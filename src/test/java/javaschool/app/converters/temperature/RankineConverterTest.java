package javaschool.app.converters.temperature;

import javaschool.app.converters.Converter;
import org.junit.Assert;
import org.junit.Test;

public class RankineConverterTest {
    private final Converter source = new CelsiusConverter();
    private final Converter target = new RankineConverter();

    @Test
    public void to() throws Exception {
        Assert.assertEquals(509.67, target.from(source.to(10)), 0.001);
    }

    @Test
    public void from() throws Exception {
        Assert.assertEquals(10, source.from(target.to(509.67)), 0.001);
    }

}