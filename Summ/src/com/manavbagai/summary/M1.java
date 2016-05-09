package com.manavbagai.summary;
import java.util.List;

import edu.stanford.nlp.simple.*;
public class M1 {

	public String[][] lemma1(String s5)
	{
		String s=s5.toLowerCase();
	   String[][] s1= new String[10000][10000]; int i=0;
		Document doc = new Document(s);
        for (Sentence sent : doc.sentences()) {  
           int j=0;
           
           // When we ask for the lemma, it will load and run the part of speech tagger
          while(j!=sent.length())
          {
        s1[i][j]= sent.lemma(j); 
           
           j++;
	}
          i++;
}
        return (s1);
	}
	public List<Sentence> sentence1(String s)
	{
		//int i=0;
		Document doc = new Document(s);
	
			   List<Sentence> sentence =doc.sentences();
			//  System.out.println(sentence);
			return (sentence);
		   }
	}


