
package calculator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import updater.DownloadSFTP;
import updater.FXMLUpdater;

/**
 *
 * @author Bluechip
 */
public class FXMLCalculatorController implements Initializable {
    FXMLUpdater updater = new FXMLUpdater();
    
    @FXML
    private Label label;
    double num1 = 0.0;
    double num2 = 0;
    String op = "";
    String value = "";
    Function cal = new Function();
    
    
    @FXML
    public void getValues(ActionEvent event) {      
        value = value + ((Button)event.getSource()).getText();
        label.setText(value);        
    }
    
    @FXML
    public void getOperator(ActionEvent event) {
        String op2 = ((Button)event.getSource()).getText();
        value = "";
        
        if (!op2.equals("=")){
            if (!op.isEmpty())
                return;
            
            op = op2;
          
            num1 = Double.valueOf(label.getText());  
            label.setText(String.valueOf(op));
            
        }
        else{
            num2 = Double.valueOf(label.getText());
            if(num1 == 0 && op.equals(""))
                label.setText("0");
            
            label.setText((cal.cal(num1, num2, op)));
            num1 = 0;
            num2 = 0;
            value = "";
            op = "";
            
        }
      
    }
    
    @FXML
    public void getUpdates(ActionEvent event) throws IOException, Throwable {  
                    
        updater.runUpdater(); //Run update checker
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
