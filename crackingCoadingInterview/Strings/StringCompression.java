public class StringCompression{
		
		static String compressString(String str){
				StringBuilder compressed = new StringBuilder();
				int consecutive = 0;
				for(int i=0; i<str.length(); i++)
				{
						consecutive++;
						if((i+1) >= str.length() || str.charAt(i) != str.charAt(i+1))
						{
								compressed.append(str.charAt(i));
								compressed.append(consecutive);
								consecutive = 0;
						}
				}
				return compressed.length() < str.length() ? compressed.toString() : str;
		}
		
		static String compress(String str){
				int finalLength = countCompression(str);
				if(finalLength >= str.length()) return str;

				StringBuilder compressed = new StringBuilder(finalLength);
				int consecutive = 0;
				for(int i=0; i < str.length(); i++){
						consecutive++;
						if((i+1) >= str.length() || str.charAt(i) != str.charAt(i+1)){
								compressed.append(str.charAt(i));
								compressed.append(consecutive);
								consecutive =0;
						}
				}
				return compressed.toString();
		}

		static int countCompression(String str){
				int compressedLength = 0;
				int consecutive = 0;

				for(int i=0; i<str.length(); i++)
				{
						consecutive++;
						if((i+1) >= str.length() || str.charAt(i) != str.charAt(i+1))
						{
								compressedLength += 1 + String.valueOf(consecutive).length();
								consecutive = 0;
						}
				}
				return compressedLength;
		}

								
		public static void main(String []args){
				System.out.println(compress("aaa"));
		}
}

