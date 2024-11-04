package org.example.examenfx;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Spinner<Integer> spinnerVersion;
    @FXML
    private TextField txtCorreo;
    @FXML
    private ChoiceBox<String> comboPlataforma;
    @FXML
    private TableColumn<Usuario, String> clcorreo;
    @FXML
    private TableColumn<Usuario, String> clplataforma;
    @FXML
    private TableColumn<Usuario, String> cladministrador;
    @FXML
    private TableColumn<Usuario, String> cdversion;
    @FXML
    private TableColumn<Usuario, LocalTime> cdhora;
    @FXML
    private TableColumn<Usuario, LocalDate> cdfecha;
    @FXML
    private Button btneliminar;
    @FXML
    private TableView<Usuario> tableView;
    @FXML
    private CheckBox cbAdministrador;

    private ObservableList<Usuario> usuarios;
    @Override


        public void initialize(URL url, ResourceBundle resourceBundle) {
            spinnerVersion.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1));
            comboPlataforma.getItems().addAll("Windows", "Linux", "MacOs");

            clcorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
            clplataforma.setCellValueFactory(new PropertyValueFactory<>("plataforma"));
            cladministrador.setCellValueFactory(new PropertyValueFactory<>("administrador"));
            cdversion.setCellValueFactory(new PropertyValueFactory<>("version"));
            cdhora.setCellValueFactory(new PropertyValueFactory<>("hora"));
            cdfecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));

            tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    txtCorreo.setText(newValue.getCorreo());
                    comboPlataforma.setValue(newValue.getPlataforma());
                    cbAdministrador.setSelected(newValue.isAdmin());
                    spinnerVersion.getValueFactory().setValue(Integer.parseInt(newValue.getVersion()));
                }
            });
        }

    @FXML
    public void addUsuario(ActionEvent actionEvent) {
        String correo = txtCorreo.getText();
        String plataforma = comboPlataforma.getValue();
        String version = spinnerVersion.getValue().toString();
        LocalDate fecha = LocalDate.now();
        LocalTime hora = LocalTime.now();


        Usuario usuario = new Usuario(correo, plataforma, version, fecha, hora, cbAdministrador.isSelected());
        usuarios.add(usuario);
    }

    @FXML
    public void deleteUsuario(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Eliminar Usuario");
        alert.setHeaderText("¿Estás seguro?");
        alert.setContentText("¿Deseas eliminar este usuario?");
        var result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            Usuario selectedUsuario = tableView.getSelectionModel().getSelectedItem();
            usuarios.remove(selectedUsuario);
        }
    }

}


