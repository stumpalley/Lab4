
import java.util.Scanner;

public class UseQueue {

	public static void main(String[] args) {

		CS112QueueB myQ = new CS112QueueB();

		Scanner scan = new Scanner(System.in);

		int guests = scan.nextInt();
		int N = scan.nextInt();
		scan.close();

		for (int i = 1; i <= guests; i++) {
			myQ.enqueue(i);
		}

		System.out.println("Initial seats: ");
		myQ.writeQueue();

		int size = guests;
		while (size > 1) {
			int sauced = myQ.dequeue();
			System.out.println("Seat " + sauced + " has been sauced.");
			myQ.writeQueue();
			for (int i = 0; i < N - 1; i++) {
				int temp = myQ.dequeue();
				myQ.enqueue(temp);
			}
			size--;
		}

		System.out.println("Seat " + myQ.peek() + " gets the gold coin.");
	}

}
