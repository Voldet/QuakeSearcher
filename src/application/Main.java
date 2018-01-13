package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Author Vold
 */
public class Main extends Application {
	/**
	 * The main method, but just load the UI interface. 
	 * The UI method will be declare in the UnitController.
	 * @param primaryStage
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
			primaryStage.setTitle("Vold EarthQuake View");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * main method to launch 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
