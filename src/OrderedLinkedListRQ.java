import java.io.PrintWriter;
import java.lang.String;
import java.util.Iterator;

/**
 * Implementation of the run queue interface using an Ordered Link List.
 *
 * Your task is to complete the implementation of this class.
 * You may add methods and attributes, but ensure your modified class compiles and runs.
 *
 * @author Sajal Halder, Minyi Li, Jeffrey Chan.
 */
public class OrderedLinkedListRQ implements Runqueue {
	
	private Proc head;
	private int length;
	
    public OrderedLinkedListRQ() {
    	head = null;
    	length = 0;
    }  // end of OrderedLinkedList()
    
    @Override
    // Bug with head - smallest EN so far is never set to head, the only time head is set is when the list is empty. 
    
    public void enqueue(String procLabel, int vt) {
    	Proc newProc = new Proc(procLabel, vt);
    	Proc currProc = this.head;
    	int highestEqualIndex = 0;
    	int firstGreaterIndex = 0;
    	boolean equivalent = false;
    	int switchCase = 4;
    	
    	//If head is empty, then list is empty and newProc is the new head.
    	if (head == null) {
            head = newProc;
            this.length += 1;
        }
        // otherwise, add node to list in order of vt value.
        else {
        	for (int i = 0; i < this.length; i++) {
        		//1. If there is an equivilent VT in the array, find its highest index. Case 1.
        		if (currProc.getVT() == newProc.getVT()) {
        			highestEqualIndex = i;
        			equivalent = true;
        			switchCase = 1;
        		//2. If not, find the index of the first VT in the array which is larger than
        		// newProc.VT and break. Case 2.
        		} else if (currProc.getVT() > newProc.getVT()) {
        			firstGreaterIndex = i;
        			switchCase = 2;
        			break;
        		//3. Else new Proc must have the largest VT so far. Case 3.
        		} else {
        			if (!equivalent) {
						switchCase = 3;
					}
        		}
        		currProc = currProc.getNextProc();
        	}
        	
        	switch (switchCase) {
        	// There is one or more equivalent VT values in the array - new entry needs to
			// go behind the largest one.
        	case 1:
        		currProc = this.head;
        		for (int i = 0; i < highestEqualIndex; i++) {
        			currProc = currProc.getNextProc();
        		}
        		newProc.setNextProc(currProc.getNextProc());
        		currProc.setNextProc(newProc);
        		this.length += 1;
        		break;
        	
        	// There are no equivalent VT values but the new VT value is not the largest so
			// far.
        	case 2:
        		//If newProc has the smallest VT so far, it's the new head.
        		if (firstGreaterIndex == 0) {
        			newProc.setNextProc(this.head);
        			this.head = newProc;
        			this.length += 1;
        			break;
        		}
        		// Else, Add new proc before the element at greaterIndex (first element.VT in the
				// array which is larger than newProc.VT).
        		currProc = this.head;
        		for (int i = 0; i < firstGreaterIndex - 1; i++) {
        			currProc = currProc.getNextProc();
        		}
        		newProc.setNextProc(currProc.getNextProc());
        		currProc.setNextProc(newProc);
        		this.length += 1;
        		break;
        		
        	// The VT value of the new proc is the largest so far. New proc goes at the end
			// of the array.
        	case 3:
        		currProc = this.head;
        		for (int i = 0; i < this.length - 1; i++) {
        			currProc = currProc.getNextProc();
        		}
        		currProc.setNextProc(newProc);
        		this.length += 1;
        		break;
        	
        	//Error case.
        	case 4:
        		System.out.println("Error - no case match in OrderedLinkedListRQ switch statement.");
        		break;
        	}
        }
    	
    	currProc = this.head;
    	for (int i = 0; i < this.length; i++) {
			System.out.println(currProc.getProcLabel() + " " + currProc.getVT());
    		currProc = currProc.getNextProc();
		}

    } // end of enqueue()


    @Override
    public String dequeue() {
        // Implement me

        return ""; // placeholder, modify this
    } // end of dequeue()


    @Override
    public boolean findProcess(String procLabel) {
        // Implement me

        return false; // placeholder, modify this
    } // end of findProcess()


    @Override
    public boolean removeProcess(String procLabel) {
        // Implement me

        return false; // placeholder, modify this
    } // End of removeProcess()


    @Override
    public int precedingProcessTime(String procLabel) {
        // Implement me

        return -1; // placeholder, modify this
    } // end of precedingProcessTime()


    @Override
    public int succeedingProcessTime(String procLabel) {
        // Implement me

        return -1; // placeholder, modify this
    } // end of precedingProcessTime()


    @Override
    public void printAllProcesses(PrintWriter os) {
        //Implement me

    } // end of printAllProcess()


} // end of class OrderedLinkedListRQ
