package javaschool.app;

import javaschool.app.converters.Converter;
import javaschool.app.converters.length.FeetConverter;
import javaschool.app.converters.length.InchesConverter;
import javaschool.app.converters.length.MetersConverter;
import javaschool.app.converters.length.MilesConverter;
import javaschool.app.converters.temperature.CelsiusConverter;
import javaschool.app.converters.temperature.FahrenheitConverter;
import javaschool.app.converters.temperature.KelvinConverter;
import javaschool.app.converters.temperature.RankineConverter;
import javaschool.app.formatters.Format;
import javaschool.app.formatters.Formatter;
import javaschool.app.formatters.ImperialFormatter;
import javaschool.app.formatters.MetricFormatter;

import java.util.*;

public class UniversalConverter {

    private final NavigableMap<String, Converter> converters = new TreeMap<>();
    private final NavigableMap<String, Formatter> formatters = new TreeMap<>();
    private final EnumMap<Format, Formatter> formatterMap = new EnumMap<>(Format.class);

    private Converter target;
    private Converter source;
    private Formatter format;

    UniversalConverter() {
        Arrays.asList(
                new CelsiusConverter(),
                new KelvinConverter(),
                new FahrenheitConverter(),
                new RankineConverter(),
                ///
                new MetersConverter(),
                new InchesConverter(),
                new FeetConverter(),
                new MilesConverter()
        ).forEach((Converter converter) -> converters.put(converter.toString(), converter));

        formatterMap.put(Format.IMPERIAL, new ImperialFormatter());
        formatterMap.put(Format.METRIC, new MetricFormatter());
        formatterMap.forEach((format, formatter) -> formatters.put(formatter.toString(), formatter));
    }

    public double convert(double value) throws Exception {
        if (this.source == null) {
            throw new Exception("Source not defined");
        }
        if (this.target == null) {
            throw new Exception("Target not defined");
        }

        if (this.source.getType() != this.target.getType()) {
            throw new Exception(String.format("Type mismatch. Unable to convert from %s to %s", this.source, this.target));
        }

        return this.target.from(this.source.to(value));
    }

    public String format(double value) {
        return getFormatter().format(value, this.target.getSuffix());
    }

    public Formatter getFormatter() {
        if (this.format == null) {
            return this.formatterMap.get(target.getFormat());
        }
        return this.format;
    }

    public NavigableMap<String, Converter> getConverters() {
        return this.converters;
    }

    public NavigableMap<String, Formatter> getFormatters() {
        return this.formatters;
    }

    public void setSource(Converter converter) {
        this.source = converter;
    }

    public Converter getSource() {
        return source;
    }

    public void setTarget(Converter converter) {
        this.target = converter;
    }

    public Converter getTarget() {
        return target;
    }

    public void clearFormat() {
        this.format = null;
    }

    public void setFormat(Formatter formatter) {
        this.format = formatter;
    }
}
