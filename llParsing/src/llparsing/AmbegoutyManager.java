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
import java.util.Map;
import java.util.Set;

/**
 *
 * @author moroclash
 */
public class AmbegoutyManager {

	private static int exeNum = 0;
	private static int NonterminalDashNum = 1;
	private static String NonterminalDashName = "X";

	private static String getname() {
		String name = NonterminalDashName + NonterminalDashNum;
		NonterminalDashNum++;
		return name;
	}

	private static int getExeNum() {
		return exeNum;
	}

	private static void increasExeNum() {
		exeNum++;
	}

	private static void SetZeroExeNum() {
		exeNum = 0;
	}

	/**
	 * @moroclash this function Take Grammar to delete Left Factoring
	 *
	 * @param Grammer : this is a Grammar
	 *
	 * Complexity : worse -> N^4 best -> N^3 log(n)
	 */
	public static void deletLeftFactoring(LinkedHashMap<String, ArrayList<String>> Grammer) {
		//this to loop on all non terminal to delete left factoring
		for (Map.Entry<String, ArrayList<String>> Nonterminal : Grammer.entrySet()) {
			String nonTerminal = Nonterminal.getKey();
			ArrayList<String> rules = Nonterminal.getValue();
			SetZeroExeNum();
			//Rules number that will applied remove exenum of exe's
			Set<Integer> rulesPositions = new HashSet<>();
			//number of cell that will be removed from Rules
			int exeNum = 0;
			//number of rules
			int RulesSize = rules.size();
			//check if nonTrminal have one rule or not
			if (rules.size() != 1) {
				//position : this is a exe position in String[] to check it with arr Strings that in the same lvl
				//minExeNum : the less length of String[]
				int position = 0, minExeNum;
				//this list have all rulles but Tokonaizes
				ArrayList<String[]> Splitrules = new ArrayList<>();
				// tokonaize rule to String[] of exe's
				rules.forEach(rule -> {
					Splitrules.add(GrammarManager.split(rule));
				});
				//get all rull position that have same exe in position String[0] 
				HashSet<Integer> rulePosition = (HashSet<Integer>) getPositions(Splitrules, position);
				//check if have many Rules have the same exe at firest
				if (rulePosition.size() > 1) // increase ExeNum by 1
				{
					increasExeNum();
				}
				//this have the final position of rules that have same exe's
				HashSet<Integer> OreginalRulePosition = new HashSet<>();
				//this loop to check if Rules position have the same exe in another lvl's
				while (rulePosition.size() > 1) {
					minExeNum = 1000;
					//have  List of Postion that have the same exe only
					ArrayList<String[]> spli = new ArrayList<>();
					// fill List "split"
					for (int num : rulePosition) {
						//get original Rule from Splitrules
						String[] exeL = Splitrules.get(num);
						//add it in spli  Arr
						spli.add(exeL);
						//check min number of exe's in roule's
						if (minExeNum > exeL.length) {
							minExeNum = exeL.length;
						}
					}
					//check if rulePosition have some rules after filter them
					if (rulePosition.size() != 0) {
						//copy it in anther Place
						OreginalRulePosition = new HashSet<>(rulePosition);
					}
					//increase Search lvl to check other lvl of exe
					position++;
					//check if lvl is >= minExeNum to Avoid OutOfBoud Exciption
					if (position >= minExeNum) {
						break;
					}
					//check a new lvl of exe's
					rulePosition = (HashSet<Integer>) getPositions(spli, position);
					//check if found same exe's in another lvl to all rules that have the same in previous lvl
					if (OreginalRulePosition.size() == rulePosition.size()) //increase final lvl of have same
					{
						increasExeNum();
					} else {
						break;
					}
				}
				//check if have more than one rule have left factoring
				if (OreginalRulePosition.size() > 1) {
					//this is sub rule that will added in new nun terminal
					ArrayList<String> subExe = new ArrayList<>();
					//this is name of new Nuntermianl
					String name = getname();
					//get firest rule form Splitrues
					String[] Exe = Splitrules.get(OreginalRulePosition.iterator().next());
					//get repeated subExe from any exe
					String[] PreExe = Arrays.copyOfRange(Exe, 0, getExeNum());
					//remove left reqursion from another exe's
					int minus = 0;
					for (int Posit : OreginalRulePosition) {
						String[] AnotherExe = Splitrules.get(Posit);
						//remove non repeated exe's from rules
						String[] PostExe = Arrays.copyOfRange(AnotherExe, getExeNum(), AnotherExe.length);
						String PostString = String.join(" ", PostExe);
						if (PostExe.length == 0) {
							PostString = "epslon";
						}
						//add it to new Rules list
						subExe.add(PostString);
						//remove this rule form original grammar
						Grammer.get(nonTerminal).remove(Posit - minus);
						minus++;
					}
					//add new rule in Original Rules array
					rules.add(String.join(" ", PreExe) + " " + name);
					LinkedHashMap<String, ArrayList<String>> newSubGram = new LinkedHashMap<>();
					//add new nonTerminal in Original Grammar
					newSubGram.put(name, subExe);
					deletLeftFactoring(newSubGram);
					Grammer.putAll(newSubGram);
				}
			}//end of condition of nonTerminal have one rule
		}//end of NonTerminal Loop
	}

