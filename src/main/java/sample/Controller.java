package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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

    private Weather currentWeather;

    public void initialize(URL location, ResourceBundle resource){
        setValuesComponentsFromServer();
    }

    private void setValuesComponentsFromServer() {
        WeatherServiceJsonOrg weatherServiceJsonOrg = new WeatherServiceJsonOrg("d578c483ed8b494bad8170534161511");
        currentWeather = weatherServiceJsonOrg.getWeatherFromUrl("http://api.apixu.com/v1/current.json","Warsaw");
        dateLabel.setText(currentWeather.getLastUpdated());
        cityLabel.setText(currentWeather.getLocation());
        temperatureLabel.setText(String.valueOf(currentWeather.getFeelsLikeTemperatureInCelcius()));
        textConditionLabel.setText(currentWeather.getWeatherCondition().getText());
    }


}
