package linklist;

import java.util.HashMap;

public class Solution {
	//============================================
	//============================================
	//============================================
	//=====================链表====================
    /*
     * 2.2.1 Add Two Numbers
     * 问题描述:使用链表按位逆序存储的两个非负整数,用同样方式表示其和
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * Output: 7 -> 0 -> 8
	 * 算法:
	 * 1.暂存链表1头引用,用于链表1存储两数的和
	 * 2.在链表2全部读取完之前,若链表1已读取完,或链表2读取完,但进位非0,这两种情况下需要加长链表1
	 * 3.如果还有进位则运算进位与链表1中余下元素的和,若链表1长度不够需要加长
	 * 4.返回之前保存的链表1头引用为所求
	 * 时间复杂度O(m+n),空间复杂度O(m-n)
	 * 98%
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null || l2==null)
        	return l1==null?l2:l1;
        int a=0,b=0,c=0,d=0;
        ListNode t=l1;
        while(l2!=null){
        	a=l1.val;
        	b=l2.val;
        	d=a+b+c;
        	c=d/10;
        	d=d%10;
        	l1.val=d;
        	if(l1.next==null && (l2.next!=null || c>0)){
        		ListNode h=new ListNode(0);
        		l1.next=h;
        	}
        	l1=l1.next;
        	l2=l2.next;
        }
        while(c>0){
        	a=l1.val;
        	d=a+c;
        	c=d/10;
        	d=d%10;
        	l1.val=d;
        	if(l1.next==null && c>0){
        		ListNode h=new ListNode(0);
        		l1.next=h;
        	}
        	l1=l1.next;
        }
        return t;
    }
    
    /*
     * 2.2.2 Reverse Linked List II
     * 问题描述:逆序链表中指定段的数据,从1开始计数
     * 算法:
     * 1.设立头结点及计数器,数到指定段的段头
     * 2.将段头元素后指定数目元素逆序插入到段头前
     * 时间复杂度O(n),空间复杂度O(1)
     * 94%
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m<0||n<0||n<=m)
        	return head;
        ListNode h = new ListNode(-1),per=h,pm,t;
        h.next=head;
        int count=1;
        while(per!=null && count<m){
        	per=per.next;
        	count++;
        }
        if(per==null)
        	return head;
        pm=per.next;
        while(pm!=null && pm.next!=null && count<n){
        	t=pm.next;
        	pm.next=t.next;
        	t.next=per.next;
        	per.next=t;
        	count++;
        }
        return h.next;
    }
    
    /*
     * 2.2.4 Remove Duplicates from Sorted List
     * 问题描述:去掉有序列表中多余的重复元素
     * 算法:设立前后两个链表引用,若所引用元素值相等则跳过该元素,否则两个引用分别直向下一个元素
     * 时间复杂度O(n),空间复杂度O(1)
     * 90%
     */
    public ListNode deleteDuplicates_(ListNode head) {
    	if(null==head || null==head.next)
    		return head;
    	ListNode p=head,t=head.next,s;
    	while(null!=t){
    		if(p.val==t.val){
    			s=t;
    			t=t.next;
    			p.next=t;
    			s.next=null;
    		}
    		else{
    			p=t;
    			t=t.next;
    		}
    	}
        return head;
    }
    
