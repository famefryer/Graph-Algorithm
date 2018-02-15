import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class Graph<Item> {
	
	LinkedHashMap<Item, LinkedList<Item>> hm;
	
	public Graph() {
		hm = new LinkedHashMap<Item, LinkedList<Item>>();
	}
	
	public void addVertice(Item parent) {
		LinkedList<Item> vertices = new LinkedList<Item>();
		hm.put(parent, vertices);
	}
	
	public void addEdge(Item parent,Item vertice) {
		hm.get(parent).addFirst(vertice);
		hm.get(vertice).addFirst(parent);
		
	}
	
	public void removeEdge(Item parent,Item vertice) {
		hm.get(parent).remove(vertice);
		hm.get(vertice).remove(parent);
	}
	
	public List<Item> getAllVertice() {
		List<Item> keyList = new ArrayList<>(hm.keySet());
		return keyList;
	}
	
	public LinkedList<Item> getEdge(Item parent) {
		return hm.get(parent);
	}
	
	public int getNumberOfVertice() {
		return hm.size();
	}
	
	public static void main(String[] args) {
		Graph<String> g = new Graph<>();
		String s1 = "A1";
		String s2 = "A2";
		String s3 = "A3";
		String s4 = "A4";
		String s5 = "A5";
		
		g.addVertice(s1);
		g.addVertice(s2);
		g.addVertice(s3);
		g.addVertice(s4);
		g.addVertice(s5);
		
		g.addEdge(s4, s5);
		g.addEdge(s1, s2);
		g.addEdge(s1, s3);
		g.addEdge(s1, s4);
		
		List<String> test = g.getAllVertice();
		for(String ver : test) {
			System.out.println(ver+" : "+g.getEdge(ver));
		}
				
	}

}
