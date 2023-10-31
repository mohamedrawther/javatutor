package com.jf.tutor.innerclass;

public class InnerClassMain {
	
	private String msg = "This is outerclass";
	private static String smsg = "this is outerclass static member";
	public static void main(String arg[]){
		InnerClassMain m = new InnerClassMain();
		InnerClassMain.SquareArea mi = m.new SquareArea();
		mi.display();
		
		//anoymouse inner class
		Person p = new Person() {			
			@Override
			public void display() {
				System.out.println("anoymouse"+smsg);
			}
		};
		p.display();
	}

	//Member inner class
	class SquareArea{
		private String msg1 = "This is memberclass";
		void display() {
			System.out.println(msg);
		}
	}
	
	// static inner class
	static class SInner{
		public static void display() {
			System.out.println(smsg);
		}
	}
	
	// Local class
	public void display() {
		class RectancleArea{
			private String msg = "This is localclass";
			void display() {
				System.out.println(msg);
			}
		}
	}	
	
}
abstract class Person{
	abstract void display();
}

