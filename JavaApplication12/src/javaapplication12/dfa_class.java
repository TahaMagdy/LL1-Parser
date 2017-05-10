/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

import com.sun.xml.internal.fastinfoset.util.CharArray;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alimh
 */
 public class dfa_class{  

public String match_ID(String str){
    char[] input = str.toCharArray();
     char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                case 1:switch(ch)
                {
                    case '_': state = 2;break;
                    case 'a': state = 2;break;
                    case 'b': state = 2;break;
                    case 'c': state = 2;break;
                    case 'd': state = 2;break;
                    case 'e': state = 2;break;
                    case 'f': state = 2;break;
                    case 'g': state = 2;break;
                    case 'h': state = 2;break;
                    case 'i': state = 2;break;
                    case 'j': state = 2;break;
                    case 'k': state = 2;break;
                    case 'l': state = 2;break;
                    case 'm': state = 2;break;
                    case 'n': state = 2;break;
                    case 'o': state = 2;break;
                    case 'p': state = 2;break;
                    case 'q': state = 2;break;
                    case 'r': state = 2;break;
                    case 's': state = 2;break;
                    case 't': state = 2;break;
                    case 'v': state = 2;break;
                    case 'u': state = 2;break;
                    case 'w': state = 2;break;
                    case 'x': state = 2;break;
                    case 'y': state = 2;break;
                    case 'z': state = 2;break;
                    case 'A': state = 2;break;
                    case 'B': state = 2;break;
                    case 'C': state = 2;break;
                    case 'D': state = 2;break;
                    case 'E': state = 2;break;
                    case 'F': state = 2;break;
                    case 'G': state = 2;break;
                    case 'H': state = 2;break;
                    case 'I': state = 2;break;
                    case 'J': state = 2;break;
                    case 'K': state = 2;break;
                    case 'L': state = 2;break;
                    case 'M': state = 2;break;
                    case 'N': state = 2;break;
                    case 'O': state = 2;break;
                    case 'P': state = 2;break;
                    case 'Q': state = 2;break;
                    case 'R': state = 2;break;
                    case 'S': state = 2;break;
                    case 'T': state = 2;break;
                    case 'V': state = 2;break;
                    case 'U': state = 2;break;
                    case 'W': state = 2;break;
                    case 'X': state = 2;break;
                    case 'Y': state = 2;break;
                    case 'Z': state = 2;break;
                    default : state = 0;
                }
                break;
                case 2:
                    switch(ch){
                    case '_': state = 2;break;
                    case 'a': state = 2;break;
                    case 'b': state = 2;break;
                    case 'c': state = 2;break;
                    case 'd': state = 2;break;
                    case 'e': state = 2;break;
                    case 'f': state = 2;break;
                    case 'g': state = 2;break;
                    case 'h': state = 2;break;
                    case 'i': state = 2;break;
                    case 'j': state = 2;break;
                    case 'k': state = 2;break;
                    case 'l': state = 2;break;
                    case 'm': state = 2;break;
                    case 'n': state = 2;break;
                    case 'o': state = 2;break;
                    case 'p': state = 2;break;
                    case 'q': state = 2;break;
                    case 'r': state = 2;break;
                    case 's': state = 2;break;
                    case 't': state = 2;break;
                    case 'v': state = 2;break;
                    case 'u': state = 2;break;
                    case 'w': state = 2;break;
                    case 'x': state = 2;break;
                    case 'y': state = 2;break;
                    case 'z': state = 2;break;
                    case 'A': state = 2;break;
                    case 'B': state = 2;break;
                    case 'C': state = 2;break;
                    case 'D': state = 2;break;
                    case 'E': state = 2;break;
                    case 'F': state = 2;break;
                    case 'G': state = 2;break;
                    case 'H': state = 2;break;
                    case 'I': state = 2;break;
                    case 'J': state = 2;break;
                    case 'K': state = 2;break;
                    case 'L': state = 2;break;
                    case 'M': state = 2;break;
                    case 'N': state = 2;break;
                    case 'O': state = 2;break;
                    case 'P': state = 2;break;
                    case 'Q': state = 2;break;
                    case 'R': state = 2;break;
                    case 'S': state = 2;break;
                    case 'T': state = 2;break;
                    case 'V': state = 2;break;
                    case 'U': state = 2;break;
                    case 'W': state = 2;break;
                    case 'X': state = 2;break;
                    case 'Y': state = 2;break;
                    case 'Z': state = 2;break;
                    case '0': state = 2;break;
                    case '1': state = 2;break;
                    case '2': state = 2;break;
                    case '3': state = 2;break;
                    case '4': state = 2;break;
                    case '5': state = 2;break;
                    case '6': state = 2;break;
                    case '7': state = 2;break;
                    case '8': state = 2;break;
                    case '9': state = 2;break;
                    default : state = 0;
                    }
                    break;
                default: 
                    break;
        }}
        if(state == 2)
            return "IDENTIFIER";
        return null;
}
public String match_pattern(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                
                case 1:switch(ch){
                        case 'p':state = 2;break;
                        default :state = 0;
                    }
                break;
                case 2:switch(ch){
                        case 'a':state = 3;break;
                        default :state = 0;
                    }
                break;
                case 3:switch(ch){
                        case 't':state = 4;break;
                        default :state = 0;
                    }
                break;
                case 4:switch(ch){
                        case 't':state = 5;break;
                        default :state = 0;
                    }
                break;
                case 5:switch(ch){
                        case 'e':state = 6;break;
                        default :state = 0;
                    }
                break;
                case 6:switch(ch){
                        case 'r':state = 7;break;
                        default :state = 0;
                    }
                break;
                case 7:switch(ch){
                        case 'n':state = 8;break;
                        default :state = 0;
                    }
                break;
                default : 
                    break ;
            
        }
        }
        
        if(state == 8)
                return "class";
        return null;
    }



