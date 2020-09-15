package controlador;

import java.util.ArrayList;

import Modelo.Datagrama;
import Modelo.Fragmentacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class ControladorPrincipal {
	
	private Fragmentacion fragmentacion;
	
	private ObservableList<Datagrama> items;

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
	private TableView<Datagrama> datagramas;
	
	@FXML
	private TableColumn<Datagrama, String> longitudTotal;
	
	@FXML
	private TableColumn<Datagrama, String> flags;
	
	@FXML
	private TableColumn<Datagrama, String> offsetBin;
	
	@FXML
	private TableColumn<Datagrama, String> offsetDec;
	
	@FXML
	private TableColumn<Datagrama, String> bits16;

	@FXML
	void accionBotonCalcular(ActionEvent event) {
		fragmentacion = new Fragmentacion();
		String tamañoDatagrama = cmpTamanioDatagrama.getText();
		String mtu = cmpMTU.getText();
		
		items = FXCollections.observableArrayList();
		
		ArrayList<Datagrama> datos = fragmentacion.calcularLongitudFragmento(tamañoDatagrama, mtu);
		
		for(Datagrama datagramas: datos) {
			items.add(datagramas);
		}
		
		longitudTotal.setCellValueFactory(new PropertyValueFactory<>("longitudTotal"));
		flags.setCellValueFactory(new PropertyValueFactory<>("flags"));
		offsetBin.setCellValueFactory(new PropertyValueFactory<>("offsetBin"));
		offsetDec.setCellValueFactory(new PropertyValueFactory<>("offsetDec"));
		bits16.setCellValueFactory(new PropertyValueFactory<>("bits16"));
		
		datagramas.setItems(items);
	}

}
