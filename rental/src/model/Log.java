package model;

public class Log {
    int id;
    int userId;
    String username;
    String tableName;
    String activity;
    String createdAt;

    public Log(int id, String username, String tableName, String activity, String createdAt) {
        this.id = id;
        this.username = username;
        this.tableName = tableName;
        this.activity = activity;
        this.createdAt = createdAt;
    }

    public Log(int id, int userId, String tableName, String activity) {
        this.id = id;
        this.userId = userId;
        this.tableName = tableName;
        this.activity = activity;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
