/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llparsing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author taha
 */
public class GrammarManager {
	

	public HashMap grammarHash = new HashMap();
	


// @Taha
public void grammar() throws FileNotFoundException, IOException {


	HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();
      	ArrayList fileLines = new ArrayList();


      // Reading lines
	try {
		File file = new File("Grammer/Grammer.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuilder stringBuffer = new StringBuilder();
		String line;
		// a BufferReader takes only one line at a time
		while ((line = bufferedReader.readLine()) != null) {
			stringBuffer.append(line);
			stringBuffer.append("\n");
			fileLines.add(line);
			fileLines.add("\n");
		} 
		fileReader.close();
		System.out.println("Contents of file:");
		System.out.println(stringBuffer.toString());
	} catch (IOException e) {
		e.printStackTrace();
	}

	// Testing lines array
	int x = 0;
	while ( x < fileLines.size() ){
		System.out.print(fileLines.get(x));
		x++;
	}
	

/* testing
	// Split keys from rlues
	int x1  = 0;
	String[] tokens1 = "Taha | magdy ".split(" | ");
	for (String token : tokens1)
	{
	    if (token.equals("|"))
		    continue; // x will not increase
	    System.out.println(token + " __ x = " + x1);
	    x1++;
	}
*/

// Filling the hashMap
System.out.println("Beginning to fill the HASHMAP...");
int count = 0;
int flag = 0;
String[] temp = new String[2]; // contain nonterminal at [0]
		      // and rule at [1]
String[] tokens = null;
ArrayList rules = new ArrayList();
String nonTerminal = new String();
while ( count < fileLines.size() ){

			System.out.println("TOP" + count);


	// getting the line
	String currentLine = fileLines.get(count).toString();

	// Restting flags
	flag = 0;
	rules.clear();
	if ( currentLine.contains(":") )
	{

		tokens = currentLine.split(":");
		for (String token : tokens)
			{
			    if (token.equals("|"))
				    continue; // x will not increase
			    temp[flag] = token;
			    flag++;
			System.out.println("TOKEN " + count);
			}	

		// Picking the non-terminal sympole
		nonTerminal = temp[0];
		
		// Adding the First Rule
		rules.add(temp[1]);
			
		System.out.println("Before the last while " + count);
		// Adding the rest rules of the non-terminal
		if (!currentLine.equals("\n")){
		
			rules.add( currentLine );
		System.out.println("LAST WHILE " + count);
		}

		// Filling the HashMap
		hashMap.put(nonTerminal, rules);
		System.out.println("LAST " + count);


			
	} // end : if

	

count ++;





		
	} // end while filling




// testing hashmap




this.grammarHash = hashMap;






} // end grammar()











// @Yaser
 // a function that return Strings  from sentance split by space  
    public static String[] split(String word) {
        String[] array = word.split("\\s+");
        return array;
    } // End of funcrion 
// @Yaser
 // a function that return first word in strings 
    public static String returnFirst(String input) {
        int i = input.indexOf(' ');
        String word = input.substring(0, i);
        return word;
    } // End of funcrion





} // end GrammarManager
