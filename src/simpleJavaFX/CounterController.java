package simpleJavaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CounterController {

    @FXML
    private TextField tfOutput;

    @FXML
    private Button counter;
    
    private int c = 0;

    @FXML
    void count(ActionEvent event) {
    	c += 1;
    	tfOutput.setText(c + "");
    }

}

