package Main;

import java.util.Vector;

import Primitives.Sentence;
import SentimentPrimitives.KnowledgeDictionary;

public class HyperboleSarcasm {

	
	public static String generateHyperboleSarcasm(Sentence input, KnowledgeDictionary kd)
	{
		Vector<String> entities = input.getEntities();
		
		int trials = 0;
			
		if (entities.size() == 0)
			return "The best everything ever in the history of humankind!";
		int i;
		do{
			i= (int)(Math.random()*entities.size()); 
			trials++;
		}while(entities.get(i).equals("opinion") && trials<20);
		
		int number = input.getNumberOfEntities().get(i).equals("Plu")?2:1;
		String result = "";
		
		if (number == 1)
		{
			result = "That was the ";
		}
		else
			result = "Those were the ";
		if (trials<20)
			return result+" best "+entities.get(i)+" in the history of humankind!";
		else 
			return result+ " best everything ever in the history of humankind!";
	}
}
