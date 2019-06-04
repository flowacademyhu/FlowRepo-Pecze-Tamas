import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        System.out.println(HighAndLow("3 4 6 81 9 55 1"));
    }

    public static String HighAndLow(String numbers) {
        var list = new ArrayList<Integer>();
        int counter = 0;
        for (int i = 0; i <= numbers.length(); i++) {
            try{
                if (!numbers.substring(i, i + 1).equals(" ") && !numbers.substring(i + 1, i + 2).equals(" ")) {
                    list.add(Integer.parseInt(numbers.substring((i - 1) - counter, i + 1)));
                    counter = 0;
                } else if (numbers.substring(i, i + 1).equals(" ")) {
                    list.add(Integer.parseInt(numbers.substring((i -1) - counter, i)));
                    counter = 0;
                }
            } catch (Exception e) {
                System.out.println(e);
                counter++;
            }
        }
        list.add(Character.getNumericValue(numbers.charAt(numbers.length()-1)));
        list.forEach(lista-> System.out.println(lista));
        return "throw towel";
    }
    }
