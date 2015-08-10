package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.stanford.nlp.ling.tokensregex.SequenceMatchRules.StringPatternExtractRule;

import Primitives.AbusiveLanguageHandler;
import Primitives.Sentence;
import SentimentPrimitives.KnowledgeDictionary;

public class sarcasticChatter {

	static Sentence s;
	static KnowledgeDictionary rd;
	FlipSarcasm fs;
	HyperboleSarcasm hs;
	AbusiveLanguageHandler alh;
	
	public sarcasticChatter(String postagger,String sentiwordlist)
	{
		s = new Sentence(postagger);
		rd = new KnowledgeDictionary();
		hs = new HyperboleSarcasm();
		alh = new AbusiveLanguageHandler();
		fs = new FlipSarcasm(sentiwordlist);
	}
	public String chat(String input)
	{
		String output = "";
		
		
		s.loadSentence(input);

		output = alh.getReplyIfSwearWordsHaveBeenUsed(s,  rd);
		
		if (!output.equals(""))
			return output;
		
		
		if (!s.isQuestion())
		{
			int sentiment = fs.ss.getSentimentOfSentence(input, true,  true,  false);
			 if(sentiment == 0)
			 {
				output = "Chatbot: "+rd.getRandomRudeness();
			 	return output;
			 }
			 else 
			 {
				 int i= (int)(Math.random()*10); 
				 if (sentiment < 0)
				 {
					 String positivethings[] = {"Aww!! That's so adorable!", "Awesome!",
							 "You owe me a drink for that awesome piece of news!",
							 "Brilliant!", "Let's party!", "That deserves an applause." };
					 output = positivethings[(int)i%positivethings.length];
				 }
				 else
				 {
					 String negativethings[] = {"I am so sorry for you!", "Oh you poor thing!",
							 "I'd feel terrible if I were you!", "You are such a simple person!"};
					 output = negativethings[(int)i%negativethings.length];
				 }
			 }
		}
		else if (s.isEnquiryQuestion() )
		{
			
			
			if ((s.getEntities().size() + s.getNamedEntities().size()) < 2)
				output = fs.doYouSarcasm(s, rd);
			else 
				output = "Chatbot: "+ hs.generateHyperboleSarcasm(s, rd);
		
				
		}
			
		else if (s.isChoiceQuestion())
		{
			int i= (int)(Math.random()*10); 
			
			if (i%3==0)
				output = "Chatbot: "+ fs.getMinusPlusExpression(s, rd);
			else if (i%3==1) 
				output = "Chatbot: "+ hs.generateHyperboleSarcasm(s, rd);
			else
				output = "Chatbot: "+ fs.getFlippedSimilies(s, rd);
		}
		else
		{
			if ((s.getEntities().size() + s.getNamedEntities().size()) > 0)
			//	output = fs.doYouSarcasm(s, rd);
				output = fs.whoWhatQuestions(s,rd);
		}
		
		if (output.equals(""))
			output = "Chatbot: "+rd.getRandomUnaware();
			
		return output;
	}
	
	public void chatByChunk(String chunk)
	{
		String[] lines = chunk.split("\n");
		
		for(int i = 0 ; i < lines.length; i++)
		{
			System.out.println("You said:"+lines[i]);
			System.out.println("SARCO-SANCT said:"+this.chat(lines[i]));
		}
	}
	
	public void loopChat()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String userName = "";
		
		   while(!userName.toLowerCase().equals("q"))
		   {
		   try {
		  
	    	  System.out.print("Your message ('q' to exit):");
	         userName = br.readLine();
	         System.out.println(this.chat(userName));
	      } catch (IOException ioe) {
	         System.out.println("IO error trying to read your name!");
	         System.exit(1);
	      }
		   }
	}
	public static void main(String[] args)
	{
		String chunk = "";
		//Hello, how are you?\nWhat is the formula for resistance?\nWhy did the elephant die?\nWho understands the world?\nAre you mad at me?\nIs sarcasm a difficult skill?\nDo you like sushi?\nWould you like to have some sushi?\nWho wrote 'The Three Musketeers'?\nWhy did the President resign?\nWhat is your opinion about the immigration reforms introduced in the Capitol this morning?\nDid you watch the reality show on NCC news last night?\nWho created you? Was he any good?\nI won the lottery!\nMy pet died last night.\nI am feeling very low.\nWhy are you so dumb?\nWho will take over the world in 2015?\nWhich country won the World Cup in 2009?\nWhy does sarcasm evoke laughter?\nWhen was the Battle of Plassey fought?\nWhere is Afghanistan?\nWhat do you think of my new dress?\nWho kille\nYou suck!\nThis sarcasm chat bot is pretty neat!\nThis sarcasm chat bot is almost horrible!\nClean out my trash for me.\nCan you clean out my trash for me, please?\nWhere is the nearest restaurant?\nYou have not helped me even a tiny bit.";
		
		if (args.length!=2)
		{
			System.out.println("Input : args[0]: postagger model file, args[1]: sentiment wordlist");
			return;
		}
		String postagger = args[0];
		String sentiwordlist = args[1];
		sarcasticChatter sc = new sarcasticChatter(postagger, sentiwordlist);
	/*	System.out.println(sc.chat("My name is Aditya."));
		System.out.println(sc.chat("What is the capital of India?"));
		System.out.println(sc.chat("What is your opinion about movies by Shahrukh Khan?"));
		System.out.println(sc.chat("What is your opinion about Amisha Patel?"));
		System.out.println(sc.chat("Do you love chocolates?"));
		System.out.println(sc.chat("What do you think of Rajan's chocolates?"));
		
		System.out.println(sc.chat("Will you marry me?"));
		System.out.println(sc.chat("Did you like Barack Obama's immigration reforms introduced in the Capitol this morning?"));
		System.out.println(sc.chat("Stop being such a bitch"));		
		System.out.println(sc.chat("When did India get freedom?"));
	*/	
		sc.loopChat();
	 sc.chatByChunk(chunk);
	      //  read the username from the command-line; need to use try/catch with the
	      //  readLine() method

	}
}
