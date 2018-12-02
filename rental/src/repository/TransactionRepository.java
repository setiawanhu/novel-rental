/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Genre;
import model.Member;
import model.Novel;
import model.Transaction;
import model.TransactionDetail;
import model.User;

/**
 *
 * @author setiawanhu
 */
public class TransactionRepository {
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
     * Retrieve all transactions from storage
     * 
     * @return ArrayList<Transaction>
     */
    public static ArrayList<Transaction> findAll(){
        setConnection();
        
        ArrayList<Transaction> transactions = new ArrayList<>();
        
        try{
            //Preparing for DB query
            Statement statement = con.createStatement();
        
            ResultSet result = statement.executeQuery("SELECT peminjaman.id, member.id, member.name, user.id, user.name, status, peminjaman.created_at FROM peminjaman " +
                                                      "INNER JOIN member ON peminjaman.member_id = member.id " +
                                                      "INNER JOIN user ON peminjaman.user_id = user.id");

            while(result.next()){
                int transactionId = result.getInt(1);
                int memberId = result.getInt(2);
                String memberName = result.getString(3);
                Member member = new Member();
                member.setId(memberId);
                member.setName(memberName);
                
                int userId = result.getInt(4);
                String userName = result.getString(5);
                User user = new User();
                user.setId(userId);
                user.setName(userName);
                
                String status = result.getString(6);
                String createdAt = result.getString(7);
    
                Transaction transaction = new Transaction(transactionId, member, user, status, createdAt);
                
                ArrayList<TransactionDetail> details = new ArrayList<>();
                
                //Get transaction detail
                String query = "SELECT tanggal_kembali, denda, novel.*, kondisi.name FROM peminjaman_novel " +
                               "INNER JOIN novel ON peminjaman_novel.novel_id = novel.id " +
                               "INNER JOIN kondisi ON novel.kondisi_id = kondisi.id WHERE peminjaman_id = ?";

                //Create mysql prepared statement
                PreparedStatement transactionDetailPreparedStatement = con.prepareStatement(query);
                transactionDetailPreparedStatement.setInt(1, transactionId);
                
                if(transactionDetailPreparedStatement.execute()){
                    ResultSet transactionDetailResult = transactionDetailPreparedStatement.getResultSet();
                    
                    while(transactionDetailResult.next()){
                        
                        String returnDate = transactionDetailResult.getString(1);
                        int fine = transactionDetailResult.getInt(2);
                        
                        //Retrieve novel information
                        int novelId = transactionDetailResult.getInt(3);
                        String title = transactionDetailResult.getString(4);
                        String author = transactionDetailResult.getString(5);
                        String language = transactionDetailResult.getString(6);
                        String publisher = transactionDetailResult.getString(7);
                        String publicationDate = transactionDetailResult.getString(8);
                        int rentPrice = transactionDetailResult.getInt(9);
                        int pages = transactionDetailResult.getInt(10);
                        String isbn = transactionDetailResult.getString(11);
                        String kondisi = transactionDetailResult.getString(16);
                        String novelStatus = transactionDetailResult.getString(13);
                        String novelCreatedAt = transactionDetailResult.getString(14);
                        String updatedAt = transactionDetailResult.getString(15);

                        Novel novel = new Novel(novelId, title, author, language, publisher, publicationDate, rentPrice, pages, isbn,
                                                kondisi, novelStatus, novelCreatedAt, updatedAt); 

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
                        
                        details.add(new TransactionDetail(transactionId, novel, returnDate, fine));
                    }
                    
                    transaction.setTransactionDetails(details);
                }
                
                transactions.add(transaction);
            }
            
            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return transactions;
    }
    
    /**
     * Retrieve all transactions from storage
     * 
     * @return ArrayList<Transaction>
     */
    public static ArrayList<Transaction> findAllWhereNotCompleted(){
        setConnection();
        
        ArrayList<Transaction> transactions = new ArrayList<>();
        
        try{
            //Preparing for DB query
            Statement statement = con.createStatement();
        
            ResultSet result = statement.executeQuery("SELECT peminjaman.id, member.id, member.name, user.id, user.name, status, peminjaman.created_at FROM peminjaman " +
                                                      "INNER JOIN member ON peminjaman.member_id = member.id " +
                                                      "INNER JOIN user ON peminjaman.user_id = user.id " +
                                                      "WHERE status = 'not finished'");

            while(result.next()){
                int transactionId = result.getInt(1);
                int memberId = result.getInt(2);
                String memberName = result.getString(3);
                Member member = new Member();
                member.setId(memberId);
                member.setName(memberName);
                
                int userId = result.getInt(4);
                String userName = result.getString(5);
                User user = new User();
                user.setId(userId);
                user.setName(userName);
                
                String status = result.getString(6);
                String createdAt = result.getString(7);
    
                Transaction transaction = new Transaction(transactionId, member, user, status, createdAt);
                
                ArrayList<TransactionDetail> details = new ArrayList<>();
                
                //Get transaction detail
                String query = "SELECT tanggal_kembali, denda, novel.*, kondisi.name FROM peminjaman_novel " +
                               "INNER JOIN novel ON peminjaman_novel.novel_id = novel.id " +
                               "INNER JOIN kondisi ON novel.kondisi_id = kondisi.id WHERE peminjaman_id = ?";

                //Create mysql prepared statement
                PreparedStatement transactionDetailPreparedStatement = con.prepareStatement(query);
                transactionDetailPreparedStatement.setInt(1, transactionId);
                
                if(transactionDetailPreparedStatement.execute()){
                    ResultSet transactionDetailResult = transactionDetailPreparedStatement.getResultSet();
                    
                    while(transactionDetailResult.next()){
                        
                        String returnDate = transactionDetailResult.getString(1);
                        int fine = transactionDetailResult.getInt(2);
                        
                        //Retrieve novel information
                        int novelId = transactionDetailResult.getInt(3);
                        String title = transactionDetailResult.getString(4);
                        String author = transactionDetailResult.getString(5);
                        String language = transactionDetailResult.getString(6);
                        String publisher = transactionDetailResult.getString(7);
                        String publicationDate = transactionDetailResult.getString(8);
                        int rentPrice = transactionDetailResult.getInt(9);
                        int pages = transactionDetailResult.getInt(10);
                        String isbn = transactionDetailResult.getString(11);
                        String kondisi = transactionDetailResult.getString(16);
                        String novelStatus = transactionDetailResult.getString(13);
                        String novelCreatedAt = transactionDetailResult.getString(14);
                        String updatedAt = transactionDetailResult.getString(15);

                        Novel novel = new Novel(novelId, title, author, language, publisher, publicationDate, rentPrice, pages, isbn,
                                                kondisi, novelStatus, novelCreatedAt, updatedAt); 

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
                        
                        details.add(new TransactionDetail(transactionId, novel, returnDate, fine));
                    }
                    
                    transaction.setTransactionDetails(details);
                }
                
                transactions.add(transaction);
            }
            
            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return transactions;
    }
    
    /**
     * Find transaction by id from storage
     * 
     * @param id String
     * @return ArrayList<Transaction>
     */
    public static ArrayList<Transaction> findById(String id){
        setConnection();
        
        ArrayList<Transaction> transactions = new ArrayList<>();
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement
            String query = "SELECT peminjaman.id, member.id, member.name, user.id, user.name, status, peminjaman.created_at FROM peminjaman " +
                            "INNER JOIN member ON peminjaman.member_id = member.id " +
                            "INNER JOIN user ON peminjaman.user_id = user.id " +
                            "WHERE peminjaman.id LIKE ?";
            
            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, "%"+id+"%");
            
            //Execute the prepared statement
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next()){
                int transactionId = result.getInt(1);
                int memberId = result.getInt(2);
                String memberName = result.getString(3);
                Member member = new Member();
                member.setId(memberId);
                member.setName(memberName);
                
                int userId = result.getInt(4);
                String userName = result.getString(5);
                User user = new User();
                user.setId(userId);
                user.setName(userName);
                
                String status = result.getString(6);
                String createdAt = result.getString(7);
    
                Transaction transaction = new Transaction(transactionId, member, user, status, createdAt);
                
                ArrayList<TransactionDetail> details = new ArrayList<>();
                
                //Get transaction detail
                String transactionDetailQuery = "SELECT tanggal_kembali, denda, novel.*, kondisi.name FROM peminjaman_novel " +
                                                "INNER JOIN novel ON peminjaman_novel.novel_id = novel.id " +
                                                "INNER JOIN kondisi ON novel.kondisi_id = kondisi.id WHERE peminjaman_id = ?";

                //Create mysql prepared statement
                PreparedStatement transactionDetailPreparedStatement = con.prepareStatement(transactionDetailQuery);
                transactionDetailPreparedStatement.setInt(1, transactionId);
                
                if(transactionDetailPreparedStatement.execute()){
                    ResultSet transactionDetailResult = transactionDetailPreparedStatement.getResultSet();
                    
                    while(transactionDetailResult.next()){
                        
                        String returnDate = transactionDetailResult.getString(1);
                        int fine = transactionDetailResult.getInt(2);
                        
                        //Retrieve novel information
                        int novelId = transactionDetailResult.getInt(3);
                        String title = transactionDetailResult.getString(4);
                        String author = transactionDetailResult.getString(5);
                        String language = transactionDetailResult.getString(6);
                        String publisher = transactionDetailResult.getString(7);
                        String publicationDate = transactionDetailResult.getString(8);
                        int rentPrice = transactionDetailResult.getInt(9);
                        int pages = transactionDetailResult.getInt(10);
                        String isbn = transactionDetailResult.getString(11);
                        String kondisi = transactionDetailResult.getString(16);
                        String novelStatus = transactionDetailResult.getString(13);
                        String novelCreatedAt = transactionDetailResult.getString(14);
                        String updatedAt = transactionDetailResult.getString(15);

                        Novel novel = new Novel(novelId, title, author, language, publisher, publicationDate, rentPrice, pages, isbn,
                                                kondisi, novelStatus, novelCreatedAt, updatedAt); 

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
                        
                        details.add(new TransactionDetail(transactionId, novel, returnDate, fine));
                    }
                    
                    transaction.setTransactionDetails(details);
                }
                
                transactions.add(transaction);
            }
            
            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return transactions;
    }
    
