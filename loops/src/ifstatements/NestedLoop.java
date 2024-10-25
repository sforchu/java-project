package ifstatements;

import java.util.Arrays;

public class NestedLoop {
    public static void main(String[] args) {

        int[][] num = {{1, 2, 3}, {4, 5, 6}, {7,8,9}, {10, 11, 12}};
        System.out.println(num.length);
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[j].length; j++) {
                System.out.println(num[i][j]);
            }
        }

//        int[][] num1 = {{1, 2, 3}, {4, 5, 6}};
//        System.out.println(Arrays.toString(num[0]));
    }
}
