package javaschool.app.formatters;

import org.junit.Assert;
import org.junit.Test;

public class MetricFormatterTest {
    private final Formatter formatter = new MetricFormatter();

    @Test
    public void format() throws Exception {
        Assert.assertEquals(formatter.format(10.123, "s"), "10,12 s");
    }

}