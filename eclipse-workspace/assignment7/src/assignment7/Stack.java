package assignment7;

public class Stack {
	private int [] Array;
	private int top;
	private int capacity;
	public Stack (int capacity) {
		this.capacity=capacity;
		Array = new int[capacity];
		top=-1;
	}
	public void push(int element) {
		try {
			if(top==capacity-1) {
				throw new StackOverflowException("Stack Overflow");
			}
			Array[++top]=element;
			System.out.println("Pushed Element : " + element);
		}
		catch(StackOverflowException e) {
			System.out.println("Error: "+e.getErrorCode()+"-"+e.getMessage());
		}
	}
	public int pop() {
		try {
			if(top==-1) {
				throw new StackUnderFlowException("Stack Underflow");
			}
			int element = Array[top--];
			System.out.println("Popped Element: " + element);
			return element;
		}
		catch(StackUnderFlowException e) {
			System.out.println("Error: "+ e.getErrorCode() + "-" +e.getMessage());
			return -1;
		}
	}
	class StackOverflowException extends Exception{
		private static final int ERROR_CODE=1;
		public StackOverflowException(String message) {
			super(message);
		}
		public int getErrorCode() {
			return ERROR_CODE;
		}
	}
	class StackUnderFlowException extends Exception{
		private static final int ERROR_CODE=2;
		public StackUnderFlowException(String message) {
			super(message);
		}
		public int getErrorCode() {
			return ERROR_CODE;
		}
	}
	
}

