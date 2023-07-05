/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.persistencia;

import tienda.entidades.Fabricante;
import tienda.entidades.Producto;

/**
 *
 * @author monte
 */
public final  class FabricanteDAO extends DAO{
    
    public  void nuevoFabricante(Fabricante fabricante) throws Exception{
        try {
            if (fabricante == null) {
                throw  new Exception("Debe de ingresar un fabricante");
            }
            
              String sql = "INSERT INTO fabricante (codigo,nombre) VALUES (' "+ fabricante.getCodigo()+ " ', '" + fabricante.getNombre()+ "')";
         //  String sql = "INSERT INTO fabricante (codigo, nombre) VALUES ('" + fabricante.getCodigo() + "', '" + fabricante.getNombre() + "')";
              instarModificarEliminar(sql);
            
            
            
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
    }




}