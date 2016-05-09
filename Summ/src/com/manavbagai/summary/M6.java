package com.manavbagai.summary;
import edu.stanford.nlp.simple.*;
public class M6 {
	public String[] pos22(String s)
	{
		s.toLowerCase();
	   String[] s1= new String[5000]; int i=0;
		Document doc = new Document(s);
        for (Sentence sent : doc.sentences()) {  
           int j=0;
           
           // When we ask for the lemma, it will load and run the part of speech tagger
          while(j!=sent.length())
          {
       // if(sent.posTag(j).equals("NN") || sent.posTag(j).equals("JJ"))
           s1[i]=sent.lemma(j); 
        //else
        //	s1[i]="123";
           j++;i++;
	}
          
}
        return (s1);
	}
}

