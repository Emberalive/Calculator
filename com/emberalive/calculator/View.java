package com.emberalive.calculator;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

import java.util.Arrays;

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

        String[]
                button5 = {"BCK", "."};
        for (String label : button5) {
            Button button = new Button (label);
            button.setId("button7");
            buttons4.getChildren().add(button);
            button.setOnAction(this::number);
        }

        Button button7 = new Button("÷");
        button7.setId("button6");
        button7.setOnAction(this::mathyStuff);
        buttons4.getChildren().add(button7);

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
        String number2 = (display.getText());
        if (event.getSource() instanceof Button){
            Button button = ((Button) event.getSource());

            String number = button.getText();
            String number1 = equation.getText();

            display.setText(number2 + number1 + number);
            
            equation.setText(""); 
        }
    }

    public void equals (ActionEvent event){
        //figuring out which mathamatical symbol is being used
        String number = display.getText();
        String equationType = number.substring(number.length() -1 );
        
        //getting numbers for the equation, and converting from String to int
        String newElement = equation.getText();
        String [] numberString = display.getText().split("[^0-9]+");
        //display.setText(number + newElement); //making the whole equation, appear in display textField
        String[] newArray = Arrays.copyOf(numberString, numberString.length +1);
        newArray[newArray.length-1] = newElement;
        int[] numbers = Arrays.stream(newArray).mapToInt(Integer::parseInt).toArray();

        //states which method to run for which button.
        switch( equationType ){
            case "+":
                Addition(numbers);
                break;
            case "-":
                Subtraction(numbers);
                break;
            case "x":
                multiplication(numbers);
                break;
            case "÷":
                division(numbers);
        }
    }
    public void Addition(int...numbers) {
        int c = 0;
        for (int number : numbers) {
            c += number;
        }
        String d = String.valueOf(c);
        equation.setText(d);
    }


    public void Subtraction(int...numbers) {
        int subtract = numbers[0];
        for (int number : numbers){
            subtract -= number;
        }
        String result = String.valueOf(subtract);
        equation.setText(result);

        /*int c = a - b;
        String d = String.valueOf(c);
        equation.setText(d);*/
    }
        public void multiplication(int...numbers) {
        int product = numbers[0];
        for (int number : numbers){
            product *= number;
        }
        String result = String.valueOf(product);
        equation.setText(result);

        /*int c = a * b;
        String d = String.valueOf(c);
        equation.setText(d);*/
    }

    public void division (int...numbers) {
        int quotient = numbers[0]; //the product of dividing multiple numbers together
        for (int number : numbers) {
            quotient /= number;
        }
        String result = String.valueOf(quotient);
        equation.setText(result);


        /*int c = a / b;
        String d = String.valueOf(c);
        equation.setText(d);*/
}
}