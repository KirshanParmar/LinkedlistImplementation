package com.binary.linkedList;

import java.util.LinkedList;
import java.util.Queue;

/**
	 *  Java Program to Implement a Binary Tree using Linked List
	 *
	 *  @author kirshan.lal
	 *
	**/
public class BinaryTreeImplLinkedList {

	/** A Linked List Node class Start************/
	class ListNode
	{
		int data;
		ListNode next;
		ListNode(int d)
		{
			data = d;
			next = null;
		}
	}
	/** A Linked List Node class End*************/


	/** A Binary Tree Node class Start***********/
	class BinaryTreeNode
	{
		int data;
		BinaryTreeNode left, right = null;
		BinaryTreeNode(int data)
		{
			this.data = data;
			left = right = null;
		}
	}
	/** Binary Tree Node class End***************/

	/** A Binary Tree class Start****************/
	class BinaryTree
	{
		ListNode head;
		BinaryTreeNode root;

		// Function to insert a node at the beginning of the Linked List
		void push(int new_data)
		{
			// allocate node and assign data
			ListNode new_node = new ListNode(new_data);

			// link the old list of the new node
			new_node.next = head;
			head = new_node;
		}

		// converts a given linked list representing a
		// complete binary tree into the linked
		// representation of binary tree.
		BinaryTreeNode convertList2Binary(BinaryTreeNode node)
		{
			// queue to store the parent nodes
			Queue<BinaryTreeNode> q =new LinkedList<BinaryTreeNode>();
			if (head == null)
			{
				node = null;
				return null;
			}

			//add it to the queue
			node = new BinaryTreeNode(head.data);
			q.add(node);
			head = head.next;

			// until the end of linked list is reached, do the
			while (head != null)
			{

				//remove it from q
				BinaryTreeNode parent = q.peek();
				BinaryTreeNode pp = q.poll();

				BinaryTreeNode leftChild = null, rightChild = null;
				leftChild = new BinaryTreeNode(head.data);
				q.add(leftChild);
				head = head.next;
				if (head != null)
				{
					rightChild = new BinaryTreeNode(head.data);
					q.add(rightChild);
					head = head.next;
				}

				//assign the left and right children of	 parent
				parent.left = leftChild;
				parent.right = rightChild;
			}

			return node;
		}

		// Utility function to traverse the binary tree after conversion
		void inorderTraversal(BinaryTreeNode node)
		{
			if (node != null)
			{
				inorderTraversal(node.left);
				System.out.print(node.data + " ");
				inorderTraversal(node.right);
			}
		}
	}
	/** A Binary Tree class End*******************/

	/** A Main Method Start*******************/
	public static void main(String[] args){

		BinaryTreeImplLinkedList main=new BinaryTreeImplLinkedList();
		BinaryTree tree = main.new BinaryTree();
		tree.push(36); /* Last node of Linked List */
		tree.push(30);
		tree.push(25);
		tree.push(15);
		tree.push(12);
		tree.push(10); /* First node of Linked List */
		BinaryTreeNode node = tree.convertList2Binary(tree.root);

		System.out.println("Inorder Traversal of the constructed Binary Tree is:");
			tree.inorderTraversal(node);
		}
	}