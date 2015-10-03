package charstr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
	//============================================
	//============================================
	//============================================
	//====================�ַ���====================
	/*
	 * 3.1 Valid Palindrome
	 * ��������:�ж��ַ����Ƿ�Ϊ����,�Ƚϴ�����ĸ������
	 * �㷨:���Ҽб�,�ҷ����������ַ�,�ж��Ƿ���ͬ(��Ȼ�Ϊ��Сд��ϵ)
	 * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(1)
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
     * ע��:	1.�߽�
     * 		2.��ȡnextʱi<n.length-1
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
     * ��������:ʵ�������ַ���ת����(int��)
     * ע��:	1.�ո�,����,����,����
     * 		2.����/�����ַ�ǰ�Ŀո�,����
     * 		3.����λ��һ���������ֳ���ǰ
     * 		4.���ֿ��ܳ�����ʾ��Χ
     * 		5.����/���ֳ��ֺ�,�����������ַ���ֹͣ
     * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(1)
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
     * ��������:���������ƴ��ĺ�
     * �㷨:���ý�λ��β���������,ע�����ʱ��λ�Ĵ���
     * ʱ�临�Ӷ�O(m+n),�ռ临�Ӷ�O(1)
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
     * ��������:�ҳ��ַ�������Ļ���
     * �㷨: 1)�����׺ʽ�Ƚ�
     *      2)�������,��Ԫ��Ϊ����չ������
     */
    public String longestPalindrome(String s) {
        String str="";
        
        return str;
    }
    
    /*
     * 3.6 Regular Expression Matching
     * ��������: '.'���������ַ�,'*'����0~n��ǰ���ַ�,�����ַ����Ƿ���ͬ
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
     * ��������:���n����������,1, 11, 21, 1211, 111221, ...
     * �㷨:������ƴ���ַ���
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
     * ��������:�ҳ��ַ���������,����ͬ��ĸ��������ɵĴ�����(Сд��ĸ)
     * �㷨:���ַ�������,���ظ�������������뼯��
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
     * ��������:���ַ��������һ�����ʵĳ���
     * �㷨:ɨ��һ���ַ���,��¼������ĸ�ĳ���,�������ո�ʱ�����ȷ������ݴ�����
     * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(1)
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
