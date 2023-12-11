package unsa.idnp.lab03.adapter;

import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import unsa.idnp.lab03.R;
import unsa.idnp.lab03.data.model.Postulante;

public class PostulanteViewHolder extends RecyclerView.ViewHolder {
    TextView txtDni;
    TextView txtApellidoP;
    TextView txtApellidoM;
    TextView txtNombres;
    TextView txtFecha;
    TextView txtColegio;
    TextView txtCarrera;
    public PostulanteViewHolder(@NonNull View itemView) {
        super(itemView);

        txtDni = (TextView) itemView.findViewById(R.id.txt_row_dni);
        txtApellidoP = (TextView) itemView.findViewById(R.id.txt_row_apellidoP);
        txtApellidoM = (TextView) itemView.findViewById(R.id.txt_row_apellidoM);
        txtNombres = (TextView) itemView.findViewById(R.id.txt_row_nombres);
        txtFecha = (TextView) itemView.findViewById(R.id.txt_row_fecha);
        txtColegio = (TextView) itemView.findViewById(R.id.txt_row_colegio);
        txtCarrera = (TextView) itemView.findViewById(R.id.txt_row_carrera);
    }

    public void setContent(Postulante p){
        txtDni.setText(p.getDNI());
        txtApellidoP.setText(p.getApellidoPaterno());
        txtApellidoM.setText(p.getApellidoMaterno());
        txtNombres.setText(p.getNombres());
        txtFecha.setText(p.getFechaNacimiento());
        txtColegio.setText(p.getColegioProcedencia());
        txtCarrera.setText(p.getCarrera());
    }
}
