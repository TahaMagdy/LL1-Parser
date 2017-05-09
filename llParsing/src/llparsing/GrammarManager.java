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
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 *
 * @author taha
 */
public class GrammarManager {
	

	


// @Taha
public LinkedHashMap<String, ArrayList<String>> grammar() throws FileNotFoundException, IOException {


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
//		System.out.println("Contents of file:");
//		System.out.println(stringBuffer.toString());
	} catch (IOException e) {
		e.printStackTrace();
	}

	// Testing lines array
	int x = 0;
	while ( x < fileLines.size() ){
//		System.out.print(fileLines.get(x));
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
//System.out.println("Beginning to fill the HASHMAP...");
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
//			    System.out.println( ">>>>>TOKENS "+ temp[0] + " " + temp[1]);
			}	

		// Picking the non-terminal sympole
		nonTerminal = temp[0];
		rules[currentNonTeminal] = new ArrayList();
		temp[1] = temp[1].trim();
		rules[currentNonTeminal].add(temp[1]); // r1
	} else {


		if ( currentLine.contains("|") )
		{
			// Remove " | " chars
			String cleaned = currentLine.
				replaceAll("(\\s\\|\\s)|(\\|)|(\\|\\s)|(\\s\\|)", 
					"");
			cleaned = cleaned.trim();
			rules[currentNonTeminal].add(cleaned);

		} else if ( currentLine.equals("\n") ){


			nonTerminal = nonTerminal.trim();
			hashMap.put(nonTerminal, rules[currentNonTeminal]);
			
		}

	} // end else



	


	
count++; // Get the next line
	} // end while filling




// testing hashmap
//    System.out.println("OUT: > " + hashMap );



return hashMap;
} // end grammar()








// @Taha
// takes unambiguous rules
public void parsingTable( LinkedHashMap<String, ArrayList<String>> first,
			  LinkedHashMap<String, ArrayList<String>> follow,
			  ArrayList<String> rules ) 
{

	// FOR TESTING ONLEY
	ArrayList<String> ar1 = new ArrayList();
	ar1.add("(");
	ar1.add("id");
	ar1.add("name");
	ArrayList<String> ar2 = new ArrayList();
	ar2.add("*");
	ar2.add("+");
	ar2.add("id");


	first.put("E", ar1 );
	first.put("F", ar2 );
	// FOR TESTING ONLEY




	
// This will contain all symbols
Set set = new HashSet();
// Getting all symbols (Terminals&NonTerminals)
for (String key : first.keySet()) {

	for (int x = 0; x < first.get(key).size(); x++ ){

		// Adding every element in the rule
		// into a set
		set.add(first.get(key).get(x));
	}
	// Adding the left hand non-terminal
	set.add(key);
} // end filling the set.

// System.out.println(set);



// After these two loops.
// nonTerminalSet will contains all non-terminals ONLY
// set will contain terminals ONLY
// * the First Only have noterminals on the left hand side
// * put all symbols in a set
// * AllSet - Fisrt = Terminals
Set nonTerminalSet = new HashSet();
	for (String key : first.keySet()) {

		for (int x = 0; x < first.get(key).size(); x++ ){

			if ( set.contains(key)) {
				set.remove(key);
				nonTerminalSet.add(key);
			}
		}
	}  // end separating terminals and non-terminals

//System.out.println("nonTerminals ->" + nonTerminalSet );
//System.out.println("terminals ->" + set);



// * Building the parsing table
int tableRows = nonTerminalSet.size();
int tableColm = set.size();











} // end parsingTable()














////////////////////////////////////////////////////////////////////////////////


// @Yaser
 // a function that return Strings  from sentance split by space  
    public static String[] split(String word) {
        String[] array = word.split("\\s+");
        return array;
    } // End of funcrion 
// @Yaser
 // a function that return first word in strings 
    public static String returnFirst(String input) {
    String result = input;  // if no space found later, input is the first word

    for(int i = 0; i < input.length(); i++)
    {
        if(input.charAt(i) == ' ')
        {
            result = input.substring(0, i);
            break;
        }
    }

    return result;
    } // End of funcrion
    
    

    /**
     * remove first  exe from rule
     * @param rule : this is a rule that will remove the first  
     * @return String of rule without first
     */
    // @Yaser
    public static String removeFirestExe(String rule)
    {
	    String []SplitRule = split(rule);
	    return  String.join(" ", Arrays.copyOfRange(SplitRule, 1,SplitRule.length));
    }

} // end GrammarManager
