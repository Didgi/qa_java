package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LionAlex extends Lion{
    public LionAlex(Feline feline) throws Exception {
        super("Самец", feline);
    }
    public List<String> getFriends() {
        return Arrays.asList("Зебра Марти", "Бегемотиха Глория", "Жираф Мелман");
    }
    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }
    @Override
    public int getKittens(){
        return 0;
    }
    //getFriends() возвращает список имён его друзей — зебры Марти, бегемотихи Глории и жирафа Мелман;
    //getPlaceOfLiving() возвращает место, где он живёт — Нью-Йоркский зоопарк.
}
