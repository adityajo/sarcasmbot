package SentimentPrimitives;

import java.util.HashMap;
import java.util.Vector;

public class KnowledgeDictionary {
	public static Vector<String> general_positives;
	public static Vector<String> general_negatives;
	public static Vector<String> celebs_positives;
	public static Vector<String> celebs_negatives;
	public static Vector<String> celebproperties_positives;
	public static Vector<String> celebproperties_negatives;
	public static Vector<String> positive_VP;
	public static Vector<String> negative_VP;
	public static Vector<String> positive_situations;
	public static Vector<String> negative_situations;
	public static Vector<String> intensifier_adverbs;
	public static Vector<String> similies;
	public static Vector<String> swear_words;
	public static Vector<String> respond_to_swear_words;
	public static Vector<String> doYou_Negative;
	public static Vector<String> fillers;
	public static Vector<String> i_dont_know;
	public static HashMap<String, String> pronoun_question_response;
	public KnowledgeDictionary()
	{
		pronoun_question_response = new HashMap<String,String>();
		i_dont_know = new Vector<String>();
		general_positives = new Vector<String>();
		general_negatives = new Vector<String>();
		celebproperties_positives = new Vector<String>();
		celebproperties_negatives = new Vector<String>();
		positive_situations = new Vector<String>();
		negative_situations = new Vector<String>();
		doYou_Negative  = new Vector<String>();
		fillers = new Vector<String>();
		similies = new Vector<String>();
		positive_VP = new Vector<String>();
		negative_VP = new Vector<String>();
		intensifier_adverbs = new Vector<String>();
		swear_words = new Vector<String>();
		respond_to_swear_words = new Vector<String>();
		
		general_positives.add("How exciting!");
		general_positives.add("That is a very useful piece of information!");
		general_positives.add("Yay!");
		general_positives.add("Wow!");
		
		general_negatives.add("Yawn!");
		general_negatives.add("*rolls eyes*");
		general_negatives.add("LMAO");
		
		celebs_positives = new Vector<String>();
		celebs_negatives = new Vector<String>();
		
		celebs_positives.add("Amitabh Bachhan");
		celebs_positives.add("Shahrukh Khan");
		celebs_positives.add("Madhuri Dixit");
		celebs_positives.add("Barack Obama");
		celebs_positives.add("Aishwarya Rai");
				
		celebs_negatives.add("Justin Bieber");
		celebs_negatives.add("Rakhi Sawant");
		celebs_negatives.add("Kamaal R Khan");
		
		
		celebproperties_positives.add("talent");
		celebproperties_positives.add("looks");
		celebproperties_positives.add("everything");
		
		celebproperties_negatives.add("arrogance");
		celebproperties_negatives.add("rudeness");
		celebproperties_negatives.add("more problems");
		celebproperties_negatives.add("just luck");
		
		
		positive_VP.add("SMLR I RB love");
		positive_VP.add("SMLR I RB would be thankful");
		positive_VP.add("SMLR I RB enjoy");
		positive_VP.add("SMLR I RB appreciate");
		positive_VP.add("SMLR I RB adore");
		
		similies.add("Just the way");
		similies.add("Like");
		similies.add("The way");
		similies.add("It's like how");
		similies.add("as much as");
		fillers.add("Hmm..");
		fillers.add("Oh well..");
		fillers.add("Well..");
		fillers.add("Uhmm...");
		
		fillers.add("Let's put it this way... ");
		fillers.add("");
		
		intensifier_adverbs.add("thoroughly");
		intensifier_adverbs.add("totally");
		intensifier_adverbs.add("completely");
		intensifier_adverbs.add("absolutely");
				
		negative_VP.add("SMLR I RB hate");
		negative_VP.add("SMLR I RB despise");
		negative_VP.add("SMLR I RB would curse someone for");
		negative_VP.add("SMLR I RB dislike");

		negative_situations.add("staying awake till 4am.");
		negative_situations.add("visiting the dentist thrice a week.");
		negative_situations.add("bad coffee.");
		negative_situations.add("having a persistent head ache all week.");
		negative_situations.add("having the tyres of my car punctured.");
		negative_situations.add("college on a Friday. "); 
		 negative_situations.add("Bus over 20 minutes late"); 
		 negative_situations.add("that my stupid hair refuses to stay straight after a 30 min walk."); 
		 negative_situations.add("when my brain thinks it's acceptable to be most active at 3am"); 
		 negative_situations.add("figuring out how to make an infinity scarf"); 
		 negative_situations.add("sweating out a fever with a small fleece blanket"); 
		 negative_situations.add("when you show up for rehearsal and somebody's disassembled the drum kit and spread it all over the stage"); 
		 negative_situations.add("that moment when you've been waiting for @americanairlnes to call, yet you accidentally hang up on them because you were texting."); 
		 negative_situations.add("you trying to sleep when you are angry "); 
		 negative_situations.add("being unable to load the content from YouTube"); 
		 negative_situations.add("sitting at home typing a paper on my break"); 
		 negative_situations.add("when your favourite actor comes on the radio and your mom changes it"); 
		 negative_situations.add("being in a work situation where you have to go around your elbow to get to your thumb, but the elbow doesn't return emails?"); 
		 negative_situations.add("not realising football was on tonight #Grr got to find something to do"); 
		 negative_situations.add("queuing"); 
		 negative_situations.add("when I don't want to talk to anyone days"); 
		 negative_situations.add("when they keep on putting on broadway shows/commercials."); 
		 negative_situations.add("My Outlook being down"); 
		 negative_situations.add("bad printer at work having my life today"); 
		 negative_situations.add("where you're all done at the gym, showered, then get on the tube and start sweating?"); 
		 negative_situations.add("when you arrive in a new city to find you left laptop at work & you were accidentally booked in your hotel for tomorrow night"); 
		 negative_situations.add("being Half way done with one project"); 
		 negative_situations.add("when I poured a glass of milk to take my meds with, walked away for three seconds, come back and my Dad drank it just to be an ass."); 
		 negative_situations.add("when crushes are dumb and don't understand how you feel."); 
		 negative_situations.add("realizing that none of my fav shows will be on tonight"); 
		 negative_situations.add("phone calls to small talk"); 
		 negative_situations.add("when websites don't accept credit card numbers entered with spaces?"); 
		 negative_situations.add("trying to get hold of a recruiter who isn't local, and who just won't give you a reply to your emails."); 
		 negative_situations.add("coming home to no parking on the block"); 
		 negative_situations.add("cannot seem to locate my favourite scarf"); 
		 negative_situations.add("when my face gets flakey"); 
		 negative_situations.add("the time of year when everybody is grumpy"); 
		 negative_situations.add("having dreams about being abducted"); 
		 negative_situations.add("waking up by punching myself in the face."); 
		 negative_situations.add("getting angry"); 
		 negative_situations.add("getting sick"); 
		 negative_situations.add("when people retweet bunch of SPAM."); 
		 negative_situations.add("having to rewrite a whole heap of CSS for a website."); 
		 negative_situations.add("trying to read, and they turn off the lights!"); 
		 negative_situations.add("calling and hanging up on me prank is great I would have loved this WHEN I WAS TEN"); 
		 negative_situations.add("if you drive for 20 miles on my tail with your brights on"); 
		 negative_situations.add("when a bunch of lads just sit around on the weight machines on their phones/gossiping! "); 
		 negative_situations.add("Zero accountability people"); 
		 negative_situations.add("when so many people lack human decency!!!!"); 
		 negative_situations.add("how holidays make work grind to a halt long before the day actually arrives");
		
		
		
		positive_situations.add("walking on a beautiful beach.");
		
		doYou_Negative.add("if PR was 5");
		doYou_Negative.add("if PR felt stupid");
		doYou_Negative.add("if PR was drunk");
		doYou_Negative.add("if PR had poor taste");
		doYou_Negative.add("only on most stupid days.");
		doYou_Negative.add("only in drunken stupor.");
		
		/* From LIWC */
		 swear_words.add("arse"); 
		 swear_words.add("arsehole"); 
		 swear_words.add("arses"); 
		 swear_words.add("ass"); 
		 swear_words.add("asses"); 
		 swear_words.add("asshole"); 
		 swear_words.add("bastard"); 
		 swear_words.add("bitch"); 
		 swear_words.add("bloody"); 
		 swear_words.add("boob"); 
		 swear_words.add("butt"); 
		 swear_words.add("butts"); 
		 swear_words.add("cock"); 
		 swear_words.add("cocks"); 
		 swear_words.add("crap"); 
		 swear_words.add("crappy"); 
		 swear_words.add("cunt"); 
		 swear_words.add("damn"); 
		 swear_words.add("dang"); 
		 swear_words.add("darn"); 
		 swear_words.add("dick"); 
		 swear_words.add("dicks"); 
		 swear_words.add("dumb"); 
		 swear_words.add("dyke"); 
		 swear_words.add("fuck"); 
		 swear_words.add("fucked"); 
		 swear_words.add("fucker"); 
		 swear_words.add("fuckin"); 
		 swear_words.add("fucks"); 
		 swear_words.add("goddam"); 
		 swear_words.add("heck"); 
		 swear_words.add("hell"); 
		 swear_words.add("homo"); 
		 swear_words.add("jeez"); 
		 swear_words.add("mofo"); 
		 swear_words.add("motherf"); 
		 swear_words.add("nigger"); 
		 swear_words.add("piss"); 
		 swear_words.add("prick"); 
		 swear_words.add("pussy"); 
		 swear_words.add("queer"); 
		 swear_words.add("screw"); 
		 swear_words.add("shit"); 
		 swear_words.add("sob"); 
		 swear_words.add("sonofa"); 
		 swear_words.add("suck"); 
		 swear_words.add("sucked"); 
		 swear_words.add("sucks"); 
		 swear_words.add("tit"); 
		 swear_words.add("tits"); 
		 swear_words.add("titties"); 
		 swear_words.add("titty"); 
		 swear_words.add("wanker");
		 
		 i_dont_know.add("I am supposed to know that now. Wow, I am the new Google!");
		 i_dont_know.add("I only answer questions sarcastically. Come on, say something stupid so that I can hit back at you!");
		 i_dont_know.add("My looks are deceptive. I am not as smart as I look.");
		 i_dont_know.add("Great question! You should have paid attention to stuff in school!");
		 i_dont_know.add("You just asked me that! You love using newspapers as gift wraps, don't you?!");
		 
		 
		 respond_to_swear_words.add("Wow, you said 'SWR', didn't you? Your mom will be really proud of you!");
		 respond_to_swear_words.add("Unbelievable that you just said 'SWR'! You are really very classy!");
		
		 
		 pronoun_question_response.put("anybody","anybody");
		 pronoun_question_response.put("anyone","anyone");
		 pronoun_question_response.put("anything","anything");
		 pronoun_question_response.put("everybody","everybody");
		 pronoun_question_response.put("everyone","everyone");
		 pronoun_question_response.put("everything","everything");
		 pronoun_question_response.put("her","her");
		 pronoun_question_response.put("he","he");
		 pronoun_question_response.put("him","him");
		 pronoun_question_response.put("himself","himself");
		 pronoun_question_response.put("his","his");
		 pronoun_question_response.put("i","you");
		 pronoun_question_response.put("it","it");
		 pronoun_question_response.put("itself","itself");
		 pronoun_question_response.put("me","you");
		 pronoun_question_response.put("mine","mine");
		 pronoun_question_response.put("my","your");
		 pronoun_question_response.put("myself","yourself");
		 pronoun_question_response.put("nobody","nobody");
		 pronoun_question_response.put("oneself","oneself");
		 pronoun_question_response.put("other","other");
		 pronoun_question_response.put("others","others");
		 pronoun_question_response.put("our","our");
		 pronoun_question_response.put("ours","ours");
		 pronoun_question_response.put("she","she");
		 pronoun_question_response.put("somebody","somebody");
		 pronoun_question_response.put("someone","someone");
		 pronoun_question_response.put("something","something");
		 pronoun_question_response.put("somewhere","somewhere");
		 pronoun_question_response.put("them","them");
		 pronoun_question_response.put("they","they");
		 pronoun_question_response.put("this","this");
		 pronoun_question_response.put("those","those");
		 pronoun_question_response.put("us","us");
		 pronoun_question_response.put("we","we");
		 pronoun_question_response.put("whatever","whatever");
		 pronoun_question_response.put("you","I");
	}
	
	public String getRandomUnaware()
	{
		String response = "";
		int i = (int)(Math.random()*i_dont_know.size()); 
		
		response = response+i_dont_know.get(i);
		
		return response;
		
	}
	public String getRandomRudeness()
	{
		String response = "";
		int i = (int)(Math.random()*general_positives.size()); 
		
		response = response+general_positives.get(i);
		
		i = (int)(Math.random()*general_negatives.size());
		response = response+" "+general_negatives.get(i);
		
		return response;
	}
}
