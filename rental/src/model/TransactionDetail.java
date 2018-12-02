/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author setiawanhu
 */
public class TransactionDetail {
    int transactionId;
    Novel novel;
    String returnDate;
    int fine;

    public TransactionDetail(int transactionId, Novel novel, String returnDate, int fine) {
        this.transactionId = transactionId;
        this.novel = novel;
        this.returnDate = returnDate;
        this.fine = fine;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Novel getNovel() {
        return novel;
    }

    public void setNovel(Novel novel) {
        this.novel = novel;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
    
    
}
