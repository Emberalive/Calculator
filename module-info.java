module Calculator {
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires java.scripting;
    requires exp4j;
    opens com.emberalive.calculator to javafx.graphics;
}