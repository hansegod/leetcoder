package search;

public class Solution {
	//============================================
	//============================================
	//============================================
	//=====================����====================
	/*
	 * 7.1 Search for a Range
	 * ��������:�������������,����ָ����ֵ����ֹλ��,�����ڷ���(-1,-1)
	 * �㷨����:�����۰����,�ҵ�ָ��ֵ��,������ȷ���߽�
	 * ʱ�临�Ӷ�O(longn),�ռ临�Ӷ�O(1)
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
     * ��������:�����������в���ָ��Ԫ������λ�û��ʵ��Ĳ���λ��
     * �㷨:�۰����,�����ҵ��򷵻��±�,��δ�ҵ�,�����λ��Ϊ���ֹͣλ��
     * ʱ�临�Ӷ�O(longn),�ռ临�Ӷ�O(1)
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
     * ��������:���С��е����Ķ�ά������(��ÿ��Ԫ�ض�����ǰһ��),�����в���ָ��Ԫ��
     * �㷨:�����Ͻǲ���,��Ԫ�ش���ָ����ȥ��һ��,��֮��ȥ��һ��
     * ʱ�临�Ӷ�O(m+n),�ռ临�Ӷ�O(1)
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
