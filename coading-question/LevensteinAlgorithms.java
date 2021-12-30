public class LevensteinAlgorithms{

		public static int min(int a, int b, int c){
				int mintemp = a < b ? a : b;
				int min = mintemp < c ? mintemp : c;
				return min;
		}

		public static int changeToFar(String s, String t){
				int row = s.length() + 1; // 6 5
				int col = t.length() + 1; // 4 3

				int result_matrix[][] = new int[row][col];
				for(int i=1; i < row; i++)
						result_matrix[i][0] = i;
				for(int j=1; j < col; j++)
						result_matrix[0][j] = j;



				
				int cost = 0;
				for(int i=1; i<row; i++)
						for(int j=1; j < col; j++){
								if(s.charAt(i-1) == t.charAt(j-1))
										cost = 0;
								else
										cost = 1;
								int a = result_matrix[i][j-1]+1;
								int b = result_matrix[i-1][j]+1;
								int c = result_matrix[i-1][j-1]+cost;
								result_matrix[i][j] = min( a,b ,c );
						}
				for(int i=0; i < row; i++){
						for(int j=0; j < col; j++){
								System.out.print(result_matrix[i][j] + " ");
				}
								System.out.println();
				}
				return result_matrix[row-1][col-1];
		}

		public static void main(String []args){
				System.out.println(changeToFar("bang", "ang"));
		}
}





