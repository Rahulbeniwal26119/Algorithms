import java.util.Scanner;
public class SparseMatrix
{
	Scanner in = new Scanner(System.in);
		public static class Element 
		{
				int i , j , x;
				Element(int i, int j, int x)
				{
						this.i = i;
						this.j = j;
						this.x = x;
				}
		}

		int numOfRows;
		int numOfCols;
		int numOfNonZeroElement;
		Element elementPointer[];

		void create(SparseMatrix e)
		{
				System.out.print("Enter dimensions");
				e.numOfRows = in.nextInt();
				e.numOfCols = in.nextInt();
				e.numOfNonZeroElement = in.nextInt();
				e.elementPointer  = new Element[e.numOfNonZeroElement];
				System.out.println("Enter non zero element");
				for(int i=0; i<e.numOfNonZeroElement; i++)
				{
						e.elementPointer[i] = new Element(in.nextInt(), in.nextInt(), in.nextInt());
				}
		}

		void display(SparseMatrix s)
		{
				int k=0;
				for(int i=0; i<s.numOfRows; i++)
				{	
						for(int j=0; j<s.numOfCols; j++)
					{
							if(k < s.elementPointer.length && s.elementPointer[k].i == i && s.elementPointer[k].j ==j)
									System.out.print(" " + s.elementPointer[k++].x + " ");
							else 
									System.out.print(" 0 ");
					}
					System.out.println();
				}
		}

		static SparseMatrix add(SparseMatrix s1 , SparseMatrix s2)
		{
				SparseMatrix sum = new SparseMatrix();
				sum.elementPointer = new Element[s1.numOfNonZeroElement + s2.numOfNonZeroElement];
				int i,j,k;
				i=j=k=0;
				while(i < s1.numOfNonZeroElement && j<s2.numOfNonZeroElement)
				{
						if(s1.elementPointer[i].i < s2.elementPointer[j].i)
								sum.elementPointer[k++] = s1.elementPointer[i++];
						else if(s1.elementPointer[i].i > s2.elementPointer[j].i)
							sum.elementPointer[k++] = s2.elementPointer[j++];
						else
						{
							if(s1.elementPointer[i].j < s2.elementPointer[j].j)
								sum.elementPointer[k++] = s2.elementPointer[i++];
							else if(s1.elementPointer[i].j > s2.elementPointer[j].j)
								sum.elementPointer[k++] = s2.elementPointer[j++];
							else 
							{
								sum.elementPointer[k] = s1.elementPointer[i];
								sum.elementPointer[k++].x = s1.elementPointer[i++].x + s2.elementPointer[j++].x;
							}
						} 
					}
					for(; i<s1.numOfNonZeroElement; i++)
						sum.elementPointer[k++] = s1.elementPointer[i];
					for(;j<s2.numOfNonZeroElement; j++)
						sum.elementPointer[k++] = s2.elementPointer[j];
					sum.numOfRows = s1.numOfRows;
					sum.numOfCols= s1.numOfCols;
					sum.numOfNonZeroElement = k;

					return sum;
		}





		public static void main(String []args){
				SparseMatrix matrix1 = new SparseMatrix();
				SparseMatrix matrix2 = new SparseMatrix(); 
				matrix1.create(matrix1);
				matrix2.create(matrix2);
				matrix1.display(add(matrix1, matrix2));
		}
}


