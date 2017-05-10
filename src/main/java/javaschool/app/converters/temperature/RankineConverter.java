package javaschool.app.converters.temperature;

import javaschool.app.converters.Unit;

public class RankineConverter extends TemperatureConverter {
    @Override
    public double from(double value) {
        return (value + 273.15) * 9 / 5;
    }

    @Override
    public double to(double value) {
        return (value - 491.67) * 5 / 9;
    }

    @Override
    public String getSuffix() {
        return "°R";
    }

    @Override
    public Unit getUnit() {
        return Unit.KELVIN;
    }

    @Override
    public String toString() {
        return "rankine";
    }
}
