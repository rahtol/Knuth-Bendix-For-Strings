
public class kbs_1_shortlex extends kbs_1_shortlex_base {

	kbs_1_shortlex(String[][] R)
	{
		super(R);
	}

	@Override
	int ordchar (char c)
	{
		// a < A < b < B < c < C ...
		
		int o = -c; // not expecting this to go through - c should be a letter
		if ((c >= 'a') && (c <= 'z')) 
			o = (c-'a')*2;
		if ((c >= 'A') && (c <= 'Z')) 
			o = (c-'A')*2+1;
		
		return o;
	};
}
