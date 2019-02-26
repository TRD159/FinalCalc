package com.company;

import javax.swing.*;

public class FinalFrame extends JFrame {

    JTextField Term1 = new JTextField();
    JTextField Term2 = new JTextField();
    JTextField Term3 = new JTextField();
    JTextField Term4 = new JTextField();
    JTextField Term5 = new JTextField();

    JComboBox<Integer> Terms = new JComboBox<>();

    ButtonGroup Grades = new ButtonGroup();

    JSlider TermW = new JSlider();
    JSlider FinalW = new JSlider();

    char[] letterGrades = {'A', 'B', 'C', 'D', 'F'};
    char[] gradeMods = {'+', ' ', '-'};

    public FinalFrame(String name) {
        super(name);

        setDefaultCloseOperation(3);
        setSize(1500, 1000);

        setVisible(true);
    }

}
