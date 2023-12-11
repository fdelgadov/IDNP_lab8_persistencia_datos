package unsa.idnp.lab03.data;

import android.content.Context;

import java.io.*;
import java.util.ArrayList;

import unsa.idnp.lab03.data.model.Postulante;

public class DAOPostulante {
    private static DAOPostulante instance;
    private static ArrayList<Postulante> lista;

    // Constructor privado para evitar instanciación directa
    private DAOPostulante() {
    }

    // Método para obtener la instancia única del DAO (Singleton)
    public static DAOPostulante getInstance() {
        if (instance == null) {
            instance = new DAOPostulante();
        }
        return instance;
    }

    // Método para registrar un nuevo postulante
    public void registrarPostulante(Context context, Postulante postulante) {
        String filename = postulante.getDNI();
        try {
            FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(postulante);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        lista.add(postulante);
    }

    // Método para buscar un postulante por nombre
    public Postulante buscarPostulantePorDNI(Context context, String dni) {
        Postulante res = null;
        try{
            FileInputStream fis = context.openFileInput(dni);
            ObjectInputStream ois = new ObjectInputStream(fis);
            res = (Postulante) ois.readObject();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return res;
    }

    public ArrayList<Postulante> getList(Context context){
        lista = new ArrayList<>();
        File dir = context.getFilesDir();
        File[] files = dir.listFiles();

        for(File f: files){
            try{
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                lista.add((Postulante) ois.readObject());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return lista;
    }
}