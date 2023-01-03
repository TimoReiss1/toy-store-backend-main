package com.oreilly.persistence.config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Raindrops extends JPanel {
    // width and height of the panel
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    // maximum number of raindrops to be displayed at once
    private static final int MAX_RAINDROPS = 1000;

    // array to store the raindrop coordinates
    private int[][] raindrops;

    // constructor
    public Raindrops() {
        // initialize the raindrop array
        raindrops = new int[MAX_RAINDROPS][2];

        // generate random initial coordinates for the raindrops
        for (int i = 0; i < MAX_RAINDROPS; i++) {
            raindrops[i][0] = (int) (Math.random() * WIDTH);
            raindrops[i][1] = (int) (Math.random() * HEIGHT);
        }
    }

    // method to generate new coordinates for the raindrops
    public void update() {
        for (int i = 0; i < MAX_RAINDROPS; i++) {
            // generate new x coordinate
            raindrops[i][0] = (int) (Math.random() * WIDTH);

            // generate new y coordinate
            // use different increments to simulate raindrops falling at different speeds
            raindrops[i][1] += 1 + (int) (Math.random() * 5);

            // if the raindrop reaches the bottom of the screen, generate a new y coordinate
            if (raindrops[i][1] > HEIGHT) {
                raindrops[i][1] = 0;
            }
        }
    }

    // method to draw the raindrops
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // set the color to blue to represent the raindrops
        g.setColor(Color.BLUE);

        // draw the raindrops as circles
        for (int i = 0; i < MAX_RAINDROPS; i++) {
            g.fillOval(raindrops[i][0], raindrops[i][1], 5, 5);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Raindrops");
        Raindrops rain = new Raindrops();
        frame.add(rain);
        frame.setResizable(false);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a timer to update the raindrop coordinates and redraw the screen
        Timer timer = new Timer(30, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rain.update();
                rain.repaint();
            }
        });
        timer.start();
    }
}