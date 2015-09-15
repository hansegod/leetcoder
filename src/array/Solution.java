package array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
	
	//============================================
	//============================================
	//============================================
	//=====================����====================
	/*
	 * 2.1.1
	 * ��ԭ�����У�ȥ���������ظ�Ԫ�أ��������³���
	 * �㷨������
	 * 1.����s,t��������ָʾ����ʼ��s=0,t=1
	 * 2.t++ֱ������ĩβ����a[t]!=a[s]��s����,��a[s]=a[t]
	 * 3.���������³���s+1
	 * ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(1)
	 */
    public int removeDuplicates(int[] nums) {
        int s=0,t=1;
        if(nums==null)
        	return 0;
        if(nums.length<=1)
        	return nums.length;
        while(t<nums.length)
        {
        	if(nums[t]!=nums[s])
        		nums[++s]=nums[t];
        	t++;
        }
        return s+1;
    }
    
    /*
     * 2.1.2
	 * ����������ʹ������������������������ͬԪ�أ��������µ����鳤��
	 * �㷨��
	 * 1.����s=0,t=1��������ָʾ��c=1�ظ����ּ���
	 * 2.��a[s]==a[t]��c<2,a[++s]=a[t],c++
	 * 3.��a[s]!=a[t],a[++s]=a[t],c=1
	 * 4.tÿ��������һԪ��,ֱ������ĩβ,��󷵻������³���s+1
	 * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(1)
	 */
    public int removeDuplicates2(int[] nums) {
    	if(nums==null)
    		return 0;
    	if(nums.length<=1)
    		return nums.length;
    	
    	int s=0,t=1,c=1;
    	while(t<nums.length)
    	{
    		if(nums[s]==nums[t] && c<2)
    		{
    			nums[++s]=nums[t];
    			c++;
    		}
    		else if(nums[s]!=nums[t])
    		{
    			nums[++s]=nums[t];
    			c=1;
    		}
    		t++;
    	}
    	return s+1;
    }
    
    /*
     * 2.1.3
     * 2.1.4
     * ��������������תһ�ε���������,����ĳһ��
     * �㷨��
     * ���ֲ���
     */
    
    /*
     * 2.1.5
     * ��������������������������м�Ԫ��,Ҫ��ʱ��O(m+n)
     * �㷨��
     * 1.����s,t�ֱ�ֱ��������,m,n�ֱ��ʾ��������,c���ڼ���,pmid,mid��¼���������е�ǰ��������
     * 2.c����ֱ��Ϊ�����鳤�Ⱥͳ���������Ϊ����ʱ����Ϊmid,Ϊż��ʱΪpmid��midƽ��ֵ
     * 3.��C����������,���������а����ݴ�С���������ͱ���pmid,mid
     * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(1)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	if(nums1==null && nums2==null)
    		return Double.MIN_VALUE;
    	
    	int m=0,n=0,s=0,t=0,c=0,pmid=0,mid=0;
    	m=(nums1!=null)?(nums1.length):0;
    	n=(nums2!=null)?(nums2.length):0;
    	
        while(c<=(m+n)/2)
        {
    		if(m<=0 || s>=m || (t<n && s<m && nums1[s]>nums2[t]))
    		{
    			pmid=mid;
    			mid=nums2[t];
    			t++;
    		}
    		else if(n<=0 || t>=n || (t<n && s<m && nums1[s]<=nums2[t]))
    		{
    			pmid=mid;
    			mid=nums1[s];
    			s++;
    		}
        	c++;
        }
        
        if((m+n)%2==0)
        	return (pmid+mid)/2.0;
        else
        	return mid;
    }
    
    
    /*
     * 2.1.6
     * ��������������������������������г���
     * 
     * 
     */
    
    
    /*
     * 2.1.7
     * ��������������������Ԫ�غ�Ϊָ��ֵ�����������е�λ������(��һ��)
     * �㷨��
     * 1.������ֵΪ��,��������Ϊֵ,hashmap�洢����
     * 2.���δ�hashmap��ȥ��֮ǰ��ͬ����ֵ��<a[i],i>,�������µ�hashmap�������Ƿ����ָ��ֵ�뱾��
     * 	    ��ֵ����ֵ�Ĳ�(tag-a[i])Ϊ���ļ�ֵ��<tag-a[i],k>�Ƿ����
     * 3.���������������Ϊ<i+1,k+1>
     * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        int [] rst = {0,0};
        if(nums==null)
        	return rst;
        
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        	m.put(nums[i], i);
        for(int i=0;i<nums.length;i++)
        {
        	m.remove(nums[i],i);
        	Integer t = m.get(target-nums[i]);
        	if(t!=null)
        	{
        		rst[0]=i+1;
        		rst[1]=t+1;
        		return rst;
        	}
        }
        return rst;
    }
    
    /*
     * 2.1.8
     * ����������������������Ԫ�غ�Ϊ0����������
     * �㷨��
     * 1.��������
     * 2.��������˳��ȡ��ͬԪ��A[i]Ϊa
     * 3.ȡb=A[j],c=A[k],����j=i+1,k=n-1,���м�б�,ֱ��j>=k
     * 4.��b+c>-a,k=k-1,��b+c<-a,j=j+1,��b+c=-a,(a,b,c)Ϊ����,k������ǰ��
     *   ��һ����ͬԪ��,j��������ҵ�һ����ͬԪ��
     * ʱ�临�Ӷ�O(N^2),�ռ临�Ӷ�O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	if(nums==null||nums.length<3)
    		return list;
    	
    	Arrays.sort(nums);
    	
    	int i=0,j=1,k=nums.length-1;
    	int a,b,c;
        while(i<nums.length-2)
        {
        	j=i+1;
        	k=nums.length-1;
        	
        	while(j<k)
        	{
	        	a=nums[i];
	        	b=nums[j];
	        	c=nums[k];
	        	if(b+c<-a)
	        		j++;
	        	else if(b+c>-a)
	        		k--;
	        	else
	        	{
	        		List<Integer> l=new ArrayList<Integer>();
	        		l.add(a);
	        		l.add(b);
	        		l.add(c);
	        		list.add(l);
	        		while(j<k && nums[j]==nums[j+1])	
	        			j++;
	        		j++;
	        		while(j<k && nums[k]==nums[k-1])	
	        			k--;
	        		k--;
	        	}
        	}
        	while(i<nums.length-2 && nums[i]==nums[i+1])	
        		i++;
        	i++;
        }
        return list;
    }
    

    
    /*
     * 2.1.9
     * ����������Ѱ�������к�Ϊָ��ֵ����Ԫ���ظ������������
     * �㷨��
     * ͬ��
     */
    public int threeSumClosest(int[] nums, int target) {
    	if(nums==null||nums.length<3)
    		return 0;
    	
    	Arrays.sort(nums);
    	
    	int i=0,j,k;
    	int a,b,c;
    	int count=0,sum=nums[i]+nums[i+1]+nums[nums.length-1];
        while(i<nums.length-2){
        	j=i+1;
        	k=nums.length-1;
        	while(j<k){
	        	a=nums[i];
	        	b=nums[j];
	        	c=nums[k];
	        	sum=Math.abs(a+b+c-target)<Math.abs(sum-target)?(a+b+c):sum;
	        	if(b+c<target-a){
	        		while(j<k && nums[j]==nums[j+1])
	        			j++;
	        		j++;
	        	}
	        	else if(b+c>target-a){
	        		while(j<k && nums[k]==nums[k-1])
	        			k--;
	        		k--;
	        	}
	        	else
	        		return target;
        	}
        	while(i<nums.length-2 && nums[i]==nums[i+1])	
        		i++;
        	i++;
        }
        return sum;
    }
    
    
    /*
     * 2.1.10
     * ��������:4Sum
     * 
     */
    
    
	/* 
	 * 2.1.11
	 * ������������ԭ������ȥ��������ָ��ֵ��Ԫ��,�����������鳤��
	 * �㷨��
	 * 1.����s=0,t=0��������ָʾ
	 * 2.t����ֱ���������,��a[t]!=valʱ,a[s]=a[t]��s��1,����������
	 * 3.����s��Ϊ�����鳤��
	 * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(1)
	 */
    public int removeElement(int[] nums, int val) {
    	if(nums==null)
    		return 0;
    	
        int len=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] !=val)
                nums[len++] = nums[i];
        }
        return len;
    }
    
    
	/*
	 * 2.1.12
	 * �������������������е��ֵ������һ����,��û����ѭ������С�ֵ���
	 * �㷨��
	 * 1.�Ե�ǰ���дӺ���ǰɨ�裬�ҵ�һ��Ϊ���������Ԫ�أ���Ϊi��j(i < j)
	 * 2.�������������һ��Ϊ���������Ԫ�أ����������о����ҵ����㷨����
	 * 3.�������¶Ե�ǰ���дӺ���ǰɨ�裬�ҵ���һ������i��Ԫ��k��
	 *   ����i��k��Ȼ��Դ�j��ʼ�������������з�ת�����ʱ�õ��������о�Ϊ��һ���ֵ������С�
	 * ʱ�临�Ӷ�O(n^2),�ռ临�Ӷ�O(1)
	 */
    public void nextPermutation(int[] num) {
    	if(num==null || num.length<2)
    		return;
    	
    	int i=num.length-2;
    	while(i>=0){
    		if(num[i]<num[i+1]){
    			int t=num.length-1;
    			while(t>i){
    				if(num[t]>num[i]){
    					int m=num[i];
    					num[i]=num[t];
    					num[t]=m;
    					int c=num.length;
    					while(++i<--c){
    						int n=num[c];
    						num[c]=num[i];
    						num[i]=n;
    					}
    					return;
    				}
    				t--;
    			}
    		}
    		i--;
    	}
    	Arrays.sort(num);
    	return;
    }
    
    /*
     * 2.1.13 Permutation Sequence
     * ����֪ʶ:
     * ����չ���Ĺ�ʽ�� X(s)=an*(n-1)!+an-1*(n-2)!+...+ai*(i-1)!+...+a2*1!+a1*0! 
     * ����,aiΪ��ǰδ���ֵ�Ԫ���������ڵڼ���(��0��ʼ),�õ�����ֵΪs�ڱ�������0��ʼ��ŵ���.
     * ������չ��:շת�����,
     * ��������:��ָ���������ֵ�ָ���ֵ���
     * �㷨:
     * ���ÿ������ݿ�
     * 1.��k����,�俵���ݿ���Ϊk-1
     * 2.��t1=k-1,i=1,an=t1/(n-i)!,t2=t1%(n-i)!,��λ���ַ�Ϊ��δ�����ַ����еĵ�an���ַ�(0��ʼ����)
     * 3.��������
     * http://blog.csdn.net/zhongkeli/article/details/6966805
     */
    public int factorial(int n){
    	int r=1;
    	while(n>1)
    		r*=n--;
    	return r;
    }
    public String getPermutation(int n, int k) {
    	String s="";
        if(n<1 || k<1)
        	return s;
        
        List<Integer> c = new LinkedList<Integer>();
        for(int i=1;i<=n;i++)
        	c.add(i-1,i);
        for(int t=k-1,i=1,f=0;i<=n;i++){
        	f=factorial(n-i);
        	s+=c.get(t/f);
        	c.remove(t/f);
        	t=t%f;
        }
        return s;
    }
    
    /*
     * 2.1.14 Valid Sudoku
     * 
     * 
     */
    
    
    /*
     * 2.1.15 Trapping Rain Water
     * ��������:����������ʽ��������״ͼ����������
     * �㷨:
     * 1.�������鱣��,�����ұ��������ѳ��ֵ����ֵ
     * 2.�Ե�i����,������Ϊ���������Ӧλ�õ���Сֵ������֮��
     * 3.������Ϊ��������֮��
     * ʱ�临�Ӷ�O(2n),�ռ临�Ӷ�o(n)
     * 
     */
    public int trap(int[] height) {
        if(height==null || height.length<3)
        	return 0;
        int vol=0;
        int[] lm=new int[height.length],rm=new int[height.length];
        for(int s=0,t=height.length-1,maxl=0,maxr=0;s<height.length && t>=0;s++,t--){
        	lm[s]=maxl;
        	maxl=height[s]>maxl?height[s]:maxl;
        	rm[t]=maxr;
        	maxr=height[t]>maxr?height[t]:maxr;
        }
        
        for(int j=0,w;j<height.length;j++){
        	w = Math.min(lm[j], rm[j])-height[j];
        	vol+=(w>0?w:0);
        }
        return vol;
    }
    /*
	 * �㷨:
	 * 1.���������ֵΪ�ֽ�,�ֱ���������Ѱ�Ҵ����ֵ,�����ֵ�������ֵ����������
	 * 2.�����������������ֵ,��֮ǰ�Ĵ����ֵ������������
	 * ʱ�临�Ӷ�O(3n),�ռ临�Ӷ�O(1)
	 */
	public static int findmax(int[] array,int start,int stop){
		int index=start;
		for(int i=start+1;i<=stop;i++)
			if(array[i] >= array[index])
				index = i;
		return index;
	}
	public static int trap_(int[] height) {
		if(height==null || height.length <3)
			return 0;
		int vol=0,maxindex,max,smax,smaxindex;
		maxindex = findmax(height,0,height.length-1);
		max = height[maxindex];
		for(int i=maxindex+1;i<height.length;i++){
			smaxindex = findmax(height,i,height.length-1);
			smax = height[smaxindex];
			if(smaxindex != i){
				int lev = max>smax?smax:max,svol=0;
				for(int t=i;t<smaxindex;t++)
					svol+=lev-height[t];
				vol+=svol;
				i=smaxindex;
				max=smax;
			}
		}
		max = height[maxindex];
		for(int j=maxindex-1;j>=0;j--){
			smaxindex = findmax(height,0,j);
			smax = height[smaxindex];
			if(smaxindex != j){
				int lev = max>smax?smax:max;
				int svol=0;
				for(int t=j;t>smaxindex;t--)
					svol+=lev-height[t];
				vol+=svol;
				j=smaxindex;
				max=smax;
			}
		}
		return vol;
	}
    
    /*
     * 2.1.16 Rotate Image
     * �㷨:
     * �ضԽ��߷���,���ΰ�Ȧ����������ת,�ֱ�ȡһ�ߵ��������ζԻ����ĸ��������ת
     * !����ѡװʱ���� (i,j)->(j,n-i-1)ʵ��Ϊ�ضԽ��߶Գ�Ȼ����y=n/2���߶Գ�,
     * �㷨�ԶԽ���������,���ΰ�����ת,���Ե�һ��ѭ��Ϊ<n/2,�ڶ���ѭ��<n-i-1
     */
    public void rotate(int[][] matrix) {
        if(matrix==null || matrix.length<2)
        	return;
        int n=matrix.length;
        for(int i=0;i<n/2;i++){
        	for(int j=i;j<n-i-1;j++){
        		int tmp = matrix[i][j];  
                matrix[i][j] = matrix[n-1-j][i];  
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];  
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];  
                matrix[j][n-1-i] = tmp; 
        	}
        }
    }
    
    
    /*
     * 2.1.17 Plus one
     * ��������:�����ʾһ������,�Ը��������м�һ����
     * �㷨:ĩβ��һ,��ʮ���ƽ��н�λ,ע�⵱���ʱ��Ҫ���¿��ٿռ�
     */
    public int[] plusOne(int[] digits) {
    	int[] arr;
        if(digits==null||digits.length<1){
        	arr=new int[1];
        	arr[0]=1;
        	return arr;
        }
        int c=0;
    	for(int i=digits.length-1;i>=0;i--){
    		digits[i]+=c;
    		c=digits[i]/10;
    		digits[i]%=10;
    	}
    	if(c>0){
    		arr=new int[digits.length+1];
    		System.arraycopy(digits, 0, arr, 1, digits.length);
    		arr[0]=c;
    		return arr;
    	}
    	else{
    		return digits;
    	}	
    }
    
    
    /*
     * 2.1.18 Climbing Stairs
     * ��������:n��¥��,ÿ���ɿ�1,2��¥��,�ʿ��ܵĿ編�ж�����
     * �㷨:�������i�׿����� i-1��һ����i-2�������������,�õ��ƹ�ʽ f(n)=f(n-1)+f(n-2),f(1)=1,f(2)=2
     * Ϊ쳲���������,an=(1/k)*{(1+k)^n/2^n - (1-k)^n/2^n},k=sqrt(5);
     * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�o(1)
     */
    public int climbStairs(int n) {
        if(n<=0)
        	return 0;
        
        int fp=1,fb=2,fn=n;
        for(int i=3;i<=n;i++){
        	fn=fp+fb;
        	fp=fb;
        	fb=fn;
        } 
        return fn;
    }
    public int climbStairs_(int n) {
    	double s = Math.sqrt(5);
    	return (int) Math.floor((Math.pow((1+s)/2, n+1) + Math.pow((1-s)/2, n+1))/s + 0.5);
    }
    
    
    
    public static void main(String args[])
    {
    	int[] a = {0,0,0,0,1,1,1,1,2,2,2,2,3,4,5,6,7,8,9};
    	int i=0;
    	while(i<a.length)
    	{
    		System.out.println(a[i]);
	    	while(i+1<a.length && a[i+1]==a[i])	
	    		i++;
	    	i++;
    	}
    }
}
