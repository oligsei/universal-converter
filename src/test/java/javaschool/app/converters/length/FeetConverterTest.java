package javaschool.app.converters.length;

import javaschool.app.converters.Converter;
import org.junit.Assert;
import org.junit.Test;

public class FeetConverterTest {
    private final Converter source = new MetersConverter();
    private final Converter target = new FeetConverter();

    @Test
    public void from() throws Exception {
        Assert.assertEquals(target.from(source.to(10)), 32.80839895, 0.001);
    }

    @Test
    public void to() throws Exception {
        Assert.assertEquals(source.from(target.to(32.80839895)), 10, 0.001);
    }

}