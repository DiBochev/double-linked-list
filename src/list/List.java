package list;

public class List<T> {

	private Node<T> firstNode;
	private Node<T> lastNode;
	
	public List(){
		this.firstNode = null;
		this.lastNode = null;
	}
	
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
	
}
