
public class kbs_1_shortlex2 extends kbs_1_shortlex_base {

	kbs_1_shortlex2(String[][] R)
	{
		super(R);
	}

	@Override
	int ordchar(char c)
	{
		// a < b < c <  ... < C < B < A
		
		int o = -c; // not expecting this to go through - c should be a letter
		if ((c >= 'a') && (c <= 'z')) 
			o = (c-'a');
		if ((c >= 'A') && (c <= 'Z')) 
			o = ('Z'-c)+100;

		return o;
	}

}
