package unsa.idnp.lab03.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import unsa.idnp.lab03.R;
import unsa.idnp.lab03.data.model.Postulante;

public class PostulanteAdapter extends RecyclerView.Adapter<PostulanteViewHolder> {
    private List<Postulante> postulantes;

    public PostulanteAdapter(List<Postulante> lista){
        postulantes = lista;
    }

    @NonNull
    @Override
    public PostulanteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_postulante, parent, false);
        return new PostulanteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostulanteViewHolder holder, int position) {
        Postulante p = postulantes.get(position);
        holder.setContent(p);
    }

    @Override
    public int getItemCount() {
        return postulantes.size();
    }
}
