/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llparsing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author taha
 */
public class GrammarManager {
	


public void grammar() throws FileNotFoundException, IOException {

	FileInputStream file = null;

      try {
         file = new FileInputStream("Grammer/Grammer.txt");
         
         int c;
         while ((c = file.read()) != -1) {
		System.out.print(c);
         }
      }finally {
         if (file != null) {
            file.close();
         }
      } // end finally




} // end grammar()








} // end GrammarManager
