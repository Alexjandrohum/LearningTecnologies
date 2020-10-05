package com.example.minitwitter.ui.perfil;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.Manifest;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.minitwitter.R;
import com.example.minitwitter.common.Constantes;
import com.example.minitwitter.data.ProfileViewModel;
import com.example.minitwitter.retrofit.request.RequestUserProfile;
import com.example.minitwitter.retrofit.response.ResponseUserProfile;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.listener.single.CompositePermissionListener;
import com.karumi.dexter.listener.single.DialogOnDeniedPermissionListener;
import com.karumi.dexter.listener.single.PermissionListener;

public class ProfileFragment extends Fragment {

    ImageView ivProfile;
    EditText etUsername, etEmail, etPassword, etWebSite, etDescription;
    Button btnGuardar, buttonChangePassword;

    private boolean loadingData = true;
    private ProfileViewModel profileViewModel;
    PermissionListener allPermissionListener;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profileViewModel = ViewModelProviders.of(getActivity()).get(ProfileViewModel.class);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.profile_fragment, container, false);


        ivProfile = v.findViewById(R.id.imageViewAvatar);
        etUsername = v.findViewById(R.id.editTextUserName);
        etEmail = v.findViewById(R.id.editTextEmail);
        etWebSite = v.findViewById(R.id.editTextWebSite);
        etDescription = v.findViewById(R.id.editTextDescripction);
        etPassword = v.findViewById(R.id.editTextPassword);
        btnGuardar = v.findViewById(R.id.buttonGuardar);

        //Eventos

        btnGuardar.setOnClickListener(view ->{
            String username = etUsername.getText().toString();
            String email = etEmail.getText().toString();
            String descripcion = etDescription.getText().toString();
            String website = etWebSite.getText().toString();
            String password = etPassword.getText().toString();


            if (username.isEmpty()){
                etUsername.setError("El nombre de usuario es requerido");
            }else if (email.isEmpty()){
                etEmail.setError("El Email es requerido");
            }else if (password.isEmpty()){
                etPassword.setError("La contraseña es requerida");
            }else {

                RequestUserProfile requestUserProfile = new RequestUserProfile(username, email, descripcion, website, password);
                profileViewModel.UpdateProfile(requestUserProfile);

                Toast.makeText(getActivity(), "Guardando la información", Toast.LENGTH_SHORT).show();
                btnGuardar.setEnabled(false);
            }

        });



        ivProfile.setOnClickListener(view ->{
            //invocar a la selección de la fotografía
            //Invocar al método de comprovación de permisos
            CheckPermissions();

        });

        //ViewModel

        profileViewModel.userProfile.observe(getActivity(), new Observer<ResponseUserProfile>() {
            @Override
            public void onChanged(ResponseUserProfile responseUserProfile) {
                loadingData = false;
                etUsername.setText(responseUserProfile.getUsername());
                etEmail.setText(responseUserProfile.getEmail());
                etWebSite.setText(responseUserProfile.getWebsite());
                etDescription.setText(responseUserProfile.getDescripcion());



                if (!responseUserProfile.getPhotoUrl().isEmpty()){
                    Glide.with(getActivity())
                            .load(Constantes.API_MINITWITTER_FILES_URL + responseUserProfile.getPhotoUrl())
                            .dontAnimate()
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .centerCrop()
                            .skipMemoryCache(true)
                            .into(ivProfile);
                }


                if (!loadingData){
                    btnGuardar.setEnabled(true);
                    //Toast.makeText(getActivity(), "Datos guardados correctamente", Toast.LENGTH_SHORT).show();
                }
            }
        });


        profileViewModel.photoProfile.observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String photo) {
                if (!photo.isEmpty()){
                    Glide.with(getActivity())
                            .load(Constantes.API_MINITWITTER_FILES_URL + photo)
                            .dontAnimate()
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .centerCrop()
                            .skipMemoryCache(true)
                            .into(ivProfile);
                }
            }
        });


        return v;
    }

    private void CheckPermissions() {
        PermissionListener dialogOnDeniedPermissionsListener =
                DialogOnDeniedPermissionListener.Builder.withContext(getActivity())
                .withTitle("Permisos")
                .withMessage("Los permisos solicitados son necesarios para poder seleccionar una foto de perfil")
                .withButtonText("Aceptar")
                .withIcon(R.mipmap.ic_launcher)
                .build();


        allPermissionListener = new CompositePermissionListener(
                (PermissionListener) getActivity(),
                dialogOnDeniedPermissionsListener
        );

        Dexter.withActivity(getActivity())
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(allPermissionListener)
                .check();
    }


}