public String match_DerivedFrom(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                case 1:switch(ch){
                        case 'D':state = 2; break;
                        default :state = 0;
                    }
                break;
                case 2:switch(ch){
                        case 'e':state = 3;break;
                        default :state = 0;
                    }
                break;
                case 3:switch(ch){
                        case 'r':state = 4;break;
                        default :state = 0;
                    }
                break;
                case 4:switch(ch){
                        case 'i':state = 5;break;
                        default :state = 0;
                    }
                break;
                case 5:switch(ch){
                        case 'v':state = 6;break;
                        default :state = 0;
                    }
                break;
                case 6:switch(ch){
                        case 'e':state = 7;break;
                        default :state = 0;
                    }
                break;
                case 7:switch(ch){
                        case 'd':state = 8;break;
                        default :state = 0;
                    }
                break;
                case 8:switch(ch){
                        case 'F':state = 9;break;
                        default :state = 0;
                    }
                break;
                case 9:switch(ch){
                        case 'r':state = 10;break;
                        default :state = 0;
                    }
                break;
                case 10:switch(ch){
                        case 'o':state = 11;break;
                        default :state = 0;
                    }
                break;
                case 11:switch(ch){
                        case 'm':state = 12;break;
                        default :state = 0;
                    }
                break;
                default : 
                    break ;
            
        }
        }
        
        if(state == 12)
                return "Inheritance";
        return null;
    }    
public String match_TrueFor_Else(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                
                case 1:switch(ch){
                        case 'T':state = 2;break;
                        case 'E':state = 9;break;
                        default :state = 0;
                    }
                
                break;
                case 2:switch(ch){
                        case 'r':state = 3;break;
                        default :state = 0;
                    }
                break;
                case 3:switch(ch){
                        case 'u':state = 4;break;
                        default :state = 0;
                    }
                break;
                case 4:switch(ch){
                        case 'e':state = 5;break;
                        default :state = 0;
                    }
                break;
                case 5:switch(ch){
                        case 'F':state = 6;break;
                        default :state = 0;
                    }
                break;
                case 6:switch(ch){
                        case 'o':state = 7;break;
                        default :state = 0;
                    }
                break;
                case 7:switch(ch){
                        case 'r':state = 8;break;
                        default :state = 0;
                    }
                break;
                case 9:switch(ch){
                        case 'l':state = 10;break;
                        default :state = 0;
                    }
                break;
                case 10:switch(ch){
                        case 's':state = 11;break;
                        default :state = 0;
                    }
                break;
                case 11:switch(ch){
                        case 'e':state = 12;break;
                        default :state = 0;
                    }
                break;
                default : 
                    break ;
            
        }
        }
        
        if(state == 8 || state == 12)
                return "Condition";
        return null;
    }
