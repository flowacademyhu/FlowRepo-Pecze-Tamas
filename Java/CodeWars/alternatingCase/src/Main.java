public class Main {
    public static void main(String[] args) {
        System.out.println(toAlternativeString("hellOOO boY"));
    }
    public static String toAlternativeString(String string) {
        String output = "";
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLowerCase(string.charAt(i))) {
                output += string.substring(i, i+1).toUpperCase();
            } else if (Character.isUpperCase(string.charAt(i))) {
                output += string.substring(i, i+1).toLowerCase();
            } else {
                output += string.substring(i,i+1);
            }
        }
        return output;
    }
}
