package unsa.idnp.lab03;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import unsa.idnp.lab03.data.Result;
import unsa.idnp.lab03.data.UserDAO;
import unsa.idnp.lab03.data.model.User;

public class LoginAcivity extends AppCompatActivity {
    private final static String TAG = "LoginActivity";
    private EditText usernameEditText, passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserDAO userDAO = UserDAO.getInstance();
        Button btnLogin = findViewById(R.id.login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                usernameEditText = findViewById(R.id.username);
                passwordEditText = findViewById(R.id.password);
                Log.d(TAG, usernameEditText.getText().toString());
                Log.d(TAG, passwordEditText.getText().toString());

                Result<User> result =  userDAO.login(usernameEditText.getText().toString(), passwordEditText.getText().toString());

                if (result instanceof Result.Success) {
                    Log.i(TAG, "Usuario Logeado");
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    intent.putExtra("userName", usernameEditText.getText().toString());
                    startActivity(intent);
                }
                else{
                    Log.i(TAG, "No reconocido");

                }
            }
        });
    }
}