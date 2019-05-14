package GameArea;

import Buildings.Headquarter;

import javax.swing.*;
import java.awt.*;

public class GameArea extends JFrame {

    public GameArea() {
        super("GameArea");
        this.setSize(1000,600);
        setLayout(new BorderLayout());
        JLabel RedPlayerLife = new JLabel("Red players life: 200");
        JLabel BluePlayerLife = new JLabel("Blue players life: 200");
        JPanel playerStatus = new JPanel();
        JPanel map = new JPanel(new GridLayout(10,10));
        playerStatus.add(RedPlayerLife);
        playerStatus.add(BluePlayerLife);
        this.add(playerStatus, BorderLayout.SOUTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel[][] labels  = new JLabel[10][10];

        for(int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                labels[i][j] = new JLabel();
                map.add(labels[i][j]);
            }
        }
        Headquarter headquarter = new Headquarter(0,0);
        labels[headquarter.getLocationX()][headquarter.getLocationY()].setIcon(headquarter.getImg());
        this.add(map);
    }

    Headquarter headquarter1 = new Headquarter(1,1);
}
