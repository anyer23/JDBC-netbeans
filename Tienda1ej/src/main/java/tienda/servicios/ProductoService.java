/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.servicios;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

/**
 *
 * @author monte
 */
public class ProductoService {

    private ProductoDAO proDAO;
    Producto producto;
    Scanner leer = new Scanner(System.in);

    public ProductoService() {
        producto = new Producto(); // Agrega esta línea para inicializar el objeto producto
        proDAO = new ProductoDAO();
    }

    public void productosTa(){
               try {
                    System.out.println(" ");
                    System.out.println("Nombre de todos los productos que hay en la tabla producto.\n");
                    Collection<Producto> datosTabla = proDAO.listaProductos();

                    // Realiza las operaciones necesarias con los datos obtenidos
                       for (Producto producto1 : datosTabla) {
                // System.out.println(producto1.getNombre() + "  " + producto1.getPrecio());
                String nombre = producto1.getNombre();
                double precio = producto1.getPrecio();

                String mensaje = String.format( nombre);
                System.out.println(mensaje);
            }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    // Maneja la excepción de SQL
                    e.printStackTrace();
                }

    }
    
    public void productoNyP() {
        try {
            System.out.println(" ");
            System.out.println("Lista los nombres y los precios de todos los productos de la tabla producto.\n");
            Collection<Producto> datosTabla = proDAO.listaProductosNyP();

            // Realiza las operaciones necesarias con los datos obtenidos
            for (Producto producto1 : datosTabla) {
                // System.out.println(producto1.getNombre() + "  " + producto1.getPrecio());
                String nombre = producto1.getNombre();
                double precio = producto1.getPrecio();

                String mensaje = String.format("%-35s %10.2f", nombre, precio);
                System.out.println(mensaje);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // Maneja la excepción de SQL
            e.printStackTrace();
        }
    }

    public void precio102a202() {
        try {
            System.out.println(" ");
            System.out.println("Listar aquellos productos que su precio esté entre 120 y 202.\n");
            Collection<Producto> datosTabla = proDAO.listaProductosP120y202();

            for (Producto producto1 : datosTabla) {
                // System.out.println(producto1.getNombre() + "  " + producto1.getPrecio());
                String nombre = producto1.getNombre();
                double precio = producto1.getPrecio();

                String mensaje = String.format("%-30s %10.2f", nombre, precio);
                System.out.println(mensaje);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // Maneja la excepción de SQL
            e.printStackTrace();
        }

    }

    public void portatil() {
        try {

            System.out.println("Buscar y listar los portatiles de la tabla producto.\n");
            Collection<Producto> datosTabla = proDAO.listaProductosPorta();

            // Realiza las operaciones necesarias con los datos obtenidos
            for (Producto producto1 : datosTabla) {
                // System.out.println(producto1.getNombre() + "  " + producto1.getPrecio());
                String nombre = producto1.getNombre();
                double precio = producto1.getPrecio();

                String mensaje = String.format("%-20s %10.2f", nombre, precio);
                System.out.println(mensaje);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // Maneja la excepción de SQL
            e.printStackTrace();
        }
    }

    public void productoBarato() {
        try {

            System.out.println(" Listar el nombre y el precio del producto más barato..\n");
            Collection<Producto> datosTabla = proDAO.listaProductosBarato();

            // Realiza las operaciones necesarias con los datos obtenidos
            for (Producto producto1 : datosTabla) {
                // System.out.println(producto1.getNombre() + "  " + producto1.getPrecio());
                String nombre = producto1.getNombre();
                double precio = producto1.getPrecio();

                String mensaje = String.format("%-20s %10.2f", nombre, precio);
                System.out.println(mensaje);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // Maneja la excepción de SQL
            e.printStackTrace();
        }
    }

    public void crearProducto() throws Exception {
        do {

            try {

                System.out.println("ingrese el nombre del producto\n");
                producto.setNombre(leer.nextLine());
                System.out.println("ingrese el precio\n");
                String p = leer.nextLine();
                System.out.println("ingrese el codigo del fabricante\n");
                String c = leer.nextLine();

                try {
                    producto.setPrecio(Double.parseDouble(p));
                    producto.setCodigo_fabricante(Integer.parseInt(c));

                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un numero valido");
                    continue;
                }
                if (producto.getNombre() == null || producto.getNombre().isEmpty()) {
                    throw new IllegalArgumentException("\nDebe de indicar  el nombre         ");
                }

                if (producto.getPrecio() <= 0) {
                    throw new IllegalArgumentException("\nDebe de indicar el precio ");
                }
                proDAO.ingresarProducto(producto);
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        } while (producto.getNombre() == null || producto.getNombre().isEmpty() || producto.getPrecio() <= 0);
    }

}
