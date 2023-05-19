package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryDB {

    ConectionDB con = new ConectionDB();
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    Connection conexion = null;
    ResultSet resultSet = null;

    public void Read(){
        String sql = "SELECT * FROM Estudiantes";
        try{
            conexion = con.getConnection();
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                System.out.println(resultSet.getString(2) + " " +resultSet.getString(3)
                        + " " +resultSet.getString(4) + " " +resultSet.getString(5)
                        + " " +resultSet.getString(6) + " ");
            }

        }catch (Exception e){
            System.out.println("No se pudo leer los registros de la base de datos\nERROR: " + e);
        }
    }
    public void Insert(String name, String lastName, float notaUno, float notaDos, float notaTres, float notaFinal){
        String sql = "INSERT INTO Estudiantes (nombre, apellido, notaUno, notaDos, notaTres, notaFinal) VALUES " +
                "(?, ?, ?, ?, ?, ?)";
        try{
            conexion = con.getConnection();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setFloat(3, notaUno);
            preparedStatement.setFloat(4, notaDos);
            preparedStatement.setFloat(5, notaTres);
            preparedStatement.setFloat(6, notaFinal);

            preparedStatement.executeUpdate();

            System.out.println("Los valores fueron agregados correctamente.");

        }catch (Exception e){
            System.out.println("Los fue posible agregar el registro. \nERROR: " + e);
        }
    }

    public void Delete(int id){
        String sql = "DELETE FROM Estudiantes WHERE id_estudiante = ? ";

        try{
            conexion = con.getConnection();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            System.out.println("El registro " + id + " fue eliminado");
        }catch(Exception e){
            System.out.println("No se elimino el registro " + id + "\nERROR: " + e);
        }

    }


}
