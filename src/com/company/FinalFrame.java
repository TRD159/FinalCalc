package com.company;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.text.Format;
import java.text.NumberFormat;

public class FinalFrame extends JFrame implements SwingConstants {

    NumberFormat gradeForm = NumberFormat.getNumberInstance();

    JLabel lbl_term = new JLabel("Term Grades");
    JLabel lbl_terms = new JLabel("Terms: ");
    //Text Fields to take in the user's term grades

    JLabel o = new JLabel("1: ");
    JLabel tw = new JLabel("2: ");
    JLabel th = new JLabel("3: ");
    JLabel fo = new JLabel("4: ");
    JLabel fi = new JLabel("5: ");

    JButton Calculate = new JButton("Calculate!");
    
    JFormattedTextField Term1;
    JFormattedTextField Term2;
    JFormattedTextField Term3;
    JFormattedTextField Term4;
    JFormattedTextField Term5;

    Integer[] n = {1, 2, 3, 4, 5};

    //The number of terms applicable
    JComboBox<Integer> Terms = new JComboBox<>(n);

    JFormattedTextField gradeWanted;

    //Button Group to hold all the radio buttons for the grade the user wants
    //ButtonGroup Grades = new ButtonGroup();

    //Two sliders to adjust the weight of the term grades and the final grades
    JSlider TermW = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 85);
    JSlider FinalW = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 15);

    JLabel Term = new JLabel();
    JLabel Final = new JLabel();

    JLabel Wanted = new JLabel("Grade Wanted: ");
    JLabel Needed = new JLabel();

    Character[] gradeMods = {'+', ' ', '-'};

    public FinalFrame(String name) {
        super(name);

        gradeForm.setMaximumIntegerDigits(3);
        gradeForm.setMaximumFractionDigits(2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(424, 293);

        Term1 = new JFormattedTextField(gradeForm);
        Term2 = new JFormattedTextField(gradeForm);
        Term3 = new JFormattedTextField(gradeForm);
        Term4 = new JFormattedTextField(gradeForm);
        Term5 = new JFormattedTextField(gradeForm);

        gradeWanted = new JFormattedTextField(gradeForm);

        Term1.setBounds(50, 100, 50, 25);
        Term2.setBounds(50, 130, 50, 25);
        Term3.setBounds(50, 160, 50, 25);
        Term4.setBounds(50, 190, 50, 25);
        Term5.setBounds(50, 220, 50, 25);

        Term1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Term2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Term3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Term4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Term5.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        FinalW.setBounds(0, 0, 200, 25);
        TermW.setBounds(0, 25, 200, 25);

        Final.setBounds(225, 0, 125, 25);
        Term.setBounds(225, 25, 125, 25);

        Final.setText("Final Weight: 15%");
        Term.setText("Term Weight: 85%");

        lbl_term.setBounds(20, 0, 140, 145);
        lbl_terms.setBounds(300, 75, 75, 25);

        Wanted.setBounds(300, 150, 100, 25);
        gradeWanted.setBounds(300, 175, 100, 25);

        Needed.setBounds(150, 220, 150, 25);

        o.setBounds(25, 100, 25, 25);
        tw.setBounds(25, 130, 25, 25);
        th.setBounds(25, 160, 25, 25);
        fo.setBounds(25, 190, 25, 25);
        fi.setBounds(25, 220, 25, 25);

        Calculate.setBounds(150, 100, 100, 100);

        Terms.setBounds(300, 100, 100, 25);
        Terms.setSelectedIndex(4);
        
        FinalW.addChangeListener(e -> FinalUpdate());
        TermW.addChangeListener(e -> TermUpdate());

        Terms.addActionListener(e -> TermsUpdate());

        Calculate.addActionListener(e -> calc());

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

        add(Wanted);
        add(gradeWanted);

        add(Needed);

        add(lbl_term);
        add(lbl_terms);

        add(o);
        add(tw);
        add(th);
        add(fo);
        add(fi);

        add(Calculate);

        setVisible(true);
    }

    public void FinalUpdate() {
        TermW.setValue(100 - FinalW.getValue());
        Final.setText("Final Weight: "+FinalW.getValue() + "%");
        Term.setText("Term Weight: "+TermW.getValue() + "%");
    }
    public void TermUpdate() {
        FinalW.setValue(100 - TermW.getValue());
        Final.setText("Final Weight: "+FinalW.getValue() + "%");
        Term.setText("Term Weight: "+TermW.getValue() + "%");
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

    public void calc() {
        double t1, t2, t3, t4, t5;
        double wanted;

        try {
            t1 = Double.parseDouble(Term1.getText());
        } catch (NumberFormatException e) {
            t1 = 0;
        }
        try {
            t2 = Double.parseDouble(Term2.getText());
        } catch (NumberFormatException e) {
            t2 = 0;
        }
        try {
            t3 = Double.parseDouble(Term3.getText());
        } catch (NumberFormatException e) {
            t3 = 0;
        }
        try {
            t4 = Double.parseDouble(Term4.getText());
        } catch (NumberFormatException e) {
            t4 = 0;
        }
        try {
            t5 = Double.parseDouble(Term5.getText());
        } catch (NumberFormatException e) {
            t5 = 0;
        }
        double tn = Terms.getSelectedIndex() + 1;

        double ta = (t1+t2+t3+t4+t5)/tn;

        try {
            wanted = Double.parseDouble(gradeWanted.getText());
        } catch (NumberFormatException e) {
            wanted = 0;
        }

        double tw = TermW.getValue()/100.0;
        double fw = FinalW.getValue()/100.0;

        System.out.println(tw);

        double gradeNeeded = -(((ta*tw)-wanted)/fw);

        if(gradeNeeded == -0)
            gradeNeeded *= -1;

        String finalG = String.format("%.2f", gradeNeeded);

        Needed.setText("Grade Needed: " + finalG);
    }

}
