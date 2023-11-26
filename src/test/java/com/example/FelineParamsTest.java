package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParamsTest {

    @Parameterized.Parameter
    public int kittensInput;

    @Parameterized.Parameter(1)
    public int expectedKittensAmount;

    @Parameterized.Parameters(name = "Ввели котят: {0} котят, ждем, что вернется котят: {1}")
    public static Object[][] data() {
        return new Object[][] {
                { 1, 1 },
                { 0, 0 },
                { 15, 15 }
        };
    }

    @Test
    public void getKittens() {
        Feline feline = new Feline();

        int actualKittensAmount = feline.getKittens(kittensInput);

        assertEquals("Котят больше или меньше, чем мы ожидали",
                expectedKittensAmount, actualKittensAmount);
    }

}
