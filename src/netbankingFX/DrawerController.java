/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netbankingFX;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import login.NetbankingFX;

/**
 * FXML Controller class
 *
 * @author Mohit
 */
public class DrawerController implements Initializable {

    @FXML
    private JFXButton homebtn;
    @FXML
    private JFXButton orderbtn;
    @FXML
    private JFXButton aboutbtn;
    @FXML
    private JFXButton signoutbtn;
    @FXML
    private JFXButton exitbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    private void logOut(ActionEvent event) {
        try {
            Stage window=(Stage) exitbtn.getScene().getWindow();
            NetbankingFX netbankingFX=new NetbankingFX();
            netbankingFX.start(new Stage());
            window.close();
        } catch (Exception ex) {
            Logger.getLogger(DrawerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
    }
}
