package com.tecsup.labs;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio para registrar usuarios con mejores prácticas.
 */
public class UserRegistrationService {

    // Campo privado con getter para evitar acceso directo
    private String lastErrorMessage = "";

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }

    // Lista con uso de genéricos
    private final List<String> users = new ArrayList<>();

    // Se evita lógica innecesaria en el constructor
    public UserRegistrationService() {
        System.out.println("Constructor llamado");
    }

    /**
     * Registra un nuevo usuario.
     *
     * @param username nombre de usuario
     * @param password contraseña
     * @param email    correo electrónico
     * @return true si se registró correctamente
     */
    public boolean registerUser(String username, String password, String email) {

        if (username == null || username.trim().isEmpty()) {
            lastErrorMessage = "El nombre de usuario está vacío.";
            return false;
        }

        if (password == null) {
            lastErrorMessage = "La contraseña es null.";
            return false;
        }

        if (password.length() < 8) {
            lastErrorMessage = "La contraseña es muy corta.";
            return false;
        }

        if (!email.contains("@") || !email.contains(".")) {
            lastErrorMessage = "El correo electrónico no parece válido.";
            return false;
        }

        if (users.contains(username)) {
            lastErrorMessage = "El usuario ya existe.";
            return false;
        }

        try {
            saveUser(username, password, email);
        } catch (Exception e) {
            lastErrorMessage = "Error al guardar el usuario.";
            return false;
        }

        return true;
    }

    private void saveUser(String username, String password, String email) throws Exception {

        if ("error".equals(username)) {
            throw new Exception("Nombre de usuario no permitido.");
        }

        users.add(username);
    }

    /**
     * Devuelve la longitud de un string validando null correctamente.
     */
    public int contarCaracteres(String texto) {
        if (texto == null) {
            return -1;
        }

        return texto.length();
    }
}
