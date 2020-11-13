/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netbankingFX;

import com.jfoenix.controls.JFXDecorator;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Mohit
 */
public class CoverController implements Initializable {

    @FXML
    private Button btnPro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/login/Login.fxml"));
        JFXDecorator decorator = new JFXDecorator(stage, root, false, false, true);
        decorator.setCustomMaximize(false);
        decorator.setBorder(Border.EMPTY);
        
        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(decorator);
        
        stage.setScene(scene);
        stage.setIconified(false);

        stage.show();
        
        btnPro.getScene().getWindow().hide();
        System.out.println("Welcome to our Project");
    }
    
}
