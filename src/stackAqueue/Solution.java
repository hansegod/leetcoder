package stackAqueue;

import java.util.Stack;

public class Solution {
	/*
	 * 4.1.1 Valid Parentheses
	 * ��������:�ж������Ƿ�ƥ��
	 * �㷨:��������ջ,�������ж�ջ���Ƿ���Ԫ�ز�ƥ��,���ջΪ��
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
     * ��������:����'(',')'�ַ����е��������ƥ�䴮����
     * �㷨:�Դ�Ϊ��")()(())()"
     * 	   ����')'ʱ,��֮ǰ��δƥ���'(',���ɴ˿�ȷ�������ƥ�䳤��,Ϊ���ַ����±��
     *   Ҫ���㵱ǰ����󳤶�,����Ҫ����'('֮ǰ��ƥ�䳤��
     *   ���,f[i]���洢iλ����ƥ��ĳ���,��'('����f[k]=0
     *       f[i]=i-t+1 + f[t-1],tΪ��i��')'ƥ���'('�±�	
     * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(n)
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
     * ��������:����ͼ�����ľ������
     * �㷨:˼·������ÿһ������i,���������ĸ߶�,����������������չ����λ��l[i]��h[i],
     * Ȼ��𰸾���max(a[i]*(r[i]-l[i])),���仰˵��ÿ���㣬����ߵ�һ��������㰫�ĵ�����꣬
     * �����ұߵ�һ��������㰫������,���õ���ջ!
     * ��ʵ���������ÿ����Ϊ�߶������˾�����չ!!
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
     * ��������:�����������������沨�����ʽ
     * �㷨:����ջ���������,������������ջ������,���㲢��ջ
     * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(n)
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
