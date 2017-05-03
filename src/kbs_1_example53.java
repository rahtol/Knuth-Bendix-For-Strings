
public class kbs_1_example53 {

	// by convention, upper case letters represent the inverse of their lower case pendant 

	final static String [][] ex53_data = {
		{"aa", ""},
		{"bbb", ""},
		{"ababab", ""}
	};

	public static void main(String[] args)
	{
		kbs_1_shortlex ex53 = new kbs_1_shortlex(ex53_data);
		ex53.run();
	}

}