public String match_Ity(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                case 1:switch(ch){
                        case 'I':state = 2;break;
                        default :state = 0;
                    }
                break;
                case 2:switch(ch){
                        case 't':state = 3;break;
                        default :state = 0;
                    }
                break;
                case 3:switch(ch){
                        case 'y':state = 4;break;
                        default :state = 0;
                    }
                break;
                default : 
                    break ;
            
        }
        }
        
        if(state == 4)
                return "Integer";
        return null;
    }
public String match_Sity(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                
                case 1:switch(ch){
                        case 'S':state = 2;break;
                        default :state = 0;
                    }
                break;
                case 2:switch(ch){
                        case 'i':state = 3;break;
                        default :state = 0;
                    }
                break;
                case 3:switch(ch){
                        case 't':state = 4;break;
                        default :state = 0;
                    }
                break;
                case 4:switch(ch){
                        case 'y':state = 5;break;
                        default :state = 0;
                    }
                break;
                default : 
                    break ;
            
        }
        }
        
        if(state == 5)
                return "SInteger";
        return null;
    }

public String match_Cwq(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                
                case 1:switch(ch){
                        case 'C':state = 2;break;
                        default :state = 0;
                    }
                break;
                case 2:switch(ch){
                        case 'w':state = 3;break;
                        default :state = 0;
                    }
                break;
                case 3:switch(ch){
                        case 'q':state = 4;break;
                        default :state = 0;
                    }
                break;
                default : 
                    break ;
            
        }
        }
        
        if(state == 4)
                return "Character";
        return null;
    }

public String match_CwqSequence(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                
                case 1:switch(ch){
                        case 'C':state = 2;break;
                        default :state = 0;
                    }
                break;
                case 2:switch(ch){
                        case 'w':state = 3;break;
                        default :state = 0;
                    }
                break;
                case 3:switch(ch){
                        case 'q':state = 4;break;
                        default :state = 0;
                    }
                break;
                case 4:switch(ch){
                        case 'S':state = 5;break;
                        default :state = 0;
                    }
                break;
                case 5:switch(ch){
                        case 'e':state = 6;break;
                        default :state = 0;
                    }
                break;
                case 6:switch(ch){
                        case 'q':state = 7;break;
                        default :state = 0;
                    }
                break;
                case 7:switch(ch){
                        case 'u':state = 8;break;
                        default :state = 0;
                    }
                break;
                case 8:switch(ch){
                        case 'e':state = 9;break;
                        default :state = 0;
                    }
                break;
                
                case 9:switch(ch){
                        case 'n':state = 10;break;
                        default :state = 0;
                    }
                break;
                case 10:switch(ch){
                        case 'c':state = 11;break;
                        default :state = 0;
                    }
                break;
                case 11:switch(ch){
                        case 'e':state = 12;break;
                        default :state = 0;
                    }
                break;
                
                default: 
                    break;
        }
        }
        
        if(state == 12)
                return "String";
        return null;
    }
public String match_Ifity(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                
                case 1:switch(ch){
                        case 'I':state = 2;break;
                        default :state = 0;
                    }
                break;
                case 2:switch(ch){
                        case 'f':state = 3;break;
                        default :state = 0;
                    }
                break;
                case 3:switch(ch){
                        case 'i':state = 4;break;
                        default :state = 0;
                    }
                break;
                case 4:switch(ch){
                        case 't':state = 5;break;
                        default :state = 0;
                    }
                break;
                case 5:switch(ch){
                        case 'y':state = 6;break;
                        default :state = 0;
                    }
                default : 
                    break ;
            
        }
        }
        
        if(state == 6)
                return "Float";
        return null;
    }
