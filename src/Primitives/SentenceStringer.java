package Primitives;

import java.util.StringTokenizer;
import java.util.Vector;

public class SentenceStringer {

	public String getTaggedWordsThatMatch(String taggedSentence, String keyword)
	{
		StringTokenizer st = new StringTokenizer(taggedSentence.toLowerCase()," ");
	
	String words="";
	
		while (st.hasMoreTokens())
		{
			String curr_word = st.nextToken();
		
			if(curr_word.startsWith(keyword+"_"))
				words+=curr_word+" ";
		}
	return words.trim();
		
	}
	
	public String getOnlyWordSequence(String taggedSentence)
	{
		
		taggedSentence = taggedSentence.trim();
		String onlyWordSequence = "";
		String curr_word = "", word="";
		taggedSentence = taggedSentence.replace("?"," ?");
		
		StringTokenizer st = new StringTokenizer(taggedSentence.toLowerCase()," ");
	
				
		while (st.hasMoreTokens())
		{
			curr_word = st.nextToken();
			if (curr_word.contains("_"))
				word = curr_word.substring(0, curr_word.lastIndexOf("_"));
			else
				word = curr_word;
			
			
			onlyWordSequence = onlyWordSequence+ word+" ";
			
		}
		
		onlyWordSequence = onlyWordSequence.trim();
		
		return onlyWordSequence;
	
	}
	
	public String getOnlyTagSequence(String taggedSentence)
	{
		taggedSentence = taggedSentence.trim();
		String onlyWordSequence = "";
		String curr_word = "", tag ="";
		taggedSentence = taggedSentence.replace("?"," ?");
		
		StringTokenizer st = new StringTokenizer(taggedSentence.toUpperCase()," ");
	
				
		while (st.hasMoreTokens())
		{
			curr_word = st.nextToken();
			if (curr_word.contains("_"))
				tag = curr_word.substring(curr_word.lastIndexOf("_")+1);
			else
				tag = "";
			
			
			onlyWordSequence = onlyWordSequence+ tag+" ";
			
		}
		
		onlyWordSequence = onlyWordSequence.trim();
		
		return onlyWordSequence;
	
	}
	
	public static void main(String args[])
	{
		SentenceStringer ss = new SentenceStringer();
		String taggedSentence = "I_PRP am_VBP a_DT boy_NN ";
		System.out.println(ss.getOnlyTagSequence(taggedSentence));
		System.out.println(ss.getOnlyWordSequence(taggedSentence));
		
		taggedSentence = "I am a girl ";
		System.out.println(ss.getOnlyTagSequence(taggedSentence));
		System.out.println(ss.getOnlyWordSequence(taggedSentence));
	}
}
