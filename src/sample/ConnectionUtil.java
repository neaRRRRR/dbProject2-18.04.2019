package sample;

import java.sql.Connection;
import java.sql.DriverManager;






public class ConnectionUtil {

    private static Connection connection;

    public static Connection connectdb(){

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url1 = "jdbc:mysql://localhost:3306/dbp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String password = "kaan1998";

            connection = DriverManager.getConnection(url1, user, password);

            return connection;




        }
        catch(Exception e){

            e.printStackTrace();

            return null;

        }





    }


}
