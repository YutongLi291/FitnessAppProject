package ui;

import exceptions.NegativeEntryException;
import jdk.nashorn.internal.scripts.JO;
import model.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class TrackMenu extends JFrame implements ActionListener {

    private JLabel label;
    private JTextField field;
    JButton mealButton;
    JButton exerciseButton;
    JButton heightButton;
    JButton weightButton;
    public static Calorie ct = new Calorie();
    public static WeightTrack wt = new WeightTrack();
    public static Calculator bc = new BmiCalculator();
    public static Calculator dcic = new DailyCalorieIntakeCalculator();
    public static HeightTrack ht = new HeightTrack();

    public TrackMenu() {
        super("Tracker Interface");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        mealButton = new JButton("m");
        exerciseButton = new JButton("e");
        heightButton = new JButton("h");
        weightButton = new JButton("w");
        setPreferredSize(new Dimension(650, 200));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(50, 100, 50, 100));
        setLayout(new FlowLayout());
        setTitle("Tracker Interface");
        mealButton.setActionCommand("meal");
        exerciseButton.setActionCommand("exercise");
        heightButton.setActionCommand("height");
        weightButton.setActionCommand("weight");
        mealButton.addActionListener(this);
        exerciseButton.addActionListener(this);
        heightButton.addActionListener(this);
        weightButton.addActionListener(this);
    }

    public void initialize() {
        getContentPane().setBackground(Color.white);
        //sets "this" class as an action listener for btn.
        //that means that when the btn is clicked,
        //this.actionPerformed(ActionEvent e) will be called.
        //You could also set a different class, if you wanted
        //to capture the response behaviour elsewhere
        label = new JLabel("Press m to track meal and e to track exercise in calories, "
                + "h to track height in metres, w to track weight in kgs");
        field = new JTextField(5);
        add(field);
        add(mealButton);
        add(exerciseButton);
        add(heightButton);
        add(weightButton);
        add(label);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        {
            try {
                if (e.getActionCommand().equals("meal")) {
                    trackMeal();
                } else if (e.getActionCommand().equals("exercise")) {
                    trackExercise();
                } else if (e.getActionCommand().equals("height")) {
                    trackHeight();
                } else if (e.getActionCommand().equals("weight")) {
                    trackWeight();
                }

            } catch (NegativeEntryException ex) {
                JOptionPane.showConfirmDialog(null, "Please enter a positive integer!",
                        "Error", JOptionPane.DEFAULT_OPTION);
            }
        }
    }

    private void trackWeight() throws NegativeEntryException {
        wt.trackMeasure(parseDouble(field.getText()));
        JOptionPane.showConfirmDialog(null, "Your weight of" + wt.getMeasure()
                + "kg has been tracked", "Popup", JOptionPane.DEFAULT_OPTION);
    }

    private void trackHeight() throws NegativeEntryException {
        ht.trackMeasure(parseDouble(field.getText()));
        JOptionPane.showConfirmDialog(null, "Your height of" + ht.getMeasure()
                + "m has been tracked", "Popup", JOptionPane.DEFAULT_OPTION);
    }

    private void trackMeal() throws NegativeEntryException {
        ct.addCalories(parseInt(field.getText()));
        JOptionPane.showConfirmDialog(null, "Your meal has been tracked, your net "
                + "calories today is " + ct.getNetCalories(), "Popup", JOptionPane.DEFAULT_OPTION);
    }

    private void trackExercise() throws NegativeEntryException {
        ct.burnCalories(parseInt(field.getText()));
        JOptionPane.showConfirmDialog(null, "Your exercise has been tracked, your net "
                + "calories today is " + ct.getNetCalories(), "Popup", JOptionPane.DEFAULT_OPTION);
    }

}
