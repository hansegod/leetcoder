package stackAqueue;

import java.util.Stack;

public class Solution {
	/*
	 * 4.1.1 Valid Parentheses
	 * 问题描述:判断括号是否匹配
	 * 算法:左括号入栈,右括号判断栈中是否有元素并匹配,最后栈为空
	 */
    public boolean isValid(String s) {
        if(null==s || s.length()<=0)
        	return false;
        char ch,t;
        Stack<Character> sk=new Stack<Character>();
        for(int i=0;i<s.length();i++){
        	ch=s.charAt(i);
        	if(ch=='(' || ch=='{' || ch=='[')
        		sk.push(ch);
        	else if(sk.isEmpty())
        		return false;
        	else{
        		t=sk.pop();
        		if(!((t=='('&&ch==')') || (t=='['&&ch==']') || (t=='{'&&ch=='}')) )
        			return false;
        	}
        }
        return sk.isEmpty();
    }
    
    /*
     * 4.1.2 Longest Valid Parentheses
     * 问题描述:计算'(',')'字符串中的最大连续匹配串长度
     * 算法:以此为例")()(())()"
     * 	   遇到')'时,若之前有未匹配的'(',则由此可确定的最近匹配长度,为两字符的下标差
     *   要计算当前的最大长度,则还需要加上'('之前已匹配长度
     *   因此,f[i]来存储i位置已匹配的长度,令'('处的f[k]=0
     *       f[i]=i-t+1 + f[t-1],t为与i处')'匹配的'('下标	
     * 时间复杂度O(n),空间复杂度O(n)
     */
    public int longestValidParentheses(String s) {
        if(null==s || s.length()<2)
        	return 0;
        int max=0,t=0;
        int[] f=new int[s.length()];
        Stack<Integer> sk=new Stack<Integer>();
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i)=='(')
        		sk.push(i);
        	else if(sk.isEmpty())
        		f[i]=0;
        	else{
        		t=sk.pop();
        		f[i]=(t>0?f[t-1]:0) + i-t+1;
        		max=max>f[i]?max:f[i];
        	}
        }
        return max;
    }
    
    /*
     * 4.1.3 Largest Rectangle in Histogram
     * 问题描述:求柱图中最大的矩形面积
     * 算法:思路就是求每一个顶点i,按照这个点的高度,向左和向右最大能拓展到的位置l[i]和h[i],
     * 然后答案就是max(a[i]*(r[i]-l[i])),换句话说求每个点，它左边第一个比这个点矮的点的坐标，
     * 和它右边第一个比这个点矮的坐标,采用单调栈!
     * 其实就是穷举以每个柱为高度向两端尽量延展!!
     * 
     */
    public int largestRectangleArea__(int[] height) {
    	if(null==height || height.length<1)
    		return 0;
    	int t,a=0,max=0;
    	Stack<Integer> sk=new Stack<Integer>();
    	for(int i=0;i<height.length;i++){
    		while(!sk.isEmpty() && height[i]<height[sk.peek()]){
    			t=sk.pop();
    			if(sk.isEmpty())
    				a=height[t]*(i-0);
    			else
    				a=height[t]*(i-sk.peek()-1);
    			max=max>a?max:a;
    		}
    		sk.push(i);
    	}
    	while(!sk.isEmpty()){
			t=sk.pop();
			if(sk.isEmpty())
				a=height[t]*(height.length-0);
			else
				a=height[t]*(height.length-sk.peek()-1);
			max=max>a?max:a;
    	}
    	return max;
    }
    public int largestRectangleArea_(int[] height) {
    	if(null==height || height.length<1)
    		return 0;
    	int t,a=0,max=0;
    	Stack<Integer> sk=new Stack<Integer>();
    	sk.push(-1);
    	for(int i=0;i<height.length;i++){
    		while(sk.peek()>=0 && height[i]<height[sk.peek()]){
    			t=sk.pop();
    			a=height[t]*(i-sk.peek()-1);
    			max=max>a?max:a;
    		}
    		sk.push(i);
    	}
    	while(sk.peek()>=0){
			t=sk.pop();
			a=height[t]*(height.length-sk.peek()-1);
			max=max>a?max:a;
    	}
    	return max;
    }
    public int largestRectangleArea(int[] height) {
    	if(null==height || height.length<1)
    		return 0;
    	int t,a=0,max=0;
    	Stack<Integer> sk=new Stack<Integer>();
    	sk.push(-1);
    	for(int i=0;i<=height.length;i++){
    		while(sk.peek()>=0 && (i>=height.length|| height[i]<height[sk.peek()])){
    			t=sk.pop();
    			a=height[t]*(i-sk.peek()-1);
    			max=max>a?max:a;
    		}
    		sk.push(i);
    	}
    	return max;
    }
    
    /*
     * 4.1.4 Evaluate Reverse Polish Notation
     * 问题描述:计算包含四则运算的逆波兰表达式
     * 算法:采用栈保存操作数,遇到操作符出栈操作数,计算并入栈
     * 时间复杂度O(n),空间复杂度O(n)
     */
    public int evalRPN(String[] tokens) {
        if(null==tokens || tokens.length<1)
        	return Integer.MIN_VALUE;
        Stack<Integer> sk=new Stack<Integer>();
        for(int i=0;i<tokens.length;i++){
        	if(!(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")))
        		sk.push(Integer.parseInt(tokens[i]));
        	else if(sk.isEmpty())
        		return Integer.MIN_VALUE;
        	else{
        		int b=sk.pop(),a=sk.pop(),c=0;
        		if(tokens[i].equals("+"))
        			c=b+a;
        		else if(tokens[i].equals("-"))
        			c=a-b;
        		else if(tokens[i].equals("*"))
        			c=a*b;
        		else if(tokens[i].equals("/")&&b!=0)
        			c=a/b;
        		else
        			return Integer.MIN_VALUE;
        		sk.push(c);
        	}
        }
        if(sk.isEmpty())
        	return Integer.MIN_VALUE;
        else{
        	int c=sk.pop();
        	return sk.isEmpty()?c:Integer.MIN_VALUE;
        }
    }
}
