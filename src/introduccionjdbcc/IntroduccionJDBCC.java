/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introduccionjdbcc;
import java.sql.*;

/**
 *
 * @author Cefnar
 */

// ####### ----      MYSQL CONEXION !!!!!!!!!!!!
public class IntroduccionJDBCC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    //Cadena de conexion de Mysql. El uso del parametro useSSL es opcional.
    String url = "jdbc:mysql://localhost:3306/sga?useSSL=false";
    
    //Cargamso el driver de mysql en un try por si da error
    //Al cargar el api de mysql, ya se crean las clases que debemos uar, aqui solo las llamamos y creamos 
    //ojetos
    //Este ejercicio es con el api de mysqli con Oracle es otro driver y diferente
    try {
        //Aqui cargamos la clase que se creo con el driver, al agregar el api de mysql a librerias
        Class.forName("com.mysql.jdbc.Driver");
        //Creamos un objeto de conexion, el cual debemos recordar cerrar al final
        Connection conexion = (Connection) DriverManager.getConnection(url,"root","admin");
        //Creamos un objeto statement
        Statement instruction = conexion.createStatement();
        //Creamos el query y lo metemos en una variable llamada sql como en php
        String sql = "Select id_persona, nombre, apellido from persona";
        ResultSet result = instruction.executeQuery(sql);
        //Mostramos los datos con un while
        while (result.next()){
            System.out.print("Id: " + result.getInt(1));
            System.out.print(" Nombre: " + result.getString(2));
            System.out.println(" Apellido: " + result.getString(3));
        
        }
        //Cerrar cada uno de los objetos usados
        result.close();
        instruction.close();
        conexion.close();
    
        //Vamos a verificar si nos dio error la clase o un sql y si fue asi, imprimimos el error 
        //para saber que es
    }catch (ClassNotFoundException | SQLException e){
        e.printStackTrace();
    }
    
    
    }
    
}
