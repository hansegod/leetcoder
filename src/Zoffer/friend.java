package Zoffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class friend {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int n,m,lc=0;
		while(scan.hasNextInt()){
			n=scan.nextInt();
			m=scan.nextInt();
			if(n<=0 || m<=0)
				System.out.println(0);
			
			int a,b;
			Map<Integer,Integer> map= new HashMap<Integer,Integer>();
			List<List> list=new LinkedList<List>();
			for(int i=0;i<m;i++){
				a=scan.nextInt();
				b=scan.nextInt();
				if(map.containsKey(a)&&map.containsKey(b)){
					List k=list.get(map.get(a));
					List q=list.get(map.get(b));
					k.addAll(q);
					map.put(b, map.get(a));
					list.remove(map.get(b));
				}
				else if(map.containsKey(a)){
					List k=list.get(map.get(a));
					k.add(b);
				}
				else if(map.containsKey(b)){
					List k=list.get(map.get(b));
					k.add(a);
				}
				else{
					map.put(a, lc);
					map.put(b, lc);
					List<Integer> l=new LinkedList<Integer>();
					list.add(lc,l);
					lc++;
				}
			}
		}
		scan.close();
	}
	public static List<Integer> union(List<Integer> a, List<Integer> b) {
        Set<Integer> s=new HashSet<Integer>();
        s.addAll(a);
        s.addAll(b);
        List<Integer> ll=new LinkedList<Integer>();
        ll.addAll(s);
        return ll;
    }
}
