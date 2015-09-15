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
	//=====================数组====================
	/*
	 * 2.1.1
	 * 在原数组中，去除数组中重复元素，并返回新长度
	 * 算法描述：
	 * 1.设置s,t两个数组指示，初始化s=0,t=1
	 * 2.t++直至数组末尾，若a[t]!=a[s]则s后移,并a[s]=a[t]
	 * 3.返回数组新长度s+1
	 * 时间复杂度O(n)，空间复杂度O(1)
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
	 * 问题描述：使得有序数组中最多包含两个相同元素，并返回新的数组长度
	 * 算法：
	 * 1.设立s=0,t=1两个数组指示及c=1重复数字计数
	 * 2.当a[s]==a[t]且c<2,a[++s]=a[t],c++
	 * 3.当a[s]!=a[t],a[++s]=a[t],c=1
	 * 4.t每次移向下一元素,直至数组末尾,最后返回数组新长度s+1
	 * 时间复杂度O(n),空间复杂度O(1)
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
     * 问题描述：被旋转一次的有序数组,查找某一数
     * 算法：
     * 二分查找
     */
    
    /*
     * 2.1.5
     * 问题描述：求两个有序数组的中间元素,要求时间O(m+n)
     * 算法：
     * 1.设置s,t分别直向两数组,m,n分别表示数组容量,c用于计数,pmid,mid记录搜索过程中的前后两个数
     * 2.c递增直至为两数组长度和除二，当和为奇数时所求为mid,为偶数时为pmid与mid平均值
     * 3.在C递增过程中,在两数组中按数据大小依次搜索和保存pmid,mid
     * 时间复杂度O(n),空间复杂度O(1)
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
     * 问题描述：求无序数组中最长连续子序列长度
     * 
     * 
     */
    
    
    /*
     * 2.1.7
     * 问题描述：求数组中两元素和为指定值的数在数组中的位置序列(仅一解)
     * 算法：
     * 1.以数组值为键,数组坐标为值,hashmap存储数组
     * 2.依次从hashmap中去掉之前的同样键值对<a[i],i>,并在余下的hashmap中搜索是否存在指定值与本次
     * 	    键值对中值的差(tag-a[i])为键的键值对<tag-a[i],k>是否存在
     * 3.存在则所求坐标对为<i+1,k+1>
     * 时间复杂度O(n),空间复杂度O(n)
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
     * 问题描述：求数组中三个元素和为0的有序排列
     * 算法：
     * 1.数组排序
     * 2.按新数组顺序取不同元素A[i]为a
     * 3.取b=A[j],c=A[k],其中j=i+1,k=n-1,向中间夹逼,直至j>=k
     * 4.若b+c>-a,k=k-1,若b+c<-a,j=j+1,若b+c=-a,(a,b,c)为所求,k向数组前找
     *   第一个不同元素,j向数组后找第一个不同元素
     * 时间复杂度O(N^2),空间复杂度O(1)
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
     * 问题描述：寻找数组中和为指定值的三元无重复有序序列组合
     * 算法：
     * 同上
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
     * 问题描述:4Sum
     * 
     */
    
    
	/* 
	 * 2.1.11
	 * 问题描述：在原数组上去除数组中指定值的元素,并返回新数组长度
	 * 算法：
	 * 1.设立s=0,t=0两个数组指示
	 * 2.t递增直至数组结束,当a[t]!=val时,a[s]=a[t]且s加1,否则不做处理
	 * 3.返回s即为新数组长度
	 * 时间复杂度O(n),空间复杂度O(1)
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
	 * 问题描述：求数字序列的字典序的下一序列,若没有则循环到最小字典序
	 * 算法：
	 * 1.对当前排列从后向前扫描，找到一对为升序的相邻元素，记为i和j(i < j)
	 * 2.如果不存在这样一对为升序的相邻元素，则所有排列均已找到，算法结束
	 * 3.否则，重新对当前排列从后向前扫描，找到第一个大于i的元素k，
	 *   交换i和k，然后对从j开始到结束的子序列反转，则此时得到的新排列就为下一个字典序排列。
	 * 时间复杂度O(n^2),空间复杂度O(1)
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
     * 背景知识:
     * 康托展开的公式是 X(s)=an*(n-1)!+an-1*(n-2)!+...+ai*(i-1)!+...+a2*1!+a1*0! 
     * 其中,ai为当前未出现的元素中是排在第几个(从0开始),得到的数值为s在编码中以0开始编号的数.
     * 康托逆展开:辗转相除法,
     * 问题描述:求指定数量数字的指定字典序
     * 算法:
     * 采用康托逆暂开
     * 1.第k个数,其康托暂开序为k-1
     * 2.令t1=k-1,i=1,an=t1/(n-i)!,t2=t1%(n-i)!,该位置字符为从未出现字符集中的第an个字符(0开始计数)
     * 3.依次类推
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
     * 问题描述:求以数组形式给出的柱状图可容纳雨量
     * 算法:
     * 1.两个数组保存,从左右遍历数组已出现的最大值
     * 2.对第i个柱,其容量为上述数组对应位置的最小值与柱高之差
     * 3.则容量为各柱容量之和
     * 时间复杂度O(2n),空间复杂度o(n)
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
	 * 算法:
	 * 1.以数组最大值为分界,分别向左、向右寻找次最大值,在最大值及次最大值区间求容量
	 * 2.依次向左、右搜索最大值,与之前的次最大值继续上述操作
	 * 时间复杂度O(3n),空间复杂度O(1)
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
     * 算法:
     * 沿对角线方向,依次按圈进行数据旋转,分别取一边的数据依次对环上四个点进行旋转
     * !其中选装时坐标 (i,j)->(j,n-i-1)实际为沿对角线对称然后沿y=n/2中线对称,
     * 算法以对角线向中心,依次按环旋转,所以第一层循环为<n/2,第二层循环<n-i-1
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
     * 问题描述:数组表示一个正数,对该正数进行加一操作
     * 算法:末尾加一,按十进制进行进位,注意当溢出时需要重新开辟空间
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
     * 问题描述:n阶楼梯,每步可跨1,2阶楼梯,问可能的跨法有多少种
     * 算法:将到达第i阶看做由 i-1跨一步及i-2跨两步两种情况,得递推公式 f(n)=f(n-1)+f(n-2),f(1)=1,f(2)=2
     * 为斐波那契数列,an=(1/k)*{(1+k)^n/2^n - (1-k)^n/2^n},k=sqrt(5);
     * 时间复杂度O(n),空间复杂度o(1)
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
