package list;

public class Node<T>{

	private Node<T> previousNode;
	private Node<T> nextNode;
	private T value;
	
	public Node (){
		
	}
	
	public Node(T value){
		this.value = value;
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
	
	public Node<T> getNextNode() {
		return nextNode;
	}
	
	public boolean HasNextNode() {
		return (nextNode != null);
	}

	private void setPreviousNode(Node<T> previousNode) {
		this.previousNode = previousNode;
	}

	private void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}
	
	public void addNextNode(Node<T> nextNode) {
		if(this == nextNode) return;
		if (getNextNode() == null) {
			setNextNode(nextNode);
			setPreviousNode(nextNode.getPreviousNode());
			if (nextNode.getPreviousNode() == null) {
				nextNode.setPreviousNode(this);
			}else{
				nextNode.getPreviousNode().setNextNode(this);
				nextNode.setPreviousNode(this);
			}
		}else{
			Node<T> temp = getNextNode();
			setNextNode(nextNode);
			getNextNode().setNextNode(temp);
			temp.setPreviousNode(this.getNextNode());
			getNextNode().setPreviousNode(this);
		}
	}
	
	public void addPreviousNode(Node<T> previousNode){
		if(this == nextNode) return;
		if (getPreviousNode() == null) {
			setPreviousNode(previousNode);
			previousNode.setNextNode(this);
			

			
		}else{
			Node<T> temp = new Node<T>(getPreviousNode());
			setPreviousNode(previousNode);
			previousNode.setNextNode(this);
			previousNode.setPreviousNode(temp);
			temp.setNextNode(previousNode);
		}
	}

//	public void deleteNode(){
//		
//	}
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}



}
