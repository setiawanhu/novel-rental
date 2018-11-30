/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

public class Novel {
    private int id;
    private String title;
    private String author;
    private String language;
    private String publisher;
    private String publicationDate;
    private int rentPrice;
    private int pages;
    private String isbn;
    private String kondisi;
    private String status;
    private String createdAt;
    private String updatedAt;

    /**
     * The novel model constructor
     * 
     */
    public Novel(){   
    }

    /**
     * The novel model constructor
     * 
     * @param id
     * @param title
     * @param author
     * @param language
     * @param publisher
     * @param publicationDate
     * @param rentPrice
     * @param pages
     * @param isbn
     * @param kondisi
     * @param status
     * @param createdAt
     * @param updatedAt 
     */
    public Novel(int id, String title, String author, String language, String publisher, String publicationDate, int rentPrice, int pages, String isbn, String kondisi, String status, String createdAt, String updatedAt) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.language = language;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.rentPrice = rentPrice;
        this.pages = pages;
        this.isbn = isbn;
        this.kondisi = kondisi;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    
}
