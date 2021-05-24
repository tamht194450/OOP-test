package simpleJavaFX;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Counter extends Application {
	
   public void start(Stage primaryStage) throws Exception {
       Parent root = FXMLLoader.load(getClass()
               .getResource("/simpleJavaFX/Counter.fxml"));
       
       primaryStage.setTitle("My Application");
       primaryStage.setScene(new Scene(root));
       primaryStage.show();
        
   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}