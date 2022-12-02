package com.example.avance.model;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String Nombre_Producto;
    private Integer Categoria_ID;
    private Integer Proveedor_ID;
    private Integer Existencia_Min;
    private Integer Existencia_Max;
    private double Precio;
    private double Costo;
    private String Unidad_Medida;
    private String Ubicacion_Bodega;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNombre_Producto() {
        return Nombre_Producto;
    }

    public void setNombre_Producto(String nombre_Producto) {
        Nombre_Producto = nombre_Producto;
    }

    public Integer getCategoria_ID() {
        return Categoria_ID;
    }

    public void setCategoria_ID(Integer categoria_ID) {
        Categoria_ID = categoria_ID;
    }

    public Integer getProveedor_ID() {
        return Proveedor_ID;
    }

    public void setProveedor_ID(Integer proveedor_ID) {
        Proveedor_ID = proveedor_ID;
    }

    public Integer getExistencia_Min() {
        return Existencia_Min;
    }

    public void setExistencia_Min(Integer existencia_Min) {
        Existencia_Min = existencia_Min;
    }

    public Integer getExistencia_Max() {
        return Existencia_Max;
    }

    public void setExistencia_Max(Integer existencia_Max) {
        Existencia_Max = existencia_Max;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public double getCosto() {
        return Costo;
    }

    public void setCosto(double costo) {
        Costo = costo;
    }

    public String getUnidad_Medida() {
        return Unidad_Medida;
    }

    public void setUnidad_Medida(String unidad_Medida) {
        Unidad_Medida = unidad_Medida;
    }

    public String getUbicacion_Bodega() {
        return Ubicacion_Bodega;
    }

    public void setUbicacion_Bodega(String ubicacion_Bodega) {
        Ubicacion_Bodega = ubicacion_Bodega;
    }
}
