package a5;

/**
 * 
 * @author Lap
 * @param <T>
 */
public class TreeNode<T> {
	T data;
	TreeNode<T> left,right;
	
	public TreeNode(T d) {
		data = d;
		left=right=null;
	}
	
	public TreeNode() {
		data=null;
		left=right=null;
	}
	
	//deep copy constructor
	public TreeNode(TreeNode<T> node) {
		this.data=node.data;
		if (node.left!=null)
			left = new TreeNode<T>(node.left);
		else
			left=null;
		if (node.right!=null)
			right= new TreeNode<T>(node.right);
		else
			right=null;
	}
	
	public T getData() {
		return data;
	}
}
