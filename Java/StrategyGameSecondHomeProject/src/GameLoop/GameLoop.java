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
    public GameLoop() {
        gameInit(garea);
        gameProcess();
    }

    private void gameInit(GameArea g) {
        for(int i = 0; i < FieldX; ++i) {
            for (int j = 0; j < FieldY; ++j) {
                arr[i][j] = new Fields(false);
            }
        }
        String bpNAME = "BluePlayer";
        String rpNAME = "RedPlayer";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Blue players name?");
        try {
            bpNAME = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Red players name?");
        try {
            rpNAME = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bp = new BluePlayer(bpNAME,"BLUE");
        rp = new RedPlayer(rpNAME,"RED");
        System.out.println(bp.getName() + " VS " + rp.getName());

        makeHeadQuarter(1,1,rp);
        makeHeadQuarter(2,3,bp);
        makeSolider(3,4,rp);
        makeSolider(3,5,bp);

        int randomStart = ThreadLocalRandom.current().nextInt(2);
        System.out.println("RANDOM: " + randomStart);
        if(randomStart == 1) {
            System.out.println(rp.getName() + " starts!");
            whosturn = rp.getName();
        } else {
            System.out.println(bp.getName() + " starts");
            whosturn = bp.getName();
        }
    }

    private void gameProcess() {
        System.out.println("Welcome to gameProcess!");
        Scanner sc = new Scanner(System.in);
        int roundCounter = 0;
       while(RedBuildings > 0 && BlueBuildings > 0) {
           while(!endturn){
                   actionSelect(whosturn);
               }
           System.out.println(whosturn + " turn ended. " + getEnemyName() + "'s turn!");
           whosturn = getEnemyName();
           endturn = false;
           }
              GameEnd();
           }

    private void GameEnd() {
        String tempA = "";
        System.out.println("Do you want to play another game?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            tempA = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(tempA.equals("YES") || tempA.equals("yes")) {
            //TODO clear data from old gameinit/processes
            gameInit(garea);
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
        System.out.println("5 Give up");
        Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
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
                        makeHeadQuarter(Integer.parseInt(input.substring(0, 1)), Integer.parseInt(input.substring(1, 2)), bp);
                        break;
                    } else if (input.equals("2")) {
                        getMap();
                        System.out.println("XY coordinates please");
                        input = sc.nextLine();
                        makeSniperTrainer(Integer.parseInt(input.substring(0, 1)), Integer.parseInt(input.substring(1, 2)), bp);
                        break;
                    }else if (input.equals("3")) {
                        getMap();
                        System.out.println("XY coordinates please");
                        input = sc.nextLine();
                        makeHospital(Integer.parseInt(input.substring(0, 1)), Integer.parseInt(input.substring(1, 2)), bp);
                        break;
                    }else if (input.equals("4")) {
                        getMap();
                        System.out.println("XY coordinates please");
                        input = sc.nextLine();
                        makeSolider(Integer.parseInt(input.substring(0, 1)), Integer.parseInt(input.substring(1, 2)), bp);
                        break;
                    }else if (input.equals("5")) {
                        getMap();
                        System.out.println("XY coordinates please");
                        input = sc.nextLine();
                        makeSniper(Integer.parseInt(input.substring(0, 1)), Integer.parseInt(input.substring(1, 2)), bp);
                        break;
                    }else if(input.equals("6")) {
                        break;
                    } else {
                        System.out.println("Invalid input. Try again...");
                    }
                case "5":
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
            garea.GameAreaBuilder(arr[x][y].getImg(), x, y);
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
            System.out.println("Hospital built.");
        }
    }
    private void makeSniper(int x,int y, Player player) {
        if(checkField(x,y)) {
            arr[x][y] = new Sniper(x, y, player);
            arr[x][y].setUsed(true);
        }
    }
    private void makeSolider(int x,int y, Player player) {
        if(checkField(x,y)) {
            arr[x][y] = new Soldier(x, y, player);
            arr[x][y].setUsed(true);
        }
    }
    private boolean checkField(int x, int y) {
        if (arr[x][y].isUsed()) {
            System.out.println(x + ":" + y + " Field is in use!");
            System.out.println(arr[x][y].toString());
            return false;
        } else {
            System.out.println("success!");
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
    private boolean move(Unit u, int mtx, int mty) {
        if(!checkField(u.getLocationX() + mtx,u.getLocationY() + mty)) {
            return false;
        } else {
            u.setUsed(false);
            u.setLocationX(u.getLocationX() + mtx);
            u.setLocationY(u.getLocationY() + mty);
            return true;
        }
    }
}

