/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontpage;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author ANiket125
 */
public class AirController implements Initializable {
    
    private Label label;
    @FXML
    private ComboBox combo1;
    @FXML
    private ComboBox combo11;
    @FXML
    private DatePicker departdate;
    @FXML
    private DatePicker departdate1;
    @FXML
    private ComboBox combo2;
    @FXML
    private ToggleGroup board;
    
    ObservableList<String> list=FXCollections.observableArrayList("Delhi","Darbhanga","Mumbai","Hyderabad","Kolkata","Patna","Chennai","Ahmedabad","Lucknow","Jaipur","Pune");
    ObservableList<String> list2=FXCollections.observableArrayList("Economy","First Class","Business");
    ObservableList<String> list1=FXCollections.observableArrayList("Delhi","Darbhanga","Mumbai","Hyderabad","Kolkata","Patna","Chennai","Ahmedabad","Lucknow","Jaipur","Pune");
    int eco = 3000,first = 5000,business = 10000;
    @FXML
    private JFXTextField no;
    @FXML
    private TextArea t1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        combo1.setItems(list);
        combo2.setItems(list2);
        combo11.setItems(list1);
       }
    

    @FXML
    private void select(ActionEvent event) {
        String s=combo1.getSelectionModel().getSelectedItem().toString();
        
        
    }

    @FXML
    private void proceed(ActionEvent event) {
        float amt = (float) 0.00;
        String from = (String) combo1.getValue(),to = (String)combo11.getValue();
        int num = Integer.parseInt(no.getText());
        if(combo2.getValue()=="Economy"){
            amt = num*eco;
        } else if(combo2.getValue()=="First Class"){
            amt = num*first;
        } else if(combo2.getValue()=="Business"){
            amt = num*business;
        }
        String tic="Your Booked Flight E-ticket Info\n"
                    +"==================================\n"
                    +"From:\t"+from+"\n"
                    +"To:\t\t"+to+"\n"
                    +"Ammount:\t"+amt+"\n"
                    +"SUCCESSFULLY Booked\n"
                    +"Have a Safe Journey :)!!!!";
        t1.setText(tic);
    }

    
    
}
