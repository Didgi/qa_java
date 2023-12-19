package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTests {
    LionAlex lionAlex;
    Feline feline;
    @Before
    public void setUp() throws Exception {
        lionAlex = new LionAlex(feline);
    }
    @Test
    public void getFriendsDefaultGetListShowsOk() {
        List<String> expectedList = Arrays.asList("Зебра Марти", "Бегемотиха Глория", "Жираф Мелман");
        Assert.assertEquals(expectedList,lionAlex.getFriends());
    }
    @Test
    public void getPlaceOfLivingDefaultGetPlaceShowsOk(){
        String expectedPlace = "Нью-Йоркский зоопарк";
        Assert.assertEquals(expectedPlace, lionAlex.getPlaceOfLiving());
    }
    @Test
    public void getKittensDefaultGetZeroShowsOk(){
        int expectedKittens = 0;
        Assert.assertEquals(expectedKittens, lionAlex.getKittens());
    }
}
