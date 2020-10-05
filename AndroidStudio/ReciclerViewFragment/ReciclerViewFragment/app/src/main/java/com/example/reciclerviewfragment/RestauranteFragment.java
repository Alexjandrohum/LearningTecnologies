package com.example.reciclerviewfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class RestauranteFragment extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;

    private OnListFragmentInteractionListener mListener;
    RecyclerView recyclerView;
    MyRestauranteRecyclerViewAdapter adapterRestaurantes;
    List<Restaurante> restauranteList;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestauranteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurante_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            //Lista de elementos (Restaurantes)
            restauranteList = new ArrayList<>();

            restauranteList.add(new Restaurante("Pizzería Carlos","https://www.laespanolaaceites.com/wp-content/uploads/2019/05/pizza-al-ajo-con-tomates-frescos-1080x671.jpg",4.0f,"Madrid, España."));
            restauranteList.add(new Restaurante("Tacos Tizoncito","https://culto.latercera.com/wp-content/uploads/2019/07/cro%CC%81nicas-del-taco-netflix-culto-900x600.jpg",5.0f,"Puebla, Tepeaca."));
            restauranteList.add(new Restaurante("Mole poblano","https://cocina-casera.com/mx/wp-content/uploads/2017/10/mole-rojo.jpg",2.0f,"Puebla, puebla."));
            restauranteList.add(new Restaurante("Barbacoa","https://www.cocinavital.mx/wp-content/uploads/2018/12/taco-barbacoa.jpg",4.0f,"Lázaro Cardenas, Cuapiaxtla de Madero."));
            restauranteList.add(new Restaurante("Cemitas Juan","http://www.laopinionpuebla.com/wp-content/uploads/2018/06/1124.jpg",5.0f,"5 sur noroeste, Puebla"));

            //Asociamos el adaptador al RecyclerView
            adapterRestaurantes =new MyRestauranteRecyclerViewAdapter(restauranteList, mListener);

            recyclerView.setAdapter(adapterRestaurantes);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Restaurante item);
    }
}
