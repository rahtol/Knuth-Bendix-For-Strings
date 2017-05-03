
public class kbs_1_example54 {

	// by convention, upper case letters represent the inverse of their lower case pendant 

	final static String [][] ex54_data = {
		{"aa", ""},
		{"bB", ""},
		{"bbb", ""},
		{"ababab", ""}
	};

	public static void main(String[] args) 
	{
		kbs_1_shortlex ex54 = new kbs_1_shortlex(ex54_data);
		ex54.run();
	}

}
