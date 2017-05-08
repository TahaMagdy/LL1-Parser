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
	m.grammar();


	// 29 non-terminal symbol
	System.out.println(m.grammarHash.size());
	













	} // end main
	
}
