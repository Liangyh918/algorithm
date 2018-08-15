package io.waterdrop.datastructure.tree;

/**
 * 
 * @author liangyh
 *
 */
public class LevelOrderTraversal<T extends Comparable<T>> {
	public void levelOrderTraversal(Node<T> root) {
		visit(root);
		
	}
	
	private void visit(Node node){
		System.out.println(node.value);
	}
}
