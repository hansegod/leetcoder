package charstr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
     * 问题描述:找出字符串中最长的回文
     * 算法: 1)逆序后缀式比较
     *      2)间隔插入,各元素为中心展开搜索
     */
    public String longestPalindrome(String s) {
        String str="";
        
        return str;
    }
    
    /*
     * 3.6 Regular Expression Matching
     * 问题描述: '.'代表任意字符,'*'代表0~n个前面字符,判两字符串是否相同
     * 
     */
    public boolean isMatch_(String s, String p) {
        
    	return true;
    }
    
    /*
     * 3.7 Wildcard Matching
     * 
     */
    public boolean isMatch(String s, String p) {
     
    	return true;
    }
    
    /*
     * 3.8 Longest Common Prefix
     * 
     * 
     */
    public String longestCommonPrefix(String[] strs) {
        
    	return "";
    }
    
    
    /*
     * 3.9 Valid Number
     * 
     * 
     */
    public boolean isNumber(String s) {
        
    	return true;
    }
    
    
    /*
     * 3.10 Integer to Roman
     * 
     */
    public int romanToInt(String s) {
        
    	return 1;
    }
    
    /*
     * 3.11 Roman to Integer
     * 
     */
    public String intToRoman(int num) {
     
    	return "";
    }
    
    /*
     * 3.12 Count and Say
     * 问题描述:求第n个数数问题,1, 11, 21, 1211, 111221, ...
     * 算法:计数并拼接字符串
     */
    public String countAndSay(int n) {
    	if(n<=0)
    		return null;
        String per="1",cur="";
        int c=0;
        
        for(int i=1;i<n;i++){
        	char ch;
        	for(int j=0;j<per.length();){
        		do{
        			ch=per.charAt(j++);
        			c++;
        		}	
        		while(j<per.length() && ch==per.charAt(j));
        		cur+=c+""+ch;
        		c=0;
        	}
        	per=cur;
        	cur="";
        }
        return per;
    }
    
    /*
     * 3.13 Anagrams
     * 问题描述:找出字符串数组中,由相同字母集合所组成的串集合(小写字母)
     * 算法:将字符串排序,若重复出现则将其添加入集合
     * 
     */
	public ArrayList<String> anagrams(String[] strs) 
	{
		ArrayList<String> list = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		    
	    for (int i = 0; i < strs.length; ++i){
			 char[] chars = strs[i].toCharArray();
			 Arrays.sort(chars);
			 String anagram = new String(chars);
			 if(map.containsKey(anagram)){
				 int index = map.get(anagram);
				 if (index != -1){
					 list.add(strs[index]);
					 map.put(anagram, -1);
				 }
				 list.add(strs[i]);
			 } 
			 else 
				 map.put(anagram, i);
	    }
	    return list;
   }
	
	/*
	 * 3.14 Simplify Path
	 * 
	 * 
	 */
    public String simplifyPath(String path) {
        String res="";
        
        return res;
    }
    
    /*
     * 3.15 Length of Last Word
     * 问题描述:求字符串中最后一个单词的长度
     * 算法:扫描一遍字符串,记录连续字母的长度,当遇到空格时若长度非零则暂存起来
     * 时间复杂度O(n),空间复杂度O(1)
     */
    public int lengthOfLastWord(String s) {
    	int len=0,per=0;
    	if(s==null || s.length()<1)
    		return 0;
    	for(int i=0;i<s.length();i++){
    		if(s.charAt(i)!=' ')
    			len++;
    		else{
    			per=len>0?len:per;
    			len=0;
    		}
    	}
    	return len>0?len:per;
    }
}
