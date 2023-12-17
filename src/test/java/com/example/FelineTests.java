package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTests {
    @Spy
    Feline feline;

    @Test
    public void eatMeatDefaultGetListShowsOk() throws Exception { //переписать. Неверно
        List<String> expectedAnimalList = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedAnimalList);
        Assert.assertEquals(expectedAnimalList, feline.eatMeat());
    }

    @Test
    public void eatMeatDefaultCheckCallGetFoodOnceShowsOk() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test(expected = Exception.class)
    public void eatMeatDefaultShowsException() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenThrow(new Exception());
        feline.eatMeat();
    }

    @Test
    public void getFamilyDefaultShowsOk() {
        String actualFelineFamily = feline.getFamily();
        Assert.assertEquals("Кошачьи", actualFelineFamily);
    }

    @Test
    public void getKittensDefaultShowsOneKitten() {
        int actualCountKittens = feline.getKittens();
        Assert.assertEquals(1, actualCountKittens);
    }

    @Test
    public void getKittensFiveAmountShowsFiveKittens() {
        int actualCountKittens = feline.getKittens(5);
        Assert.assertEquals(5, actualCountKittens);
    }

    @Test
    public void getKittensDefaultCallGetKittensOnceShowsOk() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

}