    /**
     * Find transaction by id from storage
     * 
     * @param id int
     * @return ArrayList<Transaction>
     */
    public static ArrayList<Transaction> findById(int id){
        setConnection();
        
        ArrayList<Transaction> transactions = new ArrayList<>();
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement
            String query = "SELECT peminjaman.id, member.id, member.name, user.id, user.name, status, peminjaman.created_at FROM peminjaman " +
                            "INNER JOIN member ON peminjaman.member_id = member.id " +
                            "INNER JOIN user ON peminjaman.user_id = user.id " +
                            "WHERE peminjaman.id = ?";
            
            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            //Execute the prepared statement
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next()){
                int transactionId = result.getInt(1);
                int memberId = result.getInt(2);
                String memberName = result.getString(3);
                Member member = new Member();
                member.setId(memberId);
                member.setName(memberName);
                
                int userId = result.getInt(4);
                String userName = result.getString(5);
                User user = new User();
                user.setId(userId);
                user.setName(userName);
                
                String status = result.getString(6);
                String createdAt = result.getString(7);
    
                Transaction transaction = new Transaction(transactionId, member, user, status, createdAt);
                
                ArrayList<TransactionDetail> details = new ArrayList<>();
                
                //Get transaction detail
                String transactionDetailQuery = "SELECT tanggal_kembali, denda, novel.*, kondisi.name FROM peminjaman_novel " +
                                                "INNER JOIN novel ON peminjaman_novel.novel_id = novel.id " +
                                                "INNER JOIN kondisi ON novel.kondisi_id = kondisi.id WHERE peminjaman_id = ?";

                //Create mysql prepared statement
                PreparedStatement transactionDetailPreparedStatement = con.prepareStatement(transactionDetailQuery);
                transactionDetailPreparedStatement.setInt(1, transactionId);
                
                if(transactionDetailPreparedStatement.execute()){
                    ResultSet transactionDetailResult = transactionDetailPreparedStatement.getResultSet();
                    
                    while(transactionDetailResult.next()){
                        
                        String returnDate = transactionDetailResult.getString(1);
                        int fine = transactionDetailResult.getInt(2);
                        
                        //Retrieve novel information
                        int novelId = transactionDetailResult.getInt(3);
                        String title = transactionDetailResult.getString(4);
                        String author = transactionDetailResult.getString(5);
                        String language = transactionDetailResult.getString(6);
                        String publisher = transactionDetailResult.getString(7);
                        String publicationDate = transactionDetailResult.getString(8);
                        int rentPrice = transactionDetailResult.getInt(9);
                        int pages = transactionDetailResult.getInt(10);
                        String isbn = transactionDetailResult.getString(11);
                        String kondisi = transactionDetailResult.getString(16);
                        String novelStatus = transactionDetailResult.getString(13);
                        String novelCreatedAt = transactionDetailResult.getString(14);
                        String updatedAt = transactionDetailResult.getString(15);

                        Novel novel = new Novel(novelId, title, author, language, publisher, publicationDate, rentPrice, pages, isbn,
                                                kondisi, novelStatus, novelCreatedAt, updatedAt); 

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
                        
                        details.add(new TransactionDetail(transactionId, novel, returnDate, fine));
                    }
                    
                    transaction.setTransactionDetails(details);
                }
                
                transactions.add(transaction);
            }
            
            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return transactions;
    }
    
    /**
     * Store a new transaction to the storage
     * 
     * @param transaction Transaction
     * @return boolean
     */
    public static boolean create(Transaction transaction){
        setConnection();
        
        try{
            Statement statement = con.createStatement();
            
            //Transaction query statement
            String transactionQuery = "INSERT INTO peminjaman (member_id, user_id, status) VALUES (?,?,?)";
            
            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(transactionQuery, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, transaction.getMember().getId());
            preparedStatement.setInt(2, transaction.getUser().getId());
            preparedStatement.setString(3, transaction.getStatus());
            
            //Execute the query
            if(preparedStatement.executeUpdate() > 0){
                int transactionId = 0;
                
                ResultSet result = preparedStatement.getGeneratedKeys();
                if(result.next()){
                    transactionId = result.getInt(1);
                }
                
                ArrayList<TransactionDetail> transactionDetails = transaction.getTransactionDetails();
                
                for(int i = 0; i < transactionDetails.size(); i++){
                    //Insert transaction detail statement
                    String insertDetailQuery = "INSERT INTO peminjaman_novel (peminjaman_id, novel_id) VALUES (?,?)";
                    
                    //Create transaction detail prepared statement
                    PreparedStatement detailPreparedStatement = con.prepareStatement(insertDetailQuery);
                    detailPreparedStatement.setInt(1, transactionId);
                    detailPreparedStatement.setInt(2, transactionDetails.get(i).getNovel().getId());
                    
                    detailPreparedStatement.executeUpdate();
                    
                    //Update novel statement
                    String updateNovelQuery = "UPDATE novel SET status = ? WHERE id = ?";
                    
                    //Create update novel prepared statement
                    PreparedStatement updatePreparedStatement = con.prepareStatement(updateNovelQuery);
                    updatePreparedStatement.setString(1, "borrowed");
                    updatePreparedStatement.setInt(2, transactionDetails.get(i).getNovel().getId());
                    
                    updatePreparedStatement.executeUpdate();
                }
                
                return true;
            }
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    /**
     * Update an existing transaction from the storage
     * 
     * @param id
     * @param transaction
     * @return 
     */
    public static boolean update(int id, Transaction transaction){
        setConnection();
        
        try{
            Statement statement = con.createStatement();
            
            //Update transaction query statement
            String updateTransactionQuery = "UPDATE peminjaman SET status = ? WHERE id = ?";
            
            PreparedStatement preparedStatement = con.prepareStatement(updateTransactionQuery);
            preparedStatement.setString(1, transaction.getStatus());
            preparedStatement.setInt(2, id);
            
            if(preparedStatement.executeUpdate() > 0){                
                ArrayList<TransactionDetail> transactionDetails = transaction.getTransactionDetails();
                
                for(int i = 0; i < transactionDetails.size(); i++){
                    //Update transaction detail query statement
                    String detailQuery = "UPDATE peminjaman_novel SET tanggal_kembali = ?, denda = ? WHERE peminjaman_id = ? AND novel_id = ?";
                    
                    //Create update transaction detail prepared statement
                    PreparedStatement updatePreparedStatement = con.prepareStatement(detailQuery);
                    updatePreparedStatement.setString(1, transactionDetails.get(i).getReturnDate());
                    updatePreparedStatement.setInt(2, transactionDetails.get(i).getFine());
                    updatePreparedStatement.setInt(3, transactionDetails.get(i).getTransactionId());
                    updatePreparedStatement.setInt(4, transactionDetails.get(i).getNovel().getId());
                    
                    updatePreparedStatement.executeUpdate();
                    
                    //Update the return novel(s) to "available"
                    if(transactionDetails.get(i).getReturnDate() != null){
                        String novelQuery = "UPDATE novel SET status = 'available' WHERE id = ?";
                        
                        PreparedStatement novelPreparedStatement = con.prepareStatement(novelQuery);
                        novelPreparedStatement.setInt(1, transactionDetails.get(i).getNovel().getId());
                        
                        novelPreparedStatement.executeUpdate();
                    }
                }
                
                return true;
            }
            
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
