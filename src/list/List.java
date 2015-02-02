package list;

public class List<T> {

	private Node<T> firstNode;
	private Node<T> lastNode;
	
	public List(Node<T> node){
		this.setFirstNode(node);
		this.setLastNode(node);
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
		return (getFirstNode() == null);
	}

	public void setFirstNode(Node<T> firstNode) {
		this.firstNode = firstNode;
	}

	public void setLastNode(Node<T> lastNode) {
		this.lastNode = lastNode;
	}
}