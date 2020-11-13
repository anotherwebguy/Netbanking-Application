/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netbankingFX;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Mohit
 */
public class HomeViewController implements Initializable {

    @FXML
    private JFXHamburger hamburger;
    @FXML
    private Label txtCurrentWindow;
    @FXML
    private AnchorPane holderpane;
    @FXML
    private JFXDrawer drawer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();

            if (drawer.isShown()) {
                drawer.close();
            } else {
                drawer.open();
            }

        });
        try{
            VBox sidePane = FXMLLoader.load(getClass().getResource("/netbankingFX/Drawer.fxml"));
            AnchorPane orders = FXMLLoader.load(getClass().getResource("/ordersbookings/ordersandbookings.fxml"));
            AnchorPane payments = FXMLLoader.load(getClass().getResource("/paymentview/payment.fxml"));
            AnchorPane about = FXMLLoader.load(getClass().getResource("/aboutus/FXMLDocument.fxml"));
            AnchorPane login = FXMLLoader.load(getClass().getResource("/login/Login.fxml"));
            AnchorPane welcome = FXMLLoader.load(getClass().getResource("/netbankingFX/welcome.fxml"));
            setNode(welcome);
            drawer.setSidePane(sidePane);
            
             for (Node node : sidePane.getChildren()) {
                if (node.getAccessibleText() != null) {
                    node.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent ev) -> {
                        switch (node.getAccessibleText()) {
                            case "homeMenu":
                                drawer.close();
                                setNode(welcome);
                                break;
                            case "ordersMenu":
                                drawer.close();                               
                                setNode(orders);
                                break;
                            case "paymentMenu":
                                drawer.close();                               
                                setNode(payments);
                                break;    
                            case "aboutMenu":
                                drawer.close();
                                setNode(about);
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
        holderpane.getChildren().clear();
        holderpane.getChildren().add((Node) node);
    }
    
}
