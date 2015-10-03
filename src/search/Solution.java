package search;

public class Solution {
	//============================================
	//============================================
	//============================================
	//=====================查找====================
	/*
	 * 7.1 Search for a Range
	 * 问题描述:在排序的数组中,查找指定数值的起止位置,不存在返回(-1,-1)
	 * 算法描述:采用折半查找,找到指定值后,向两边确定边界
	 * 时间复杂度O(longn),空间复杂度O(1)
	 * 
	 */
    public int[] searchRange_(int[] nums, int target) {
    	int high=nums.length-1,low=0,middle=0;
    	int[] res = {-1,-1};
    	while(low<=high){
    		middle = (low+high)/2;
    		if(nums[middle]>target)
    			high = middle-1;
    		else if(nums[middle]<target)
    			low = middle+1;
    		else{
    			while(nums[low]<target)
    				low++;
    			while(nums[high]>target)
    				high--;
    			res[0]=low;
    			res[1]=high;
    			break;
    		}
    	}
    	return res;
    }
    public int[] searchRange(int[] nums, int target) {
    	int high=nums.length-1,low=0,middle=0;
    	int[] res = {-1,-1};
    	while(low<=high){
    		middle = (low+high)/2;
    		if(nums[middle]>target)
    			high = middle-1;
    		else if(nums[middle]<target)
    			low = middle+1;
    		else{
    			int p;
    			p=middle;
    			while(low<=p){
    				if(nums[(p+low)/2]<target)
    					low=(p+low)/2+1;
    				else if(nums[low]<target)
    					p=(p+low)/2-1;
    				else
    					break;
    			}
    			p=middle;
    			while(high>=p){
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
    
    /*
     * 7.2 Search Insert Position
     * 问题描述:在排序数组中查找指定元素所在位置或适当的插入位置
     * 算法:折半查找,若查找到则返回下标,若未找到,则插入位置为最后停止位置
     * 时间复杂度O(longn),空间复杂度O(1)
     */
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
    
    /*
     * 7.3 Search a 2D Matrix
     * 问题描述:按行、列递增的二维数组中(且每行元素都大于前一行),在其中查找指定元素
     * 算法:由右上角查找,若元素大于指定则去除一列,反之则去除一行
     * 时间复杂度O(m+n),空间复杂度O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(null==matrix || matrix.length<1 || matrix[0].length<1)
        	return false;
        for(int i=0,j=matrix[0].length-1;i<matrix.length && j>=0;){
        	if(matrix[i][j]<target)
        		i++;
        	else if(matrix[i][j]>target)
        		j--;
        	else
        		return true;
        }
        return false;
    }
}
