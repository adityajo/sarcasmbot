package Primitives;

import java.util.StringTokenizer;
import java.util.Vector;

import SentimentPrimitives.KnowledgeDictionary;

public class NounPhraseHandler {

	Vector<String> entities;
	Vector<String> named_entities;
	Vector<String> number_entities;
	Vector<String> gender_entities;
	Vector<String> pronouns;
	Vector<String> pronoun_list;
	
	public void loadPronouns()
	{
		pronoun_list = new Vector<String>();
		pronoun_list.add("anybody");
		pronoun_list.add("anyone");
		pronoun_list.add("anything");
		pronoun_list.add("everybody");
		pronoun_list.add("everyone");
		pronoun_list.add("everything");
		pronoun_list.add("he");
		pronoun_list.add("her");
		pronoun_list.add("him");
		pronoun_list.add("himself");
		pronoun_list.add("his");
		pronoun_list.add("i");
		pronoun_list.add("it");
		pronoun_list.add("itself");
		pronoun_list.add("me");
		pronoun_list.add("mine");
		pronoun_list.add("my");
		pronoun_list.add("myself");
		pronoun_list.add("nobody");
		pronoun_list.add("oneself");
		pronoun_list.add("other");
		pronoun_list.add("others");
		pronoun_list.add("our");
		pronoun_list.add("ours");
		pronoun_list.add("she");
		pronoun_list.add("somebody");
		pronoun_list.add("someone");
		pronoun_list.add("something");
		pronoun_list.add("somewhere");
		pronoun_list.add("them");
		pronoun_list.add("they");
		pronoun_list.add("this");
		pronoun_list.add("those");
		pronoun_list.add("us");
		pronoun_list.add("we");
		pronoun_list.add("whatever");
		pronoun_list.add("you");
	}
	public void getPronouns(String taggedSentence)
	{
		pronouns = new Vector<String>();
		loadPronouns();
			
		String curr_token, word, tag;
		StringTokenizer st = new StringTokenizer(taggedSentence," ");
			
		String candidate = "", named_candidate = "";
		String tagCandidate = "";
		while (st.hasMoreTokens())
		{
			curr_token = st.nextToken();
			word  = curr_token.substring(0, curr_token.lastIndexOf("_"));;
			tag = curr_token.substring(curr_token.lastIndexOf("_")+1);
			
			if (tag.equals("PRP"))
			{
				if(pronoun_list.contains(word.toLowerCase()))
						pronouns.add(word);
			}
			
		}
		
		
		
	}
	public void getEntities(String taggedSentence)
	{
		entities = new Vector<String> ();
		named_entities = new Vector<String> ();
		number_entities = new Vector<String>();
		gender_entities = new Vector<String>();
		
		
		String curr_token, word, tag;
		StringTokenizer st = new StringTokenizer(taggedSentence," ");
		
		
		String candidate = "", named_candidate = "";
		String tagCandidate = "";
		while (st.hasMoreTokens())
		{
			curr_token = st.nextToken();
			word  = curr_token.substring(0, curr_token.lastIndexOf("_"));;
			tag = curr_token.substring(curr_token.lastIndexOf("_")+1);
			
			if (tag.startsWith("N"))
			{
				if (tag.contains("P"))
					named_candidate += word+" ";
				else
				{
					candidate += word+" ";
					tagCandidate += tag+ " ";
				}
				
			}
			
			else if (!tag.startsWith("N") && (!candidate.equals("") || !named_candidate.equals("")))
			{
				candidate = candidate.trim();
				if (!named_candidate.equals(""))
					named_entities.add(named_candidate);
				else
				{
					if (tagCandidate.trim().endsWith("S"))
						number_entities.add("Plu");
					else
						number_entities.add("Si");
					entities.add(candidate);
				}
				
				tagCandidate = "";
				candidate = "";
				named_candidate = "";
			}
			
		}
		
		
	}
	
	
	
	public static void main(String[] args)
	{
	
	}
}
