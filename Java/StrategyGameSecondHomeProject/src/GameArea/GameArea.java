package GameArea;
import Fields.Buildings.Building;
import Fields.Fields;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameArea extends JFrame implements MouseListener {
         private JPanel map = new JPanel(new GridLayout(10,10));
         private JLabel[][] labels  = new JLabel[10][10];
         private JLabel[][] labelinfo  = new JLabel[10][10];
    int counter = 0;

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
                labels[i][j].setIcon(new ImageIcon("img/qwe150.png"));
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
        map.repaint();
        map.revalidate();
    }
    public void GameAreaInfoBuilder(Building b, int x, int y) {
        labelinfo[x][y].setText(" HP: " + b.getHitPoints());
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

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println(x + " " + y);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
