package ui;

import exceptions.ImpossibleMeasureException;
import model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.parseDouble;

public class BmiMenu extends JFrame implements ActionListener {


    private JLabel label;
    private JTextField field;

    JButton heightButton;
    JButton weightButton;
    JButton calculateButton;
    public static Calorie ct = new Calorie();
    public static WeightTrack wt = new WeightTrack();
    public static Calculator bc = new BmiCalculator();
    public static Calculator dcic = new DailyCalorieIntakeCalculator();
    public static HeightTrack ht = new HeightTrack();
    BmiCalculator bmiCalculator = new BmiCalculator();
    double height;
    double weight;

    //Constructs a new bmiMenu frame
    public BmiMenu() {
        super("Bmi Calculator Interface");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        heightButton = new JButton("height");
        weightButton = new JButton("weight");
        calculateButton = new JButton("calculate");

        setPreferredSize(new Dimension(700, 200));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(50, 100, 50, 100));

        setLayout(new FlowLayout());
        setTitle("Bmi Calculator Interface");

        heightButton.setActionCommand("height");
        weightButton.setActionCommand("weight");
        calculateButton.setActionCommand("calculate");


        heightButton.addActionListener(this);
        weightButton.addActionListener(this);
        calculateButton.addActionListener(this);
    }


    //Modifies: this
    //Effects: initializes the Bmi popup menu
    public void initialize() {
        getContentPane().setBackground(Color.white);
        //sets "this" class as an action listener for btn.
        //that means that when the btn is clicked,
        //this.actionPerformed(ActionEvent e) will be called.
        //You could also set a different class, if you wanted
        //to capture the response behaviour elsewhere
        label = new JLabel("Calculate your bmi after entering your weight(kg) and height(m) using their "
                + "respective buttons" + ", then pressing calculate");

        field = new JTextField(5);
        add(field);
        add(heightButton);
        add(weightButton);
        add(calculateButton);
        add(label);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);


    }

    @Override
    //Modifies: this
    //Effects: takes in commands depending on which button is pressed
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("height")) {
            height = parseDouble(field.getText());
            JOptionPane.showConfirmDialog(null, "Your height of" + height
                    + "m has been tracked", "Popup", JOptionPane.DEFAULT_OPTION);
        } else if (e.getActionCommand().equals("weight")) {
            weight = parseDouble(field.getText());
            JOptionPane.showConfirmDialog(null, "Your weight of" + weight
                    + "kg has been tracked", "Popup", JOptionPane.DEFAULT_OPTION);
        } else if (e.getActionCommand().equals("calculate")) {
            try {
                calculateBmi();
            } catch (ImpossibleMeasureException ex) {
                JOptionPane.showConfirmDialog(null, "This bmi is impossible!",
                        "Popup", JOptionPane.DEFAULT_OPTION);
            }
        }

    }

    private void calculateBmi() throws ImpossibleMeasureException {
        bmiCalculator.calculateValue(weight, height);
        JOptionPane.showConfirmDialog(null, "Your bmi is "
                + bmiCalculator.getMeasure() + ", You are "
                + bmiCalculator.getWeightClassification() + ".", "Popup", JOptionPane.DEFAULT_OPTION);
    }
}
