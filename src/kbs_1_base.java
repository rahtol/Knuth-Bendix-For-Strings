import java.util.Vector;


public abstract class kbs_1_base {

	String [][] R;
	Vector<String[]> S;
	Vector<String[]> T;
	
	abstract boolean lessthan (String U, String V);
	
	kbs_1_base (String [][] R)
	{
		this.R = R;
		S = new Vector<String[]>();
		T = new Vector<String[]>();
		S.clear();
		T.clear();
	}
	
	String rewrite_from_left (String U)
	{
//		System.out.printf("rewrite_from_left: .%s", U);
		String W = U;
		String V = "";
		while (W.length() != 0)
		{
			V = V + W.substring(0, 1);
			W = W.substring(1);
			for (int i = 0; i < S.size(); i++)
			{
				String Pi = S.elementAt(i)[0];
				String Qi = S.elementAt(i)[1];
				if (V.endsWith(Pi))
				{
					V = V.substring(0, V.length()-Pi.length());
					W = Qi + W;
//					System.out.printf("->%s.%s", V, W);
					break;
				}
			}
		}
//		System.out.printf("\n");
		return V;
	};
	
	void test_1 (String U, String V, String comment)
	{
		String A = rewrite_from_left(U);
		String B = rewrite_from_left(V);
		if (!A.equals(B))
		{
//			System.out.printf("test_1: ");
//			System.out.printf("%s -> %s, ", U, A);
//			System.out.printf("%s -> %s\n", V, B);
			
			String [] element = {A, B};
			if (lessthan (A, B))
			{
				element [0] = B;
				element [1] = A;
			}
			S.addElement(element);
			System.out.printf("%-20s    S[%3d]: %s -> %s\n", comment, S.size(), element[0], element[1]);
		};
	};

	void overlap_1 (int i, int j)
	{
//		System.out.printf("overlap_1: (%d,%d), (%s,%s)\n", i, j, ex37_data[i][0], ex37_data[j][0]);

		String Pi = S.elementAt(i)[0];
		String Pj = S.elementAt(j)[0];
		String Qi = S.elementAt(i)[1];
		String Qj = S.elementAt(j)[1];
		
		int li = Pi.length();
		int lj = Pj.length();
		int la, lu, ld, le;
		
		for (int k=1; k <= li; k++)
		{
			la = li - k;
			lu = 0;
			while ((la+lu < li) && (lu < lj) && (Pi.charAt(la+lu) == Pj.charAt(lu)))
			{
				lu++;
			};
			ld = li - (la + lu);
			le = lj - lu;
			if ((ld==0) || (le==0))
			{
				String A = Pi.substring(0, la);
				String D = Pi.substring(la+lu, li);
				String E = Pj.substring(lu, lj);
				String U = Pj.substring(0, lu);
//				System.out.printf("test_1: AUDE=%s.%s.%s.%s  (AQjD=%s.%s.%s, QiE=%s.%s)\n", A,U,D,E, A,Qj,D, Qi,E);
				test_1 (A+Qj+D,Qi+E, String.format("Overlap %d %d %d", i+1, j+1, k));
			}
				
		}
	};
	
	void run()  // named kbs_1 in Sims
	{
		int i=0;
		S.clear();
		T.clear();
		
		for (i=0; i < R.length; i++)
		{
			test_1(R[i][0], R[i][1], String.format("Relation %d", i+1));
		};
	
		i=0;
		while (i < S.size())
		{
			for (int j=0; j <= i; j++)
			{
				overlap_1 (i,j);
				if (j < i) overlap_1 (j,i);
			};
			i++;
		};
		
		for (i=0; i < S.size(); i++)
		{
			boolean propersubword = false;
			String Pi = S.elementAt(i)[0];
			for (int j = 0; j < S.size(); j++)
			{
				String Pj = S.elementAt(j)[0];
				if (i == j) continue;
				if (Pi.length() <= Pj.length()) continue;
				if (Pi.contains(Pj))
				{
					propersubword = true;
					break;
				}
			};
			if (!propersubword)
			{
				String Q = rewrite_from_left(Pi);
				String [] element = {Pi, Q};
				T.addElement(element);
				System.out.printf("%-20s    T[%3d]: %s -> %s\n", "", T.size(), element[0], element[1]);
			}
		};
	}

}
