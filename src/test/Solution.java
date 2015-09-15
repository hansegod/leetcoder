package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import test.ListNode;

public class Solution {
	/*
    public static List<List<Integer>> threeSum(int[] nums) {
    	//排序后分两类情况分析，1.全0 2.按三元组各位仅取一次，过滤重复，取得第一个数后，另两个数夹逼查找，每个符合条件的三元组在一轮同一第一位数的情况下第三位也必唯一出现一次，且不为0
    	List<List<Integer>> list = new LinkedList<List<Integer>>();
    	boolean flag=false;
    	int len = nums.length;
    	if(len < 3)
    	{
    		return list;
    	}
    	Arrays.sort(nums);
    	int first=0,third=0;
    	
    	for(int i=0;i <= len-3;i++)
    	{
    		int h,r;
    		h=i+1;
    		r=len-1;
    		
    		if(first != nums[i] && nums[i]!=nums[i+2])
    		{
    			first = nums[i];
    			third = 0;
    			//System.out.printf("%d %d\n",h,r);
        		while(h<r)
        		{
        			while(h+1 < r && nums[h] == nums[h+1])
        			{
        				h++;
        			}
        			while(r-1 > h && nums[r] == nums[r-1])
        			{
        				r--;
        			}
        			
        			int val = nums[i] + nums[h] + nums[r];
        			System.out.printf("%d %d\n",h,r);
        			//System.out.printf("%d\n",val);
        			if(val > 0)
        			{
        				--r;
        				continue;
        			}
        			else if(val < 0)
        			{
        				++h;
        				continue;
        			}
        			else if(val == 0 && third != nums[r])
        			{
        				third = nums[r];
    					List<Integer> l=new ArrayList<Integer>();
    					l.add(nums[i]);
    					l.add(nums[h]);
    					l.add(nums[r]);
    					list.add(l);
    					System.out.printf("(%d,%d,%d)\n",nums[i],nums[h],nums[r]);
    					r--;
    					h++;
    					continue;
        			}
        			else
        			{
        				r--;
        				h++;
        				continue;
        			}
        		}
    		}
    		else
    		{
    			if(nums[i+2]==0 && false == flag)
    			{
    				flag = true;
					List<Integer> l=new ArrayList<Integer>();
					l.add(0);
					l.add(0);
					l.add(0);
					list.add(l);
    			}
    		}

    	}
        
        return list;
    }
    
    public static void main(String args[])
    {
    	int a[] = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};//{1,1,-2};//{7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};//{-2,0,1,1,2};//{1,-1,-1,0};//{-1,0,1,2,2,-2,-1,-4};
    	List<List<Integer>> r = new LinkedList<List<Integer>>();
    	r = threeSum(a);
    	System.out.printf("Result:\n");
    	for(int i=0;i<r.size();i++)
    	{
    		System.out.printf("(%d,%d,%d)\n",r.get(i).get(0),r.get(i).get(1),r.get(i).get(2));
    	}
    }
    */
	
	
	
	/*
    public static String getPermutation(int n, int k) {
    	String str = new String();
    	ArrayList list = new ArrayList();
    	for(int i=1;i<=n;i++)
    	{
    		list.add(i);
    	}
    	for(int j=1;j<=n;j++)
    	{
    		int p=1;
    		for(int s=n-j;s>0;s--)
    		{
    			p*=s;
    		}
    		//k--;
    		int index = k/p;
    		str += (int)list.get(index);
    		list.remove(index);
    		k = k%p;
    	}
    	return str;
    }
    
    public static void main(String args[])
    {
    	String s = getPermutation(1,1);
    	System.out.printf("%s", s);
    }
    */
    
	/*
    public int trap(int[] height) {
    	int vol=0;
    	
    	for(int i=0;i<height.length;i++)
    	{
    		if(i+1 < height.length && height[i] <= height[i+1])	//找到第一个峰
    		{
    			continue;
    		}
    		for(int j=i+2;j<height.length;j++)
    		{
    			if(height[i] <= height[j])	//找到第二个峰
    			{
    				for(int t=i+1;t<j;t++)	//统计容量
    				{
    					vol+=height[i]-height[t];
    				}
    				
    				i = j-1;				//准备查找下一个
    				break;
    			}
    		}
    	}
    	return vol;
    }
    */
	
	
	/*
	public static int findmax(int[] array,int start,int stop)
	{
		int index=start;
		
		for(int i=start+1;i<=stop;i++)
		{
			if(array[i] >= array[index])
			{
				index = i;
			}
		}
		//System.out.printf("Find MAX = %d:%d\n", index,array[index]);
		return index;
	}
	public static int trap(int[] height) {
		int vol=0;
		int maxindex,max,smax,smaxindex;
		
		if(height.length == 0)
		{
			return vol;
		}
		maxindex = findmax(height,0,height.length-1);				//1.找到最大值位置
		
		max = height[maxindex];
		for(int i=maxindex+1;i<height.length;i++)
		{
			smaxindex = findmax(height,i,height.length-1);			//2。1找右侧区间内构成池的另一个峰
			smax = height[smaxindex];
			if(smaxindex != i)
			{
				int lev = max>smax?smax:max;
				int svol=0;
				
				for(int t=i;t<smaxindex;t++)						//2.2统计容量
				{
					svol+=lev-height[t];
				}
				//System.out.printf("Add right svol = %d\n", svol);
				vol+=svol;
				
				i=smaxindex;
				max=smax;
			}
		}
		
		max = height[maxindex];
		for(int j=maxindex-1;j>=0;j--)
		{
			smaxindex = findmax(height,0,j);						//3.1找左侧区间内构成池的另一个峰
			smax = height[smaxindex];
			if(smaxindex != j)
			{
				int lev = max>smax?smax:max;
				int svol=0;
				
				for(int t=j;t>smaxindex;t--)						//3.2统计容量，注意下标
				{
					svol+=lev-height[t];
				}
				//System.out.printf("Add left svol = %d\n", svol);
				vol+=svol;
				
				j=smaxindex;
				max=smax;
			}
			
		}
		return vol;
	}
	
	public static void main(String args[])
	{
		int[] height = {2,0,2};//{0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.printf("%d\n", trap(height));
	}
	*/
	
	/*
    public int[] plusOne(int[] digits) {
        int flag = 1;
        int i = 0;
		
		for(i=digits.length-1;i>=0;i--) 
		{
			digits[i] = digits[i] + flag;
			if(digits[i]>9) 
			{
	            flag = 1;
	            digits[i] = 0;
	        } 
			else 
			{
	            return digits;
	        }
	    }
			
		if(i==-1&&flag==1)
		{
			int[] newdigits = new int[digits.length+1];
			newdigits[0] = 1;
			for(i=1;i<=digits.length;i++) 
			{
				newdigits[i] = digits[i-1];
			}
			return newdigits;
		} 
		else 
		{
			return digits;
		}
	}
	*/
	
	
	/*
    public List<Integer> grayCode(int n) {
    	ArrayList list = new ArrayList<Integer>();
        int size=1;
        for(int i=0;i<n;i++)
        {
        	size*=2;
        }
        
        int tmp=0;
        for(int i=0;i<=n;i++)
        {
        	tmp = (0x01<<i) | tmp;
        }
        
        for(int j=1;j<n;j++)
        {
        	tmp = (0x01<<i);
        }
        
        return list;
    }
    */
	
	
	/*
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int tmp;
        
        for(int i=0;i<n;i++)
        {
        	int j=i,s=n;
        	tmp = gas[i];
        	while(--s>=0)
        	{
        		tmp-=cost[j];
        		if(tmp>=0 && s!=0)
        		{
        			j=(j+1)%n;
        			tmp+=gas[j];
        		}
        		else
        		{
        			break;
        		}
        	}
        	if(s<0 && tmp >=0)
        	{
        		return i;
        	}
        }
        
        return -1;
    }
    */
	
	/*
    public int candy(int[] ratings) {
    	int result=1,count=1,rate;
    	if(ratings.length==0)
    		return 0;
    	Arrays.sort(ratings);
    	rate = ratings[0];
    	for(int i=1;i<ratings.length;i++)
    	{
    		if(ratings[i]>rate)
    		{
    		    rate = ratings[i];
    			count++;
    		}
    		result+=count;
    	}
    	return result;
    }
    */
	
	/*
    public int singleNumber(int[] nums) {
        int integer=0;
        
        for(int i=0;i<nums.length;i++)
        {
        	integer^=nums[i];
        }
        
        return integer;
    }
    */
    
