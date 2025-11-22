package com.tecsup.labs;

public class Main {

    public static void main(String[] args) {

        UserRegistrationService service = new UserRegistrationService();

        service.registerUser("juan", "12345678", "juan@correo.com");
        System.out.println(service.getLastErrorMessage());

        service.registerUser("pedro", "87654321", "pedro@correo.com");
        System.out.println(service.getLastErrorMessage());
    }
}
