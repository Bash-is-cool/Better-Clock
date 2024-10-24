package net.blueaxealotle.clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;    
import java.time.*;

public class AnalogClock extends JPanel implements ActionListener {
    private final Timer timer;

    public AnalogClock() {
        timer = new Timer(1000, this);
        timer.start();
        setPreferredSize(new Dimension(400, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawClock(g);
    }

    private void drawClock(Graphics g) {
        // Get current time in CST
        ZonedDateTime cstTime = ZonedDateTime.now(ZoneId.of("America/Chicago"));
        int hours = cstTime.getHour();
        int minutes = cstTime.getMinute();
        int seconds = cstTime.getSecond();

        // Draw the clock face
        g.setColor(Color.WHITE);
        g.fillOval(50, 50, 300, 300);
        g.setColor(Color.BLACK);
        g.drawOval(50, 50, 300, 300);

        // Draw hour markers
        for (int i = 0; i < 12; i++) {
            double angle = Math.toRadians(i * 30);
            int x = (int) (200 + 120 * Math.cos(angle - Math.PI / 2));
            int y = (int) (200 + 120 * Math.sin(angle - Math.PI / 2));
            g.drawString(String.valueOf(i == 0 ? 12 : i), x - 5, y + 5);
        }

        // Draw hands
        drawHand(g, hours % 12 * 30 + minutes / 2.0, 100, 6); // Hour hand
        drawHand(g, minutes * 6, 120, 4); // Minute hand
        drawHand(g, seconds * 6, 140, 2); // Second hand
    }

    private void drawHand(Graphics g, double angle, int length, int width) {
        g.setColor(Color.BLACK);
        g.fillRect(195 - width / 2, 200, width, 5); // Center pivot
        double radians = Math.toRadians(angle);
        int x = (int) (200 + length * Math.cos(radians - Math.PI / 2));
        int y = (int) (200 + length * Math.sin(radians - Math.PI / 2));
        g.drawLine(200, 200, x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Analog Clock");
        AnalogClock clock = new AnalogClock();
        frame.add(clock);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}