package com.manavbagai.summary;
import java.util.Arrays;

import rita.*;
public class m78 {
	public String gen(String s)
	{
    RiWordNet rs = new RiWordNet("C:\\WordNet-3.0");
  
  
  
   String sy[]=rs.getSynset(s,"n");
String sj[]=rs.	getSynset(s,"a");
   String str1 = Arrays.toString(sy);  
   
   String str2= Arrays.toString(sj); 
   //replace starting "[" and ending "]" and ","
   str1 = str1.substring(1, str1.length()-1).replaceAll(",", "");
   str2 = str2.substring(1, str2.length()-1).replaceAll(",", "");
   str1+=" "+str2;
   return str1;
}
}
