/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llparsing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author moroclash
 */
public class LlParsing {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		HashMap<String,ArrayList<String>> Grammer = new HashMap<>();
		ArrayList<String> arr = new ArrayList<>();
		arr.add("test");
		Grammer.put("program", arr);
		omar(Grammer);
	}
	
	
	
	/**
	 * @moroclash
	 * this function Take Grammar to delete Left Factoring 
	 * 
	 * @param Grammer : this is a Grammar  
	 */
	public static void omar(HashMap<String,ArrayList<String>> Grammer) {
		//this to loop on all non terminal to delete left factoring
		Grammer.forEach((nonTerminal,rules)->{
			//loob on all Probabilty Rules 
			rules.forEach(rule->{
			
			
			
			
			
			});//end of Rules loop		
		});//end of NonTerminal Loop
		
	}

	
}
