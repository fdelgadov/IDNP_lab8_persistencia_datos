package unsa.idnp.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import unsa.idnp.lab03.data.DAOPostulante;
import unsa.idnp.lab03.data.model.Postulante;

public class SearchActivity extends AppCompatActivity {
    private EditText editTextDniBuscar, editTextDni, editTextApellidoPaterno, editTextApellidoMaterno, editTextNombres, editTextFechaNacimiento, editTextColegio, editTextCarrera;
    private DAOPostulante daoPostulante = DAOPostulante.getInstance();
    private  String TAG = "SearchActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        editTextDni = findViewById(R.id.editTextDni);
        editTextApellidoPaterno = findViewById(R.id.editTextApellidoPaterno);
        editTextApellidoMaterno = findViewById(R.id.editTextApellidoMaterno);
        editTextNombres = findViewById(R.id.editTextNombres);
        editTextFechaNacimiento = findViewById(R.id.editTextFechadeNacimiento);
        editTextColegio = findViewById(R.id.editTextColegio);
        editTextCarrera = findViewById(R.id.editTextCerrera);

        editTextDniBuscar = findViewById(R.id.dniBuscar);
    }

    public void buscarPostulante(View view){
        limpiarDatos();
        String dni = editTextDniBuscar.getText().toString();
        Postulante postulanteEncontrado = daoPostulante.buscarPostulantePorDNI(getApplicationContext(), dni);

        if(postulanteEncontrado == null){
            Log.d(TAG, "Postulanete No encontrado");
            Toast.makeText(getApplicationContext(), "Postulante No Encontrado", Toast.LENGTH_SHORT).show();
        }else{
            Log.d(TAG, "Postulanete encontrado");
            Log.d(TAG, postulanteEncontrado.toString());
            editTextDni.setText(postulanteEncontrado.getDNI());
            editTextApellidoPaterno.setText(postulanteEncontrado.getApellidoPaterno());
            editTextApellidoMaterno.setText(postulanteEncontrado.getApellidoMaterno());
            editTextNombres.setText(postulanteEncontrado.getNombres());
            editTextFechaNacimiento.setText(postulanteEncontrado.getFechaNacimiento());
            editTextColegio.setText(postulanteEncontrado.getColegioProcedencia());
            editTextCarrera.setText(postulanteEncontrado.getCarrera());
        }

    }

    private void limpiarDatos(){
        editTextDni.setText("");
        editTextApellidoPaterno.setText("");
        editTextApellidoMaterno.setText("");
        editTextNombres.setText("");
        editTextFechaNacimiento.setText("");
        editTextColegio.setText("");
        editTextCarrera.setText("");

    }
    public void atras(View view){
        finish();
    }
}