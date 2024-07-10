module Calculator {
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    opens com.emberalive.calculator to javafx.graphics;
}