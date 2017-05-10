/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 *
 * @author alimh
 */
public class scanner {
        
    public  String reserved_lookup(String str){
        String ss ;
        dfa_class dd =new dfa_class();
        if((ss= dd.match_BreakFromThis(str)) != null){
            return ss;
        }
        if((ss= dd.match_Cwq(str)) != null){
            return ss;
        }
        if((ss= dd.match_CwqSequence(str)) != null){
            return ss;
        }
        if((ss= dd.match_DerivedFrom(str)) != null){
            return ss;
        }
        if((ss= dd.match_Ifity(str)) != null){
            return ss;
        }
        if((ss= dd.match_Ity(str)) != null){
            return ss;
        }
        if((ss= dd.match_Logical(str)) != null){
            return ss;
        }
        if((ss= dd.match_Quation_mark(str)) != null){
            return ss;
        }
        if((ss= dd.match_Require(str)) != null){
            return ss;
        }
        if((ss= dd.match_Respondwith(str)) != null){
            return ss;
        }
        if((ss= dd.match_Scan_Conditionof(str)) != null){
            return ss;
        }
        if((ss= dd.match_Sifity(str)) != null){
            return ss;
        }
        if((ss= dd.match_Sity(str)) != null){
            return ss;
        }
        if((ss= dd.match_Srap(str)) != null){
            return ss;
        }
        if((ss= dd.match_Token_delimiter(str)) != null){
            return ss;
        }
        if((ss= dd.match_TrueFor_Else(str)) != null){
            return ss;
        }
        if((ss= dd.match_Valueless(str)) != null){
            return ss;
        }
        if((ss= dd.match_Whatever(str)) != null){
            return ss;
        }
        if((ss= dd.match_arthematic(str)) != null){
            return ss;
        }
        if((ss= dd.match_access(str)) != null){
            return ss;
        }
        if((ss= dd.match_assignment(str)) != null){
            return ss;
        }
        if((ss= dd.match_braces(str)) != null){
            return ss;
        }
        if((ss= dd.match_end_symbol(str)) != null){
            return ss;
        }
        if((ss= dd.match_line_comment(str)) != null){
            return ss;
        }
        if((ss= dd.match_line_delimaeter(str)) != null){
            return ss;
        }
        if((ss= dd.match_logic(str)) != null){
            return ss;
        }
        if((ss= dd.match_multiline_comment(str)) != null){
            return ss;
        }
        if((ss= dd.match_pattern(str)) != null){
            return ss;
        }
        if((ss= dd.match_relational(str)) != null){
            return ss;
        }
        if((ss= dd.match_start_symbol(str)) != null){
            return ss;
        }
        return null;
    }
    public  String ID_lookup(String str){
        dfa_class df =new dfa_class();
        String st; 
        if((st=df.match_ID(str)) !=null)
            return st;
        return null;
    }
    
    
    public Stack scan (String str){
        ArrayList <diction> list =new ArrayList<diction>();
        StringTokenizer tokens = new StringTokenizer(str ,".");
        Stack stack =new Stack();
        stack.push("$");
        int line_no =0;
        int word_no = 0;
        boolean match = false;
        while(tokens.hasMoreTokens())
        {
            line_no ++;
            String s = tokens.nextToken();
            StringTokenizer Line_tokens = new StringTokenizer(s ,"$");
            String st;//String conc ="";
            while(Line_tokens.hasMoreTokens()){
                word_no ++;
                String tok ;
                tok = Line_tokens.nextToken();
                 if((st = reserved_lookup(tok))!=null)
                    {
                        stack.push(st);
                        match =true;
                    }
                 else if ((st = ID_lookup( tok))!= null)
                 {
                     stack.push(st);
                       match =true;
                 }
                 else{
                     match =false;
                 }
                 list.add(new diction(tok,st,""+line_no,""+word_no,match));
                 
                 st = "";
                 match = false;
            }
            word_no =0;
        }
        frame fr = new frame(list);
        return stack;
}
}
