package list;

public class Node<T>{

	private Node<T> previousNode;
	private Node<T> nextNode;
	private T value;
	private List<T> list;
	
	public Node (){
	}
	
	public Node(T value, List list){
		this.setValue(value);
		setList(list);
	}
	
	public Node(T value){
		this.setValue(value);
	}
	
	public Node(Node<T> node, List list){
		setPreviousNode(null);
		setNextNode(null);
		setList(list);
	}
	
	public Node(List list){
		setPreviousNode(null);
		setNextNode(null);
		setList(list);
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

	private List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public void addPreviousNode(Node<T> previousNode){
		if(this == getNextNode()) return;
		if (getPreviousNode() == null) {
			setPreviousNode(previousNode);
			previousNode.setNextNode(this);
		}else{
			Node<T> temp = getPreviousNode();
			setPreviousNode(previousNode);
			getPreviousNode().setNextNode(this);
			temp.setNextNode(previousNode);
			getPreviousNode().setPreviousNode(temp);
		}
		if (getList() == null) {
			throw new IllegalArgumentException("set list reference");
		}
		previousNode.setList(getList());
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
			temp.setPreviousNode(getNextNode());
			getNextNode().setPreviousNode(this);
		}
		if (getList() == null) {
			throw new IllegalArgumentException("set list reference");
		}
		nextNode.setList(getList());
	}
	
	public void deleteNode()throws IllegalArgumentException{
		if (getPreviousNode() != null) {
			getPreviousNode().setNextNode(getNextNode());			
		}
		if (getNextNode() != null) {
			getNextNode().setPreviousNode(getPreviousNode());			
		}
		if (this == getList().getFirstNode()) {
			list.setFirstNode(getNextNode());
		}
		if (this == getList().getLastNode()){
			list.setLastNode(getPreviousNode());
		}
		setPreviousNode(null);
		setNextNode(null);
		if (getList().isEmpty()) {
			throw new IllegalArgumentException("cannot delete last element!");
		}
	}
}
