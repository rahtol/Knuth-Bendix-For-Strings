
public class kbs_1_example51 {

	// by convention, upper case letters represent the inverse of their lower case pendant 

	final static String [][] ex51_data = {
		{"aA", ""},
		{"Aa", ""},
		{"bB", ""},
		{"Bb", ""},
		{"ba", "ab"}
};

	public static void main(String[] args)
	{
		kbs_1_shortlex ex51 = new kbs_1_shortlex(ex51_data);
		ex51.run();
	}
	

}