public String match_Sifity(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                
                case 1:switch(ch){
                        case 'S':state = 2;break;
                        default :state = 0;
                    }
                break;
                case 2:switch(ch){
                        case 'i':state = 3;break;
                        default :state = 0;
                    }
                break;
                case 3:switch(ch){
                        case 'f':state = 4;break;
                        default :state = 0;
                    }
                break;
                case 4:switch(ch){
                        case 'i':state = 5;break;
                        default :state = 0;
                    }
                break;
                case 5:switch(ch){
                        case 't':state = 6;break;
                        default :state = 0;
                    }
                break ;
            
                case 6:switch(ch){
                        case 'y':state = 7;break;
                        default :state = 0;
                    }
                break;
                default : 
                    break ;
            
        }
        }
        
        if(state == 7)
                return "SFloat";
        return null;
    }
public String match_Valueless(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                
                case 1:switch(ch){
                        case 'V':state = 2;break;
                        default :state = 0;
                    }
                break;
                case 2:switch(ch){
                        case 'a':state = 3;break;
                        default :state = 0;
                    }
                break;
                case 3:switch(ch){
                        case 'l':state = 4;break;
                        default :state = 0;
                    }
                break;
                case 4:switch(ch){
                        case 'u':state = 5;break;
                        default :state = 0;
                    }
                break;
                case 5:switch(ch){
                        case 'e':state = 6;break;
                        default :state = 0;
                    }
                break;
                case 6:switch(ch){
                        case 'l':state = 7;break;
                        default :state = 0;
                    }
                break;
                case 7:switch(ch){
                        case 'e':state = 8;break;
                        default :state = 0;
                    }
                break;
                case 8:switch(ch){
                        case 's':state = 9;break;
                        default :state = 0;
                    }
                break;
                case 9:switch(ch){
                        case 's':state = 10;break;
                        default :state = 0;
                    }
                break;
                default : 
                    break ;
            
        }
        }
        
        if(state == 10)
                return "Void";
        return null;
    }

public String match_Logical(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                case 1:switch(ch){
                        case 'L':state = 2;break;
                        default :state = 0;
                    }
                break;
                case 2:switch(ch){
                        case 'o':state = 3;break;
                        default :state = 0;
                    }
                break;
                case 3:switch(ch){
                        case 'g':state = 4;break;
                        default :state = 0;
                    }
                break;
                case 4:switch(ch){
                        case 'i':state = 5;break;
                        default :state = 0;
                    }
                break;
                case 5:switch(ch){
                        case 'c':state = 6;break;
                        default :state = 0;
                    }
                break;
                case 6:switch(ch){
                        case 'a':state = 7;break;
                        default :state = 0;
                    }
                break;
                case 7:switch(ch){
                        case 'l':state = 8;break;
                        default :state = 0;
                    }
                default : 
                    break ;
            
        }
        }
        
        if(state == 8)
                return "boolean";
        return null;
    }


public String match_BreakFromThis(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                
                case 1:switch(ch){
                        case 'B':state = 2;break;
                        default :state = 0;
                    }
                break;
                case 2:switch(ch){
                        case 'r':state = 3;break;
                        default :state = 0;
                    }
                break;
                case 3:switch(ch){
                        case 'e':state = 4;break;
                        default :state = 0;
                    }
                break;
                case 4:switch(ch){
                        case 'a':state = 5;break;
                        default :state = 0;
                    }
                break;
                case 5:switch(ch){
                        case 'k':state = 6;break;
                        default :state = 0;
                    }
                break;
                case 6:switch(ch){
                        case 'F':state = 7;break;
                        default :state = 0;
                    }
                break;
                case 7:switch(ch){
                        case 'r':state = 8;break;
                        default :state = 0;
                    }
                break;
                case 8:switch(ch){
                        case 'o':state = 9;break;
                        default :state = 0;
                    }
                break;
                
                case 9:switch(ch){
                        case 'm':state = 10;break;
                        default :state = 0;
                    }
                break;
                case 10:switch(ch){
                        case 'T':state = 11;break;
                        default :state = 0;
                    }
                break;
                case 11:switch(ch){
                        case 'h':state = 12;break;
                        default :state = 0;
                    }
                break;
                
                case 12:switch(ch){
                        case 'i':state = 13;break;
                        default :state = 0;
                    }
                break;
                case 13:switch(ch){
                        case 's':state = 14;break;
                        default :state = 0;
                    }
                break;
                
                default: 
                    break;
        }
        }
        
        if(state == 14)
                return "Break";
        return null;
    }
