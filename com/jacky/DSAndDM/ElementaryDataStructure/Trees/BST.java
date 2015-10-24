package com.jacky.DSAndDM.ElementaryDataStructure.Trees;

public class BST {

	private Node root;
	private int size;

	public BST() {
		root = null;
		size = 0;
	}

	public void insert(int data) {
		// root = insert(root, data);
		root = insertIteratively(root, data);
		size++;
	}

	private Node insertIteratively(Node root, int data) {
		if (root == null) {
			root = new Node(data);
		}
		Node temp = root; // if tree not empty, create a temp node as a runner
		while (temp != null) {
			if (temp.data < data) {
				if (temp.right == null) {
					temp.right = new Node(data);
					break; // done insert, break out while loop
				} else { // there is a node, keep moving
					temp = temp.right;
				}
			} else if (temp.data > data) {
				if (temp.left == null) {
					temp.left = new Node(data);
					break; // done insert break out while loop
				} else { // there is a node, keep moving left subtree
					temp = temp.left;
				}
			} else {
				temp.data = data;
				break; // need to break out here to indicate that we are done
			}
		}

		return root;
	}

	private Node insert(Node root, int data) {
		if (root == null) {
			root = new Node(data);
		} else {
			if (root.data > data) {
				root.left = insert(root.left, data);
			} else if (root.data < data) {
				root.right = insert(root.right, data);
			} else {
				root.data = data;
			}
		}
		return root;
	}

	public boolean contain(int data) {
		// return search(root, data) != null;
		return searchIteratively(root, data) != null;
	}

	private Node searchIteratively(Node root, int data) {
		while (root != null && root.data != data) {
			if (root.data > data) {
				root = root.left;
			} else if (root.data < data) {
				root = root.right;
			}
		}
		return root;
	}

	private Node search(Node root, int data) {
		if (root == null) {
			return null;
		} else {
			if (root.data > data) { // move to left subtree
				return search(root.left, data);
			} else if (root.data < data) {
				return search(root.right, data);
			} else {
				return root;
			}
		}
	}

	public void delete(int data) {
		root = delete(root, data);
		size = size - 1;
	}

	private Node delete(Node root, int data) {
		if (root == null) {
			return null;
		} else {
			if (root.data > data) {
				root.left = delete(root.left, data);
			} else if (root.data < data) {
				root.right = delete(root.right, data);
			} else { // found
				if (root.left == null) { // no left child
					return root.right;
				} else if (root.right == null) { // no right child
					return root.left;
				} else { // delete at node with 2 children
					Node temp = root;
					Node smallestRightSubTree = findMinIteratively(root.right); // find
																				// the
					// smallest
					// value
					// on
					// right
					// sub
					root = smallestRightSubTree; // replace node to be deleted
													// by the smallest one on
													// right sub
					Node rightNode = deleteMinIteratively(temp.right);
					root.right = rightNode; // delete the smallest one
					root.left = temp.left;
				}
			}
		}
		return root;
	}

	// helper method to help delete the node that being used to replace the node
	// to be deleted in delete operation
	private Node deleteMin(Node root) {
		if (root.left == null)
			return root.right;
		root.left = deleteMin(root.left); // try to set the node to null
		return root;
	}

	private Node deleteMinIteratively(Node root) {
		if (root.left == null) {
			return root.right;
		}
		Node temp = root; // so we can keep a copy of original root
		while (temp != null) {
			if (temp.left != null) {
				temp = temp.left;
			} else { // if left node is null,
				root.left = temp.right; // now set left node of original to the
										// right subtree immediately
				return root;
			}
		}
		return root;
	}

	// helper method to help find the minimum node in the rigt subtree for
	// delete operation
	private Node findMin(Node root) {
		if (root.left == null) {
			return root;
		}
		return findMin(root.left);
	}

	private Node findMinIteratively(Node root) {
		if (root.left == null) {
			return root;
		}
		Node temp = root;
		while (temp != null) {
			if (temp.left != null) {
				temp = temp.left;
			} else {
				return temp;
			}
		}
		return root;
	}

	public Node min() {
		return min(root);
	}

	private Node min(Node root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
		/*
		 * if(root.left == null){ return root; } root = min(root.left); return
		 * root;
		 */
	}

	public Node max() {
		return max(root);
	}

	/*
	 * 1. in-order: left, root, right
	   2. pre-order: root, left, right
       3. post-order: left, right, root
	 */
	private Node max(Node root) {
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}

	public void inOrderTraversal() {
		inOrderTraversal(root);
	}

	private void inOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.println(root.data);
			inOrderTraversal(root.right);
		}
	}

	public void preOrderTraversal() {
		preOrderTraversal(root);
	}

	private void preOrderTraversal(Node root) {
		if (root == null)
			return;
		System.out.println(root.data + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	public int height() {
		return height(root);
	}

	private int height(Node root) {
		if (root == null) {
			return -1;
		} else {
			return 1 + Math.max(height(root.left), height(root.right));
		}
	}
	
	public int size(){
		return size(root);
	}

	private int size(Node root) {
		if(root == null){
			return 0;
		}
		else {
			return size(root.left) + size(root.right) + 1;
		}
	}

	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(8);
		bst.insert(2);
		bst.insert(9);
		bst.insert(1);
		bst.insert(4);
		bst.insert(3);
		bst.insert(6);
		bst.insert(5);
		bst.insert(7);
		bst.delete(4);
		bst.delete(1);
		bst.inOrderTraversal();
		System.out.println("bst contains 7 " + bst.contain(7));
		System.out.println("minimum: " + bst.min().data);
		System.out.println("maximum: " + bst.max().data);
		System.out.println("height: " + bst.height());
		System.out.println("size: " + bst.size());
	}

}
