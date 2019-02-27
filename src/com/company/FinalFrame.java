package com.company;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class FinalFrame extends JFrame implements SwingConstants {

    //Text Fields to take in the user's term grades
    JTextField Term1 = new JTextField();
    JTextField Term2 = new JTextField();
    JTextField Term3 = new JTextField();
    JTextField Term4 = new JTextField();
    JTextField Term5 = new JTextField();

    Integer[] n = {1, 2, 3, 4, 5};

    //The number of terms applicable
    JComboBox<Integer> Terms = new JComboBox<>(n);

    //Button Group to hold all the radio buttons for the grade the user wants
    ButtonGroup Grades = new ButtonGroup();

    //Two sliders to adjust the weight of the term grades and the final grades
    JSlider TermW = new JSlider(SwingConstants.VERTICAL, 0, 100, 85);
    JSlider FinalW = new JSlider(SwingConstants.VERTICAL, 0, 100, 15);

    JLabel Term = new JLabel();
    JLabel Final = new JLabel();

    char[] letterGrades = {'A', 'B', 'C', 'D'};
    char[] gradeMods = {'+', ' ', '-'};

    public FinalFrame(String name) {
        super(name);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 1000);

        Term1.setBounds(50, 50, 225, 25);
        Term2.setBounds(50, 100, 225, 25);
        Term3.setBounds(50, 150, 225, 25);
        Term4.setBounds(50, 200, 225, 25);
        Term5.setBounds(50, 250, 225, 25);

        Term1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Term2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Term3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Term4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Term5.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        FinalW.setBounds(100, 350, 25, 100);
        TermW.setBounds(125, 350, 25, 100);

        Final.setBounds(100, 450, 25, 50);
        Term.setBounds(125, 450, 25, 50);

        Final.setText("15");
        Term.setText("85");

        Terms.setBounds(300, 50, 100, 25);
        Terms.setSelectedIndex(4);
        
        FinalW.addChangeListener(e -> FinalUpdate());
        TermW.addChangeListener(e -> TermUpdate());

        Terms.addActionListener(e -> TermsUpdate());

        setLayout(null);

        add(Term1);
        add(Term2);
        add(Term3);
        add(Term4);
        add(Term5);

        add(TermW);
        add(FinalW);

        add(Term);
        add(Final);

        add(Terms);

        setVisible(true);
    }

    public void FinalUpdate() {
        Final.setText(""+FinalW.getValue());
    }
    public void TermUpdate() {
        Term.setText(""+TermW.getValue());
    }

    public void TermsUpdate() {
        switch (Terms.getSelectedIndex()) {
            case 0:
                Term2.setText("");
                Term3.setText("");
                Term4.setText("");
                Term5.setText("");
                Term2.setEditable(false);
                Term3.setEditable(false);
                Term4.setEditable(false);
                Term5.setEditable(false);
                break;
            case 1:
                Term2.setEditable(true);
                Term3.setText("");
                Term4.setText("");
                Term5.setText("");
                Term3.setEditable(false);
                Term4.setEditable(false);
                Term5.setEditable(false);
                break;
            case 2:
                Term2.setEditable(true);
                Term3.setEditable(true);
                Term4.setText("");
                Term5.setText("");
                Term4.setEditable(false);
                Term5.setEditable(false);
                break;
            case 3:
                Term2.setEditable(true);
                Term3.setEditable(true);
                Term4.setEditable(true);
                Term5.setText("");
                Term5.setEditable(false);
                break;
            case 4:
                Term2.setEditable(true);
                Term3.setEditable(true);
                Term4.setEditable(true);
                Term5.setEditable(true);
        }
    }

}
