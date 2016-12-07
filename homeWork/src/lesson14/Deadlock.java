package lesson14;

public class Deadlock {
    
	public static String girlName="Alina";
	public static String boyName="Andrey";
	
	
	public static void main(String[] args) {
		
		Thread1 T1 = new Thread1();
		Thread2 T2 = new Thread2();
		
		T1.start();
		T2.start();
	}
	private static class Thread1 extends Thread {
		public void run() {
			synchronized (girlName) {
				System.out.println("Позовите девочку...");
				System.out.println(girlName);
				System.out.println("Кто пришел первый?");
				synchronized (boyName) {
					System.out.println("boyName");
					
				}
			}
			
		} 
	}
	private static class Thread2 extends Thread {
		public void run() {
			synchronized (boyName) {
				System.out.println("Позовите мальчика...");
				System.out.println(boyName);
				System.out.println("Кто пришел второй?");
				synchronized (girlName) {
					System.out.println(girlName);
				}
			}
		}
	}
}

