package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParamsTest {

    @Mock
    Feline feline;

    @Parameterized.Parameter
    public String sex;

    @Parameterized.Parameter(1)
    public boolean expectedHasMane;

    @Parameterized.Parameters(name = "Если пол: {0} - ожидаем, что наличие гривы: {1}")
    public static Object[][] data() {
        return new Object[][] {
                { "Самец", true },
                { "Самка", false }
        };
    }

    @Test
    public void lionHasMane() throws Exception {

        Lion lion = new Lion(sex, feline);
        boolean actualHasMane = lion.doesHaveMane();

        assertEquals("Ожидалось иное поведение по наличию гривы", expectedHasMane, actualHasMane);

    }
}