public String match_Whatever(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                
                case 1:switch(ch){
                        case 'W':state = 2;break;
                        default :state = 0;
                    }
                break;
                case 2:switch(ch){
                        case 'h':state = 3;break;
                        default :state = 0;
                    }
                break;
                case 3:switch(ch){
                        case 'a':state = 4;break;
                        default :state = 0;
                    }
                break;
                case 4:switch(ch){
                        case 't':state = 5;break;
                        default :state = 0;
                    }
                break;
                case 5:switch(ch){
                        case 'e':state = 6;break;
                        default :state = 0;
                    }
                break;
                case 6:switch(ch){
                        case 'v':state = 7;break;
                        default :state = 0;
                    }
                break;
                case 7:switch(ch){
                        case 'e':state = 8;break;
                        default :state = 0;
                    }
                break;
                case 8:switch(ch){
                        case 'r':state = 9;break;
                        default :state = 0;
                    }
                break;
                default : 
                    break ;
            
        }
        }
        
        if(state == 9)
                return "Loop";
        return null;
    }


public String match_Respondwith(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                
                case 1:switch(ch){
                        case 'R':state = 2;break;
                        default :state = 0;
                    }
                break;
                case 2:switch(ch){
                        case 'e':state = 3;break;
                        default :state = 0;
                    }
                break;
                case 3:switch(ch){
                        case 's':state = 4;break;
                        default :state = 0;
                    }
                break;
                case 4:switch(ch){
                        case 'p':state = 5;break;
                        default :state = 0;
                    }
                break;
                case 5:switch(ch){
                        case 'o':state = 6;break;
                        default :state = 0;
                    }
                break;
                case 6:switch(ch){
                        case 'n':state = 7;break;
                        default :state = 0;
                    }
                break;
                case 7:switch(ch){
                        case 'd':state = 8;break;
                        default :state = 0;
                    }
                break;
                case 8:switch(ch){
                        case 'w':state = 9;break;
                        default :state = 0;
                    }
                break;
                case 9:switch(ch){
                        case 'i':state = 10;break;
                        default :state = 0;
                    }
                break;
                case 10:switch(ch){
                        case 't':state = 11;break;
                        default :state = 0;
                    }
                break;
                case 11:switch(ch){
                        case 'h':state = 12;break;
                        default :state = 0;
                    }
                break;
                default : 
                    break ;
            
        }
        }
        
        if(state == 12)
                return "Return";
        return null;
    }
public String match_Srap(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                
                case 1:switch(ch){
                        case 'S':state = 2;break;
                        default :state = 0;
                    }
                break;
                case 2:switch(ch){
                        case 'r':state = 3;break;
                        default :state = 0;
                    }
                break;
                case 3:switch(ch){
                        case 'a':state = 4;break;
                        default :state = 0;
                    }
                break;
                case 4:switch(ch){
                        case 'p':state = 5;break;
                        default :state = 0;
                    }
                break;
                default : 
                    break ;
            
        }
        }
        
        if(state == 5)
                return "Struct";
        return null;
    }
