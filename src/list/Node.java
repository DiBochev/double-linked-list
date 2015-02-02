package list;

public class Node<T>{

	private Node<T> previousNode;
	private Node<T> nextNode;
	private T value;
	
	public Node (){
		
	}
	
	public Node(T value){
		this.setValue(value);
	}
	
	public Node(Node<T> node){
		this.previousNode = null;
		this.nextNode = null;
	}

	public Node<T> getPreviousNode() {
		return previousNode;
	}

	public boolean HasPreviousNode() {
		return (previousNode != null);
	}

	public boolean HasNextNode() {
		return (nextNode != null);
	}
	
	public Node<T> getNextNode() {
		return nextNode;
	}
	

	void setPreviousNode(Node<T> previousNode) {
		this.previousNode = previousNode;
	}

	void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}
