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
public class Modeltable1 {
    
    String paymentinfo,mobile,operator,consumerid,consumerno,board,amount;

    public Modeltable1(String paymentinfo, String mobile, String operator, String consumerid, String consumerno, String board, String amount) {
        this.paymentinfo = paymentinfo;
        this.mobile = mobile;
        this.operator = operator;
        this.consumerid = consumerid;
        this.consumerno = consumerno;
        this.board = board;
        this.amount = amount;
    }

    public String getPaymentinfo() {
        return paymentinfo;
    }

    public void setPaymentinfo(String paymentinfo) {
        this.paymentinfo = paymentinfo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getConsumerid() {
        return consumerid;
    }

    public void setConsumerid(String consumerid) {
        this.consumerid = consumerid;
    }

    public String getConsumerno() {
        return consumerno;
    }

    public void setConsumerno(String consumerno) {
        this.consumerno = consumerno;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    
    
}
