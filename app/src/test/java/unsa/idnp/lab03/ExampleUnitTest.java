package unsa.idnp.lab03;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

import unsa.idnp.lab03.data.DAOPostulante;
import unsa.idnp.lab03.data.model.Postulante;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private DAOPostulante dao;

    @Before
    public void setUp() {
        dao = DAOPostulante.getInstance(); // Obtener la instancia del DAO
    }

    @Test
    public void testRegistrarPostulante() {
        Postulante newPostulante = new Postulante("789", "ApellidoNuevo", "ApellidoNuevo", "NuevoNombre", "03/03/2000", "NuevoColegio", "NuevaCarrera");
        dao.registrarPostulante(newPostulante);

        List<Postulante> postulantes = dao.listarPostulantes();
        assertTrue(postulantes.contains(newPostulante));
    }

    @Test
    public void testListarPostulantes() {
        List<Postulante> postulantes = dao.listarPostulantes();
        assertNotNull(postulantes);
    }

    @Test
    public void testBuscarPostulantePorDNI() {
        Postulante postulante = dao.buscarPostulantePorDNI("123");
        assertNotNull(postulante);
        assertEquals("123", postulante.getDNI());
    }

    @Test
    public void testBuscarPostulantePorDNINoExistente() {
        Postulante postulante = dao.buscarPostulantePorDNI("999");
        assertNull(postulante);
    }
}