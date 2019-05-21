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
    /*


     */
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
        if(randomStart == 0) {
            System.out.println("Red player starts!");
            whosturn = rp.getName();
        } else {
            System.out.println("Blue player starts");
            whosturn = bp.getName();
        }
    }

    private void gameProcess() {
        System.out.println("Welcome to gameProcess!");
        Scanner sc = new Scanner(System.in);
        int roundCounter = 0;
       while(RedBuildings > 0 && BlueBuildings > 0) {
           endturn = false;
           while(!endturn){
               if(whosturn.equals(rp.getName())) {
                   System.out.println("Blue players turn!");
                   actionSelect(bp.getName());
               } else {
                   System.out.println("Red players turn!");
                   actionSelect(rp.getName());
               }
           }
           System.out.println("next player");
           while(sc.nextLine().equals("endturn")) {
               System.out.println("Round: " + roundCounter);
               switch (sc.nextLine()) {
                   case "u1 attack b1":
                       AttackBuilding((Building)arr[1][1],(Unit)arr[3][5]);
                       break;
               }
               roundCounter++;
           }

        /*AttackUnit((Unit)arr[3][4], (Unit)arr[3][5]);
           AttackUnit((Unit)arr[3][4], (Unit)arr[3][5]);
           AttackUnit((Unit)arr[3][4], (Unit)arr[3][5]);*/
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

    private void actionSelect(String player) {
        if(player.equals(rp.getName())){
            System.out.println("What you want to do?");
            System.out.println("1 Get map information: 1MAP");
            System.out.println("2 Attack building: 2XY");
            System.out.println("3 Attack unit: 3XYXY");
            System.out.println("4 Give up: 4EXIT");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            switch (input) {
                case "1MAP":
                    getMap();
            }
        }

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
    private void AttackBuilding(Building b, Unit u) {
        System.out.println("Attacking Building " + b.getLocationY() + " " + b.getLocationX() + " With unit"
                + u.getLocationX() + " " + u.getLocationX() + " Building HP: " + b.getHitPoints());
        if(u.getPrice() == 60) {
            b.setHitPoints(b.getHitPoints()-45);
        } else {
            b.setHitPoints(b.getHitPoints()-20);
        }
        if(b.getHitPoints() <= 0) {
            arr[b.getLocationX()][b.getLocationY()].setUsed(false);
            arr[b.getLocationX()][b.getLocationY()] = null;
        }
        System.out.println("attack ended, building new hitpoints: " + b.getHitPoints());
    }
    private void AttackUnit(Unit u1, Unit u2) {
        if(u1 instanceof Sniper) {
            u2.setHealth(u2.getHealth()-45);
        } else {
            u2.setHealth(u2.getHealth()-20);
        }
        if(u2.getHealth() <= 0) {
            arr[u2.getLocationX()][u2.getLocationY()].setUsed(false);
            arr[u2.getLocationX()][u2.getLocationY()] = null;
            System.out.println("unit megmurdalt!");
            System.out.println(arr[u2.getLocationX()][u2.getLocationY()].isUsed());
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

