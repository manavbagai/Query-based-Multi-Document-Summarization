package com.manavbagai.summary;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

import edu.stanford.nlp.simple.*;
import org.apache.lucene.store.LockObtainFailedException;


public class SimpleCoreNLP {
    public static void main(String[] args) throws IOException { 
try{    docme();
    	int i=0;
       String ddd= extracted().useDelimiter("\\Z").next();
       String query1=JOptionPane.showInputDialog("Enter the query");
       
       M1 m1=new M1();
       List<Sentence> a1= m1.sentence1(ddd);
      String[][]token1 = m1.lemma1(ddd);  //DOCUMENT STRING FINAL
      for(int i1=0;i1<5000;i1++)
      {
    	  if(token1[i1][0]==null)
    		  break;
      String str1 = Arrays.toString(token1[i1]);               
      //replace starting "[" and ending "]" and ","
      str1 = str1.substring(1, str1.length()-1).replaceAll(",", "");
     //System.out.println(token1[1][4]);
     doci2(str1,i1+1);
    }
      M6 m6=new M6();
      m78 m7=new m78();
      String[]pos1 = m6.pos22(query1);
      String[][] pos2=new String[1000][1000];
    
      query1+=" ";
      while(pos1[i]!=null)
      {
    	if(pos1[i]=="123")
    	{
    		pos2[i][0]="";
    	}
    	else
    	{
      query1+=m7.gen(pos1[i])+" ";
     // int j=0;
    	}
    	i++;
      }
      String str2 = Arrays.toString(pos2);               
      //replace starting "[" and ending "]" and ","
      str2 = str2.substring(1, str2.length()-1).replaceAll(",", "");
System.out.println("string "+query1);
     doci2(query1,0);
      getCosineSimilarity(a1);
}
finally{
    i12emp("i1");
    i12emp("i2");
}
    
    }

	public static void doci2(String str1,int i) {
		try(  PrintWriter out = new PrintWriter("i2/"+ Integer.toString(i)+".txt" )  ){
		    out.println( str1 );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static Scanner extracted() throws FileNotFoundException {
		return new Scanner(new File("i1/mergedFile.txt"));
	}
    
    public static void getCosineSimilarity(List<Sentence>a1) throws LockObtainFailedException, IOException
    {
    	
       Indexer index = new Indexer();
       index.index();
       VectorGenerator vectorGenerator = new VectorGenerator();
       vectorGenerator.GetAllTerms();       
       DocVector[] docVector = vectorGenerator.GetDocumentVectors();// getting document vectors
       Integer ai[]=new Integer[docVector.length];
       Double[] cosineSimilarity=new Double[docVector.length];
       for(int i=0;i<docVector.length;i++)
    	   ai[i]=i;
       for(int i = 1; i < docVector.length; i++)
       {
            cosineSimilarity[i-1] = CosineSimilarity.CosineSimilarity(docVector[0], docVector[i]);
           System.out.println("Cosine Similarity Score between document 0 and "+i+"  = " + cosineSimilarity[i-1]);
       }
      sort111(ai,cosineSimilarity,a1);
    }
    public static void docme(){
    	
    	File folder = new File("articles");
    	File[] files = folder.listFiles();
    	String mergedFilePath = "i1/mergedFile.txt";
    	File mergedFile = new File(mergedFilePath);
		MergerFiles.mergeFiles(files, mergedFile);
    }
    public static void i12emp(String str){
    	File file = new File(str);      
        String[] myFiles;    
            if(file.isDirectory()){
                myFiles = file.list();
                for (int i=0; i<myFiles.length; i++) {
                    File myFile = new File(file, myFiles[i]); 
                    myFile.delete();
                }
             }
            }
   public static void sort111(Integer[] ai, Double[] vec1, List<Sentence> a1)
   {
	   int c,d,n,k;
	   n=ai.length-1;
	   double swap;
	   for (c = 0; c < ( n - 1 ); c++) {
		      for (d = 0; d < n - c - 1; d++) {
		        if (vec1[d] < vec1[d+1]) /* For descending order use < */
		        {
		          swap       = vec1[d];
		          vec1[d]   = vec1[d+1];
		          vec1[d+1] = swap;
		          k = ai[d];
		          ai[d] = ai[d+1];
		          ai[d+1]=k;
		        }
		      }
		    }
	   k= (int) (n*0.1);
	   String final1="";
	   for(int i=0;i<=k;i++)
	   {	  if(vec1[i]>0.0)
	   final1+=a1.get(ai[i])+" ";
	   }
	   
	   
	   JOptionPane.showMessageDialog(null,"<html><body><p style='width: 600px;'>"+final1+"</p></body></html>","Summary",JOptionPane.INFORMATION_MESSAGE);
	   
   }
    
    
}


    


