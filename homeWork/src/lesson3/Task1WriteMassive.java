package lesson3;

public class Task1WriteMassive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float mas[]={1.2f, 2.7f, 5.6f, 3.9f, 4.4f, 8.2f, 7.5f, 8.3f, 9.4f, 4.2f};
		
		for(int i=0; i<10; i++){
			System.out.print(" "+mas[i]+" | ");
			
		}
		System.out.println(" ");
		float t=0;
		for(int i=0; i<10; i++){
			t=t+mas[i];
		}
       System.out.println("average value ="+ (t/10));
	}

}