	/*
    public static int singleNumber(int[] nums) {
    	int integer=0;
    	
    	for(int i=0;i<32;i++)
    	{
    		int count=0;
    		for(int j=0;j<nums.length;j++)
    		{
    			if( (nums[j] & (0x01<<i)) != 0)//(nums[j] & 0x01<<i)是错误的
    			{
    				count++;
    			}
    		}
    		if((count%3) != 0)
    		{
    			integer|=0x01<<i;
    		}
    	}
    	
    	return integer;
    }
    
    public static void main(String args[])
    {
    	int[] a = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
    	System.out.printf("%d\n", singleNumber(a) );
    }
    */
	
	/*
	 public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
		}
	 
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1=l1,p2=l2,p3=new ListNode(0),list=p3;
        int carry=0;
        
        while(p1 != null || p2 != null)
        {
        	if(p1!=null)
        	{
        		carry+=p1.val;
        		p1=p1.next;
        	}
        	if(p2!=null)
        	{
        		carry+=p2.val;
        		p2=p2.next;
        	}
        	p3.val = carry%10;
        	carry=carry/10;
        	
        	if(p1 != null || p2 != null)
        	{
        		p3.next = new ListNode(0);
        		p3=p3.next;
        	}
        }
        
        if(carry!=0)
        {
        	p3.next = new ListNode(1);
        }
        
        return list;
    }
    */
	
	

	/*
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode perm=null,pn,aftern,pt,ptt,newHead=new ListNode(0);
        newHead.next=head;
        int count;
        
        if(m==n)
        {
        	return head;
        }
        
        //System.out.printf("newHead.next.val = %d\n",newHead.next.val);
        
        count=0;
        pt=newHead;
        while(count < m)
        {
        	perm=pt;
        	pt=pt.next;
        	count++;
        }
        //System.out.printf("perm.val = %d\n",perm.val);
        
        count=0;
        pt=newHead;
        do
        {
        	pt=pt.next;
        	pn=pt;
        	count++;
        }
        while(count != n);
        aftern=pn.next;
        //System.out.printf("pn.val = %d\n",pn.val);
        
        ptt=perm.next;				//要调整列表
        pn.next=null;
        
        perm.next=aftern;
        pt=perm;
        
        
        while(ptt!=null)
        {
        	ListNode t = ptt;
        	ptt=ptt.next;
        	t.next=pt.next;
        	pt.next=t;
        }
        
        return newHead.next;
    }

    public static void main(String[] args)
    {
    	ListNode a=new ListNode(3);
    	ListNode b=new ListNode(5);
    	a.next=b;
    	b.next=null;
    	ListNode c=reverseBetween(a,1,2);
    	while(c!=null)
    	{
    		System.out.printf("%d ", c.val);
    		c=c.next;
    	}
    }
    */
	
	
	/*
    public static ListNode partition(ListNode head, int x) {
        ListNode list1=new ListNode(0),list2=new ListNode(0);
        ListNode t=list1,th=list2;
        t.next=head;
        
        //System.out.printf("t.next.val=%d,head.val=%d\n", t.next.val,head.val);
        
        if(head==null || head.next==null)
        {
        	return head;
        }
        
        while(t!=null && t.next!=null)
        {
        	if(t.next.val>=x)
        	{
        		ListNode h;
        		h=t.next;
        		t.next=h.next;
        		h.next=null;
        		th.next=h;
        		th=th.next;
        	}
        	else
        	{
        		t=t.next;
        	}
        }
        
        th.next=null;							//做结束标记
        t.next=list2.next;
        
        return list1.next;
    }
    
    public static void main(String[] args)
    {
    	ListNode a=new ListNode(3);
    	a.next=null;
//    	ListNode b=new ListNode(5);
//    	a.next=b;
//    	b.next=null;
    	ListNode c=partition(a,0);
    	while(c!=null)
    	{
    		System.out.printf("%d ", c.val);
    		c=c.next;
    	}
    }
    */
	
	/*
    public ListNode deleteDuplicates(ListNode head) {
        ListNode t=head;
        
        while(t!=null && t.next!=null)
        {
        	if(t.val == t.next.val)
        	{
        		ListNode h=t.next;
        		t.next=h.next;
        	}
        	else
        	{
        		t=t.next;
        	}
        }
        
        return head;
    }
    */
	
	
	/*
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode list=new ListNode(0),t,th;
    	list.next=null;
    	th=list;
    	t=head;
    	
    	while(t!=null)
    	{
    		if(t.next==null || t.next.val != t.val)
    		{
    			th.next=t;
    			t=t.next;					//在该处要移动t
    			th=th.next;
    			th.next=null;
    		}
    		else
    		{
    			ListNode tm=t.next.next;
    			while(tm!=null && t.val==tm.val)
    			{
    				tm=tm.next;
    			}
    			t=tm;
    		}
    	}
    	
    	return list.next;
    }
    */
	
	
	/*
    public ListNode rotateRight(ListNode head, int k) {
        ListNode list=new ListNode(0),t,r;
        list.next=head;
        int count=0;
        
        
        for(t=list;t.next!=null;t=t.next)
        {
        	count++;
        }
        r=t;
        
        if(count==0||count==1||k==0)
        {
        	return head;
        }
        
        k=k%count;
        if(count==0||count==1||k==0)
        {
        	return head;
        }
        count=count-k;
        
        t=list;
        while(count-->0)
        {
        	t=t.next;
        }
        
        r.next=list.next;
        list.next=t.next;
        t.next=null;
        
        
        return list.next;
    }
    */
	
	/*
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode list=new ListNode(0);
        list.next=head;
        ListNode p=list,q=list;
        int count;
        
        if(head==null)
        {
        	return head;
        }
        for(count=0;count<n;count++)
        {
        	q=q.next;
        }
        while(q!=null && q.next!=null)
        {
        	p=p.next;
        	q=q.next;
        }
        ListNode t;
        t=p.next;
        p.next=t.next;
        t.next=null;
        
        return list.next;
    }
    */
	
	
	
	
	/*
    public ListNode swapPairs(ListNode head) {
        ListNode list=new ListNode(0),p,q;
        list.next=head;
        boolean flag=false;
        
        if(head==null||head.next==null)
        {
        	return head;
        }
        
        p=list;
        q=p.next.next;
        
        
        while(!flag)
        {
        	if(q.next==null||q.next.next==null)
        	{
        		flag=true;
        	}
	        p.next.next=q.next;
	        q.next=p.next;
	        p.next=q;
	        
	        if(!flag)
	        {
	        	p=p.next.next;
	        	q=q.next.next.next;
	        }
        }
        
        return list.next;
    }
   */
	
	
	/*
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode list=new ListNode(0),p,pk,np,t,th;
        list.next=head;
        
        if(k<=1||head==null)
        {
        	return head;
        }
        
        
        for(pk=list,p=pk;pk.next!=null;pk=np,p=pk)
        {
            int count=k;
            while(count>0)
            {
            	count--;
            	pk=pk.next;
            	
            	if(count>=0&&pk==null)//>=0
            	{
            		return list.next;
            	}
            }
            t=p.next;
            np=p.next;
            p.next=pk.next;
            pk.next=null;
            
            while(t!=null)
            {
            	th=t;
            	t=th.next;
            	th.next=p.next;
            	p.next=th;
            }
        }
        
        return list.next;
    }
    */
	
	
	/*
    public void reorderList(ListNode head) {
        ListNode slow,fast,h,t,th;
        slow=fast=head;
    	
        if(head==null||head.next==null)
        {
        	return;
        }
        
    	while(fast.next!=null&&fast.next.next!=null)
    	{
    		slow=slow.next;
    		fast=fast.next.next;
    	}
    	
    	if(fast.next==null)
    	{
    		th=slow.next.next;
    	}
    	else
    	{
    		th=slow.next;
    	}
    	
    	h=null;
    	while(th!=null)//逆序
    	{
    		t=th;
    		th=th.next;
    		t.next=h;
    		h=t;
    	}
    	
    	slow=head;
    	fast=h;
    	while(fast!=null)
    	{
    		t=slow;
    		slow=slow.next;
    		
			th=fast;
			fast=fast.next;
			
			h=th.next;
			th.next=t.next;
			t.next=th;
    	}
    }
    */
	
	
	/*
    public boolean isPalindrome(String s)
    {
		if(s==null||s.length()==0) 
			return true;
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		for(int i = 0; i < s.length() ; i++)
		{
			if(s.charAt(i) != s.charAt(s.length() - 1 - i))
			{
				return false;
			}
		}
		return true;
	}
    */
	
