package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> menu = new HashMap<>();
    Random random = new Random();

    void includeNewDish(String dishType, String dishName) {
        //Проверяю, существует ли уже такой тип
        if (!menu.containsKey(dishType)) {
            menu.put(dishType, new ArrayList<String>());
        }
        menu.get(dishType).add(dishName);
    }

    ArrayList<ArrayList<String>> generateCombos(int numberOfCombos, ArrayList<String> dishesList) {
        ArrayList<ArrayList<String>> combos = new ArrayList<>();
        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> selectedDishes = new ArrayList<>();
            for (String typeOfDish : dishesList) {
                int index = random.nextInt(menu.get(typeOfDish).size());
                String dish = menu.get(typeOfDish).get(index);
                selectedDishes.add(dish);
            }
            combos.add(selectedDishes);
        }
        return combos;
    }

    boolean checkType(String type) {
        return menu.containsKey(type);
    }
}
