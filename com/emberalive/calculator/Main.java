package com.emberalive.calculator;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public void start (Stage scene){
        View view = new View();
        
        view.start(scene);
    }
}