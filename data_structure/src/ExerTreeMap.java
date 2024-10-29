import java.util.TreeMap;

public class ExerTreeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> age = new TreeMap<>();
        age.put("Lum", 31);
        age.put("Ojong", 45);
        age.put("Nana", 20);
        age.put("Bih", 28);

        System.out.println(age);

        age.remove("Lum");
        System.out.println(age.get("Nana"));

        age.replace("Bih", 30);

        System.out.println(age);
    }
}
