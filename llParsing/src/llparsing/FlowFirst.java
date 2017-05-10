/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llparsing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author moroclash
 */
public class FlowFirst {

	public static LinkedHashMap<String, ArrayList<String>> getFirstSet(LinkedHashMap<String, ArrayList<String>> grammers) {
		int changeFlag = 1;
		LinkedHashMap<String, ArrayList<String>> firstset = new LinkedHashMap<>();
		ArrayList<String> first = new ArrayList<>();
		String[] firsts = new String[grammers.size()];
		String[] firstsOld = new String[grammers.size()];

		int i = 0;
		HashMap<String, Integer> m = new HashMap<>();
		// intilize sets 
		for (String g : grammers.keySet()) {
			firstset.put(g, first);
			firsts[i] = "";
			m.put(g, i);
			i++;
		}
		int chenge = 1;

		while (chenge == 1) {
			i = 0;
			firstsOld = firsts.clone();

			for (Map.Entry<String, ArrayList<String>> grammer : grammers.entrySet()) {
////////            // System.err.println(i);
				String cuurentgrammer = grammer.getKey();
				ArrayList<String> rules = grammer.getValue();

////////             //System.out.println(cuurentgrammer + " " +firstset.get(cuurentgrammer).toString());
				for (String rule : rules) {

					String[] firstOne = rule.split("\\s");
////////                // System.out.println(firstOne[0]);
					if (grammers.get(firstOne[0]) == null) {

						first.add(firstOne[0]);
						if (firsts[i].contains(firstOne[0])) {

						} else {
							firsts[i] = firsts[i] + " " + firstOne[0];
						}

////////                     //System.out.println(first.toString());
					} else {

						int l = m.get(firstOne[0]);

						if (firsts[i].contains(firsts[l])) {

						} else {
							firsts[i] = firsts[i] + " " + firsts[l];
////////                         System.err.println("add non");
////////                         System.out.println(">>>" +firsts[1]);
						}

					}

				}

				i++;

			}

////////           // System.err.println(chenge);
			chenge++;

			if (Arrays.equals(firsts, firstsOld)) {
				chenge = 0;
			} else {
				chenge = 1;
			}

		}

		System.out.println(firsts[1]);
		String[] f = firsts[1].split("\\s");

		for (Map.Entry<String, ArrayList<String>> firstSet : firstset.entrySet()) {
////////             //System.err.println(i);
			ArrayList<String> n = new ArrayList<>();

			int index = m.get(firstSet.getKey());
			f = firsts[index].split("\\s");
//          //      System.out.println(f.toString());
			for (String k : f) {

				if (!k.matches("[ -]*") && !n.contains(k)) {
//                    System.out.println(">>>" +k);
					n.add(k);
				}
			}
//////               // System.out.println(firstSet.getKey() + n);
			firstset.put(firstSet.getKey(), n);

		}
/////          System.out.println(firstset.get("S"));

		return firstset;

	}

