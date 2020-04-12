import java.io.PrintWriter;
import java.lang.String;

/**
 * Implementation of the Runqueue interface using a Binary Search Tree.
 *
 * Your task is to complete the implementation of this class. You may add
 * methods and attributes, but ensure your modified class compiles and runs.
 *
 * @author Sajal Halder, Minyi Li, Jeffrey Chan
 */
public class BinarySearchTreeRQ implements Runqueue {

	public Tree root;
	static Tree[] storelist = new Tree[100];
	int num;

	public BinarySearchTreeRQ() {
		this.root = null;
	}

	@Override
	public void enqueue(String procLabel, int vt) {
		storelist[num++] = new Tree(procLabel, vt);

		if (root == null) {
			root = new Tree(procLabel, vt);
			return;
		}
		Tree current = root;
		Tree parent = null;
		while (true) {
			parent = current;
			if (vt < current.getVt()) {
				current = current.left;
				if (current == null) {
					parent.left = new Tree(procLabel, vt);
					return;
				}
			} else {
				current = current.right;
				if (current == null) {
					parent.right = new Tree(procLabel, vt);
					return;
				}
			}
		}

	}

	@Override
	public String dequeue() {
		Tree t = storelist[0];
		int min = t.getVt();

		for (int i = 1; storelist[i] != null; i++) {
			if (storelist[i].getVt() <= min) {
				min = storelist[i].getVt();
				storelist[i] = null;
				break;

			}
			System.out.println(min);
		}

		return null;

	}

	@Override
	public boolean findProcess(String procLabel) {
		Tree current = root;

		for (int i = 0; i < BinarySearchTreeRQ.storelist.length; i++) {
			if (BinarySearchTreeRQ.storelist[i].getData().equals(procLabel)) {
				int id = BinarySearchTreeRQ.storelist[i].getVt();
				System.out.println(id);
				while (current != null) {
					if (current.getVt() == id) {
						return true;
					} else if (current.getVt() > id) {
						current = current.left;
					} else {
						current = current.right;
					}
				}

			}

		}

		return false;
	}

	@Override
	public boolean removeProcess(String procLabel) {

		for (int i = 0; i < BinarySearchTreeRQ.storelist.length; i++) {
			if (BinarySearchTreeRQ.storelist[i].getData().equals(procLabel)) {
				storelist[i] = null;

				break;
			}
		}

		return false;
	}

	@Override
	public int precedingProcessTime(String procLabel) {

		int sum = 0;
		for (int i = 0; i < BinarySearchTreeRQ.storelist.length; i++) {
			if (BinarySearchTreeRQ.storelist[i].getData().equals(procLabel)) {

				int id = BinarySearchTreeRQ.storelist[i - 1].getVt();

				if (id != 0) {
					sum = sum + id;
					System.out.println(sum);
					break;
				}

				else {
					System.out.println("This is the last element of the tree");
				}
			}

		}

		return -1;

	}

	@Override
	public int succeedingProcessTime(String procLabel) {

		int sum = 0;
		for (int i = 0; i < BinarySearchTreeRQ.storelist.length; i++) {
			if (BinarySearchTreeRQ.storelist[i].getData().equals(procLabel)) {

				int id = BinarySearchTreeRQ.storelist[i + 1].getVt();
				if (id != 0) {
					sum = sum + id;
					System.out.println(sum);
					break;
				}

				else {
					System.out.println("This is the last element of the tree");
				}
			}

		}

		return -1;

	}

	@Override
	public void printAllProcesses(PrintWriter os) {
		BinarySearchTreeRQ b = new BinarySearchTreeRQ();
		b.display(b.root);
		os.println();

	}

	public void display(Tree root) {
		if (root != null) {
			display(root.left);
			System.out.print(" " + root.getData());
			display(root.right);
		}
	}

} // end of class BinarySearchTreeRQ
