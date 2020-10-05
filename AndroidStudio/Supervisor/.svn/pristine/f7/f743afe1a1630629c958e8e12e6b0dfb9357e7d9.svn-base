package com.grupopakar.grupopakarapp.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.activity.Tienda;
import com.grupopakar.grupopakarapp.dto.GpoInfoTiendaDTO;
import com.grupopakar.grupopakarapp.dto.InfoTiendaDTO;
import com.grupopakar.grupopakarapp.util.Mensaje;

import java.util.List;

/**
 * Created by antonio.ruiz on 2019-05-06
 */
public class InfoTiendaAdapter extends RecyclerView.Adapter {
    private List<GpoInfoTiendaDTO> elementos;
    private Context context;

    public InfoTiendaAdapter(Context context, List<GpoInfoTiendaDTO> elementos) {
        this.elementos = elementos;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_grupo_tienda, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((Holder) holder).bind(elementos.get(position));
    }

    @Override
    public int getItemCount() {
        return elementos.size();
    }

    public void setItems(List<GpoInfoTiendaDTO> elementos) {
        this.elementos = elementos;
        notifyDataSetChanged();
    }

    private class Holder extends RecyclerView.ViewHolder {
        private final TextView tvGrupoNombre;
        private final RecyclerView rv;
        private InfoElementoTiendaAdapter adapter;


        Holder(@NonNull View itemView) {
            super(itemView);
            tvGrupoNombre = itemView.findViewById(R.id.tvGrupoNombre);
            rv = itemView.findViewById(R.id.rv);
        }

        void bind(GpoInfoTiendaDTO elemento) {
            tvGrupoNombre.setText(elemento.getNombreGrupoInfoTienda());
            adapter = new InfoElementoTiendaAdapter(elemento.getListaConceptos());
            rv.setAdapter(adapter);
        }
    }

    private class InfoElementoTiendaAdapter extends RecyclerView.Adapter {
        private final List<InfoTiendaDTO> elementos;

        InfoElementoTiendaAdapter(List<InfoTiendaDTO> elementos) {
            this.elementos = elementos;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ElementoHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_info_tienda, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ((ElementoHolder) holder).bind(elementos.get(position));
        }

        @Override
        public int getItemCount() {
            return elementos.size();
        }

        private class ElementoHolder extends RecyclerView.ViewHolder implements TextView.OnEditorActionListener {
            private final TextView tvNombre;
            private final TextInputEditText etValor;

            ElementoHolder(@NonNull View itemView) {
                super(itemView);
                tvNombre = itemView.findViewById(R.id.tvNombre);
                etValor = itemView.findViewById(R.id.etValor);
            }

            void bind(InfoTiendaDTO elemento) {
                tvNombre.setText(elemento.getNombreConcepto());
                etValor.setText(elemento.getValorConcepto());
                etValor.setOnEditorActionListener(this);
                etValor.setEnabled(elemento.isEditable());
                if (!elemento.isEditable()) {
                    etValor.setBackground(null);
                }
            }

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InfoTiendaDTO elemento = elementos.get(getAdapterPosition());
                    if (!TextUtils.isEmpty(v.getText()) && !v.getText().toString().equals(elemento.getValorConcepto())) {
                        ((Tienda) context).actualizaTienda(elemento.getIdInformacionTienda(), v.getText().toString());
                    } else if (v.getText().toString().equals(elemento.getValorConcepto())) {
                        Mensaje.muestraMensajeCorto(context, context.getString(R.string.error_campo_identico));
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
        }
    }
}
