package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;


public class Main extends Application implements EventHandler<ActionEvent>{
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent scene = FXMLLoader.load(getClass().getResource("GUI.fxml"));
			primaryStage.setTitle("Calculator");
			primaryStage.setScene(new Scene(scene, 500, 479));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
}
