package javaschool.app.converters.temperature;

import javaschool.app.converters.Unit;

public class CelsiusConverter extends TemperatureConverter {
    @Override
    public String getSuffix() {
        return "°C";
    }

    @Override
    public Unit getUnit() {
        return Unit.CELSIUS;
    }

    @Override
    public String toString() {
        return "celsius";
    }
}
