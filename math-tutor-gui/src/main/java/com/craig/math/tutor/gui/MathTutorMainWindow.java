package com.craig.math.tutor.gui;

import javax.swing.*;
import java.awt.*;

public class MathTutorMainWindow {

    private JFrame jFrame = new JFrame("Math Tutor");


    public void init() {
        jFrame.setSize(500, 500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLayout(new GridLayout(1, 1));
        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.add(new AdditionTab(), "Add");
        jTabbedPane.add(new SubtractionTab(), "Subtract");
        jTabbedPane.add(new MultiplicationTab(), "Multiply");
        jTabbedPane.add(new DivisionTab(), "Divide");

        jFrame.add(jTabbedPane);
        jFrame.setVisible(true);

    }
}
