package charstr;

public class Solution {
	//============================================
	//============================================
	//============================================
	//====================字符串====================
	/*
	 * 3.1 Valid Palindrome
	 * 问题描述:判断字符串是否为回文,比较串中字母及数字
	 * 算法:左右夹逼,找符合条件的字符,判断是否相同(相等或为大小写关系)
	 * 时间复杂度O(n),空间复杂度O(1)
	 * 95%
	 */
    public boolean isPalindrome(String s) {
       if(null==s || s.length()<=1)
    	   return true;
       int h=0,t=s.length()-1;
       char hh,tt;
       while(h<t){
    	   for(hh=s.charAt(h);h<t&&!checkchar(hh);)
    		   hh=s.charAt(++h);
    	   for(tt=s.charAt(t);h<t&&!checkchar(tt);)
    		   tt=s.charAt(--t);
    	   if(h>=t)
    		   return true;
    	   else if(hh==tt || Math.abs(hh-tt)=='a'-'A'){
    		   h++;
    		   t--;
    		   continue;
    	   }
    	   else
    		   return false;
       }
       return true;
    }
    boolean checkchar(char c){
    	if(c>'z'||c<'0')
    		return false;
    	else if(c>'9'&&c<'A')
    		return false;
    	else if(c>'Z'&&c<'a')
    		return false;
    	else
    		return true;
    }
    
    /*
     * 3.2 Implement strStr()
     * KMP
     * http://kb.cnblogs.com/page/176818/
     * http://www.cnblogs.com/goagent/archive/2013/05/16/3068442.html
     * http://www.cnblogs.com/easonliu/p/3660748.html
     * 注意:	1.边界
     * 		2.获取next时i<n.length-1
     */
    int strStr_(String haystack, String needle) {
    	if(haystack==null || needle==null)
    		return -1;
    	else if(needle.length()<1)
    		return 0;
        int i,j;
        for (i=j=0; i < haystack.length() && j < needle.length();) {
            if (haystack.charAt(i) == needle.charAt(j)){
                ++i;
                ++j;
            } 
            else{
                i-=j-1;
                j=0;
            }
        }
        return j!=needle.length()?-1:i-j;
    }
    public int strStr(String haystack, String needle) {
    	if(haystack==null || needle==null)
    		return -1;
    	else if(needle.length()<1)
    		return 0;
        int[] next=GetNext(needle);
        int i,j;
        i=j=0;
        while(i<haystack.length() && j<needle.length()){
        	if(j==-1 || haystack.charAt(i)==needle.charAt(j)){
        		i++;
        		j++;
        	}
        	else
        		j=next[j];
        }
        return j==needle.length()?i-j:-1;
    }
    int[] GetNext(String s){
    	int[] n=new int[s.length()];
    	int i=0,j=-1;
    	n[i]=j;
    	while(i<n.length-1){
    		if(j==-1||s.charAt(i)==s.charAt(j)){
    			i++;
    			j++;
    			//n[i]=j;
    			n[i]=s.charAt(i)!=s.charAt(j)?j:n[j];
    		}
    		else
    			j=n[j];
    	}
    	return n;
    }
    
    /*
     * 3.3 String to Integer (atoi)
     * 问题描述:实现数字字符串转数字(int型)
     * 注意:	1.空格,符号,数字,其他
     * 		2.数字/符号字符前的空格,跳过
     * 		3.符号位仅一个且在数字出现前
     * 		4.数字可能超出表示范围
     * 		5.符号/数字出现后,遇到非数字字符则停止
     * 时间复杂度O(n),空间复杂度O(1)
     */
    public int myAtoi(String str) {
        if(null==str)
        	return 0;
        boolean fnum=false,fsyb=false;
        char ch;
        long v=0;
        int i=0,f=1;
        while(i<str.length()){
        	ch=str.charAt(i++);
        	if(ch>='0' && ch<='9'){
        		v=v*10+ch-'0';
                if(f*v>Integer.MAX_VALUE)
                	return Integer.MAX_VALUE;
                else if(f*v<Integer.MIN_VALUE)
                	return Integer.MIN_VALUE;
        		fnum=true;
        	}
        	else if(!fsyb && (ch=='-' || ch=='+')){
        		f=(ch=='-')?(-1):1;
        		fsyb=true;
        	}
        	else if(ch==' ' && !fnum && !fsyb)
        		continue;
        	else
        		break;
        }
        return f*(int)v;
    }
    
    /*
     * 3.4 Add Binary
     * 问题描述:求两二进制串的和
     * 算法:设置进位由尾部依次相加,注意结束时进位的处理
     * 时间复杂度O(m+n),空间复杂度O(1)
     * 91%
     */
    public String addBinary(String a, String b) {
        if(null==a||null==b)
        	return (null==a)?b:a;
        String s="";
        int na=0,nb=0,c=0,i=a.length()-1,j=b.length()-1;
        while(i>=0||j>=0){
        	na=(i>=0)?a.charAt(i--)-'0':0;
        	nb=(j>=0)?b.charAt(j--)-'0':0;
        	s=(na+nb+c)%2+s;
        	c=(na+nb+c)/2;
        }
        return (c>0)?(c+s):s;
    }
    
    /*
     * 3.5 Longest Palindromic Substring
     * 
     * 
     */
    public String longestPalindrome(String s) {
        
    }
}
