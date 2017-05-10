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
import java.util.Stack;


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
		LinkedHashMap<String, HashSet<String>> follow = new LinkedHashMap(),first;
//		GrammarManager x = new GrammarManager();
//		hashMap =  (LinkedHashMap<String, ArrayList<String>>) x.grammar();
//                AmbegoutyManager.RemoveLeftReqursion(hashMap);
//		AmbegoutyManager.deletLeftFactoring(hashMap);
//		hashMap.forEach((key,value)->{System.out.println("key :  "+ key);value.forEach(e->{System.out.println("   value   :  " +e);});});
		
		ArrayList<String> t1 =  new ArrayList<>();
		t1.add("t ex");
		ArrayList<String> t2 =  new ArrayList<>();
		t2.add("+ t ex");
		t2.add("em");
		ArrayList<String> t3 =  new ArrayList<>();
		t3.add("f tx");
		ArrayList<String> t4 =  new ArrayList<>();
		t4.add("* f tx");
		t4.add("em");
		ArrayList<String> t5 =  new ArrayList<>();
		t5.add("id");
		t5.add("( e )");
		
		
		
		hashMap.put("e", t1);
		hashMap.put("ex", t2);
		hashMap.put("t", t3);
		hashMap.put("tx", t4);
		hashMap.put("f", t5);
		
		first = test.getFirest(hashMap);//FlowFirst.getFirstSet(hashMap);
		follow = test.getFollow(first, hashMap); //FlowFirst.getFollowSet(hashMap);
//		String s[] = test.getAfterExe(GrammarManager.split("t e"),"e","e");
//		System.out.println(s[0]+"   "+s[1]);

//		LinkedHashMap<String,String[]> tt = test.getNonTerminalPositions(hashMap, "t");
//		tt.forEach((k,v)->{System.out.println("k: " +k+ "  v :"+v[0]+"  "+v[1]);});
		follow.forEach((key,value)->{System.out.print("key  :"+key+"  {");value.forEach(e->{System.out.print(" "+e+"  ");});System.out.print(" }");System.out.println("");});
		 
		
		

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











	
