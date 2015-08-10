package SentencePredictor;

import java.util.ArrayList;
import java.util.HashSet;

public class Tokenizer {

	private static boolean stop;
	private static boolean stem;
	
	private HashSet<String> stopwords;
	private Porter stemmer = null;
	private String regex = "\\s+";
	
	
	public Tokenizer(boolean stop, boolean stem, boolean removePunctuation) {
		this.stop = stop;
		this.stem = stem;
		
		if (stop) stopwords = getStopwords();
		if (stem) stemmer = new Porter();
		if (removePunctuation) regex = "(\\s|\\p{Punct})+";
	}
	
		
	
	public ArrayList<String> tokenize(String s) {
		ArrayList<String> tokens = new ArrayList<String>();
				
		for (String term: s.trim().split(regex)) {
			if (term.length()>0) {
				if (stop)
				{	
					if (stopwords.contains(term)) 
						term = "";
					
				}
				
				if (this.stem && stemmer != null) term = stemmer.stripAffixes(term);

				if (term.length()>0) tokens.add(term);	
			}
		}
		return tokens; 
	}

	public String tokenizeAndReturnString(String s, boolean stem, boolean stop, boolean punct){
		
		ArrayList<String> tokens = new ArrayList<String>();
		String result = "";
		
		this.stem = stem;
		this.stop = stop;
		
		if (punct)
			regex = "(\\s|\\p{Punct})+";
		
		stopwords = getStopwords();
		
		tokens = tokenize(s);
		
		for (String curr: tokens)
		{
			result = result+curr+" ";
		}

		result = result.trim();
		return result;
	}
	
	// private methods
	
	private HashSet<String> getStopwords() {
		
		HashSet<String> stopwords = new HashSet<String>();
		
		String[] googleStopwords = {"I","i", "a","about","an","are","as","at","be","by","com","de","en","for","from","how","in","is","it","la","of","on","or","that","the","this","to","was","what","when","where","who","will","with","und","the","www"};
		String[] luceneStopwords = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "000", "$", "about", "after", "all", "also", "an", "and", "another", "any", "are", "as", "at", "be", "because", "been", "before", "being", "between", "both", "but", "by", "came", "can", "come", "could", "did", "do", "does", "each", "else", "for", "from", "get", "got", "has", "had", "he", "have", "her", "here", "him", "himself", "his", "how","if", "in", "into", "is", "it", "its", "just", "like", "make", "many", "me", "might", "more", "most", "much", "must", "my", "never", "now", "of", "on", "only", "or", "other", "our", "out", "over", "re", "said", "same", "see", "should", "since", "so", "some", "still", "such", "take", "than", "that", "the", "their", "them", "then", "there", "these", "they", "this", "those", "through", "to", "too", "under", "up", "use", "very", "want", "was", "way", "we", "well", "were", "what", "when", "where", "which", "while", "who", "will", "with", "would", "you", "your", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		String[] marksStopwords = {"http","ww","co","system","unfiled"};
		String[] adityasStopwords = {"on","go","without","us","one","no","not","one","two","three","four","five","six","seven","eight","nine","ten"};
		String[] malletStopwords = {"a","able","about","above","according","accordingly","across","actually","after","afterwards","again","against","all","allow","allows","almost","alone","along","already","also","although","always","am","among","amongst","an","and","another","any","anybody","anyhow","anyone","anything","anyway","anyways","anywhere","apart","appear","appreciate","appropriate","are","around","as","aside","ask","asking","associated","at","available","away","awfully","b","be","became","because","become","becomes","becoming","been","before","beforehand","behind","being","believe","below","beside","besides","best","better","between","beyond","both","brief","but","by","c","came","can","cannot","cant","cause","causes","certain","certainly","changes","clearly","co","com","come","comes","concerning","consequently","consider","considering","contain","containing","contains","corresponding","could","course","currently","d","definitely","described","despite","did","different","do","does","doing","done","down","downwards","during","e","each","edu","eg","eight","either","else","elsewhere","enough","entirely","especially","et","etc","even","ever","every","everybody","everyone","everything","everywhere","ex","exactly","example","except","f","far","few","fifth","first","five","followed","following","follows","for","former","formerly","forth","four","from","further","furthermore","g","get","gets","getting","given","gives","go","goes","going","gone","got","gotten","greetings","h","had","happens","hardly","has","have","having","he","hello","help","hence","her","here","hereafter","hereby","herein","hereupon","hers","herself","hi","him","himself","his","hither","hopefully","how","howbeit","however","i","ie","if","ignored","immediate","in","inasmuch","inc","indeed","indicate","indicated","indicates","inner","insofar","instead","into","inward","is","it","its","itself","j","just","k","keep","keeps","kept","know","knows","known","l","last","lately","later","latter","latterly","least","less","lest","let","like","liked","likely","little","look","looking","looks","ltd","m","mainly","many","may","maybe","me","mean","meanwhile","merely","might","more","moreover","most","mostly","much","must","my","myself","n","name","namely","nd","near","nearly","necessary","need","needs","neither","never","nevertheless","new","next","nine","no","nobody","non","none","noone","nor","normally","not","nothing","novel","now","nowhere","o","obviously","of","off","often","oh","ok","okay","old","on","once","one","ones","only","onto","or","other","others","otherwise","ought","our","ours","ourselves","out","outside","over","overall","own","p","particular","particularly","per","perhaps","placed","please","plus","possible","presumably","probably","provides","q","que","quite","qv","r","rather","rd","re","really","reasonably","regarding","regardless","regards","relatively","respectively","right","s","said","same","saw","say","saying","says","second","secondly","see","seeing","seem","seemed","seeming","seems","seen","self","selves","sensible","sent","serious","seriously","seven","several","shall","she","should","since","six","so","some","somebody","somehow","someone","something","sometime","sometimes","somewhat","somewhere","soon","sorry","specified","specify","specifying","still","sub","such","sup","sure","t","take","taken","tell","tends","th","than","thank","thanks","thanx","that","thats","the","their","theirs","them","themselves","then","thence","there","thereafter","thereby","therefore","therein","theres","thereupon","these","they","think","third","this","thorough","thoroughly","those","though","three","through","throughout","thru","thus","to","together","too","took","toward","towards","tried","tries","truly","try","trying","twice","two","u","un","under","unfortunately","unless","unlikely","until","unto","up","upon","us","use","used","useful","uses","using","usually","uucp","v","value","various","very","via","viz","vs","w","want","wants","was","way","we","welcome","well","went","were","what","whatever","when","whence","whenever","where","whereafter","whereas","whereby","wherein","whereupon","wherever","whether","which","while","whither","who","whoever","whole","whom","whose","why","will","willing","wish","with","within","without","wonder","would","would","x","y","yes","yet","you","your","yours","yourself","yourselves","z","zero"};
		for (String s: googleStopwords) stopwords.add(s);
		for (String s: luceneStopwords) stopwords.add(s);
		for (String s: marksStopwords) stopwords.add(s);
		for (String s: adityasStopwords) stopwords.add(s);
		for (String s: malletStopwords) stopwords.add(s);
		return stopwords;
		
	}
	
	
	public static void main(String[] args) {
		Tokenizer qt = new Tokenizer(true, true, true);
		System.out.println(qt.tokenizeAndReturnString("there are people who are people but people don't people. what to do , i what on not to do, stop a thinking,....just do do",true,true,true));
		
	}
	
}
