/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
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

//eleminar fabricante
  public void eliminarFabricante(String nombre) throws Exception {

        try {

            String sql = "DELETE FROM Fabricante WHERE nombre = '" + nombre + "';";

            instarModificarEliminar(sql);

        } catch (Exception e) {

            throw e;

        }

    }
  
  public Collection<Fabricante> listarFabricante() throws Exception {

        try {

            String sql = "SELECT * FROM Fabricante";

            consultarBase(sql);

            Fabricante fab = null;
            Collection<Fabricante> listFab = new ArrayList();

            while (resultado.next()) {
                fab = new Fabricante();
                fab.setCodigo(resultado.getInt("codigo"));
                fab.setNombre(resultado.getString("nombre"));

                listFab.add(fab);

            }
            desconectarBase();
            return listFab;

        } catch (Exception e) {
            desconectarBase();
            throw new Exception("ERROR DE SISTEMA");
        }

    }
    
    /*
        PARA DEVOLVER SOLO UN REGISTRO DE LA TABLA FABRICANTE
     */
    public Fabricante buscarFabricante(String nombre) throws Exception{
        try {
            String sql = "SELECT * FROM Fabricante WHERE nombre = '" + nombre + "';";
            consultarBase(sql);
            
            Fabricante fab = null;
            
            while (resultado.next()) {
                fab = new Fabricante();
                fab.setCodigo(resultado.getInt(1));
                fab.setNombre(resultado.getString(2));
            }
            
            desconectarBase();
            return fab;
            
        } catch (Exception e) {
            desconectarBase();
            throw e;
            
        }
    }
    
    public Fabricante buscarFabricanteID(int id) throws Exception{
        try {
            String sql = "SELECT * FROM Fabricante WHERE codigo = " + id + ";";
            consultarBase(sql);
            
            Fabricante fab = null;
            
            while (resultado.next()) {
                fab = new Fabricante();
                fab.setCodigo(resultado.getInt(1));
                fab.setNombre(resultado.getString(2));
            }
            
            desconectarBase();
            return fab;
            
        } catch (Exception e) {
            desconectarBase();
            throw e;
            
        }
    }
  

}