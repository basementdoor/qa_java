package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    protected Lion lion;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самка", feline);
    }

    @Test
    public void hasManeIncorrectSexException() throws Exception {

        assertThrows("Исключение не обрабатывается",
                Exception.class, () -> new Lion("Mushina", feline));

    }

    @Test
    public void hasManeIncorrectSexExceptionText() throws Exception {

        Exception exception = assertThrows(Exception.class, () -> new Lion("Mushina", feline));
        String expectedText = "Используйте допустимые значения пола животного - самец или самка";
        String actualText = exception.getMessage();

        assertEquals("Некорректное сообщение об исключении", expectedText, actualText);

    }

    @Test
    public void getKittensReturnsAmount() throws Exception {

        Mockito.when(feline.getKittens()).thenReturn(1);

        int expectedAmount = 1;
        int actualAmount = lion.getKittens();

        assertEquals("Неверное количество котят", expectedAmount, actualAmount);
    }

    @Test
    public void eatMeatPredatorList() throws Exception {

        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник"))
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualList = lion.getFood();

        assertEquals("Настоящие львы такое не едят!", expectedList, actualList);

    }
}
