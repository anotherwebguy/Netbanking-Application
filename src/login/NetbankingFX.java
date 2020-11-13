/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import com.jfoenix.controls.JFXDecorator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Mohit
 */
public class NetbankingFX extends Application {
    
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rst = null;
    static String mainname;
    static int walbal;
    static int accbal;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/netbankingFX/cover.fxml"));
        JFXDecorator decorator=new JFXDecorator(stage, root, false, false, true);
        decorator.setCustomMaximize(false);
        decorator.setBorder(Border.EMPTY);
        
        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(decorator);
        
        stage.setScene(scene);
        stage.setIconified(false);
        stage.show();
    }
    
    public NetbankingFX(){
        conn = NetbankingFX.ConnectDb();
        getbal();
        getacc();
    }
    
    //==============Setting up the Connection with sqlite database=============
    public static Connection ConnectDb(){
        try{
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:Accdetails.db";
            Connection conn = DriverManager.getConnection(url);
            System.out.println("connected");
            return conn;
        }catch(Exception e){
           System.out.println("not connn");
            return null;
        }
       
    }
    
    public static String getname(){
        return mainname;
    }
    
    
    
    public void getbal(){
        String sql = "SELECT * FROM Netbanking WHERE Username = ?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1,mainname);
            rst = pst.executeQuery();
            if(rst.next()){
                walbal = rst.getInt("Walletbalance");
                pst.close();
                rst.close();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public void getacc(){
        String sql = "SELECT * FROM Netbanking WHERE Username = ?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1,mainname);
            rst = pst.executeQuery();
            if(rst.next()){
                accbal = rst.getInt("Accbalance");
                pst.close();
                rst.close();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public static String getbalance(){
        return Integer.toString(walbal);
    }
    
    public static String getaccbal(){
        return Integer.toString(accbal);
    }
    
    public void refresh(){
        getbal();
        getacc();
    }
    
    //===============function to check login credentials===========================
    public boolean isLogin(String user, String pass) {
        String sql = "SELECT Username and Password FROM Netbanking WHERE Username = ? and Password = ?";
        mainname = user;
        System.out.println(mainname);
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1,user);
            pst.setString(2,pass);
            
            rst = pst.executeQuery();
            
            if(rst.isBeforeFirst()){
              
                pst.close();
                rst.close();
                return true;
            } else{
              
                pst.close();
                rst.close();
                return false;
            }
            
            
        } catch(Exception e){
           
            return false;
        }
    }
    
    public void Signup(String name,String id,String pass,String acc,String pin,int bal){
        String sql = "INSERT INTO Netbanking(Name,Username,Password,AccNo,AccPin,Accbalance,Walletbalance)VALUES(?,?,?,?,?,?,?)";
        
         try{
            
             pst = conn.prepareStatement(sql);
             pst.setString(1,name);
             pst.setString(2,id);
             pst.setString(3,pass);
             pst.setString(4,acc);
             pst.setString(5,pin);
             pst.setInt(6,bal);
             pst.setInt(7,0);
             pst.executeUpdate();
             rst.close();
             pst.close();
             
         } catch(Exception e){
            
             System.out.println(e.getMessage());
         }
    }
    
    //====================adding money to users account=====================
    public void addwallet(String name,String amt){
        String sql = "INSERT INTO Netbanking(Name,RecievedMoneyInfo,Fromacc,Fromaccno,Fromammountrecieved)Values(?,?,?,?,?)";
        
        try{
          
            pst = conn.prepareStatement(sql);
            pst.setString(1,mainname);
            pst.setString(2,"In wallet");
            pst.setString(3,"Self");
            pst.setString(4,"----");
            pst.setString(5,amt);
            
            pst.executeUpdate();
            
            rst.close();
            pst.close();
        } catch(Exception e){
          System.out.println(e.getMessage());
         }
    }
    
    //============updation of account and wallet balance=====================

    public void updatewalbalance(int bal) {
        
        String sql = "UPDATE Netbanking SET Walletbalance = Walletbalance + ? WHERE Username = ?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setInt(1,bal);
            pst.setString(2,mainname);
            pst.executeUpdate();
            
            rst.close();
            pst.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void updatewalbalancemin(int bal) {
        
        String sql = "UPDATE Netbanking SET Walletbalance = Walletbalance - ? WHERE Username = ?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setInt(1,bal);
            pst.setString(2,mainname);
            pst.executeUpdate();
            
            rst.close();
            pst.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void updateaccbalance(int bal,String acc) {
        
        String sql = "UPDATE Netbanking SET Accbalance =Accbalance + ? WHERE AccNo = ?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setInt(1,bal);
            pst.setString(2, acc);
            pst.executeUpdate();
            
            rst.close();
            pst.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void updateaccbalancemin(int bal) {
        
        String sql = "UPDATE Netbanking SET Accbalance =Accbalance - ? WHERE Username = ?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setInt(1,bal);
            pst.setString(2, mainname);
            pst.executeUpdate();
            
            rst.close();
            pst.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    //=============Inserting data into databases for all auxilary works done by netbanking app===============
    public void recharge(String number,String Operator,String Amount){
        String sql = "INSERT INTO Netbanking(Name,Paymentsinfo,Mobileno,Operator,ConsumerId,ConsumerNo,Board,Paymentsammount)VALUES(?,?,?,?,?,?,?,?)";
        try{
          
            pst = conn.prepareStatement(sql);
            pst.setString(1,mainname);
            pst.setString(2,"Mobile Recharge");
            pst.setString(3,number);
            pst.setString(4,Operator);
            pst.setString(5,"----");
            pst.setString(6,"----");
            pst.setString(7,"----");
            pst.setString(8,Amount);
            
            pst.executeUpdate();
            rst.close();
            pst.close();
        } catch(Exception e){
          System.out.println(e.getMessage());
         }
    }
    
    public void dth(String connum,String Operator,String Amount){
        String sql = "INSERT INTO Netbanking(Name,Paymentsinfo,Mobileno,Operator,ConsumerId,ConsumerNo,Board,Paymentsammount)VALUES(?,?,?,?,?,?,?,?)";
        try{
          
            pst = conn.prepareStatement(sql);
             pst.setString(1,mainname);
            pst.setString(2,"Dth Recharge");
            pst.setString(3,"----");
            pst.setString(4,Operator);
            pst.setString(5,connum);
            pst.setString(6,"----");
            pst.setString(7,"----");
            pst.setString(8,Amount);
            
            pst.executeUpdate();
            rst.close();
            pst.close();
        } catch(Exception e){
          System.out.println(e.getMessage());
         }
    }
    
    public void electricity(String connumber,String board,String Amount){
        String sql = "INSERT INTO Netbanking(Name,Paymentsinfo,Mobileno,Operator,ConsumerId,ConsumerNo,Board,Paymentsammount)VALUES(?,?,?,?,?,?,?,?)";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1,mainname);
            pst.setString(2,"Mobile Recharge");
            pst.setString(3,"----");
            pst.setString(4,"----");
            pst.setString(5,"----");
            pst.setString(6,connumber);
            pst.setString(7,board);
            pst.setString(8,Amount);
            
            pst.executeUpdate();
            rst.close();
            pst.close();
        } catch(Exception e){
          System.out.println(e.getMessage());
         }
    }
    
    public void trans(String to,String acc,String Amount){
        String sql = "INSERT INTO Netbanking(Name,Transfersinfo,ToAcc,TransAccno,TransAmmountpaid)VALUES(?,?,?,?,?)";
        try{
          
            pst = conn.prepareStatement(sql);
            pst.setString(1,mainname);
            pst.setString(2,"Transfer to Another account");
            pst.setString(3,to);
            pst.setString(4,acc);
            pst.setString(5,Amount);
            
            pst.executeUpdate();
            rst.close();
            pst.close();
        } catch(Exception e){
          System.out.println(e.getMessage());
         }
    }
   
    public void water(String connumber,String board,String Amount){
        String sql = "INSERT INTO Netbanking(Name,Paymentsinfo,Mobileno,Operator,ConsumerId,ConsumerNo,Board,Paymentsammount)VALUES(?,?,?,?,?,?,?,?)";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1,mainname);
            pst.setString(2,"Water bill Payment");
            pst.setString(3,"----");
            pst.setString(4,"----");
            pst.setString(5,"----");
            pst.setString(6,connumber);
            pst.setString(7,board);
            pst.setString(8,Amount);
            
            pst.executeUpdate();
            rst.close();
            pst.close();
        } catch(Exception e){
          System.out.println(e.getMessage());
         }
    }
    
    public void insurance(String to,String acc){
        String sql = "INSERT INTO Netbanking(Name,Transfersinfo,ToAcc,TransAccno,TransAmmountpaid)VALUES(?,?,?,?,?)";
        try{
          
            pst = conn.prepareStatement(sql);
            pst.setString(1,mainname);
            pst.setString(2,"Insurance");
            pst.setString(3,to);
            pst.setString(4,acc);
            pst.setString(5,"----");
            
            pst.executeUpdate();
            rst.close();
            pst.close();
        } catch(Exception e){
          System.out.println(e.getMessage());
         }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
