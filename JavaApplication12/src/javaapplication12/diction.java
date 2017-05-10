/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

/**
 *
 * @author alimh
 */
public class diction {
    public String lexeme;
    public String return_token;
    public String no_of_line;
    public String word_no_in_line;
    public boolean matchbility;
    public diction(String lex , String r_token ,String n_line , String n_word ,boolean match ){
        this.lexeme = lex;
        this.return_token = r_token;
        this.no_of_line = n_line;
        this.word_no_in_line = n_word;
        this.matchbility = match;
    }
    
}
