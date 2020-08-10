package com.gmail.dymitr.kuzmin;

import javax.swing.*;
import java.awt.*;

public class Window {
    JFrame frame = new JFrame("Fields");
    JLabel text = new JLabel("", SwingConstants.CENTER);

    public void createWindow(){
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text.setPreferredSize(new Dimension(200, 200));
        frame.getContentPane().add(text, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public void updateLabel(String textFill){
        textFill = textFill.replaceAll(" ", "")
                .replaceAll("[0-9]", "")
                .replaceAll(":", "")
                .replaceAll("-", "")
                .replaceAll("y\\\\x", "")
                .replaceAll("<", "l")
                .replaceAll(">", "g");

        String newText = "<html><style>table tr td {border: 1px solid black;} table{width: 90%;} td tr {width:30%; height:30%}" +
                "<table><tr>" + textFill
                .replaceAll("\\|", "</td><td>&nbsp;")
                .replaceAll("&nbsp;l", "&lt;")
                .replaceAll("&nbsp;g", "&gt;")
                .replaceAll("&nbsp;∧", "∧")
                .replaceAll("&nbsp;v", "V")
                .replaceAll("&nbsp;\\*", "*")
                .replaceAll("\n", "</td></tr><tr>") + "</td></tr></table></html>";
        text.setText(newText);
    }
}