	public static LinkedHashMap<String, ArrayList<String>> getFollowSet(LinkedHashMap<String, ArrayList<String>> grammers) {
		int changeFlag = 1;
		LinkedHashMap<String, ArrayList<String>> folowSets = new LinkedHashMap<>();
		LinkedHashMap<String, ArrayList<String>> ferstsets = getFirstSet(grammers);
		ArrayList<String> grammerRule = new ArrayList<>();
		ArrayList<String> follow = new ArrayList<>();
		String[] followArray = new String[ferstsets.size()], followArrayOld = new String[ferstsets.size()];
		HashMap<String, Integer> ruleMap = new HashMap<>();
		int j = 0;
		for (String g : grammers.keySet()) {
			ruleMap.put(g, j);
			followArray[j] = "";
////            System.out.println(j);
			grammerRule.add(g);
			folowSets.put(g, follow);
//            System.err.println(g);
			j++;
		}
//        //System.err.println(j);

		int i = 0;
		int index = 0;
		while (changeFlag == 1)// ÇááæÈ Ïí ÈÊÞÝ áãÇ ãíÍÕáÔ ÊÛííÑ 
		{
			followArrayOld = followArray.clone();
			if (i == 0) // áæ Ïå Çæá ÌÑÇãÑ ÈäÍØ ÏæáÇÑ 
			{
				followArray[i] = followArray[i] + "$";
			}
			for (String r : grammerRule) // ÈäáÝ Ýí  Úáì ÇáÓíãÈæá  
			{//for 1
				ArrayList<String> ruleInS = new ArrayList<>();
				ruleInS.addAll(grammers.get(r)); // ÈäÌíÈ ÇáÞæÇÚÏ ÈÊÇÚÊåÇ 
				for (String ff : ruleInS)// ÈäáÝáì ÇáÑáÒ ÈÊÇÚÊ ÇÓãÈæá Ç
				{//for 2

					String[] ss = ff.split("\\s");// ÈÊÍæá ÇáÑæá áÇÇÑí ãä ÓÊÑíäÌ 
////                    //System.err.println(ss[1]);
					for (int l = 0; l < ss.length; l++) // ÈÊÔæÝ ßá  ÍÇÌå Ýí ÇáÑæá 
					{//for 3
						if (grammerRule.contains(ss[l]))//áæ  ÇáÍÑÝ Çæ ÇáÓÊÑíäÌ Ïå ÌÑÇãÑ ÍíÌíÈ ÇáÝæáæ ÈÊÇÚå 
						{//if 1 : for 3

							// if 2 : for 3
							if (l + 1 < ss.length && grammerRule.contains(ss[l + 1])) {// áæ Çááí ÈÚÏ Çááí ÇáäæäÊÑãäÇá äæäÊÑãäÇá ÍäÌíÈ ÇáÝÑÓÊ ÈÊÇÚå æäÍØ Ýíå ÇáÝæáææ á 
								ArrayList<String> M = new ArrayList<>();
								M.addAll(ferstsets.get(ss[l + 1]));
								for (String n : M) {
									if (n.equals("?")) {
										continue;
									}
									if (!followArray[ruleMap.get(ss[l])].contains(n)) {
										followArray[ruleMap.get(ss[l])] = followArray[ruleMap.get(ss[l])] + " " + n;
									}
									// continue;
								}
							}// if 2 : for 3

							// System.err.println(">>?"+followArray[ruleMap.get(r)]);
							if ((l + 1) == ss.length) {
//                                //System.err.println("______" + followArray[ruleMap.get(r)]);
								if (!followArray[ruleMap.get(ss[l])].contains(followArray[ruleMap.get(r)])) {
									followArray[ruleMap.get(ss[l])] = followArray[ruleMap.get(ss[l])] + " " + followArray[ruleMap.get(r)];
									//System.err.println(">>"+followArray[ruleMap.get(r)]);
								}
							} else // áæ Çááí ÈÚÏ ÇáäÇäÑÊãäÇá ãÔ äæä 
							 if (l + 1 < ss.length) {
									if (!followArray[ruleMap.get(ss[l])].contains(ss[l + 1]) && !grammerRule.contains(ss[l + 1])) {
										followArray[ruleMap.get(ss[l])] = followArray[ruleMap.get(ss[l])] + " " + ss[l + 1];
									}
								} else if (!followArray[ruleMap.get(ss[l])].contains(followArray[ruleMap.get(r)])) {
									followArray[ruleMap.get(ss[l])] = followArray[ruleMap.get(ss[l])] + " " + followArray[ruleMap.get(r)];
								}
						}//if 1 : for 3 
						else // Ííßãá áæ ÇáÍÑÝ Ïå ãÔ Ñæá 
						{
							continue;
						}
					}//end for 3
				}//end for2
			}// end for1

			i++;

			if (Arrays.equals(followArray, followArrayOld)) {
				changeFlag = 0;
			} else {
				changeFlag = 1;
			}
			// changeFlag++;
		}

//            System.out.println(followArray[1]);
		String[] fo = followArray[1].split("\\s");

		for (Map.Entry<String, ArrayList<String>> firstSet : folowSets.entrySet()) {
////////             //System.err.println(i);
			ArrayList<String> n = new ArrayList<>();

			index = ruleMap.get(firstSet.getKey());
			fo = followArray[index].split("\\s");
//          //      System.out.println(f.toString());
			for (String k : fo) {

				if (!k.matches("[ -]*") && !n.contains(k)) {
//                    System.out.println(">>>" +k);
					n.add(k);
				}
			}
//////               // System.out.println(firstSet.getKey() + n);
			folowSets.put(firstSet.getKey(), n);

		}
		System.out.println(folowSets.get("x"));

		return folowSets;

	}

}
