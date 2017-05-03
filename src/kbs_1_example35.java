
public class kbs_1_example35 {

	// by convention, upper case letters represent the inverse of their lower case pendant 

	final static String [][] ex35_data = {
		{"aa", ""},
		{"abba", "bab"},
		{"bbb", ""},
		{"baba", "abb"},
		{"abab", "bba"},
		{"bbabb", "aba"}
	};

	public static void main(String[] args) 
	{
		kbs_1_shortlex ex35 = new kbs_1_shortlex(ex35_data);
		ex35.run();
	
		String ba = ex35.rewrite_from_left("abaababbaaabbabbbaba");  // actually uses S not T for rewriting !!
		System.out.printf("abaababbaaabbabbbaba -> %s\n", ba);

	}

}
