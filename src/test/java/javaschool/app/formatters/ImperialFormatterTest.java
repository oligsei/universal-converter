package javaschool.app.formatters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ImperialFormatterTest {
    private final Formatter formatter = new ImperialFormatter();

    @Parameterized.Parameter()
    private double value;

    @Parameterized.Parameter(1)
    private String suffix;

    @Parameterized.Parameter(2)
    private String expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10.5, "s", "10 1/2 s"},
                {10.25, "s", "10 1/4 s"},
                {10.125, "s", "10 1/8 s"},
        });
    }

    @Test
    public void format() throws Exception {
        Assert.assertEquals(formatter.format(value, suffix), expected);
    }

}