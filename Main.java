import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public void start (Stage scene){
        view view = new view();
        
        view.start(scene);
    }
}