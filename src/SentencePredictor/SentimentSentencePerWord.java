package SentencePredictor;

import java.util.HashSet;
import java.util.StringTokenizer;

public class SentimentSentencePerWord {

	public static SentimentWord sw;
	public static HashSet<String> negators;
	public static HashSet<String> intensifiers;


	private HashSet<String> getNegators() {

		HashSet<String> negators = new HashSet<String>();

		String[] listnegators = {"not","no","never","neither","nor"};
		for (String s: listnegators) negators .add(s);

		return negators;

	}


	private HashSet<String> getIntensifiers() {

		HashSet<String> intensifiers = new HashSet<String>();

		String[] fromOpinionFinder = {"absolute","abundant","acute","ample","all-consuming","all-embracing","ardent","big","bottomless","boundless","burning","categorical","certain","clear","close","colossal","complete","consuming","consummate","considerable","damned","decided","deep","definite","definitive","downright","drastic","emphatic","enormous","endless","entire","excessive","extensive","extravagant","extreme","fanatical","fervent","fervid","fierce","firm","forceful","gigantic","great","greatest","grievous","heightened","high","highest","huge","humongous","illimitable","immense","incalculable","incontestable","incontrovertible","indisputable","infinite","inordinate","intense","intensified","intensive","keen","mammoth","marked","maximal","maximum","mighty","more","most","mungo","numerous","out-and-out","outright","perfect","plain","powerful","prodigious","profound","pronounced","pure","real","resounding","severe","sharp","sheer","simple","strict","strong","stupendous","supreme","sure","terrible","thorough","titanic","top","total","towering","tremendous","true","ultimate","unambiguous","unconditional","uncontestable","undeniable","undesputable","unending","unequivocal","unfathomable","unlimited","unmistakable","unqualified","unquestionable","utmost","utter","uttermost","vast","vehement","vigorous","violent","vivid","zealous","absolutely","absurdly","abundantly","acutely","all","altogether","amazingly","amply","ardently","astonishingly","awfully","categorically","certainly","clearly","completely","considerably","dearly","decidedly","deeply","definitely","definitively","downright","drastically","eminently","emphatically","endlessly","entirely","even","exaggeratedly","exceedingly","excessively","explicitly","expressly","extensively","extraordinarily","extravagantly","extremely","fanatically","fervently","fervidly","fiercely","firmly","forcefully","frankly","fully","greatly","highly","hugely","immensely","incredibly","indeed","indispensably","indisuptably","indubitably","infinitely","inordinately","intensely","irretrievably","just","keenly","largely","maximally","mightily","more","most","much","notably","noticeably","outright","outrightly","particularly","perfectly","plainly","positively","powerfully","pressingly","pretty","prodigiously","profoundly","purely","quite","really","remarkably","severely","sharply","simply","strikingly","strongly","stupendously","substantially","super","superlatively","supremely","surely","surpassingly","surprisingly","terribly","thoroughly","too","totally","tremendously","truely","ultimately","unambiguously","uncommonly","unconditionally","unbelievably","undeniably","undisputably","unequivocally","unnaturally","unquestionably","unusually","utterly","vastly","vehemently","vigorously","violently","vividly","very","wholly","wonderfully","zealously"};

		for (String s: fromOpinionFinder) intensifiers.add(s);

		return intensifiers;

	}
	private static boolean isNegator(String word)
	{
		return (negators.contains(word));
		
		
	}
	private static boolean isIntensifier(String word)
	{
		return (intensifiers.contains(word));
		
		
	}
	public String getSentimentOfSentence(String sentence, boolean stem,boolean stop, boolean removePunctuation)
	{
		
		Tokenizer t = new Tokenizer(true,false,true);

		String temp_sentence = sentence;
		String result = "";
		//temp_sentence = t.tokenizeAndReturnString(temp_sentence, stem, stop, removePunctuation);

		temp_sentence = temp_sentence.trim();
		StringTokenizer st = new StringTokenizer(temp_sentence," ");
		int pos_score = 0, neg_score = 0, word_count = 0;
		int multiplier = 1;
		
		while(st.hasMoreTokens())
		{
			String word = st.nextToken();
			
			int curr_score = sw.getSentimentOfWord(word);
			result = result+word+"|"+curr_score+" ";
		}

		
		return result;

	}
	public static void load(String[] args)
	{
		for (String arg: args) {
			String[] s = arg.split("=");
			String param = s[0];
			String val = s[1];

			if (param.equals("sentilist")) sw.hm_filepath = val; 


		}

	}

	public SentimentSentencePerWord(String sentilist)
	{
		
		negators = getNegators();
		intensifiers = getIntensifiers();
		
		if (this.sw.hm_filepath.equals(""))
			this.sw.hm_filepath = sentilist; 
		
		sw = new SentimentWord();
	}

	public static void main(String[] args)
	{

		load(args);

		SentimentSentencePerWord ss = new SentimentSentencePerWord("");

		System.out.println("Sentiment of I am abundantly happy and fabulous = "+ss.getSentimentOfSentence("I am abundantly happy and fabulous",true,true,false));
		System.out.println("Sentiment of I am absolutely sad and terrible = " + ss.getSentimentOfSentence("I am absolutely sad and terrible",true,true,false));
		System.out.println("Sentiment of I am absolutely sad but happy = " + ss.getSentimentOfSentence("I am absolutely sad but happy",true,true,false));

		System.out.println("Sentiment of I am sad but happy = " + ss.getSentimentOfSentence("I am sad but happy",true,true,false));
		System.out.println("Sentiment of I am absolutely not sad  = " + ss.getSentimentOfSentence("I am absolutely not sad ",true,false,false));

	}
}
