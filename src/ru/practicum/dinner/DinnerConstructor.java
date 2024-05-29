package ru.practicum.dinner;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> menu = new HashMap<>();

    void includeNewDish(String dishType, String dishName) {
        //Проверяю, существует ли уже такой тип
        if (!menu.containsKey(dishType)) {
            menu.put(dishType, new ArrayList<String>());
        }
        menu.get(dishType).add(dishName);
    }

    void generateCombosOfDish(int numberOfCombos, ArrayList<String> dishesList) {
        Random random = new Random();

        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> combos = new ArrayList<>();
            for (String typeOfDish : dishesList) {
                int index = random.nextInt(menu.get(typeOfDish).size());
                String dish = menu.get(typeOfDish).get(index);
                combos.add(dish);
            }
            System.out.println(combos);
        }
    }

    boolean checkType(String type) {
        return menu.containsKey(type);
    }
}
