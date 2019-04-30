import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Window extends JFrame implements KeyListener, MouseListener, MouseMotionListener {

    private JButton button;
    private int x = 197;
    private int y = 199;
    private char b = 'b';
    private Random r = new Random ();
    public Window() throws HeadlessException {
        setTitle("A window");
        setSize(400,400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.button = new JButton("ok, katt ide");
        setLayout(null);
        button.setBounds(x,y, 150, 150);
        add(button);
        setVisible(true);
        button.addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        button.addMouseListener(this);
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.button.setBounds(x,y,150,50);

        if(b == 'w') {
            y-=10;
        } else if(b == 's') {
            y+=10;
            if(y+button.getHeight() > this.getHeight()){
                this.setSize(getWidth(),button.getHeight()+y);
            }
        } else if(b == 'd') {
            x+=10;
        } else if(b == 'a') {
            x-=10;
        }
        b = e.getKeyChar();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {/*
        System.out.println(e.getX() + " " + e.getY());
        int x = e.getX();
        int y = e.getY();
        button.setLocation(x,y-32);*/
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

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        /*System.out.println(e.getX() + " " + e.getY());
        System.out.println(e.getPoint());*/
        int mouseX = e.getX();
        int mouseY = e.getY();
        if (mouseX >= x && mouseX <= button.getWidth()) {
            if (mouseY >= y && mouseY -32 <= y + button.getHeight()) {
                x = r.nextInt(this.getWidth() - button.getWidth());
                y = r.nextInt(this.getHeight() - button.getHeight());
                button.setLocation(x, y);
            }
        }
    }
}
