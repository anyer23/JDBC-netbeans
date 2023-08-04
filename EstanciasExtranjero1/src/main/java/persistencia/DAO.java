/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author monte
 */
public abstract class DAO {
    protected Connection conexion=null;
   protected Statement sentencia = null;
   protected ResultSet resultado = null;
      
 
   private final String USER ="root";
   private final String PASSWORD ="root";
   private final String DATABASE ="estancias_exterior";
   private final String DRIVER ="com.mysql.cj.jdbc.Driver";
   
   protected  void conectarBase() throws ClassNotFoundException, SQLException{
       try {
           Class.forName(DRIVER);
           String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false&serverTimezone=America/Los_Angeles";
    
           conexion =DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
           
           
       } catch (ClassNotFoundException | SQLException ex) {
           throw ex;
                 
       }
   }
   
   protected void desconectarBase() throws Exception{
       try {
           if (resultado !=null) {
               resultado.close();
           }
           if (sentencia != null) {
               sentencia.close();
           }
           if (conexion!=null) {
               conexion.close();
           }
       } catch (SQLException e) {
           throw e;
       }
   }
   
   protected  void instarModificarEliminar(String sql) throws SQLException, ClassNotFoundException, Exception{
       try {
           conectarBase();
           sentencia=conexion.createStatement();
           sentencia.executeUpdate(sql);
           
           
       } catch (SQLException | ClassNotFoundException ex) {
           
           // se recomienda usar un roolback();
           //conexion.rollback();
           /*descomentar la linea anterior si desae tener en cuenta el rollback
           correr el siguiente script en workbench
           
           SET autocommit =1;
           COMMIT;
           
           */
           throw ex;
       }finally{
           desconectarBase();
       }
   }
   
   protected void consultarBase(String sql ) throws Exception{
       try {
           conectarBase();
           sentencia=conexion.createStatement();
           resultado=sentencia.executeQuery(sql);
       } catch (ClassNotFoundException | SQLException e) {
           throw e;
       }
   }
}
