package com.grupopakar.grupopakarapp.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.textfield.TextInputEditText;
import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.activity.Plantilla;
import com.grupopakar.grupopakarapp.dto.EmpleadoDTO;
import com.grupopakar.grupopakarapp.util.GlideApp;
import com.grupopakar.grupopakarapp.util.Mensaje;

import java.util.List;

/**
 * Created by antonio.ruiz on 2019-05-10
 */
public class PlantillaAdapter extends RecyclerView.Adapter {
    private List<EmpleadoDTO> elementos;
    private final Context context;

    public PlantillaAdapter(Context context, List<EmpleadoDTO> elementos) {
        this.elementos = elementos;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_plantilla_empleado, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((Holder) holder).bind(elementos.get(position));
    }

    @Override
    public int getItemCount() {
        return elementos.size();
    }

    public void setItems(List<EmpleadoDTO> elementos) {
        this.elementos = elementos;
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder implements TextView.OnEditorActionListener, CompoundButton.OnCheckedChangeListener {
        private final ImageView ivFoto;
        private final TextView tvNoControl;
        private final TextView tvNombre;
        private final TextView tvPuesto;
        private final TextView tvDescanso;
        private final CheckBox checkbox;
        private final TextInputEditText etComentario;


        Holder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.ivFoto);
            tvNoControl = itemView.findViewById(R.id.tvNoControl);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvPuesto = itemView.findViewById(R.id.tvPuesto);
            tvDescanso = itemView.findViewById(R.id.tvDescanso);
            checkbox = itemView.findViewById(R.id.checkbox);
            etComentario = itemView.findViewById(R.id.etComentario);
        }

        void bind(EmpleadoDTO elemento) {
            GlideApp.with(context)
                    .load(elemento.getRutaImagen())
                    .fitCenter()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.NORMAL)
                    .into(ivFoto);
            tvNoControl.setText(elemento.getNumeroControl());
            tvNombre.setText(elemento.getNombreEmpleado());
            tvPuesto.setText(elemento.getPuestoEmpleado());
            tvDescanso.setText(context.getString(R.string.lb_descanso, elemento.getDescanso()));
            checkbox.setChecked(elemento.isValidarPlantilla());
            checkbox.setEnabled(!elemento.isValidarPlantilla());
            checkbox.setOnCheckedChangeListener(this);
            etComentario.setEnabled(false);
            etComentario.setText(null);
            etComentario.setOnEditorActionListener(this);
            etComentario.clearFocus();
        }

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                EmpleadoDTO elemento = elementos.get(getAdapterPosition());
                if (!TextUtils.isEmpty(v.getText())) {
                    etComentario.clearFocus();
                    ((Plantilla) context).validaPlantilla(elemento.getIdEmpleado(), v.getText().toString());
                } else {
                    Mensaje.muestraMensajeCorto(context, context.getString(R.string.error_campo_vacio));
                }
                InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                return true;
            }
            return false;
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            etComentario.setEnabled(false);
            etComentario.clearFocus();
            if (isChecked && buttonView.isPressed()) {
                Mensaje.muestraMensajeCorto(context, context.getString(R.string.mensaje_captura_comentario));
                etComentario.setEnabled(true);
                etComentario.requestFocus();
                if (etComentario.isFocused()) {
                    InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
                    }
                }
            }
        }
    }
}
