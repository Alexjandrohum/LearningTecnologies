package com.grupopakar.grupopakarapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.activity.Tarea;
import com.grupopakar.grupopakarapp.dto.ActividadDTO;
import com.grupopakar.grupopakarapp.dto.TareaDTO;

import java.util.List;

/**
 * Created by antonio.ruiz on 2019-05-13
 */
public class TareaAdapter extends RecyclerView.Adapter {
    private List<ActividadDTO> elementos;
    private final Context context;

    public TareaAdapter(Context context, List<ActividadDTO> elementos) {
        this.elementos = elementos;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_checklist, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((Holder) holder).bind(elementos.get(position));
    }

    @Override
    public int getItemCount() {
        return elementos.size();
    }

    public void setItems(List<ActividadDTO> elementos) {
        this.elementos = elementos;
        notifyDataSetChanged();
    }

    private class Holder extends RecyclerView.ViewHolder {
        private final TextView tvGrupoNombre;
        private final RecyclerView rv;
        private TareaElementoAdapter adapter;


        Holder(@NonNull View itemView) {
            super(itemView);
            tvGrupoNombre = itemView.findViewById(R.id.tvGrupoNombre);
            rv = itemView.findViewById(R.id.rv);
        }

        void bind(ActividadDTO elemento) {
            tvGrupoNombre.setText(elemento.getGrupoTarea());
            adapter = new TareaElementoAdapter(elemento.getListaTarea());
            rv.setAdapter(adapter);
        }
    }

    private class TareaElementoAdapter extends RecyclerView.Adapter {
        private List<TareaDTO> elementos;

        TareaElementoAdapter(List<TareaDTO> elementos) {
            this.elementos = elementos;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ElementoHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_checklist_valor, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ((ElementoHolder) holder).bind(elementos.get(position));
        }

        @Override
        public int getItemCount() {
            return elementos.size();
        }

        private class ElementoHolder extends RecyclerView.ViewHolder implements CompoundButton.OnCheckedChangeListener {
            private final CheckBox checkBox;

            ElementoHolder(@NonNull View itemView) {
                super(itemView);
                checkBox = itemView.findViewById(R.id.checkbox);
            }

            void bind(TareaDTO elemento) {
                checkBox.setText(elemento.getNombreTarea());
                checkBox.setChecked(elemento.isEstatusTarea());
                checkBox.setOnCheckedChangeListener(this);
            }

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                TareaDTO elemento = elementos.get(getAdapterPosition());
                if (buttonView.isPressed()) {
                    ((Tarea) context).actualizaEstatus(elemento.getIdTarea(), isChecked);
                }
            }

        }
    }
}
