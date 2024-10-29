import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class ExerTree {
    public static void main(String[] args) {
        int[] ages = {8, 2, 4, 3, 9, 2};

        TreeSet<Integer> ageTree = new TreeSet<>();

//        Enhanced for loop
        for (int age : ages) {
            ageTree.add(age);
        }

//        Regular loop
//        for (int i = 0; i < ages.length; i++) {
//            ageTree.add(ages[i]);
//        }

        System.out.println(Arrays.toString(ages));
        System.out.println(ageTree);


    }
}
