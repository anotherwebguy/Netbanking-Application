/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordersbookings;

/**
 *
 * @author Mohit
 */
public class Modeltable3 {
    String recieved,from,acc,amt;

    public Modeltable3(String recieved, String from, String acc, String amt) {
        this.recieved = recieved;
        this.from = from;
        this.acc = acc;
        this.amt = amt;
    }

    public String getRecieved() {
        return recieved;
    }

    public void setRecieved(String recieved) {
        this.recieved = recieved;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }
    
}
