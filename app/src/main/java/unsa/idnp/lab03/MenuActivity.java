package unsa.idnp.lab03;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import unsa.idnp.lab03.data.DAOPostulante;
import unsa.idnp.lab03.data.model.Postulante;

public class MenuActivity extends AppCompatActivity {

    private String TAG = "MenuActivity";
    private ActivityResultLauncher<Intent> registroActivityResultLauncher;
    private DAOPostulante daoPostulante = DAOPostulante.getInstance();
    private TextView userNameEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        userNameEditText = (TextView) findViewById(R.id.textUserName);
        String userName = getIntent().getStringExtra("userName");
        userNameEditText.setText(userName);


        registroActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null && data.hasExtra("nuevoPostulante")) {
                            Postulante nuevoPostulante = data.getParcelableExtra("nuevoPostulante");
                            Log.d(TAG, "Nuevo postulante");
                            Log.d(TAG, nuevoPostulante.toString());
                            daoPostulante.registrarPostulante(getApplicationContext(), nuevoPostulante);
                            Toast.makeText(getApplicationContext(), "Postulante Registrado", Toast.LENGTH_SHORT).show();

                        }
                    }
                });


    }


    public void registrarPostulante(View view){

        Intent intent = new Intent(this, RegisterActivity.class);
        registroActivityResultLauncher.launch(intent);

    }

    public void buscarPostulante(View view){
        Intent internBuscar = new Intent(this, SearchActivity.class);
        startActivity(internBuscar);


    }
}