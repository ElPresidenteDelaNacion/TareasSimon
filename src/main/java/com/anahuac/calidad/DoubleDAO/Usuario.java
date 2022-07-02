package com.anahuac.calidad.DoubleDAO;

public class Usuario {

    private String nombre, id, email, edad;

    public Usuario() {}

    public Usuario(String nombre, String id, String edad, String email) {
        this.nombre = nombre;
        this.id     = id;
        this.email  = email;
        this.edad   = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

}