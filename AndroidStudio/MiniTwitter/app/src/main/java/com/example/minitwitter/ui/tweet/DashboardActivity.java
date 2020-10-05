package com.example.minitwitter.ui.tweet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.minitwitter.R;
import com.example.minitwitter.common.Constantes;
import com.example.minitwitter.common.SharedPreferencesManager;
import com.example.minitwitter.data.ProfileViewModel;
import com.example.minitwitter.retrofit.response.ResponseUserProfile;
import com.example.minitwitter.ui.perfil.ProfileFragment;
import com.example.minitwitter.ui.tweet.NuevoTweetDialogFragment;
import com.example.minitwitter.ui.tweet.TweetListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class DashboardActivity extends AppCompatActivity implements PermissionListener {

    FloatingActionButton fab;
    ImageView imageViewAvatar;
    ProfileViewModel profileViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        profileViewModel = ViewModelProviders.of(this).get(ProfileViewModel.class);

        fab = findViewById(R.id.fab);

        imageViewAvatar = findViewById(R.id.imageViewToolbarPhoto);

        getSupportActionBar().hide();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_twet_like, R.id.navigation_profile)
                .build();


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


        NavigationUI.setupWithNavController(navView, navController);


        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contenedor, TweetListFragment.newInstance(Constantes.TWEET_LIST_ALL))
                .commit();


        //With it Method can us implement the actions of the Button Navigation

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {


                Fragment f = null;

                switch (destination.getId()) {
                    case R.id.navigation_home:
                        f = TweetListFragment.newInstance(Constantes.TWEET_LIST_ALL);
                        fab.show();
                        ;
                        break;
                    case R.id.navigation_twet_like:
                        f = TweetListFragment.newInstance(Constantes.TWEET_LIST_FAVS);
                        fab.hide();
                        break;
                    case R.id.navigation_profile:
                        f = new ProfileFragment();
                        fab.hide();
                }

                if (f != null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.contenedor, f)
                            .commit();

                }


            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NuevoTweetDialogFragment dialog = new NuevoTweetDialogFragment();
                dialog.show(getSupportFragmentManager(), "Nuevo tweet");
            }
        });


        //seteamos la imagen del usuario del perfil
        String photoUrl = SharedPreferencesManager.getSomeStringValue(Constantes.PREF_PHOTOURL);

        if (!photoUrl.isEmpty()) {

            Glide.with(this)
                    .load(Constantes.API_MINITWITTER_FILES_URL + photoUrl)
                    .dontAnimate()
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .centerCrop()
                    .skipMemoryCache(true)
                    .into(imageViewAvatar);
        }


        profileViewModel.photoProfile.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String photo) {

                Glide.with(DashboardActivity.this)
                        .load(Constantes.API_MINITWITTER_FILES_URL + photo)
                        .dontAnimate()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .centerCrop()
                        .skipMemoryCache(true)
                        .into(imageViewAvatar);


            }
        });

    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (resultCode != RESULT_CANCELED) {
            if (requestCode == Constantes.SELECT_PHOTO_GALLERY) {
                if (data != null) {
                    Uri imagenSeleccionada = data.getData();
                    String[] filePathColum = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(imagenSeleccionada,
                            filePathColum, null, null, null);

                    if (cursor != null) {
                        cursor.moveToFirst();
                        int imagenIndex = cursor.getColumnIndex(filePathColum[0]);
                        String photoPath = cursor.getString(imagenIndex);
                        profileViewModel.uploadProfile(photoPath);
                        cursor.close();
                    }

                }
            }
        }
    }

    @Override
    public void onPermissionGranted(PermissionGrantedResponse response) {

        // Invocamos la selección de fotos de la galería

        Intent seleccionarFoto = new  Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(seleccionarFoto, Constantes.SELECT_PHOTO_GALLERY);
    }

    @Override
    public void onPermissionDenied(PermissionDeniedResponse response) {

        Toast.makeText(this, "No se puede seleccionar la fotografía", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

    }
}
