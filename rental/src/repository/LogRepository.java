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
import model.Log;

public class LogRepository {
    //String logQuery = "INSERT INTO log (user_id, table_name, activity) VALUES(?,?,?)";
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
     * Retrieve all logs from storage
     * 
     * @return ArrayList<Log>
     */
    public static ArrayList<Log> findAll(){
        setConnection();
        
        ArrayList<Log> logs = new ArrayList<>();
        
        try{
            //Preparing for DB query
            Statement statement = con.createStatement();
        
            ResultSet result = statement.executeQuery("SELECT log.id, user.username, table_name, activity, log.created_at FROM log " +
                                                      "INNER JOIN  user ON log.user_id = user.id");

            while(result.next()){
                int logId = result.getInt(1);
                String username = result.getString(2);
                String tableName = result.getString(3);
                String activity = result.getString(4);
                String createdAt = result.getString(5);
    
                Log log = new Log(logId, username, tableName, activity, createdAt);
                
                logs.add(log);
            }
            
            con.close();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
        return logs;
    }
    
    /**
     * Store a new log to the storage
     * 
     * @param log Log
     * @return boolean
     */
    public static boolean create(Log log){
        setConnection();
        
        try{
            Statement statement = con.createStatement();
            
            //Query statement
            String query = "INSERT INTO log (user_id, table_name, activity) VALUES(?,?,?)";
            
            //Create mysql prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, log.getUserId());
            preparedStatement.setString(2, log.getTableName());
            preparedStatement.setString(3, log.getActivity());
            
            //Execute the query
            if(preparedStatement.executeUpdate() > 0) {
                return true;
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
