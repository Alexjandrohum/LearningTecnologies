package com.grupopakar.grupopakarapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.activity.Comentarios;
import com.grupopakar.grupopakarapp.activity.Modulos;
import com.grupopakar.grupopakarapp.activity.Plantilla;
import com.grupopakar.grupopakarapp.activity.Tarea;
import com.grupopakar.grupopakarapp.activity.Tienda;
import com.grupopakar.grupopakarapp.dto.ModuloDTO;

import java.util.List;

/**
 * Created by antonio.ruiz on 2019-05-06
 */
public class ModulosAdapter extends RecyclerView.Adapter {
    private List<ModuloDTO> modulos;
    private Context context;

    public ModulosAdapter(Context context, List<ModuloDTO> modulos) {
        this.modulos = modulos;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ModuloHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_modulo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ModuloHolder) holder).bind(modulos.get(position));
    }

    @Override
    public int getItemCount() {
        return modulos.size();
    }

    public void setItems(List<ModuloDTO> modulos) {
        this.modulos = modulos;
        notifyDataSetChanged();
    }

    private class ModuloHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView tvNombre;
        private final CardView cv;
        private final ImageView ivIcono;

        ModuloHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            cv = itemView.findViewById(R.id.cv);
            ivIcono = itemView.findViewById(R.id.ivIcono);
            cv.setOnClickListener(this);
        }

        void bind(ModuloDTO modulo) {
            tvNombre.setText(modulo.getNombreModulo().toUpperCase());
            if (modulo.getIcono()!=null && !modulo.getIcono().isEmpty())
                ivIcono.setImageResource(context.getResources().getIdentifier(modulo.getIcono(), "drawable", context.getPackageName()));
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.cv) {
                Intent intent;
                switch (modulos.get(getAdapterPosition()).getIdModulo()) {
                    case 1:
                        intent = new Intent(context, Tienda.class);
                        intent.putExtra("tienda", ((Modulos) context).getTienda());
                        context.startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(context, Comentarios.class);
                        intent.putExtra("tienda", ((Modulos) context).getTienda());
                        context.startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(context, Tarea.class);
                        intent.putExtra("tienda", ((Modulos) context).getTienda());
                        context.startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(context, Plantilla.class);
                        intent.putExtra("tienda", ((Modulos) context).getTienda());
                        context.startActivity(intent);
                        break;
                }
            }
        }
    }
}
