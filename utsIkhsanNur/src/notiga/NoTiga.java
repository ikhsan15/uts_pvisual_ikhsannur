/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notiga;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author ikhsan15
 */
public class NoTiga extends JFrame implements ActionListener{
    JTextArea jta;
    JScrollPane jsp;
    
    private static final String EMPTY_STRING = "";
    private static final String NEWLINE = System.getProperty("line.separator");
    private JButton clearButton;
    private JButton addButton;
    private JTextField inputLine;
    private JTextArea textArea;
    
    public NoTiga(){
        Container contentPane;
        
        setTitle("Program Latihan2");
        jta = new JTextArea(10, 30);
        jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(jsp);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        
        contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
//        textArea = new JTextArea();
//        textArea.setColumns(22);
//        textArea.setRows(8);
//        textArea.setBorder(BorderFactory.createLineBorder(Color.RED));
//        textArea.setEditable(false);
//        contentPane.add(textArea);
        inputLine = new JTextField();
        inputLine.setColumns(30);
        contentPane.add(inputLine);
        inputLine.addActionListener(this);
        
        addButton = new JButton("ADD");
        contentPane.add(addButton);
        clearButton = new JButton("CLEAR");
        contentPane.add(clearButton);
        
        addButton.addActionListener(this);
        clearButton.addActionListener(this);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }    
    
    public static void main(String[] args) {
        new NoTiga();
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() instanceof JButton){
            JButton clickedButton = (JButton) event.getSource();
            if(clickedButton == addButton){
                addText(inputLine.getText());
            }else{
                clearText();
            }
        }else{
            addText(inputLine.getText());
        }
    }
    
    private void addText(String newline){
        jta.append(newline + NEWLINE);
        inputLine.setText("");
    }
    
    private void clearText(){
        jta.setText(EMPTY_STRING);
        inputLine.setText(EMPTY_STRING);
    }
}
