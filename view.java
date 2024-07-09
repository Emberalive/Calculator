import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.*;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import java.util.Arrays;

public class view {
    TextField equation;
    TilePane numPad;
    Button button;
    int H = 415;
    int W = 350;

    public void start(Stage window){
        /*Swing.utilities.invokeLater(()-> {
            
        });*/
        //this is where the GUI happens
        //where everything that is cool on the GUI is initialised
        
        VBox root = new VBox(); //learn what these do
        HBox hbox = new HBox();
        HBox buttons1 = new HBox();
        HBox buttons2 = new HBox();
        HBox buttons3 = new HBox();
        HBox buttons4 = new HBox();
        
        
        //Hbox
        hbox.setAlignment(Pos.CENTER); //center the HBox
        root.getChildren().add(hbox); //adds HBox to VBox
        
        //button layout
        root.getChildren().add(buttons1);
        buttons1.setAlignment(Pos.CENTER);
        root.getChildren().add(buttons2);
        buttons2.setAlignment(Pos.CENTER);
        root.getChildren().add(buttons3);
        buttons3.setAlignment(Pos.CENTER);
        root.getChildren().add(buttons4);
        buttons4.setAlignment(Pos.CENTER);
        
        //root
        root.setId("root");
        
        //equation (TextField) 
        equation = new TextField();
        equation.setId("equation");
        equation.setAlignment(Pos.CENTER_RIGHT);
        hbox.getChildren().add(equation); //adds equation(TextField) to hbox
        equation.setEditable(false);
        
        //buttons (num pad)
        for (int i = 7; i <=9; i++){
            Button button = new Button(String.valueOf(i));
            button.setId("button");
            button.setOnAction(this::handle);
            buttons1.getChildren().add(button);
        }

        for (int i = 4; i <=6; i++){
            Button button = new Button(String.valueOf(i));
            button.setId("button");
            button.setOnAction(this::handle);
            buttons2.getChildren().add(button);
        }

        for (int i = 1; i <=3; i++){
            Button button = new Button(String.valueOf(i));
            button.setId("button");
            button.setOnAction(this::handle);
            buttons3.getChildren().add(button);
        }

        String [] button4 =
            {"0", "."};        
        for (String label : button4){
            Button button = new Button(label);
            button.setId("button");
            button.setOnAction(this::handle);
            buttons4.getChildren().add(button);
        }

        
        
        //buttons (functions)
        Button button1 = new Button("x");
        button1.setId("button1");
        buttons1.getChildren().add(button1);
        
        Button button2 = new Button("-");
        button2.setId("button2");
        buttons2.getChildren().add(button2);
        
        Button button3 = new Button("+");
        button3.setId("button3");
        buttons3.getChildren().add(button3);
        
        Button button6 = new Button ("BCK");
        button6.setId("button6");
        buttons4.getChildren().add(button6);
        button6.setOnAction(this::back);
        
        Button button5 = new Button("=");
        button5.setId("button5");
        buttons4.getChildren().add(button5);
        

        
        
        
        
        Scene scene = new Scene(root, W , H);
        scene.getStylesheets().add("calculator.css");
        window.setScene(scene);
        window.setTitle("Calculator");
        window.show();
    }
    
    public void handle(ActionEvent event){
        if (event.getSource() instanceof Button){
            Button button = ((Button) event.getSource());
            String number = button.getText();
            String currentText = equation.getText();
            String newText = currentText + number;
            equation.setText(newText);
        }
    }
    
    public void back (ActionEvent event){
        if (event.getSource() instanceof Button){
            Button button6 = ((Button) event.getSource());
            String currentText = equation.getText();
            
            String newText = currentText.substring(0, currentText.length() - 1);
            equation.setText(newText);
        }
    }
    
    
    


    /*public void Addition(ActionEvent add){

    }


    public void Subtraction(ActionEvent sub) {

    }


    public void Multiplication(ActionEvent multi) {

    }*/
}
