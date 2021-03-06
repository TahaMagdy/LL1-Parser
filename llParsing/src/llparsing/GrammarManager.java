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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author taha
 */
public class GrammarManager {
	

	


// @Taha
	// Getting the grammar from the file (Ambig..)
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

private static LinkedHashMap<String, ArrayList<String>> converter (LinkedHashMap<String, HashSet<String>> OLD ){
	LinkedHashMap<String, ArrayList<String>> NEW = new LinkedHashMap<>();
	OLD.forEach((k,v)->{
		ArrayList<String> ta = new ArrayList<>(v);
		NEW.put(k, ta);
	});
	return NEW;
}





// @Taha
// takes 
// 1* first,  LinkedHashMap of (key is non-terminal, value is arraylist of rule symbol)
// 2* follow, LinkedHashMap of (key is non-terminal, value is arraylist of rule symbol)
// 3* unambiguous rules
// 
// epsilon is "em"e
public static void parsingTable( LinkedHashMap<String, HashSet<String>> firstHash,
			  LinkedHashMap<String, HashSet<String>> followHash,
			  LinkedHashMap<String, ArrayList<String>>  rules ) 
{

	LinkedHashMap<String,ArrayList<String>> first = converter(firstHash);
	LinkedHashMap<String,ArrayList<String>> follow = converter(followHash);
	// FOR TESTING ONLEY
//	ArrayList<String> firstT = new ArrayList();
//	firstT.add("(");
//	firstT.add("id");
//	first.put("T", firstT );
//	first.put("E", firstT);
//	first.put("E`", firstT);
//
//	
//	follow.put("E`", firstT);
//
//	ArrayList eRule = new ArrayList();
//	eRule.add("T E`");
//	ArrayList e2Rule = new ArrayList();
//	e2Rule.add("+ T E`");
//	e2Rule.add("em");
//	rules.put("E", eRule);
//	rules.put("E`", e2Rule);
//
System.out.println("First is  " + first);
System.out.println("Follow is " + follow);

	// FOR TESTING ONLEY




	
// This will contain all symbols
Set<String> set = new HashSet<String>();
// Getting all symbols (Terminals&NonTerminals)
///////////////////////////////////////////////
// I'm getting all the symbols from the rules LinkedHashMap
///////////////////////////////////////////////
String[] cutString = null;
for (String keyOuter : rules.keySet()) {

	for (int x = 0; x < rules.get(keyOuter).size(); x++ ){

		// Adding every element in the rule
		// into a set
		cutString = split(rules.get(keyOuter).get(x));
		for (int i = 0; i <  cutString.length; i++){
			set.add(cutString[i]);
		} // end putting
	} // end symbols from rules

	
	for (String keyInnerFi : first.keySet()) {

	for (int x = 0; x < first.get(keyInnerFi).size(); x++ ){

		// Adding every element in the rule
		// into a set
		set.add(first.get(keyInnerFi).get(x));
	}
	}

	for (String keyInnerFo : follow.keySet()) {

	for (int x = 0; x < follow.get(keyInnerFo).size(); x++ ){

		// Adding every element in the rule
		// into a set
		set.add(follow.get(keyInnerFo).get(x));
	}
	}


	






	// Adding the left hand non-terminal
	set.add(keyOuter);
} // end filling the set.
System.out.println("THE ALL set >> " + set);

// System.out.println(set);



// After these two loops.
// nonTerminalSet will contains all non-terminals ONLY
// set will contain terminals ONLY
// * the First Only have noterminals on the left hand side
// * put all symbols in a set
// * AllSet - Fisrt = Terminals
Set<String> nonTerminalSet = new HashSet<String>();
	for (String key : first.keySet() ) {

		for (int x = 0; x < first.get(key).size(); x++ ){

			if ( set.contains(key)) {
				set.remove(key);
				nonTerminalSet.add(key);
			}
		}
	}  // end separating terminals and non-terminals

System.out.println("nonTerminals_Set (Raws)->" + nonTerminalSet );
System.out.println("terminals_Set    (Coln)->" + set);


// These two are used to control the assigning in the parsing table
// maps a (terminal/nonterminal) to an index
LinkedHashMap<String, Integer> indicesOfNonTerminal_Rows = new LinkedHashMap();
LinkedHashMap<String, Integer> indicesOfTerminal_Columns = new LinkedHashMap();


// Building indices controllers
Iterator<String> iteratorTerminal = set.iterator();
int index = 0;
String currentterminal = "";
for(String ss: set)
{
	currentterminal = ss;
	indicesOfTerminal_Columns.put( ss, index);
	System.out.println("Terminals Index " + ss
		+  " -> " + index);
	index++;
}
indicesOfTerminal_Columns.put("$", index); // adding $ to the terminals

index = 0;
for(String ss : nonTerminalSet){
		
	currentterminal = ss;	
	indicesOfNonTerminal_Rows.put( ss, index);
	System.out.println("NonTerminal Index " +  ss +  " -> " + index);
	
	index++;
}


System.out.println("IndicesRows " + indicesOfNonTerminal_Rows);
System.out.println("IndicesCols " + indicesOfTerminal_Columns);




// * Building the parsing table
int tableRows = nonTerminalSet.size();
int tableColm = set.size();


//int[ ][ ] a = new int[2][4];  // Two rows and four columns.
String[][] table = new String[tableRows+1][tableColm+1];



// Filling the Pasring Table
// Loop Over the hole grammar (nonTerminals)
String firstSymbol = "";
int firstCount = 0;
char letter = 0;
int innerWhile = 0;
String terminal  = "";
int terminalIndex = 0;
int nonTerminalIndex = 0;
// Loop Over the hole grammar (nonTerminals)
//indicesOfTerminal_Rows.forEach((k,v)->{System.out.println("key : " + k);System.out.println("int : "+v);});
for (String currentNonTerminal: rules.keySet()) {

//	System.out.println(indicesOfTerminal_Rows.containsKey(currentNonTerminal));
//	System.out.println("curret KEY " + currentNonTerminal);
	
	
// rules.get(currentNonTerminal) is a list of the rules for the currenNonTerminal 
//System.out.println( currentNonTerminal + " -- " + rules.get(currentNonTerminal));

	System.out.print("*********************: " + indicesOfNonTerminal_Rows.containsKey(currentNonTerminal)+"    "+currentNonTerminal);
nonTerminalIndex = indicesOfNonTerminal_Rows.get(currentNonTerminal);
	System.out.println("    "  + nonTerminalIndex);
	// Looping over the nonTerminal rules
	for (int i = 0; i < rules.get(currentNonTerminal).size(); i++)
	{
//
//		System.out.println("llllllllllllllllllllll : i="+i+"         "+ rules.get(currentNonTerminal).size());
//
//		// if the rule is epsilon
//		// current rule for the current nonTerminal rules.get(currentNonTerminal).get(i) 
		if (rules.get(currentNonTerminal).get(i).compareTo("em") == 0){
			

			// If the the rule is epsilon
			// We'll get the first of the current non-terminal
			// Put 
			for (int j = 0; j < follow.get(currentNonTerminal).size(); j++){

			terminal = follow.get(currentNonTerminal).get(j);
			// Getting the index of the terminal in the table (2D Array)
			terminalIndex = indicesOfTerminal_Columns.get(terminal);

			// 4* Addin the Rule in the Cell
			table[nonTerminalIndex][terminalIndex]
				= currentNonTerminal + " -> " + rules.get(currentNonTerminal).get(i);

System.out.println("Tabel[][] -> "+ table[nonTerminalIndex][terminalIndex]);		
		}
		// Rest indices for the next nonTerminal round
		terminalIndex = 0;
		nonTerminalIndex = 0;




		}/////////////////// 
		else {
				
		// 1* getting the first symbol
		firstSymbol = returnFirst(rules.get(currentNonTerminal).get(i));
System.out.println("First Symbol "+ firstSymbol);
//
//		// 2* Getting the first of the firstSymbol
//		// 3* Adding the rule into the (NonTerminalRow, TerminalColumns)
//
//
//
//		// Gettin the index of the non-terminal in the table (2D Array)
//		// if firstSymbol is terminal
//		// then put it in the terminal coulmn
		System.out.println("the Current non (NEED_INDEX) >>>>> " + currentNonTerminal);
			System.out.println(" (NEED_INDEX) >>>>> " + indicesOfNonTerminal_Rows);

		if ( set.contains(firstSymbol)) {
			
			
			terminalIndex = indicesOfTerminal_Columns.get(firstSymbol);
			
			try {
			table[nonTerminalIndex][terminalIndex]
			= currentNonTerminal + " -> " + rules.get(currentNonTerminal).get(i);
			} catch(Exception e) {
			
				table[nonTerminalIndex][terminalIndex] = "sym";
				
			}
		} //  firstSymbol is terinal
//		else // the symbol is terminal -> get its index directly
//		{
//System.out.println("377 FirstELSE" + firstSymbol);
//		for (int j = 0; j < first.get(firstSymbol).size(); j++){
//
//			terminal = first.get(firstSymbol).get(j);
//			// Getting the index of the terminal in the table (2D Array)
//			terminalIndex = indicesOfNonTerminal_Columns.get(terminal);
//
//			// 4* Addin the Rule in the Cell
//			table[nonTerminalIndex][terminalIndex]
//				= currentNonTerminal + " -> " + rules.get(currentNonTerminal).get(i);
//
//System.out.println("Tabel[][] -> "+ table[nonTerminalIndex][terminalIndex]);		
//		}
//		// Rest indices for the next nonTerminal round
//		terminalIndex = 0;
//		nonTerminalIndex = 0;
//
//
//
//
//		}
		} // not epsilon



	} // end nonTerminal rules 

} // end NonTerminals










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
