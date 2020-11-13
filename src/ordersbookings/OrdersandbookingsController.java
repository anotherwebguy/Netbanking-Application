/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordersbookings;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import database.Database;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import login.NetbankingFX;

/**
 * FXML Controller class
 *
 * @author Mohit
 */
public class OrdersandbookingsController implements Initializable {

    @FXML
    private TableColumn<Modeltable1, String> Pay_info;
    @FXML
    private TableColumn<Modeltable1, String> mob_no;
    @FXML
    private TableColumn<Modeltable1, String> operat;
    @FXML
    private TableColumn<Modeltable1, String> con_id;
    @FXML
    private TableColumn<Modeltable1, String> con_no;
    @FXML
    private TableColumn<Modeltable1, String> board;
    @FXML
    private TableColumn<Modeltable1, String> amt_paid;
    @FXML
    private ToggleGroup cash;
    @FXML
    private TextArea t1;
    @FXML
    private TableView<Modeltable1> table1;
    @FXML
    private TableView<Modeltable2> table2;
    @FXML
    private TableColumn<Modeltable2, String> trans_info;
    @FXML
    private TableColumn<Modeltable2, String> to;
    @FXML
    private TableColumn<Modeltable2, String> Acc_no1;
    @FXML
    private TableColumn<Modeltable2, String> Amt_paid1;
    @FXML
    private JFXTextField txtname;
    @FXML
    private JFXTextField txtamt;
    @FXML
    private TableView<Modeltable3> table3;
    @FXML
    private TableColumn<Modeltable3, String> recieved_info;
    @FXML
    private TableColumn<Modeltable3, String> from;
    @FXML
    private TableColumn<Modeltable3, String> Acc_no2;
    @FXML
    private TableColumn<Modeltable3, String> Amt_recieved;
    
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rst = null;
    
    String main;
    
    ObservableList<Modeltable1> oblist1 = FXCollections.observableArrayList();
    ObservableList<Modeltable2> oblist2 = FXCollections.observableArrayList();
    ObservableList<Modeltable3> oblist3 = FXCollections.observableArrayList();
    NetbankingFX net = new NetbankingFX();
    String bal,acc;
    @FXML
    private JFXRadioButton e;
    @FXML
    private JFXRadioButton b;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        bal = net.getbalance();
        acc = net.getaccbal();
        
