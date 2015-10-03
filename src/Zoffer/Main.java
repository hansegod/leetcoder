package Zoffer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
	public static String fun(){
		boolean flag = false;
		int time=0;
		Scanner in=new Scanner(System.in);
		String s=in.nextLine();
		for(int i=0,j=s.length()-1;i<j;){
			if(s.charAt(i)==s.charAt(j)){
				i++;
				j--;
			}
			else if(s.charAt(i)==s.charAt(j-1)){
				time++;
				j--;
			}
			else if(s.charAt(i+1)==s.charAt(j)){
				time++;
				i++;
			}
		}
		
		return time<2?"YES":"NO";
	}
	
	public static int fun_(){
		Scanner in=new Scanner(System.in);
		int c=0,p=0,n=0,i=0;
		long t=0;
		p=in.nextInt();
		n=in.nextInt();
		boolean[] P=new boolean[p];
		while(n-->0){
			c++;
			t=in.nextLong();
			i=(int) (t%p);
			if(P[i])
				return c;
			else
				P[i]=true;
		}
		return -1;
	}
	
	public static void writeperson(){
		try{
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("person.txt"));
			Person p=new Person("hanse",30);
			oos.writeObject(p);
			oos.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void writeman(){
		try{
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("man.txt"));
			Man m=new Man("blacktiger",20);
			m.writeExternal(oos);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] agvs){
//		System.out.println(fun());
		writeperson();
		writeman();
	}
}
