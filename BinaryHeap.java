import java.util.Arrays;

public class BinaryHeap {
	private final int INITIAL_SIZE = 10;
	private int a[];
	private int size;
	
	//Constructor
	public BinaryHeap() {
		a = new int[INITIAL_SIZE];
		size = 0;
	}
	
	//Grow arry
	protected void grow_array() {
		a = Arrays.copyOfRange(a, 0, a.length * 2);
	}
	
	//Swap
	protected void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	//Add method
	public void add(int priority) {
		if(size >= a.length)
			grow_array();
		
		a[size++] = priority;
		int child = size - 1;
		int parent = (child - 1) / 2;
		
		while(a[child] < a[parent] && parent >= 0) {
			swap(a, child, parent);
			child = parent;
			parent = (child - 1) / 2;
		}

	}
	
	//Remove method
	public int remove(){
		if(size == 0)
			throw new IndexOutOfBoundsException();
		
		int temp = a[0];
		a[0] = a[--size];
		siftdown(0);
		return temp;		
	}
	
	//Trickle down method
	protected void siftdown(int parent) {
		int child = parent * 2 + 1;
		
		//base case
		if(child >= size)
			return;
		
		if(child + 1 < size) 
			if(a[child] > a[child + 1])
				child = child + 1;
		
		if(a[child] < a[parent]) {
			swap(a,child, parent);
			siftdown(child);
		}	
		
	}

}
