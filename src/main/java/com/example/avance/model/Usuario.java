package com.example.avanceunidad3.model;

import javax.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String Nombres;
    private String Apellidos;
    private String Correo;
    private String Contrasena;
    private String Tipo_Usuario;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }

    public String getTipo_Usuario() {
        return Tipo_Usuario;
    }

    public void setTipo_Usuario(String tipo_Usuario) {
        Tipo_Usuario = tipo_Usuario;
    }
}
