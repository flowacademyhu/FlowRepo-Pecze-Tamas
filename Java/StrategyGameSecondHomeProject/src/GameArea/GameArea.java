package GameArea;

import javax.swing.*;
import java.awt.*;

public class GameArea extends JFrame {
         private JPanel map = new JPanel(new GridLayout(10,10));
         private JLabel[][] labels  = new JLabel[10][10];



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
        this.add(map);

        GameAreaBuild();

    }

    private void GameAreaBuild() {
        for(int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                labels[i][j] = new JLabel();
                map.add(labels[i][j]);
            }
        }
    }
}
