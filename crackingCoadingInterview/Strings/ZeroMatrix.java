public class ZeroMatrix{

		void setZero(int [][]matrix){
		boolean [] row = new boolean[matrix.length];
		boolean [] column = new boolean[matrix[0].length];

		for(int i=0; i < matrix.length; i++)
				for (int j=0; j < matrix[0].length; j++){
						if(matrix[i][j] == 0)
						{
								row[i] = true;
								column[j] = true;
						}
				}
		for(int j =0; j < column.length; j++)
				if(column[j]) nullifyColumn(matrix,j);

		for(int i=0; i < row.length; i++)
				if(row[i]) nullifyRow(matrix, i);
		}

		void nullifyColumn(int [][]matrix, int col){
				for(int i=0; i < matrix.length; i++)
						matrix[i][col] = 0;
		}

		void nullifyRow(int [][]matrix, int row){
				for(int i=0; i < matrix[0].length; i++)
						matrix[row][i] = 0;
		}





}