public String match_Scan_Conditionof(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                
                case 1:switch(ch){
                        case 'S':state = 2;break;
                        case 'C':state = 6;break;
                
                        default :state = 0;
                    }
                break;
                case 2:switch(ch){
                        case 'c':state = 3;break;
                        default :state = 0;
                    }
                break;
                case 3:switch(ch){
                        case 'a':state = 4;break;
                        default :state = 0;
                    }
                break;
                case 4:switch(ch){
                        case 'n':state = 5;break;
                        default :state = 0;
                    }
                break;
                
                
                case 6:switch(ch){
                        case 'o':state = 7;break;
                        default :state = 0;
                    }
                break;
                case 7:switch(ch){
                        case 'n':state = 8;break;
                        default :state = 0;
                    }
                break;
                case 8:switch(ch){
                        case 'd':state = 9;break;
                        default :state = 0;
                    }
                break;
                case 9:switch(ch){
                        case 'i':state = 10;break;
                        default :state = 0;
                    }
                break;
                case 10:switch(ch){
                        case 't':state = 11;break;
                        default :state = 0;
                    }
                break;
                case 11:switch(ch){
                        case 'i':state = 12;break;
                        default :state = 0;
                    }
                break;
                case 12:switch(ch){
                        case 'o':state = 13;break;
                        default :state = 0;
                    }
                break;
                case 13:switch(ch){
                        case 'n':state = 14;break;
                        default :state = 0;
                    }
                break;
                case 14:switch(ch){
                        case 'o':state = 15;break;
                        default :state = 0;
                    }
                break;
                case 15:switch(ch){
                        case 'f':state = 16;break;
                        default :state = 0;
                    }
                break;
                

                
                default : 
                    break ;
            
        }
        }
        
        if(state == 5 || state == 16)
                return "Switch";
        return null;
    }
public String match_arthematic(String str){
    char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                
                case 1:switch(ch){
                        case '*':state = 2;break;
                        case '+':state = 3;break;
                        case '-':state = 4;break;
                        case '/':state = 5;break;
                        
                        default :state = 0;
                    }
                default : 
                    break ;
            
        }
        }
        
        if(state == 2||state == 3||state == 4||state == 5)
                return "Arthematic Operation";
        return null;
    
    
}
public String match_logic(String str){
    char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                
                case 1:switch(ch){
                        case '&':state = 2;break;
                        case '|':state = 4;break;
                        case '~':state = 6;break;
                        default :state = 0;
                    }
                break;
                case 2:switch(ch){
                        case '&':state = 3;break;
                        default :state = 0;
                }break;
                case 4:switch(ch){
                        case '|':state = 5;break;
                        default :state = 0;
                }break;
                default : 
                    break ;
            
        }
        }
        
        if(state == 3 || state == 5 || state == 6)
                return "Logical Operators";
        return null;
    
    
}
public String match_Require(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                
                case 1:switch(ch){
                        case 'R':state = 2;break;
                        default :state = 0;
                    }
                break;
                case 2:switch(ch){
                        case 'e':state = 3;break;
                        default :state = 0;
                    }
                break;
                case 3:switch(ch){
                        case 'q':state = 4;break;
                        default :state = 0;
                    }
                break;
                case 4:switch(ch){
                        case 'u':state = 5;break;
                        default :state = 0;
                    }
                break;
                
                case 5:switch(ch){
                        case 'i':state = 6;break;
                        default :state = 0;
                    }
                break;
                case 6:switch(ch){
                        case 'r':state = 7;break;
                        default :state = 0;
                    }
                break;
                
                case 7:switch(ch){
                        case 'e':state = 8;break;
                        default :state = 0;
                    }
                break;
                default : 
                    break ;
            }
        }
        
        if(state == 8)
                return "Inclusion"; 
      
        
        return null;
    }
public String match_start_symbol(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
            for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                case 1 :
                    switch(ch){
                        case '@': state  = 2; break;
                        default:break;
                    }
                    break;
                default:break;
            }
            }
            if(state == 2)
                return "Start Symbol";
            return null;}
public String match_end_symbol(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
            for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                case 1 :
                    switch(ch){
                        case '$': state  = 2; break;
                        default:break;
                    }
                    break;
                default:break;
            }
            }
            if(state == 2)
                return "End Symbol";
            return null;}
public String match_assignment(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
            for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                case 1 :
                    switch(ch){
                        case '=': state  = 2; break;
                        default:break;
                    }
                    break;
                default:break;
            }
            }
            if(state == 2)
                return "Assignment Operator";
            return null;}
public String match_access(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
            for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                case 1 :
                    switch(ch){
                        case '-': state  = 2; break;
                        default:break;
                    }
                    break;
                case 2 :
                    switch(ch){
                        case '>': state = 3;break;
                        default: break;
                    }
                    break;
                default:
                    break;
            }
            }
            if(state == 3)
                return "Acces Operator";
            return null;}