	/*
    public int myAtoi(String str) {
    	long result=0;
    	int i=0,single=1;
    	
    	str=str.trim();
    	
    	if(str.length()==0)
    	{
    		return (int)result;
    	}
    	
    	if(str.charAt(i)=='-')
    	{
    		single=-1;
    		i++;
    	}
    	else if(str.charAt(i)=='+')
    	{
    		single=1;
    		i++;
    	}
    	
    	while(i<str.length())
    	{
    		char ch = str.charAt(i);
    		if(ch>='0' && ch<='9')
    		{
    			result=result*10 + ch-'0';
    			i++;
    			
    	    	if(single*result>=Integer.MAX_VALUE)	//!!!必须在这里面判断
    	    	{
    	    		return Integer.MAX_VALUE;
    	    	}
    	    	else if(single*result<=Integer.MIN_VALUE)
    			{
    				return Integer.MIN_VALUE;
    			}
    		}
    		else
    		{
    			break;
    		}
    	}
    	
    	return single*(int)result;
    }
    */
    
	/*
    public static String addBinary(String a, String b) {
        String c="";
        int ia=a.length()-1;
        int ib=b.length()-1;
        int carry=0;
        
        while(ia>=0||ib>=0)
        {
        	int ta=0,tb=0;
        	
        	if( (ia>=0) && (a.charAt(ia)=='1') )
        	{
        		ta=1;
        	}        	
        	if( (ib>=0) && (b.charAt(ib)=='1') )
        	{
        		tb=1;
        	}
        	c=(ta+tb+carry)%2 + c;//注意C的位置
        	carry=(ta+tb+carry)/2;
        	ia--;
        	ib--;
        }
        return carry==1?1+c:c;
    }
    
    
    public static void main(String[] args)
    {
    	System.out.printf("%s", addBinary("1010","1011"));
    }
    */
	
	/*
    public String longestCommonPrefix(String[] strs) {
        String str="";
        if (strs == null || strs.length == 0)  
            return str;
        for(int i=0;i<strs[0].length();i++)
        {
        	char ch=strs[0].charAt(i);
        	for(int j=0;j<strs.length;j++)
        	{
        		if(i>=strs[j].length() || ch!=strs[j].charAt(i))
        		{
        			return str;
        		}
        	}
        	str+=ch;
        }
        
        return str;
    }
    */
	
	
	/*
    public String intToRoman(int num) {
        String res="";
        
        String[][] table = 
        	{  
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},  
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},  
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},   
                {"", "M", "MM", "MMM"}  
            };
        for(int i=0,t=num;t>0;i++)
        {
        	res = table[i][t%10] + res;
        	t/=10;
        }
        
        return res;
    }
    */
	
	
	/*
	int toNumber(char ch) {  
        switch (ch) {  
            case 'I': return 1;  
            case 'V': return 5;  
            case 'X': return 10;  
            case 'L': return 50;  
            case 'C': return 100;  
            case 'D': return 500;  
            case 'M': return 1000;  
        }  
        return 0;  
    } 
	
    public int romanToInt(String s) {
        int res=0;
        
        if(s==null)
        {
        	return res;
        }
        
        res = toNumber(s.charAt(0));
        for(int i=1;i<s.length();i++)
        {
        	int t1=toNumber(s.charAt(i-1));
        	int t2=toNumber(s.charAt(i));
        	if(t1 < t2)
        	{
        		res = res-t1 + t2 -t1;
        	}
        	else
        	{
        		res+=t2;
        	}
        }
        
        return res;
    }
    */
	
	
	/*
    public String countAndSay(int n) {
    	String str="";
    	
    	for(int tmp=n,nump=n%10,count=1;tmp>0;tmp/=10,nump=tmp%10)
    	{
    		if(0==tmp/10)
    		{
    			str = count + "" + nump + str;
    			break;
    		}
    		else
    		{
    			if(nump==tmp%10)
    			{
    				count++;
    			}
    			else
    			{
        			str = count + nump + str;
        			count=1;
    			}
    		}
    	}
    	
    	
        return str;
    }
    */
	
	/*
    public String countAndSay(int n) {
    	String str="1";
		
    	for(int i=1;i<n;i++)
    	{
    		int count=1;
    		StringBuilder sb = new StringBuilder(); 
    		
    		for(int j=1;j<str.length();j++)
    		{
    			if(str.charAt(j)==str.charAt(j-1))
    			{
    				count++;
    			}
    			else
    			{
    				sb.append(count);
    				sb.append(str.charAt(j-1));
        			count=1;
    			}
    		}
    		
			sb.append(count);
			sb.append(str.charAt(str.length()-1));
    		
    		str = sb.toString();
    	}
    	
        return str;
    }
    */
	
	/*
	public ArrayList<String> anagrams(String[] strs) 
	{
		ArrayList<String> list = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		    
	    for (int i = 0; i < strs.length; ++i) 
	    {
			 char[] chars = strs[i].toCharArray();		//转化为字符串数组
			 
			 Arrays.sort(chars);						//进行排序
			 String anagram = new String(chars);		//组成排序字符串
			 
			 if(map.containsKey(anagram))				//HashMap中存在该串 
			 {
				 int index = map.get(anagram);
				 if (index != -1)						//首次匹配，将之前的串加入List
				 {
					 list.add(strs[index]);
					 map.put(anagram, -1);				//用-1标识第一次出现的重排列字符串
				 }
				 list.add(strs[i]);						//将新串加入List
			 } 
			 else 
			 {
				 map.put(anagram, i);					//HashMap中不存在该串
			 }

	    }
	    
	    return list;
   }
	*/
	
	
	
	/*
	public String simplifyPath(String path) 
	{
    	//将//都简化成/
        path = path.replaceAll("/{2,}","/");
        Stack<String> st = new Stack<String>();
        //按/分割数组
    	String[] p = path.split("/");
    	for(int i = 0; i < p.length; i++){
    		//..表示后退一个路径
    		if(p[i].equals("..")){
    			 if(!st.isEmpty())//不为空才后退
    				 st.pop();
    		}
    		//.忽视，表示当前路径
    		else if(!p[i].equals(".") ){
    			st.push(p[i]);
    		}
    	}
        //现在栈里的就是简化的路径
        String s = "";
        while(!st.isEmpty()){
            s = "/" + st.pop() + s;//先进后出
        }
        s = "/" + s;//补上开头的/
        if(s.length() > 1)
        	s = s.replaceAll("/{1,}", "/");//去除结尾的/
        return s;
    }
	*/
	
	/*
    public int lengthOfLastWord(String s) {
        int len=0;
        
        for(int i=s.length()-1;i>=0;i--)
        {
        	if(s.charAt(i)!=' ')
        	{
        		while(i>=0&&s.charAt(i)!=' ')
	    		{
	    			i--;
	    			len++;
	    		}
        		break;
        	}
        }
        
        return len;
    }
    */
	
	/*
    public boolean isValid(String s) {
        Stack<Character> sk = new Stack<Character>();
        
        for(int i=0;i<s.length();i++)
        {
        	char sch = s.charAt(i);
        	
        	if(!sk.isEmpty())
        	{
        		char ch = sk.peek();
        		
        		if(ch=='('&&sch==')' || ch=='['&&sch==']' || ch=='{'&&sch=='}')
        		{
        			sk.pop();
        			continue;
        		}
            	else
            	{
            		sk.push(sch);
            	}
        	}
        	else
        	{
        		sk.push(sch);
        	}
        }
        
        if(sk.isEmpty())
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }
    */
	
	
	/*
    public int longestValidParentheses(String s) {
    	int len=0,max=0;
        Stack<Character> sk = new Stack<Character>();
        
        for(int i=0;i<s.length();i++)
        {
        	char sch = s.charAt(i);
        	
        	if(!sk.isEmpty())
        	{
        		if(sch == ')')
        		{
        			sk.pop();
        			len+=2;
        			continue;
        		}
            	else
            	{
            		sk.push(sch);
            		max=len>max?len:max;
            		len=0;
            		if(sch == '(')
            		{
            			
            		}
            	}
        	}
        	else
        	{
        		max=len>max?len:max;
        		len=0;
        		if(sch == '(')
        		{
        			sk.push(sch);
        		}
        	}
        }
        return max;
    }
    */
    
	
	/*
    public int evalRPN(String[] tokens) {
        Stack<Integer> num = new Stack<Integer>();
        
        for(int i=0;i<tokens.length;i++)
        {
        	int t1,t2;
        	
        	switch(tokens[i].trim())
        	{
	        	case "+":
	        		t1=num.pop();t2=num.pop();num.push(t2+t1);
	        		break;
	        	case "-":
	        		t1=num.pop();t2=num.pop();num.push(t2-t1);
	        		break;
	        	case "*":
	        		t1=num.pop();t2=num.pop();num.push(t2*t1);
	        		break;
	        	case "/":
	        		t1=num.pop();t2=num.pop();num.push(t2/t1);
	        		break;
	        	default:
	        		num.push(Integer.valueOf(tokens[i].trim()));
	        		break;
        	}
        }
        
        return num.pop();
    }
    */
    
