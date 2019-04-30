import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class LabelFrame extends JFrame implements MouseMotionListener, KeyListener {

    JLabel[][] labels;
    int row = 10;
    public LabelFrame() throws HeadlessException {
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout g = new GridLayout(row,row);
        labels = new JLabel[row][row];
        setLayout(g);
        setTitle("haha nagyon vicces");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                labels[i][j]=new JLabel("szo");
                add(labels[i][j]);
                labels[i][j].addMouseMotionListener(this);
                labels[i][j].addKeyListener(this);
                labels[i][j].setOpaque(true);
                labels[i][j].setBackground(Color.white);
            }
        }
        setBlack();
        addMouseMotionListener(this);
        setVisible(true);
    }

    private void setBlack() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (i%2==0){
                   if(j%2==0){
                       labels[i][j].setBackground(Color.black);
                       labels[i][j].setForeground(Color.white);
                   } else {
                       labels[i][j].setBackground(Color.white);
                       labels[i][j].setForeground(Color.black);
                   }
                } else {
                    if (j % 2 == 1) {
                        labels[i][j].setBackground(Color.black);
                        labels[i][j].setBackground(Color.white);
                    } else {
                        labels[i][j].setBackground(Color.white);
                        labels[i][j].setBackground(Color.black);
                    }
                }
            }
            }
        }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(e.getSource() instanceof JLabel) {
            ((JLabel) e.getSource()).setBackground(Color.green);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar()=='r'){
            setBlack();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