public String match_braces(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
            for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                case 1 :
                    switch(ch){
                        case '{': state  = 2; break;
                        case '}': state  = 3; break;
                        case '[': state  = 4; break;
                        case ']': state  = 5; break;
                        default:break;
                    }
                    break;
                default:
                    break;
            }
            }
            if(state == 2 || state ==3 ||state ==4 ||state ==5)
                return "Braces";
            return null;}
public String match_relational(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
            for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                case 1 :
                    switch(ch){
                        case '<': state  = 2; break;
                        case '>': state  = 4; break;
                        case '=': state  = 6; break;
                        default:break;
                    }
                    break;
                case 2 :
                    switch(ch){
                        case '=': state  = 3; break;
                        default:break;
                    }
                    
                case 4 :
                    switch(ch){
                        case '=': state  = 5; break;
                        default:break;
                    }
                 
                case 6 :
                    switch(ch){
                        case '=': state  = 7; break;
                        default:break;
                    }
                default:
                    break;
            }
            }
            if(state == 2 || state ==3 ||state ==4 ||state ==5 ||state == 7)
                return "relational operator";
            return null;}
public String match_Quation_mark(String str){
    char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
            for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                case 1 :
                    switch(ch){
                        case ',': state  = 2; break;
                        default:break;
                    }
                    break;
                default:break;
            }
            }
            if(state == 2)
                return "Quation Mark";
            return null;}
public String match_line_delimaeter(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
            for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                case 1 :
                    switch(ch){
                        case '.': state  = 2; break;
                        default:break;
                    }
                    break;
                default:break;
            }
            }
            if(state == 2)
                return "Line delimiter";
            return null;}
public String match_Token_delimiter(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
            for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                case 1 :
                    switch(ch){
                        case '#': state  = 2; break;
                        default:break;
                    }
                    break;
                default:break;
            }
            }
            if(state == 2)
                return "Token delimiter";
            return null;}
public String match_line_comment(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
            for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                case 1 :
                    switch(ch){
                        case '-': state  = 2; break;
                        default:break;
                    }
                case 2 :
                    switch(ch){
                        case '-': state  = 3; break;
                        default:break;
                    }
                
                    break;
                default:break;
            }
            }
            if(state == 3)
                return "Comment";
            return null;}
public String match_multiline_comment(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
            for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                case 1 :
                    switch(ch){
                        case '/': state  = 2; break;
                        case '-': state  = 4; break;
                        default:break;
                    }
                case 2 :
                    switch(ch){
                        case '-': state  = 3; break;
                        default:break;
                    }
                
                case 4 :
                    switch(ch){
                        case '/': state  = 5; break;
                        default:break;
                    }
                
                    break;
                default:break;
            }
            }
            if(state == 3 || state == 5)
                return "Comment";
            return null;}

}


