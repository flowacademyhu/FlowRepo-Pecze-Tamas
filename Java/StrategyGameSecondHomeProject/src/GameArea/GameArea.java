package GameArea;

import Fields.Buildings.Headquarter;
import Fields.Fields;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameArea extends JFrame {
         private JPanel map = new JPanel(new GridLayout(10,10));
         private JLabel[][] labels  = new JLabel[10][10];
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
                map.add(labels[i][j]);
            }
        }
    }
    public void GameAreaBuilder(ImageIcon newIcon, int x, int y) {
                labels[x][y].setIcon(newIcon);
        map.repaint();
        map.revalidate();
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
}
