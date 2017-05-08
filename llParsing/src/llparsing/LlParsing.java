/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llparsing;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashMap;

||||||| merged common ancestors
=======
import java.io.IOException;

>>>>>>> 7eeeb213d6d87ab9ceac8094c2f5163f5071461c
/**
 *
 * @author moroclash
 */
public class LlParsing {

<<<<<<< HEAD
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
||||||| merged common ancestors
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
=======
/**
 * @param args the command line arguments
 */
public static void main(String[] args) throws IOException {

>>>>>>> 7eeeb213d6d87ab9ceac8094c2f5163f5071461c

<<<<<<< HEAD
||||||| merged common ancestors















	} // end main
=======


	GrammarManager x = new GrammarManager();
	x.grammar();













	} // end main
>>>>>>> 7eeeb213d6d87ab9ceac8094c2f5163f5071461c
	
}