    /* 2.2.5 Remove Duplicates from Sorted List II
     * 问题描述:去除有序链表中所有重复元素
     * 算法:设立两个相邻的前后链表引用及标志位来标识是否有重复,两个引用向后滑动,当值不等时标识位置位,
     *    当两值不等时,若标志位置位,则恢复标志位,若标志位非置位,则将前一引用加入目标链表,依次类推,
     *    直至前一引用为空,此时,有两种可能,标志位为置位,则表示没有新的可加入元素,反之,将前一引用元素
     *    加入目标链表.
     *    特殊情况:null,len<2,1 1 2 2(连续两个相同),1 1 2(末尾为独立元素)
     * 时间复杂度O(n),空间复杂度O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
    	if(null==head || null==head.next)
    		return head;
    	ListNode h=new ListNode(-1),p,t,s;
    	boolean flag=false;
    	h.next=head;
    	p=h;
    	s=head;
    	t=head.next;
    	while(t!=null){
    		if(s.val==t.val)
    			flag=true;
    		else if(false==flag){
    			p.next=s;
    			p=p.next;
    		}
    		else
    			flag=false;
    		s=t;
			t=t.next;
    	}
    	if(!flag){
    		p.next=s;
    		p=p.next;
    	}
    	p.next=null;
    	return h.next;
    }
    
    /*
     * 2.2.6 Rotate List
     * 问题描述:将链表沿末尾K处选装,{1 2 3 4 5},2 -> {4 5 1 2 3}
     * 算法:计算链表长度,k对长度取模,链表空或模长为0则返回原链表
     *    使用计数器及快慢指针查找到第k个位置,调整链表顺序(注意移动时的对应关系)
     * 时间复杂度O(n),空间复杂度O(1)
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k<=0)
        	return head;
        ListNode h=new ListNode(-1),s,t;
        h.next=head;
        int len=0;
        t=head;
        while(t!=null){
        	t=t.next;
        	len++;
        }
        k%=len;
        if(0==k || len<2)
        	return head;
        t=head;
        while(k>0){
        	t=t.next;
        	k--;
        }
        s=head;
        while(t!=null && null!=t.next){
        	s=s.next;
        	t=t.next;
        }
        t.next=h.next;
        h.next=s.next;
        s.next=null;
        
        return h.next;
    }
    
    
    /*
     * 2.2.7 Remove Nth Node From End of List
     * 问题描述:删除链表末尾第n个元素,令n一定存在,要求一次遍历
     * 算法:快慢指针定位倒数第n元
     * 时间复杂度O(n),空间复杂度O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || n<=0)
        	return head;
        ListNode h=new ListNode(-1),s,t;
        h.next=head;
        t=h;
        while(n>0){
        	t=t.next;
        	n--;
        }
        s=h;
        while(t!=null && t.next!=null){
        	s=s.next;
        	t=t.next;
        }
        s.next=s.next.next;
        return h.next;
    }
    
    /*
     * 2.2.8 Swap Nodes in Pairs
     * 问题描述:交换链表中的相邻元素,只能交换结点
     * 算法:增加头结点,设置三个指针用于交换相邻,以三为步长向前滑动,直至链表末尾
     * 时间复杂度O(n),空间复杂度O(1)
     */
    public ListNode swapPairs(ListNode head) {
    	ListNode h=new ListNode(-1),s,t,p;
    	h.next=head;
    	p=h;
    	while(p!=null && p.next!=null && p.next.next!=null){
    		s=p.next;
    		t=p.next.next;
    		p.next=t;
    		s.next=t.next;
    		t.next=s;
    		p=s;
    	}
    	return h.next;
    }
    
    /*
     * 2.2.9 Reverse Nodes in k-Group
     * 问题描述:对链表每k个元素为一组翻转
     * 算法描述:设立三个指针,前一组末尾,下一组开始,下下一组的开始,如果当前一组元素数目不足则停止,
     * 		 否则,采用头插法将组内元素插入到开始元素前,使其逆序
     * 时间复杂度O(n),空间复杂度O(1)	
     */
    public ListNode reverseKGroup(ListNode head, int k) {
    	if(null==head || k<2)
    		return head;
    	ListNode h=new ListNode(-1),s,t,p,r;
    	int glen=0;h.next=head;
    	p=h;
    	t=head;
    	s=head;
    	while(t!=null){
    		while(t!=null&&glen<k){
    			t=t.next;
    			glen++;
    		}
    		if(glen<k)
    			return h.next;
    		while(s.next!=t){
    			r=s.next;
    			s.next=r.next;
    			r.next=p.next;
    			p.next=r;
    		}
    		p=s;
    		s=t;
    		glen=0;
    	}
    	return h.next;
    }
    
    /*
     * 2.2.10 Copy List with Random Pointer
     * 问题描述:链表中含有一个随机的指针指向下一元素,拷贝这个链表
     * 算法:1.在原链表后插入其拷贝
     *    2.遍历新链表,利用线性的相对关系拷贝随机指针
     *    3.从新链表中摘下拷贝链表并恢复原链表
     * 时间复杂度:O(n),空间复杂度O(n)
     * 100%
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if(null==head)
        	return head;
        RandomListNode h=new RandomListNode(-1),p=head,t;
        while(p!=null){
        	t=new RandomListNode(p.label);
        	t.next=p.next;
        	p.next=t;
        	p=t.next;
        }
        h.next=head.next;
        p=head;
        t=head.next;
        while(t!=null){
        	if(p.random!=null)
        		t.random=p.random.next;
        	if(t.next!=null){
        		p=t.next;
        		t=p.next;
        	}
        	else
        		break;
        }
        p=head;
        t=head.next;
        while(t!=null){
        	p.next=t.next;
        	p=p.next;
        	if(p!=null)
        		t.next=p.next;
        	else
        		t.next=null;
        	t=t.next;	
        }
        return h.next;
    }
    
    
    /*
     * 2.2.11 Linked List Cycle
     * 问题描述:判断链表是否包含环
     * 算法:使用快慢指针,若指针指向null则无环,或快慢指针相等,则有环
     * 时间复杂度:O(n),空间复杂度O(1)
     */
    public boolean hasCycle_(ListNode head) {
    	ListNode s=head,f=head;
    	while(f!=null){
    		if(f.next!=null && f.next.next!=null)
    			f=f.next.next;
    		else
    			return false;
    		s=s.next;
    		if(s==f)
    			return true;
    	}
    	return false;
    }
    
