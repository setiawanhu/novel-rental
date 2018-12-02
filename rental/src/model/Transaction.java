/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author setiawanhu
 */
public class Transaction {
    int id;
    Member member;
    User user;
    String status;
    String createdAt;
    ArrayList<TransactionDetail> transactionDetails;

    public Transaction(Member member, User user, String status) {
        this.id = id;
        this.member = member;
        this.user = user;
        this.status = status;
    }

    public Transaction(int id, Member member, User user, String status, String createdAt) {
        this.id = id;
        this.member = member;
        this.user = user;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public ArrayList<TransactionDetail> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(ArrayList<TransactionDetail> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }
}
