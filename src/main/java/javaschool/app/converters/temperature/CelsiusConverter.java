package javaschool.app.converters.temperature;

public class CelsiusConverter extends TemperatureConverter {
    @Override
    public String getSuffix() {
        return "°C";
    }

    @Override
    public String toString() {
        return "celsius";
    }
}
