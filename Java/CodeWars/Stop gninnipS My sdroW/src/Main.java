public class Main {
    public static void main(String[] args) {
        /*import java.util.Arrays;

        public class SpinWords {

            public String spinWords(String sentence) {
                String[] words = sentence.split(" ");
                for (int i=0; i<words.length; i++) {
                    if (words[i].length() >= 5) {
                        words[i] = new StringBuilder(words[i]).reverse().toString();
                    }
                }
                return String.join(" ",words);
            }
        }*/
        //---
        /*
        import java.util.stream.*;
        import java.util.Arrays;

            public class SpinWords {

        public String spinWords(String sentence) {
                 return Arrays.stream(sentence.split(" "))
                 .map(i -> i.length() > 4 ? new StringBuilder(i).reverse().toString() : i)
                 .collect(Collectors.joining(" "));
  }
}
         */
    }
}
