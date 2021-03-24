// replace each ' ' with %20 
public class URLify
{
	static String  replaceSpaces(String  string , int truelength)
	{
		char str[] = string.toCharArray();
		int nSpaces=0;
		for(int i=0; i<truelength;i++)
			if(str[i]==' ')
				nSpaces++;
		int index  = truelength + 2 * nSpaces - 1;
		//if(truelength < str.length) 
		for(int i = truelength -1 ; i >=0; i--)
		{
			if(str[i] == ' ' )
			{
				str[index] = '0';
				str[index - 1] = '2';
				str[index - 2] = '%';
				index = index - 3;
			}
			else 
			{
				str[index] = str[i];
				index--;
			}
		}
		return new String(str);
	}
	public static void main(String [] args)
	{
		String str = "Rahul Beniwal  ";
		System.out.println(replaceSpaces(str , 13));
	}
}


