import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Parent;

/**
 * 
 */

/**
 * @author USUARIO
 *
 */
public class Aplicacion extends Application {

	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/vista/principal.fxml"));

		Parent p = loader.load();
		Scene s = new Scene(p);

		primaryStage.setTitle("");
		primaryStage.setScene(s);
		primaryStage.show();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		launch(args);

	}

}
