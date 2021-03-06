package Primitives;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;
import edu.stanford.nlp.process.TokenizerFactory;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

/** This demo shows user-provided sentences (i.e., {@code List<HasWord>})
 *  being tagged by the tagger. The sentences are generated by direct use
 *  of the DocumentPreprocessor class.
 *
 *  @author Christopher Manning
 */
/*
 * Modified by Aditya J.
 * 
 * Input: 1) model file, 2) Directory where data files are present
 * 
 * 
 * 1) model file = C:\Aditya\POSTaggerModels\english-left3words-distsim.tagger
 * Output goes to directory same as (2) with "input" replaced with "output". This directory must be created
 * beforehand. All files are copied with a ".wordpos" extension.
 * Output format is word/POS.
 */
class POSTagger {

	MaxentTagger tagger;
	TokenizerFactory<CoreLabel> ptbTokenizerFactory;
	public POSTagger(String modelFile) {
		

		this.tagger = new MaxentTagger(modelFile);
		this.ptbTokenizerFactory = PTBTokenizer.factory(new CoreLabelTokenFactory(),
					"untokenizable=noneKeep");
	
	}

	
	public static void main(String[] args) throws Exception 
	{
		
		
		/*
		 * Create output directory if it does not exist
		 */
		
		int count = 0;
		POSTagger pt;
		
		String modelFile = "/home/aadi/Downloads/stanford-postagger-full-2014-01-04/models/english-left3words-distsim.tagger";
		pt = new POSTagger(modelFile);
		
			String tag = pt.tagger.tagString("What is your opinion about the immigration reforms in Shahrukh Khan?");
			//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out, "utf-8"));
			System.out.println(tag);
			System.out.println(pt.tagger.tagString("Do you have the chocolate?"));
			System.out.println(pt.tagger.tagString("Which chocolate is that?"));
			System.out.println(pt.tagger.tagString("Will he marry me?"));

	}
}
