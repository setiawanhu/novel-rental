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
import model.Member;

public class MemberRepository {
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
     * Retrieve all members from storage
     * 
     * @return ArrayList<Member>
     */
    public static ArrayList<Member> findAll(){
        setConnection();
        
        ArrayList<Member> members = new ArrayList<>();
        
        try{
            //Preparing for DB query
            Statement statement = con.createStatement();
        
            ResultSet result = statement.executeQuery("SELECT * FROM member");

            while(result.next()){
                int memberId = result.getInt(1);
                String name = result.getString(2);
                String email = result.getString(3);
                String phone = result.getString(4);
                String address = result.getString(5);
                String dob = result.getString(6);
    
                Member member = new Member(memberId, name, email, phone, address, dob);
                
                members.add(member);
            }
            
            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return members;
    }
    
    /**
     * Find member by id from storage
     * 
     * @param id int
     * @return Member
     */
    public static Member findById(int id){
        setConnection();
        
        Member member = null;
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement
            String query = "SELECT * FROM member WHERE id = ?";

            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            
            //Execute the prepared statement
            if(preparedStatement.execute()){
                ResultSet result = preparedStatement.getResultSet();
                
                result.next();
                
                int memberId = result.getInt(1);
                String name = result.getString(2);
                String email = result.getString(3);
                String phone = result.getString(4);
                String address = result.getString(5);
                String dob = result.getString(6);
    
                member = new Member(memberId, name, email, phone, address, dob);
            }
            
            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return member;
    }
    
    /**
     * Find member by name keyword from storage
     * 
     * @param id String
     * @return ArrayList<Member>
     */
    public static ArrayList<Member> findById(String id){
        setConnection();
        
        ArrayList<Member> members = new ArrayList<>();
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement
            String query = "SELECT * FROM member WHERE id LIKE ?";

            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, "%"+id+"%");
            
            //Execute the prepared statement
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next()){
                int memberId = result.getInt(1);
                String name = result.getString(2);
                String email = result.getString(3);
                String phone = result.getString(4);
                String address = result.getString(5);
                String dob = result.getString(6);
    
                members.add(new Member(memberId, name, email, phone, address, dob));
            }

            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return members;
    }
    
    /**
     * Find member by name keyword from storage
     * 
     * @param usr String
     * @return ArrayList<Member>
     */
    public static ArrayList<Member> findByName(String usr){
        setConnection();
        
        ArrayList<Member> members = new ArrayList<>();
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement
            String query = "SELECT * FROM member WHERE name LIKE ?";

            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, "%"+usr+"%");
            
            //Execute the prepared statement
            ResultSet result = preparedStatement.executeQuery();
            
            while(result.next()){
                int memberId = result.getInt(1);
                String name = result.getString(2);
                String email = result.getString(3);
                String phone = result.getString(4);
                String address = result.getString(5);
                String dob = result.getString(6);
    
                members.add(new Member(memberId, name, email, phone, address, dob));
            }

            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return members;
    }
    
    /**
     * Store a new member to the storage
     * 
     * @param member Member
     * @return boolean
     */
    public static boolean create(Member member){
        setConnection();
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement
            String query = "INSERT INTO member (name, email, phone, address, dob) VALUES(?,?,?,?,?)";
            
            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, member.getName());
            preparedStatement.setString(2, member.getEmail());
            preparedStatement.setString(3, member.getPhone());
            preparedStatement.setString(4, member.getAddress());
            preparedStatement.setString(5, member.getDob());
            
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
     * Update an existing member from the storage
     * 
     * @param id int
     * @param member Member
     * @return boolean
     */
    public static boolean update(int id, Member member){
        setConnection();
        
        try {
            Statement statement = con.createStatement();
            
            //Query statement
            String query = "UPDATE member SET name = ?, email = ?, phone = ?, address = ?, dob = ? WHERE id = ?";
            
            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, member.getName());
            preparedStatement.setString(2, member.getEmail());
            preparedStatement.setString(3, member.getPhone());
            preparedStatement.setString(4, member.getAddress());
            preparedStatement.setString(5, member.getDob());
            preparedStatement.setInt(6, id);
            
            if(preparedStatement.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return false;
    }
    
    /**
     * Destroy an existing member from storage
     * 
     * @param id
     * @return 
     */
    public static boolean destroy(int id){
        setConnection();
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement 
            String query = "DELETE FROM member WHERE id = ?";
            
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
