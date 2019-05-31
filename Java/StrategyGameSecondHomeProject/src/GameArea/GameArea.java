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
import java.util.concurrent.ThreadLocalRandom;

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
         private JButton endTurnButton;
         private JButton attackUnitButton;
         final int FieldX = 10;
         final int FieldY = 10;
         private int blueSniperTrainerCounter = 0;
         private int redSniperTrainerCounter = 0;
         Fields[][] arr = new Fields[FieldX][FieldY];
         BluePlayer bp;
         RedPlayer rp;
         Integer RedBuildings = 0;
         Integer BlueBuildings = 0;
         String whosturn;
         private ImageIcon DefaultIcon = new ImageIcon("img/qwe150.png");
         private JLabel playerPoints;
         private boolean shopOrMove = false;
         private int hospitalHealingPoints = 5;

    public GameArea() {

        super("Strategy game");
        this.setSize(960,650);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        secondXYgetter = false;

        attackUnitButton= new JButton("Attack unit");
        attackUnitButton.addActionListener(e -> attackUnitValidate());
        JButton attackBuildingButton= new JButton("Attack building");
        attackBuildingButton.addActionListener(e -> ValidateAttackBuilding());

        playerPoints = new JLabel("");

        JComboBox constructBuildingComboBox = new JComboBox();
        constructBuildingComboBox.addItem(new BuildingList("Build/Recruit", 0));
        constructBuildingComboBox.addItem(new BuildingList("Headquarter", 1));
        constructBuildingComboBox.addItem(new BuildingList("Sniper trainer", 2));
        constructBuildingComboBox.addItem(new BuildingList("Hospital", 3));
        constructBuildingComboBox.addItem(new BuildingList("Soldier", 4));
        constructBuildingComboBox.addItem(new BuildingList("Sniper", 5));

        constructBuildingComboBox.addActionListener(e -> constructOrRecruit(constructBuildingComboBox));

        moveUnitButton= new JButton("Move unit");
        moveUnitButton.addActionListener(e -> moveCheck());
        endTurnButton = new JButton("End turn");
        endTurnButton.addActionListener(e -> endTurn());
        selectedTarget = new JLabel("Nothing selected yet.");
        whosturnLabel = new JLabel("Waiting for game init");
        JLabel nowPlaying = new JLabel("Now playing: ");
        log = new JTextArea("Game log",30,30);
        log.setEditable(false);
        JScrollPane areaScrollPane = new JScrollPane(log);
        areaScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        areaScrollPane.getVerticalScrollBar().addAdjustmentListener(e ->
                e.getAdjustable().setValue(e.getAdjustable().getMaximum()));
        JLabel fun = new JLabel();
        fun.setIcon(new ImageIcon("img/qwe150.png"));
        JPanel southPanel = new JPanel();
        southPanel.add(attackUnitButton);
        southPanel.add(attackBuildingButton);
        southPanel.add(moveUnitButton);
        southPanel.add(endTurnButton);
        southPanel.add(constructBuildingComboBox);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(selectedTarget, BorderLayout.PAGE_START);
        this.add(map, BorderLayout.CENTER);
        JPanel eastPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        eastPanel.add(areaScrollPane,c);
        c.gridy = 1;
        eastPanel.add(playerPoints, c);
        c.gridy = 2;
        eastPanel.add(nowPlaying,c);
        c.gridy = 3;
        eastPanel.add(whosturnLabel,c);
        this.add(eastPanel, BorderLayout.EAST);

        GameAreaInit();
        gameInit();
    }
    private void constructOrRecruit(JComboBox box) {
        Object item = box.getSelectedItem();
        int value = ((BuildingList)item).getValue();
        if(!shopOrMove){
        switch (value) {
            case 1:
                if (getWhosTurn().getGP() > 200) {
                    buildHeadQuarter(x, y, getWhosTurn());
                    getWhosTurn().setGP(getWhosTurn().getGP() - 200);
                    shopOrMove = true;
                } else {
                    log.append("\nYou don't have enough points \nto construct a headquarter.");
                }
                shopOrMove = true;
                break;
            case 2:
                if (getWhosTurn().getGP() > 250) {
                    buildSniperTrainer(x, y, getWhosTurn());
                    getWhosTurn().setGP(getWhosTurn().getGP() - 250);
                    if (getWhosTurn().getName().equals("RedPlayer")) {
                        redSniperTrainerCounter++;
                    } else {
                        blueSniperTrainerCounter++;
                    }
                    shopOrMove = true;
                } else {
                    log.append("\n You don't have enough points \nto construct a sniper trainer.");
                }
                shopOrMove = true;
                break;
            case 3:
                if (getWhosTurn().getGP() > 150) {
                    buildHospital(x, y, getWhosTurn());
                    getWhosTurn().setGP(getWhosTurn().getGP() - 150);
                    shopOrMove = true;
                } else {
                    log.append("\n You don't have enough points \nto construct a hospital.");
                }

                break;
            case 4:
                if (getWhosTurn().getGP() > 40) {
                    makeSoldier(x, y, getWhosTurn());
                    getWhosTurn().setGP(getWhosTurn().getGP() - 40);
                    shopOrMove = true;
                } else {
                    log.append("\nYou need to build a Sniper Trainer first!");
                }
                break;
            case 5:
                if (getWhosTurn().getGP() > 60) {
                    if (getWhosTurn().getName().equals("RedPlayer") && redSniperTrainerCounter > 0) {
                        makeSniper(x, y, getWhosTurn());
                        getWhosTurn().setGP(getWhosTurn().getGP() - 60);
                        shopOrMove = true;
                    } else if (getWhosTurn().getName().equals("BluePlayer") && blueSniperTrainerCounter > 0) {
                        makeSniper(x, y, getWhosTurn());
                        getWhosTurn().setGP(getWhosTurn().getGP() - 60);
                        shopOrMove = true;
                    } else {
                        log.append("\nYou don't have enough points \nto recruit a sniper.");
                    }
                }else {
                    log.append("\n You don't have enough points \nto recruit a soldier.");
                }
                break;
        }playerPoints.setText("Red players points:" + rp.getGP() + " Blue players points:" + bp.getGP());
        } else {
            log.append("\nYou already moved or built something.");
        }

        box.setSelectedIndex(0);
    }

    private void ValidateAttackBuilding() {
        if((x >= 0 && y >= 0) && arr[x][y] instanceof Unit) {
            secondXYgetter = true;
            if(TargetX >= 0 && TargetY >= 0) {
                if (arr[TargetX][TargetY] instanceof Building){
                    attackBuilding(whosturn,(Unit)arr[x][y],(Building)arr[TargetX][TargetY]);
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

    private void attackUnitValidate() {
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
                    move(x, y, TargetX, TargetY, (Unit) arr[x][y], whosturn);
            }
            }else {
                log.append("\nSelect a target!");
            }
        } else {
            log.append("\nTarget a unit with what you want to move.");
        }
    }
    private void endTurn() {
        hospitalHeal();
        resetUnitAttackedThisTurn();
        if(whosturn.equals("BluePlayer")) {
            getWhosTurn().setGP(getWhosTurn().getGP() + 50);
            whosturn = "RedPlayer";
            whosturnLabel.setText(whosturn);
            shopOrMove = false;

        } else if(whosturn.equals("RedPlayer")) {
            getWhosTurn().setGP(getWhosTurn().getGP() + 50);
            whosturn = "BluePlayer";
            whosturnLabel.setText(whosturn);
            shopOrMove = false;
        }
        playerPoints.setText("Red players points:" + rp.getGP() + " Blue players points:" + bp.getGP());
    }

    private void hospitalHeal() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i][j] instanceof Unit) {
                    if (((Unit) arr[i][j]).getPlayer().getName().equals(whosturn)) {
                        if (((Unit) arr[i][j]).getMaxhealth() >= ((Unit) arr[i][j]).getHealth() +
                                (rp.getNumberOfHospitalsPresent() * hospitalHealingPoints)) {
                            ((Unit) arr[i][j]).setHealth(((Unit) arr[i][j]).getHealth()
                                    + (rp.getNumberOfHospitalsPresent() * hospitalHealingPoints));
                            GameAreaRefresher(arr[i][j],i,j);
                        }
                    } else if (((Unit) arr[i][j]).getPlayer().getName().equals(whosturn)) {
                        if (((Unit) arr[i][j]).getMaxhealth() >= ((Unit) arr[i][j]).getHealth() +
                                (bp.getNumberOfHospitalsPresent() * hospitalHealingPoints)) {
                            ((Unit) arr[i][j]).setHealth(((Unit) arr[i][j]).getHealth()
                                    + (bp.getNumberOfHospitalsPresent() * hospitalHealingPoints));
                        }
                        GameAreaRefresher(arr[i][j],i,j);
                    }
                }
            }
        }
    }

    private void resetUnitAttackedThisTurn() {
        for(int i=0; i<10; i++) {
            for (int j = 0; j < 10; j++) {
                if(arr[i][j] instanceof Unit) {
                    ((Unit) arr[i][j]).setHasAttackedThisTurn(false);
                }
            }
        }

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
                        getMouseClick(mouseLocation);
                    }
                });
            }
        }
    }
    private void drawGameOver() {
        map.removeAll();
        for(int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                labels[i][j] = new JLabel();
                labels[i][j].setIcon(new ImageIcon("img/game-over.png"));
                map.add(labels[i][j]);
            }
        }
        map.repaint();
        map.revalidate();
        moveUnitButton.setEnabled(false);
        endTurnButton.setEnabled(false);
        moveUnitButton.setEnabled(false);
        attackUnitButton.setEnabled(false);
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
    public void GameAreaRefresher(Fields f1, int x, int y) {
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
    public void GameAreaRefresher(int OldX, int OldY, int x, int y, ImageIcon newIcon, Unit u) {
        labels[OldX][OldY].setIcon(DefaultIcon);
        labels[OldX][OldY].setText("");
        labels[x][y].setIcon(newIcon);
        labels[x][y].setText(String.valueOf(u.getHealth()));
        labels[x][y].setHorizontalTextPosition(JLabel.CENTER);
        labels[x][y].setVerticalTextPosition(JLabel.CENTER);
        map.repaint();
        map.revalidate();
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
        bp = new BluePlayer("BluePlayer","BLUE");
        rp = new RedPlayer("RedPlayer","RED");
        playerPoints.setText("Red players points:" + rp.getGP() + " Blue players points:" + bp.getGP());
        log.append("\n" + bp.getName() + " VS " + rp.getName());
        System.out.println(bp.getName() + " VS " + rp.getName());

        buildHeadQuarter(0,0,rp);
        buildHeadQuarter(9,9,bp);
        makeSoldier(0,1,rp);
        makeSoldier(1,1,rp);
        makeSoldier(1,0,rp);
        makeSoldier(9,8,bp);
        makeSoldier(8,9,bp);
        makeSoldier(8,8,bp);

        int randomStart = ThreadLocalRandom.current().nextInt(2);
        if(randomStart == 1) {
            log.append("\n" + rp.getName() + " starts!");
            whosturn = rp.getName();
        } else {
            log.append("\n" + bp.getName() + " starts!");
            whosturn = bp.getName();
        }
        whosturnLabel.setText(whosturn);
    }
    private void buildHeadQuarter(int x, int y, Player player) {
        if(checkField(x,y)) {
            arr[x][y] = new Headquarter(x, y, player);
            arr[x][y].setUsed(true);
            if (player.getColor().equals(bp.getColor())) {
                BlueBuildings++;
            } else {
                RedBuildings++;
            }
            GameAreaRefresher(arr[x][y], x, y);
        }
    }
    private void buildHospital(int x, int y, Player player) {
        if(checkField(x,y)) {
            arr[x][y] = new Hospital(x, y, player);
            arr[x][y].setUsed(true);
            if (player.getColor().equals(bp.getColor())) {
                BlueBuildings++;
                bp.setNumberOfHospitalsPresent(bp.getNumberOfHospitalsPresent() + 1);
            } else {
                RedBuildings++;
                rp.setNumberOfHospitalsPresent(rp.getNumberOfHospitalsPresent() + 1);
            }
            GameAreaRefresher(arr[x][y], x, y);
            System.out.println("Hospital built.");
        }
    }
    private void buildSniperTrainer(int x, int y, Player player) {
        if(checkField(x,y)) {
            System.out.println("hello");
            arr[x][y] = new SniperTrainer(x, y, player);
            arr[x][y].setUsed(true);
            if (player.getColor().equals(bp.getColor())) {
                BlueBuildings++;
            } else {
                RedBuildings++;
            }
            GameAreaRefresher(arr[x][y], x, y);
            System.out.println("Sniper trainer built.");
        }
    }
    private void makeSniper(int x,int y, Player player) {
        if(checkField(x,y)) {
            arr[x][y] = new Sniper(x, y, player);
            arr[x][y].setUsed(true);
        }
        GameAreaRefresher(arr[x][y], x, y);
    }
    private void makeSoldier(int x, int y, Player player) {
        if(checkField(x,y)) {
            arr[x][y] = new Soldier(x, y, player);
            arr[x][y].setUsed(true);
        }
        GameAreaRefresher(arr[x][y], x, y);
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
    private void attackBuilding(String whosturn, Unit u, Building b) {
        if(!b.getPlayer().getName().equals(whosturn)) {
            if (u instanceof Sniper) {
                b.setHitPoints(b.getHitPoints() - u.getDmg());
                log.append("\nSniper unit attacked!");
            } else {
                b.setHitPoints(b.getHitPoints() - u.getDmg());
                log.append("\nSolider unit attacked!");
            }
            if (b.getHitPoints() <= 0) {
                arr[b.getLocationX()][b.getLocationY()].setUsed(false);
                arr[b.getLocationX()][b.getLocationY()] = null;
            }
            labels[b.getLocationX()][b.getLocationY()].setText(String.valueOf(b.getHitPoints()));
            if (b.getHitPoints() <= 0) {
                if(b instanceof SniperTrainer) {
                    if (b.getPlayer().getName().equals("RedPlayer")){
                        redSniperTrainerCounter--;
                    } else {
                        blueSniperTrainerCounter--;
                    }
                }
                if(b instanceof Hospital) {
                    if (b.getPlayer().getName().equals("RedPlayer")) {
                        rp.setNumberOfHospitalsPresent(rp.getNumberOfHospitalsPresent() - 1);
                    } else {
                        rp.setNumberOfHospitalsPresent(rp.getNumberOfHospitalsPresent() - 1);
                    }
                }
                arr[b.getLocationX()][b.getLocationY()] = new Fields(false);
                GameAreaNewEmptyFieldBuilder(b.getLocationX(),b.getLocationY());
                log.append("\nEnemy building eliminated");
                if(b.getPlayer().getName().equals("BluePlayer")){
                    BlueBuildings--;
                } else {
                    RedBuildings--;
                }
                checkNumOfBuildings();
            }
        } else {
            log.append("\nYou can't attack your own unit.");
        }
    }

    private void checkNumOfBuildings() {
        if(RedBuildings == 0) {
            log.append("Blue player has won the game!");
            drawGameOver();
        } else if(BlueBuildings == 0) {
            log.append("Red player has won the game!");
            drawGameOver();
        }
    }

    private void AttackUnit(String whosturn, Unit u1, Unit u2) {
        if (!u2.getPlayer().getName().equals(whosturn)) {
            if(!u1.isHasAttackedThisTurn()) {
                u1.setHasAttackedThisTurn(true);
                if (u1 instanceof Sniper) {
                    u2.setHealth(u2.getHealth() - u1.getDmg());
                    log.append("\nSniper unit attacked!");
                } else {
                    u2.setHealth(u2.getHealth() - u1.getDmg());
                    log.append("\nSolider unit attacked!");
                }
                System.out.println(u2.getHealth());
                labels[TargetX][TargetY].setText(String.valueOf(u2.getHealth()));
                if (u2.getHealth() <= 0) {
                    arr[TargetX][TargetY] = new Fields(false);
                    GameAreaNewEmptyFieldBuilder(TargetX, TargetY);
                    log.append("\nEnemy unit eliminated");
                }
            } else {
                log.append("\nUnit already attacked this turn");
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
        if(checkField(newX,newY)) {
            if(u.getPlayer().getName().equals(whosturn)) {
                if(arr[x][y] instanceof Unit) {
                    if(!shopOrMove){
                        arr[newX][newY] = arr[x][y];
                        arr[x][y] = new Fields(false);
                        GameAreaRefresher(x, y, newX, newY, u.getImg(), (Unit)arr[newX][newY]);
                        log.append("\nSuccessful move");
                        shopOrMove = true;
                    } else {
                        log.append("\nYou already moved or shopped this turn.");
                    }
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
    private void resetValues() {
        x = -1;
        y = -1;
        TargetX = -1;
        TargetY = -1;
    }
}
