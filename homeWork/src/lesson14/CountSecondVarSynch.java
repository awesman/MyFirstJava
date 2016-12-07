package lesson14;
/**
 *@author Pavel
 *@version 2
 */
public class CountSecondVarSynch {

	public static void main(String[] args) {
		
		NewThread T1=new NewThread();
		NewThread T2=new NewThread();
		T1.start();
		T2.start();
	}
}
class NewThread extends Thread {
	Thread th;
	public NewThread() {
		th = new Thread(this);
	}
	public void run() {
		synchronized(this){
			
		for(int i=0; i<10;i++){
			System.out.println(th.getName()+":"+" "+(i*10+1)+" "+(i*10+2)+" "+(i*10+3)+" "+(i*10+4)+" "+(i*10+5)+" "+(i*10+6)+" "+(i*10+7)+" "+(i*10+8)+" "+(i*10+9)+" "+(i*10+10));
			   yield();  
		  }
		}
     }
}