	/*
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        while(root!=null || !st.isEmpty())
        {
        	while(root!=null)
        	{
        		list.add(root.val);
        		st.push(root);
        		root=root.left;
        	}
        	root=st.pop();
        	root=root.right;
        }
        
        return list;
    }
    */
    
	/*
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        while(root!=null || !st.isEmpty())
        {
        	while(root!=null)
        	{
        		st.push(root);
        		root=root.left;
        	}
        	root=st.pop();
        	list.add(root.val);
        	root=root.right;
        }
        
        return list;
    }
    */
	
	
	/*
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        while(root!=null || !st.isEmpty())
        {
        	while(root!=null)
        	{
        		list.add(root.val);
        		st.push(root);
        		root=root.right;
        	}
        	root=st.pop();
        	root=root.left;
        }
        
        for(int i=0,len = list.size()-1;len>0 && i<=len/2;i++)
        {
        	int tmp;
        	tmp=list.get(i);
        	list.set(i,list.get(len-i));
        	list.set(len-i,tmp);
        }
        
        return list;
    }
    */
	
	/*
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	Queue<TreeNode> st = new LinkedList<TreeNode>();
    	
    	if(root != null)
    	{
    		st.add(root);
    	}
    	
    	while(!st.isEmpty())
    	{
    		TreeNode tmp;
    		List<Integer> ls = new ArrayList<Integer>();
    		Queue<TreeNode> sst = new LinkedList<TreeNode>();
    		
    		while(!st.isEmpty())
			{
    			tmp = st.poll();
    			if(tmp.left!=null)
    			{
    				sst.add(tmp.left);
    			}
    			if(tmp.right!=null)
    			{
    				sst.add(tmp.right);
    			}
    			
    			ls.add(tmp.val);
			}
    		
    		st = sst;
    		list.add(ls);
    	}
    	
    	return list;
    }
    */
	
	
	/*
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	boolean left2right=true;
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	
    	if(root != null)
    	{
    		st.add(root);
    	}
    	
    	while(!st.isEmpty())
    	{
    		TreeNode tmp;
    		
    		Stack<TreeNode> sst = new Stack<TreeNode>();
    		List<Integer> ls = new ArrayList<Integer>();
    		while(!st.isEmpty())
			{
    			tmp = st.pop();
    			ls.add(tmp.val);
    			if(!left2right)
    			{
        			if(tmp.right!=null)
        			{
        				sst.add(tmp.right);
        			}
        			if(tmp.left!=null)
        			{
        				sst.add(tmp.left);
        			}
    			}
    			else
    			{
    				if(tmp.left!=null)
	    			{
	    				sst.add(tmp.left);
	    			}
	    			if(tmp.right!=null)
	    			{
	    				sst.add(tmp.right);
	    			}
    			}
			}
    		
    		left2right=left2right?false:true;
    		st = sst;
    		list.add(ls);
    	}
    	
    	return list;
    }
    */
	
	
	/*
    public static void recoverTree(TreeNode root) {
        TreeNode pr1=null,r1=null,pr2=null,r2=null;
        Stack<TreeNode> st = new Stack<TreeNode>();
        int perValue=Integer.MAX_VALUE;
        
        while(root!=null || !st.isEmpty())
        {
        	while(root!=null)
        	{
        		//TreeNode ssroot=root;
        		st.add(root);
        		root=root.right;//left;
        	}
        	root=st.pop();
        	if(perValue>=root.val)
        	{
        		if(r1==null)
        			pr1=root;
        		else
        			pr2=root;
        	}
        	else
        	{
        		if(r1==null)
        			r1=root;
        		else
        			r2=root;
        	}
        	perValue=root.val;
        	root=root.left;//right;
        }
        
        if(r2==null)
        {
        	int t=pr1.val;
        	pr1.val=r1.val;
        	r1.val=t;
        }
        else
        {
        	int t=pr1.val;
        	pr1.val=r2.val;
        	r2.val=t;
        }
    }
    
    public static void main(String[] args)
    {
    	TreeNode t1=new TreeNode(0),t2=new TreeNode(1);
    	
    	t1.right=t2;
    	recoverTree(t1);
    }
    */
	
	/*
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	Stack<TreeNode> s1=new Stack<TreeNode>();
    	Stack<TreeNode> s2=new Stack<TreeNode>();
    	
    	while( (p!=null&&q!=null) || (!s1.isEmpty()&&!s2.isEmpty()) )
    	{
    		while(p!=null&&q!=null)
    		{    			
    			if(p.val!=q.val)
    			{
    				return false;
    			}
    			s1.push(p);
    			s2.push(q);
    			p=p.left;
    			q=q.left;
    		}
    		if(p!=null || q!=null)
    		{
    			return false;
    		}
    		p=s1.pop().right;
    		q=s2.pop().right;
    	}
    	
		if(p!=null || q!=null || !s1.isEmpty() || !s2.isEmpty())
		{
			return false;
		}
		
    	return true;
    }
    */
	
	
	/*
    public boolean isSymmetric(TreeNode root) {
    	Stack<TreeNode> s1=new Stack<TreeNode>();
    	Stack<TreeNode> s2=new Stack<TreeNode>();
    	TreeNode p,q;
    	
    	if(root!=null)
    	{
    		p=root.left;
    		q=root.right;
    	}
    	else
    	{
    		return true;
    	}
    	
    	while( (p!=null&&q!=null) || (!s1.isEmpty()&&!s2.isEmpty()) )
    	{
    		while(p!=null&&q!=null)
    		{    			
    			if(p.val!=q.val)
    			{
    				return false;
    			}
    			s1.push(p);
    			s2.push(q);
    			p=p.left;
    			q=q.right;
    		}
    		if(p!=null || q!=null)
    		{
    			return false;
    		}
    		p=s1.pop().right;
    		q=s2.pop().left;
    	}
    	
		if(p!=null || q!=null || !s1.isEmpty() || !s2.isEmpty())
		{
			return false;
		}
		
    	return true;
    }
    */
	
	/*
	public int height(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		else
		{
			if(root.left==null)
			{
				return height(root.right)+1;
			}
			else if(root.right==null)
			{
				return height(root.left)+1;
			}
			else
			{
				return 1+ Math.max(height(root.left),height(root.right));
			}
		}
	}
	
    public boolean isBalanced(TreeNode root) {
        if(root == null)
        {
        	return true;
        }
        else
        {
        	int l=height(root.left);
        	int r=height(root.right);
        	if(Math.abs(l-r)>1)
        	{
        		return false;
        	}
        	else
        	{
        		return isBalanced(root.left) && isBalanced(root.right);
        	}
        }
    }
    */
    
	/*
    public void flatten(TreeNode root) {
    	if(root!=null)
    	{
    		TreeNode sroot=root,left=root.left,right=root.right;
    		flatten(left);
    		flatten(right);
    		
    		if(left!=null)
    		{
    			sroot=left;
    			while(sroot!=null && sroot.right!=null)
    			{
    				sroot=sroot.right;
    			}
        		sroot.right=right;
        		root.right=left;
        		root.left=null;
    		}
    	}
    }
    */
	

