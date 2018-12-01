/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Genre {
    private int id;
    private String name;
    private String createdAt;
    private String updatedAt;

    public Genre(int id, String name, String created_at, String updated_at) {
        this.id = id;
        this.name = name;
        this.createdAt = created_at;
        this.updatedAt = updated_at;
    }
    
    public Genre(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String created_at) {
        this.createdAt = created_at;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updated_at) {
        this.updatedAt = updated_at;
    }
}
