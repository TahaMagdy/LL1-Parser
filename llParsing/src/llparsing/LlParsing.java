/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llparsing;

<<<<<<< HEAD
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
||||||| merged common ancestors
import java.io.IOException;
=======
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
>>>>>>> b55235e64c718f4b0563ff3d27d042e3be137c87

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


<<<<<<< HEAD
	// 29 non-terminal symbol
	//System.out.println(m.grammarHash.size());
||||||| merged common ancestors
	// 29 non-terminal symbol
	System.out.println(m.grammarHash.size());
=======
>>>>>>> b55235e64c718f4b0563ff3d27d042e3be137c87
	
<<<<<<< HEAD

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

	










	} // end main
||||||| merged common ancestors













	} // end main
=======
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
>>>>>>> b55235e64c718f4b0563ff3d27d042e3be137c87
	
}
