package Main;

import java.util.StringTokenizer;
import java.util.Vector;

import Primitives.Sentence;
import SentimentPrimitives.KnowledgeDictionary;
import SentencePredictor.*;

public class FlipSarcasm {
	static SentimentSentence ss;

	public String pickVerb(Sentence input,KnowledgeDictionary kd)
	{
		String verb = "";
		String tagSequence = input.getTagSequence();
		StringTokenizer st = new StringTokenizer(tagSequence," ");
		
		if (!tagSequence.contains("V"))
			return kd.getRandomRudeness();
		String[] array = input.getwords().split("\\s");
		int i = (int)(Math.random()*kd.fillers.size());
		
		String filler = kd.fillers.get(i);
		int verbPos = 0;
		while(st.hasMoreTokens())
		{
			String curr_word = st.nextToken();
			
			if(curr_word.startsWith("V") && !array[verbPos].toLowerCase().equals("do") && !array[verbPos].toLowerCase().equals("did")
					&& !array[verbPos].toLowerCase().equals("can")&& !array[verbPos].toLowerCase().equals("could")&& !array[verbPos].toLowerCase().equals("must")
					&& !array[verbPos].toLowerCase().equals("should")&& !array[verbPos].toLowerCase().equals("will")&& !array[verbPos].toLowerCase().equals("would"))
				break;
			verbPos++;
		}
		
		if (verbPos >= array.length)
			return "";
		verb = array[verbPos];
		return verb;
	}
	
	public FlipSarcasm (String sentiwordlist)
	{
		ss = new SentimentSentence(sentiwordlist);
	}
	
	public String whoWhatQuestions(Sentence input, KnowledgeDictionary kd)
	{
		String output = "";
		String randomstuff[] = {"wanted to play the piano", "was getting bored on a Sunday morning", " was in a mood for adventure",
				"was high"};
		

		int i = (int)(Math.random()*input.getNamedEntities().size());
		int j = (int)(Math.random()*randomstuff.length);
		
		if (input.getQuestionType().contains(5))
		{
			String tense = input.getTenseCode();
			String verb = "";
			if (tense.equals("Present")) verb = "do";
			else if (tense.equals("3Present")) verb = "do";
			else if (tense.equals("Modal")) verb = "am";
			else if (tense.equals("Past")) verb = "did";
			else if (tense.equals("non3Present")) verb = "am";
			
			
			output = "I "+ verb+". Hi!";
		}
		else if (input.getQuestionType().contains(1) && input.getNamedEntities().size()>0)
			output = "Because "+input.getNamedEntities().elementAt(i)+" "+randomstuff[j];
		
		return output;
		
	}
	
