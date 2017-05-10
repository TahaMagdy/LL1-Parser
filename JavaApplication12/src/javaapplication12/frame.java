/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author alimh
 */
public class frame {
         private JFrame frame;
         private JLabel line_no;
         private JLabel lexeme;
         private JLabel return_token;
         private JLabel word_no_line;
         private JLabel matchability;

         
         private JLabel[] line_no_list;
         private JLabel[] lexeme_list;
         private JLabel[] return_token_list;
         private JLabel[] word_no_line_list;
         private JLabel[] matchability_list;

         public frame (ArrayList<diction> list){
             frame = new JFrame();
             frame.setLayout(null);
         frame.setSize(900,600);
             frame.setResizable(false);
        frame.setLocationRelativeTo(null);    
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         Font font_name=new Font("serif",Font.BOLD,20);
             line_no=new JLabel("Line no");
             line_no.setFont(font_name);
            line_no.setBounds(40,40,100,40);
            frame.add(line_no);
            line_no.setHorizontalAlignment(JLabel.CENTER);
            line_no.setVerticalAlignment(JLabel.CENTER);
        
             lexeme=new JLabel("lexeme");
             lexeme.setFont(font_name);
            lexeme.setBounds(140,40,100,40);
            frame.add(lexeme);
            lexeme.setHorizontalAlignment(JLabel.CENTER);
            lexeme.setVerticalAlignment(JLabel.CENTER);
        
             return_token=new JLabel("return token");
             return_token.setFont(font_name);
            return_token.setBounds(240,40,140,40);
            frame.add(return_token);
            return_token.setHorizontalAlignment(JLabel.CENTER);
            return_token.setVerticalAlignment(JLabel.CENTER);
        
             word_no_line=new JLabel("Word No In Line");
             word_no_line.setFont(font_name);
            word_no_line.setBounds(380,40,230,40);
            frame.add(word_no_line);
            word_no_line.setHorizontalAlignment(JLabel.CENTER);
            word_no_line.setVerticalAlignment(JLabel.CENTER);
        
             matchability=new JLabel("Matchability");
             matchability.setFont(font_name);
            matchability.setBounds(610,40,120,40);
            frame.add(matchability);
            matchability.setHorizontalAlignment(JLabel.CENTER);
            matchability.setVerticalAlignment(JLabel.CENTER);
            lexeme_list =new JLabel[list.size()];
            word_no_line_list =new JLabel[list.size()];
            line_no_list =new JLabel[list.size()];
            return_token_list =new JLabel[list.size()];
            matchability_list =new JLabel[list.size()];
            
            int y =75;
            String match;
            for(int k = 0 ;k< list.size() ; k++){
            diction d = list.get(k);
            if(d.matchbility){
                match = "matched";
            }
            else{
                match = "not matched";
            }
            System.out.println(d.lexeme +  "   "+d.no_of_line+"   "+d.return_token+"   "+ d.word_no_in_line+"   "+match);
            line_no_list[k]=new JLabel(list.get(k).no_of_line);
            line_no_list[k].setBounds(40,y,100,20);
            frame.add(line_no_list[k]);
            line_no_list[k].setHorizontalAlignment(JLabel.CENTER);
            line_no_list[k].setVerticalAlignment(JLabel.CENTER);
           
            lexeme_list[k]=new JLabel(list.get(k).lexeme);
            lexeme_list[k].setBounds(140,y,100,20);
            frame.add(lexeme_list[k]);
            lexeme_list[k].setHorizontalAlignment(JLabel.CENTER);
            lexeme_list[k].setVerticalAlignment(JLabel.CENTER);
            
             return_token_list[k]=new JLabel(list.get(k).return_token);
             return_token_list[k].setBounds(240,y,140,20);
            frame.add( return_token_list[k]);
             return_token_list[k].setHorizontalAlignment(JLabel.CENTER);
             return_token_list[k].setVerticalAlignment(JLabel.CENTER);
            
           
            word_no_line_list[k]=new JLabel(list.get(k).word_no_in_line);
             word_no_line_list[k].setBounds(380,y,230,20);
            frame.add( word_no_line_list[k]);
             word_no_line_list[k].setHorizontalAlignment(JLabel.CENTER);
            word_no_line_list[k].setVerticalAlignment(JLabel.CENTER);
            
            matchability_list[k]=new JLabel(match);
            matchability_list[k].setBounds(610,y,120,20);
            frame.add(matchability_list[k]);
            matchability_list[k].setHorizontalAlignment(JLabel.CENTER);
            matchability_list[k].setVerticalAlignment(JLabel.CENTER);
            y+=35;
            }
         }
    
}
