/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llparsing;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import java.io.IOException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;


/**
 *
 * @author moroclash
 */
public class LlParsing {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws IOException {

		LinkedHashMap<String, ArrayList<String>> hashMap = new LinkedHashMap();

		GrammarManager x = new GrammarManager();
		hashMap =  (LinkedHashMap<String, ArrayList<String>>) x.grammar();
                AmbegoutyManager.RemoveLeftReqursion(hashMap);
		AmbegoutyManager.deletLeftFactoring(hashMap);
		hashMap.forEach((key,value)->{System.out.println("key :  "+ key);value.forEach(e->{System.out.println("   value   :  " +e);});});



	}



	// 29 non-terminal symbol
	//System.out.println(m.grammarHash.size());

	// 29 non-terminal symbol

/* TESTING HASHMAP
	HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();
	ArrayList ar = new ArrayList();

	ar.add("A");
	ar.add("B");
	hashMap.put("First", ar);
	System.out.println(hashMap);
*/

/*
	String[] ar = {"Taha", "Magdy", "Abu-Allah"};

	ArrayList<String> rules[] = new ArrayList[100];

	rules[0] = new ArrayList();
	rules[0].add("oo");

*/

	




	public static void omar() {
		LinkedHashMap<String,ArrayList<String>> gram= new LinkedHashMap<>();
		ArrayList<String> t1 = new ArrayList<>();
		t1.add("n m l");
		t1.add("A m");
		t1.add("l z");
		
		
		gram.put("A", t1);
		gram.put("z", t1);
		gram.put("b", t1);
		gram.put("s", t1);
		
	/**
	 *		A ->  A m 
	 *		    | A m 
	 *		    | l z 
	 * 
	 *		
	 * 
	 */
	
		AmbegoutyManager.RemoveLeftReqursion(gram);
//		AmbegoutyManager.deletLeftFactoring(gram);
//		System.out.println(GrammarManager.removeFirestExe(t1.get(0)));
		gram.forEach((key,value)->{System.out.println(key);System.out.print("->");value.forEach(e->{System.out.println(e);});System.out.println("********************************");});
	}









	} // end class











	
