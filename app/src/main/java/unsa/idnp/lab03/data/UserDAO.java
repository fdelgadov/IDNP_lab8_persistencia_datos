package unsa.idnp.lab03.data;

import unsa.idnp.lab03.data.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static UserDAO instance; // Instancia única de UserDAO
    private List<User> users;

    private UserDAO() {
        users = new ArrayList<>();
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    // Agregar un usuario a la lista en memoria
    public void addUser(User user) {
        users.add(user);
    }

    // TEST
    private void addUserTest(){
        addUser(new User("user1", "user1"));
        addUser(new User("admin", "admin123"));

    }

    // TEST
    public Result<User> login(String username, String password) {

        addUserTest();

        for (User user : users) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                return new Result.Success<>(user); // Inicio de sesión exitoso
            }
        }
        return new Result.Error(new Exception("Inicio de sesión fallido")); // Inicio de sesión fallido
    }

    // Realizar el cierre de sesión (logout) - No se necesita nada en memoria
    public void logout() {
        // No se necesita lógica específica para el cierre de sesión en memoria
    }
}