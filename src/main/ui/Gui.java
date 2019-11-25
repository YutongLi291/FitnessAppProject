package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.Track;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import exceptions.ImpossibleMeasureException;
import exceptions.NegativeEntryException;
import model.*;
import network.FoodCalorieInformation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

//Referenced lots from LabelChanger
public class Gui extends JFrame implements ActionListener {

    private String state = "analyzing";
    private static final String CONFIRM = "ok";
    private static final String TRACK = "t";
    private static final String QUIT_COMMAND = "quit";
    private static final String WEIGHT = "w";
    private static final String HEIGHT = "h";
    private static final String CALCULATE_BMI = "bmi";
    private Scanner scanner;
    public String input;
    public static Calorie ct = new Calorie();
    public static WeightTrack wt = new WeightTrack();
    public static Calculator bc = new BmiCalculator();
    public static Calculator dcic = new DailyCalorieIntakeCalculator();
    public static HeightTrack ht = new HeightTrack();
    public static FoodCalorieInformation fci;
    private JLabel label;
    private JTextField field;


    public Gui() {
        super("Fitness Tracker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(650, 200));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(50, 100, 50, 100));
        setLayout(new FlowLayout());
        setTitle("Welcome To Fitness Tracker!");
        getContentPane().setBackground(Color.white);
        JButton enter = new JButton("Enter");
        enter.setActionCommand("myButton");
        enter.addActionListener(this); //sets "this" class as an action listener for btn.
        //that means that when the btn is clicked,
        //this.actionPerformed(ActionEvent e) will be called.
        //You could also set a different class, if you wanted
        //to capture the response behaviour elsewhere
        label = new JLabel(" You can enter 't' to record your meal, exercise, height, or weight."
                + " 'bmi' to calculate your bmi." + " 'save' to save.");
        field = new JTextField(5);
        add(field);
        add(enter);
        add(label);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    //this is the method that runs when Swing registers an action on an element
    //for which this class is an ActionListener
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("myButton")) {
            if (field.getText().equals(TRACK)) {
                TrackMenu trackMenu = new TrackMenu();
                trackMenu.initialize();
            } else if (field.getText().equals("save")) {
                SaveFile.main(new String[]{"main"});
                JOptionPane.showConfirmDialog(null, "Your data was saved!", "Save",
                        JOptionPane.DEFAULT_OPTION);
            } else if (field.getText().equals(CALCULATE_BMI)) {
                BmiMenu bmiMenu = new BmiMenu();
                bmiMenu.initialize();
            }


        }
    }


//    private void analyzeCommand(String input) {
//        if (input.equals("save")) {
//            SaveFile.main(new String[]{"main"});
//        } else if (input.equals("help")) {
//            welcome();
//        } else if (input.equals(TRACK)) {
//            trackAnything();
//        } else if (input.equals(CALCULATE_BMI)) {
//            label.setText("Please enter your weight in kg");
//            calculatorFunction(bc);
//        }
//    }


    public static void main(String[] args) {
        new Gui();
    }
}