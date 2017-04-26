package javaschool.app.formatters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MetricFormatterTest {
    private final Formatter formatter = new MetricFormatter();

    @Parameterized.Parameter()
    public double value;

    @Parameterized.Parameter(1)
    public String suffix;

    @Parameterized.Parameter(2)
    public String expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10.5, "s", String.format("%.2f s", 10.5)},
                {10.25, "s", String.format("%.2f s", 10.25)},
                {10.125, "s", String.format("%.2f s", 10.125)},
        });
    }


    @Test
    public void format() throws Exception {
        Assert.assertEquals(expected, formatter.format(value, suffix));
    }

}