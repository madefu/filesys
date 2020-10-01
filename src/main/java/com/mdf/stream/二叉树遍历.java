package com.mdf.stream;

import lombok.Data;

public class 二叉树遍历 {

	/**
	 * 二叉搜索数
特征一:
任意结点（包括根结点）的左子树上的结点的值都比这个结点得值小。
特征二：
任意结点（包括根结点）的右子树上的结点的值都比这个结点得值大。
特征三(前驱结点)：
二叉查找树中序遍历完成后和这个节点相邻的前面的节点为该节点的前驱节点。

	 * @author madefu
	 *
	 */
	@Data
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int value;
		TreeNode(int v){
			this.value = v;
		}
	}
	@Data
	class Tree{
		TreeNode root;
		public void insert(int v) {
			if(root==null) {
				root = new TreeNode(v);
				
			}else {
				insert(root,v);
			}
		}
		private void insert(TreeNode node, int v) {
			if(node.getValue()>v ) {
				if(node.left==null) {
					node.left=new TreeNode(v);
				}else {
					insert(node.left,v);	
				}
				
			}else {
				if(node.right==null) {
					node.right=new TreeNode(v);
				}else {
					insert(node.right,v);
				}
					
				
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
