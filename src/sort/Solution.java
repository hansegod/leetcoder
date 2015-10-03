package sort;

import java.util.Arrays;

import linklist.ListNode;

public class Solution {
	//============================================
	//============================================
	//============================================
	//=====================����====================
	/*
	 * �ڲ�����:
	 * 		1.��������(ֱ�Ӳ������� ϣ������)
	 * 		2.ѡ������(��ѡ������ ��Ԫѡ������ ������)
	 * 		3.��������(ð������ ��������)
	 * 		4.�鲢����
	 * 		5.��������
	 */
	
	/*
	 * 6.1 Merge Sorted Array
	 * ��������:��һ������ϲ�����һ���㹻�ռ������
	 * �㷨:��������ĩβ��ǰɨ��Ƚ�,Ȼ�����ϲ�������λ��
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
     * ��������:�ϲ��������������
     * �㷨:���αȽ����б�Ԫ��,����������б�
     * ʱ�临�Ӷ�O(m+n),�ռ临�Ӷ�O(1)
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
     * ��������:�ϲ�k����������
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
     * ��������:ʹ�ò�����������
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
     * ��������:nlog2n��������
     * �㷨:ʹ�ÿ���ָ��ָ�����,�Ե�������ݹ������鲢
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
	 * ��������:��������������,��һ��ȱʧ��������
	 * �㷨:�����������,���αȽ�ÿ���Ǹ�����ֵ����,���ط�����������
	 * 99%
	 * ������ģ��HashMap
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
     * ��������:������ɫ�����尴�� �� ������
     * �㷨:������ɫ���м�б�,���ζ�ȡ������,���н���
     * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(1)
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
