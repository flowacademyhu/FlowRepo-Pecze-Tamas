import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        /*var collection1 = new ArrayList<String>();
        collection1.add("Elso elem");
        collection1.add("Masodik elem");
        collection1.add("Harmadik elem");
        collection1.forEach(s -> System.out.println(s));*/
        /*var collection2 = new HashMap<String, String>();
        collection2.put("elso","elsoErtek");
        collection2.put("masodik","masodikErtek");
        collection2.put("harmadik","harmadikErtek");
        collection2.put("negyedik","negyedikErtek");
        for(String k: collection2.keySet()){
            System.out.println(k);
        }*/
        var collection3 = new LinkedHashMap<String, String>();
        collection3.put("elso","elsoErtek");
        collection3.put("masodik","masodikErtek");
        collection3.put("harmadik","harmadikErtek");
        collection3.put("negyedik","negyedikErtek");
        for(String k: collection3.keySet()){
            System.out.println(k);
        }
    }
}