	/*
	public void connect(TreeLinkNode root) {
		 if(root==null)
			 return;
		 
		 TreeLinkNode per=new TreeLinkNode(0),save=per;
		 while(root!=null)
		 {
			 TreeLinkNode tmp=null;
			 if(root.left!=null||root.right!=null)
			 {
				 if(root.left!=null)
				 {
					 root.left.next=root.right;
					 tmp=root.left;
				 }
				 else
				 {
					 tmp=root.right;
				 }
			 }
			 if(tmp!=null)
			 {
				 per.next=tmp;
				 do
				 {
					 per=per.next;
				 }
				 while(per.next!=null);
			 }
			 root=root.next;
		 }
		 connect(save.next);
	 }
	*/
	
	
	/*
	public TreeNode build(int[] preorder,int[] inorder,int start,int end)
	{
    	if(cur>=preorder.length || start>=end)	return null;
    	
		int t=preorder[cur],incur=start;
		TreeNode root=new TreeNode(t);
    	
    	while(t!=inorder[incur])	incur++;
        
        cur++;
        root.left=build(preorder,inorder,start,incur);
        root.right=build(preorder,inorder,incur+1,end);
        
        return root;
    }
	
	public int cur=0;
    public TreeNode buildTree(int[] preorder,int[] inorder) {
        
        return build(preorder,inorder,0,inorder.length);
    }
    */
    
	
	/*
	public TreeNode build(int[] postorder,int[] inorder,int start,int end)
	{
    	if(cur<0 || start>=end)	return null;
    	
		int t=postorder[cur],incur=start;
		TreeNode root=new TreeNode(t);
    	
    	while(t!=inorder[incur])	incur++;
        
        cur--;
        root.right=build(postorder,inorder,incur+1,end);
        root.left=build(postorder,inorder,start,incur);
        
        return root;
    }

	public int cur;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        cur=postorder.length-1;
    	return build(postorder,inorder,0,inorder.length);
    }
    */
	
	
	/*
    public int numTrees(int n) {
        int sum=0;
        
        if(n==0||n==1)
        {
        	return 1;
        }
        
        for(int i=0;i<n;i++)
        {
        	sum+=numTrees(i)*numTrees(n-i-1);
        }
        
        return sum;
    }
    */
	/*
    public int numTrees(int n) {
        if(n==0||n==1)
        {
        	return 1;
        }
        
        int[] dp = new int[n+1];
        dp[0]=dp[1]=1;
        
        for(int j=2;j<=n;j++)
        {
        	dp[j]=0;
	        for(int i=1;i<=j;i++)
	        {
	        	dp[j]+=dp[i-1]*dp[j-i];
	        }
        }
        
        return dp[n];
    }
    */
    
	/*
    public List<TreeNode> generateTrees(int n) {
    	List<List<TreeNode>> list = new LinkedList<List<TreeNode>>();
    	if(n==0)
    	{
    		list.add(null);
    	}
        if(n==1)
        {
        	List<TreeNode> l = new LinkedList<TreeNode>();
        	TreeNode t = new TreeNode(1);
        	l.add(t);
        	list.add(l);
        }
        
        for(int j=2;j<=n;j++)
        {
        	List<TreeNode> l = new LinkedList<TreeNode>();
	        for(int i=1;i<=j;i++)
	        {
	        	TreeNode t = new TreeNode(j);
	        }
        }
        
        return list.get(n);
        
        
        
        int[] dp = new int[n+1];
        dp[0]=dp[1]=1;
        
        for(int j=2;j<=n;j++)
        {
        	dp[j]=0;
	        for(int i=1;i<=j;i++)
	        {
	        	dp[j]+=dp[i-1]*dp[j-i];
	        }
        }
        
        return dp[n];
    }
    */
	
	
	/*
	public List<TreeNode> generate(int s,int e) {
		List<TreeNode> l = new LinkedList<TreeNode>();
		
		if(s==e)
		{
			l.add(null);
			return l;
		}
		if(s+1==e)
		{
			TreeNode t = new TreeNode(s);
			l.add(t);
			return l;
		}
		
        for(int i=s;i<e;i++)
        {
        	List<TreeNode> left=generate(s,i);
        	List<TreeNode> right=generate(i+1,e);
        	for(int j=0;j<left.size();j++)
        	{
        		for(int k=0;k<right.size();k++)
        		{
        			TreeNode t = new TreeNode(i);
        			t.left=left.get(j);
        			t.right=right.get(k);
        			l.add(t);
        		}
        	}
        }
        return l;
	}
	
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> l = new LinkedList<TreeNode>();
		
        return generate(1,n+1);
	}
	*/
	
	/*
    public boolean isValidBST(TreeNode root) {
//		该算法不可以，只能保证局部有序
//    	if(root==null)
//    	{
//    		return true;
//    	}
//		if(((root.left==null || root.val>root.left.val) && (root.right==null || root.val<root.right.val)))
//    	{
//			if((isValidBST(root.left)&&isValidBST(root.right)))
//			{
//				return true;
//			}
//    	}
//    	return false;
    	
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	boolean flag=false;
    	int cur=0;
    	
    	while(root!=null || !st.isEmpty())
    	{
    		while(root!=null)
    		{
    			st.add(root);
    			root=root.left;
    		}
    		root = st.pop();
    		if(!flag)
    		{
    			cur=root.val;
    			flag=true;
    		}
    		else
    		{
    			if(cur>=root.val)
    				return false;
    			cur = root.val;
    		}

    		root = root.right;
    	}
    	return true;
    }
	*/
	
	
	/*
	public TreeNode sortedArrayToBST(int[] nums,int s,int e) {
		if(s>=e)
			return null;
		
		int mid;
		mid=(s+e)/2;
		TreeNode t = new TreeNode(nums[mid]);
		t.left=sortedArrayToBST(nums,s,mid);
		t.right=sortedArrayToBST(nums,mid+1,e);			//mid+1
		
		return t;
	}
    public TreeNode sortedArrayToBST(int[] nums) {
    	
        return sortedArrayToBST(nums,0,nums.length);	//length
    }
	*/
	
	/*
    private ListNode end = null;
    public TreeNode sortedListToBST(ListNode head) {
        end = head;
        ListNode c = head;
        int count = 0;
        while(c!=null){
            count++;
            c = c.next;
        }
        return convert(head, count);
    }


    private TreeNode convert(ListNode n, int count){
        if(count==0){ 
            return null;
        }
        int m = count/2;
        TreeNode left = convert(n, m);
        TreeNode ret = new TreeNode(end.val);
        end = end.next;
        ret.left = left;
        ret.right = convert(end, count-m-1);
        return ret;
    }
    */
	
	
	/*
	public int minDepth(TreeNode root,int deep) {
		if(root==null){return deep;}
		deep++;
		int left = minDepth(root.left,deep);
		int right = minDepth(root.right,deep);
		if(left==deep||right==deep)
		{
			return left>right?left:right;
		}
		else
		{
			return left>right?right:left;
		}
	}
	
    public int minDepth(TreeNode root) {
    	if(root==null){return 0;}
    	return minDepth(root,0);
    }
    */
	
	/*
	public int maxDepth(TreeNode root,int deep) {
		if(root==null){return deep;}
		deep++;
		int left = maxDepth(root.left,deep);
		int right = maxDepth(root.right,deep);
		return left>right?left:right;
	}
	
	public int maxDepth(TreeNode root) {
    	if(root==null){return 0;}
    	return maxDepth(root,0);
    }
	*/
	
	
	/*
    public boolean hasPathSum(TreeNode root, int sum) {
    	
    	if(root==null)	return false;
    	
    	sum-=root.val;
    	if(root.right==null&&root.left==null&&sum==0)	return true;
    		
    	return hasPathSum(root.left,sum)||hasPathSum(root.right,sum);
    }
    */
	
	
	/*
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    ArrayList<Integer> path = new ArrayList<Integer>();
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        getSum(root, 0, sum);
        return result;
    }
	public void getSum(TreeNode root, int sum, int target){
		if(root == null) return;
		sum+= root.val;
		path.add(root.val);
		if(root.left == null && root.right == null && sum== target)
			result.add(new ArrayList<>(path));
		getSum(root.left, sum, target);
		getSum(root.right, sum, target);
		sum-=root.val;
		path.remove(path.size()-1);
		return;
	}
	*/
	
	
	/*
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    ArrayList<Integer> path = new ArrayList<Integer>();
    
    public void path(TreeNode root,int sum)
    {
    	if(root==null)	
    		return;
    	
    	path.add(root.val);
    	
    	sum-=root.val;
    	if(root.right==null&&root.left==null&&sum==0)	
    	{
    		list.add(new ArrayList<Integer>(path));
    	}
    	path(root.left,sum);
    	path(root.right,sum);
    	
    	path.remove(path.size()-1);
    	
    	return;
    }
    
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	path(root,sum);
		return list;
    }
	*/
	
	/*
	private static int maxValue;
    
    public static int maxPathSum(TreeNode root) {
        maxValue = root == null ? 0 : root.val;
        findPath(root);
        return maxValue;
    }
    
    public static int findPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = Math.max(findPath(root.left), 0);
        int right = Math.max(findPath(root.right), 0);
        
        maxValue = Math.max(maxValue, root.val + left + right);
        
        int current = Math.max(root.val, Math.max(root.val + left, root.val + right));
                
        return current;
    }
    */
	
	
	/*
    public void connect(TreeLinkNode root) {
    	if(root==null) return;
    	
    	TreeLinkNode p = new TreeLinkNode(-1),head= p;
    	while(root!=null)
    	{
    		if(root.left!=null)
    		{
    			p.next=root.left;
    			p=p.next;
    		}
    		if(root.right!=null)
    		{
    			p.next=root.right;
    			p=p.next;
    		}
    		root=root.next;	
    	}
    	connect(head.next);
    }
    */

	
	/*
	private int sum=0,sub=0;
	
    public void sum(TreeNode root) {
    	if(root==null)
    		return;
    	
        sub = root.val + sub*10;
        
    	if(root.left==null && root.right==null)
    		sum+=sub;
    	
    	if(root.left!=null || root.right!=null)
    	{
    		sum(root.left);
    		sum(root.right);
    	}
    	
        sub = sub/10;
    }
    
    public int sumNumbers(TreeNode root) {
    	sum(root);
    	
    	return sum;
    }
    */
    
