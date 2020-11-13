/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paymentview;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import login.NetbankingFX;


/**
 * FXML Controller class
 *
 * @author Mohit
 */
public class RechargeController implements Initializable {

    @FXML
    private ToggleGroup cash;
    @FXML
    private JFXComboBox<String> C1;
    @FXML
    private JFXTextField txtmob;
    
    ObservableList<String> list = FXCollections.observableArrayList("Vodaphone","Airtel","Jio","Idea");
 
    NetbankingFX net = new NetbankingFX();
    @FXML
    private JFXTextField amt;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        C1.setItems(list);
    }    

    @FXML
    private void save(ActionEvent event) {
        if(txtmob.getText()!=null && C1.getItems()!=null && amt.getText()!=null){
            net.recharge(txtmob.getText(), C1.getValue(), amt.getText());
            net.updatewalbalancemin(Integer.parseInt(amt.getText()));
        }
    }
    
}
