package lesson14;

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
			
			for(int i=1; i<11;i++){
				System.out.print(th.getName()+":"+"");
				 for(int j=0; j<10;j++){
				System.out.printf("%4d",count);
				count++;
			        if((count-1)%10==0){
			        	System.out.println();
			        }
			} 
		} 
	}
}

