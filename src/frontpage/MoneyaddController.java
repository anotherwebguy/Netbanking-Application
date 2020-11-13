/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontpage;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXSpinner;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import login.NetbankingFX;

/**
 * FXML Controller class
 *
 * @author Mohit
 */
public class MoneyaddController implements Initializable {

    @FXML
    private TextField txtacc;
    @FXML
    private TextField txtamt;
    @FXML
    private Label L1;
    @FXML
    private JFXSpinner spin;
    
    String pass ;
    @FXML
    private TextField ot;
    @FXML
    private JFXDatePicker date;
    @FXML
    private Label L2;
    
    NetbankingFX net = new NetbankingFX();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
         
         spin.setVisible(false);
    }    

    @FXML
    private void otpgen(ActionEvent event) {
        pass = toString(OTP());
        L1.setText(pass);
    }

    @FXML
    private void submit(ActionEvent event) {
        if(ot.getText().equals(pass)){
            spin.setVisible(true);
            L2.setText(" ");
            PauseTransition pauseTransition = new PauseTransition();
            pauseTransition.setDuration(Duration.seconds(5));
            String name = "Mohit";
            net.addwallet(name,txtamt.getText());
            int bo = Integer.parseInt(txtamt.getText());
            net.updatewalbalance(bo);
            
        } else{
            L2.setText("Incorrect Otp");
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
        txtacc.setText(" ");
        txtamt.setText(" ");
        L1.setText(" ");
        ot.setText(" ");
        L2.setText(" ");
        
    }
    
    static char[] OTP(){
        int otplen = 5;
        String otpcontains = "0123456789abcdefghijk";
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

    
}
