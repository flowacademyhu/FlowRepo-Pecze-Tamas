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
        this.add(showGUI(map), BorderLayout.CENTER);
        playerStatus.add(RedPlayerLife);
        playerStatus.add(BluePlayerLife);
        this.add(playerStatus, BorderLayout.SOUTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    private JLabel[] createLabels() {
        JLabel[] labels  = new JLabel[100];
        for(int i=0; i<100; i++) {
            labels[i] = new JLabel("field: " + (i+1));
        }
        return labels;
    }
    private JPanel showGUI(JPanel map) {
        JLabel[] labels = createLabels();
        labels[0].setText(addHeadquarter());
        labels[99].setText(addHeadquarter());
        for(int i=0; i < labels.length; i++) {
            map.add(labels[i]);
        }
        return map;
    }
    public String addHeadquarter() {
        Headquarter h1 = new Headquarter();
        return "Headquarter";
    }
}
