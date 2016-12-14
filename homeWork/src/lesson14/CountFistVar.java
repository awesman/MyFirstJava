package lesson14;
/**
 * Написать приложение, 
 * в котором используются 2 потока(класс один и тот же). 
 * Класс потока задать как наследник Thread.
 * Класс потока должен обеспечивать в методе run построчный 
 * несинхронизированный вывод в консольное окно чисел от 1 до 100 
 * порциями по 10 чисел в строке, разделенных пробелами, 
 * причем перед каждой такой порцией должна стоять надпись: "Thread 1:"
 * для первого потока, "Thread 2:" — для второго  - можно использовать 
 * название потока (есть соответствующий метод). 
 * В приложении при вводе с клавиатуры "start" потоки должны стартовать.   
 *@author Pavel
 *@version 1
 */
public class CountFistVar {

	public static void main(String[] args) throws InterruptedException {
		
		Thread1 T1=new Thread1();
		Thread1 T2=new Thread1();
		T1.start();
		T2.start();
		}
	}
	class Thread1 extends Thread {
		Thread th;
		int count =1;
		public Thread1() {
			th = new Thread(this);
		}
		public void run() {
			
			for(int i=0; i<10;i++){
				System.out.println(th.getName()+":"+" "+(i*10+1)+" "+(i*10+2)+" "+(i*10+3)+" "+(i*10+4)+" "+(i*10+5)+" "+(i*10+6)+" "+(i*10+7)+" "+(i*10+8)+" "+(i*10+9)+" "+(i*10+10));
		} 
	}
}