/* 
    public String match_pattern(String str){
        char[] ch = str.toCharArray();
        HashMap<Character,Integer > char_map =new HashMap<Character,Integer>();
        char_map.put('p' , 0);
        char_map.put('a' , 1);
        char_map.put('t' , 2);
        char_map.put('t' , 3);
        char_map.put('e' , 4);
        char_map.put('r' , 5);
        char_map.put('n' , 6);
        boolean [] accept = new boolean[8];
        boolean[] [] advance = new boolean[8][7];
        
        int arr[][] = new int[8][7];
        
        arr[0][0] = 1 ;
        arr[1][1] = 2 ;
        arr[2][2] = 3 ;
        arr[3][3] = 4 ;
        arr[4][4] = 5 ;
        arr[5][5] = 6 ;  
        arr[6][6] = 7 ;
        
        advance[0][0] = true;
        advance[1][1] = true;
        advance[2][2] = true;
        advance[3][3] = true;
        advance[4][4] = true;
        advance[5][5] = true;
        advance[6][6] = true;
        accept[7] = true;
        
        if(this.transition_table_algorithm(ch, arr, accept, advance, char_map))
            return "Class";
     
        return null;
    }
    
    public String get_DerivedFrom(String str){
        char[] ch = str.toCharArray();
        HashMap<Character,Integer > char_map =new HashMap<Character,Integer>();
        char_map.put('D' , 0);
        char_map.put('e' , 1);
        char_map.put('r' , 2);
        char_map.put('i' , 3);
        char_map.put('v' , 4);
        char_map.put('e' , 5);
        char_map.put('d' , 6);
        char_map.put('F' , 7);
        char_map.put('r' , 8);
        char_map.put('o' , 9);
        char_map.put('m' , 10);
       
        boolean [] accept = new boolean[11];
        boolean[] [] advance = new boolean[11][10];
        
        int arr[][] = new int[11][10];
        
        arr[0][0] = 1 ;
        arr[1][1] = 2 ;
        arr[2][2] = 3 ;
        arr[3][3] = 4 ;
        arr[4][4] = 5 ;
        arr[5][5] = 6 ;  
        arr[6][6] = 7 ;
        arr[7][7] = 8 ;
        arr[8][8] = 9 ;
        arr[9][9] = 10 ;
        
        advance[0][0] = true;
        advance[1][1] = true;
        advance[2][2] = true;
        advance[3][3] = true;
        advance[4][4] = true;
        advance[5][5] = true;
        advance[6][6] = true;
        advance[7][7] = true;
        advance[8][8] = true;
        advance[9][9] = true;
       
        accept[10] = true;
        
        if(this.transition_table_algorithm(ch, arr, accept, advance, char_map))
            return "Inheritance";
     
        return null;
    }
    
    
    
    public boolean transition_table_algorithm(char[] arr ,int [][] trans_table , boolean[] accept ,boolean advance[][], HashMap char_map ){
        int state = 0 ;
        int new_state ;
        int ch_index;
        char ch ; 
        for (int k = 0 ; k< arr.length ; k++){
            ch = arr[k];
           if(!accept[state]){
               ch_index = (int) char_map.get(ch);
               System.out.println(ch +"   "+state); 
               new_state = trans_table[state][ch_index];
                if(advance[state][ch_index])
                {
                    state = new_state;
                }
            }
        }
        if(accept[state])
                return true ; 
        return false;
    }
    
}
    /*
    
    
    */
    
/*public String match_Else(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                
                case 1:switch(ch){
                        case 'E':state = 2;break;
                        default :state = 0;
                    }
                break;
                case 2:switch(ch){
                        case 'l':state = 3;break;
                        default :state = 0;
                    }
                break;
                case 3:switch(ch){
                        case 's':state = 4;break;
                        default :state = 0;
                    }
                break;
                case 4:switch(ch){
                        case 'e':state = 5;break;
                        default :state = 0;
                    }
                break;
                default : 
                    break ;
            
        }
        }
        
        if(state == 5)
                return "Condition";
        return null;
    }
*/
/*

public String match_Conditionof(String str){
        char[]input= str.toCharArray();
        char ch ; 
        int state = 1; 
        for(int k = 0 ;k<input.length ; k++){
            ch = input[k];
            switch(state){
                
                case 1:switch(ch){
                        case 'C':state = 2;break;
                        default :state = 0;
                    }
                break;
                case 2:switch(ch){
                        case 'o':state = 3;break;
                        default :state = 0;
                    }
                break;
                case 3:switch(ch){
                        case 'n':state = 4;break;
                        default :state = 0;
                    }
                break;
                case 4:switch(ch){
                        case 'd':state = 5;break;
                        default :state = 0;
                    }
                break;
                case 5:switch(ch){
                        case 'i':state = 6;break;
                        default :state = 0;
                    }
                break;
                case 6:switch(ch){
                        case 't':state = 7;break;
                        default :state = 0;
                    }
                break;
                case 7:switch(ch){
                        case 'i':state = 8;break;
                        default :state = 0;
                    }
                break;
                case 8:switch(ch){
                        case 'o':state = 9;break;
                        default :state = 0;
                    }
                break;
                case 9:switch(ch){
                        case 'n':state = 10;break;
                        default :state = 0;
                    }
                break;
                case 10:switch(ch){
                        case 'o':state = 11;break;
                        default :state = 0;
                    }
                break;
                case 12:switch(ch){
                        case 'f':state = 13;break;
                        default :state = 0;
                    }
                break;
                
                default : 
                    break ;
            
        }
        }
        
        if(state == 13)
                return "Switch";
        return null;
    }

*/