
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Help h = new Help();
        List<String> listQuestion = new ArrayList<>();
        List<String> listAnswers = new ArrayList<>();
        List<String> listCorrectA = new ArrayList<>();
        boolean alive = true;
        int counter = 0;
        int Acounter = 0;
        String useranswer;
        Integer[] money = new Integer[] {0, 1000,5000,20000,1000000};
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream("/home/poczok/Work/Java/Homework-WhoWantsToBeAMilionaire/questions.txt")))) {
            bufferedReader.lines().forEach(
                    a -> {
                        listQuestion.add(a);
                    }
            );
        } catch (IOException e) {
            System.err.printf("File not found");
        }
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream("/home/poczok/Work/Java/Homework-WhoWantsToBeAMilionaire/answers.txt")))) {
            bufferedReader.lines().forEach(
                    a -> {
                        listAnswers.add(a);
                    }
            );
        } catch (IOException e) {
            System.err.printf("File not found");
        }
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream("/home/poczok/Work/Java/Homework-WhoWantsToBeAMilionaire/correctAnswer.txt")))) {
            bufferedReader.lines().forEach(
                    a -> {
                        listCorrectA.add(a);
                    }
            );
        } catch (IOException e) {
            System.err.printf("File not found");
        }
        System.out.println(listQuestion);
        System.out.println(listAnswers);
        System.out.println(listCorrectA);
        Scanner sc = new Scanner(System.in);
        while (alive == true && counter < 4) {
            System.out.println(listQuestion.get(counter));
            counter++;
            for (int i = 0; i < 4; i++) {
                System.out.println(i + 1 + " " + listAnswers.get(Acounter) + " ");
                Acounter++;
            }
            useranswer = sc.nextLine();
            if (useranswer.equals("telefon")) {
                if (h.telephone == true) {
                    System.out.println("A helyes valasz valszeg a: " + listCorrectA.get(counter - 1));
                    counter--;
                    Acounter = Acounter - 4;
                    h.telephone = false;
                } else if (h.telephone == false) {
                    counter--;
                    Acounter = Acounter - 4;
                    System.out.println("Nincs telefonos segitseged");
                }
            } else if (useranswer.equals("kozonseg")) {
                if (h.viewers == true) {
                    System.out.println("A helyes valasz a kozonseg szerint: " + listCorrectA.get(counter - 1));
                    counter--;
                    Acounter = Acounter - 4;
                    h.viewers = false;
                } else if (h.viewers == false) {
                    counter--;
                    Acounter = Acounter - 4;
                    System.out.println("Nincs kozonseg segitseged");
                }
            } else if (useranswer.equals("felezes")) {
                if (h.fiftyfifty == true) {
                    Acounter -= 4;
                    h.fiftyfifty = false;
                    int c = 2;
                    for (int i = 0; i < c; i++) {
                        int random = ThreadLocalRandom.current().nextInt(4);
                        if(listCorrectA.get(counter-1).equals(listAnswers.get(Acounter+random)) || listAnswers.get(Acounter+random).equals("---")) {
                             c++;
                        } else {
                            listAnswers.set(Acounter+random,"---");
                        }
                    }
                    System.out.println(listAnswers);
                    counter--;

                } else if (h.fiftyfifty == false) {
                    counter--;
                    Acounter = Acounter - 4;
                    System.out.println("Nincs felezes segitsege.");
                }
            } else if (useranswer.equals(listCorrectA.get(counter - 1))) {
                System.out.println("Helyes valasz");
            } else {
                alive = false;
                System.out.println("helytelen valasz, vesztettel");
            }
            System.out.println("Az On nyeremenye: " + money[counter]);
        }
        System.out.println("Koszonjuk, hogy velunk jatszott!");
    }
}