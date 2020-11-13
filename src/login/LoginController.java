/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author Mohit
 */
public class LoginController implements Initializable {
    
   
    @FXML
    private Label label;
    @FXML
    private JFXTextField txtUsername;
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private JFXSpinner loggingProgress;
    @FXML
    private Label L1;
    
  
    
    NetbankingFX net = new NetbankingFX();
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException{
       
                if(net.isLogin(txtUsername.getText(), txtPassword.getText())){
                    loggingProgress.setVisible(true);
                    L1.setText(" ");
                    PauseTransition pauseTransition = new PauseTransition();
                    pauseTransition.setDuration(Duration.seconds(5));
                    pauseTransition.setOnFinished(ev-> {
                        System.out.println("logging In");
                        try {
                            completeLogin();
                        } catch (IOException ex) {
                            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                    pauseTransition.play();
                }else{
                    L1.setText("x Incorrect Username or Password");
                }
            
            
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          loggingProgress.setVisible(false);
    }    

   
    private void completeLogin() throws IOException{
          Stage primaryStage = new Stage();
          Parent root = FXMLLoader.load(getClass().getResource("/netbankingFX/HomeView.fxml"));
         
          primaryStage.initStyle(StageStyle.UNDECORATED);
          Scene scene = new Scene(root);
          
          primaryStage.setScene(scene);
          primaryStage.setIconified(false);
          primaryStage.show();
          
          btnLogin.getScene().getWindow().hide();
          System.out.println("Login Success");
        
    }

    @FXML
    private void Signup(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/login/SignUpForm.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    
   
    
}
