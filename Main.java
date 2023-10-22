import java.sql.Array;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> adjacency_list = new HashMap<String, ArrayList<String>>();
        ArrayList<String> adj_a = new ArrayList<>(Arrays.asList("B","D","E","F","H"));
        ArrayList<String> adj_b = new ArrayList<>(Arrays.asList("A","C","D","E","F","G","I"));
        ArrayList<String> adj_c = new ArrayList<>(Arrays.asList("B","D","E","F","H"));
        ArrayList<String> adj_d = new ArrayList<>(Arrays.asList("A","B","C","E","G","H","I"));
        ArrayList<String> adj_e = new ArrayList<>(Arrays.asList("A","B","C","D","F","G","H","I"));
        ArrayList<String> adj_f = new ArrayList<>(Arrays.asList("A","B","C","E","G","H","I"));
        ArrayList<String> adj_g = new ArrayList<>(Arrays.asList("B","D","E","F","H"));
        ArrayList<String> adj_h = new ArrayList<>(Arrays.asList("A","C","D","E","F","G","I"));
        ArrayList<String> adj_i = new ArrayList<>(Arrays.asList("B","D","E","F","H"));

        adjacency_list.put("A",adj_a);
        adjacency_list.put("B",adj_b);
        adjacency_list.put("C",adj_c);
        adjacency_list.put("D",adj_d);
        adjacency_list.put("E",adj_e);
        adjacency_list.put("F",adj_f);
        adjacency_list.put("G",adj_g);
        adjacency_list.put("H",adj_h);
        adjacency_list.put("I",adj_i);

        System.out.println(possible_locks("A",0,adjacency_list));
        System.out.println("-----------");
        print_result(possible_locks("B",1,adjacency_list));
        System.out.println("-----------");
        print_result(possible_locks("C",2,adjacency_list));
        System.out.println("-----------");
        print_result(possible_locks("D",3,adjacency_list));
        System.out.println("-----------");
        System.out.println(possible_locks("E",8,adjacency_list).size());
        System.out.println("-----------");
        System.out.println(possible_locks("F",9,adjacency_list).size());
        System.out.println("-----------");
        System.out.println(possible_locks("G",11,adjacency_list));
    }

    //possible_locks method if the given length is out of the boundires return null
    //if length is 1 return start node
    //if length is more than one and less than 9 apple depth first search(DFS) algorithm
    public static ArrayList<String>  possible_locks(String start, int length, HashMap<String, ArrayList<String>> adj_list){
        //Your code here
    	ArrayList<String> lock = new ArrayList<String>();
    	
    	
    	if(length <= 0 || length > 9) {
    		lock = null;
    		return lock;
    		
    		
    	} else if(length == 1) {
    		lock.add(start);
    		
    	} else {
    		
    			ArrayList<String>  curr = DFS(start,length,adj_list);
    			lock.addAll(curr);
    			
    	}
    	
    	return lock;
    }

    //Your code here
    
    
    //partially working depth search method
    //creates possible lock combinations in the string "result"
    //if the length of the "result" reaches the given length then saves that lock combination to
    //result2 list in order to be returned
    public static ArrayList<String> DFS(String start, int length, HashMap<String, ArrayList<String>> adj_list){
    	
    	String result = "";
    	int d = 1;
    	
    	ArrayList<String> result2 = new ArrayList<String>(); 	
    	ArrayList<String> visited = new ArrayList<String>(); 	
    	
    	ArrayList<String> used = new ArrayList<String>(); 	


    	Stack<String> stack = new Stack<>();
   
    	stack.push(start);
    	
    		while(stack.isEmpty() == false) {
    			d = 1;
    			
    			String x = stack.pop();
    			visited.add(x);
				used.add(x);


    			result = result + x;

    			
    			if(result.length() == length) {
    				
    				result2.add(result);
    				result = result.substring(0, result.length()-1); 
    				
    				d = 0;
    				
    				
    			}
    			
    			if(isAllVisited(result.substring(result.length()-1), visited, adj_list.get(result.substring(result.length()-1)))) {
    				visited.removeAll(used);

    				result = result.substring(0, result.length()-1);  
    				
    				
    			}
    			
    			if(d == 1) {
    				ArrayList<String> unvisitedAdj = adj_list.get(result.substring(result.length()-1));
        			unvisitedAdj.removeAll(visited);
        			for(int k = 0; k < unvisitedAdj.size(); k++) {
        				stack.push(unvisitedAdj.get(unvisitedAdj.size()-k-1));
    				
    			}
    			
    			}
    			   			
    		}
    	    	
    	return result2;
    	
    }
    
    //a helper method to bu used in DFS method
    //checks if all the elements in the adjacency list of x are also in the visited list
    public static boolean isAllVisited(String x, ArrayList<String> visited, ArrayList<String> adjs) {
    	
    	boolean res = true;
    	
    	for(int i = 0; i < adjs.size(); i ++) {
    		if(!visited.contains(adjs.get(i))) {
    			
    			res = false;
    			return res;
    		}
    	}
    	
    	
    	
    	return res;
    }
    
    
    
    public static void print_result(ArrayList<String> result){
        System.out.println("Total number of possible locks: "+result.size());
        for(String current_lock: result){
            ArrayList<String> letters = new ArrayList<String>(Arrays.asList(current_lock.split("")));
            System.out.println(String.join(" -> ", letters));
        }
    }
}
