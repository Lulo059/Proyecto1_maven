package maven_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Hello world!
 *
 */
public class conexion 
{
    public static void main( String[] args )
    {
        connectionDB();
    }
    
    private static void connectionDB() {
    	try {
    		//Establecer conexion
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		
    		//Datos de conexion
    		final Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/pruebaMaven","root", "contrasena");
    		
    		//Consulta
    		final Statement sentencia = dBconection.createStatement();
    		final String query = "SELECT * FROM NTTDATA_ORACLE_SOCCER_TEAM";
    		final ResultSet queryResult = sentencia.executeQuery(query);
    		
    		
    		while(queryResult.next()) {
    			System.out.println(queryResult);
    		}
    		
    		//Se cierra la conexión
    		dBconection.close();
    	} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
    		System.out.println("Conexión realizada.");
    	}
    }
}
