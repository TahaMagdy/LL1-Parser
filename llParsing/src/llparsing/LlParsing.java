/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llparsing;

import java.io.IOException;
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
public static void main(String[] args) throws IOException {




	GrammarManager m = new GrammarManager();
	m.grammar();


	// 29 non-terminal symbol
	System.out.println(m.grammarHash.size());
	

/* TESTING HASHMAP
	HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();
	ArrayList ar = new ArrayList();

	ar.add("A");
	ar.add("B");
	hashMap.put("First", ar);
	System.out.println(hashMap);
*/












	} // end main
	
}
