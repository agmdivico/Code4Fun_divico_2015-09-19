package new_project_ADV;

import org.w3c.dom.Node;

public class ListNodeN {
	  Node head;
	  int count;

	   ListNodeN(){
	     //head = new Node();
	     count = 0;
	   }

	  public Node GetNode(int index){
	    Node nod2= head;
	    if(index > count){
	        System.out.println("index greater than list limit");
	        return null;
	    }
	    for(int i=0;i<index && (nod2.getNextSibling() != null);i++){
	        nod2 = nod2.getNextSibling();
	    }
	    return nod2.getNextSibling();
	  }
}