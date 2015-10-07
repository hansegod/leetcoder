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
	//====================二叉树====================
	/*
	 * 背景知识:
	 * 1.第k层最多结点数2^(k-1),(k>=1)
	 * 2.深度m最多节点数2^m-1,(m>=1) 
	 * 3.叶子结点比度为二的结点多一,N0=N2+1
	 * 4.n个结点最小深度[long2(n)]+1
	 * 
	 * 
	 */
	
	/*
	 * 5.1.1 Binary Tree Preorder Traversal
	 * 问题描述:实现二叉树的先序遍历
	 * 算法:采用栈存储根节点,依次遍历左右子树
	 * 时间复杂度O(n),空间复杂度O(n)
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
     * 问题描述:实现二叉树的中序遍历
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
     * 问题描述:实现树的后序遍历
     * 算法:非递归,先采用 根-右-左遍历,然后逆转列表得到 左-右-根
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
     * 问题描述:层次遍历二叉树
     * 算法:用队列存储每层节点,在每层末尾添加null用于指示一层的结束,将每一层加入列表
     * 时间复杂度O(n),空间复杂度O(n)
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
     * 问题描述:由最深层向低层输出二叉树每层
     * 算法:由低层向高层获取列表后进行逆序
     * 时间复杂度O(n),空间复杂度O(n)
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
     * 问题描述:由根开始Z字形按层次遍历二叉树
     * 算法:使用栈暂存孩子结点,然后全部加入队列,依次出队访问并加入孩子结点(设置标志位确定左右孩子入栈顺序)
     * 时间复杂度O(n),空间复杂度O(n)
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
     * 问题描述:使用常量空间,修复调换了两个节点位置的排序二叉树,不改变其结构
     * 算法:递归(常量空间、不改变树结构)、线索二叉树(常量空间、改变树结构)、非递归栈(线性空间、不改变树结构)
     * 中序遍历树后,可将调换分三种情况,
     * 1.交换序列中两节点
     * 2.交换首位与中间节点
     * 3.相邻交换
     * 举例说明发现规律:
     * 1 2 3 4 5 6 7 8 9
     * (交换3,7)
     * (交换1,7)
     * (交换5,6)
     * 可以发现规律,都会出现前一节点>后一节点值,相邻只出现一次,出现两次的前一次错误为前一节点,第二次错误在后一节点
     * 算法的思想是将非线性问题转换为线性进行分析!!!!
     * 时间复杂度O(N),空间复杂度O(1)
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
     * 问题描述:判断两棵二叉树是否相同
     * 算法:递归中序遍历两棵树,比较左右子树及根节点值
     * 时间复杂度O(N),空间复杂度O(1)
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
     * 问题描述:判断一棵二叉树是否为镜像二叉树,即左右对称
     * 算法:由根节点按左右子树进行递归遍历查找,左、右子树按对称进行比较
     * 时间复杂度O(n),空间复杂度O(1)
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
     * 问题描述:判断二叉树是否平衡
     * 算法:递归求各节点的左右子树深度差,返回左右子树最大深度,若不平衡设置标志位
     * 时间复杂度O(n),空间复杂度O(n)
     * AVL树每个节点都是平衡的,叶子节点的深度差可以大于1,根节点深度为1
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
     * 问题描述:将二叉树转换为右侧连接的链表
     * 算法:采用递归,对最终情况分类进行处理
     * 1.空或无孩子(直接返回该节点作为其线性化后的最后节点)
     * 2.无左孩子(线性化右子树并返回最后节点)
     * 3.无右孩子(将左子树移到右子树,线性化右子树后返回最后节点)
     * 4.有左右孩子(线性化左子树返回最后节点,线性后的左子树插入右子树,线性化原右子树并返回最后节点)
     * 算法2:将情况分为有左子树和无左子树,代码更简洁,但由于无返回最后节点,时间复杂度比算法1高
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
     * 问题描述:为二叉树添加层索引
     * 算法:递归分层遍历,设立临时头节点指示下一层
     * 时间复杂度O(N),空间复杂度O(1)
     * 注意:dummy.next=null指针要恢复
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
     * 问题描述:根据前序、中序遍历构建二叉树(无重复元素)
     * 算法:一次读取前序节点,根据该节点划分中序,划分的左右区间为该节点的左右子树成员,依次类推
     * 时间复杂度O(n),空间复杂都O(1)
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
     * 问题描述:根据后序、中序构造二叉树(无重复元素)
     * 算法:同上,将后序逆向扫描,并且递归时先右再左子树
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
     * 问题描述:计算1~n的排序二叉树个数
     * 算法:
     * 1.n=0,f(0)=1
     * 2.n=1,f(1)=1
     * 3.n=2,f(2)=2
     * 依次类推,以1~n中的每个顶点为根,可能的情况为以前后两部分为左右子树的排序二叉树可能的乘积,然后将各顶点情况相加
     * 而上述前后两部份的可能情况,只与节点数目有关,
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
     * 问题描述:求1~n构成的所有排序二叉树
     * 算法:依次选取元素为根,左右递归然后组合!!!!
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
     * 问题描述:判断二叉树是否为排序二叉树
     * 算法:中序遍历,判断当前节点值是否大于之前节点值(注意初始化变量的处理)
     * 时间复杂度O(N),空间复度O(1)
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
     * 问题描述:根据排序的数组生成排序二叉树
     * 算法:采用二分法截取数组,依次向下生成节点及处理其左右子树
     *     取数组中点为根节点,划分排序的数组为左右子树,递归直至划分的子数组大小为0
     * 时间复杂度O(N),空间复杂度O(N)
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
     * 问题描述:根据递增链表的数据构造排序二叉树
     * 算法:中序递归!!!!
     * http://blog.csdn.net/worldwindjp/article/details/39722643
     * 时间复杂度O(N),空间复杂度O(1)
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
     * 问题描述:计算二叉树的最小深度
     * 算法:广度优先搜索,采用null分割层次,并计数树的深度
     * 时间复杂度O(n),空间复杂度O(n)
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
     * 问题描述:计算二叉树的最大深度
     * 算法:递归求左右子树的最大深度取最大值加1
     * 时间复杂度O(N),空间复杂度O(1)
     */
    public int maxDepth(TreeNode root) {
        if(null==root)
        	return 0;
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    
    /*
     * 5.4.3 Path Sum
     * 问题描述:判断二叉树种是否存在路径使得路径和为所给值
     * 算法:所给值减去节点值然后递归查找左右子树,直至查找到叶子节点,只要有一条路径即可
     * 时间复杂度O(N),空间复杂度O(1)
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
     * 问题描述:寻找二叉树种所有根到叶子为指定值的路径
     * 算法:利用全局变量存储最终路径集和当前搜索路径,然后递归访问左右子树搜索判断路径是否符合要求
     * 时间复杂度O(N),空间复杂度O(N)
     * 注意对符合条件路径的处理:
     * 1.将叶节点加入路径临时存储列表
     * 2.复制路径并加入结果集合
     * 3.将叶节点从临时路径中删除
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
     * 问题描述:寻找二叉树中路径权值的最大值
     * 算法:递归各节点,判断节点值,节点+左子树,节点+右子树(前面这三个最大值用于返回),左子树+节点+右子树最大值与全局最大比较
     * 注意代码中最后一句返回,root.val + (Math.max(left,right)>0?Math.max(left,right):0)必须加括号
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
     * 问题描述:将二叉树按层连接起来
     * 算法:逐层遍历并连接下一层
     * 时间复杂度O(longN),空间复杂度O(1)
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
     * 问题描述:求二叉树所有根-叶路径长度和
     * 算法:传递当前路径长并递归左右子树,为叶时计算当前路径长并加入总和
     * 时间复杂度O(n),空间复杂度O(1)
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
