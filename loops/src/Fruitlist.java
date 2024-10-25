//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Fruitlist {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("peach");
        fruits.add("pear");

//        // Loop through the list using a traditional for loop
//        for (int i = 0; i < fruits.size(); i++) {
//            System.out.println(fruits.get(i));
//
//        }
//
//        // Loop through the list using a for-each loop
//        for (String fruit:fruits) {
//            System.out.println(fruit);
//        }

        // Loop through the list using an iterator
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // print the list
        System.out.println(fruits);

    }
    }


