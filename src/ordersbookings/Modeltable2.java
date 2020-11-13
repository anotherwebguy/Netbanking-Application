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
public class Modeltable2 {
    String transfered,to,acc,amt;

    public Modeltable2(String transfered, String to, String acc, String amt) {
        this.transfered = transfered;
        this.to = to;
        this.acc = acc;
        this.amt = amt;
    }

    public String getTransfered() {
        return transfered;
    }

    public void setTransfered(String transfered) {
        this.transfered = transfered;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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
