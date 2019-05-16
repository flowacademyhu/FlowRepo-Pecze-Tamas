package GameLoop;

import Fields.Buildings.Building;
import Fields.Buildings.Headquarter;
import GameArea.GameArea;
import Players.BluePlayer;
import Players.RedPlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class GameLoop {
    <Integer,Building> buildings = new HashMap<Integer, Building>();
    public GameLoop() {
        GameArea garea = new GameArea();
        gameInit(garea);
        gameProcess();
    }
    /*


     */
    private void gameInit(GameArea g) {
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
        BluePlayer bp = new BluePlayer(bpNAME,"BLUE");
        RedPlayer rp = new RedPlayer(rpNAME,"RED");

        Headquarter headquarter2 = new Headquarter(9,9,"BLUE");

    }

    public void gameProcess() {

    }
    public void makeHeadQuarter(int x, int y, String color) {

        buildings.put(new Headquarter(0,0, "RED"));
    }

}

