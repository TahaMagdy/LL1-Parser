/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llparsing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author moroclash
 */
public class Firest_Follow {

	/**
	 * @moroclash
	 * this function get first of nonTermina
	 *
	 * @param grammar : this is a grammar that will extract first
	 * @return : return LinkedHashMap that have Key : is a Nonterminal ,
	 * value : is a First Array
	 */
	public static LinkedHashMap<String, HashSet<String>> getFirest(LinkedHashMap<String, ArrayList<String>> grammar) {
		//this is LinkedHashMap that will returned and it is now empty
		LinkedHashMap<String, HashSet<String>> Returnfirst = new LinkedHashMap<>();
		//loop on all nonTerminals
		for (Map.Entry<String, ArrayList<String>> map : grammar.entrySet()) {
			//get nonTerminal name
			String nonTerminal = map.getKey();
			//check if we get his firest before 
			if (!Returnfirst.containsKey(nonTerminal)) {
				//if not get his firests and put it in Returnfirst using this helpper function
				Fires(grammar, nonTerminal, new HashSet<String>(), Returnfirst);
			}
		}
		//return LinkedHashMap
		return Returnfirst;
	}

	/**
	 * @moroclash
	 * this helper function that will use to get first using recursion
	 * Algorithm
	 *
	 * @param grammar : this is a Original grammar
	 * @param nonTerminal : this is a nonTerminal name that will use to get
	 * his First
	 * @param firets : this is a empty ArrayList<String> that will have
	 * nonTerminal Firsts
	 * @param ruleFirest : this is Original rules that get First before
	 * @return :return ArrayList that have First of nonTerminal
	 */
	private static HashSet<String> Fires(LinkedHashMap<String, ArrayList<String>> grammar,
		String nonTerminal,
		HashSet<String> firets,
		LinkedHashMap<String, HashSet<String>> ruleFirest) {
		//this is a List of nonTerminal Rules
		ArrayList<String> rules = grammar.get(nonTerminal);
		//this will have First exe to every Rule
		String firestExe = "";
		//loop on all rules
		for (String rule : rules) {
			//get firest exe in rule
			firestExe = GrammarManager.returnFirst(rule);
			//check if firestExe not exist in Original Gramare
			if (!grammar.containsKey(firestExe)) {
				//if firestExe terminal add it in first ArrayList 
				firets.add(firestExe);
			} else //else if it's NonTerminal
			//check if we get his firests before
			{
				if (!ruleFirest.containsKey(firestExe)) {
					//if not ... get his firests
					firets.addAll(Fires(grammar, firestExe, new HashSet<String>(), ruleFirest));
				}
			}
		}
		//add nonTerminal and his firsts in ruleFirest HashMap to be finished
		ruleFirest.put(nonTerminal, firets);
		//return ArrayList of nonTerminal firsts
		return firets;
	}

	/**
	 * @moroclash
	 * this function use to get follow of nonterminals
	 * @param grammar : this is a original grammar of BNF
	 * @param firests : is a LinkedHashMap of nonTerminals and his firsts
	 * @return : return LinkedHashMap that have Key : is a Nonterminal ,
	 * value : is a Follow Array
	 */
	public static LinkedHashMap<String, HashSet<String>> getFollow(LinkedHashMap<String, HashSet<String>> firests,
		LinkedHashMap<String, ArrayList<String>> grammar) {
		//this is a LinkedHashMap that will returned
		LinkedHashMap<String, HashSet<String>> returnFollows = new LinkedHashMap<>();
		//this is a first Follow of firest NonTerminal in grammar
		HashSet<String> firestFollow = new HashSet<String>();
		//add Dollar Simpole "$" to Follows ArrayLit
		firestFollow.add("$");
		//get grammar interator that use to looping on grammar
		Iterator<Map.Entry<String, ArrayList<String>>> ito = grammar.entrySet().iterator();
		//get name of firest non-terminal from Grammar
		String firstNonTerminal = ito.next().getKey();
		//add firest non-terminal and his Follows on returnedFollows
		returnFollows.put(firstNonTerminal, firestFollow);
		//get his another follows
		follow(firstNonTerminal, returnFollows, firestFollow, grammar, firests);
		//loop on alll nonTerminal to get follow for every one
		for (Map.Entry<String, HashSet<String>> map : firests.entrySet()) {
			//check if we get his follow before or not
			if (!returnFollows.containsKey(map.getKey())) {
				//if not -  get his follow and add it in returnedFollows
				follow(map.getKey(), returnFollows, new HashSet<String>(), grammar, firests);
			}

		}
		//return follows for every nonTerminal
		return returnFollows;
	}

	
	
