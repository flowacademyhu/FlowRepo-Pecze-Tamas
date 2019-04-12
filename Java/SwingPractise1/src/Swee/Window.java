package Swee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {
    int numb1;
    int numb2;
    int sum = 0;
    boolean truefalse = false;
    String answer = "+";
    public Window() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTextField firstInput = new JTextField();
        firstInput.setBounds(50,50,200,30);
        this.add(firstInput);
        JTextField secondInput = new JTextField();
        secondInput.setBounds(750,50,200,30);
        this.add(secondInput);
        JButton theButton = new JButton("OK");
        theButton.setBounds(350,350, 200, 100);
        theButton.setBackground(Color.CYAN);

        //radiobuttons

        JRadioButton firstButton = new JRadioButton("firstButton",null, true);
        firstButton.setBounds(420,300,20,20);
        JRadioButton secondButton = new JRadioButton("secondButton",null,false);
        secondButton.setBounds(440,300,20,20);
        JRadioButton thirdButton = new JRadioButton("thirdButton",null,false);
        thirdButton.setBounds(460,300,20,20);
        JRadioButton fourthButton = new JRadioButton("fourthButton",null,false);
        fourthButton.setBounds(480,300,20,20);
        ButtonGroup group  = new ButtonGroup();
        JLabel labell = new JLabel("+   -   *   /  ");
        labell.setBounds(430,270,120,40);
        this.add(labell);
        JLabel labell2 = new JLabel("The answer will be displayed here!");
        labell2.setBounds(130,250,1200,40);
        this.add(labell2);
        group.add(firstButton);
        group.add(secondButton);
        group.add(thirdButton);
        group.add(fourthButton);
        this.add(firstButton);
        this.add(secondButton);
        this.add(thirdButton);
        this.add(fourthButton);

        //RadioListener myListener = new RadioListener();
        JLabel labelCheck = new JLabel("Summing Mode");
        labelCheck.setBounds(130,140,120,40);
        this.add(labelCheck);
        this.add(theButton);
        this.setTitle("The Super Swee App");
        this.setSize(1024,768);
        this.setLayout(null);
        this.setVisible(true);
        firstButton.addActionListener(e -> {
                answer = "+";
                labelCheck.setText("Summing mode");
        });
        secondButton.addActionListener(e -> {
                answer = "-";
                labelCheck.setText("Subtract mode");
        });
        thirdButton.addActionListener(e -> {
                answer = "*";
                labelCheck.setText("Multiply mode");
        });
        fourthButton.addActionListener(e -> {
                answer = "/";
                labelCheck.setText("Division mode");
        });
        theButton.addActionListener(e -> {
            try {
                numb1 = Integer.parseInt(firstInput.getText());
                numb2 = Integer.parseInt(secondInput.getText());
                truefalse = false;
            } catch (NumberFormatException nfe) {
                truefalse = true;
                if(firstInput.getText().equals("") && secondInput.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "NO INPUT");
                } else if(firstInput.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "NO INPUT ON THE LEFT");
                } else if(secondInput.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "NO INPUT ON THE RIGHT");
                } else {
                    JOptionPane.showMessageDialog(null, "HOW COULD YOU TYPE IN A LETTER??? WTF MATE?" +
                            "Wanna + or - or * or / a letter??? Are you mental?");
                }
            }
            if(answer.equals("+")){
                sum = numb1+numb2;
            } else if (answer.equals("-")) {
                sum = numb1-numb2;
            } else if (answer.equals("*")) {
                sum = numb1*numb2;
            } else if (answer.equals("/")) {
                sum = numb1 / numb2;
            }
            if(truefalse==true){
                labell2.setText("ERROR!");
            } else {
                labell2.setText("Method: " + numb1 + answer + numb2 + " has the following answer: " + sum);
            }
        });
        }
    }
