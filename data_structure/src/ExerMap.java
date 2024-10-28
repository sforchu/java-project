import java.util.HashMap;

public class ExerMap {
    public static void main(String[] args) {
        HashMap<String, Integer> score = new HashMap<>();
        score.put("Smith", 20);
        score.put("Jack", 15);
        score.put("Mike", 35);
        score.put("Paul", 55);

        System.out.println(score);

        score.remove("Mike");
        System.out.println(score.get("Jack"));

        score.replace("Smith", 30);

        System.out.println(score);


    }
}
