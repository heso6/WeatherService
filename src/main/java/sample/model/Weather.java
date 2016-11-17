package sample.model;

import java.time.LocalDateTime;

/**
 * Created by gosc on 17.11.2016.
 */
public class Weather {


    private double temperatureInCelcius;
    private LocalDateTime lastUpdated;
    private double feelsLikeTemperatureInCelcius;
    private String iconUrl;
    private boolean isDay;
    private double pressureMB;
    private String location;
    private WeatherCondition weatherCondition;


    public Weather(double temperatureInCelcius, WeatherCondition weatherCondition, double pressureMB, boolean isDay, String iconUrl, LocalDateTime lastUpdated, double feelsLikeTemperatureInCelcius, String location) {
        this.temperatureInCelcius = temperatureInCelcius;
        this.weatherCondition = weatherCondition;
        this.pressureMB = pressureMB;
        this.isDay = isDay;
        this.iconUrl = iconUrl;
        this.lastUpdated = lastUpdated;
        this.feelsLikeTemperatureInCelcius = feelsLikeTemperatureInCelcius;
        this.location = location;
    }

    public WeatherCondition getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(WeatherCondition weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public double getTemperatureInCelcius() {
        return temperatureInCelcius;
    }

    public void setTemperatureInCelcius(double temperatureInCelcius) {
        this.temperatureInCelcius = temperatureInCelcius;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPressureMB() {
        return pressureMB;
    }

    public void setPressureMB(double pressureMB) {
        this.pressureMB = pressureMB;
    }

    public boolean isDay() {
        return isDay;
    }

    public void setDay(boolean day) {
        isDay = day;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public double getFeelsLikeTemperatureInCelcius() {
        return feelsLikeTemperatureInCelcius;
    }

    public void setFeelsLikeTemperatureInCelcius(double feelsLikeTemperatureInCelcius) {
        this.feelsLikeTemperatureInCelcius = feelsLikeTemperatureInCelcius;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
