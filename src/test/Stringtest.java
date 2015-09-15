package test;

public class Stringtest {
	static void change(String s)
	{
		s="World";
	}
	
	static void replace(char[] s)
	{
		int slen=0,sslen=0,count=0;
		for(int i=0;i<s.length&&s[i]!='\0';i++)
		{
			if(s[i]==' ')
				count++;
			slen++;
		}
		sslen=slen+2*count;
		for(int i=slen-1,j=sslen-1;count>0 && i>=0;i--,j--)
		{
			if(s[i]==' ')
			{
				s[j--]='0';
				s[j--]='2';
				s[j]='%';
				count--;
			}
			else
			{
				s[j]=s[i];
			}
		}
		
	}
	public static void main(String[] args)
	{
		String s="Hello";
		String h="Hello";
		if(s==h)
			System.out.println("s=h");
		change(s);
		System.out.println(s);
		
		char[] str = s.toCharArray();
		replace(str);
		System.out.println(str.toString());
	}
}
