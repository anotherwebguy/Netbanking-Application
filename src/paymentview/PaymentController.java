/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paymentview;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author Mohit
 */
public class PaymentController implements Initializable {

   
    @FXML
    private JFXComboBox<String> C1;
  
    
    ObservableList<String> list1 = FXCollections.observableArrayList("Mobile Recharge","DTH Recharge","Electricity Bill Payment","Transfer to Another Account");
    @FXML
    private ToggleGroup cash;
    @FXML
    private AnchorPane hpane;
    @FXML
    private AnchorPane capane;
    @FXML
    private JFXRadioButton E1;
    @FXML
    private JFXRadioButton B1;
    @FXML
    private JFXRadioButton C2;
    @FXML
    private JFXTextField pin;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        C1.setItems(list1);
        pin.setVisible(false);
      
    }    

    @FXML
    private void combo(ActionEvent event) {
        try{
            AnchorPane rec = FXMLLoader.load(getClass().getResource("/paymentview/recharge.fxml"));
            AnchorPane dt = FXMLLoader.load(getClass().getResource("/paymentview/Dth.fxml"));
            AnchorPane elect = FXMLLoader.load(getClass().getResource("/paymentview/electricity.fxml"));
            AnchorPane trans = FXMLLoader.load(getClass().getResource("/paymentview/transfer.fxml"));
            setNode(rec);
            if (C1.getValue() != null) {
                    
                        switch (C1.getValue()) {
                            case "Mobile Recharge":
                                setNode(rec);
                                break;
                            case "DTH Recharge":
                                setNode(dt);
                                break;
                            case "Electricity Bill Payment":
                                setNode(elect);
                                break; 
                            case "Transfer to Another Account":
                                setNode(trans);
                                break;     
                                
                                                  
                        }
                   
                }
            
        } catch (IOException ex){
             Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void radioselect(ActionEvent event){
        if(B1.isSelected()){
            pin.setVisible(true);
        }
        else if(C2.isSelected()){
            pin.setVisible(false);
            try{
                AnchorPane card = FXMLLoader.load(getClass().getResource("/paymentview/card.fxml"));
                setNode1(card);
            } catch (IOException ex) {
                Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        else{
            pin.setVisible(false);
        }
    }
    
     private void setNode(Node node) {
        hpane.getChildren().clear();
        hpane.getChildren().add((Node) node);
    }
    
     private void setNode1(Node node) {
        capane.getChildren().clear();
        capane.getChildren().add((Node) node);
    }
     
   
    @FXML
    private void recordpayment(ActionEvent event)
    {
        
      
    }
}
