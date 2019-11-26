/*
  CISC3130 Assignment 3 
  Objective:
  1. Prepare a text file that contains text to analyze. It could be song lyrics to your favorite song. 
  2. With your code, you’ll read from the text file and capture the data into a data structure. 
  3. Using a data structure, write the code to count the appearance of each unique word in the lyrics.
  4. Print out a word frequency list. 

  Instructor: Katherine Chuang, Section: MY9 
  Brooklyn College
 
  Student Name: Hiu Wing, Lam
  Empl ID: 23626630
  Date: 11/27/2019
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;



public class WordFrequencies
{
   public static void main(String[] args) throws FileNotFoundException{
	 
	 //Prepare a text file that contains text to analyze
     String filename = "Watermelon Sugar Lyrics.txt";
     
     HashMap <String,Integer> map = new HashMap<String,Integer>();
     
     //read from the text file and capture the data into a data structure
     Scanner reader = new Scanner(new File(filename));
     
     while (reader.hasNext()){
    	 
      String text = reader.next();
      
      //converts all the characters of the String into lower case characters
      String word = text.toLowerCase();
      
      //count the appearance of each unique word in the lyrics
      if (map.containsKey(word)){ 
    	  
      map.put(word,map.get(word)+1);
      
      } 
      else {
    	  
      map.put(word,1);
      
      }
     }
     
     LinkedList<HashMap.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
     
     Comparator<HashMap.Entry<String, Integer>> comparator = Comparator.comparing(HashMap.Entry::getValue);
     
     //Sorting the HashMap in descending order based on the value
     Collections.sort(list, comparator.reversed());
     
     //Print out a word frequency list
     for (HashMap.Entry entry : list)
     
     System.out.println(entry.getValue() + ": " + entry.getKey());          
           
 }
}

/*
The contents of the Watermelon Sugar Lyrics.txt file:
Watermelon sugar high
Watermelon sugar high
Watermelon sugar high
Watermelon sugar high 
Watermelon sugar high
Watermelon sugar high
Watermelon sugar high
Watermelon sugar high

I just wanna taste it
Watermelon sugar

The output for that input file should look like:
9: watermelon
9: sugar
8: high
1: taste
1: i
1: it
1: just
1: wanna
*/