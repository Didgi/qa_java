package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {

    @Mock
    Feline feline;
    Lion lion;
    Lion lionNegative;
    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", feline);
    }


    @Test
    public void getKittensDefaultCallOneKittenFeline() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedCountKittens = 1;
        Assert.assertEquals(expectedCountKittens, lion.getKittens());
    }

    @Test
    public void getKittensCallGetKittensFelineOnce() throws Exception {
        lion.getKittens();
        Mockito.verify(feline,Mockito.times(1)).getKittens();
    }
    @Test
    public void doesHaveManeGetValue() throws Exception {
        lion.doesHaveMane();
        Assert.assertEquals(lion.hasMane,lion.doesHaveMane());
    }
    @Test
    public void getFoodDefaultGetAnimalList() throws Exception {
        List<String> expectedAnimalList = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedAnimalList);
        Assert.assertEquals(expectedAnimalList, lion.getFood());
    }

    @Test
    public void getFoodCallCheckFoodFelineOnce() throws Exception {
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
    @Test (expected = Exception.class)
    public void getFoodDefaultShowsException() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenThrow(new Exception());
        lion.getFood();
    }
    @Test
    public void createLionNegativeGenderShowsException() throws Exception {
        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        Exception exception = Assert.assertThrows(Exception.class, () -> lionNegative = new Lion("Оно", feline));
        Assert.assertEquals(expectedMessage,exception.getMessage());
    }

}
