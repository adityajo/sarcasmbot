package SentencePredictor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SentimentWord {

	public static HashMap<String, Integer> hm_sentiwordlist; // Wordlist containing sentiment words: +1, -1 
	public static String hm_filepath ="";
	
	public SentimentWord()
	{
		if (hm_filepath.equals(""))
		{
			System.err.println("No sentiment word list attached.");
			return;
		}
		
		if (this.hm_sentiwordlist != null && this.hm_sentiwordlist.size() > 0)
			return;
		
		HashMap<String, Integer> hm_senti = new HashMap<String, Integer>();
		try {
			
			
			BufferedReader br = new BufferedReader(new FileReader(new File(hm_filepath)));
	         String str="";
	                  
			while ((str = br.readLine())!=null)
			{
				
				
				StringTokenizer st = new StringTokenizer(str," ");
				int num_of_tokens = st.countTokens();
				
				if (num_of_tokens >= 2)
				{
					String word = st.nextToken();
					String next = st.nextToken();
					
					
					int polarity = -1;
					if(!next.equals("-") && isNumeric(next))
						polarity = Integer.parseInt(next);
					
					hm_senti.put(word,polarity);
				}
			}
			
			this.hm_sentiwordlist = hm_senti;
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
		
		System.out.println("Completed loading " + this.hm_sentiwordlist.size() + " words in sentiment word list.");
		
	}
	
	public int getSentimentOfWord(String word)
	{
		int val = 0;
		if (this.hm_sentiwordlist!=null && this.hm_sentiwordlist.containsKey(word))
			val = this.hm_sentiwordlist.get(word);
		return val;
		
	}
	
	public static void loadParameters(String[] args)
	{
		for (String arg: args) {
			String[] s = arg.split("=");
			String param = s[0];
			String val = s[1];

			if (param.equals("sentilist")) hm_filepath = val; 
		}
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	public static void main(String[] args)
	{
		
		loadParameters(args);
		SentimentWord sw = new SentimentWord();
		
		System.out.println("Sentiment of happy = "+sw.getSentimentOfWord("happy"));
		System.out.println("Sentiment of sad = " + sw.getSentimentOfWord("sad"));
		
		
	}
}
