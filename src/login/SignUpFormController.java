/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.net.URL;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mohit
 */
public class SignUpFormController implements Initializable {

    @FXML
    private ComboBox<String> C1;
    @FXML
    private TextField textname;
    @FXML
    private TextField textnumber;
    @FXML
    private TextField textmail;
    @FXML
    private TextField txtid;
    @FXML
    private TextField txtpass;
    @FXML
    private TextField txtacc;
    @FXML
    private TextField txtbalance;
    @FXML
    private Button btnclicked;
    
    @FXML
    private TextField txtpin;
    
    ObservableList<String> list1 = FXCollections.observableArrayList("Mr.","Mrs.");
    @FXML
    private Label label;
    
    NetbankingFX net = new NetbankingFX();
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        C1.setItems(list1);
    }    

    @FXML
    private void btnAction(ActionEvent event) {
        try{
            int bal = Integer.parseInt(txtbalance.getText());
            net.Signup(textname.getText(),txtid.getText(), txtpass.getText(), txtacc.getText(), txtpin.getText(), bal);
            label.setText("Successfully Registered");
         } catch(Exception e){
             label.setText("Successfully Registered");
             System.out.println(e.getMessage());
         }
    }
    
    
    
}
