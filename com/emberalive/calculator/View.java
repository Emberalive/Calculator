package com.emberalive.calculator;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class View {
    TextField equation;
    TextField display;
    int H = 440;
    int W = 350;

    public void start(Stage window) {
        //this is where the GUI happens
        //where everything that is cool on the GUI is initialised
        VBox root = new VBox();
        HBox display1 = new HBox();
        HBox hbox = new HBox();
        HBox buttons1 = new HBox();
        HBox buttons2 = new HBox();
        HBox buttons3 = new HBox();
        HBox buttons4 = new HBox();
        HBox buttons5 = new HBox();

        //display1
        display1.setAlignment(Pos.CENTER_RIGHT);
        root.getChildren().add(display1);

        //HBox alignment
        root.getChildren().add(hbox); //adds HBox to VBox
        hbox.setAlignment(Pos.CENTER);//center the HBox

        root.getChildren().add(buttons1);
        buttons1.setAlignment(Pos.CENTER);
        root.getChildren().add(buttons2);
        buttons2.setAlignment(Pos.CENTER);
        root.getChildren().add(buttons3);
        buttons3.setAlignment(Pos.CENTER);
        root.getChildren().add(buttons4);
        buttons4.setAlignment(Pos.CENTER);
        root.getChildren().add(buttons5);
        buttons5.setAlignment(Pos.CENTER);

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
        hbox.getChildren().add(equation); //adds equation(TextField) to HBox
        equation.setEditable(false);

        //button row
        String[] button1 =
                {"(", ")", ".", "BCK"};
        for (String label : button1) {
            Button button = new Button(label);
            button.setId("gray");
            buttons1.getChildren().add(button);
            button.setOnAction(this::number);
        }


        //button row 2
        for (int i = 7; i <= 9; i++) {
            Button button = new Button(String.valueOf(i));
            button.setId("white");
            button.setOnAction(this::number);
            buttons2.getChildren().add(button);
        }
        //button row 3
        for (int i = 4; i <= 6; i++) {
            Button button = new Button(String.valueOf(i));
            button.setId("white");
            button.setOnAction(this::number);
            buttons3.getChildren().add(button);
        }
        //button row 4
        for (int i = 1; i <= 3; i++) {
            Button button = new Button(String.valueOf(i));
            button.setId("white");
            button.setOnAction(this::number);
            buttons4.getChildren().add(button);
        }
        //button row 5
        String[]
                button = {"", "0"};
        for (String label : button) {
            Button button2 = new Button(label);
            if (!label.isEmpty()) {
                button2.setId("white");
                buttons5.getChildren().add(button2);
                button2.setOnAction(this::number);
            } else {
                button2.setId("emptySpace");
                buttons5.getChildren().add(button2);
            }
        }
        Button button3 = new Button("=");
        button3.setId("white");
        buttons5.getChildren().add(button3);
        button3.setOnAction(this::equals);

        //button column 4, starting at row 2
        String[] fancy =
                {"x", "-", "+", "÷"};
        for (String labels : fancy) {
            switch (labels) {
                case "x":
                    Button button4 = new Button(labels);
                    button4.setId("gray");
                    button4.setOnAction(this::mathyStuff);
                    buttons2.getChildren().add(button4);
                    break;
                case "-":
                    Button button5 = new Button(labels);
                    button5.setId("gray");
                    button5.setOnAction(this::mathyStuff);
                    buttons3.getChildren().add(button5);
                    break;
                case "+":
                    Button button6 = new Button(labels);
                    button6.setId("gray");
                    button6.setOnAction(this::mathyStuff);
                    buttons4.getChildren().add(button6);
                    break;
                case "÷":
                    Button button7 = new Button(labels);
                    button7.setId("gray");
                    button7.setOnAction(this::mathyStuff);
                    buttons5.getChildren().add(button7);
            }
        }
        //clear button
        Button clear = new Button("clear");
        clear.setId("clearButton");
        display1.getChildren().add(clear);
        clear.setOnAction(this::number);
        //starting the scene and that
        Scene scene = new Scene(root, W, H);
        scene.getStylesheets().add("calculator.css");
        window.setScene(scene);
        window.setTitle("Calculator");
        window.show();
    }

    public void number(ActionEvent event) {
        if (event.getSource() instanceof Button button) {
            String number = button.getText();
            System.out.println("button pressed: " + number);
            String currentText = equation.getText();
            String newText;
            switch (number) {
                case "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "(", ")", ".":
                    newText = currentText + number;
                    equation.setText(newText);
                    break;
                case "BCK":
                    String a = equation.getText();
                    if (!a.isEmpty()){
                        newText = currentText.substring(0, currentText.length() - 1);
                        equation.setText(newText);
                        System.out.println("  Character removed, current value: " + newText);
                    }else{
                        System.out.println("There is no character to remove");
                    }
                    break;
                case "clear":
                    equation.setText("");
                    display.setText("");
                    break;
            }
        }
    }

    public void mathyStuff(ActionEvent event) {
        String number2 = (display.getText());//getting the value from display, textField, in case there is a prior equation
        String a = equation.getText();
        if (!a.isEmpty()){
            if (event.getSource() instanceof Button button) {
                //getting the values from the main textField and the button pressed
                String number = button.getText();
                System.out.println("button pressed: " + number);
                String number1 = equation.getText();
                //making sure there is a value already in the displayText if not, then else statement runs
                if (number2.length() >= 2) {
                    display.setText(number2 + number1 + number);
                    equation.setText("");
                } else {
                    display.setText(number1 + number);
                    equation.setText("");
                }
            }
        }else{
            System.out.println("there is no number to process");
        }
    }

    public void equals(ActionEvent event) {
        System.out.println("button pressed: =");
        //figuring out which mathematical symbol is being used
        String number = display.getText();
        String a = equation.getText();
        if (!a.isEmpty()) {
            //This is not needed right now            //String equationType = number.substring(number.length() - 1);
            //getting numbers for the equation, and converting from String to int
            String newElement = equation.getText();
            display.setText(number + newElement); //making the whole equation, appear in display textField
            String[] numberString = display.getText().split("[^0-9]+");
            System.out.println(Arrays.toString(numberString));

            //This is a test thingy, works as intended, I am very happy :)
            //it essentially gets all the symbols used for the equation, and in the correct order.
            String [] mathSymbols = display.getText().split("[0-9]");
            //add the code to remove first symbol of the array if new thing doesnt work
            System.out.println("TESTYTHINGYMABOB" + Arrays.toString(mathSymbols/*replace with moremafs if new thing doesnt work*/));
            //however I do not know what to do with it now :(

            System.out.println("equation answered : " + number + newElement);
            String[] newArray = Arrays.copyOf(numberString, numberString.length + 1);
            newArray[newArray.length - 1] = newElement;
            int[] numbers = Arrays.stream(newArray).mapToInt(Integer::parseInt).toArray();
            maf(numberString, mathSymbols/* set to moremafs if new thing doesnt work*/);
            //states which method to run for which button
            /*switch (equationType) {
                case "+":
                    coolEquations(numberString, moremafs);
                    break;
                case "-":
                    coolEquations(numberString, moremafs);
                    break;
                case "x":
                    coolEquations(numbers);
                    break;
                case "÷":
                    coolEquations(numbers);
                default:
                    System.out.println("there is no equation to process");
            }
        }else{
            System.out.println("there is not a full equation to process");
        */}
    }



    public void maf (String[] a, String[] c){
        int no1 = 0;
        int no2 = 0;
        int no3 = 0;
        int no4 = 0;
        String maf = "";
        for (int i = 0; i < a.length; i++, i++){
            //this is to remove th empty value in the array
            String [] b = Arrays.copyOfRange(c, 1, c.length);

            //This is the actual start of the method
                no1 = Integer.parseInt(a[i]);
                System.out.println("  This is the first number: " + no1);

                for (int x = 1; x < a.length; x++, x++){
                no2 = Integer.parseInt(a[x]);
                System.out.println("   This is the second number: " + no2);

                for (String s : b) {
                    maf = s;
                    System.out.println("    This is the math symbol used: " + maf);
                    System.out.println("no3: " + no3);
                    switch (maf) {
                        case "x":
                            if (no3 == 0){
                                no3 = no1 * no2;
                                equation.setText(String.valueOf(no3));
                                break;
                            }else{
                                no4 = no3 * no1;
                                equation.setText(String.valueOf(no4));
                            }
                        case "÷":
                            if (no3 == 0){
                                no3 = no1 / no2;
                                equation.setText(String.valueOf(no3));
                            }else{
                                no4 = no3 / no1;
                                equation.setText(String.valueOf(no4));
                            }
                            break;
                        case "+":
                            if (no3 == 0){
                                no3 = no1 + no2;
                                equation.setText(String.valueOf(no3));
                            }else{
                                no4 = no3 + no1;
                                equation.setText(String.valueOf(no4));
                            }
                            break;
                        case "-":
                            if (no3 == 0){
                                no3 = no1 - no2;
                                equation.setText(String.valueOf(no3));
                            }else{
                                no4 = no3 - no1;
                                equation.setText(String.valueOf(no4));
                            }
                            break;
                        default:
                            System.out.println("Does not work, you silly");
                    }
                    System.out.println("      no3: " + no3);
                    System.out.println("      no4: " + no4);
                }
            }
        }
    }


    /*
    public void maf (String[] a, String[] b){
        int no3 = 0;
        int no1 = 0;
        int no2 = 0;
        int no4 = 0;
        int no5 = 0;
        for (int i = 0; i <= a.length; i++, i++){
            if (i == 2){
                no4 = Integer.parseInt(a[i]);
                System.out.println("This is the third number: " + no4);
            }else{
                no1 = Integer.parseInt(a[i]);
                System.out.println("This is the first number: " + no1);
            }
            for (int x = 1; x <= a.length; x++){
                if (x <= 1){
                    no2 = Integer.parseInt(a[x]);
                    System.out.println("This is the second number: " + no2);
                }else{
                    System.out.println("this is the end of the road my friend");
                }
                for (String maf : b) {
                    System.out.println("This is the maf thingy: " + maf);
                    switch (maf) {
                        case "+":
                            if (i == 3) {
                                equation.setText("");
                                no5 = no3 + no4;
                                equation.setText(String.valueOf(no5));
                                System.out.println("This is the final answer: " + no5);
                            } else {
                                no3 = no1 + no2;
                                System.out.println("This is the first half of the equation: " + no3);
                            }
                            break;
                        case "-":
                            if (i >= 2) {
                                equation.setText("");
                                no5 = no3 - no4;
                                equation.setText(String.valueOf(no5));
                                System.out.println("This is the final answer: " + no5);
                            } else {
                                no3 = no1 - no2;
                                equation.setText(String.valueOf(no3));
                                System.out.println("This is the first half of the equation: " + no3);
                            }

                            break;
                        case "x":
                            if (i >= 3) {
                                equation.setText("");
                                no5 = no3 * no4;
                                equation.setText(String.valueOf(no5));
                                System.out.println("This is the final answer: " + no5);
                            } else {
                                no3 = no1 * no2;
                                equation.setText(String.valueOf(no3));
                                System.out.println("This is the first half of the equation: " + no3);
                            }
                            break;
                        case "÷":
                            if (i >= 3) {
                                equation.setText("");
                                no5 = no3 / no4;
                                equation.setText(String.valueOf(no5));
                                System.out.println("This is the final answer: " + no5);
                            } else {
                                no3 = no1 / no2;
                                equation.setText(String.valueOf(no3));
                                System.out.println("This is the first half of the equation: " + no3);
                            }
                        default:
                            System.out.println("Does not work, you silly");
                    }
                }
            }
        }
    }*/

    /*public void Addition(int... numbers) {
        String a = equation.getText();
        if (!a.isEmpty()){
            int c = 0;
            for (int number : numbers) {
                c += number;
            }
            String d = String.valueOf(c);
            equation.setText(d);
            System.out.println("    answer to equation: " + d);
        }else{
            System.out.println("There is no number to process");
        }
    }

    public void Subtraction(int... numbers) {
        String a = equation.getText();
        if (!a.isEmpty()) {
            int subtract = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                subtract -= numbers[i];
            }
            String result = String.valueOf(subtract);
            equation.setText(result);
            System.out.println("    answer to equation: " + result);
        } else {
            System.out.println("There is no number to process");
        }
    }

    public void multiplication(int... numbers) {
        String a = equation.getText();
        if (!a.isEmpty()) {
            int product = 1;
            for (int number : numbers) {
                product *= number;
            }
            String result = String.valueOf(product);
            equation.setText(result);
            System.out.println("    answer to equation: " + result);
        } else {
            System.out.println("There is no number to process");
        }
    }

    public void division(int... numbers) {
        String a = equation.getText();
        if (!a.isEmpty()) {
            int quotient = numbers[0]; //the product of dividing multiple numbers together
            for (int i = 1; i < numbers.length; i++) {
                quotient /= numbers[i];
            }
            String result = String.valueOf(quotient);
            equation.setText(result);
            System.out.println("    answer to equation: " + result);
        } else {
            System.out.println("There is no number to process");
        }
    }*/
}