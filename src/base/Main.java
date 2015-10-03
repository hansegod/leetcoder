package base;

import java.util.Scanner;

public class Main {
	public static void main(String[] argvs){

	}
	
	//ÊäÈë¾ØÕó
	public static void scannertest(){
		int[][] A;
		Scanner in=new Scanner(System.in);
		String input=in.nextLine();
		String[] line=input.split(";");
		A=new int[line.length][];
		for(int i=0;i<line.length;i++){
			String[] t=line[i].split(" ");
			int[] v=new int[t.length];
			for(int j=0;j<v.length;j++)
				v[j]=Integer.parseInt(t[j]);
			A[i]=v;
		}
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				System.out.printf("%d ", A[i][j]);
			}
		}
	}
}