	/*
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int cur=m+n-1;
    	n--;
    	m--;
    	
    	while(m>=0&&n>=0)
    		nums1[cur--] = nums1[m]>nums2[n]?nums1[m--]:nums2[n--];
    	while(n>=0)
    		nums1[cur--] = nums2[n--];
    }
    */
    
	/*
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1),t=head;
    	
        while(l1!=null&&l2!=null)
        {
        	if(l1.val<l2.val)
        	{
        		t.next = l1;
        		l1=l1.next;
        	}
        	else
        	{
        		t.next = l2;
        		l2=l2.next;
        	}
        	t = t.next;
        }
        t.next = l1!=null?l1:l2;
        
    	return head.next;
    }
    */
	
	
	
	/*
    public ListNode insertionSortList(ListNode head) {
        ListNode h = new ListNode(Integer.MIN_VALUE),t=h,tp;
    	
        while(head!=null)
        {
        	int val = head.val;
        	t=h;// 回复指针
        	while(t.next!=null && t.next.val<val)//循环条件
        	{
        		t=t.next;
        	}
        	
        	tp=t.next;
        	t.next=head;
        	head=head.next;
        	t.next.next=tp;
        }
    	
    	return h.next;
    }
    */
    
	/*
    public ListNode sortList(ListNode head) {
        ListNode h = new ListNode(Integer.MIN_VALUE),t=h,tp;
    	
        while(head!=null)
        {
        	int val = head.val;
        	t=h;// 回复指针
        	while(t.next!=null && t.next.val<val)//循环条件
        	{
        		t=t.next;
        	}
        	
        	tp=t.next;
        	t.next=head;
        	head=head.next;
        	t.next.next=tp;
        }
    	
    	return h.next; 
    }
	*/
	
	
	
	/*
	//heap sort
	public static void BuildHeap(int[] array,int s,int e)
	{
		if(2*s+1<e && array[2*s+1]<array[2*s] && array[2*s+1]<array[s])
		{
			int tmp = array[2*s+1];
			array[2*s+1]=array[s];
			array[s]=tmp;
			BuildHeap(array,2*s+1,e);
		}
		if(2*s<e && array[2*s]<array[s])
		{
			int tmp = array[2*s];
			array[2*s]=array[s];
			array[s]=tmp;
			BuildHeap(array,2*s,e);
		}
	}
	public static void HeapSort(int[] array)
	{
		//build init
		for(int i=(array.length-1)/2;i>=0;i--)
		{
			BuildHeap(array,i,array.length);
		}
		
		
		//sort
		for(int i=array.length-1;i>=0;i--)
		{
			int tmp=array[0];
			array[0]=array[i];
			array[i]=tmp;
			
			BuildHeap(array,0,i);
		}
	}
	 public static void main(String[] args)
	{
		int[] a = {1,8,2,9,3,0,4,8};
		HeapSort(a);
		for(int i=0;i<a.length;i++)
			System.out.printf("%d", a[i]);
	}
	 */
	 
	
	
	/*
	//Merge sort
	public ListNode sortList(ListNode head) {
		if(head==null || head.next==null)
			return head;
		
		ListNode fast=head,slow=head,tmp,root=new ListNode(0);
		
		while(fast!=null&&fast.next!=null&&fast.next.next!=null)
		{
			fast=fast.next.next;
			slow=slow.next;	
		}
		tmp=slow;
		slow=slow.next;
		tmp.next=null;
		
		slow = sortList(slow);
		head = sortList(head);
		
		tmp = root;
		while(slow!=null&&head!=null)
		{
			if(slow.val<head.val)
			{
				tmp.next=slow;
				slow=slow.next;
			}
			else
			{
				tmp.next=head;
				head=head.next;
			}
			tmp=tmp.next;
		}
		
		tmp.next=slow!=null?slow:head;
		
		return root.next;
	}
	*/
	
	
	
	/*
    public int firstMissingPositive(int[] nums) {
        if(nums.length==0) return 1;//边界条件
        
        int i=0;
    	
        for(int j=0;j<nums.length;j++)
        {
        	while(nums[j]>0 && nums[j]!=j+1&&nums[j]-1<nums.length&&nums[nums[j]-1]!=nums[j])//已经在正确位置时不交换
        	{
        		int tmp = nums[nums[j]-1];
        		nums[nums[j]-1]=nums[j];
        		nums[j]=tmp;
        	}
        }
        for(i=0;i<nums.length;i++)
        {
        	if(nums[i]!=i+1)
        	{
        		break;
        	}
        }
    	
    	return i+1;//位置转为值
    }
    */
	
	
	/*
	void sortColors(int[] nums)   
    {  
        int n=nums.length,r = 0, w = 0, b = n-1;  
        for (w = 0; w <= b; )  
        {  
        	int tmp;
        	
            switch (nums[w])  
            {  
	            case 0:  
	                tmp=nums[r];
	                nums[r++]=nums[w];
	                nums[w++]=tmp;
	                break;  
	  
	            case 1:  
	                w++;  
	                break;  
	  
	            case 2:
	                tmp=nums[w];
	                nums[w]=nums[b];
	                nums[b--]=tmp;
	                break;
            }  
        }  
    }
	*/
	
	
	/*
    public int[] searchRange(int[] nums, int target) {
        
    	int high=nums.length-1,low=0,middle=0;
    	int[] res = {-1,-1};
    	
    	while(low<=high)
    	{
    		middle = (low+high)/2;
    		
    		if(nums[middle]>target)
    			high = middle-1;
    		else if(nums[middle]<target)
    			low = middle+1;
    		else
    		{
    			int p;
    			
    			p=middle;
    			while(low<=p)
    			{
    				if(nums[(p+low)/2]<target)
    					low=(p+low)/2+1;
    				else if(nums[low]<target)
    					p=(p+low)/2-1;
    				else
    					break;
    			}
    			
    			p=middle;
    			while(high>=p)
    			{
    				if(nums[(p+high)/2]>target)
    					high=(p+high)/2-1;
    				else if(nums[high]>target)
    					p=(p+high)/2+1;
    				else
    					break;
    			}
    			
    			res[0]=low;
    			res[1]=high;
    			break;
    		}
    	}
    	
    	return res;
    }
    */
	
	/*
    public int searchInsert(int[] nums, int target) {
        int low=0,high=nums.length-1,mid=0;
        
        while(high>=low)
        {
        	mid=(high+low)/2;
        	if(nums[mid]<target)
        		low=mid+1;
        	else if(nums[mid]>target)
        		high=mid-1;
        	else
        		return mid;
        }
        return low;
    }
    */
	
	
    /*
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0,high=0,mid=0,index=0;
        
        low=0;high=matrix.length-1;
        while(high>=low)
        {
        	mid=(high+low)/2;
        	if(matrix[mid][0]>target)
        		high=mid-1;
        	else if(matrix[mid][0]<target)
        		low=mid+1;
        	else
        		return true;
        }
        if(low==0)
        	return false;
        
        index=low-1;low=0;high=matrix[index].length-1;
        while(high>=low)
        {
        	mid=(high+low)/2;
        	if(matrix[index][mid]>target)
        		high=mid-1;
        	else if(matrix[index][mid]<target)
        		low=mid+1;
        	else
        		return true;
        }
        
        return false;
    }
    */
	
	
	
