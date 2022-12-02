package com.example.avance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer ID;
    private String CodigoProveedor;

    @Column(name="Nombre_Proveedor")
    private String NombreProveedor;

    @Column(name="Categoria_Proveedor")
    private String CategoriaProveedor;

    private String NIT;

    private String NRC;

    private String Direccion;

    private String Telefono;

    private int Calificacion;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        ID = iD;
    }

    public String getCodigoProveedor() {
        return CodigoProveedor;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        CodigoProveedor = codigoProveedor;
    }

    public String getNombreProveedor() {
        return NombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        NombreProveedor = nombreProveedor;
    }

    public String getCategoriaProveedor() {
        return CategoriaProveedor;
    }

    public void setCategoriaProveedor(String categoriaProveedor) {
        CategoriaProveedor = categoriaProveedor;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String nIT) {
        NIT = nIT;
    }

    public String getNRC() {
        return NRC;
    }

    public void setNRC(String nRC) {
        NRC = nRC;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public int getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(int calificacion) {
        Calificacion = calificacion;
    }

    
}
