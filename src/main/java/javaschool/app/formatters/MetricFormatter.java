package javaschool.app.formatters;

public class MetricFormatter extends Formatter {
    public String format(double value, String suffix) {
        return String.format("%.2f %s", value, suffix);
    }

    @Override
    public String toString() {
        return "metric";
    }
}
