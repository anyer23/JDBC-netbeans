/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;

/**
 *
 * @author monte
 */
public final class ProductoDAO extends DAO {

     private ProductoDAO productoDA;

    
    
    Producto producto=new Producto();
    
   

    public void ingresarProducto(Producto producto) throws Exception {
        
        
        try {
            
            if (producto == null) {
                
                throw new Exception("Debe de tener un producto");
            }
            String sql =  "INSERT INTO producto (nombre, precio, codigo_Fabricante) " +
                     "VALUES ('" + producto.getNombre() + "', " + producto.getPrecio() +
                     ", " + producto.getCodigo_fabricante() + ")";
            
            
            instarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
        
        
    }

    public void modificarProducto(Producto producto) throws Exception {

        try {
            if (producto == null) {
                throw new Exception("Debe de tener un producto");
            }

            String sql = "UPDATE producto SET"
                    + "codigo = '" + producto.getCodigo() + "' WHERE nombre = '" + producto.getNombre();
            instarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarProducto(String nombre) throws Exception {
        //eliminar un producto por nombre
        try {
            String sql = "DELETE FROM producto WHERE nombre= '" + nombre + "' ";
        } catch (Exception e) {
            throw e;
        }

    }

   
    public Collection<Producto> listaProductos() throws Exception {
         Collection<Producto> productos = new ArrayList<>();
        // String sql = "SELECT * from producto ";
        String sql = "SELECT nombre from producto";
        try {

            consultarBase(sql);

            while (resultado.next()) {
                // int id = resultado.getInt("codigo");
                Producto  producto=new Producto();
                String nombre = resultado.getString("nombre");
               
                // double precio = resultado.getDouble("precio");
                // int codigo_fabricante = resultado.getInt("codigo_fabricante");

                // datos.add(id + "  |  " + nombre + "  | " + precio + " | " + codigo_fabricante + " | "   );
                //  System.out.println("ID: " + id + ", Nombre: " + nombre + ", Precio: " + precio+ ", Codigo: " +codigo_fabricante);
                //  String fila = String.format("%-2d | %-32s | %-8.2f | %-4d", id, nombre, precio, codigo_fabricante);
             
                //  String fila = String.format("| %-32s | ", nombre);
               // datos.add(fila);
                producto=new Producto();
              producto.setNombre(resultado.getString(1));
              //producto.setPrecio(resultado.getDouble(2));
              productos.add(producto);
            }
            desconectarBase();
            return productos;

        } catch (Exception e) {
            throw e;

        } finally {
            // Cierra los recursos
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }

        }
    }

    public Collection<Producto> listaProductosNyP() throws Exception {
        Collection<Producto> productos = new ArrayList<>();
        String sql = "SELECT nombre,precio from producto ";

        try {

            consultarBase(sql);

            while (resultado.next()) {
                /*
                String nombre = resultado.getString("nombre");
                double precio = resultado.getDouble("precio");

                String fila = String.format(" %-32s | %-8.2f ", nombre, precio);
                datos.add(fila);
                */
                producto=new Producto();
              producto.setNombre(resultado.getString(1));
              producto.setPrecio(resultado.getDouble(2));
              productos.add(producto);
            }
            desconectarBase();
            return productos;

        } catch (Exception e) {
            throw e;

        } finally {
            // Cierra los recursos
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }

        }
    }

    public  Collection<Producto> listaProductosP120y202() throws Exception {
       Collection<Producto> productos = new ArrayList<>();
        String sql = "SELECT nombre,precio FROM producto  WHERE precio>=102 and precio<=202 ";
        try {

            consultarBase(sql);

            while (resultado.next()) {
                /*
                String nombre = resultado.getString("nombre");
                double precio = resultado.getDouble("precio");

                String fila = String.format(" %-32s | %-8.2f ", nombre, precio);
                datos.add(fila);
               */ 
              producto=new Producto();
              producto.setNombre(resultado.getString(1));
              producto.setPrecio(resultado.getDouble(2));
              productos.add(producto);
            }
            desconectarBase();
            return productos;

        } catch (Exception e) {
            throw e;

        } finally {
            // Cierra los recursos
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }

        }
    }

    public Collection<Producto> listaProductosPorta() throws Exception {
        //List<String> datos = new ArrayList<>();
        Collection<Producto> productos = new ArrayList();
        String sql = "SELECT nombre,precio FROM producto  WHERE nombre like 'portatil%' ";
        try {

            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {

               /* String nombre = resultado.getString("nombre");
                double precio = resultado.getDouble("precio");

                String fila = String.format(" %-32s | %-8.2f ", nombre, precio);
                datos.add(fila);
               */ 
                producto=new Producto();
              producto.setNombre(resultado.getString(1));
              producto.setPrecio(resultado.getDouble(2));
              productos.add(producto);
            }
            desconectarBase();
            return productos;

        } catch (Exception e) {
            throw e;

        } finally {
            // Cierra los recursos
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }

        }
    }
    
    
    public Collection<Producto> listaProductosBarato() throws Exception {
        //List<String> datos = new ArrayList<>();
        
        Collection<Producto> productos = new ArrayList();
        String sql = "SELECT nombre,precio FROM producto  order by precio asc limit 1 ";
        try {

            consultarBase(sql);
            Producto producto = null;
            
            while (resultado.next()) {
                //sin el objeto producto    
              /*  String nombre = resultado.getString("nombre");
                double precio = resultado.getDouble("precio");

                String fila = String.format(" %-32s | %-8.2f ", nombre, precio);
                datos.add(fila);
*/
              producto=new Producto();
              producto.setNombre(resultado.getString(1));
              producto.setPrecio(resultado.getDouble(2));
              productos.add(producto);
            }
            desconectarBase();
            return productos;

        } catch (Exception e) {
            throw e;

        } finally {
            // Cierra los recursos
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }

        }
    }

}
