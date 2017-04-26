package javaschool.app.converters.temperature;

import javaschool.app.converters.Converter;
import org.junit.Assert;
import org.junit.Test;

public class KelvinConverterTest {
    private final Converter source = new CelsiusConverter();
    private final Converter target = new KelvinConverter();

    @Test
    public void from() throws Exception {
        Assert.assertEquals(target.from(source.to(10)), 283.15, 0.001);
    }

    @Test
    public void to() throws Exception {
        Assert.assertEquals(source.from(target.to(283.15)), 10, 0.001);
    }

}