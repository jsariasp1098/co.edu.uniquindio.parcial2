package co.edu.uniquindio.parcial2.view;

import co.edu.uniquindio.parcial2.controller.ConsultaController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ConsultaViewController {
    ConsultaController consultaController;

    @FXML
    private Button btn1;
    @FXML
    private TextArea txt1;
    @FXML
    private TextField txtRango1;

    @FXML
    private Button btn2;
    @FXML
    private TextArea txt2;
    @FXML
    private TextField txtRango2;

    @FXML
    private Button btn3;
    @FXML
    private TextArea txt3;
    @FXML
    private TextField txtRango3;

    @FXML
    private Button btn4;
    @FXML
    private TextArea txt4;

    @FXML
    void onObtenerObjetosMasPrestadosSegunRango(ActionEvent event) {
        if(!txtRango1.getText().isEmpty()){
            String reporteObjetos = consultaController.obtenerObjetosMasPrestadosSegunRango(txtRango1.getText());
            txt1.setText(reporteObjetos);
        }
    }

    @FXML
    void onObtenerObjeto(ActionEvent event) {
        if(!txtRango2.getText().isEmpty()){
            String objeto = consultaController.obtenerObjeto(txtRango2.getText());
            txt2.setText(objeto);
        }
    }

    @FXML
    void onObtenerClientesPrestamosSegunRango(ActionEvent event) {
        if(!txtRango3.getText().isEmpty()){
            String objeto = consultaController.obtenerClientesPrestamosSegunRango(txtRango3.getText());
            txt3.setText(objeto);
        }
    }

    @FXML
    void onObtenerCantidadObjetosDisponiblesNoDisponibles(ActionEvent event) {
        String objeto = consultaController.obtenerCantidadObjetosDisponiblesNoDisponibles();
        txt4.setText(objeto);
    }

    @FXML
    void initialize() {
        consultaController = new ConsultaController();
    }
}
