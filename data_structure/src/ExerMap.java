import java.util.HashMap;

public class ExerMap {
    public static void main(String[] args) {
        HashMap<String, Integer> score = new HashMap<>();
        score.put("Smith", null);
        score.put("Jack", 15);
        score.put("Mike", 35);
        score.put("Paul", 55);

        System.out.println(score);

        score.remove("Mike");
        System.out.println(score.get("Jack"));

        System.out.println(score.replace("James", 30));
//        score.put("Smith", 30);

        System.out.println(score);


    }
}
