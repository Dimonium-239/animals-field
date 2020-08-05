package com.gmail.dymitr.kuzmin;

import javax.swing.*;
import java.awt.*;

public class Window {
    JFrame frame = new JFrame("Fields");
    JLabel text = new JLabel("", SwingConstants.CENTER);

    public void createWindow(){
        frame.setPreferredSize(new Dimension(200, 200));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text.setPreferredSize(new Dimension(200, 200));
        frame.getContentPane().add(text, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public void updateLabel(String textFill){
        String newText = "<html>" + textFill
                .replaceAll(" ", "&nbsp;")
                .replaceAll("<", "&#8592;")
                .replaceAll(">", "&#8594;")
                .replaceAll("∧", "&#8593;")
                .replaceAll("V", "&#8595;")
                .replaceAll("\n", "<br>") + "</html>";
        text.setText(newText);
    }
}
