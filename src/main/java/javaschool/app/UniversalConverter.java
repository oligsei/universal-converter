package javaschool.app;

import asg.cliche.Command;
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

    @Command
    public String convert(double value) {
        if (this.source == null) {
            return "Source not defined";
        }
        if (this.target == null) {
            return "Target not defined";
        }

        if (this.source.getType() != this.target.getType()) {
            return String.format("Type mismatch. Unable to convert from %s to %s", this.source, this.target);
        }

        Formatter formatter;
        if (this.format == null) {
            formatter = this.formatterMap.get(this.target.getFormat());
        } else {
            formatter = this.format;
        }
        System.out.format("Converting from %s to %s\n", this.source, this.target);

        return formatter.format(this.target.from(this.source.to(value)), this.target.getSuffix());
    }

    @Command
    public Collection<Converter> converters() {
        return this.converters.values();
    }

    @Command
    public Collection<Formatter> formatters() {
        return this.formatters.values();
    }

    @Command(abbrev = "source")
    public void setSource(String name) {
        final Converter converter = this.converters.ceilingEntry(name).getValue();
        if (converter == null) {
            throw new IllegalArgumentException(String.format("Did not find any converters matching %s", name));
        } else {
            this.source = converter;
        }
    }

    @Command(abbrev = "target")
    public void setTarget(String name) {
        final Converter converter = this.converters.ceilingEntry(name).getValue();
        if (converter == null) {
            throw new IllegalArgumentException(String.format("Did not find any converters matching %s", name));
        } else {
            this.target = converter;
        }
    }

    @Command(abbrev = "format")
    public void setFormat() {
        this.format = null;
    }

    @Command(abbrev = "format")
    public void setFormat(String name) {
        final Formatter formatter = this.formatters.ceilingEntry(name).getValue();
        if (formatter == null) {
            throw new IllegalArgumentException(String.format("Did not find any formatters matching %s", name));
        } else {
            this.format = formatter;
        }
    }
}
