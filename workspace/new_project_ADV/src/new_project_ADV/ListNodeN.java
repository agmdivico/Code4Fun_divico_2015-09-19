package new_project_ADV;

public class ListNodeN {
	  Node head;
	  int count;

	   ListNodeN(){
	     head = new Node();
	     count = 0;
	   }

	  public Node GetNode(int index){
	    Node nod2= head;
	    if(index > count){
	        System.out.println("index greater than list limit");
	        return null;
	    }
	    for(int i=0;i<index && (nod2.getNext() != null);i++){
	        nod2 = nod2.getNext();
	    }
	    return nod2.getNext();
	  }
}