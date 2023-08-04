/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.servicios;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

/**
 *
 * @author monte
 */
public class Services {

    Scanner leer = new Scanner(System.in);

    ProductoService pser = new ProductoService();

    FabricantesService fser=new FabricantesService();
    public void menu() throws Exception {

        int op;
        do {
            System.out.println("");
            System.out.println("Menu");
            System.out.println("1. Nombre de los productos en la tabla producto.");
            System.out.println("2. Nombres y los precios de los productos de la tabla producto.");
            System.out.println("3. Listar aquellos productos que su precio esté entre 120 y 202.");
            System.out.println("4. Buscar y listar los portatiles de la tabla producto");
            System.out.println("5. Listar el nombre y el precio del producto más barato.");
            System.out.println("6. Ingresar un producto a la base de datos.");
            System.out.println("7. Ingresar un fabricante a la base de datos ");
            
            System.out.println("8. Editar un producto con datos a elección.");
            op = leer.nextInt();
            // String cp = " ";
            // limpiarPantalla();
            switch (op) {
                case 1:

                    pser.productosTa();
                    break;

                case 2:

                    pser.productoNyP();

                    break;

                case 3:

                    pser.precio102a202();
                    break;

                case 4:

                    pser.portatil();

                    break;
                case 5:
                    pser.productoBarato();

                    break;

                case 6:
                     try {
                    pser.crearProducto();

                } catch (Exception e) {
                    // Maneja la excepción de SQL
                    e.printStackTrace();
                }
                break;

                case 7:
                    
                    fser.crearFabricante();
                    break;
                case 8:
                    pser.modificarProducto();
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }

            if (op != 9) {

                ///   limpiarPantalla();
            }

        } while (op != 9);
        leer.close();

    }

    /* private static void limpiarPantalla() {
        // Lógica para limpiar la pantalla (puedes adaptarla según el sistema operativo)
        for (int i = 0; i < 5; i++) {
            System.out.println();

        }
        System.out.println("Presiona Enter para continuar...");

    }
     */
}
