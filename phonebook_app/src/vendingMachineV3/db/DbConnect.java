package vendingMachineV3.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    private static Connection dbConn;


    public static Connection getConnection() {
        if (dbConn == null) {
            String dbDriver = "com.mysql.cj.jdbc.Driver";
            String dbUrl = "jdbc:mysql://localhost:3306/vMachine_db";
            String dbUser = "vuser";
            String dbPassword = "1111";

            try {
                Class.forName(dbDriver);
                dbConn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                System.out.println("DB연결 성공");
            } catch (Exception e) {
                System.out.println("DB연결 실패");
                e.printStackTrace();
            }
        }
        return dbConn;
    }
    public static void close(){
        if(dbConn != null){
            try {
                if(!dbConn.isClosed()){
                    dbConn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
