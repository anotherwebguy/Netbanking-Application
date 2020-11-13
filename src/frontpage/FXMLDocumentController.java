/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontpage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import login.NetbankingFX;

/**
 *
 * @author avdho
 */
public class FXMLDocumentController implements Initializable {
    String pass;
    @FXML
    private Label L1;
    @FXML
    public JFXComboBox <String> combobox;
    ObservableList<String> list = FXCollections.observableArrayList("MahaVitran","MBMC","MCGM");
    @FXML
    private JFXTextField text;
    @FXML
    private JFXTextField cons;
    @FXML
    private JFXTextField text1;
    @FXML
    private Label cvv;
    @FXML
    private Label card;
    @FXML
    private JFXRadioButton btn;
    @FXML
    private JFXRadioButton btn1;
    @FXML
    private JFXTextField amount;
    @FXML
    private JFXTextField otp;
    @FXML
    private ToggleGroup board;
    @FXML
    private JFXDatePicker date;
    @FXML
    private JFXButton generate;
    @FXML
    private Label label;
    
    @FXML
    private JFXButton cls;
    @FXML
    private void otpgen(ActionEvent event) {
        pass = toString(OTP());
        L1.setText(pass);
    }
    
    NetbankingFX net = new NetbankingFX();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         combobox.setItems(list);
         text.setVisible(false);
         text1.setVisible(false);
         cvv.setVisible(false);
         card.setVisible(false);
    }
    
    static char[] OTP(){
        int otplen = 5;
        String otpcontains = "0123456789";
        Random random = new Random();
        char[] otp = new char[otplen];
        for(int i=0;i<otplen;i++){
            otp[i] = otpcontains.charAt(random.nextInt(otpcontains.length()));
        }
        return otp;
    }
    private String toString(char[] OTP) {
        String string = String.valueOf(OTP);
        return string;
    }
    @FXML
    public void access(ActionEvent event){
        if(btn1.isSelected()){
            text.setVisible(true);
            text1.setVisible(true);
            cvv.setVisible(true);
            card.setVisible(true);
        }
        else if(btn.isSelected()){
            text.setVisible(false);
            text1.setVisible(false);
            cvv.setVisible(false);
            card.setVisible(false);
        }
    }
    @FXML
    public void remove(ActionEvent event){
        text.setText("");
        text1.setText("");
        cons.setText("");
        amount.setText("");
        otp.setText("");
        date.setValue(null);
        combobox.valueProperty().setValue(null);
        if(btn.isSelected()){
            btn.setSelected(true);
            text.setVisible(false);
            text1.setVisible(false);
            cvv.setVisible(false);
            card.setVisible(false);
        }
        else if(btn1.isSelected()){
            btn1.setSelected(false);
            btn.setSelected(true);
            text.setVisible(false);
            text1.setVisible(false);
            cvv.setVisible(false);
            card.setVisible(false);
        }
    }

    @FXML
    private void submit(ActionEvent event) {
        if(otp.getText().equals(pass)){
            net.water(cons.getText(), combobox.getValue(), amount.getText());
            net.updatewalbalancemin(Integer.parseInt(amount.getText()));
        } else{
            L1.setText("wrong OTP");
        }
    }
}
