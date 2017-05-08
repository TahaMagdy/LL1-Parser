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

/**
 *
 * @author taha
 */
public class GrammarManager {
	
	


public void grammar() throws FileNotFoundException, IOException {


      ArrayList fileLines = new ArrayList();


      // Reading lines
	try {
		File file = new File("Grammer/Grammer.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuilder stringBuffer = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			stringBuffer.append(line);
			stringBuffer.append("\n");
			fileLines.add(line);
			fileLines.add("\n");
		}
		fileReader.close();
		System.out.println("Contents of file:");
		//System.out.println(stringBuffer.toString());
	} catch (IOException e) {
		e.printStackTrace();
	}

	int x = 0;
	while ( x < fileLines.size() ){
		System.out.print(fileLines.get(x));
		x++;
	}
	



} // end grammar()








} // end GrammarManager
