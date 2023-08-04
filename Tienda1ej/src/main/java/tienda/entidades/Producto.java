/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.entidades;

import java.util.Collection;

/**
 *
 * @author monte
 */
public class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    //private int codigo_fabricante;
    private Fabricante codigo_fabricante;
    
    public Producto() {
    }

    public Producto(int codigo, String nombre, double precio,Fabricante codigo_fabricante) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.codigo_fabricante = codigo_fabricante;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Fabricante getCodigo_fabricante() {
        return codigo_fabricante;
    }

    public void setCodigo_fabricante(Fabricante codigo_fabricante) {
        this.codigo_fabricante = codigo_fabricante;
    }

    public void add(Collection<Producto> productos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   



   

    

   
    
}
