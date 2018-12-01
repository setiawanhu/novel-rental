/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Novel;

public class NovelRepository {
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
     * Retrieve all novels from storage
     * 
     * @return ArrayList<Novel>
     */
    public static ArrayList<Novel> findAll(){
        setConnection();
        ArrayList<Novel> novels = new ArrayList<>();
        
        try{
            //Preparing for DB query
            Statement statement = con.createStatement();
        
            ResultSet result = statement.executeQuery(
                    "SELECT novel.id, title, author, language, publisher, publication_date, rent_price, pages, isbn, " + 
                    "kondisi.name, status, created_at, updated_at FROM novel " +
                    "INNER JOIN kondisi ON novel.kondisi_id = kondisi.id");

            while(result.next()){
                int novelId = result.getInt(1);
                String title = result.getString(2);
                String author = result.getString(3);
                String language = result.getString(4);
                String publisher = result.getString(5);
                String publicationDate = result.getString(6);
                int rentPrice = result.getInt(7);
                int pages = result.getInt(8);
                String isbn = result.getString(9);
                String kondisi = result.getString(10);
                String status = result.getString(11);
                String createdAt = result.getString(12);
                String updatedAt = result.getString(13);
    
                Novel novel = new Novel(novelId, title, author, language, publisher, publicationDate, rentPrice, pages, isbn,
                                        kondisi, status, createdAt, updatedAt); 
                
                novels.add(novel);
            }
            
            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }        
      
        return novels;
    }
    
    /**
     * Find novel by id from storage
     * 
     * @param id int
     * @return Novel
     */
    public static Novel findById(int id){
        setConnection();
        
        Novel novel = null;
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement
            String query = "SELECT novel.id, title, author, language, publisher, publication_date, rent_price, pages, isbn, " + 
                            "kondisi.name, status, created_at, updated_at FROM novel " +
                            "INNER JOIN kondisi ON novel.kondisi_id = kondisi.id " +
                            "WHERE novel.id = ?";
            
            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            //Execute the prepared statement
            if(preparedStatement.execute()){
                ResultSet result = preparedStatement.getResultSet();
                
                result.next();
                
                int novelId = result.getInt(1);
                String title = result.getString(2);
                String author = result.getString(3);
                String language = result.getString(4);
                String publisher = result.getString(5);
                String publicationDate = result.getString(6);
                int rentPrice = result.getInt(7);
                int pages = result.getInt(8);
                String isbn = result.getString(9);
                String kondisi = result.getString(10);
                String status = result.getString(11);
                String createdAt = result.getString(12);
                String updatedAt = result.getString(13);

                novel = new Novel(novelId, title, author, language, publisher, publicationDate, rentPrice, pages, isbn,
                                        kondisi, status, createdAt, updatedAt);
            }
            
            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return novel;
    }
    
    /**
     * Store a new novel to the storage
     * 
     * @param novel Novel
     * @return boolean
     */
    public static boolean create(Novel novel){
        setConnection();
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement
            String query = "INSERT INTO novel (title, author, language, publisher, publication_date, rent_price, "
                    + "pages, ISBN, kondisi_id, status) VALUES (?,?,?,?,?,?,?,?,?,?)";
            
            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, novel.getTitle());
            preparedStatement.setString(2, novel.getAuthor());
            preparedStatement.setString(3, novel.getLanguage());
            preparedStatement.setString(4, novel.getPublisher());
            preparedStatement.setString(5, novel.getPublicationDate());
            preparedStatement.setInt(6, novel.getRentPrice());
            preparedStatement.setInt(7, novel.getPages());
            preparedStatement.setString(8, novel.getIsbn());
            switch(novel.getKondisi()){
                case "bagus":
                    preparedStatement.setInt(9, 1);
                    break;
                case "rusak":
                    preparedStatement.setInt(9, 2);
                    break;
                default:
                    preparedStatement.setInt(9, 0);
            }
            preparedStatement.setString(10, novel.getStatus());
            
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
     * Update an existing novel from the storage
     * 
     * @param id int
     * @param novel Novel
     * @return boolean
     */
    public static boolean update(int id, Novel novel){
        setConnection();
        
        try {
            Statement statement = con.createStatement();
            
            //Query statement
            String query = "UPDATE novel SET title = ?, author = ?, language = ?, publisher = ?, publication_date = ?, rent_price = ?, "
                    + "pages = ?, ISBN = ?, kondisi_id = ?, status = ? WHERE id = ?";
            
            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, novel.getTitle());
            preparedStatement.setString(2, novel.getAuthor());
            preparedStatement.setString(3, novel.getLanguage());
            preparedStatement.setString(4, novel.getPublisher());
            preparedStatement.setString(5, novel.getPublicationDate());
            preparedStatement.setInt(6, novel.getRentPrice());
            preparedStatement.setInt(7, novel.getPages());
            preparedStatement.setString(8, novel.getIsbn());
            switch(novel.getKondisi()){
                case "bagus":
                    preparedStatement.setInt(9, 1);
                    break;
                case "rusak":
                    preparedStatement.setInt(9, 2);
                    break;
                default:
                    preparedStatement.setInt(9, 0);
            }
            preparedStatement.setString(10, novel.getStatus());
            preparedStatement.setInt(11, id);
            
            if(preparedStatement.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    /**
     * Destroy an existing novel from storage
     * 
     * @param id
     * @return 
     */
    public static boolean destroy(int id){
        setConnection();
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement 
            String query = "DELETE FROM novel WHERE id = ?";
            
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
