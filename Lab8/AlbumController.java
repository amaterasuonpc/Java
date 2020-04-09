package dbapp.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumController {
    Connection connection;

    public AlbumController() {
        this.connection = Database.getConnection();
    }
    public void create(String name,int artistId,int releaseYear){
        Statement stmt;

        try {
            stmt = connection.createStatement();

            String sql="Insert into \"Albums\" (name,artist_id,release_year) VALUES ("+name+" ,"+Integer.toString(artistId)+","+Integer.toString(releaseYear)+");";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public String findByArtist(int artistId){
        Statement stmt;
        String query="Select * from \"Albums\" where artist_id="+artistId+";";

        try {
            stmt=connection.createStatement();

            ResultSet rs =stmt.executeQuery(query);
            rs.next();
            return rs.getString("name");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "not found";

    }

}
