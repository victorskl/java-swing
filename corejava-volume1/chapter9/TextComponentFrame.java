package chapter9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextComponentFrame extends JFrame {
    public static final int TEXTAREA_ROWS = 8;
    public static final int TEXTAREA_COLUMNS = 20;
    
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 300;
    
    public TextComponentFrame() {
        setTitle("TextComponentFrame");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        final JTextField textField = new JTextField();
        final JPasswordField passwordField = new JPasswordField();
        
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 2));
        northPanel.add(new JLabel("User name: ", SwingConstants.RIGHT));
        northPanel.add(textField);
        northPanel.add(new JLabel("Password: ", SwingConstants.RIGHT));
        northPanel.add(passwordField);
        
        add(northPanel, BorderLayout.NORTH);
        
        final JTextArea textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        add(scrollPane, BorderLayout.CENTER);
        
        JPanel southPanel = new JPanel();
        JButton insertButton = new JButton("Insert");
        southPanel.add(insertButton);
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                textArea.append("User name: " + textField.getText() + " Password: " 
                + new String(passwordField.getPassword()) + "\n");
            }
        });
        add(southPanel, BorderLayout.SOUTH);
        pack();
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(
            new Runnable() {
                public void run() {
                    JFrame frame = new TextComponentFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                }
            }
        );
    }
}