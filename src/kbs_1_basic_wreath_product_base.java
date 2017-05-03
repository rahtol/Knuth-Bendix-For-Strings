import java.util.Vector;


public abstract class kbs_1_basic_wreath_product_base extends kbs_1_base {
	
	class deghead {
		public deghead(int degree, int head) 
		{
			this.degree = degree;
			this.head = head;
		};
		boolean equals (deghead x)
		{
			return (this.degree == x.degree) && (this.head == x.head);
		}
		int degree;
		int head; // no need for a String here since it would repeat a single char n-times. just store the count n.
	};
	
	@SuppressWarnings("serial")
	class DegHeadSeq extends Vector<deghead> {};  // sequence of degrees and heads

	kbs_1_basic_wreath_product_base(String[][] R) {
		super(R);
	};
	
	abstract int degree (char c);
	
	DegHeadSeq HEAD (String U)  // page 49f, Sims
	{
		DegHeadSeq h = new DegHeadSeq();
		int m = 0;
		for (int k = 0; k < U.length(); k++)
		{
			int j = degree (U.charAt(k));
			if (j > m)
			{
				m = j;
				h.add(new deghead (j, 1));
			}
			else if (j == m)
			{
				h.lastElement().head++;
			}
		};

		// revert h (to stay compatible with Sims)
		DegHeadSeq h2 = new DegHeadSeq();
		for (int i = h.size()-1; i >= 0; i--)
		{
			h2.add(h.get(i));
		}
		return h2;
	};

	@Override
	boolean lessthan(String U, String V)
	{
		int i, j;
		int minlen = Math.min(U.length(), V.length());
		
		// skip any common prefix
		for (i = 0; (i < minlen) && (U.charAt(i) == V.charAt(i)); i++);
		
		// if U.substring(i) or V.substring(i) is empty now, we already have a result
		// (since the empty word is less than any other word for any reduction ordering)
		if (i == minlen) return U.length() < V.length();
		
		// now U.substring(i) and V.substring(i) are both non-empty and do not start with the same character
		
		DegHeadSeq headU = HEAD (U.substring(i));
		DegHeadSeq headV = HEAD (V.substring(i));
		
		int minheadlen = Math.min(headU.size(), headV.size());
		for (j = 0; j < minheadlen && headU.get(j).equals(headV.get(j)); j++);
		
		if (j < minheadlen)
		{
			if (headU.get(j).degree != headU.get(j).degree) {
				return headU.get(j).degree < headU.get(j).degree;
			}
			else {
				return headU.get(j).head < headU.get(j).head;
			}
		}
		else {
			return headU.size() < headV.size();
		}
	}

}