	/*
	List<List<Integer>> list = new LinkedList<List<Integer>>();
	List<Integer> t = new LinkedList<Integer>();
	
	public void getsets(int[] nums,int s,int n)
	{
		if(n<=0)
		{
			list.add(new LinkedList<Integer>(t));
			return;
		}
		
    	for(int i=s;i<=nums.length-n;i++)
    	{
    		t.add(nums[i]);
    		getsets(nums,i+1,n-1);
    		t.remove(t.size()-1);
    	}
	}
	
    public List<List<Integer>> subsets(int[] nums) {
    	Arrays.sort(nums);//题设只说没有重复元素，而结果需要升序，所以先进行排序
    	list.add(new LinkedList<Integer>(t));//空集为任何集合的子集，单独处理
    	
    	for(int j=0;j<nums.length;j++)
    	{
    		t.add(nums[j]);//以一个元素开头
    		for(int i=0;i<nums.length;i++)//依次搜索不同子集大小
    		{
    			getsets(nums,j+1,i);
    		}
    		t.remove(t.size()-1);
    	}
    	return list;
    }
    */
    
	
	/*
	List<List<Integer>> list = new LinkedList<List<Integer>>();
	List<Integer> t = new LinkedList<Integer>();
	
	public void getsets(int[] nums,int s,int e)//start and end
	{
		if(s>=e)
		{
			list.add(new LinkedList<Integer>(t));
			return;
		}
		
		int c=s+1;
		while(c<e && nums[s]==nums[c]) c++;
		for(int k=s-1;k<c;k++)
		{
    		getsets(nums,c,e);
    		t.add(nums[s]);//元素可为0~c-s个
		}
		for(int k=s-1;k<c;k++)
			t.remove(t.size()-1);
		
			
	}
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	Arrays.sort(nums);//题设只说没有重复元素，而结果需要升序，所以先进行排序
    	list.add(new LinkedList<Integer>(t));//空集为任何集合的子集，单独处理
    	
    	for(int j=0;j<nums.length;)
    	{
    		int c=j+1;
    		while(c<nums.length && nums[j]==nums[c]) c++;//计算元素重复次数
    		
    		for(int k=j;k<c;k++)//以同一元素重复次数为开头
    		{
	    		t.add(nums[k]);//必须加入一个元素
	    		getsets(nums,c,nums.length);
    		}
    		t.clear();
    		j=c;
    	}
    	return list;
    }
    */
	
	
	
	/*
	char[][] tab = {
						{'a','b','c'},
						{'d','e','f'},
						{'g','h','i'},
						{'j','k','l'},
						{'m','n','o'},
						{'p','q','r','s'},
						{'t','u','v'},
						{'w','x','y','z'}
					};
	List<String> str = new ArrayList<String>();
	StringBuffer ls=new StringBuffer();
	
	public void getString(String s,int n)
	{
		if(s.length()<=n)
		{
			str.add(new String(ls.toString()));
			return;
		}
		
		int cow=s.charAt(n)-'2';
		for(int i=0;i<tab[cow].length;i++)
		{
			ls.append(tab[cow][i]);
			getString(s,n+1);
			ls.deleteCharAt(ls.length()-1);
		}
	}
    public List<String> letterCombinations(String digits) {
    	if(digits.isEmpty())//字符串比较要用equal
    		return str;
    	
        getString(digits,0);
    	return str;
    }
    */
	
	/*
	//DFS
	List<List<String>> list = new LinkedList<List<String>>();
	List<String> sp = new LinkedList<String>();
	public String isPalindrome(StringBuffer st,int start,int end)
	{
		StringBuffer sub = new StringBuffer(st.substring(start, end));
		if((sub.toString()).equals(sub.reverse().toString()))
			return sub.toString();
		else
			return null;
	}
	public void getpartion(StringBuffer st,int start)
	{
		if(start>=st.length())
		{
			list.add(new LinkedList(sp));
			return;
		}
		for(int i=start;i<st.length();i++)
		{
			String ss = isPalindrome(st,start,i+1);
			if(ss!=null)
			{
				sp.add(ss);
				getpartion(st,i+1);
				sp.remove(sp.size()-1);
			}
		}
	}
    public List<List<String>> partition(String s) {
        if(s.isEmpty())
        	return list;
        
    	StringBuffer st = new StringBuffer(s);
        getpartion(st,0);
        
        return list;
    }
    */
	
	/*
	int count=0,cm=0,cn=0;
	public void getpath(int m,int n)
	{
		if(cm==m&&n==cn)
		{
			count++;
			return;
		}
		else if(cm<m||cn<n)
		{
			return;
		}
		
		getpath(m+1,n);
		getpath(m,n+1);
	}
	
    public int uniquePaths(int m, int n) {
        cm=m;cn=n;
        getpath(1,1);
        return count;
    }
	 */
	/*
	int[][] path;
	public int getpath(int m,int n)
	{
		if(1==m&&1==n)
			return 1;
		if(m<1||n<1)
			return 0;
		if(path[m][n]<=0)
			path[m][n]=getpath(m-1,n) + getpath(m,n-1);
		
	    return path[m][n];
	}
	
    public int uniquePaths(int m, int n) {
        path=new int[m+1][n+1];
        
        return getpath(m,n);
    }
    */
	/*
	public int uniquePaths(int m, int n) {
		int[][] f = new int[m+1][n+1];
		for(int i=1;i<=m;i++)
			for(int j=1;j<=n;j++)
				f[i][j]=(i==1||j==1)?1:f[i-1][j]+f[i][j-1];
		return f[m][n];
	}
	*/
	
	
	
	/*
	//ERROR
	List<String> list = new LinkedList<String>();
    public List<String> restoreIpAddresses(String s) {
    	int[] ip = {-1,-1,-1,-1};
        for(int i=1;i<s.length()&&i-0<=3;i++)
        {
        	int t1 = Integer.parseInt(s.substring(0,i));
        	if(ip[0]>255 || t1 == ip[0])
        		continue;
        	for(int j=i+1;j<s.length()&&j-i<=3;j++)
        	{
        		int t2=Integer.parseInt(s.substring(i,j));
            	if(ip[1]>255||ip[1]==t2)
            		continue;
        		for(int k=j+1;k<s.length()&&k-j<=3&&s.length()-k<=3;k++)
        		{
        			int t3=Integer.parseInt(s.substring(j,k));
        			int t4=Integer.parseInt(s.substring(k,s.length()));
                	if(ip[2]>255||ip[3]>255||ip[2]==t3||ip[3]==t4)
                		continue;
                	ip[0]=t1;
                	ip[1]=t2;
                	ip[2]=t3;
                	ip[3]=t4;
    				String ss = ip[0]+"."+ip[1]+"."+ip[2]+"."+ip[3];
    				list.add(ss);
        		}
        	}
        }
    	return list;
    }
    */
	
	
	/*
	List<List<Integer>> list = new LinkedList<List<Integer>>();
	List<Integer> st = new LinkedList<Integer>();
	public void getsum(int[]set,int start,int sum)
	{
		if(sum==0)
		{
			list.add(new LinkedList<Integer>(st));
			return;
		}
		for(int i=start;i<set.length;i++)
		{
			if(sum-set[i]>=0)
			{
				st.add(set[i]);
				getsum(set,i,sum-set[i]);
				st.remove(st.size()-1);
			}
		}
	}
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
        getsum(candidates,0,target);
    	
    	return list;
    }
    */
	
	
	
	/*
	List<List<Integer>> list = new LinkedList<List<Integer>>();
	List<Integer> st = new LinkedList<Integer>();
	public void getsum(int[]set,int start,int sum)
	{
		if(sum==0)
		{
			list.add(new LinkedList<Integer>(st));
			return;
		}
		for(int i=start;i<set.length;i++)
		{
			if(sum-set[i]>=0)
			{
				st.add(set[i]);
				getsum(set,i+1,sum-set[i]);
				st.remove(st.size()-1);
				while(i+1<set.length && set[i]==set[i+1])
					i++;
			}
		}
	}
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	Arrays.sort(candidates);
        getsum(candidates,0,target);
    	return list;
    }
    */
	
	
	/*
	List<String> list = new LinkedList<String>();
	StringBuffer st = new StringBuffer();
	public void getres(int n,int ban)
	{
		if(ban<0||n<0)
			return;
		if(n==0&&ban==0)
		{
			list.add(st.toString());
			return;
		}
		
		st.append('(');
		getres(n-1,ban+1);
		st.deleteCharAt(st.length()-1);
		st.append(')');
		getres(n,ban-1);
		st.deleteCharAt(st.length()-1);
	}
    public List<String> generateParenthesis(int n) {
    	getres(n,0);
    	return list;
    }
    */
    
    
	
	/*
    public boolean search(char[][] board,int x,int y, String word,int pos)
    {
    	if(word.charAt(pos) != board[x][y])
    		return false;
    	if(pos+1==word.length() && word.charAt(pos) == board[x][y])
    		return true;
    	
    	char t = board[x][y];
    	board[x][y]='.';
    	if(x+1<board.length && board[x+1][y]!='.' && search(board,x+1,y,word,pos+1))
    		return true;
    	if(y+1<board[0].length && board[x][y+1]!='.' && search(board,x,y+1,word,pos+1))
    		return true;
    	if(x-1>=0 && board[x-1][y]!='.' && search(board,x-1,y,word,pos+1))
    		return true;
    	if(y-1>=0 && board[x][y-1]!='.' && search(board,x,y-1,word,pos+1))
    		return true;
    	board[x][y]=t;
    	return false;
    }
    public boolean exist(char[][] board, String word) {
        if(word.isEmpty())
        	return true;
    	
        for(int i=0;i<board.length;i++)
        {
        	for(int j=0;j<board[0].length;j++)
        	{
        		if(search(board,i,j,word,0))
	        		return true;
        	}
        }
        return false;
    }
    */
	
	
	
