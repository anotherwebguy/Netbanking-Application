/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontpage;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Mohit
 */
public class MoreController implements Initializable {

   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void insurance(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/frontpage/Insurance.fxml"));
        JFXDecorator decorator = new JFXDecorator(stage, root, false, false, true);
        decorator.setCustomMaximize(false);
        decorator.setBorder(Border.EMPTY);
        
        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(decorator);
        
        stage.setScene(scene);
        stage.setIconified(false);

        stage.show();
    }

    @FXML
    private void water(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/frontpage/Water.fxml"));
        JFXDecorator decorator = new JFXDecorator(stage, root, false, false, true);
        decorator.setCustomMaximize(false);
        decorator.setBorder(Border.EMPTY);
        
        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(decorator);
        
        stage.setScene(scene);
        stage.setIconified(false);

        stage.show();
        
    }

    @FXML
    private void flight(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/frontpage/air.fxml"));
        JFXDecorator decorator = new JFXDecorator(stage, root, false, false, true);
        decorator.setCustomMaximize(false);
        decorator.setBorder(Border.EMPTY);
        
        stage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(decorator);
        
        stage.setScene(scene);
        stage.setIconified(false);

        stage.show();
    }
    
}
