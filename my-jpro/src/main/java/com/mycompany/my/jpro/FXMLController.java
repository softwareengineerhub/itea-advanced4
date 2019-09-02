package com.mycompany.my.jpro;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FXMLController implements Initializable {
    
    @FXML
    private Label label;
    String textValue;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText(textValue);
        
        
        
        Platform.runLater(new Runnable(){
        // ...
            
            public void run(){
                
            }
            
        });
        
        
        
        Thread t = new Thread(){
            
            @Override
            public void run(){
                while(true){
                    try {
                        Thread.sleep(3000);
                        textValue="Change: "+System.currentTimeMillis();
                        System.out.println("Here");
                        
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        };
        t.start();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
