package dbapp.dao;

import java.sql.*;

public class Database {
    static Connection connection;


    private Database() {

    }

    public static Connection getConnection() {

        if (connection == null) {


            Statement stmt = null;
            try {

                connection = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/MusicAlbums",
                                "dba", "sql");
                connection.setAutoCommit(false);

            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Opened database successfully");
            return connection;
        } else {
            return connection;
        }
    }
    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
