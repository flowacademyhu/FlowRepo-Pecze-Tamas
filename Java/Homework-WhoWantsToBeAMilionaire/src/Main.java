import quest.Quest;
import quest.QuestLoader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream("/home/poczok/Work/Java/Homework-WhoWantsToBeAMilionaire/questions.txt")))) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                listQuestion.add(line);

            }
        } catch (IOException e) {
            System.err.printf("File not found");
        }
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream("/home/poczok/Work/Java/Homework-WhoWantsToBeAMilionaire/answers.txt")))) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                listAnswers.add(line);

            }
        } catch (IOException e) {
            System.err.printf("File not found");
        }
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream("/home/poczok/Work/Java/Homework-WhoWantsToBeAMilionaire/correctAnswer.txt")))) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                listCorrectA.add(line);

            }
        } catch (IOException e) {
            System.err.printf("File not found");
        }
        System.out.println(listQuestion);
        System.out.println(listAnswers);
        System.out.println(listCorrectA);
        Scanner sc = new Scanner(System.in);
        while(alive == true && counter < 4) {
            System.out.println(listQuestion.get(counter));
            counter++;
            for (int i = 0; i < 4; i++) {
                System.out.print( i+1 + " " + listAnswers.get(Acounter) + " ");
                Acounter++;
            }
            useranswer = sc.nextLine();
            if (useranswer.equals("telefon")){
                if(h.telephone == true) {
                    System.out.println("A helyes valasz valszeg a: " + listCorrectA.get(counter-1));
                    counter--;
                    Acounter = Acounter-4;
                    h.telephone = false;
                } else if(h.telephone == false) {
                    counter--;
                    Acounter = Acounter-4;
                    System.out.println("Nincs telefonos segitseged");
                }
            }
            if (useranswer.equals("kozonseg")){
                if(h.viewers == true) {
                    System.out.println("A helyes valasz a kozonseg szerint: " + listCorrectA.get(counter-1));
                    counter--;
                    Acounter = Acounter-4;
                    h.viewers = false;
                } else if(h.viewers == false) {
                    counter--;
                    Acounter = Acounter-4;
                    System.out.println("Nincs kozonseg segitseged");
                }
            }
            else if(Integer.parseInt(useranswer) == Integer.parseInt(listCorrectA.get(counter-1))) {
                System.out.println("fasza");
            }
            else {
                alive = false;
                System.out.println("helytelen valasz, vesztettel");
            }
        }
    }
}