/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontpage;

import database.Database;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import login.NetbankingFX;

/**
 * FXML Controller class
 *
 * @author Mohit
 */
public class WalletinController implements Initializable {

    @FXML
    private Label label;
    
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rst = null;
    NetbankingFX net = new NetbankingFX();
    @FXML
    private Label label2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TOD
        conn=Database.connectDB();
        if(conn==null) System.exit(1);
        
        label.setText(net.getbalance());
        label2.setText(net.getaccbal());
    } 

    @FXML
    private void ref(ActionEvent event) {
        net.refresh();
        label.setText(net.getbalance());
        label2.setText(net.getaccbal());
    }
    
    
    }
    