    /*
     * 2.2.12 Linked List Cycle II
     * 问题描述:若链表含有环则返回环入口所在位置,若不存在则返回null
     * 算法:一个指针步长为2,一个指针步长为1,当两指针相遇时,第三个指针由链头
     * 步长1出发,两步长1指针相遇时所走过的路程为入口坐标;
     * 表长L,入口x,环长r,快慢指针相遇在环内a处,由两指针距离关系可得:n*r=x+a,n>=1
     * 推到得x=(n-1)r+(L-x-a),可得两慢指针在环入口处相遇
     * 时间复杂度O(n),空间复杂度O(1)
     * 99.23%
     */
    public ListNode detectCycle(ListNode head) {
        ListNode s,f,t;
        s=f=t=head;
        while(f!=null){
        	if(f.next==null || f.next.next==null)
        		return null;
        	s=s.next;
        	f=f.next.next;
        	if(s==f){
        		while(s!=null){
        			if(s==t)
        				return s;
        			s=s.next;
        			t=t.next;
        		}
        	}
        }
        return null;
    }
    
    /*
     * 2.2.13 Reorder List
     * 问题描述:将链表重排为, L0 → Ln → L1 →Ln−1 → L2 → Ln−2 → ···
     * 算法:快慢指针找到中心点,将中心点后元素逆序,中心点后元素依次插入中心点前各元素后
     * 时间复杂度O(n),空间复杂度O(1)
     */
    public void reorderList(ListNode head) {
        if(null==head||head.next==null||head.next.next==null)
        	return;
        ListNode s,t,p;
        s=t=p=head;
        while(t!=null&&t.next!=null){
        	if(t.next.next!=null)
        		t=t.next.next;
        	else
        		t=t.next;
        	s=s.next;
        }
        p=s.next;
        t=p.next;
        while(t!=null){
        	p.next=t.next;
        	t.next=s.next;
        	s.next=t;
        	t=p.next;
        }
        p=head;
        t=s.next;
        while(t!=null){
        	s.next=t.next;
        	t.next=p.next;
        	p.next=t;
        	t=s.next;
        	p=p.next.next;
        }
     }
    
	/*
	 * 2.2.14 LRU Cache
	 * 问题描述:实现LRU,最近最少使用
	 * 算法:
	 * 采用HashMap + 双向链表   为数据结构,
	 * 设立链表头尾结点,
	 * get(key)			1.存在key		->	1.为首元直接(返值)
	 * 									2,非首元(摘下,置顶,返值)
	 * 					2.不存在key	->	返回-1
	 * set(key,value)	1.存在key		->	(摘下,置顶,设值)
	 * 					2.不存在key	->	1.链表非满(加入键值,置顶,长度加1)
	 * 									2.链表满(加加入键值,置顶,摘尾元)
	 * 可总结为两种操作,置顶+摘元,设立头尾结点可使得操作统一
	 * 94%
	 */
public class LRUCache {
    HashMap<Integer, DoubleLinkedListNode> c=null;
    DoubleLinkedListNode first=null,end=null;
    int len=0,capacity=0;
    public LRUCache(int capacity) {
        c=new HashMap<Integer, DoubleLinkedListNode>();
    	first=new DoubleLinkedListNode(-1,Integer.MIN_VALUE);
    	end=new DoubleLinkedListNode(-1,Integer.MIN_VALUE);
    	this.capacity=capacity;
    	first.next=end;
    	end.pre=first;
    }
    public int get(int key) {
    	if(!c.containsKey(key))
    		return -1;
    	else{
    		DoubleLinkedListNode t;
    		t=c.get(key);
    		if(t.pre!=first){
    			TakeOff(t);
    			First(t);
    		}
    		return t.val;
    	}
    }
    public void set(int key, int value) {
    	if(c.containsKey(key)){
    		DoubleLinkedListNode t;
    		t=c.get(key);
    		TakeOff(t);
    		First(t);
    		t.val=value;
    	}
    	else{
    		DoubleLinkedListNode v=new DoubleLinkedListNode(key,value);
    		c.put(key, v);
    		if(len<capacity){
    			First(v);
    			len++;
    		}
    		else{
    			First(v);
    			v=end.pre;
    			TakeOff(end.pre);
    			c.remove(v.key);
    		}
    	}
    }
    void TakeOff(DoubleLinkedListNode n){
    	n.next.pre=n.pre;
    	n.pre.next=n.next;
    }
    void First(DoubleLinkedListNode n){
    	n.next=first.next;
    	first.next=n;
    	n.pre=first;
    	n.next.pre=n;
    }
    
    class DoubleLinkedListNode {
    	public int val;
    	public int key;
    	public DoubleLinkedListNode pre;
    	public DoubleLinkedListNode next;
    	public DoubleLinkedListNode(int key, int value) {
    		val = value;
    		this.key = key;
    	}
    }
}


}