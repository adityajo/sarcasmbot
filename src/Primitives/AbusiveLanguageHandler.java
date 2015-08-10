package Primitives;

import java.util.StringTokenizer;

import SentimentPrimitives.KnowledgeDictionary;

public class AbusiveLanguageHandler {

	public boolean isAbusiveWord(String curr_word, KnowledgeDictionary kd)
	{
		for (int i = 0; i < kd.swear_words.size(); i++)
		{ if (curr_word.trim().startsWith(kd.swear_words.get(i)))
			return true;
		}
		return false;
	}
	
	public String containsAbusiveWord(Sentence input, KnowledgeDictionary kd)
	{
		StringTokenizer st = new StringTokenizer(input.getwords()," ");
		
		while(st.hasMoreTokens())
		{
			String curr_word = st.nextToken().toLowerCase();
			if (isAbusiveWord(curr_word, kd))
				return curr_word;
		}
		
		return "";
	}
	
	public String getReplyIfSwearWordsHaveBeenUsed(Sentence input, KnowledgeDictionary kd)
	{
	
		String output = "";
		String abusive_words = "";
		abusive_words = containsAbusiveWord(input, kd);
		
		if (abusive_words.equals(""))
			return "";
		
		else
		{
			int i = (int)(Math.random()*kd.respond_to_swear_words.size());
			output = kd.respond_to_swear_words.get(i);
			output = output.replace("SWR",abusive_words);
		}
			return output;
		
		
	}
}
