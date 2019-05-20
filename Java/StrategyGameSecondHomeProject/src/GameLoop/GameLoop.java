package GameLoop;
import Fields.Buildings.Building;
import Fields.Buildings.Headquarter;
import Fields.Buildings.Hospital;
import Fields.Fields;
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
        makeHeadQuarter(5,5,"BLUE");
    }

    private void gameProcess() {

       while(RedBuildings > 0 && BlueBuildings > 0) {
           for (int i = 1; i < FieldX; i++) {
               for (int j = 1; j < FieldY; j++) {
                   if (!arr[i][j].isUsed()) {
                       System.out.println(i + ":" + j);
                   }
               }
           }
           RedBuildings--;
           System.out.println(RedBuildings + " und " + BlueBuildings);
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
        System.out.println("hello");
        arr[x][y] = new Headquarter(x,y, color);
        arr[x][y].setUsed(true);
        if(color.equals("RED")){
            BlueBuildings++;
        } else {
            RedBuildings++;
        }
        garea.set
    }


}

