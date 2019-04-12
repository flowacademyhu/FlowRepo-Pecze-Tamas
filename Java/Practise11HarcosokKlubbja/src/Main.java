import HarcosokKlubbja.Harcos;
import HarcosokKlubbja.Nagydarab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main (String[] args) {
        List<String> input = new ArrayList<>();
        int harc = 0;
        int nagyD = 0;
        for (int i = 0; i < args.length; i++) {
            input.add(args[i]);
        }
        for (int j = 0; j < input.size(); j++) {
            if(input.get(j).matches("Harcos")) {
                build(input.get(j + 1),input.get(j + 1));
                j+=2;
            } else if (input.get(j).matches("Nagydarab")) {
                build(input.get(j + 1),input.get(j + 1),input.get(j + 2));
                j+=3;
            }
        }
        System.out.println(harc + " hely " + nagyD);
        System.out.println(input);

        meccs(harcos,harcos2);

    }
    public static Harcos build (String h1, String h2) {
        return new Harcos(Integer.parseInt(h1),Integer.parseInt(h2)); //listbe
        }
    public static Nagydarab build (String h1, String h2, String h3) {
        Nagydarab harcos2 = new Nagydarab(Integer.parseInt(h1),Integer.parseInt(h2),Integer.parseInt(h3));
    }

    public static void meccs (Harcos h1, Nagydarab h2) {
        int random;
        Random r = new Random();
        int counter = 0;
        do{
            counter++;
            System.out.println("round: " + counter);
            random =r.nextInt(2);
            if(random == 0) {
                System.out.println("h2 kezd");
                h2.megutH(h1);
                if(h1.getEgeszseg() > 0) {
                h1.megutN(h2);
                }
            } else {
                h1.megutN(h2);
                System.out.println("h1 kezd");
                if(h2.getEgeszseg() > 0) {
                    h2.megutH(h1);
                }
            }
            System.out.print("h1 elete: " + h1.getEgeszseg() + " h2 elete: " + h2.getEgeszseg());
        } while (h1.getEgeszseg() > 0 && h2.getEgeszseg() > 0);

        if ((h1.getEgeszseg() <= 0 && h2.getEgeszseg() <= 0) || (h1.getEgeszseg() > 0 && h2.getEgeszseg() > 0)) {
            System.out.println("Dontetlen");
        } else if ( h1.getEgeszseg() <= 0) {
            System.out.println("Masodik jatekos nyert!!!");
        } else if ( h2.getEgeszseg() <= 0){
            System.out.println("Elso jatekos nyert");
        } else {
            System.err.println("else ag?!");
        }
    }
}
