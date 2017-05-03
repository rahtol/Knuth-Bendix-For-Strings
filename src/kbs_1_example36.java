
public class kbs_1_example36 {

	final static String [][] ex36_data = {
		{"aA", ""},
		{"Aa", ""},
		{"bB", ""},
		{"Bb", ""},
		{"cC", ""},
		{"Cc", ""},
		{"cb", "bc"},
		{"cB", "Bc"},
		{"Cb", "bC"},
		{"CB", "BC"},
		{"ca", "ac"},
		{"cA", "Ac"},
		{"Ca", "aC"},
		{"CA", "AC"},
		{"ba", "abc"},
		{"bA", "AbC"},
		{"Ba", "aBC"},
		{"BA", "ABc"}
	};
	
	public static void main(String[] args)
	{
		kbs_1_basic_wreath_product ex36 = new kbs_1_basic_wreath_product(ex36_data);
		
		for (int i = 0; i < ex36_data.length; i++)
		{
			boolean b = ex36.lessthan(ex36_data[i][1], ex36_data[i][0]);
			System.out.println(b);
		};
		
		ex36.run();
	}

}
