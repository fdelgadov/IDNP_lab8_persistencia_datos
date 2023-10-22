package unsa.idnp.lab03;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import unsa.idnp.lab03.data.model.Postulante;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextDni, editTextApellidoPaterno, editTextApellidoMaterno, editTextNombres, editTextFechaNacimiento, editTextColegio, editTextCarrera;
    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextDni = findViewById(R.id.editTextDni);
        editTextApellidoPaterno = findViewById(R.id.editTextApellidoPaterno);
        editTextApellidoMaterno = findViewById(R.id.editTextApellidoMaterno);
        editTextNombres = findViewById(R.id.editTextNombres);
        editTextFechaNacimiento = findViewById(R.id.editTextFechadeNacimiento);
        editTextColegio = findViewById(R.id.editTextColegio);
        editTextCarrera = findViewById(R.id.editTextCerrera);


        Button buttonEnviar = findViewById(R.id.buttonEnviar);


        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null && data.hasExtra("postulante")) {
                            Postulante postulante = data.getParcelableExtra("postulante");
                            // Hacer algo con el objeto Postulante
                        }
                    }
                });

    }

    public void completeRegister(View view){
        String dni = editTextDni.getText().toString();
        String apellidoPaterno = editTextApellidoPaterno.getText().toString();
        String apellidoMaterno = editTextApellidoMaterno.getText().toString();
        String nombres = editTextNombres.getText().toString();
        String fechaNacimiento = editTextFechaNacimiento.getText().toString();
        String colegio = editTextColegio.getText().toString();
        String carrera = editTextCarrera.getText().toString();

        // Crea un objeto Postulante con los datos
        Postulante postulante = new Postulante(dni, apellidoPaterno, apellidoMaterno, nombres, fechaNacimiento, colegio, carrera);

        // Después de completar el registro del postulante
        Intent intent = new Intent();
        intent.putExtra("nuevoPostulante", postulante); // postulante es tu objeto Postulante
        setResult(RESULT_OK, intent);
        finish();
    }

    public void cancelar(View view){
        finish();
    }
}

