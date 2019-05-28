package GameArea;
import Fields.Buildings.Building;
import Fields.Fields;
import Fields.Units.Unit;
import GameLoop.GameLoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GameArea extends JFrame {
         private GameLoop gameLoop;
         public JPanel map = new JPanel(new GridLayout(10,10));
         public JLabel[][] labels  = new JLabel[10][10];
         private JLabel[][] labelinfo  = new JLabel[10][10];
         private int uniqueId;
         private List inUseUniqueId = new ArrayList();
         public JTextArea log;
         public JTextField userInput;
    int counter = 0;
    private Icon DefaultIcon = new ImageIcon("img/qwe150.png");

    public GameArea() {
        super("GameArea");
        this.setSize(1000,600);
        this.setVisible(true);
        setLayout(new BorderLayout());
        JButton attackUnitButton= new JButton("Attack unit");
        JButton attackBuildingButton= new JButton("Attack building");
        JButton moveUnitButton= new JButton("Move unit");
        JLabel selectedTarget = new JLabel("Nothing selected yet.");
        JLabel whosturn = new JLabel("Waiting for game init");
        JPanel southPanel = new JPanel();
        JLabel userInputText = new JLabel("Input here please:");
        userInput = new JTextField();
        userInput.setPreferredSize(new Dimension(300,30));
        log = new JTextArea("Game history");
        log.setColumns(15);
        log.setRows(20);
        log.setEditable(false);
        southPanel.add(attackUnitButton);
        southPanel.add(attackBuildingButton);
        southPanel.add(selectedTarget);
        southPanel.add(whosturn);
        southPanel.add(moveUnitButton);
        Box eastPanel = Box.createVerticalBox();
        eastPanel.add(Box.createVerticalGlue());
        eastPanel.add(log);
        eastPanel.add(Box.createVerticalGlue());
        eastPanel.add(userInputText, BorderLayout.CENTER);
        eastPanel.add(Box.createVerticalGlue());
        eastPanel.add(userInput, BorderLayout.SOUTH);

        this.add(southPanel, BorderLayout.SOUTH);
        this.add(eastPanel, BorderLayout.EAST);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(map, BorderLayout.CENTER);
        GameAreaInit();
    }
    private  void GameAreaInit() {
        for(int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                labels[i][j] = new JLabel();
                labels[i][j].setIcon(getDefaultIcon());
                String mouseLocation = i + "" + j;
                labels[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println(mouseLocation);
                    }
                });
                map.add(labels[i][j]);
            }
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
