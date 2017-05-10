/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author alimh
 */
public class main {
        private JFrame frame;
    public JTextArea code_area;
    private JButton compile_button;
    private JButton upload_button;
    public main(){
        frame=new JFrame();
        Font myfont=new Font("Serif",Font.BOLD,12);
        frame.setSize(900,600);
        //this.setVisible(true);
        frame.setLayout(null);
        
        code_area = new JTextArea();
        code_area.setBounds(40, 40, 800, 300);
        frame.add(code_area);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        compile_button=new JButton("Compile");
        compile_button.setBounds(385, 500, 100, 40);
        compile_button.setFont(myfont);
        compile_button.addActionListener(new action());
        
        frame.add(compile_button);
        upload_button=new JButton("Include_file");
        upload_button.setBounds(385, 400, 100, 40);
        
        upload_button.setFont(myfont);
        frame.add(upload_button);
        
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
            
        frame.setVisible(true);
    }

    private class action implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            String input = code_area.getText();
            scanner sc =new scanner();
            sc.scan(input);
//Integer.p
            
           
        } 

        
    }
}
