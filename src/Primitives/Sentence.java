package Primitives;

import java.util.Vector;

public class Sentence {
	String words = "";
	Vector<Integer> questiontype;
	int tense;
	String tagsequence = "";
	String taggedsentence = "";
	static QuestionTypeHandler qth;
	static TenseHandler th;
	static POSTagger pt;
	static SentenceStringer ss;
	static NounPhraseHandler nph;
    
	 public Vector<String> getPronouns()
	    {
	    	return nph.pronouns;
	    }
	 
    public Vector<String> getNumberOfEntities()
    {
    	return nph.number_entities;
    }
    public Vector<String> getEntities()
    {
    	return nph.entities;
    }
    public Vector<String> getNamedEntities()
    {
    	return nph.named_entities;
    }
    
   
    public String getTagSequence()
    {
    	return tagsequence;
    }
    
    public String getTaggedSentence()
    {
    	return taggedsentence;
    }
    
    public String getwords()
    {
    	return words;
    }
    
    public int getTenseInteger()
    {
    	return tense;
    }
    
    public String getMatchingWords(String keyword)
    {
    	return ss.getTaggedWordsThatMatch(this.getTaggedSentence(), keyword);
    }
    
    public String getTenseCode()
    {
    	return th.tenseCodeToString(tense);
    }
    
    public Vector<Integer> getQuestionType()
    {
    	return questiontype;
    }
    
    public String getQuestionCode()
    {
    	return qth.questionCodeToString(questiontype);
    }
    
   
    
    public Sentence(String postagger)
    {
    	qth = new QuestionTypeHandler();
    	th = new TenseHandler();
    	pt = new POSTagger(postagger);
        ss = new SentenceStringer();
        nph = new NounPhraseHandler();
    }
    
    public boolean isChoiceQuestion()
    {
    	return (this.getQuestionType().contains(7))?true:false;
    }
    
    public boolean isQuestion()
    {
    	return (!this.getQuestionType().contains(-1))?true:false;
    }
    
    public boolean isEnquiryQuestion()
    {
    	return( this.words.toLowerCase().startsWith("do") || this.words.toLowerCase().startsWith("did")
    			 || this.words.toLowerCase().startsWith("can") || this.words.toLowerCase().startsWith("could")
    			  || this.words.toLowerCase().startsWith("must")
			 || this.words.toLowerCase().startsWith("should") || this.words.toLowerCase().startsWith("will") || this.words.toLowerCase().startsWith("would"));
    	
    }
    public boolean isFactQuestion()
    {
 
    	return (!this.getQuestionType().contains(7) && !this.getQuestionType().contains(8) && !this.getQuestionType().contains(9))?true:false;
    }
	public void loadSentence(String words)
	{
		//System.out.println("Word = "+words);
		this.words = words;
		questiontype = qth.getQnType(words);
		try{
		taggedsentence = pt.tagger.tagString(words);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		tagsequence = ss.getOnlyTagSequence(taggedsentence);
		tense = th.getTense(tagsequence);
		nph.getEntities(taggedsentence);
		nph.getPronouns(taggedsentence);
		
	}
	
	public static void main(String[] args)
	{
		String words = "Did you like Barack Obama's immigration reforms introduced in the Capitol this morning?";
		
		Sentence s = new Sentence("/home/aadi/Downloads/stanford-postagger-full-2014-01-04/models/english-left3words-distsim.tagger");
		
		s.loadSentence(words);
		
		System.out.println("WORDS= "+s.getwords());
		System.out.println("TAG SEQUENCE= "+s.getTagSequence());
		System.out.println("TAGGED SENTENCE= "+s.getTaggedSentence());
		System.out.println("TENSE= "+s.getTenseCode());
		System.out.println("QUESTION CODE="+s.getQuestionCode());
		System.out.println("ENTITIES="+s.getEntities());
		System.out.println("NAMED ENTITIES="+s.getNamedEntities());
		System.out.println("PRONOUNS="+s.getPronouns());
	}
}