	/**
	 * to get all rules have the same exe
	 *
	 * @param rules : this array of rules
	 * @param exePosition : position of exe
	 * @return Set that have all rules number
	 *
	 * Complexity : best -> n*log(n) : worse -> n^2
	 */
	private static Set getPositions(ArrayList<String[]> rules, int exePosition) {
		//this have final position that have the same of maxRepetation
		HashSet<Integer> rulesNumber = new HashSet<>();
		//this map to speed up the algorithm
		HashMap<String, Integer> rulesPositions = new HashMap<>();
		//this have number of repetation to all positions
		int[] arr = new int[rules.size()];
		//max : is a max number of repetation
		//size : number of rules
		int max = 0, size = rules.size();
		//loop to get number of repetation for every exe
		for (int i = 0; i < size; i++) {
			//number of repetation for every exe
			int num = 1;
			//this is a exe that will get number of his repetation
			String exe1 = rules.get(i)[exePosition];
			//check in hashMapp if calculated befoure of not ....this to optomize algorithm
			if (!rulesPositions.containsKey(exe1)) {
				//loop on all exe's to compare exe1 with thim
				for (int j = 0; j < size; j++) {
					//check if exe1 == the another exe
					// if i==j it's mean the same exe so should skip it
					if (i != j && exe1.compareTo(rules.get(j)[exePosition]) == 0) {
						//increase num of repatation
						num++;
					}
				}
				//add it in Hashmap to skip it if repeated
				rulesPositions.put(exe1, num);
				//add number of repatation in arr
				arr[i] = num;
			} else {
				//if found it in HashMapp
				//add value of repatation in arr
				arr[i] = rulesPositions.get(exe1);
			}
			//check to get max num of repatation of exe's
			if (num > max) {
				max = num;
			}
		}
		//check if have Max > 1
		if (max != 1) {
			// add final position that have same exe in same lvl in rulesNumber
			for (int i = 0; i < rules.size(); i++) {
				if (arr[i] == max) {
					rulesNumber.add(i);
				}
			}
		}
		//return final poditions
		return rulesNumber;
	}

	/**
	 * this function use to remove left recursion
	 *
	 * @param Grammer : this is grammar where will remove Left recursion
	 */
	public static void RemoveLeftReqursion(LinkedHashMap<String, ArrayList<String>> Grammer) {
		//loop on all nonTerminal rules to remove lef recusrion
		for(Map.Entry<String, ArrayList<String>> map:Grammer.entrySet())
		{
			String nonteminal = map.getKey();
			ArrayList<String> rules = map.getValue();
			//name of new nonTerminal
			String name = getname();
			boolean flage = false;
			ArrayList<String> Newrules= new ArrayList<>();
			int min=0,size=rules.size();
			//loop on all rules
			for (int i = 0; i < size; i++) {
				String rule = rules.get(i-min);
				if (nonteminal.compareTo(GrammarManager.returnFirst(rule)) == 0) {
					Newrules.add(GrammarManager.removeFirestExe(rule)+" "+name);
					rules.remove(i-min);
					min++;
					flage = true;
				}
			}
			if (flage) {
				for (int i = 0; i < rules.size(); i++) {
					rules.set(i, rules.get(i) +" "+ name);
				}
			}
			Newrules.add("epslon");
			Grammer.put(name, Newrules);
		}

	}

}