         conn=Database.connectDB();
         if(conn==null) System.exit(1);
         main =  NetbankingFX.getname();
         
        
        Updatetable1();
        Pay_info.setCellValueFactory(new PropertyValueFactory<>("paymentinfo"));
        mob_no.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        operat.setCellValueFactory(new PropertyValueFactory<>("operator"));
        con_id.setCellValueFactory(new PropertyValueFactory<>("consumerid"));
        con_no.setCellValueFactory(new PropertyValueFactory<>("consumerno"));
        board.setCellValueFactory(new PropertyValueFactory<>("board"));
        amt_paid.setCellValueFactory(new PropertyValueFactory<>("amount"));
       
        
        Updatetable2();
        trans_info.setCellValueFactory(new PropertyValueFactory<>("transfered"));
        to.setCellValueFactory(new PropertyValueFactory<>("to"));
        Acc_no1.setCellValueFactory(new PropertyValueFactory<>("acc"));
        Amt_paid1.setCellValueFactory(new PropertyValueFactory<>("amt")); 
       
        
        Updatetable3();
        recieved_info.setCellValueFactory(new PropertyValueFactory<>("recieved"));
        from.setCellValueFactory(new PropertyValueFactory<>("from"));
        Acc_no2.setCellValueFactory(new PropertyValueFactory<>("acc"));
        Amt_recieved.setCellValueFactory(new PropertyValueFactory<>("amt"));
       
    }    

    @FXML
    private void record(ActionEvent event) {
        String sql = "INSERT INTO Netbanking(Name,TransfersInfo,ToAcc,TransAccno,TransAmmountpaid)Values(?,?,?,?,?)";
        
        try{
          
            pst = conn.prepareStatement(sql);
            pst.setString(1,main);
            pst.setString(2,"PM Cares Fund");
            pst.setString(3,"PM Cares Fund");
            pst.setString(4,"----");
            pst.setString(5,txtamt.getText());
            
            pst.executeUpdate();
            if(e.isSelected()){
                net.updatewalbalancemin(Integer.parseInt(txtamt.getText()));
            }
            else if(b.isSelected()){
                net.updateaccbalancemin(Integer.parseInt(txtamt.getText()));
            }
            Updatetable2();
            
           
            rst.close();
            pst.close();
        } catch(Exception e){
          System.out.println(e.getMessage());
         }
    }
    
    private void Updatetable1(){
        
        for (int i=0; i<table1.getItems().size(); i++){
            table1.getItems().clear();
        }
        String sql = "SELECT * FROM Netbanking WHERE Name = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,main);
            rst = pst.executeQuery();
            
            while(rst.next()){
                if(rst.getString("PaymentsInfo")!=null && rst.getString("Mobileno")!=null && rst.getString("Operator")!=null && rst.getString("ConsumerId")!=null && rst.getString("ConsumerNo")!=null && rst.getString("Board")!=null && rst.getString("Paymentsammount")!=null){
                     oblist1.add(new Modeltable1(rst.getString("PaymentsInfo"),rst.getString("Mobileno"),rst.getString("Operator"),rst.getString("ConsumerId"),rst.getString("ConsumerNo"),rst.getString("Board"),rst.getString("Paymentsammount")));
                }
            }
           
            rst.close();
         } catch (SQLException ex) {
            Logger.getLogger(OrdersandbookingsController.class.getName()).log(Level.SEVERE, null, ex);
        } 
         table1.setItems(oblist1); 
        
    }
    
    private void Updatetable2(){
        for (int i=0; i<table2.getItems().size(); i++){
            table2.getItems().clear();
        }
        String sql = "SELECT * FROM Netbanking WHERE Name = ?";
         try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,main);
            rst = pst.executeQuery();
            
            while(rst.next()){
                if(rst.getString("TransfersInfo")!=null && rst.getString("ToAcc")!=null && rst.getString("TransAccno")!=null && rst.getString("TransAmmountpaid")!=null){
                     oblist2.add(new Modeltable2(rst.getString("TransfersInfo"),rst.getString("ToAcc"),rst.getString("TransAccno"),rst.getString("TransAmmountpaid")));
                }
            }
         
            rst.close();
         } catch (SQLException ex) {
            Logger.getLogger(OrdersandbookingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        table2.setItems(oblist2);
    }
   
    public void Updatetable3(){
        for (int i=0; i<table3.getItems().size(); i++){
            table3.getItems().clear();
        }
        String sql = "SELECT * FROM Netbanking WHERE Name = ?";
         try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,main);
            rst = pst.executeQuery();
            
            while(rst.next()){
                if(rst.getString("RecievedMoneyInfo")!=null && rst.getString("Fromacc")!=null && rst.getString("Fromaccno")!=null && rst.getString("Fromammountrecieved")!=null){
                      oblist3.add(new Modeltable3(rst.getString("RecievedMoneyInfo"),rst.getString("Fromacc"),rst.getString("Fromaccno"),rst.getString("Fromammountrecieved")));
                }
            }
         
            rst.close();
         } catch (SQLException ex) {
            Logger.getLogger(OrdersandbookingsController.class.getName()).log(Level.SEVERE, null, ex);
        } 
         table3.setItems(oblist3);
    }

    @FXML
    private void print(ActionEvent event) {
        t1.setText("                                 \n"
                + "                                 \n"
                +"Your Netbanking e-Passbook records\n"
                + "==================================\n"
                + "ALL YOUR PAYMENTS HAVE BEEN RECORDED\n"
                + " SUCCESSFULLY.\n\n"
                + " Name:\t\t\t\t"+main+"\n"
                + " Account balance:\t\t"+acc+"\n"
                + " Wallet balance:\t\t"+bal+"\n\n"
                + "Thanks :) For using EasyGo Netbanking\n"
                + "Happy banking!!!!");
    }
   
    @FXML
    private void refersh(ActionEvent event) {
        Updatetable1();
        Updatetable2();
        Updatetable3();
    }

    
}
    

