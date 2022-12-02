package com.example.avanceunidad3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salidas")
public class Salida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name="Producto_ID")
    private Integer ProductoID;

    private String Lote;

    private double precio;

    private Integer cantidad;

    private String Fecha_Salida;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer iD) {
        ID = iD;
    }

    public Integer getProductoID() {
        return ProductoID;
    }

    public void setProductoID(Integer productoID) {
        ProductoID = productoID;
    }

    public String getLote() {
        return Lote;
    }

    public void setLote(String lote) {
        Lote = lote;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha_Salida() {
        return Fecha_Salida;
    }

    public void setFecha_Salida(String fecha_Salida) {
        Fecha_Salida = fecha_Salida;
    }

    
}
