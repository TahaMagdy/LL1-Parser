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
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author taha
 */
public class GrammarManager {
	

	


// @Taha
public HashMap<String, ArrayList<String>> grammar() throws FileNotFoundException, IOException {


	LinkedHashMap<String, ArrayList<String>> hashMap = new LinkedHashMap();
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
String[] tokens = new String[3];
String nonTerminal = new String();

ArrayList<String> rules[] = new ArrayList[100]; // TESTING

int currentNonTeminal = -1;
while ( count < fileLines.size() ){


	// getting the line
	String currentLine = fileLines.get(count).toString();

	// Restting flags
	flag = 0;
	if ( currentLine.contains(":") )
	{
		currentNonTeminal ++;

		tokens = currentLine.split(":");
		for (String token : tokens)
			{
			    if ( token.equals(":") )
				    continue;
			    temp[flag] = token;
			    flag++;
			    System.out.println( ">>>>>TOKENS "+ temp[0] + " " + temp[1]);
			}	

		// Picking the non-terminal sympole
		nonTerminal = temp[0];
		rules[currentNonTeminal] = new ArrayList();
		rules[currentNonTeminal].add(temp[1]); // r1
	} else {


		if ( currentLine.contains("|") )
		{
			StringBuilder removed = new StringBuilder(currentLine);
			removed.deleteCharAt(0);

			rules[currentNonTeminal].add(removed.toString());

		} else if ( currentLine.equals("\n") ){

			hashMap.put(nonTerminal, rules[currentNonTeminal]);
			
		}

	}



	


	
count++; // Get the next line
	} // end while filling




// testing hashmap
    System.out.println("OUT: > " + hashMap );



return hashMap;
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


    /**
     * remove first  exe from rule
     * @param rule : this is a rule that will remove the first  
     * @return String of rule without first
     */
    public static String removeFirestExe(String rule)
    {
	    String []SplitRule = split(rule);
	    return  String.join(" ", Arrays.copyOfRange(SplitRule, 1,SplitRule.length));
    }

} // end GrammarManager
