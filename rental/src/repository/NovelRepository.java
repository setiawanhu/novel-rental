package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Genre;
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
                
                ArrayList<Genre> genres = new ArrayList<>();
                //Novel genre query statement
                String query = "SELECT genre.* FROM novel_genre INNER JOIN genre ON novel_genre.genre_id = genre.id WHERE novel_id = ?";

                //Create mysql prepared statement
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setInt(1, novelId);
                
                if(preparedStatement.execute()){
                    ResultSet genreResult = preparedStatement.getResultSet();
                    
                    while(genreResult.next()){
                        int genreId = genreResult.getInt(1);
                        String name = genreResult.getString(2);
                        String created = genreResult.getString(3);
                        String updated = genreResult.getString(4);
                        
                        genres.add(new Genre(genreId, name, created, updated));
                    }
                    
                    novel.setGenres(genres);
                }
                
                novels.add(novel);
            }
            
            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }        
      
        return novels;
    }
    
    /**
     * Retrieve all novels from storage that is not borrowed
     * 
     * @return ArrayList<Novel>
     */
    public static ArrayList<Novel> findAllWhereNotBorrowed(){
        setConnection();
        ArrayList<Novel> novels = new ArrayList<>();
        
        try{
            //Preparing for DB query
            Statement statement = con.createStatement();
        
            ResultSet result = statement.executeQuery(
                    "SELECT novel.id, title, author, language, publisher, publication_date, rent_price, pages, isbn, " + 
                    "kondisi.name, status, created_at, updated_at FROM novel " +
                    "INNER JOIN kondisi ON novel.kondisi_id = kondisi.id " + 
                    "WHERE status = 'available'");

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
                
                ArrayList<Genre> genres = new ArrayList<>();
                //Novel genre query statement
                String query = "SELECT genre.* FROM novel_genre INNER JOIN genre ON novel_genre.genre_id = genre.id WHERE novel_id = ?";

                //Create mysql prepared statement
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setInt(1, novelId);
                
                if(preparedStatement.execute()){
                    ResultSet genreResult = preparedStatement.getResultSet();
                    
                    while(genreResult.next()){
                        int genreId = genreResult.getInt(1);
                        String name = genreResult.getString(2);
                        String created = genreResult.getString(3);
                        String updated = genreResult.getString(4);
                        
                        genres.add(new Genre(genreId, name, created, updated));
                    }
                    
                    novel.setGenres(genres);
                }
                
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
            ResultSet result = preparedStatement.executeQuery();
            
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

                novel = new Novel(novelId, title, author, language, publisher, publicationDate, rentPrice, pages, isbn,
                                        kondisi, status, createdAt, updatedAt);
                
                ArrayList<Genre> genres = new ArrayList<>();
                //Novel genre query statement
                String genreQuery = "SELECT genre.* FROM novel_genre INNER JOIN genre ON novel_genre.genre_id = genre.id WHERE novel_id = ?";

                //Create mysql prepared statement
                PreparedStatement genrePreparedStatement = con.prepareStatement(genreQuery);
                genrePreparedStatement.setInt(1, novelId);
                
                if(genrePreparedStatement.execute()){
                    ResultSet genreResult = genrePreparedStatement.getResultSet();
                    
                    while(genreResult.next()){
                        int genreId = genreResult.getInt(1);
                        String name = genreResult.getString(2);
                        String created = genreResult.getString(3);
                        String updated = genreResult.getString(4);
                        
                        genres.add(new Genre(genreId, name, created, updated));
                    }
                    
                    novel.setGenres(genres);
                }    
            }
            
            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return novel;
    }
    
    /**
     * Find novel by id from storage
     * 
     * @param id int
     * @return ArrayList<Novel>
     */
    public static ArrayList<Novel> findById(String id){
        setConnection();
        
        ArrayList<Novel> novels = new ArrayList<>();
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement
            String query = "SELECT novel.id, title, author, language, publisher, publication_date, rent_price, pages, isbn, " + 
                            "kondisi.name, status, created_at, updated_at FROM novel " +
                            "INNER JOIN kondisi ON novel.kondisi_id = kondisi.id " +
                            "WHERE novel.id LIKE ?";
            
            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, "%"+id+"%");
            
            //Execute the prepared statement
            ResultSet result = preparedStatement.executeQuery();
            
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
                
                ArrayList<Genre> genres = new ArrayList<>();
                //Novel genre query statement
                String genreQuery = "SELECT genre.* FROM novel_genre INNER JOIN genre ON novel_genre.genre_id = genre.id WHERE novel_id = ?";

                //Create mysql prepared statement
                PreparedStatement genrePreparedStatement = con.prepareStatement(genreQuery);
                genrePreparedStatement.setInt(1, novelId);
                
                if(genrePreparedStatement.execute()){
                    ResultSet genreResult = genrePreparedStatement.getResultSet();
                    
                    while(genreResult.next()){
                        int genreId = genreResult.getInt(1);
                        String name = genreResult.getString(2);
                        String created = genreResult.getString(3);
                        String updated = genreResult.getString(4);
                        
                        genres.add(new Genre(genreId, name, created, updated));
                    }
                    
                    novel.setGenres(genres);
                }    
                
                novels.add(novel);
            }
            
            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return novels;
    }
    
    /**
     * Find novel by title from storage
     * 
     * @param id int
     * @return Novel
     */
    public static ArrayList<Novel> findByTitle(String keyword){
        setConnection();
        
        ArrayList<Novel> novels = new ArrayList<>();
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement
            String query = "SELECT novel.id, title, author, language, publisher, publication_date, rent_price, pages, isbn, " + 
                            "kondisi.name, status, created_at, updated_at FROM novel " +
                            "INNER JOIN kondisi ON novel.kondisi_id = kondisi.id " +
                            "WHERE novel.title LIKE ?";
            
            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, "%"+keyword+"%");
            
            //Execute the prepared statement
            ResultSet result = preparedStatement.executeQuery();
                
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
                
                ArrayList<Genre> genres = new ArrayList<>();
                //Novel genre query statement
                String genreQuery = "SELECT genre.* FROM novel_genre INNER JOIN genre ON novel_genre.genre_id = genre.id WHERE novel_id = ?";

                //Create mysql prepared statement
                PreparedStatement genrePreparedStatement = con.prepareStatement(genreQuery);
                genrePreparedStatement.setInt(1, novelId);
                
                if(genrePreparedStatement.execute()){
                    ResultSet genreResult = genrePreparedStatement.getResultSet();
                    
                    while(genreResult.next()){
                        int genreId = genreResult.getInt(1);
                        String name = genreResult.getString(2);
                        String created = genreResult.getString(3);
                        String updated = genreResult.getString(4);
                        
                        genres.add(new Genre(genreId, name, created, updated));
                    }
                    
                    novel.setGenres(genres);
                }    
                
                novels.add(novel);
            }
            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return novels;
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
            
            //Novel query statement
            String novelQuery = "INSERT INTO novel (title, author, language, publisher, publication_date, rent_price, "
                    + "pages, ISBN, kondisi_id, status) VALUES (?,?,?,?,?,?,?,?,?,?)";
            
            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(novelQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, novel.getTitle());
            preparedStatement.setString(2, novel.getAuthor());
            preparedStatement.setString(3, novel.getLanguage());
            preparedStatement.setString(4, novel.getPublisher());
            preparedStatement.setString(5, novel.getPublicationDate());
            preparedStatement.setInt(6, novel.getRentPrice());
            preparedStatement.setInt(7, novel.getPages());
            preparedStatement.setString(8, novel.getIsbn());
            switch(novel.getKondisi()){
                case "Bagus":
                    preparedStatement.setInt(9, 1);
                    break;
                case "Rusak":
                    preparedStatement.setInt(9, 2);
                    break;
                default:
                    preparedStatement.setInt(9, 0);
            }
            preparedStatement.setString(10, novel.getStatus());
            
            //Execute the query
            if(preparedStatement.executeUpdate() > 0){
                int novelId = 0;
                
                ResultSet result = preparedStatement.getGeneratedKeys();
                if(result.next()){
                    novelId = result.getInt(1);
                }
                
                ArrayList<Genre> genres = novel.getGenres();
                
                for(int i = 0; i < genres.size(); i++){
                    //Query statement
                    String genreQuery = "INSERT INTO novel_genre (novel_id, genre_id) VALUES (?,?)";

                    //Create mysql prepared statement
                    PreparedStatement genrePreparedStatement = con.prepareStatement(genreQuery);
                    genrePreparedStatement.setInt(1, novelId);
                    genrePreparedStatement.setInt(2, genres.get(i).getId());
                    
                    genrePreparedStatement.executeUpdate();
                }
                
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
                case "Bagus":
                    preparedStatement.setInt(9, 1);
                    break;
                case "Rusak":
                    preparedStatement.setInt(9, 2);
                    break;
                default:
                    preparedStatement.setInt(9, 0);
            }
            preparedStatement.setString(10, novel.getStatus());
            preparedStatement.setInt(11, id);
            
            if(preparedStatement.executeUpdate() > 0){
                //Delete genre query statement
                String deleteGenreQuery = "DELETE FROM novel_genre WHERE novel_id = ?";
                
                //Create mysql prepared statement
                PreparedStatement deletePreparedStatement = con.prepareStatement(deleteGenreQuery);
                deletePreparedStatement.setInt(1, id);
                deletePreparedStatement.executeUpdate();
                
                ArrayList<Genre> genres = novel.getGenres();
                
                for(int i = 0; i < genres.size(); i++){
                    //Query statement
                    String genreQuery = "INSERT INTO novel_genre (novel_id, genre_id) VALUES (?,?)";

                    //Create mysql prepared statement
                    PreparedStatement genrePreparedStatement = con.prepareStatement(genreQuery);
                    genrePreparedStatement.setInt(1, id);
                    genrePreparedStatement.setInt(2, genres.get(i).getId());
                    
                    genrePreparedStatement.executeUpdate();
                }
                
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
                //Delete genre query statement
                String deleteGenreQuery = "DELETE FROM novel_genre WHERE novel_id = ?";
                
                //Create mysql prepared statement
                PreparedStatement deletePreparedStatement = con.prepareStatement(deleteGenreQuery);
                deletePreparedStatement.setInt(1, id);
                deletePreparedStatement.executeUpdate();
                
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return false;
    }
}
