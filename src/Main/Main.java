package Main;

import list.List;
import list.Node;

public class Main {

	public static void main(String[] args) {
		Node<Integer> node2 = new Node<Integer>(2);
		List<Integer> list = new List<Integer>(node2);
		node2.setList(list);
		
		
		Node<Integer> node0 = new Node<Integer>(0);
		node2.addPreviousNode(node0);
		
		Node<Integer> node1 = new Node<Integer>(1);
		node0.addNextNode(node1);
		
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		
		node3.setList(list);
		node3.addNextNode(node4);
		node3.addPreviousNode(node2);
		
		
		Node<Integer> temp = list.getFirstNode();
		System.out.println(temp.getValue());
		while (temp.HasNextNode()) {
			temp = temp.getNextNode();
			System.out.println(temp.getValue());
		}
		System.out.println();
		
		temp = list.getLastNode();
		System.out.println(temp.getValue());
		while (temp.HasPreviousNode()) {
			temp = temp.getPreviousNode();
			System.out.println(temp.getValue());
		}
		
		System.out.println();
		
		node0.deleteNode();
		temp = list.getFirstNode();
		System.out.println(temp.getValue());
		while (temp.HasNextNode()) {
			temp = temp.getNextNode();
			System.out.println(temp.getValue());
		}
	}
}