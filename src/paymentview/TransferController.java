/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paymentview;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import login.NetbankingFX;

/**
 * FXML Controller class
 *
 * @author Mohit
 */
public class TransferController implements Initializable {

    @FXML
    private JFXTextField to;
    @FXML
    private JFXTextField accno;
    NetbankingFX net = new NetbankingFX();
    @FXML
    private JFXTextField amt;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void save(ActionEvent event) {
        if(to.getText()!=null && accno.getText()!=null && amt.getText()!=null){
            net.trans(to.getText(), accno.getText(), amt.getText());
            net.updateaccbalance(Integer.parseInt(amt.getText()),accno.getText());
            net.updateaccbalancemin(Integer.parseInt(amt.getText()));
        }
    }
}
