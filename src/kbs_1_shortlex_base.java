public abstract class kbs_1_shortlex_base extends kbs_1_base {
	

	kbs_1_shortlex_base (String [][] R)
	{
		super (R);
	}
	
	abstract int ordchar (char c);
	
	boolean lessthan (String U, String V)
	{
		// shortlex or length-plus-lexicographic ordering
		if (U.length() == V.length())
		{
			int i = 0;
			for (i = 0; (i < U.length()) && (U.charAt(i) == V.charAt(i)); i++);
			if (i < U.length()) 
			{
				return ordchar (U.charAt(i)) < ordchar(V.charAt(i));
			}
			else
			{
				// U == V holds
				return false; 
			}
			
		};
		return U.length() < V.length();
	};

}
