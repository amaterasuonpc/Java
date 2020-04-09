package dbapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArtistController {
    Connection connection;

    public ArtistController() {
        this.connection = Database.getConnection();
    }
    public void create(String name1,String country){
        Statement stmt;
        try {
            stmt = connection.createStatement();
            String sql="Insert into \"Artists\"(name,country) VALUES ("+name1+" , "+country+");";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
    public int findByName(String name1){
        Statement stmt;
        String query="Select * from \"Artists\" where name="+name1+";";
        System.out.println(query);
        try {
            stmt=connection.createStatement();

            ResultSet rs =stmt.executeQuery(query);
            rs.next();
            return rs.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
