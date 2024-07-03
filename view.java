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
        
        //buttons
        for (int i = 7; i <=9; i++){
            Button button = new Button(String.valueOf(i));
            button.setId("button");
            //button.setOnAction( this::buttonClicked );
            buttons1.getChildren().add(button);
        }
        Button button1 = new Button("x");
        button1.setId("button1");
        buttons1.getChildren().add(button1);
        for (int i = 4; i <=6; i++){
            Button button = new Button(String.valueOf(i));
            button.setId("button");
            //button.setOnAction( this::buttonClicked );
            buttons2.getChildren().add(button);
        }
        Button button2 = new Button("-");
        button2.setId("button2");
        buttons2.getChildren().add(button2);
        for (int i = 1; i <=3; i++){
            Button button = new Button(String.valueOf(i));
            button.setId("button");
            //button.setOnAction( this::buttonClicked );
            buttons3.getChildren().add(button);
        }
        Button button3 = new Button("+");
        button3.setId("button3");
        buttons3.getChildren().add(button3);
        String [] button4 =
            {"0", ".", "BCK"};        
        for (String label : button4){
            Button button = new Button(label);
            button.setId("button");
            //button.setOnAction( this::buttonClicked );
            buttons4.getChildren().add(button);
        }
        Button button5 = new Button("=");
        button5.setId("button5");
        buttons4.getChildren().add(button5);
        
        Scene scene = new Scene(root, W , H);
        scene.getStylesheets().add("calculator.css");
        window.setScene(scene);
        window.setTitle("Calculator");
        window.show();
    }
    /*public void buttonClicked(ActionEvent event){
        //this will make something happen when one of the buttons on the number pad is clicked
    }


    public void Addition(ActionEvent add){

    }


    public void Subtraction(ActionEvent sub) {

    }


    public void Multiplication(ActionEvent multi) {

    }*/
}
