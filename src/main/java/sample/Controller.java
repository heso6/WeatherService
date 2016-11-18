package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.model.Weather;
import sample.service.WeatherServiceJsonOrg;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label dateLabel;

    @FXML
    private Label textConditionLabel;

    @FXML
    private Label temperatureLabel;

    @FXML
    private ImageView iconImageView;

    @FXML
    private  Label cityLabel;

    @FXML
    private Button sendButton;

    @FXML
    private TextField cityTextField;

    @FXML
    public void onEnter(ActionEvent actionEvent){
        setValuesComponentsFromServer(cityTextField.getText());
    }


    private Weather currentWeather;


    private void setValuesComponentsFromServer(String myCity) {
        WeatherServiceJsonOrg weatherServiceJsonOrg = new WeatherServiceJsonOrg("d578c483ed8b494bad8170534161511");
        String city = myCity !=null ? myCity : "Warsaw";
        currentWeather = weatherServiceJsonOrg.getWeatherFromUrl("http://api.apixu.com/v1/current.json",city);
        dateLabel.setText(currentWeather.getLastUpdated());
        cityLabel.setText(currentWeather.getLocation());
        temperatureLabel.setText(String.valueOf(currentWeather.getFeelsLikeTemperatureInCelcius()));
        textConditionLabel.setText(currentWeather.getWeatherCondition().getText());
        Image image = new Image("http:"+currentWeather.getWeatherCondition().getIconUrl(), true);
        iconImageView.setImage(image);
    }


    public void initialize(URL location, ResourceBundle resources) {
        setValuesComponentsFromServer("Warsaw");

        sendButton.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        setValuesComponentsFromServer(cityTextField.getText());
                    }
                });
    }
}
