package com.example;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTests {

    @Mock
    Predator predator;
    Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(predator);
    }

    @Test
    public void getSoundDefaultShowsOk() {
        String actualCatSound = cat.getSound();
        Assert.assertEquals("Мяу", actualCatSound);
    }

    @Test
    public void getFoodDefaultGetCustomListShowsOk() throws Exception {
        List<String> expectedFoodList = Arrays.asList("Мышь", "Рыба");
        Mockito.when(predator.eatMeat()).thenReturn(expectedFoodList);
        Assert.assertEquals(expectedFoodList, cat.getFood());
    }

    @Test
    public void getFoodDefaultCallEatMeatOnceShowsOk() throws Exception {
        cat.getFood();
        Mockito.verify(predator, Mockito.times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void getFoodDefaultShowsException() throws Exception {
        Mockito.when(predator.eatMeat()).thenThrow(new Exception());
        cat.getFood();
    }
}
