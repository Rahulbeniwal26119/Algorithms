import java.util.Scanner;
public class Polynomial 
{
		static Scanner in = new Scanner(System.in);
		public static class Term
		{
				int coeff;
				int exp;
		}

		int numOfTerms;
		Term terms[];

		static void create(Polynomial p)
		{
				System.out.print("Enter non zero terms");
				p.numOfTerms = in.nextInt();
				System.out.println(p.numOfTerms);
				System.out.println("Enter terms\n");
				p.terms = new Term[p.numOfTerms];

				for(int i=0; i<p.numOfTerms; i++)
				{
						p.terms[i] = new Term();
						p.terms[i].coeff = in.nextInt();
						p.terms[i].exp   = in.nextInt();
				}
		}

		static void display(Polynomial p)
		{
				int i=0;
				for( i=0; i<p.numOfTerms-1; i++)
				{
						System.out.printf("%dx%d + ",p.terms[i].coeff , p.terms[i].exp);
				}
						System.out.printf("%dx%d",p.terms[i].coeff , p.terms[i].exp);
		}

		static Polynomial add(Polynomial p1, Polynomial p2)
		{
			System.out.println(p1.numOfTerms + " " + p2.numOfTerms);
			int i,j,k;
			i=j=k=0;
			Polynomial sum = new Polynomial();
			sum.numOfTerms = p1.numOfTerms + p2.numOfTerms;
			sum.terms  = new Term[sum.numOfTerms];
			while(i < p1.numOfTerms && j < p2.numOfTerms)
			{
				if(p1.terms[i].exp > p2.terms[j].exp)
					sum.terms[k++] = p1.terms[i++];
				else if(p1.terms[i].exp < p2.terms[j].exp)
					sum.terms[k++] = p2.terms[j++];
				else 
				{
					sum.terms[k].exp = p1.terms[i].exp;
					sum.terms[k++].coeff = p1.terms[i++].coeff + p2.terms[j++].coeff;
				}
			}
			for(;i < p1.numOfTerms; i++)
				sum.terms[k++] = p1.terms[i];

			for(;j < p2.numOfTerms; j++)
			sum.terms[k++] = p2.terms[j];

			sum.numOfTerms = k;
			return sum;
		}

		public static void main(String []args)
		{
				Polynomial p1 = new Polynomial();
				Polynomial p2 = new Polynomial();
				create(p1);
				create(p2);
				Polynomial p3 = add(p1 , p2);
				display(p3);
		}
}

