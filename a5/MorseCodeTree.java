package a5;

import java.util.ArrayList;
/**
 * 
 * @author Lap
 *@version 11/27
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	TreeNode<String> root=null;
	
	public MorseCodeTree() {
		root = new TreeNode<String>("");
		buildTree();
	}
	
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}

	@Override
	public void insert(String code, String letter) {
		addNode(root,code,letter);
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if (code.charAt(0)=='-') {
			if(code.length()==1)//base
				root.right=new TreeNode<String>(letter);
			else
				addNode(root.right, code.substring(1),letter);
		}
		if(code.charAt(0)=='.') {
			if(code.length()==1)//base
				root.left=new TreeNode<String>(letter);
			else
				addNode(root.left, code.substring(1),letter);
		}
	}

	@Override
	public String fetch(String code) {
		return fetchNode(root,code);
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if (code=="")//base
			return root.data;
		
		char m=code.charAt(0);
		code=code.substring(1,code.length());// subtract first char
		if (m=='-') {
			if (root.right==null)
					return null;
			return fetchNode(root.right, code);}
		else if(m=='.') {
			if (root.left==null)
				return null;
			return fetchNode(root.left, code);}
		return null;
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void buildTree() {
		insert(".","e");//level 1
		insert("-","t");

		insert("..","i");//level 2
		insert(".-","a");
		insert("-.","n");
		insert("--","m");

		insert("...","s");//level 3
		insert("..-","u");
		insert(".-.","r");
		insert(".--","w");
		insert("-..","d");
		insert("-.-","k");
		insert("--.","g");
		insert("---","o");

		insert("....","h");//level 4, left
		insert("...-","v");
		insert("..-.","f");
		insert(".-..","l");
		insert(".--.","p");
		insert(".---","j");
		insert("-...","b");//level 4, right
		insert("-..-","x");
		insert("-.-.","c");
		insert("-.--","y");
		insert("--..","z");
		insert("--.-","q");
	}

	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> morseList = new ArrayList<String>();
		LNRoutputTraversal(root,morseList);
		return morseList;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root.left!=null)
			LNRoutputTraversal(root.left,list);
		list.add(root.data);
		if(root.right!=null)
			LNRoutputTraversal(root.right,list);
	}


}