	public String doYouSarcasm(Sentence input, KnowledgeDictionary kd)
	{
		// Do you eat chocolate? --> I used to eat chocolate when I was 10.
		// Do you like Shahrukh Khan? --> I used to like Shahrukh Khan when I was feeling stupid.
		String firstWord;
		String result;
		String tagSequence = input.getTagSequence();
		StringTokenizer st = new StringTokenizer(tagSequence," ");
		
		if (!tagSequence.contains("V"))
			return kd.getRandomRudeness();
		String[] array = input.getwords().split("\\s");
		int i = (int)(Math.random()*kd.fillers.size());
		
		String filler = kd.fillers.get(i);
		int verbPos = 0;
		while(st.hasMoreTokens())
		{
			String curr_word = st.nextToken();
			
			if(curr_word.startsWith("V") && !array[verbPos].toLowerCase().equals("do") && !array[verbPos].toLowerCase().equals("did")
					&& !array[verbPos].toLowerCase().equals("can")&& !array[verbPos].toLowerCase().equals("could")&& !array[verbPos].toLowerCase().equals("must")
					&& !array[verbPos].toLowerCase().equals("aint")
&& !array[verbPos].toLowerCase().equals("ain't")
&& !array[verbPos].toLowerCase().equals("am")
&& !array[verbPos].toLowerCase().equals("are")
&& !array[verbPos].toLowerCase().equals("arent")
&& !array[verbPos].toLowerCase().equals("aren't")
&& !array[verbPos].toLowerCase().equals("be")
&& !array[verbPos].toLowerCase().equals("became")
&& !array[verbPos].toLowerCase().equals("become")
&& !array[verbPos].toLowerCase().equals("becomes")
&& !array[verbPos].toLowerCase().equals("becoming")
&& !array[verbPos].toLowerCase().equals("been")
&& !array[verbPos].toLowerCase().equals("being")
&& !array[verbPos].toLowerCase().equals("can")
&& !array[verbPos].toLowerCase().equals("cannot")
&& !array[verbPos].toLowerCase().equals("cant")
&& !array[verbPos].toLowerCase().equals("can't")
&& !array[verbPos].toLowerCase().equals("could")
&& !array[verbPos].toLowerCase().equals("couldnt")
&& !array[verbPos].toLowerCase().equals("couldn't")
&& !array[verbPos].toLowerCase().equals("couldve")
&& !array[verbPos].toLowerCase().equals("could've")
&& !array[verbPos].toLowerCase().equals("did")
&& !array[verbPos].toLowerCase().equals("didnt")
&& !array[verbPos].toLowerCase().equals("didn't")
&& !array[verbPos].toLowerCase().equals("do")
&& !array[verbPos].toLowerCase().equals("does")
&& !array[verbPos].toLowerCase().equals("doesnt")
&& !array[verbPos].toLowerCase().equals("doesn't")
&& !array[verbPos].toLowerCase().equals("doing")
&& !array[verbPos].toLowerCase().equals("done")
&& !array[verbPos].toLowerCase().equals("dont")
&& !array[verbPos].toLowerCase().equals("don't")
&& !array[verbPos].toLowerCase().equals("had")
&& !array[verbPos].toLowerCase().equals("hadnt")
&& !array[verbPos].toLowerCase().equals("hadn't")
&& !array[verbPos].toLowerCase().equals("has")
&& !array[verbPos].toLowerCase().equals("hasnt")
&& !array[verbPos].toLowerCase().equals("hasn't")
&& !array[verbPos].toLowerCase().equals("have")
&& !array[verbPos].toLowerCase().equals("havent")
&& !array[verbPos].toLowerCase().equals("haven't")
&& !array[verbPos].toLowerCase().equals("having")
&& !array[verbPos].toLowerCase().equals("is")
&& !array[verbPos].toLowerCase().equals("isnt")
&& !array[verbPos].toLowerCase().equals("isn't")
&& !array[verbPos].toLowerCase().equals("it'd")
&& !array[verbPos].toLowerCase().equals("itll")
&& !array[verbPos].toLowerCase().equals("it'll")
&& !array[verbPos].toLowerCase().equals("it's")
&& !array[verbPos].toLowerCase().equals("ive")
&& !array[verbPos].toLowerCase().equals("I've")
&& !array[verbPos].toLowerCase().equals("let ")
&& !array[verbPos].toLowerCase().equals("may")
&& !array[verbPos].toLowerCase().equals("might")
&& !array[verbPos].toLowerCase().equals("might've")
&& !array[verbPos].toLowerCase().equals("must")
&& !array[verbPos].toLowerCase().equals("ought")
&& !array[verbPos].toLowerCase().equals("shall")
&& !array[verbPos].toLowerCase().equals("should")
&& !array[verbPos].toLowerCase().equals("shouldn't")
&& !array[verbPos].toLowerCase().equals("should've")
&& !array[verbPos].toLowerCase().equals("that'd")
&& !array[verbPos].toLowerCase().equals("was")
&& !array[verbPos].toLowerCase().equals("wasnt")
&& !array[verbPos].toLowerCase().equals("wasn't")
&& !array[verbPos].toLowerCase().equals("were")
&& !array[verbPos].toLowerCase().equals("weren't")
&& !array[verbPos].toLowerCase().equals("will")
&& !array[verbPos].toLowerCase().equals("wont")
&& !array[verbPos].toLowerCase().equals("won't")
&& !array[verbPos].toLowerCase().equals("would")
&& !array[verbPos].toLowerCase().equals("wouldn't")
&& !array[verbPos].toLowerCase().equals("wouldve")
&& !array[verbPos].toLowerCase().equals("would've")
&& !array[verbPos].toLowerCase().equals("should")&& !array[verbPos].toLowerCase().equals("will")&& !array[verbPos].toLowerCase().equals("would"))
				break;
			verbPos++;
		}
		
		if (verbPos >= array.length)
			return kd.getRandomRudeness();
		String verb = array[verbPos];
		
		Vector<String> pronouns = input.getPronouns();
				String response_pronoun = (pronouns!=null && pronouns.size()>0)?kd.pronoun_question_response.get(pronouns.elementAt(0)):"I";
		result = filler+response_pronoun+" used to "+verb;
		
		if (input.getTenseCode().equals("Modal"))
			result = result.replace("used to","will");
		
		i = (int)(Math.random()*input.getNamedEntities().size());
		int j = (int)(Math.random()*input.getEntities().size());
		String target;
		if ( i >= 0 && input.getNamedEntities().size()>0)
		{	target = input.getNamedEntities().get(i);
			result += " "+target+" ";
		}
		else if (j >= 0 && input.getEntities().size() > 0)
		{	target = input.getEntities().get(j);
			result += " "+target+" ";
		}
		
		
		result = result.trim();
		i = (int)(Math.random()*kd.doYou_Negative.size());
		result+= " "+kd.doYou_Negative.get(i);
		if (input.getTenseCode().equals("Modal"))
		{
			result = result.replace("used to","will");
			result = result.replace("was","feel like");
		}
		result = result.replace("PR",response_pronoun);
		return result;
	}
	
	
	public static String getFlippedSimilies(Sentence input, KnowledgeDictionary kd)
	{
		String output = "";
		
		String result = "" ;
		int i;
		i = (int)(Math.random()*kd.fillers.size());
		
		result = kd.fillers.get(i);
		
		i = ss.getSentimentOfSentence(input.getwords(),true,true,false);
		
		if (i > 0)
		{
			
			i = (int)(Math.random()*kd.positive_VP.size());
			
			String first = kd.positive_VP.get(i);
			
			i = (int)(Math.random()*kd.negative_situations.size());
			
			String second = kd.negative_situations.get(i);
			
			result += first+" "+second;
		}
		else if (i < 0)
		{
			
			i = (int)(Math.random()*kd.negative_VP.size());
			
			String first = kd.negative_VP.get(i);
			
			i = (int)(Math.random()*kd.positive_situations.size());
			
			String second = kd.positive_situations.get(i);
			
			result += first+" "+second;
		}
		else
		{
			i = (int)(Math.random()*input.getNamedEntities().size());
			int j = (int)(Math.random()*input.getEntities().size());
			String target;
			if ( i >= 0 && input.getNamedEntities().size()>0)
			{	target = input.getNamedEntities().get(i);
				result += "I like "+target+". ";
			}
			else if (j >= 0 && input.getEntities().size() > 0)
			{	target = input.getEntities().get(j);
				result += "I like "+target+". ";
			}else
				return kd.getRandomRudeness();
			
			
			i = (int)(Math.random()*kd.positive_VP.size());
			
			String first = kd.positive_VP.get(i);
			
			i = (int)(Math.random()*kd.negative_situations.size());
			
			String second = kd.negative_situations.get(i);
			
			result += first+" "+second;
		}
		
		i = (int)(Math.random()*kd.intensifier_adverbs.size());
		result = result.replace("RB",kd.intensifier_adverbs.get(i));
		
		i = (int)(Math.random()*kd.similies.size());
		result = result.replace("SMLR",kd.similies.get(i));
		
		return result;
	}
	
	
	public static String getMinusPlusExpression(Sentence input, KnowledgeDictionary kd)
	{
		String output = "";
		String result = "";
		int i= (int)(Math.random()*2); 
		
		if (i == 0)
		{
			i = (int)(Math.random()*kd.celebproperties_positives.size());
			
			String first = kd.celebproperties_positives.get(i);
			
			i = (int)(Math.random()*kd.celebs_positives.size());
			
			String second = kd.celebs_positives.get(i);
			
			result = second+" minus "+first;
		}
		else
		{
			i = (int)(Math.random()*kd.celebproperties_negatives.size());
			
			String first = kd.celebproperties_negatives.get(i);
			
			i = (int)(Math.random()*kd.celebs_negatives.size());
			
			String second = kd.celebs_negatives.get(i);
			
			result = second+" plus "+first;
		}

		i = (int)(Math.random()*input.getNamedEntities().size());
		int j = (int)(Math.random()*input.getEntities().size());
		String target = "this";
		
		if ( i >= 0 && input.getNamedEntities().size() > 0)
			target = input.getNamedEntities().get(i);
		else if (j >= 0 && input.getEntities().size() > 0)
			target = input.getEntities().get(j);
		else
			target = "it";
		
		if(input.getQuestionType().contains(5))
		{
			i = (int)(Math.random()*2);
			if (i>=1)
				output += "I am not sure who "+target+" is, but.."; 
		}
		output = "Well I feel that " + target+ " is like "+result;
		return output;
		
	}
}
