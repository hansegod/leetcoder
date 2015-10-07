package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	//============================================
	//============================================
	//============================================
	//====================������====================
	/*
	 * ����֪ʶ:
	 * 1.��k���������2^(k-1),(k>=1)
	 * 2.���m���ڵ���2^m-1,(m>=1) 
	 * 3.Ҷ�ӽ��ȶ�Ϊ���Ľ���һ,N0=N2+1
	 * 4.n�������С���[long2(n)]+1
	 * 
	 * 
	 */
	
	/*
	 * 5.1.1 Binary Tree Preorder Traversal
	 * ��������:ʵ�ֶ��������������
	 * �㷨:����ջ�洢���ڵ�,���α�����������
	 * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(n)
	 * 91% 94%
	 */
    public List<Integer> preorderTraversal_(TreeNode root) {
    	List<Integer> l=new LinkedList<Integer>();
    	Stack<TreeNode> sk=new Stack<TreeNode>();
    	while(null!=root || !sk.isEmpty()){
    		while(root!=null){
    			l.add(root.val);
    			sk.push(root);
    			root=root.left;
    		}
    		root=sk.pop();
    		root=root.right;
    	}
    	return l;
    }
    List<Integer> lp=new LinkedList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
    	pfun(root);
    	return lp;
    }
    public void pfun(TreeNode root){
    	if(null==root)
    		return;
    	lp.add(root.val);
    	pfun(root.left);
    	pfun(root.right);
    }
    
    /*
     * 5.1.2 Binary Tree Inorder Traversal
     * ��������:ʵ�ֶ��������������
     * 95%
     */
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> l=new LinkedList<Integer>();
    	Stack<TreeNode> sk=new Stack<TreeNode>();
    	while(null!=root || !sk.isEmpty()){
    		while(root!=null){
    			sk.push(root);
    			root=root.left;
    		}
    		root=sk.pop();
    		l.add(root.val);
    		root=root.right;
    	}
    	return l;
    }
    
    /*
     * 5.1.3 Binary Tree Postorder Traversal
     * ��������:ʵ�����ĺ������
     * �㷨:�ǵݹ�,�Ȳ��� ��-��-�����,Ȼ����ת�б�õ� ��-��-��
     */
    List<Integer> ll=new LinkedList<Integer>();
    public List<Integer> postorderTraversal_(TreeNode root) {
    	lfun(root);
    	return ll;
    }
    public void lfun(TreeNode root){
    	if(null==root)
    		return;
    	lfun(root.left);
    	lfun(root.right);
    	ll.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> l = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        while(root!=null || !st.isEmpty()){
        	while(root!=null){
        		l.add(root.val);
        		st.push(root);
        		root=root.right;
        	}
        	root=st.pop();
        	root=root.left;
        }
        for(int i=0,len = l.size()-1;len>0 && i<=len/2;i++){
        	int tmp;
        	tmp=l.get(i);
        	l.set(i,l.get(len-i));
        	l.set(len-i,tmp);
        }
        return l;
    }
    
    /*
     * 5.1.4 Binary Tree Level Order Traversal
     * ��������:��α���������
     * �㷨:�ö��д洢ÿ��ڵ�,��ÿ��ĩβ���null����ָʾһ��Ľ���,��ÿһ������б�
     * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(n)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new LinkedList<List<Integer>>();
        Queue<TreeNode> tq=new LinkedList<TreeNode>();
        while(root!=null || !tq.isEmpty()){
        	List<Integer> l=new LinkedList<Integer>();
        	tq.add(null);
        	while(root!=null){
        		l.add(root.val);
        		if(root.left!=null)
        			tq.add(root.left);
        		if(root.right!=null)
        			tq.add(root.right);
        		root=tq.poll();
        	}
        	list.add(l);
        	if(!tq.isEmpty())
        		root=tq.poll();
        }
        return list;
    }
    
    /*
     * 5.1.5 Binary Tree Level Order Traversal II
     * ��������:���������Ͳ����������ÿ��
     * �㷨:�ɵͲ���߲��ȡ�б���������
     * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(n)
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list=new LinkedList<List<Integer>>();
        Queue<TreeNode> tq=new LinkedList<TreeNode>();
        while(root!=null || !tq.isEmpty()){
        	List<Integer> l=new LinkedList<Integer>();
        	tq.add(null);
        	while(root!=null){
        		l.add(root.val);
        		if(root.left!=null)
        			tq.add(root.left);
        		if(root.right!=null)
        			tq.add(root.right);
        		root=tq.poll();
        	}
        	list.add(l);
        	if(!tq.isEmpty())
        		root=tq.poll();
        }
        List<List<Integer>> revlist=new LinkedList<List<Integer>>();
        for(List<Integer>i:list)
        	revlist.add(0,i);
        return revlist;
    }
    
    /*
     * 5.1.6 Binary Tree Zigzag Level Order Traversal
     * ��������:�ɸ���ʼZ���ΰ���α���������
     * �㷨:ʹ��ջ�ݴ溢�ӽ��,Ȼ��ȫ���������,���γ��ӷ��ʲ����뺢�ӽ��(���ñ�־λȷ�����Һ�����ջ˳��)
     * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(n)
     * 98%
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new LinkedList<List<Integer>>();
        Queue<TreeNode> tq=new LinkedList<TreeNode>();
        Stack<TreeNode> sk=new Stack<TreeNode>();
        TreeNode a,b;
        boolean dir=true;
        if(root!=null)
        	sk.push(root);
        while(!sk.isEmpty()){
        	List<Integer> l=new LinkedList<Integer>();
        	while(!sk.isEmpty())
        		tq.add(sk.pop());
        	while(!tq.isEmpty()){
        		root=tq.poll();
        		l.add(root.val);
        		a=dir?root.left:root.right;
        		b=dir?root.right:root.left;
        		if(a!=null)
        			sk.push(a);
        		if(b!=null)
        			sk.push(b);
        	}
        	dir=!dir;
        	list.add(l);
        }
        return list;
    }
    
    /*
     * 5.1.7 Recover Binary Search Tree
     * ��������:ʹ�ó����ռ�,�޸������������ڵ�λ�õ����������,���ı���ṹ
     * �㷨:�ݹ�(�����ռ䡢���ı����ṹ)������������(�����ռ䡢�ı����ṹ)���ǵݹ�ջ(���Կռ䡢���ı����ṹ)
     * �����������,�ɽ��������������,
     * 1.�������������ڵ�
     * 2.������λ���м�ڵ�
     * 3.���ڽ���
     * ����˵�����ֹ���:
     * 1 2 3 4 5 6 7 8 9
     * (����3,7)
     * (����1,7)
     * (����5,6)
     * ���Է��ֹ���,�������ǰһ�ڵ�>��һ�ڵ�ֵ,����ֻ����һ��,�������ε�ǰһ�δ���Ϊǰһ�ڵ�,�ڶ��δ����ں�һ�ڵ�
     * �㷨��˼���ǽ�����������ת��Ϊ���Խ��з���!!!!
     * ʱ�临�Ӷ�O(N),�ռ临�Ӷ�O(1)
     */
    TreeNode per,s1,s2;
    public void intravel(TreeNode root){
    	if(null==root)
    		return;
    	intravel(root.left);
    	if(null!=per&&per.val>root.val){
    		if(null==s1){
    			s1=per;
    			s2=root;
    		}
    		else
    			s2=root;
    	}
    	per=root;
    	intravel(root.right);
    }
    public void recoverTree(TreeNode root) {
    	per=s1=s2=null;
    	intravel(root);
    	int t=s1.val;
    	s1.val=s2.val;
    	s2.val=t;
    }
    
    /*
     * 5.1.8 Same Tree
     * ��������:�ж����ö������Ƿ���ͬ
     * �㷨:�ݹ��������������,�Ƚ��������������ڵ�ֵ
     * ʱ�临�Ӷ�O(N),�ռ临�Ӷ�O(1)
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)
        	return true;
        else if(p!=null&&q!=null){
        	if(p.val!=q.val)
        		return false;
        	else
        		return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }
        else
        	return false;
    }
    
    /*
     * 5.1.9 Symmetric Tree
     * ��������:�ж�һ�ö������Ƿ�Ϊ���������,�����ҶԳ�
     * �㷨:�ɸ��ڵ㰴�����������еݹ��������,�����������Գƽ��бȽ�
     * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(1)
     */
    public boolean isSymmetric(TreeNode root) {
        return mirror(root,root);
    }
    public boolean mirror(TreeNode p, TreeNode q){
    	if(p==null&&q==null)
    		return true;
    	else if((p!=null&&q==null)||(p==null&&q!=null))
    		return false;
    	else if(p.val!=q.val)
    		return false;
    	else
    		return mirror(p.left,q.right)&&mirror(p.right,q.left);
    }
    
    /*
     * 5.1.10 Balanced Binary Tree
     * ��������:�ж϶������Ƿ�ƽ��
     * �㷨:�ݹ�����ڵ������������Ȳ�,������������������,����ƽ�����ñ�־λ
     * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(n)
     * AVL��ÿ���ڵ㶼��ƽ���,Ҷ�ӽڵ����Ȳ���Դ���1,���ڵ����Ϊ1
     */
    boolean flag=true;
    public boolean isBalanced(TreeNode root) {
    	getLevel(root,0);
    	return flag;
    }
    public int getLevel(TreeNode root,int level){
    	if(null==root)
    		return level;
    	int left,right;
    	left=getLevel(root.left,level+1);
    	right=getLevel(root.right,level+1);
    	if(Math.abs(left-right)>1)
    		flag=false;
    	return left>right?left:right;
    }
    
    /*
     * 5.1.11 Flatten Binary Tree to Linked List
     * ��������:��������ת��Ϊ�Ҳ����ӵ�����
     * �㷨:���õݹ�,���������������д���
     * 1.�ջ��޺���(ֱ�ӷ��ظýڵ���Ϊ�����Ի�������ڵ�)
     * 2.������(���Ի����������������ڵ�)
     * 3.���Һ���(���������Ƶ�������,���Ի��������󷵻����ڵ�)
     * 4.�����Һ���(���Ի��������������ڵ�,���Ժ������������������,���Ի�ԭ���������������ڵ�)
     * �㷨2:�������Ϊ������������������,��������,�������޷������ڵ�,ʱ�临�Ӷȱ��㷨1��
     */
    public void flatten_(TreeNode root) {
    	link(root);
    }
    public TreeNode link(TreeNode root){
    	if(root==null||(root.left==null&&root.right==null))
    		return root;
    	else if(root.left==null&&root.right!=null)
    		return link(root.right);
    	else if(root.left!=null&&root.right==null){
    		root.right=root.left;
    		root.left=null;
    		return link(root.right);
    	}
    	else{
    		TreeNode t=link(root.left);
    		t.right=root.right;
    		root.right=root.left;
    		root.left=null;
    		return link(t.right);
    	}
    }
    public void flatten(TreeNode root) {
    	if(null==root)
    		return;
    	flatten(root.left);
    	flatten(root.right);
    	if(null==root.left)
    		return;
    	TreeNode t=root.left;
    	while(t.right!=null)
    		t=t.right;
    	t.right=root.right;
    	root.right=root.left;
    	root.left=null;
    }
    
    /*
     * 5.1.12 Populating Next Right Pointers in Each Node II
     * ��������:Ϊ��������Ӳ�����
     * �㷨:�ݹ�ֲ����,������ʱͷ�ڵ�ָʾ��һ��
     * ʱ�临�Ӷ�O(N),�ռ临�Ӷ�O(1)
     * ע��:dummy.next=nullָ��Ҫ�ָ�
     */
    TreeLinkNode dummy=new TreeLinkNode(-1),t;
    public void connect_(TreeLinkNode root) {
        if(null==root)
        	return;
        t=dummy;
        dummy.next=null;
        while(root!=null){
        	if(root.left!=null){
        		t.next=root.left;
        		t=t.next;
        	}
        	if(root.right!=null){
        		t.next=root.right;
        		t=t.next;
        	}
        	root=root.next;
        }
        connect(dummy.next);
    }
    
    /*
     * 5.2.1 Construct Binary Tree from Preorder and Inorder Traversal
     * ��������:����ǰ�������������������(���ظ�Ԫ��)
     * �㷨:һ�ζ�ȡǰ��ڵ�,���ݸýڵ㻮������,���ֵ���������Ϊ�ýڵ������������Ա,��������
     * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(1)
     */
    int pt=0;
    public TreeNode buildTree_(int[] preorder, int[] inorder) {
    	if(preorder==null||inorder==null||preorder.length<1||inorder.length<1)
        	return null;
    	TreeNode root=new TreeNode(-1);
    	build(root,preorder,inorder,0,preorder.length-1);
    	return root;
    }
    public void build_(TreeNode root,int[] preorder,int[] inorder,int start,int end){
    	if(pt>preorder.length-1)
    		return;
    	int i=find(inorder,start,end,preorder[pt++]);
    	root.val=inorder[i];
    	if(i>start){
    		TreeNode t=new TreeNode(-1);
    		root.left=t;
    		build(t,preorder,inorder,start,i-1);
    	}
    	if(i<end){
    		TreeNode t=new TreeNode(-1);
    		root.right=t;
    		build(t,preorder,inorder,i+1,end);
    	}
    }
    public int find(int[] inorder,int start,int end,int target){
    	while(start<=end){
    		if(inorder[start]==target)
    			return start;
    		else
    			start++;
    	}
    	return -1;
    }
    
    /*
     * 5.2.2 Construct Binary Tree from Inorder and Postorder Traversal
     * ��������:���ݺ��������������(���ظ�Ԫ��)
     * �㷨:ͬ��,����������ɨ��,���ҵݹ�ʱ������������
     * 
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(postorder==null||inorder==null||postorder.length<1||inorder.length<1)
        	return null;
    	pt=postorder.length-1;
    	TreeNode root=new TreeNode(-1);
    	build(root,postorder,inorder,0,postorder.length-1);
    	return root;
    }
    public void build(TreeNode root,int[] postorder,int[] inorder,int start,int end){
    	if(pt<0)
    		return;
    	int i=find(inorder,start,end,postorder[pt--]);
    	root.val=inorder[i];
    	if(i<end){
    		TreeNode t=new TreeNode(-1);
    		root.right=t;
    		build(t,postorder,inorder,i+1,end);
    	}
    	if(i>start){
    		TreeNode t=new TreeNode(-1);
    		root.left=t;
    		build(t,postorder,inorder,start,i-1);
    	}
    }
    
    /*
     * 5.3.1 Unique Binary Search Trees
     * ��������:����1~n���������������
     * �㷨:
     * 1.n=0,f(0)=1
     * 2.n=1,f(1)=1
     * 3.n=2,f(2)=2
     * ��������,��1~n�е�ÿ������Ϊ��,���ܵ����Ϊ��ǰ��������Ϊ����������������������ܵĳ˻�,Ȼ�󽫸�����������
     * ������ǰ�������ݵĿ������,ֻ��ڵ���Ŀ�й�,
     */
    public int numTrees(int n) {
    	if(n<0)
    		return 0;
    	else if(n<2)
    		return 1;
    	int[] M=new int[n+1];
    	M[0]=1;
    	M[1]=1;
        return subTrees(M,n);
    }
    public int subTrees(int[] M,int n){
    	for(int i=1;i<=n;i++){
    		M[i-1]=M[i-1]==0?subTrees(M,i-1):M[i-1];
    		M[n-i]=M[n-i]==0?subTrees(M,n-i):M[n-i];
    		M[n]+=M[i-1]*M[n-i];
    	}
    	return M[n];
    }
    
    /*
     * 5.3.2 Unique Binary Search Trees II
     * ��������:��1~n���ɵ��������������
     * �㷨:����ѡȡԪ��Ϊ��,���ҵݹ�Ȼ�����!!!!
     * http://www.cnblogs.com/springfor/p/3884029.html
     */
    public List<TreeNode> generateTrees(int n) {
    	return buildBST(1,n);
    }
    private ArrayList<TreeNode> buildBST(int s,int e){
        ArrayList<TreeNode> rst=new ArrayList<>();
        if(s>e){
            rst.add(null);
            return rst;
        }
        for(int i=s;i<=e;i++){
            ArrayList<TreeNode> lefts=buildBST(s,i-1);
            ArrayList<TreeNode> rights=buildBST(i+1,e);
            for(TreeNode left:lefts){
                for(TreeNode right:rights){
                    TreeNode node=new TreeNode(i);
                    node.left=left;
                    node.right=right;
                    rst.add(node);
                }
            }
        }
        return rst;
    }
    
    /*
     * 5.3.3 Validate Binary Search Tree
     * ��������:�ж϶������Ƿ�Ϊ���������
     * �㷨:�������,�жϵ�ǰ�ڵ�ֵ�Ƿ����֮ǰ�ڵ�ֵ(ע���ʼ�������Ĵ���)
     * ʱ�临�Ӷ�O(N),�ռ临��O(1)
     */
    int perval;
    boolean pervalinit;
    public boolean isValidBST(TreeNode root) {
    	if(root==null)
    		return true;
    	if(!isValidBST(root.left))
    		return false;
    	if(perval>=root.val && pervalinit)
    		return false;
    	else{
    		perval=root.val;
    		pervalinit=true;
    	}
    	if(!isValidBST(root.right))
    		return false;
    	return true;
    }
    
    /*
     * 5.3.4 Convert Sorted Array to Binary Search Tree
     * ��������:��������������������������
     * �㷨:���ö��ַ���ȡ����,�����������ɽڵ㼰��������������
     *     ȡ�����е�Ϊ���ڵ�,�������������Ϊ��������,�ݹ�ֱ�����ֵ��������СΪ0
     * ʱ�临�Ӷ�O(N),�ռ临�Ӷ�O(N)
     * 
     */
    public TreeNode sortedArrayToBST_(int[] nums) {
        if(null==nums||nums.length<1)
        	return null;
        TreeNode root=new TreeNode(Integer.MIN_VALUE);
        buildBST_(nums,0,nums.length-1,root);
        return root.right;
    }
    public void buildBST_(int[] nums,int s,int e,TreeNode root){
    	if(s>e)
    		return;
    	int mid=(s+e)/2;
    	TreeNode t=new TreeNode(nums[mid]);
    	if(root.val>nums[mid])
    		root.left=t;
    	else
    		root.right=t;
    	buildBST_(nums,s,mid-1,t);
    	buildBST_(nums,mid+1,e,t);
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if(null==nums||nums.length<1)
        	return null;
        return buildBST(nums,0,nums.length-1);
    }
    public TreeNode buildBST(int[] nums,int s,int e){
    	if(s>e)
    		return null;
    	int mid=(s+e)/2;
    	TreeNode root=new TreeNode(nums[mid]);
    	root.left=buildBST(nums,s,mid-1);
    	root.right=buildBST(nums,mid+1,e);
    	return root;
    }
    
    /*
     * 5.3.5 Convert Sorted List to Binary Search Tree
     * ��������:���ݵ�����������ݹ������������
     * �㷨:����ݹ�!!!!
     * http://blog.csdn.net/worldwindjp/article/details/39722643
     * ʱ�临�Ӷ�O(N),�ռ临�Ӷ�O(1)
     * 
     */
    ListNode curHd = null;
    public TreeNode sortedListToBST(ListNode head){  
        if(head==null) 
            return null;
        curHd=head;  
        int len=0;  
        while(head!=null){  
            len++;  
            head = head.next;  
        }
        return buildTree(0,len-1);  
    }
    TreeNode buildTree(int s,int e){  
        if(s>e) 
            return null;
        int mid=s+(e-s)/2;  
        TreeNode left=buildTree(s,mid-1);  
        TreeNode root=new TreeNode(curHd.val);  
        root.left=left;  
        curHd=curHd.next;  
        root.right=buildTree(mid+1,e);  
        return root;  
    }
    
    /*
     * 5.4.1 Minimum Depth of Binary Tree
     * ��������:�������������С���
     * �㷨:�����������,����null�ָ���,�������������
     * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(n)
     */
    public int minDepth(TreeNode root) {
        if(null==root)
        	return 0;
        int deep=1;
        Queue<TreeNode> qt=new LinkedList<TreeNode>();
        qt.add(root);
        qt.add(null);
        while(!qt.isEmpty()){
        	TreeNode t=qt.poll();
        	if(null==t){
        		deep++;
        		qt.add(null);
        	}
        	else if(t.left==null&&t.right==null)
        		break;
        	else{
        		if(t.left!=null)
        			qt.add(t.left);
        		if(t.right!=null)
        			qt.add(t.right);
        	}	
        }
        return deep;
    }
    
    /*
     * 5.4.2 Maximum Depth of Binary Tree
     * ��������:�����������������
     * �㷨:�ݹ�������������������ȡ���ֵ��1
     * ʱ�临�Ӷ�O(N),�ռ临�Ӷ�O(1)
     */
    public int maxDepth(TreeNode root) {
        if(null==root)
        	return 0;
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    
    /*
     * 5.4.3 Path Sum
     * ��������:�ж϶��������Ƿ����·��ʹ��·����Ϊ����ֵ
     * �㷨:����ֵ��ȥ�ڵ�ֵȻ��ݹ������������,ֱ�����ҵ�Ҷ�ӽڵ�,ֻҪ��һ��·������
     * ʱ�临�Ӷ�O(N),�ռ临�Ӷ�O(1)
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(null==root)
        	return false;
        else if(root.val==sum&&null==root.left&&null==root.right)
        	return true;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
    
    /*
     * 5.4.4 Path Sum II
     * ��������:Ѱ�Ҷ����������и���Ҷ��Ϊָ��ֵ��·��
     * �㷨:����ȫ�ֱ����洢����·�����͵�ǰ����·��,Ȼ��ݹ�����������������ж�·���Ƿ����Ҫ��
     * ʱ�临�Ӷ�O(N),�ռ临�Ӷ�O(N)
     * ע��Է�������·���Ĵ���:
     * 1.��Ҷ�ڵ����·����ʱ�洢�б�
     * 2.����·��������������
     * 3.��Ҷ�ڵ����ʱ·����ɾ��
     */
    List<List<Integer>> list=new ArrayList<List<Integer>>();
    List<Integer> tmplist=new LinkedList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	if(null==root)
    		return list;
    	else if(root.val==sum&&root.left==null&&root.right==null){
    		List<Integer> t=new LinkedList<Integer>();
    		tmplist.add(root.val);
    		t.addAll(tmplist);
    		list.add(t);
    		tmplist.remove(tmplist.size()-1);
    		return list;
    	}
    	tmplist.add(root.val);
    	pathSum(root.left,sum-root.val);
    	pathSum(root.right,sum-root.val);
    	tmplist.remove(tmplist.size()-1);
    	return list;
    }
    
    /*
     * 5.4.5 Binary Tree Maximum Path Sum
     * ��������:Ѱ�Ҷ�������·��Ȩֵ�����ֵ
     * �㷨:�ݹ���ڵ�,�жϽڵ�ֵ,�ڵ�+������,�ڵ�+������(ǰ�����������ֵ���ڷ���),������+�ڵ�+���������ֵ��ȫ�����Ƚ�
     * ע����������һ�䷵��,root.val + (Math.max(left,right)>0?Math.max(left,right):0)���������
     */
    int MAX_PATH;
    public int maxPathSum(TreeNode root) {
    	MAX_PATH=Integer.MIN_VALUE;
    	maxPath(root);
        return MAX_PATH;
    }
    public int maxPath(TreeNode root){
        if(null==root)
        	return 0;
        int left=maxPath(root.left);
        int right=maxPath(root.right);
        int sum=root.val+(left>0?left:0)+(right>0?right:0);
        MAX_PATH=Math.max(MAX_PATH,sum);
        return root.val + (Math.max(left,right)>0?Math.max(left,right):0);
    }
    
    /*
     * 5.4.6 Populating Next Right Pointers in Each Node
     * ��������:��������������������
     * �㷨:��������������һ��
     * ʱ�临�Ӷ�O(longN),�ռ临�Ӷ�O(1)
     */
    public void connect(TreeLinkNode root) {
    	if(null==root)
    		return;
        TreeLinkNode head=new TreeLinkNode(-1),t=head;
        while(root!=null){
        	if(root.left!=null){
        		t.next=root.left;
        		t=t.next;
        	}
        	if(root.right!=null){
        		t.next=root.right;
        		t=t.next;
        	}
        	root=root.next;
        }
        connect(head.next);
    }
    
    /*
     * 5.4.7 Sum Root to Leaf Numbers
     * ��������:����������и�-Ҷ·�����Ⱥ�
     * �㷨:���ݵ�ǰ·�������ݹ���������,ΪҶʱ���㵱ǰ·�����������ܺ�
     * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(1)
     */
    int PATH_SUM;
    public int sumNumbers(TreeNode root) {
        PATH_SUM=0;
        sumPath(root,0);
        return PATH_SUM;
    }
    public void sumPath(TreeNode root,int sum){
    	if(null==root)
    		return;
    	else if(root.left==null&&root.right==null){
    		PATH_SUM+=sum*10+root.val;
    		return;
    	}
    	else{
    		sumPath(root.left,sum*10+root.val);
    		sumPath(root.right,sum*10+root.val);
    	}
    }
}
