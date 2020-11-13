/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netbankingFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Mohit
 */
public class WelcomeController implements Initializable {

    @FXML
    private HBox toppane;
    @FXML
    private Button addmoney;
    @FXML
    private Button wallet;
    @FXML
    private Button more;
    @FXML
    private VBox holdpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
            AnchorPane add = FXMLLoader.load(getClass().getResource("/frontpage/moneyadd.fxml"));
            AnchorPane walletmoney = FXMLLoader.load(getClass().getResource("/frontpage/walletin.fxml"));
            AnchorPane morebtn = FXMLLoader.load(getClass().getResource("/frontpage/more.fxml"));
            setNode(add);
            for (Node node : toppane.getChildren()) {
                if (node.getAccessibleText() != null) {
                    node.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent ev) -> {
                        switch (node.getAccessibleText()) {
                            case "addMenu":
                                setNode(add);
                                break;
                            case "walletMenu":
                                setNode(walletmoney);
                                break;
                            case "moreMenu":
                                setNode(morebtn);
                                break;    
                                                  
                        }
                    });
                }
             } 
            
        } catch (IOException ex) {
            Logger.getLogger(HomeViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   
    
     private void setNode(Node node) {
        holdpane.getChildren().clear();
        holdpane.getChildren().add((Node) node);
    }
    
}
