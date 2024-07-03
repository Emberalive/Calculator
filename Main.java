import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public void start (Stage scene){
        view view = new view();
        
        view.start(scene);
    }
    
    public static void Addition(int a, int b){
        int c = a + b;
        System.out.println(c);
    }

    public static void subtraction(int a, int b){
        int c = a- b;
        System.out.println(c);
    }

    public static void multiplication(int a, int b){
        int c = a * b;
        System.out.println(c);
    }
    public void main(String[] args) {

        
    }
}