package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    protected Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void getSoundReturnsMeow() {

        String expectedSound = cat.getSound();
        String actualSound = "Мяу";

        assertEquals("Ожидалось, что кошка издаст 'Мяу'", expectedSound, actualSound);

    }

    @Test
    public void getFoodReturnsPredatorList() throws Exception {

        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFood = cat.getFood();

        assertEquals("Кошки такое не едят", expectedFood, actualFood);
    }
}