	/*
	public boolean check(String s,String d)
	{
		int count=0;
		char[] cs=s.toCharArray(),cd=d.toCharArray();
		for(int i=0;i<cs.length;i++)
		{
			if(cs[i]!=cd[i])
				count++;
			if(count>1)
				return false;
		}
		if(count==1)
			return true;
		else
			return false;
	}
	public void getlen(String beginWord, String endWord,Set<String> dict,int count)
	{
		if(beginWord.equals(endWord))
		{
			min=min<count?min:count;
			return;
		}
		Iterator<String> it = dict.iterator();
    	for(int i=0;i<dict.size()&&it.hasNext();i++)
    	{
    		String its = it.next();
			if(flag[i]==false && check(beginWord,its))
			{
				flag[i]=true;
				getlen(its,endWord,dict,count+1);
				flag[i]=false;
			}
    	}
	}
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
    	wordDict.add(endWord);
    	flag = new boolean[wordDict.size()];
    	Arrays.fill(flag, false);
    	getlen(beginWord,endWord,wordDict,0);
        return min==Integer.MAX_VALUE?0:min;
    }
	boolean[] flag;
	int min=Integer.MAX_VALUE;
	*/
	
	
	/*
	public double power(double x, int n)
	{
		if(n!=0)
        {
        	double v=power(x,n/2);
        	return v*v*(n%2==0?1:x);
        }
		else 
        	return 1;
	}
    public double myPow(double x, int n) {
        if(n>=0)
        	return power(x,n);
        else
        	return 1.0/power(x,-n);
    }
    */
    
	/*
    public boolean canJump(int[] nums) {
        for(int i=nums.length-2;i>=0;i--)//nums.length-2
        {
        	if(0==nums[i])
        	{
        		boolean flag=false;
        		for(int j=i-1;j>=0;j--)
        		{
        			if(i-j<nums[j])
        			{
        				flag=true;
        				i=j+1;//中间可跳过
        				break;
        			}
        		}
        		if(!flag)
        			return false;
        	}
        }
        return true;
    }
    */
	/*
	//TIME OUT
	public boolean canJump(int[] nums) {
		for(int i=0,j=0;i<nums.length;i++)
		{
			for(j=i;j<nums.length;)
			{		
				if(i+nums[i]>nums.length)
					return true;
				else if(j==j+nums[j])
					break;
				else
					j+=nums[j];	
			}
			
		}
		return false;
	}
	*/
	
	
	
	/*
    //BFS
    public int jump(int[] nums) {
    	int lever=0,cur=0,levermax=0;
        Queue<Integer> qb = new LinkedList<Integer>();
        if(nums.length<=1)
        	return 0;
        else
        	qb.add(0);
        
        while(!qb.isEmpty())
        {
	    	for(int i=qb.size(),curmax=levermax;i>0;i--)
	    	{
	    		cur = qb.poll();
	    		for(int j=nums[cur];j>0;j--)
	    		{
	    			int ccur=cur+j;
		    		if(ccur>=nums.length-1)
		    			return lever+1;
		    		if(ccur>curmax)
	    			{
		    			levermax=levermax>ccur?levermax:ccur;
		    			qb.add(ccur);
	    			}
	    		}
	    	}
	    	lever++;
        }
    	return -1;
    }
    */
	/*
	//层搜
    public int jump(int[] nums) {
        if(nums.length<=1)
        	return 0;
        
        int left=0,right=0,levers=0,newright=0;
    	while(newright==0 || newright>right)
    	{
    		left=right;
    		right=newright;
	    	for(int pt=left;pt<=right;pt++)
	    	{
	    		int maxcur=pt+nums[pt];
	    		if(maxcur>=nums.length-1)
	    			return levers+1;
	    		newright=newright>maxcur?newright:maxcur;
	    	}
	    	levers++;
    	}
    	return -1;
    }
    */
	
	
	/*
    public int maxProfit(int[] prices) {
    	if(prices.length<=1)
    		return 0;
    	int low=0,high=0,tlow=0,thigh=0;
    	
    	for(int i=0;i<prices.length;i++)
    	{
    		if(prices[i]>prices[tlow])
    			thigh=i;
    		if(prices[i]<prices[tlow])
    			tlow=i;
    		if(tlow<thigh && prices[high]-prices[low]<prices[thigh]-prices[tlow])
    		{
    			high=thigh;
    			low=tlow;
    		}
    	}
    	return prices[high]-prices[low];
    }
    */
	/*
    public int maxProfit(int[] prices) {
    	if(prices.length<=1)
    		return 0;
    	
    	int lowprices=prices[0],profit=0;
    	for(int i=1;i<prices.length;i++)
    	{
    		profit=profit>prices[i]-lowprices?profit:prices[i]-lowprices;
    		lowprices=lowprices>prices[i]?prices[i]:lowprices;
    	}
    	return profit;
    }
    */
	/*
    public int maxProfit(int[] prices) {
    	if(prices.length<=1)
    		return 0;
    	int profit=0;
    	for(int i=1;i<prices.length;i++)
    	{
    		if(prices[i]-prices[i-1]>0)
    			profit+=prices[i]-prices[i-1];
    	}
    	return profit;
    }
    */
    

	
	/*
	 //ERROR
	
    public int lengthOfLongestSubstring(String s) {
    	if(s.isEmpty())
    		return 0;
        int count=0,max=0;
        boolean[] flag=new boolean[26];
        Arrays.fill(flag, false);
        for(int i=0;i<s.length();i++)
        {
        	char ch=s.charAt(i);
        	int pt=ch-'a';
        	if(!flag[pt])
        	{
        		flag[pt]=true;
        		count++;
        	}
        	else
        	{
        		max=max>count?max:count;
        		Arrays.fill(flag, false);
        		flag[pt]=true;
        		count=1;
        	}
        }
        return max>count?max:count;
    } 
    */
	
	
	/*
	public int lengthOfLongestSubstring(String s) {
		if(s.isEmpty())
			return 0;
		int cur=1,start=0,count=1,max=0;
		while(cur<s.length())
		{
			char ch=s.charAt(cur);
			for(int i=start;i<cur;i++)
			{
				if(ch==s.charAt(i))
				{
					max=max>count?max:count;
					start=i+1;
					count=cur-start;
					break;
				}
			}
			cur++;
			count++;
		}
		return max>count?max:count;
	}
	*/
	
	
	/*
    public int maxArea(int[] height) {
    	int area=0,start=0,end=height.length-1;
    	
    	while(start<end)
    	{
    		int tarea=(height[start]<height[end]?height[start]:height[end])*(end-start);
    		area=area>tarea?area:tarea;
    		if(height[start]<=height[end])
    			start++;
    		else
    			end--;
    	}
    	return area;
    }
    */
    
	
	
	/*
    public int minimumTotal(List<List<Integer>> triangle) {
    	for(int i=triangle.size()-2;i>=0;i--)
    	{
    		for(int j=triangle.get(i).size()-1;j>=0;j--)
    		{
    			int left,right,root;
    			left=triangle.get(i+1).get(j);
    			right=triangle.get(i+1).get(j+1);
    			root=triangle.get(i).get(j);
    			triangle.get(i).set(j, root+((left>right)?right:left) );
    		}
    	}
    	return triangle.get(0).get(0);
    }
    */
	
	
	
	/*
    public int maxSubArray(int[] nums) {
        int sum=nums[0],sub=nums[0];
        
        for(int i=1;i<nums.length;i++)
        {
        	sub=(sub+nums[i])>nums[i]?(sub+nums[i]):nums[i];
        	sum=sum>sub?sum:sub;
        }
        return sum;
    }
    */
	
	
	
	/*
    public int maximalRectangle(char[][] matrix) {
        int area=0,row=0,col=0;
        
        for(int i=0;i<matrix.length;i++)
        {
        	for(int j=0;j<matrix[0].length;j++)
        	{
        		if(matrix[i][j]!=0)
        		{
        			col=j+1;
        			while(col<matrix[0].length && matrix[i][col]!=0)
        				col++;
        			row=i+1;
        			while(row<matrix.length && matrix[j][row]!=0)
        				row++;
        			
//        			for(int t=)
//        			{
//        				
//        			}
        			short s=1;
        			//s=s+1;
        			s+=1;
        		}
        	}
        }
        return area;
    }
    */
	
}