	/**
	 * @moroclash
	 * this is a helper function that use to get Follow of nonTerminal using recursion Algorithm
	 * 
	 * @param nonTerminal : this is a nonTerminal that will get his follow
	 * @param returnFollows : this is a LinkedHashMap where will put nonTerminal and his follows
	 * @param follow : this is a empty Set that will have follows
	 * @param grammar : this is a Original grammar 
	 * @param firests : this is a first of nonTerminals
	 * @return HashSet that will have follows and it use in recursion algorithm only
	 */
	private static HashSet<String> follow(String nonTerminal,
		LinkedHashMap<String, HashSet<String>> returnFollows,
		HashSet<String> follow,
		LinkedHashMap<String, ArrayList<String>> grammar,
		LinkedHashMap<String, HashSet<String>> firests) {
		//this is a nonTerminal positions in original Grammar
		ArrayList<String[]> nonTerminalPosition = getNonTerminalPositions(grammar, nonTerminal);
		//loop on data for every rule that have this nonTerminal in his exe's
		for (String[] value : nonTerminalPosition) {
			//check if we have first mood - use to get firsts to add them in follows 
			if (value[1].compareTo("0") == 0) {
				//check if value[0] "Check exe" is a nonTerminal
				if(firests.containsKey(value[0]))
				{
					//if nonTerminal that will get all his firest and add them in Follow of nonTeminal without epslon "em"
					//loop on all first's of nonTerminal to add simpols without "em"
					for(String v : firests.get(value[0]))
					{
						//if not epsilone
						if(!v.equalsIgnoreCase("em"))
						{
							//add it in follow arrayList
							follow.add(v);
						}
						else
						{
							//if epsilone 
							//get firest of after nonTerminal in the rule
							String []emfirest = getAfterExe(GrammarManager.split(value[2]), value[0], value[3], value[2]);					     //check if we get his follows before
							if (returnFollows.containsKey(emfirest[0])) {
								//if get befoure -- add his follows in follow array of nonTerminal
								follow.addAll(returnFollows.get(emfirest[0]));
							} //end if
							else 
							{
								//if not get befoure -- will get his follows recurionly
								HashSet<String> s = follow(emfirest[0], returnFollows, new HashSet<String>(), grammar, firests);
								//add his follows in nonTerminal follows array 
								follow.addAll(s);
							}//end else
						}//end else of his epsilon
					}//end loop of data of rule				
				}//end if of checking if value[0] nonTerminal or not
				else
					//if it is a Terminal --- add it in his follows array
					follow.add(value[0]);
			} //end of checking firest mood
			else 
			{
			   //is a follow mood
				//check if nonTerminal == value[0] "check exe" 
				if(value[0].compareTo(nonTerminal)!=0)
				{
					//if there equale each other
					//if get his follows befoure
					if (returnFollows.containsKey(value[0])) {
						//if get it befoure
						//add his follows in our nonTerminal follows array
						follow.addAll(returnFollows.get(value[0]));
					}
					else 
					{
						//if not get it befoure
						//get his follows
						HashSet<String> s = follow(value[0], returnFollows, new HashSet<String>(), grammar, firests);
						//add returned follows "s" to our nonTerminal follows array
						follow.addAll(s);
					}
				}
			}
		}
		//add nonTerminal and his follows to returnedFollow
		returnFollows.put(nonTerminal, follow);
		//return array of follow and thet important to recusrion algorith only
		return follow;
	}

	/**
	 * @moroclash
	 * helper function that used to get nonTerminal Position and his exe
	 * after his
	 *
	 * @param grammar : this LinkedHashMapp of Original grammar
	 * @param nonTerminal : this is a nonTerminal that will search about it
	 * @return LinkedHashMap that have key : nonTerminalName that have this
	 * nonTerminal in his rules value : exe after this nonTerminal
	 */
	private static ArrayList<String[]> getNonTerminalPositions(LinkedHashMap<String, ArrayList<String>> grammar, String nonTerminal) {
		//this LinkedHashMap that will return ...it is empty now
		ArrayList<String[]> Positions = new ArrayList<>();
		//loop on all nonTerminals
		for (Map.Entry<String, ArrayList<String>> map : grammar.entrySet()) {
			//arraList of  Rules
			ArrayList<String> rules = map.getValue();
			//loop on rules
			for (String rule : rules) {
				//Splite rule to many exe's in array 
				String[] exes = GrammarManager.split(rule);
				//boolean to check if found nonterminal == exe
				boolean flage = false;
				//loop on rule exe's
				for (int i = 0; i < exes.length; i++) {
					//check if exe equle nonTerminal
					if (exes[i].compareTo(nonTerminal) == 0) {
						//set Flage true 
						flage = true;
						//exit of loop
						break;
					}
				}
				//check if rule have nonTermonal 
				if (flage) {
					//if have ...will get firest exe after it
					String[] afterExe = getAfterExe(exes, nonTerminal, map.getKey(),rule);
					//add data of AfterExe in Positions array
					Positions.add( afterExe);
				}
			}// end of rule loop
		}
		//return Positions of rule in Original Grammar 
		return Positions;
	}

	/**
	 * @moroclash
	 * helper function that use to get exe that found after specific exe
	 * @param exes : this is a spite Rule
	 * @param exe : this is a exe that will get firest exe after it
	 * @param nonTerminal  : this is rule nonTerminal
	 * @param rule   : this is a rule 
	 * 
	 * @return array of some data   arr[0] : have the exe that will use to get follow
	 *				arr[1] : this is a mood of get First | Follow
	 *				arr[2] : this is a rule
	 *				arr[3] : this is a nonTerminal name
	 */
	private static String[] getAfterExe(String[] exes, String exe, String nonTerminal,String rule) {
		//array that will returned and it have the data
		String[] retString = new String[4];
		//loop ion all exe in exes
		for (int i = 0; i < exes.length; i++) {
			//if found the goal exe
			if (exe.compareTo(exes[i]) == 0) {
				//this try to chech if exes[i+1] get OutOfPoundExciptions
				try {
					//if not have any excption
					//add firest exe after the aim exe in firest cell in array
					retString[0] = exes[i + 1];
					// this is a mood to tell that will get firest of firest cell retString[0]
					retString[1] = "0";
					//this is his rule
					retString[2] = rule;
					//this is a nonTermianal name of retString[0]
					retString[3] = nonTerminal;
				} catch (Exception e) {
					//if found exceptiona that mean outOFboundArray
					//add the non terminal to get his follow
					retString[0] = nonTerminal;
					//this mood mean is a nonTerminal to get his follow
					retString[1] = "1";
					//this is his rule
					retString[2] = rule;
					//this is a nonTermianal name of retString[0]
					retString[3] = nonTerminal;
				}
				//exit from loop
				break;
			}//end loop
		}
		//return tha array of data
		return retString;
	}

}
