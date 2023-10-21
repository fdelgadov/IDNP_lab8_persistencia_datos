package unsa.idnp.lab03.data;

import java.util.ArrayList;
import java.util.List;

import unsa.idnp.lab03.data.model.Postulante;

public class DAOPostulante {
    private static DAOPostulante instance;
    private List<Postulante> listaPostulantes = new ArrayList<>();

    // Constructor privado para evitar instanciación directa
    private DAOPostulante() {
        // Agrega algunos postulantes por defecto al DAO
        listaPostulantes.add(new Postulante("123", "Apellido1", "Apellido2", "Nombre1", "01/01/2000", "Colegio1", "Carrera1"));
        listaPostulantes.add(new Postulante("456","Apellido3", "Apellido4", "Nombre2", "02/02/2000", "Colegio2", "Carrera2"));
    }

    // Método para obtener la instancia única del DAO (Singleton)
    public static DAOPostulante getInstance() {
        if (instance == null) {
            instance = new DAOPostulante();
        }
        return instance;
    }

    // Método para registrar un nuevo postulante
    public void registrarPostulante(Postulante postulante) {
        listaPostulantes.add(postulante);
    }

    // Método para obtener todos los postulantes registrados
    public List<Postulante> listarPostulantes() {
        return listaPostulantes;
    }

    // Método para buscar un postulante por nombre
    public Postulante buscarPostulantePorNombre(String nombre) {
        for (Postulante postulante : listaPostulantes) {
            if (postulante.getNombres().equals(nombre)) {
                return postulante;
            }
        }
        return null; // Retorna null si no se encuentra el postulante
    }
}