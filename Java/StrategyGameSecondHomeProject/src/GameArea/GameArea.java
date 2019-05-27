package GameArea;
import Fields.Buildings.Building;
import Fields.Units.Unit;
import GameLoop.GameLoop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameArea extends JFrame {
         private GameLoop gameLoop;
         public JPanel map = new JPanel(new GridLayout(10,10));
         private JLabel[][] labels  = new JLabel[10][10];
         private JLabel[][] labelinfo  = new JLabel[10][10];
         private int uniqueId;
         private List inUseUniqueId = new ArrayList();
    int counter = 0;
    private Icon DefaultIcon = new ImageIcon("img/qwe150.png");

    public GameArea() {
        super("GameArea");
        this.setSize(1000,600);
        this.setVisible(true);
        setLayout(new BorderLayout());
        JLabel RedPlayerLife = new JLabel("Red players life: 200");
        JLabel BluePlayerLife = new JLabel("Blue players life: 200");
        JPanel playerStatus = new JPanel();
        playerStatus.add(RedPlayerLife);
        playerStatus.add(BluePlayerLife);
        this.add(playerStatus, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(map, BorderLayout.CENTER);
        GameAreaInit();
    }
    private  void GameAreaInit() {
        for(int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                labels[i][j] = new JLabel();
                labels[i][j].setIcon(getDefaultIcon());
                labelinfo[i][j] = new JLabel("INFO");
                labelinfo[i][j].setVerticalTextPosition(JLabel.BOTTOM);
                labelinfo[i][j].setHorizontalTextPosition(JLabel.CENTER);
                labelinfo[i][j].setMaximumSize(new Dimension(5,5));
                labelinfo[i][j].setPreferredSize(new Dimension(5,5));
                labelinfo[i][j].setMinimumSize(new Dimension(5,5));
                map.add(labels[i][j]);
                map.add(labelinfo[i][j]);
            }
        }
    }
    public void GameAreaBuilder(ImageIcon newIcon, int x, int y) {
                labels[x][y].setIcon(newIcon);
                labels[x][y].setName(String.valueOf(x + "" + y));
                map.repaint();
                map.revalidate();
    }
    public void GameAreaBuilder(int OldX, int OldY, int x, int y, ImageIcon newIcon) {
        labels[OldX][OldY].setIcon(DefaultIcon);
        labels[x][y].setIcon(newIcon);
        map.repaint();
        map.revalidate();
    }
    public void GameAreaInfoBuilder(Building b, int x, int y) {
        labelinfo[x][y].setText(" HP: " + b.getHitPoints());
    }
    public void GameAreaInfoBuilder(Unit b, int oldX, int oldY, int x, int y) {
        labelinfo[x][y].setText(" HP: " + b.getHealth());
        labelinfo[oldX][oldY].setText("");
    }
    public void GameAreaInfoBuilder(Unit u, int x, int y) {
        labelinfo[x][y].setText(" HP: " + u.getHealth());
    }
    public JLabel[][] getLabels() {
        return labels;
    }

    public void setLabels(JLabel[][] labels) {
        this.labels = labels;
    }

    public JPanel getMap() {
        return map;
    }

    public void setMap(JPanel map) {
        this.map = map;
    }
    public Icon getDefaultIcon() {
        return DefaultIcon;
    }
}
