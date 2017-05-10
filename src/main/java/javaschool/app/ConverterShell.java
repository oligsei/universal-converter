package javaschool.app;

import asg.cliche.Command;
import javaschool.app.converters.Converter;
import javaschool.app.formatters.Formatter;

import java.util.*;

public class ConverterShell {
    private UniversalConverter converter = new UniversalConverter();

    ConverterShell() {
    }

    @Command
    public String convert(double value) {
        try {
            return converter.format(converter.convert(value));
        } catch (Exception e) {
            return e.toString();
        }
    }

    @Command(abbrev = "converters")
    public Collection<Converter> getConverters() {
        return converter.getConverters().values();
    }

    @Command(abbrev = "formatters")
    public Collection<Formatter> getFormatters() {
        return converter.getFormatters().values();
    }

    @Command(abbrev = "source")
    public void setSource(String name) {
        final Converter converter =  this.converter.getConverters().ceilingEntry(name).getValue();
        if (converter == null) {
            throw new IllegalArgumentException(String.format("Did not find any converters matching %s", name));
        } else {
            this.converter.setSource(converter);
        }
    }

    @Command(abbrev = "target")
    public void setTarget(String name) {
        final Converter converter = this.converter.getConverters().ceilingEntry(name).getValue();
        if (converter == null) {
            throw new IllegalArgumentException(String.format("Did not find any converters matching %s", name));
        } else {
            this.converter.setTarget(converter);
        }
    }

    @Command(abbrev = "format")
    public void clearFormat() {
        this.converter.clearFormat();
    }

    @Command(abbrev = "format")
    public void setFormat(String name) {
        final Formatter formatter = this.converter.getFormatters().ceilingEntry(name).getValue();
        if (formatter == null) {
            throw new IllegalArgumentException(String.format("Did not find any formatters matching %s", name));
        } else {
            this.converter.setFormat(formatter);
        }
    }
}
