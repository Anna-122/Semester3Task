package com.khpi;

import java.util.HashMap;

public class Map {
    public static void main(String[] args) {

        HashMap<Integer, String> passportsAndNames = new HashMap<>();

        passportsAndNames.put(212133, "Лидия Аркадьевна Бубликова");
        passportsAndNames.put(162348, "Иван Михайлович Серебряков");
        passportsAndNames.put(808277144, "Дональд Джон Трамп");
        passportsAndNames.put(162348, "Виктор Михайлович Стычкин");//повторный ключ

        System.out.println(passportsAndNames);

    }

}
