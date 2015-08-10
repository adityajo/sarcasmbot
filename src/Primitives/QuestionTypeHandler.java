package Primitives;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;


public class QuestionTypeHandler {
	
	static HashMap<Integer,String> hm_qncode = new HashMap<Integer,String>();
	static HashMap<String, Integer> hm_wordtoqntype = new HashMap<String,Integer>();
	
	public String questionCodeToString(Vector<Integer> codes)
	{
		String op = "";
		for (int i : codes)
			op = op+ " "+hm_qncode.get(i);
		
		return op;
	}
	
	
	public QuestionTypeHandler()
	{
		// http://www.grammarbank.com/question-types.html
		hm_qncode.put(1, "why");
		hm_qncode.put(2, "what");
		hm_qncode.put(3, "where");
		hm_qncode.put(4, "how");
		hm_qncode.put(5, "who");
		hm_qncode.put(6, "when");
		hm_qncode.put(7, "choice");
		
		hm_qncode.put(8,"hypothetical");
		
		hm_qncode.put(9, "rhetorical");
		
		hm_wordtoqntype.put("why",1);
		hm_wordtoqntype.put("reason",1);
		hm_wordtoqntype.put("purpose",1);
		
		
		hm_wordtoqntype.put("what",2);
		
		hm_wordtoqntype.put("where",3);
		
		hm_wordtoqntype.put("how",4);
		hm_wordtoqntype.put("way",4);
		
		hm_wordtoqntype.put("who",5);
		hm_wordtoqntype.put("which",5);
		
		hm_wordtoqntype.put("when",6);
		
		
		hm_wordtoqntype.put("or",7);
		hm_wordtoqntype.put("opinion",7);
		hm_wordtoqntype.put("think",7);
		hm_wordtoqntype.put("how",4);
		hm_wordtoqntype.put("like",7);
		hm_wordtoqntype.put("love",7);
		hm_wordtoqntype.put("if",8);
		hm_wordtoqntype.put("don't",9);
	}
	
	public String normalizeQn(String unTaggedSentence)
	{
		unTaggedSentence = unTaggedSentence.replace("?"," ?");
		unTaggedSentence = unTaggedSentence.replace(","," ,");
		unTaggedSentence = unTaggedSentence.replace("!"," !");
		return unTaggedSentence;
		
	}
	public Vector<Integer> getQnType(String untaggedSentence)
	{
		String word = "";
		untaggedSentence = untaggedSentence.replace("?"," ?");
		
		StringTokenizer st = new StringTokenizer(untaggedSentence.toLowerCase()," ");
		Vector<Integer> vals = new Vector<Integer>();
		
		if (!isAQuestion(untaggedSentence))
		{
			vals.add(-1);
			return vals;
		}
		
		while (st.hasMoreTokens())
		{
			word = st.nextToken();
			
			if ((word.equals("is")||word.equals("was")) && vals.contains(4) )
			{
				vals.add(7);
			}
			if (hm_wordtoqntype.containsKey(word))
				vals.add(hm_wordtoqntype.get(word));
			
		}
		
		if (vals.size() == 0)
			vals.add(2);
		
		
		return vals;
	}
	public boolean isAQuestion(String sentence)
	{
		if (sentence.trim().endsWith("?"))
			return true;
		else
			return false;
	}
	
	public static void main(String[] args)
	{
		QuestionTypeHandler qth = new QuestionTypeHandler();
		System.out.println(qth.getQnType("What is your name?"));
		System.out.println(qth.getQnType("don't you like work?"));
		System.out.println(qth.getQnType("What an idiot!"));
	}
}
