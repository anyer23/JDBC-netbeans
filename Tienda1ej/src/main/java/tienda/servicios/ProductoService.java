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
    FabricantesService fabServ=new FabricantesService();
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
                producto.setPrecio( leer.nextDouble());
                
                fabServ.mostrarFabricante();
                System.out.println("seleccione el codigo del fabricante\n");
                producto.setCodigo_fabricante(fabServ.seleccionarFabricante(leer.nextInt()));

        
                
                if (producto.getNombre() == null || producto.getNombre().isEmpty()) {
                    throw new IllegalArgumentException("\nDebe de indicar  el nombre ");
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

    
    public void modificarProducto() throws Exception{
        
            try {
                  
            Collection<Producto> productos = proDAO.selectProduct();
            
               for (Producto producto1 : productos) {
                // System.out.println(producto1.getNombre() + "  " + producto1.getPrecio());
                int codigo=producto1.getCodigo();
                String nombre = producto1.getNombre();
                double precio = producto1.getPrecio();

                String mensaje = String.format("%2d %-20s %10.2f", codigo,nombre, precio);
                System.out.println(mensaje);
            }
            
               System.out.println("Ingrese el codigo de producto a modificar");
               Producto produc=proDAO.selectProductId(leer.nextInt());
            System.out.println("¿Qué desea modificar?");
           
            System.out.println("Campos a modificar");
            System.out.println("1. Nombre del producto");
            System.out.println("2. Precio del producto");
            System.out.println("3. Código fabricante del producto ");
            //System.out.println("4. Salir");

            int opcion = leer.nextInt();
            leer.nextLine(); // Limpiar el salto de línea

            switch (opcion) {
                case 1:
                    leer.nextLine();
             
                    System.out.println("Ingrese el nuevo nombre del producto:");
                    produc.setNombre( leer.nextLine());
                    proDAO.upDateProducto(producto, opcion);
                    
                    try {
                        proDAO.upDateProducto(producto, opcion);
                        System.out.println("Nombre del producto modificado exitosamente.");
                    } catch (Exception e) {
                        System.out.println("Error al modificar el nombre del producto: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Nuevo precio:");
                    produc.setPrecio( leer.nextDouble());

          
                    try {
                        proDAO.upDateProducto(producto, opcion);
                        System.out.println("Precio del producto modificado exitosamente.");
                    } catch (Exception e) {
                        System.out.println("Error al modificar el precio del producto: " + e.getMessage());
                    }
                    break;

                case 3:
                    
                    fabServ.mostrarFabricante();
                    System.out.println("Selecciones el ID del fabricante:");
                    String nombreProductoCodigo = leer.nextLine();

           
                    try {
                         proDAO.upDateProducto(producto, opcion);
                       System.out.println("Código del producto modificado exitosamente.");
                    } catch (Exception e) {
                        System.out.println("Error al modificar el código del producto: " + e.getMessage());
                    }
                    break;

                
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        
                
            } catch (Exception e) {
             throw new Exception("ERROR MOSTRANDO NOMBRE DE PRODUCTOS");
            }
      
    }
    
    
}
