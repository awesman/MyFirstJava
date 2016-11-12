package lesson3;

public class Task2MaxMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int mas[]={2,11,-17,7,19,7,9,-1,12,7};
		
		int max=0;
		
		for(int i = 0; i<10; i++){
			if(mas[i]>max){
				max=mas[i];
			}
		}
		int min=mas[0];
		
		for(int i = 0; i<10; i++){
			if(mas[i]<min){
				min=mas[i];
			}
		}
     System.out.println("max value = "+max);
     System.out.print("min value = "+min);
	}

}
