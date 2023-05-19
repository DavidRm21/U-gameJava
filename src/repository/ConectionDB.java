package repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectionDB {
    Connection connection;

    public ConectionDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Colegio", "root", "");

        }catch (Exception e){
            System.err.println("No se pudo establecer la conexión a la base de datos.\nError: " + e);
        }
    }

    public Connection getConnection(){
        return connection;
    }
}
