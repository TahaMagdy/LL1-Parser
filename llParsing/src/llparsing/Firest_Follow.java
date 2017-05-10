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
	 * this function use to get follow of nonterminals
	 *
	 * @param firests : is a LinkedHashMap of nonTerminals and his firsts
	 * @return : return LinkedHashMap that have Key : is a Nonterminal ,
	 * value : is a Follow Array
	 */
	public static LinkedHashMap<String, HashSet<String>> getFollow(LinkedHashMap<String, HashSet<String>> firests,
		LinkedHashMap<String, ArrayList<String>> grammar) {
		//this is a LinkedHashMap that will returned
		LinkedHashMap<String, HashSet<String>> returnFollows = new LinkedHashMap<>();

		HashSet<String> firestFollow = new HashSet<String>();
		firestFollow.add("$");
		Iterator<Map.Entry<String, ArrayList<String>>> ito = grammar.entrySet().iterator();
		String firstNonTerminal = ito.next().getKey();
		returnFollows.put(firstNonTerminal, firestFollow);
		follow(firstNonTerminal, returnFollows, firestFollow, grammar, firests);
		//loop on alll nonTerminal to get follow for every one
		for (Map.Entry<String, HashSet<String>> map : firests.entrySet()) {
			if (!returnFollows.containsKey(map.getKey())) {
				follow(map.getKey(), returnFollows, new HashSet<String>(), grammar, firests);
			}

		}
		return returnFollows;
	}

	private static HashSet<String> follow(String nonTerminal,
		LinkedHashMap<String, HashSet<String>> returnFollows,
		HashSet<String> follow,
		LinkedHashMap<String, ArrayList<String>> grammar,
		LinkedHashMap<String, HashSet<String>> firests) {
		ArrayList<String[]> nonTerminalPosition = getNonTerminalPositions(grammar, nonTerminal);
		for (String[] value : nonTerminalPosition) {
			if (value[1].compareTo("0") == 0) {
				if(firests.containsKey(value[0]))
				{
					for(String v : firests.get(value[0]))
					{
						if(!v.equalsIgnoreCase("em"))
						{
							follow.add(v);
						}
						else
						{
							String []emfirest = getAfterExe(GrammarManager.split(value[2]), value[0], value[3], value[2]);						
							if (returnFollows.containsKey(emfirest[0])) {
								follow.addAll(returnFollows.get(emfirest[0]));
							}
							else 
							{
								HashSet<String> s = follow(emfirest[0], returnFollows, new HashSet<String>(), grammar, firests);
								follow.addAll(s);
							}
						}
					}				
				}
				else
					follow.add(value[0]);
			} 
			else 
			{
				if(value[0].compareTo(nonTerminal)!=0)
				{
					if (returnFollows.containsKey(value[0])) {
						follow.addAll(returnFollows.get(value[0]));
					}
					else 
					{
						HashSet<String> s = follow(value[0], returnFollows, new HashSet<String>(), grammar, firests);
						follow.addAll(s);
					}
				}
			}
		}
		returnFollows.put(nonTerminal, follow);
		return follow;
	}

	/**
	 * helper function that used to get nonTerminal Position and his exe
	 * after his
	 *
	 * @param grammar : this LinkedHashMapp of Original grammar
	 * @param nonTerminal : this is a nonTerminal that will search about it
	 * @return LinkedHashMap that have key : nonTerminalName that have this
	 * nonTerminal in his rules value : exe after this nonTerminal
	 */
	public static ArrayList<String[]> getNonTerminalPositions(LinkedHashMap<String, ArrayList<String>> grammar, String nonTerminal) {
		//this LinkedHashMap that will return ...it is empty now
		ArrayList<String[]> Positions = new ArrayList<>();
		//loop on all nonTerminals
		for (Map.Entry<String, ArrayList<String>> map : grammar.entrySet()) {
			//arraList of  Rules
			ArrayList<String> rules = map.getValue();
			//loop on rules
			for (String rule : rules) {
				String[] exes = GrammarManager.split(rule);
				boolean flage = false;
				for (int i = 0; i < exes.length; i++) {
					if (exes[i].compareTo(nonTerminal) == 0) {
						flage = true;
						break;
					}
				}
				//check if rule have nonTermonal 
				if (flage) {
					//if have ...will get firest exe after it
					String[] afterExe = getAfterExe(exes, nonTerminal, map.getKey(),rule);
					Positions.add( afterExe);
				}
			}
		}
		return Positions;
	}

	/**
	 * helper function that use to get exe that found after specific exe
	 *
	 */
	public static String[] getAfterExe(String[] exes, String exe, String nonTerminal,String rule) {
		String[] retString = new String[4];
		for (int i = 0; i < exes.length; i++) {
			if (exe.compareTo(exes[i]) == 0) {
				try {
					retString[0] = exes[i + 1];
					retString[1] = "0";
					retString[2] = rule;
					retString[3] = nonTerminal;
				} catch (Exception e) {
					retString[0] = nonTerminal;
					retString[1] = "1";
					retString[2] = rule;
					retString[3] = nonTerminal;
				}
				break;
			}
		}
		return retString;
	}

}
