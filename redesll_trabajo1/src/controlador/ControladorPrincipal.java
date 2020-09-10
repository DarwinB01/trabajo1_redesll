package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class ControladorPrincipal {

	@FXML
	private Pane pane;

	@FXML
	private TextField cmpTamanioDatagrama;

	@FXML
	private TextField cmpMTU;

	@FXML
	private Button btnCalcular;

	@FXML
	private TextArea txtArea;

	@FXML
	void accionBotonCalcular(ActionEvent event) {

	}

}
