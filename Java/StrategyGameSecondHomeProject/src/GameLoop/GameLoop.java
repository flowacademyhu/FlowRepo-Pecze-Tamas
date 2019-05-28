package GameLoop;
import Fields.Buildings.Building;
import Fields.Buildings.Headquarter;
import Fields.Buildings.Hospital;
import Fields.Buildings.SniperTrainer;
import Fields.Fields;
import Fields.Units.Sniper;
import Fields.Units.Soldier;
import Fields.Units.Unit;
import GameArea.GameArea;
import Players.BluePlayer;
import Players.Player;
import Players.RedPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class GameLoop {
    AtomicInteger counter = new AtomicInteger(0);
    GameArea garea = new GameArea();
    final Integer FieldX = 10;
    final Integer FieldY = 10;
    Fields[][] arr = new Fields[FieldX][FieldY];
    BluePlayer bp;
    RedPlayer rp;
    Integer RedBuildings = 0;
    Integer BlueBuildings = 0;
    String whosturn;
    boolean endturn = false;
    String input = "0000";
    public GameLoop() {
        gameInit();
        gameProcess();
    }

    private void gameInit() {
        for(int i = 0; i < FieldX; ++i) {
            for (int j = 0; j < FieldY; ++j) {
                arr[i][j] = new Fields(false);
            }
        }
        String bpNAME = "BluePlayer";
        String rpNAME = "RedPlayer";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        garea.log.append("\nBlue players name?");
        System.out.println("Blue players name?");
        garea.userInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                garea.log.append("Text=" + garea.userInput.getText() + "\n");
            }
        });
        try {
            bpNAME = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Red players name?");
        garea.log.append("\nRed players name?");
        try {
            rpNAME = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bp = new BluePlayer(bpNAME,"BLUE");
        rp = new RedPlayer(rpNAME,"RED");
        garea.log.append("\n" + bp.getName() + " VS " + rp.getName());
        System.out.println(bp.getName() + " VS " + rp.getName());

        makeHeadQuarter(1,1,rp);
        makeHeadQuarter(2,3,bp);
        makeSolider(3,4,rp);
        makeSolider(3,5,bp);

        int randomStart = ThreadLocalRandom.current().nextInt(2);
        System.out.println("RANDOM: " + randomStart);
        if(randomStart == 1) {
            System.out.println(rp.getName() + " starts!");
            garea.log.append("\n" + rp.getName() + " starts!");
            whosturn = rp.getName();
        } else {
            System.out.println(bp.getName() + " starts");
            garea.log.append("\n" + bp.getName() + " starts");
            whosturn = bp.getName();
        }
    }

    private void gameProcess() {
        System.out.println("Welcome to gameProcess!");
        garea.log.append("\n" + "Welcome to gameProcess!");
        Scanner sc = new Scanner(System.in);
        int roundCounter = 0;
       while(RedBuildings > 0 && BlueBuildings > 0) {
           while(!endturn){
                   actionSelect(whosturn);
               }
           whosturn = getEnemyName();
           endturn = false;
           }
              GameEnd();
           }

    private void GameEnd() {
        String tempA = "";
        System.out.println("Do you want to play another game?");
        garea.log.append("\n" + "Do you want to play another game?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            tempA = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(tempA.equals("YES") || tempA.equals("yes")) {
            //TODO clear data from old gameinit/processes
            gameInit();
            gameProcess();
        } else {
            System.exit(1);
        }
    }

    private void actionSelect(String whosturn) {
        System.out.println("What you want to do?");
        System.out.println("1 Get map information");
        System.out.println("2 Attack building");
        System.out.println("3 Attack unit");
        System.out.println("4 Build Building/Recruit Unit");
        System.out.println("5 Move with unit");
        System.out.println("6 EndTurn");
        System.out.println("7 Give up");
        garea.log.setText("");
        garea.log.append("\n" + "What you want to do?");
        garea.log.append("\n" + "1 Get map information");
        garea.log.append("\n" + "2 Attack building");
        garea.log.append("\n" + "3 Attack unit");
        garea.log.append("\n" + "4 Build Building/Recruit Unit");
        garea.log.append("\n" + "5 Move with unit");
        garea.log.append("\n" + "6 EndTurn");
        garea.log.append("\n" + "7 Give up");
        Scanner sc = new Scanner(System.in);
            input = sc.nextLine();
            switch (input) {
                case "1":
                    getMap();
                    break;
                case "2":
                    System.out.println("YourUnit XY and Enemy Building XY (format:'XYXY') REQUIRED!x");
                    input = sc.nextLine();
                    AttackBuilding(whosturn, (Unit) arr[Integer.parseInt(input.substring(0, 1))][Integer.parseInt(input.substring(1, 2))],
                            (Building) arr[Integer.parseInt(input.substring(2, 3))][Integer.parseInt(input.substring(3, 4))]);
                    break;
                case "3":
                    System.out.println("YourUnit XY and Enemy Unit XY (format: 'XYXY' ");
                    input = sc.nextLine();
                    AttackUnit(whosturn, (Unit) arr[Integer.parseInt(input.substring(0, 1))][Integer.parseInt(input.substring(1, 2))],
                            (Unit) arr[Integer.parseInt(input.substring(2, 3))][Integer.parseInt(input.substring(3, 4))]);
                    break;
                case "4":
                    if (bp.getName().equals(whosturn)) {
                        System.out.println("You have " + bp.getGP() + " points to build");
                    } else {
                        System.out.println("You have " + rp.getGP() + " points to build");
                    }
                    System.out.println("What you want to do? 1 Build HQ" +
                            " 2 Build SniperTrainer 3 Build Hospital 4 Recruit Solider 5 Reqcruit Sniper 6 Cancel");
                    input = sc.nextLine();
                    if (input.equals("1")) {
                        getMap();
                        System.out.println("XY coordinates please");
                        input = sc.nextLine();
                        makeHeadQuarter(subsStringZeroOne(input), subsStringOneTwo(input), bp);
                        break;
                    } else if (input.equals("2")) {
                        getMap();
                        System.out.println("XY coordinates please");
                        input = sc.nextLine();
                        makeSniperTrainer(subsStringZeroOne(input), subsStringOneTwo(input), bp);
                        break;
                    }else if (input.equals("3")) {
                        getMap();
                        System.out.println("XY coordinates please");
                        input = sc.nextLine();
                        makeHospital(subsStringZeroOne(input), subsStringOneTwo(input), bp);
                        break;
                    }else if (input.equals("4")) {
                        getMap();
                        System.out.println("XY coordinates please");
                        input = sc.nextLine();
                        makeSolider(subsStringZeroOne(input), subsStringOneTwo(input), bp);
                        break;
                    }else if (input.equals("5")) {
                        getMap();
                        System.out.println("XY coordinates please");
                        input = sc.nextLine();
                        makeSniper(subsStringZeroOne(input), subsStringOneTwo(input), bp);
                        break;
                    }else if(input.equals("6")) {
                        break;
                    } else {
                        System.out.println("Invalid input. Try again...");
                        break;
                    }
                case "5":
                    System.out.println("what unit you wanna move? And to What coordinate? XYXY coordinates please.");
                    input = sc.nextLine();
                    if(arr[subsStringZeroOne(input)][subsStringOneTwo(input)] instanceof Soldier){
                        move((Unit)arr[subsStringZeroOne(input)][subsStringOneTwo(input)],
                                subsStringTwoThree(input),subsStringThreeFour(input), 1, whosturn);
                    } else if(arr[subsStringZeroOne(input)][subsStringOneTwo(input)] instanceof Sniper) {
                        move((Unit) arr[subsStringZeroOne(input)][subsStringOneTwo(input)],
                                subsStringTwoThree(input),subsStringThreeFour(input),2, whosturn);
                    } else {
                        System.out.println(input);
                        System.out.println(subsStringZeroOne(input) + " " + subsStringOneTwo(input));
                        System.out.println("not a unit.");
                    }
                    break;
                case "6":
                    System.out.println("End turn? Y/N");
                    input = sc.nextLine();
                    if(input.equals("y") || input.equals("Y")){
                        System.out.println(whosturn + " turn ended. " + getEnemyName() + "'s turn.");
                        endturn = true;
                    }
                    break;
                case "7":
                    System.out.println("Are you sure you want to give up? Y/N");
                    input = sc.nextLine();
                    if(input.equals("y") || input.equals("Y")){
                        System.out.println(whosturn + "gave up. " + getEnemyName() + " won the game!");
                        GameEnd();
                    }
                    break;

            }
    }

    private String getEnemyName() {
        if(!whosturn.equals(rp.getName())) {
            return rp.getName();
        }
        return bp.getName();
    }

    private void getMap() {
        for (int i = 1; i < FieldX; i++) {
               for (int j = 1; j < FieldY; j++) {
                   if (arr[i][j].isUsed()) {
                       System.out.println(i + ":" + j + " " + arr[i][j].toString());
                   }
               }
           }
    }

    private void makeHeadQuarter(int x, int y, Player player) {
        if(checkField(x,y)) {
            arr[x][y] = new Headquarter(x, y, player);
            arr[x][y].setUsed(true);
            if (player.getColor().equals(bp.getColor())) {
                BlueBuildings++;
            } else {
                RedBuildings++;
            }
            garea.GameAreaBuilder(arr[x][y], x, y);
            System.out.println("Headquarter built.");
        }
    }
    private void makeHospital(int x, int y, Player player) {
        if(checkField(x,y)) {
            arr[x][y] = new Hospital(x, y, player);
            arr[x][y].setUsed(true);
            if (player.getColor().equals(bp.getColor())) {
                BlueBuildings++;
            } else {
                RedBuildings++;
            }
            garea.GameAreaBuilder(arr[x][y], x, y);
            System.out.println("Hospital built.");
        }
    }
    private void makeSniperTrainer(int x, int y, Player player) {
        if(checkField(x,y)) {
            System.out.println("hello");
            arr[x][y] = new SniperTrainer(x, y, player);
            arr[x][y].setUsed(true);
            if (player.getColor().equals(bp.getColor())) {
                BlueBuildings++;
            } else {
                RedBuildings++;
            }
            garea.GameAreaBuilder(arr[x][y], x, y);
            System.out.println("Sniper built.");
        }
    }
    private void makeSniper(int x,int y, Player player) {
        if(checkField(x,y)) {
            arr[x][y] = new Sniper(x, y, player);
            arr[x][y].setUsed(true);
        }
        garea.GameAreaBuilder(arr[x][y], x, y);
    }
    private void makeSolider(int x,int y, Player player) {
        if(checkField(x,y)) {
            arr[x][y] = new Soldier(x, y, player);
            arr[x][y].setUsed(true);
        }
        garea.GameAreaBuilder(arr[x][y], x, y);
    }
    private boolean checkField(int x, int y) {
        if (arr[x][y].isUsed()) {
            System.out.println(x + ":" + y + " Field is in use!");
            System.out.println(arr[x][y].toString());
            return false;
        } else {
            return true;
        }
    }
    private void AttackBuilding(String whosturn, Unit u, Building b) {
        System.out.println("Attacking Building " + b.getLocationY() + " " + b.getLocationX() + " With unit"
                + u.getLocationX() + " " + u.getLocationX() + " Building HP: " + b.getHitPoints());
        if(!b.getPlayer().getName().equals(whosturn)) {
            if (u instanceof Sniper) {
                b.setHitPoints(b.getHitPoints() - 45);
            } else {
                b.setHitPoints(b.getHitPoints() - 20);
            }
            if (b.getHitPoints() <= 0) {
                arr[b.getLocationX()][b.getLocationY()].setUsed(false);
                arr[b.getLocationX()][b.getLocationY()] = null;
            }
            System.out.println("attack ended, building new hitpoints: " + b.getHitPoints());
        } else {
            System.out.println("You are trying to attack your own unit: " + b.getLocationX() + ":"+ b.getLocationY());
        }
    }
    private void AttackUnit(String whosturn, Unit u1, Unit u2) {
        if (!u2.getPlayer().getName().equals(whosturn)) {
            if (u1 instanceof Sniper) {
                u2.setHealth(u2.getHealth() - 45);
            } else {
                u2.setHealth(u2.getHealth() - 20);
            }
            if (u2.getHealth() <= 0) {
                arr[u2.getLocationX()][u2.getLocationY()].setUsed(false);
                arr[u2.getLocationX()][u2.getLocationY()] = null;
                System.out.println("unit megmurdalt!");
                System.out.println(arr[u2.getLocationX()][u2.getLocationY()].isUsed());
            }
        } else {
            System.out.println("You can't attack your own unit:" + u2.getLocationX() + ":"+ u2.getLocationY());
        }
    }
    private void move(Unit u, int newX, int  newY, int distance, String whosturn) {
        if(checkField(u.getLocationX() + distance,u.getLocationY() + distance)) {
            if(u.getPlayer().getName() == whosturn) {
                garea.GameAreaBuilder(u.getLocationX(), u.getLocationY(),u.getLocationX() + distance,
                        u.getLocationY() + distance, u.getImg());
                arr[newX][newY] = arr[u.getLocationX()][u.getLocationY()];
                arr[u.getLocationX()][u.getLocationY()] = new Fields(false);
                System.out.println("Successful move");
            } else {
                System.out.println("It's not your unit.");
            }
        } else {
            System.out.println("Failed to make move. Location is used by something already.");
        }
    }
    private int subsStringZeroOne (String input) {
        return Integer.parseInt(input.substring(0, 1));
    }
    private int subsStringOneTwo (String input) {
        return Integer.parseInt(input.substring(1, 2));
    }
    private int subsStringTwoThree (String input) {
        return Integer.parseInt(input.substring(2, 3));
    }
    private int subsStringThreeFour (String input) {
        return Integer.parseInt(input.substring(3, 4));
    }
}

