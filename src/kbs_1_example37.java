
public class kbs_1_example37 {

	// by convention, upper case letters represent the inverse of their lower case pendant 

	final static String [][] ex37_data = {
		{"aA", ""},
		{"Aa", ""},
		{"bB", ""},
		{"Bb", ""},
		{"ba", "ab"},
		{"bA", "Ab"},
		{"Ba", "aB"},
		{"BA", "AB"}
	};
	
	final static String [][] ex37_data2 = {
		{"aA", ""},
		{"Aa", ""},
		{"bB", ""},
		{"Bb", ""},
		{"ba", "ab"},
		{"Ab", "bA"},  // !! 
		{"Ba", "aB"},
		{"AB", "BA"}   // !!
	};

	public static void main(String[] args)
	{
		kbs_1_shortlex ex37 = new kbs_1_shortlex(ex37_data);
		ex37.run();
		
		kbs_1_shortlex2 ex37_2 = new kbs_1_shortlex2(ex37_data2);
		ex37_2.run();  // !!! caution: does not terminate as this representation is infinite
	}

}
