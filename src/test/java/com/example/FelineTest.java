package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void getFamilyReturnsFeline() {

        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();

        assertEquals("Неверная семья", expectedFamily, actualFamily);
    }

    @Test
    public void eatMeatCallsGetFood() throws Exception {

        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualList = feline.eatMeat();

        assertEquals("Кошачьи такое не едят!", expectedList, actualList);

    }

    @Test
    public void getKittensWithoutParamCallsGetKittens1() {

        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }


}
