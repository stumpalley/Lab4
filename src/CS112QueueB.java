// Alex Yan, Sarah Wu
public class CS112QueueB implements CS112QueueInterface {

	private int[] theQ;
	private int front;
	private int back;
	private int count;

	public CS112QueueB(int initialSize) {
		theQ = new int[initialSize];
		front = 0;
		back = -1;
		count = 0;
	}

	public CS112QueueB() {
		this(4);
	}

	public void writeQueue() {
		/*
		 * this method should write only the actual elements in the queue, starting
		 * with the element in the front and ending with the last element.
		 * It should NOT write all the elements in the array,
		 */

		System.out.print("Queue: ");

		int index = front;

		for (int i = 0; i < count; i++) {
			if (index > theQ.length - 1) {
				index = 0;
			}
			System.out.print(theQ[index] + " ");
			index++;
		}
		System.out.println();
	}

	public void writeArray() {
		System.out.println("___________ Writing Queue Array Info_______");
		System.out.println("front: " + front);
		System.out.println("back : " + back);
		System.out.println("count: " + count);

		for (int i = 0; i < theQ.length; i++)
			System.out.print(theQ[i] + " ");
		System.out.println();
		System.out.println("_____________________________________________");
		System.out.println();

	}

	public void enqueue(int toBeAdded) {
		if (full())
			expand();
		else if (bumped())
			shiftBack();
		back = back + 1;
		theQ[back] = toBeAdded;
		count = count + 1;

	}

	private void shiftBack() {
		back = -1;
	}

	private void expand() {
		int[] newQ = new int[theQ.length * 2];
		for (int i = 0; i < theQ.length; i++) {
			newQ[i] = theQ[i];
			newQ[i + theQ.length] = theQ[i];
		}
		if (front > back){
			front = front + theQ.length;
		}
		theQ = newQ;
		
	}

	private boolean bumped() {
		return back == theQ.length - 1;
	}

	private boolean full() {
		return count == theQ.length;
	}

	public int dequeue() {
		if (isEmpty()) {
			return -978;
		} else {
			int toR = theQ[front];
			if (front >= theQ.length - 1){
				front = 0;
			}
			else {front++;}
			count = count - 1;
			return toR;
		}
	}

	public int peek() {
		if (isEmpty()) {
			return -978;
		} else {
			return theQ[front];

		}
	}

	public boolean isEmpty() {
		return count == 0;
	}
}
