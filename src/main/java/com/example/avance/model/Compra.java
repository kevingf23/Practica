package com.example.avanceunidad3.model;

import javax.persistence.*;

@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    private Integer Producto_ID;

    private String Lote;

    private double Precio;

    private Integer Cantidad;

    private String Fecha_Compra;

    private String Fecha_vencimiento_Lote;

    private String Encargado;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getProducto_ID() {
        return Producto_ID;
    }

    public void setProducto_ID(Integer producto_ID) {
        Producto_ID = producto_ID;
    }

    public String getLote() {
        return Lote;
    }

    public void setLote(String lote) {
        Lote = lote;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer cantidad) {
        Cantidad = cantidad;
    }

    public String getFecha_Compra() {
        return Fecha_Compra;
    }

    public void setFecha_Compra(String fecha_Compra) {
        Fecha_Compra = fecha_Compra;
    }

    public String getFecha_vencimiento_Lote() {
        return Fecha_vencimiento_Lote;
    }

    public void setFecha_vencimiento_Lote(String fecha_vencimiento_Lote) {
        Fecha_vencimiento_Lote = fecha_vencimiento_Lote;
    }

    public String getEncargado() {
        return Encargado;
    }

    public void setEncargado(String encargado) {
        Encargado = encargado;
    }
}
