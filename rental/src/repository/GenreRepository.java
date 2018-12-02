package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Genre;


public class GenreRepository {
    private static Connection con;
    
    /**
     * Set up the mysql db connection
     * 
     */
    private static void setConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/novel_rental","root","");
        } catch (Exception e) {
            Logger.getLogger(NovelRepository.class.getName()).log(Level.SEVERE, null, e);
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Retrieve all genres from storage
     * 
     * @return ArrayList<Genre>
     */
    public static ArrayList<Genre> findAll(){
        setConnection();
        
        ArrayList<Genre> genres = new ArrayList<>();
        
        try{
            //Preparing for DB query
            Statement statement = con.createStatement();
        
            ResultSet result = statement.executeQuery("SELECT * FROM genre");

            while(result.next()){
                int genreId = result.getInt(1);
                String name = result.getString(2);
                String created_at = result.getString(3);
                String updated_at = result.getString(4);
    
                Genre genre = new Genre(genreId, name, created_at, updated_at);
                
                genres.add(genre);
            }
            
            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return genres;
    }
    
    /**
     * Find genre by id from storage
     * 
     * @param id int
     * @return Genre
     */
    public static Genre findById(int id){
        setConnection();
        
        Genre genre = null;
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement
            String query = "SELECT * FROM genre WHERE id = ?";

            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            //Execute the prepared statement
            if(preparedStatement.execute()){
                ResultSet result = preparedStatement.getResultSet();
                
                result.next();
                
                int genreId = result.getInt(1);
                String name = result.getString(2);
                String created_at = result.getString(3);
                String updated_at = result.getString(4);

                genre = new Genre(genreId, name, created_at, updated_at);
            }
            
            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return genre;
    }
    
    /**
     * Find genre by name keyword from storage
     * 
     * @param keyword String
     * @return ArrayList<Genre>
     */
    public static ArrayList<Genre> findByName(String keyword){
        setConnection();
        
        ArrayList<Genre> genres = new ArrayList<>();
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement
            String query = "SELECT * FROM genre WHERE name LIKE ?";

            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, "%"+keyword+"%");
            
            //Execute the prepared statement
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next()){
                int genreId = result.getInt(1);
                String name = result.getString(2);
                String created_at = result.getString(3);
                String updated_at = result.getString(4);

                genres.add(new Genre(genreId, name, created_at, updated_at));
            }
            
            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return genres;
    }
    
    /**
     * Store a new genre to the storage
     * 
     * @param genre Genre
     * @return boolean
     */
    public static boolean create(Genre genre){
        setConnection();
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement
            String query = "INSERT INTO genre (name) VALUES (?)";
            
            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, genre.getName());
            
            //Execute the query
            if(preparedStatement.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    /**
     * Update an existing genre from the storage
     * 
     * @param id int
     * @param genre Genre
     * @return boolean
     */
    public static boolean update(int id, Genre genre){
        setConnection();
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement
            String query = "UPDATE genre SET name = ? WHERE id = ?";
            
            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setString(1, genre.getName());
            preparedStatement.setInt(2, id);
            
            //Execute the query
            if(preparedStatement.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    /**
     * Destroy an existing genre from storage
     * 
     * @param id
     * @return 
     */
    public static boolean destroy(int id){
        setConnection();
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement 
            String query = "DELETE FROM genre WHERE id = ?";
            
            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            if(preparedStatement.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
}
