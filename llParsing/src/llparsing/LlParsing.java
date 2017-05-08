/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llparsing;

import java.io.IOException;

/**
 *
 * @author moroclash
 */
public class LlParsing {

/**
 * @param args the command line arguments
 */
public static void main(String[] args) throws IOException {




	GrammarManager m = new GrammarManager();
	//m.grammar();


	

	int x1  = 0;
	String[] tokens1 = "Taha | magdy ".split(" | ");
	for (String token : tokens1)
	{
	    if (token.equals("|"))
		    continue; // x will not increase
	    System.out.println(token + " __ x = " + x1);
	    x1++;
	}










	} // end main
	
}
