package unsa.idnp.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private TextView userNameEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        userNameEditText = (TextView) findViewById(R.id.textUserName);
        String userName = getIntent().getStringExtra("userName");
        userNameEditText.setText(userName);

    }
}