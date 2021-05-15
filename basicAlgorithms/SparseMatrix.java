import java.util.Scanner;
public class SparseMatrix
{
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
				Scanner in = new Scanner(System.in);
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





		public static void main(String []args){
				SparseMatrix matrix = new SparseMatrix();
				matrix.create(matrix);
				matrix.display(matrix);
		}
}


