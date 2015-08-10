package SentencePredictor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Calculates sentiment of a tweet. one on each line
 */
public class SentimentFile {

	public static void main(String[] args) throws IOException
	{
		SentimentSentence ss = new SentimentSentence("");
		
		int count = 0,total=0;
		ss.sw.hm_filepath = args[0];
		String filename = args[1];
		ss = new SentimentSentence("");
		BufferedReader s = new BufferedReader(new FileReader(new File(filename)));
		String str = "";
		while((str = s.readLine())!=null)
		{
			total++;
			if(ss.getSentimentOfSentence(str, true, true, true)>0)
				count++;
			
		}
		
		System.out.println(filename+" positive predicted: "+count+" out of "+total);
	}
}
