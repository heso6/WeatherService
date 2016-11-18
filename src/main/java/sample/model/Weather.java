package sample.model;

/**
 * Created by gosc on 17.11.2016.
 */
public class Weather {


    private double temperatureInCelcius;
    private String lastUpdated;
    private double feelsLikeTemperatureInCelcius;
    private boolean isDay;
    private double pressureMB;
    private String location;
    private WeatherCondition weatherCondition;

    @Override
    public String toString() {
        return "Weather{" +
                "temperatureInCelcius=" + temperatureInCelcius +
                ", lastUpdated=" + lastUpdated +
                ", feelsLikeTemperatureInCelcius=" + feelsLikeTemperatureInCelcius +
                ", isDay=" + isDay +
                ", pressureMB=" + pressureMB +
                ", location='" + location + '\'' +
                ", weatherCondition=" + weatherCondition +
                '}';
    }

    public Weather(double temperatureInCelcius, WeatherCondition weatherCondition, double pressureMB, boolean isDay, String lastUpdated, double feelsLikeTemperatureInCelcius, String location) {
        this.temperatureInCelcius = temperatureInCelcius;
        this.weatherCondition = weatherCondition;
        this.pressureMB = pressureMB;
        this.isDay = isDay;
        this.lastUpdated = lastUpdated;
        this.feelsLikeTemperatureInCelcius = feelsLikeTemperatureInCelcius;
        this.location = location;
    }

        public Weather(){}

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


    public double getFeelsLikeTemperatureInCelcius() {
        return feelsLikeTemperatureInCelcius;
    }

    public void setFeelsLikeTemperatureInCelcius(double feelsLikeTemperatureInCelcius) {
        this.feelsLikeTemperatureInCelcius = feelsLikeTemperatureInCelcius;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
