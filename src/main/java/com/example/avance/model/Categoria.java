package com.example.avance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Integer ID;
    private String id_Categoria;
    private String Categorias;
   
   
    public Integer getID() {
        return ID;
    }
    public void setID(Integer iD) {
        ID = iD;
    }
    public String getId_Categoria() {
        return id_Categoria;
    }
    public void setId_Categoria(String id_Categoria) {
        this.id_Categoria = id_Categoria;
    }
    public String getCategorias() {
        return Categorias;
    }
    public void setCategorias(String categorias) {
        Categorias = categorias;
    }
    
    
    
    
}
