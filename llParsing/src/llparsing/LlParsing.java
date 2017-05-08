/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llparsing;

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
	public static void main(String[] args) {
		omar();
	}


	
	public static void omar() {
		LinkedHashMap<String,ArrayList<String>> gram= new LinkedHashMap<>();
		ArrayList<String> t1 = new ArrayList<>();
		t1.add("l m A");
		t1.add("l m");
		t1.add("l z");
		gram.put("A", t1);
		
	
	
		AmbegoutyManager.deletLeftFactoring(gram);
		
		gram.forEach((key,value)->{System.out.println(key);System.out.print("->");value.forEach(e->{System.out.println(e);});System.out.println("********************************");});
	}
	
}
