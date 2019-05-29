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
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class GameArea extends JFrame {
         private JPanel map = new JPanel(new GridLayout(10,10));
         private JLabel[][] labels  = new JLabel[10][10];
         private JTextArea log;
         private JLabel selectedTarget;
         private JLabel whosturnLabel;
         private JButton moveUnitButton;
         private boolean secondXYgetter;
         private int x = -1;
         private int y = -1;
         private int TargetX = -1;
         private int TargetY = -1;
         private JButton whosTurnButton;
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
         private ImageIcon DefaultIcon = new ImageIcon("img/qwe150.png");
         private JLabel playerPoints;

    public GameArea() {

        super("Strategy game");
        this.setSize(1300,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        secondXYgetter = false;

        JButton attackUnitButton= new JButton("Attack unit");
        attackUnitButton.addActionListener(e -> attackUnit());
        JButton attackBuildingButton= new JButton("Attack building");
        attackBuildingButton.addActionListener(e -> attackBuilding());

        playerPoints = new JLabel("");

        JComboBox constructBuildingComboBox = new JComboBox();
        constructBuildingComboBox.addItem(new BuildingList("Build/Recruit", 0));
        constructBuildingComboBox.addItem(new BuildingList("Headquarter", 1));
        constructBuildingComboBox.addItem(new BuildingList("Sniper trainer", 2));
        constructBuildingComboBox.addItem(new BuildingList("Hospital", 3));
        constructBuildingComboBox.addItem(new BuildingList("Soldier", 4));
        constructBuildingComboBox.addItem(new BuildingList("SniperTrainer", 5));
        constructBuildingComboBox.addActionListener(e -> constructBuilding(constructBuildingComboBox));

        moveUnitButton= new JButton("Move unit");
        moveUnitButton.addActionListener(e -> moveCheck());
        whosTurnButton = new JButton("End turn");
        whosTurnButton.addActionListener(e -> endTurn());
        selectedTarget = new JLabel("Nothing selected yet.");
        whosturnLabel = new JLabel("Waiting for game init");
        JPanel southPanel = new JPanel();
        log = new JTextArea("Game log",30,30);
        log.setEditable(false);
        JScrollPane areaScrollPane = new JScrollPane(log);
        areaScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JLabel fun = new JLabel("/img/")
        southPanel.add(attackUnitButton);
        southPanel.add(attackBuildingButton);
        southPanel.add(moveUnitButton);
        southPanel.add(whosTurnButton);
        southPanel.add(constructBuildingComboBox);
        southPanel.add(playerPoints);
        southPanel.add(whosturnLabel);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(selectedTarget, BorderLayout.PAGE_START);
        this.add(map, BorderLayout.CENTER);
        JPanel eastPanel = new JPanel();
        eastPanel.add(areaScrollPane);
        eastPanel.add(areaScrollPane);
        this.add(eastPanel, BorderLayout.EAST);

        GameAreaInit();
        gameInit();
        gameProcess();
    }
    private void constructBuilding(JComboBox box) {
        Object item = box.getSelectedItem();
        int value = ((BuildingList)item).getValue();
        log.append(String.valueOf(value));
        switch (value) {
            case 1:
                if(getWhosTurn().getGP() > 200) {
                makeHeadQuarter(x,y,getWhosTurn());
                getWhosTurn().setGP(getWhosTurn().getGP() - 200);
                } else {
                    log.append("\n You don't have enough points \nto construct a headquarter.");
                }
                break;
            case 2:
                if(getWhosTurn().getGP() > 250) {
                    makeSniperTrainer(x,y,getWhosTurn());
                    getWhosTurn().setGP(getWhosTurn().getGP() - 250);
                } else {
                    log.append("\n You don't have enough points \nto construct a sniper trainer.");
                }
                break;
            case 3:
                if(getWhosTurn().getGP() > 150) {
                    makeHospital(x,y,getWhosTurn());
                    getWhosTurn().setGP(getWhosTurn().getGP() - 150);
                } else {
                    log.append("\n You don't have enough points \nto construct a hospital.");
                }
                break;
            case 4:
                if(getWhosTurn().getGP() > 60) {
                    makeSniper(x,y,getWhosTurn());
                    getWhosTurn().setGP(getWhosTurn().getGP() - 60);
                } else {
                    log.append("\n You don't have enough points \nto recruit a sniper.");
                }
                break;
            case 5:
                if(getWhosTurn().getGP() > 40) {
                    makeSniper(x,y,getWhosTurn());
                    getWhosTurn().setGP(getWhosTurn().getGP() - 40);
                } else {
                    log.append("\n You don't have enough points \nto recruit a soldier.");
                }
                break;
        }
        playerPoints.setText("Red players points:" + rp.getGP() + " Blue players points:" + bp.getGP());
        box.setSelectedIndex(0);
    }

    private void attackBuilding() {
        if((x >= 0 && y >= 0) && arr[x][y] instanceof Unit) {
            secondXYgetter = true;
            if(TargetX >= 0 && TargetY >= 0) {
                if (arr[TargetX][TargetY] instanceof Building){
                    AttackBuilding(whosturn,(Unit)arr[x][y],(Building)arr[TargetX][TargetY]);
                    resetValues();
                    secondXYgetter = false;
                } else {
                    resetValues();
                    secondXYgetter = false;
                }
            }else {
                log.append("\nSelect a target!");
            }
        } else {
            log.append("\nTarget a unit which you want to attack with.");
        }
    }

    private void attackUnit() {
        if((x >= 0 && y >= 0) && arr[x][y] instanceof Unit) {
            secondXYgetter = true;
            if(TargetX >= 0 && TargetY >= 0) {
                if (arr[TargetX][TargetY] instanceof Unit){
                    AttackUnit(whosturn,(Unit)arr[x][y],(Unit)arr[TargetX][TargetY]);
                    resetValues();
                    secondXYgetter = false;
                } else {
                    log.append("\nThe target is not a unit!");
                    resetValues();
                    secondXYgetter = false;
                }
            }else {
                log.append("\nSelect a target!");
            }
        } else {
            log.append("\nTarget a unit which you want to attack with.");
        }
    }

    private void moveCheck() {
        if((x >= 0 && y >= 0) && arr[x][y] instanceof Unit) {
            secondXYgetter = true;
            if(TargetX >= 0 && TargetY >= 0) {
                if (arr[TargetX][TargetY] instanceof Unit || arr[TargetX][TargetY] instanceof Building){
                    log.append("\nCan't move on a unit or a building.");
                    resetValues();
                    secondXYgetter = false;
                } else {
                    /*int distance = 0;
                    if(arr[x][y] instanceof Soldier) {
                        distance =  2;
                    } else {
                        distance = 1;
                    }*/
                    move(x, y, TargetX, TargetY, (Unit) arr[x][y], whosturn);
                    /*if(validateDistance(x,y,TargetX,TargetY, distance)) {
                        move(x, y, TargetX, TargetY, (Unit) arr[x][y], whosturn);
                    } else  {
                        log.append("Too far away.");
                        resetValues();
                        secondXYgetter = false;
                    }*/
            }
            }else {
                log.append("\nSelect a target!");
            }
        } else {
            log.append("\nTarget a unit with what you want to move.");
        }
    }
    private void endTurn() {
        if(whosturn.equals("BluePlayer")) {
            getWhosTurn().setGP(getWhosTurn().getGP() + 50);
            whosturn = "RedPlayer";
            whosturnLabel.setText(whosturn);
            log.append("\nBlue players turn");

        } else if(whosturn.equals("RedPlayer")) {
            getWhosTurn().setGP(getWhosTurn().getGP() + 50);
            whosturn = "BluePlayer";
            whosturnLabel.setText(whosturn);
            log.append("\nRed players turn");
        }
        playerPoints.setText("Red players points:" + rp.getGP() + " Blue players points:" + bp.getGP());
    }

    private boolean validateDistance(int x, int y, int targetX, int targetY, int distance) {
        if (targetX > x && targetY > y) {
            if (x + distance > targetX || y + distance > targetY) {
                return false;
            } else {
                return true;
            }
        }
        return false;
       /* if (targetX < x && targetY > y) {
        }
        if (targetX < x && targetY < y) {
        }
        if (targetX > x && targetY > y) {
        }*/

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
            selectedTarget.setText("Selected(XY): " + arr[x][y]);
        } else {
            TargetX = Integer.parseInt(mouseLocation.substring(0, 1));
            TargetY = Integer.parseInt(mouseLocation.substring(1, 2));
            selectedTarget.setText("Selected(TargetXY): " + arr[TargetX][TargetY]);
        }
    }

    public void GameAreaNewEmptyFieldBuilder(int x, int y) {
        labels[x][y].setIcon(getDefaultIcon());
        labels[x][y].setText("");
        map.repaint();
        map.revalidate();
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
    public void GameAreaBuilder(int OldX, int OldY, int x, int y, ImageIcon newIcon, Unit u) {
        labels[OldX][OldY].setIcon(DefaultIcon);
        labels[OldX][OldY].setText("");
        labels[x][y].setIcon(newIcon);
        labels[x][y].setText(String.valueOf(u.getHealth()));
        map.repaint();
        map.revalidate();
    }

    public void setLabels(JLabel[][] labels) {
        this.labels = labels;
    }

    public void setMap(JPanel map) {
        this.map = map;
    }
    public ImageIcon getDefaultIcon() {
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
        playerPoints.setText("Red players points:" + rp.getGP() + " Blue players points:" + bp.getGP());
        log.append("\n" + bp.getName() + " VS " + rp.getName());
        System.out.println(bp.getName() + " VS " + rp.getName());

        makeHeadQuarter(0,0,rp);
        makeHeadQuarter(9,9,bp);
        makeSoldier(0,1,rp);
        makeSoldier(1,1,rp);
        makeSoldier(1,0,rp);
        makeSoldier(9,8,bp);
        makeSoldier(8,9,bp);
        makeSoldier(8,8,bp);

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
        /*if(RedBuildings < 0 || BlueBuildings < 0) {
            GameEnd();*/
        /*}
            getWhosTurn().setGP(getWhosTurn().getGP() + 50);
            playerPoints.setText("Red players points:" + rp.getGP() + " Blue players points:" + bp.getGP());*/
            /*whosturn = getEnemyName();
            endturn = false;*/
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
                    makeSoldier(subsStringZeroOne(input), subsStringOneTwo(input), bp);
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
            System.out.println("Sniper trainer built.");
        }
    }
    private void makeSniper(int x,int y, Player player) {
        if(checkField(x,y)) {
            arr[x][y] = new Sniper(x, y, player);
            arr[x][y].setUsed(true);
        }
        GameAreaBuilder(arr[x][y], x, y);
    }
    private void makeSoldier(int x, int y, Player player) {
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
        if(!b.getPlayer().getName().equals(whosturn)) {
            if (u instanceof Sniper) {
                b.setHitPoints(b.getHitPoints() - 45);
                log.append("\nSniper unit attacked!");
            } else {
                b.setHitPoints(b.getHitPoints() - 20);
                log.append("\nSolider unit attacked!");
            }
            if (b.getHitPoints() <= 0) {
                arr[b.getLocationX()][b.getLocationY()].setUsed(false);
                arr[b.getLocationX()][b.getLocationY()] = null;
            }
            labels[b.getLocationX()][b.getLocationY()].setText(String.valueOf(b.getHitPoints()));
            if (b.getHitPoints() <= 0) {
                arr[b.getLocationX()][b.getLocationY()] = new Fields(false);
                GameAreaNewEmptyFieldBuilder(b.getLocationX(),b.getLocationY());
                log.append("\nEnemy building eliminated");
            }
        } else {
            log.append("\nYou can't attack your own unit.");
        }
    }
    private void AttackUnit(String whosturn, Unit u1, Unit u2) {
        if (!u2.getPlayer().getName().equals(whosturn)) {
            if (u1 instanceof Sniper) {
                u2.setHealth(u2.getHealth() - 45);
                log.append("\nSniper unit attacked!");
            } else {
                u2.setHealth(u2.getHealth() - 20);
                log.append("\nSolider unit attacked!");
            }
            labels[u2.getLocationX()][u2.getLocationY()].setText(String.valueOf(u2.getHealth()));
            if (u2.getHealth() <= 0) {
                arr[u2.getLocationX()][u2.getLocationY()] = new Fields(false);
                GameAreaNewEmptyFieldBuilder(u2.getLocationX(),u2.getLocationY());
                log.append("\nEnemy unit eliminated");
            }
        } else {
            log.append("\nYou can't attack your own unit.");
        }
    }

    private Player getWhosTurn() {
        if(whosturn.equals(rp.getName())){
            return rp;
        } else {
            return bp;
        }
    }
    private void move(int x, int y, int newX, int  newY, Unit u, String whosturn) {
        secondXYgetter = false;
        resetValues();
        System.out.println("\nX "+ x+ "Y "+ y + "newX " + newX + "newY" + newY );
        if(checkField(newX,newY)) {
            if(u.getPlayer().getName() == whosturn) {
                if(arr[x][y] instanceof Unit) {
                    System.out.println("\nElotte:" + arr[newX][newY]);
                    arr[newX][newY] = arr[x][y];
                    System.out.println("\nUtana:" + arr[newX][newY]);
                    arr[x][y] = new Fields(false);
                    GameAreaBuilder(x, y, newX, newY, u.getImg(), (Unit)arr[newX][newY]);
                    log.append("\nSuccessful move");
                } else {
                    log.append("\nIt's not a unit");
                }
            } else {
                log.append("\nIt's not your turn.");
            }
        } else {
            log.append("\nFailed to make move. Location is used by something already.");
        }

    }
    private boolean getEndturn () {
        return endturn;
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
