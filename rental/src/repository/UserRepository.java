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
import model.User;

public class UserRepository {
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
     * Retrieve all users from storage
     * 
     * @return ArrayList<User>
     */
    public static ArrayList<User> findAll(){
        setConnection();
        
        ArrayList<User> users = new ArrayList<>();
        
        try{
            //Preparing for DB query
            Statement statement = con.createStatement();
        
            ResultSet result = statement.executeQuery(
                    "SELECT user.id, role.name, user.name, username, password, " +
                    "email, dob, phone, address FROM user " +
                    "INNER JOIN role ON user.role_id = role.id");

            while(result.next()){
                int userId = result.getInt(1);
                String role = result.getString(2);
                String name = result.getString(3);
                String username = result.getString(4);
                String password = result.getString(5);
                String email = result.getString(6);
                String dob = result.getString(7);
                String phone = result.getString(8);
                String address = result.getString(9);
    
                User user = new User(userId, role, name, username, password, email, dob, phone, address);
                
                users.add(user);
            }
            
            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return users;
    }
    
    /**
     * Find user by id from storage
     * 
     * @param id int
     * @return User
     */
    public static User findById(int id){
        setConnection();
        
        User user = null;
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement
            String query = "SELECT user.id, role.name, user.name, username, password, " +
                            "email, dob, phone, address FROM user " +
                            "INNER JOIN role ON user.role_id = role.id " + 
                            "WHERE user.id = ?";

            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            //Execute the prepared statement
            if(preparedStatement.execute()){
                ResultSet result = preparedStatement.getResultSet();
                
                result.next();
                
                int userId = result.getInt(1);
                String role = result.getString(2);
                String name = result.getString(3);
                String username = result.getString(4);
                String password = result.getString(5);
                String email = result.getString(6);
                String dob = result.getString(7);
                String phone = result.getString(8);
                String address = result.getString(9);

                user = new User(userId, role, name, username, password, email, dob, phone, address);
            }
            
            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return user;
    }
    
    /**
     * Find user by id from storage
     * 
     * @param id int
     * @return User
     */
    public static User findByUsername(String usr){
        setConnection();
        
        User user = null;
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement
            String query = "SELECT user.id, role.name, user.name, username, password, " +
                            "email, dob, phone, address FROM user " +
                            "INNER JOIN role ON user.role_id = role.id " + 
                            "WHERE user.username = ?";

            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, usr);
            
            //Execute the prepared statement
            ResultSet result = preparedStatement.executeQuery();
            
            result.next();
            
            int userId = result.getInt(1);
            String role = result.getString(2);
            String name = result.getString(3);
            String username = result.getString(4);
            String password = result.getString(5);
            String email = result.getString(6);
            String dob = result.getString(7);
            String phone = result.getString(8);
            String address = result.getString(9);

            user = new User(userId, role, name, username, password, email, dob, phone, address);
            
            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return user;
    }
    
    /**
     * Store a new user to the storage
     * 
     * @param user User
     * @return boolean
     */
    public static boolean create(User user){
        setConnection();
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement
            String query = "INSERT INTO user (role_id, name, username, password, email, "
                    + "dob, phone, address) VALUES (?,?,?,?,?,?,?,?)";
            
            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            switch(user.getRole()){
                case "Admin":
                    preparedStatement.setInt(1, 1);
                    break;
                case "Pegawai":
                    preparedStatement.setInt(1, 2);
                    break;
                default:
                    preparedStatement.setInt(1, 0);
            }
            preparedStatement.setString(2, user.getName());            
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getDob());
            preparedStatement.setString(7, user.getPhone());
            preparedStatement.setString(8, user.getAddress());
            
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
     * Update an existing user from the storage
     * 
     * @param id int
     * @param user User
     * @return boolean
     */
    public static boolean update(int id, User user){
        setConnection();
        
        try {
            Statement statement = con.createStatement();
            
            //Query statement
            String query = "UPDATE user SET role_id = ?, name = ?, username = ?, password = ?, "
                    + "email = ?, dob = ?, phone = ?, address = ? WHERE id = ?";
            
            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            switch(user.getRole()){
                case "Admin":
                    preparedStatement.setInt(1, 1);
                    break;
                case "Pegawai":
                    preparedStatement.setInt(1, 2);
                    break;
                default:
                    preparedStatement.setInt(1, 0);
            }
            preparedStatement.setString(2, user.getName());            
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getDob());
            preparedStatement.setString(7, user.getPhone());
            preparedStatement.setString(8, user.getAddress());
            preparedStatement.setInt(9, id);
            
            if(preparedStatement.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    /**
     * Destroy an existing user from storage
     * 
     * @param id
     * @return 
     */
    public static boolean destroy(int id){
        setConnection();
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement 
            String query = "DELETE FROM user WHERE id = ?";
            
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
