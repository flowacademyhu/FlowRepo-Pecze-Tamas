package GameArea;
import Fields.Buildings.Building;
import Fields.Buildings.Headquarter;
import Fields.Buildings.Hospital;
import Fields.Buildings.SniperTrainer;
import Fields.Fields;
import Fields.Units.Sniper;
import Fields.Units.Soldier;
import Fields.Units.Unit;
import Players.BluePlayer;
import Players.Player;
import Players.RedPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Target;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class GameArea extends JFrame {
         private JPanel map = new JPanel(new GridLayout(10,10));
         private JLabel[][] labels  = new JLabel[10][10];
         private JTextArea log;
         private JTextField userInput;
         private JLabel selectedTarget;
         private JLabel whosturnLabel;
         private JButton moveUnitButton;
         private boolean secondXYgetter;
         private int x = -1;
         private int y = -1;
         private int TargetX = -1;
         private int TargetY = -1;
         AtomicInteger counter = new AtomicInteger(0);
         final int FieldX = 10;
         final int FieldY = 10;
         Fields[][] arr = new Fields[FieldX][FieldY];
         BluePlayer bp;
         RedPlayer rp;
         Integer RedBuildings = 0;
         Integer BlueBuildings = 0;
         String whosturn;
         boolean endturn = false;
         String input = "0000";
         private Icon DefaultIcon = new ImageIcon("img/qwe150.png");

    public GameArea() {

        super("Strategy game");
        this.setSize(1300,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        secondXYgetter = false;

        JButton attackUnitButton= new JButton("Attack unit");
        //attackUnitButton.addMouseListener(e -> );
        JButton attackBuildingButton= new JButton("Attack building");
        moveUnitButton= new JButton("Move unit");
        moveUnitButton.addActionListener(e -> moveCheck());
        selectedTarget = new JLabel("Nothing selected yet.");
        whosturnLabel = new JLabel("Waiting for game init");
        JPanel southPanel = new JPanel();
        JLabel userInputText = new JLabel("Input here please:");
        log = new JTextArea("Game history");
        log.setColumns(15);
        log.setRows(20);
        log.setEditable(false);
        southPanel.add(attackUnitButton);
        southPanel.add(attackBuildingButton);
        southPanel.add(whosturnLabel);
        southPanel.add(moveUnitButton);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(selectedTarget, BorderLayout.PAGE_START);
        this.add(map, BorderLayout.CENTER);

        userInput = new JTextField();
        userInput.setPreferredSize(new Dimension(300,30));
        Box eastPanel = Box.createVerticalBox();
        eastPanel.add(Box.createVerticalGlue());
        eastPanel.add(log);
        eastPanel.add(Box.createVerticalGlue());
        eastPanel.add(userInputText, BorderLayout.CENTER);
        eastPanel.add(Box.createVerticalGlue());
        eastPanel.add(userInput, BorderLayout.SOUTH);
        this.add(eastPanel, BorderLayout.EAST);

        GameAreaInit();
        gameInit();
        gameProcess();
    }

    private void moveCheck() {
        if(x >= 0 && y >= 0) {
            secondXYgetter = true;
            if(TargetX >= 0 && TargetY >= 0) {
                move(x, y, TargetX, TargetY, (Unit) arr[x][y], whosturn);
                log.append("\nMove successful.");
            }else {
                log.append("\nSelect a target!");
            }
        } else {
            log.append("\nTarget a unit with what you want to move.");
        }
    }

    private void getUserData(String userInput) {

    }

    private  void GameAreaInit() {
        for(int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                labels[i][j] = new JLabel();
                labels[i][j].setIcon(getDefaultIcon());
                String mouseLocation = i + "" + j;
                map.add(labels[i][j]);
                labels[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println(mouseLocation);
                        getMouseClick(mouseLocation);
                    }
                });
            }
        }
    }

    private void getMouseClick(String mouseLocation) {
        if(!secondXYgetter) {
            x = Integer.parseInt(mouseLocation.substring(0, 1));
            y = Integer.parseInt(mouseLocation.substring(1, 2));
            selectedTarget.setText("Selected: " + arr[x][y]);
        } else {
            TargetX = Integer.parseInt(mouseLocation.substring(0, 1));
            TargetY = Integer.parseInt(mouseLocation.substring(1, 2));
            selectedTarget.setText("Selected: " + arr[TargetX][TargetX]);
        }
    }

    public void GameAreaBuilder(Fields f1, int x, int y) {
                int hp = 0;
                if(f1 instanceof Building) {
                    hp = ((Building) f1).getHitPoints();
                } else if (f1 instanceof Unit){
                    hp = ((Unit) f1).getHealth();
                }
                labels[x][y].setIcon(f1.getImg());
                labels[x][y].setName(x + "" + y);
                labels[x][y].setText(String.valueOf(hp));
                labels[x][y].setHorizontalTextPosition(JLabel.CENTER);
                labels[x][y].setVerticalTextPosition(JLabel.CENTER);
                map.repaint();
                map.revalidate();
    }
    public void GameAreaBuilder(int OldX, int OldY, int x, int y, ImageIcon newIcon) {
        labels[OldX][OldY].setIcon(DefaultIcon);
        labels[x][y].setIcon(newIcon);
        map.repaint();
        map.revalidate();
    }

    public void setLabels(JLabel[][] labels) {
        this.labels = labels;
    }

    public void setMap(JPanel map) {
        this.map = map;
    }
    public Icon getDefaultIcon() {
        return DefaultIcon;
    }

    public void gameInit() {
        for(int i = 0; i < FieldX; ++i) {
            for (int j = 0; j < FieldY; ++j) {
                arr[i][j] = new Fields(false);
            }
        }
        String bpNAME = "BluePlayer";
        String rpNAME = "RedPlayer";

        bp = new BluePlayer(bpNAME,"BLUE");
        rp = new RedPlayer(rpNAME,"RED");
        log.append("\n" + bp.getName() + " VS " + rp.getName());
        System.out.println(bp.getName() + " VS " + rp.getName());

        makeHeadQuarter(1,1,rp);
        makeHeadQuarter(2,3,bp);
        makeSolider(3,4,rp);
        makeSolider(3,5,bp);

        int randomStart = ThreadLocalRandom.current().nextInt(2);
        System.out.println("RANDOM: " + randomStart);
        if(randomStart == 1) {
            System.out.println(rp.getName() + " starts!");
            log.append("\n" + rp.getName() + " starts!");
            whosturn = rp.getName();
        } else {
            System.out.println(bp.getName() + " starts");
            log.append("\n" + bp.getName() + " starts");
            whosturn = bp.getName();
        }
        whosturnLabel.setText(whosturn);
    }
    private void gameProcess() {
        System.out.println("Welcome to gameProcess!");
        log.append("\n" + "Welcome to gameProcess!");
        int roundCounter = 0;
        while(RedBuildings > 0 && BlueBuildings > 0) {
            while(!endturn){

            }
            whosturn = getEnemyName();
            endturn = false;
        }
        GameEnd();
    }
    private void GameEnd() {
        String tempA = "";
        System.out.println("Do you want to play another game?");
        log.append("\n" + "Do you want to play another game?");
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
    public int gameOptions() {
        log.setText("");
        log.append("\n" + "What you want to do?");
        log.append("\n" + "1 Get map information");
        log.append("\n" + "2 Attack building");
        log.append("\n" + "3 Attack unit");
        log.append("\n" + "4 Build Building/Recruit Unit");
        log.append("\n" + "5 Move with unit");
        log.append("\n" + "6 EndTurn");
        log.append("\n" + "7 Give up");
        return 1; // fail
    }
    public void actionSelect(String whosturn, int x, int y, int targetX, int targetY) {
        log.setText("");
        log.append("\n" + "What you want to do?");
        log.append("\n" + "1 Get map information");
        log.append("\n" + "2 Attack building");
        log.append("\n" + "3 Attack unit");
        log.append("\n" + "4 Build Building/Recruit Unit");
        log.append("\n" + "5 Move with unit");
        log.append("\n" + "6 EndTurn");
        log.append("\n" + "7 Give up");
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        switch (input) {
            case "1":
                getMap();
                break;
            case "2":
                System.out.println("YourUnit XY and Enemy Building XY (format:'XYXY') REQUIRED!x");
                input = sc.nextLine();
                AttackBuilding(whosturn, (Unit) arr[x][y],(Building) arr[targetX][targetY]);
                break;
            case "3":
                System.out.println("YourUnit XY and Enemy Unit XY (format: 'XYXY' ");
                input = sc.nextLine();
                AttackUnit(whosturn, (Unit) arr[x][y], (Unit) arr[targetX][targetY]);
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
                /*if(arr[subsStringZeroOne(input)][subsStringOneTwo(input)] instanceof Soldier){
                    move((Unit)arr[subsStringZeroOne(input)][subsStringOneTwo(input)],
                            subsStringTwoThree(input),subsStringThreeFour(input), 1, whosturn);
                } else if(arr[subsStringZeroOne(input)][subsStringOneTwo(input)] instanceof Sniper) {
                    move((Unit) arr[subsStringZeroOne(input)][subsStringOneTwo(input)],
                            subsStringTwoThree(input),subsStringThreeFour(input),2, whosturn);
                } else {
                    System.out.println(input);
                    System.out.println(subsStringZeroOne(input) + " " + subsStringOneTwo(input));
                    System.out.println("not a unit.");
                }*/
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
            GameAreaBuilder(arr[x][y], x, y);
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
            GameAreaBuilder(arr[x][y], x, y);
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
            GameAreaBuilder(arr[x][y], x, y);
            System.out.println("Sniper built.");
        }
    }
    private void makeSniper(int x,int y, Player player) {
        if(checkField(x,y)) {
            arr[x][y] = new Sniper(x, y, player);
            arr[x][y].setUsed(true);
        }
        GameAreaBuilder(arr[x][y], x, y);
    }
    private void makeSolider(int x,int y, Player player) {
        if(checkField(x,y)) {
            arr[x][y] = new Soldier(x, y, player);
            arr[x][y].setUsed(true);
        }
        GameAreaBuilder(arr[x][y], x, y);
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
    private void move(int x, int y, int newX, int  newY, Unit u, String whosturn) {
        resetValues();
        if(checkField(x + u.getMoveDistance(),y + u.getMoveDistance())) {
            if(u.getPlayer().getName() == whosturn) {
                GameAreaBuilder(x, y,x+ u.getMoveDistance(),
                        y + u.getMoveDistance(), u.getImg());
                arr[newX][newY] = arr[x][y];
                arr[x][y] = new Fields(false);
                labels[newX][newY].setIcon(getDefaultIcon());
                labels[x][y].setIcon(u.getImg());
                System.out.println("Successful move");
            } else {
                System.out.println("It's not your unit.");
            }
        } else {
            System.out.println("Failed to make move. Location is used by something already.");
        }
    }

    private void resetValues() {
        x = -1;
        y = -1;
        TargetX = -1;
        TargetY = -1;
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
