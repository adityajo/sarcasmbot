package Primitives;

import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;

public class TenseHandler {
	static HashMap<Integer,String> hm_tensecode = new HashMap<Integer,String>();
	static HashMap<String, Integer> hm_tagtotensetype = new HashMap<String,Integer>();
	
	public String tenseCodeToString(int i)
	{
		String op="";
		
			op = hm_tensecode.get(i);
		
		return op;
	}
	
	public TenseHandler()
	{
		/* VBN and VBG ignored */
		hm_tensecode.put(1,"3Present");
		hm_tensecode.put(2,"Past");
		hm_tensecode.put(3,"Modal");
		hm_tensecode.put(4,"non3Present");
		
		hm_tagtotensetype.put("MD",3);
		hm_tagtotensetype.put("VB",4);
		hm_tagtotensetype.put("VBD",2);
		
		hm_tagtotensetype.put("VBZ",1);
		hm_tagtotensetype.put("VBP",4);
	}
	
	public int getTense(String SequenceOfTags)
	{
		
			String word = "";
			SequenceOfTags = SequenceOfTags.replace("?"," ?");
			
			StringTokenizer st = new StringTokenizer(SequenceOfTags.toUpperCase()," ");
			Vector<Integer> vals = new Vector<Integer>();
			
			
			
			while (st.hasMoreTokens())
			{
				word = st.nextToken();
				
				if (hm_tagtotensetype.containsKey(word))
					return hm_tagtotensetype.get(word);
				
			}
		
			return -1;
		}
	
	public static void main(String[] args)
	{
		TenseHandler th = new TenseHandler();
		
		System.out.println(th.getTense("VB PRP IN PRP ."));
	}
}
