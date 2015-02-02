package list;

public class List<T> {

	private Node<T> firstNode;
	private Node<T> lastNode;
	
	public List(Node<T> node){
		this.firstNode = node;
		this.lastNode = node;
	}
	
	public Node<T> getFirstNode() {
		while (this.firstNode.HasPreviousNode()) {
			this.firstNode = this.firstNode.getPreviousNode();
		}
		return this.firstNode;
	}
	
	public Node<T> getLastNode() {
		while (this.lastNode.HasNextNode()) {
			this.lastNode = this.lastNode.getNextNode();
		}
		return this.lastNode;
	}
	
	public boolean isEmpty(){
		return (firstNode == null);
	}
	
	public void addPreviousNode(Node<T> node, Node<T> previousNode){
		if(node == node.getNextNode()) return;
		if (node.getPreviousNode() == null) {
			node.setPreviousNode(previousNode);
			previousNode.setNextNode(node);
		}else{
			Node<T> temp = node.getPreviousNode();
			node.setPreviousNode(previousNode);
			node.getPreviousNode().setNextNode(node);
			temp.setNextNode(previousNode);
			node.getPreviousNode().setPreviousNode(temp);
		}
	}

	public void addNextNode(Node<T> node, Node<T> nextNode) {
		if(node == nextNode) return;
		if (node.getNextNode() == null) {
			node.setNextNode(nextNode);
			node.setPreviousNode(nextNode.getPreviousNode());
			if (nextNode.getPreviousNode() == null) {
				nextNode.setPreviousNode(node);
			}else{
				nextNode.getPreviousNode().setNextNode(node);
				nextNode.setPreviousNode(node);
			}
		}else{
			Node<T> temp = node.getNextNode();
			node.setNextNode(nextNode);
			node.getNextNode().setNextNode(temp);
			temp.setPreviousNode(node.getNextNode());
			node.getNextNode().setPreviousNode(node);
		}
	}

	public void deleteNode(Node<T> node){
		if (node.getPreviousNode() != null) {
			node.getPreviousNode().setNextNode(node.getNextNode());			
		}
		if (node.getNextNode() != null) {
			node.getNextNode().setPreviousNode(node.getPreviousNode());			
		}
		if (node == this.firstNode) {
			this.firstNode = node.getNextNode();
		}
		if (node == this.lastNode){
			this.lastNode = node.getPreviousNode();
		}
		node.setPreviousNode(null);
		node.setNextNode(null);
	}
}