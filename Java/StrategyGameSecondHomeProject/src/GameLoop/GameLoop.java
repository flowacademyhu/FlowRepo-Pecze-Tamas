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
        try {
            bpNAME = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            rpNAME = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bp = new BluePlayer(bpNAME,"BLUE");
        rp = new RedPlayer(rpNAME,"RED");

        makeHeadQuarter(1,1,"RED");
        makeHeadQuarter(2,3,"BLUE");
        makeSolider(3,4,"RED");
        makeSolider(3,5,"BLUE");
    }

    private void gameProcess() {

       while(RedBuildings > 0 && BlueBuildings > 0) {
           /*for (int i = 1; i < FieldX; i++) {
               for (int j = 1; j < FieldY; j++) {
                   if (!arr[i][j].isUsed()) {
                       System.out.println(i + ":" + j);
                   }
               }
           }*/
        AttackUnit((Unit)arr[3][4], (Unit)arr[3][5]);
           AttackUnit((Unit)arr[3][4], (Unit)arr[3][5]);
           AttackUnit((Unit)arr[3][4], (Unit)arr[3][5]);
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

    private void makeHeadQuarter(int x, int y, String color) {
        if(checkField(x,y)) {
            arr[x][y] = new Headquarter(x, y, color);
            arr[x][y].setUsed(true);
            if (color.equals("BLUE")) {
                BlueBuildings++;
            } else {
                RedBuildings++;
            }
        }
    }
    private void makeHospital(int x, int y, String color) {
        if(checkField(x,y)) {
            System.out.println("hello");
            arr[x][y] = new Hospital(x, y, color);
            arr[x][y].setUsed(true);
            if (color.equals("BLUE")) {
                BlueBuildings++;
            } else {
                RedBuildings++;
            }
        }
    }
    private void makeSniperTrainer(int x, int y, String color) {
        if(checkField(x,y)) {
            System.out.println("hello");
            arr[x][y] = new SniperTrainer(x, y, color);
            arr[x][y].setUsed(true);
            if (color.equals("BLUE")) {
                BlueBuildings++;
            } else {
                RedBuildings++;
            }
        }
    }
    private void makeSniper(int x,int y, String color) {
        if(checkField(x,y)) {
            arr[x][y] = new Sniper(x, y, color);
            arr[x][y].setUsed(true);
        }
    }
    private void makeSolider(int x,int y, String color) {
        if(checkField(x,y)) {
            arr[x][y] = new Soldier(x, y, color);
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
        if(u.getPrice() == 60) {
            b.setHitPoints(b.getHitPoints()-45);
        } else {
            b.setHitPoints(b.getHitPoints()-20);
        }
        if(b.getHitPoints() <= 0) {
            arr[b.getLocationX()][b.getLocationY()].setUsed(false);
            arr[b.getLocationX()][b.getLocationY()] = null;
        }
    }
    private void AttackUnit(Unit u1, Unit u2) {
        if(u1.getPrice() == 40) {
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
}

