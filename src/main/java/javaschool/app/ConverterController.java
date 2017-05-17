package javaschool.app;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javaschool.app.converters.Converter;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

public class ConverterController implements Initializable {
    @FXML
    private ComboBox<Converter> source;
    @FXML
    private ComboBox<Converter> target;

    @FXML
    private TextField sourceValue;
    @FXML
    private TextField targetValue;

    private UniversalConverter converter = new UniversalConverter();

    double convert() throws Exception {
        System.out.println("CONVERT");

        try {
            return converter.convert(Double.parseDouble(sourceValue.getText()));
        } catch (Exception e) {
            System.out.println(e);
        }

        return Double.parseDouble(sourceValue.getText());
    }

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        System.out.println("Initialize");
        final Collection<Converter> converters = converter.getConverters().values();
        source.getItems().addAll(converters);
        target.getItems().addAll(converters);

        targetValue.textProperty().bind(SimpleStringProperty.stringExpression(Bindings.createDoubleBinding(this::convert, sourceValue.textProperty())));

        source.setOnAction((ActionEvent e) -> this.converter.setSource(source.getValue()));
        target.setOnAction((ActionEvent e) -> this.converter.setTarget(target.getValue()));
    }
}
