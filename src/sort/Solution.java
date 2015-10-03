package sort;

import java.util.Arrays;

import linklist.ListNode;

public class Solution {
	//============================================
	//============================================
	//============================================
	//=====================排序====================
	/*
	 * 内部排序:
	 * 		1.插入排序(直接插入排序 希尔排序)
	 * 		2.选择排序(简单选择排序 二元选择排序 堆排序)
	 * 		3.交换排序(冒泡排序 快速排序)
	 * 		4.归并排序
	 * 		5.基数排序
	 */
	
	/*
	 * 6.1 Merge Sorted Array
	 * 问题描述:将一个数组合并到另一有足够空间的数组
	 * 算法:两数组由末尾向前扫描比较,然后放入合并后最终位置
	 * 99%
	 */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int i=m-1,j=n-1,t=m+n-1;
    	while(j>=0){
    		if(i>=0)
    			nums1[t--]=nums1[i]>nums2[j]?nums1[i--]:nums2[j--];
    		else
    			nums1[t--]=nums2[j--];
    	}
    }
    
    /*
     * 6.2 Merge Two Sorted Lists
     * 问题描述:合并两个排序的链表
     * 算法:依次比较两列表元素,插入第三个列表
     * 时间复杂度O(m+n),空间复杂度O(1)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(-1),t=head;
        while(l1!=null&&l2!=null){
        	if(l1.val<l2.val){
        		t.next = l1;
        		l1=l1.next;
        	}
        	else{
        		t.next = l2;
        		l2=l2.next;
        	}
        	t = t.next;
        }
        t.next=(l1!=null)?l1:l2;
    	return head.next;
    }
    
    /*
     * 6.3 Merge k Sorted Lists
     * 问题描述:合并k个有序链表
     * 
     */
    public ListNode mergeKLists(ListNode[] lists) {
    	if(null==lists || lists.length<1)
    		return null;
        ListNode t=lists[0];
        for(int i=1;i<lists.length;i++)
        	t=mergeTwoLists(t,lists[i]);
    	return t;
    }
    
    /*
     * 6.4 Insertion Sort List
     * 问题描述:使用插入排序链表
     * 92%
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode h=new ListNode(-1),t=h,tp;
        while(head!=null){
        	t=h;
        	while(t.next!=null && t.next.val<head.val)
        		t=t.next;
        	tp=t.next;
        	t.next=head;
        	head=head.next;
        	t.next.next=tp;
        }
    	return h.next;
    }
    
    /*
     * 6.5 Sort List
     * 问题描述:nlog2n排序链表
     * 算法:使用快慢指针分割链表,对单个链表递归排序后归并
     * 91%
     */
	public ListNode sortList(ListNode head) {
		if(head==null || head.next==null)
			return head;
		ListNode fast=head,slow=head;
		while(fast!=null&&fast.next!=null&&fast.next.next!=null){
			fast=fast.next.next;
			slow=slow.next;	
		}
		fast=slow;
		slow=slow.next;
		fast.next=null;
		fast=sortList(head);
		slow=sortList(slow);
		return mergeTwoLists(fast,slow);
	}
	
	/*
	 * 6.6 First Missing Positive
	 * 问题描述:查找乱序数组中,第一个缺失的正整数
	 * 算法:对数组排序后,依次比较每个非负递增值的数,返回非连续的整数
	 * 99%
	 * 还可以模拟HashMap
	 * http://blog.csdn.net/SunnyYoona/article/details/42683405
	 */
    public int firstMissingPositive(int[] nums) {
        int i=0,p=1;
        Arrays.sort(nums);
        while(i<nums.length && nums[i]<=0)
        	i++;
        while(i<nums.length){
    		while(i+1<nums.length && nums[i]==nums[i+1])
    			i++;
    		if(nums[i]<=p)
    			p++;
    		else
    			break;
    		i++;
        }
        return p;
    }
    
    /*
     * 6.7 Sort Colors
     * 问题描述:将三种色的物体按红 白 篮排序
     * 算法:两种颜色向中间夹逼,依次读取各物体,进行交换
     * 时间复杂度O(n),空间复杂度O(1)
     */
    void sortColors(int[] nums){
    	int r=0,i=0,t=0,b=nums.length-1;
    	while(i<=b){
    		if(1==nums[i])
    			i++;
    		else if(2==nums[i]){
    			t=nums[b];
    			nums[b--]=nums[i];
    			nums[i]=t;
    		}
    		else if(0==nums[i]){
    			t=nums[r];
    			nums[r++]=nums[i];
    			nums[i++]=t;
    		}
    	}
    }
}
