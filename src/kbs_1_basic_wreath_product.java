
public class kbs_1_basic_wreath_product extends kbs_1_basic_wreath_product_base {

	kbs_1_basic_wreath_product(String[][] R) {
		super(R);
	}

	@Override
	int degree(char c) 
	{
		// .... c < C < b < B < a < A
		
		int o = -c; // not expecting this to go through - c should be a letter
		if ((c >= 'a') && (c <= 'z')) 
			o = ('z'-c)*2;
		if ((c >= 'A') && (c <= 'Z')) 
			o = ('Z'-c)*2+1;
		
		return o;
	}

}
