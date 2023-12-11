package unsa.idnp.lab03;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import unsa.idnp.lab03.adapter.PostulanteAdapter;
import unsa.idnp.lab03.data.DAOPostulante;
import unsa.idnp.lab03.data.model.Postulante;

public class ListActivity extends AppCompatActivity {
    private List<Postulante> lista;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lista = DAOPostulante.getInstance().getList(getApplicationContext());
        RecyclerView rv = findViewById(R.id.rv_list_principal);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new PostulanteAdapter(lista));
    }
}
