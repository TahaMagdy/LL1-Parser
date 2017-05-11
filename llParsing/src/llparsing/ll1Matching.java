/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llparsing;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author moroclash
 */
public class ll1Matching {
	
	/**
	 * @moroclash
	 * 
	 * this function that apply LL1 Matching on input using Parse Table
	 * @param Input : this a Input Stake that coming  from scanner 
	 * @return : True if Grammar haven't SyntxeError , False if have 
	 */
	public static boolean LL1Matching(Stack<String> Input)
	{
		 // this is a rules tack
		 Stack<String> RuleStak = new Stack<>();
		 //this is a Final Simpole
		 RuleStak.push("$");
		 //loop to matching all inputs
		 while(true)
		 {
			 String RulePop = RuleStak.pop(), InputPop = Input.pop();
			 //check if have matching or not
			 if(RulePop.compareTo(InputPop)==0)
			 {
				 //if reach final Simpol
				 if(RulePop.compareTo("$")==0)
					 //to stop loop
					 return true;
			 }
			 else
			 {
				 //if no maching happend
				 //should return exe to his input Stack
				 Input.push(InputPop);
				 //Get rule that will match with input exe
				 String rule = tahaFun(RulePop, InputPop);
				 //check if rule is not an epsilon 
				 if(rule.compareTo("em")==1)
				 {
					if(rule.compareTo("sym")==0)
						return false;
					//split rule to exe's
					String []exeS = GrammarManager.split(rule);
					for(int i=exeS.length-1;i>=0;i--)
						RuleStak.push(exeS[i]);
				 }//end check about epslilon
			 }
		 }
	}
	
	
	
	
	public static String tahaFun(String nonTerminal ,String Terminal) {
		return "sad";
	}
	
}
