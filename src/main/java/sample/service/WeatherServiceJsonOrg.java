package sample.service;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import sample.model.Weather;
import sample.model.WeatherCondition;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by michalos on 17.11.2016.
 */
public class WeatherServiceJsonOrg implements WeatherService {
    private String privateKey;


    public WeatherServiceJsonOrg(String privateKey){
        this.privateKey = privateKey;
    }

    public Weather getWeatherFromUrl(String url, String city) {
        String finalUrl = url+"?key="+privateKey+"&q="+city;
        Weather weather = new Weather();
        try {
            /*
        private double pressureMb;
        private WeatherCondition weatherCondition;


             */
            JSONObject json = new JSONObject(IOUtils.toString(new URL(finalUrl), Charset.forName("UTF-8")));
            //JSONObject weatherJson =(JSONObject)json.get("location");
            JSONObject currentWeather = json.getJSONObject("current");
            String location = city;
            double temperatureInCelsius = currentWeather.getDouble("temp_c");
            String lastUpdated = currentWeather.getString("last_updated");
            boolean isDay = currentWeather.getInt("is_day")==1 ? true : false;
            double feelsLikeTemperatureInCelsius = currentWeather.getDouble("feelslike_c");
            double pressureMB = currentWeather.getDouble("pressure_mb");
            JSONObject currentConditionWeather = currentWeather.getJSONObject("condition");
            String conditionText = currentConditionWeather.getString("text");
            String iconUrl = currentConditionWeather.getString("icon");
            int code = currentConditionWeather.getInt("code");

            WeatherCondition weatherCondition = new WeatherCondition(conditionText,iconUrl,code);
            weather.setDay(isDay);
            weather.setWeatherCondition(weatherCondition);
            weather.setLastUpdated(lastUpdated);
            weather.setTemperatureInCelcius(temperatureInCelsius);
            weather.setLocation(location);
            weather.setPressureMB(pressureMB);
            weather.setFeelsLikeTemperatureInCelcius(feelsLikeTemperatureInCelsius);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return weather;
    }

    public static  void main(String[] args){
        WeatherServiceJsonOrg weatherServiceJsonOrg = new WeatherServiceJsonOrg("d578c483ed8b494bad8170534161511");
        Weather weather = weatherServiceJsonOrg.getWeatherFromUrl("http://api.apixu.com/v1/current.json","Warsaw");
        System.out.println(weather);
    }



}
