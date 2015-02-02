package Main;

import list.List;
import list.Node;

public class Main {

	public static void main(String[] args) {
		Node<Integer> node2 = new Node<Integer>(2);
		List<Integer> list = new List<Integer>(node2);
		
		Node<Integer> node0 = new Node<Integer>(0);
		list.addPreviousNode(node2, node0);
		
		Node<Integer> node1 = new Node<Integer>(1);
		list.addNextNode(node0, node1);
		
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
		
		list.deleteNode(node0);
		temp = list.getFirstNode();
		System.out.println(temp.getValue());
		while (temp.HasNextNode()) {
			temp = temp.getNextNode();
			System.out.println(temp.getValue());
		}
	}
}