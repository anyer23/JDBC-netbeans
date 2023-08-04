/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.servicios;

import java.util.Collection;
import java.util.Scanner;
import tienda.entidades.Fabricante;

import tienda.persistencia.FabricanteDAO;


/**
 *
 * @author monte
 */
public class FabricantesService {
    
    Scanner leer =new  Scanner(System.in);
  // FabricanteDAO faDAO=new FabricanteDAO();
    
    
    private FabricanteDAO faDAO;
    Fabricante Fabricante;
   

    public FabricantesService() {
        Fabricante = new Fabricante(); // Agrega esta línea para inicializar el objeto producto
        faDAO = new FabricanteDAO();
    }
    
     public void crearFabricante() throws Exception {
        do {

           try {
            
            System.out.println("\n Ingrese el nombre del fabricante");
            Fabricante.setNombre(leer.nextLine());
            
            if (Fabricante.getNombre()== null || Fabricante.getNombre().isEmpty()) {
                System.out.println("Debe de ingresar un nombre");
            }
            faDAO.nuevoFabricante(Fabricante);
        } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
        } 
            
        } while (Fabricante.getNombre() == null || Fabricante.getNombre().isEmpty() );
    }
     
     public Fabricante seleccionarFabricante(int id) throws Exception{
         try {
               if (id == 0) {
                throw new Exception("DEBE DE INDICAR EL ID");
            }
            
               Fabricante fab=faDAO.buscarFabricanteID(id);
              return  fab;
         } catch (Exception e) {
             throw e;
         }
     }
     
     
     public void mostrarFabricante() throws Exception{
         Collection<Fabricante> fabricantes=faDAO.listarFabricante();
        
         
         
     }
     
}
