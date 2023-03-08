package br.com.puc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory2 {

    private ConnectionFactory2(){}
    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/curso",
                    "root",
                    "1304200296"
            );
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

}
