package com.emberalive.calculator;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

public class View {
    TextField equation;
    TextField display;
    int H = 440;
    int W = 350;

    public void start(Stage window){
        /*Swing.utilities.invokeLater(()-> {
            
        });*/
        //this is where the GUI happens
        //where everything that is cool on the GUI is initialised
        
        VBox root = new VBox(); //learn what these do
        HBox display1 = new HBox();
        HBox hbox = new HBox();
        HBox buttons1 = new HBox();
        HBox buttons2 = new HBox();
        HBox buttons3 = new HBox();
        HBox buttons4 = new HBox();
        
        //display1
        display1.setAlignment(Pos.CENTER_RIGHT);
        root.getChildren().add(display1);
        
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
        
        //display  this will display the first half of any equation that will be done
        display = new TextField();
        display.setId("placeHolder");
        display.setAlignment(Pos.CENTER_RIGHT);
        display1.getChildren().add(display);
        display.setEditable(false);
        
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
            button.setOnAction(this::number);
            buttons1.getChildren().add(button);
        }
        for (int i = 4; i <=6; i++){
            Button button = new Button(String.valueOf(i));
            button.setId("button");
            button.setOnAction(this::number);
            buttons2.getChildren().add(button);
        }
        for (int i = 1; i <=3; i++){
            Button button = new Button(String.valueOf(i));
            button.setId("button");
            button.setOnAction(this::number);
            buttons3.getChildren().add(button);
        }
        String [] button4 =
            {"0", "."};        
        for (String label : button4){
            Button button = new Button(label);
            button.setId("button");
            button.setOnAction(this::number);
            buttons4.getChildren().add(button);
        }
        //buttons (dark gray ones)
        Button button1 = new Button("x");
        button1.setId("button1");
        buttons1.getChildren().add(button1);
        button1.setOnAction(this::mathyStuff);
        
        Button button2 = new Button("-");
        button2.setId("button2");
        buttons2.getChildren().add(button2);
        button2.setOnAction(this::mathyStuff);
        
        Button button3 = new Button("+");
        button3.setId("button3");
        buttons3.getChildren().add(button3);
        button3.setOnAction(this::mathyStuff);
        
        Button button5 = new Button ("BCK");
        button5.setId("button6");
        buttons4.getChildren().add(button5);
        button5.setOnAction(this::number);
        
        Button button6 = new Button("=");
        button6.setId("button5");
        buttons4.getChildren().add(button6);
        button6.setOnAction(this::equals);
        //clear button
        Button clear = new Button("clear");
        clear.setId("clearButton");
        display1.getChildren().add(clear);
        clear.setOnAction(this::number);
        
        
        
        
        
        Scene scene = new Scene(root, W , H);
        scene.getStylesheets().add("calculator.css");
        window.setScene(scene);
        window.setTitle("Calculator");
        window.show();
    }
    
    public void number(ActionEvent event){
        if (event.getSource() instanceof Button button){
            String number = button.getText();
            String currentText = equation.getText();
            String newText;
            switch( number ){
                case "1", "2", "3", "4", "5", "6", "7", "8", "9", "0":
                    newText = currentText + number;
                    equation.setText(newText);
                    break;
                case "BCK":
                    newText = currentText.substring(0, currentText.length() - 1);
                    equation.setText(newText);
                    break;     
                case "clear":
                    equation.setText("");
                    display.setText("");
                    break;
            }
        }
    }
    
    public void mathyStuff (ActionEvent event){
        if (event.getSource() instanceof Button){
            Button button = ((Button) event.getSource());
            String number = button.getText();
            String number1 = equation.getText();
            display.setText(number1 + number);
            
            equation.setText(""); 
        }
    }

    public void equals (ActionEvent event){
        //figuring out which mathamatical symbol is being used
        String number = display.getText();
        String equationType = number.substring(number.length() -1 );
        
        //getting numbers for the equation, and converting from String to int
        int num1 = Integer.valueOf(number.substring(0, number.length() -1));
        int num2 = Integer.valueOf(equation.getText());
        
        display.setText(number + num2);
        
        switch( equationType ){
            case "+":
                Addition(num1, num2);
                break;
            case "-":
                Subtraction(num1, num2);
                break;
            case "x":
                multiplication(num1, num2);
                break;
        }
    }
            public void Addition(int a, int b){
        int c = a + b;
        String d = String.valueOf(c);
        equation.setText(d);
    }
    public void Subtraction(int a, int b) {
        int c = a - b;
        String d = String.valueOf(c);
        equation.setText(d);
    }
        public void multiplication(int a, int b) {
        int c = a * b;
        String d = String.valueOf(c);
        equation.setText(d);
    }
}
