package com.craig.math.tutor.gui;

import com.craig.math.tutor.engine.MathProblem;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

import static java.awt.event.KeyEvent.VK_ENTER;

public abstract class MathTab extends JComponent implements ActionListener {

    private JPanel winPanel = new JPanel(new FlowLayout());

    private JLabel correctLabelText = new JLabel("Correct: ");

    private JLabel correctLabel = new JLabel("0");

    private JLabel incorrectLabelText = new JLabel("Incorrect: ");

    private JLabel incorrectLabel = new JLabel("0");

    private JPanel jFrame = new JPanel();

    private JPanel mathPanel = new JPanel(new FlowLayout());

    private JLabel equationLabel = new JLabel();

    private JTextField answerText = new JTextField(10);

    private JButton submitButton = new JButton("Submit");

    private JPanel statusJPanel = new JPanel(new FlowLayout());

    private JLabel statusLabel = new JLabel();

    private MathProblem mathProblem;

    abstract MathProblem getMathProblem();

    protected void init() {
        jFrame.setSize(500, 500);
        jFrame.setLayout(new GridLayout(3, 1));
        this.add(jFrame);

        jFrame.add(winPanel);
        winPanel.add(correctLabelText);
        winPanel.add(correctLabel);
        winPanel.add(incorrectLabelText);
        winPanel.add(incorrectLabel);

        jFrame.add(mathPanel);

        mathPanel.add(equationLabel);
        answerText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == VK_ENTER) {
                    submitButton.doClick();
                }
                super.keyPressed(e);
            }
        });
        mathPanel.add(answerText);
        mathPanel.add(submitButton);

        submitButton.addActionListener(this);
        setNewMathProblem();

        jFrame.add(statusJPanel);
        statusJPanel.add(statusLabel);

        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Double input = null;
        try {
            input = Double.parseDouble(answerText.getText());
        } catch (Exception ex) {
            statusLabel.setText("Incorrect! Try again!");
            playSound(false);
        }

        if (input != null && input.equals(mathProblem.solve())) {
            statusLabel.setText("Correct!");
            setNewMathProblem();
            answerText.setText("");
            correctLabel.setText(String.valueOf(Double.parseDouble(correctLabel.getText()) + 1));
            playSound(true);
        } else {
            statusLabel.setText("Incorrect! Try again!");
            incorrectLabel.setText(String.valueOf(Double.parseDouble(incorrectLabel.getText()) + 1));
            answerText.setText("");
            playSound(false);
        }
    }

    private void playSound(boolean win) {
        URL url = win ? this.getClass().getClassLoader().getResource("win.wav")
                : this.getClass().getClassLoader().getResource("lose.wav");

        try (AudioInputStream audioIn = AudioSystem.getAudioInputStream(url)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void setNewMathProblem() {
        mathProblem = getMathProblem();
        equationLabel.setText(mathProblem.print());
    }
}