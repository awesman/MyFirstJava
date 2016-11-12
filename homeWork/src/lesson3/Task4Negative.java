package lesson3;

public class Task4Negative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mas[]={32,-41,7,-38,25,0,26,-1,-42,14};
		
		int amount=0;
		
		for(int i=0; i<10; i++){
			if(mas[i]<0){
			amount=amount+1;
			}
		}
     System.out.println("Количество отрицательных чисел "+amount);
	}

}
