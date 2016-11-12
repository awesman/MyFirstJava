package lesson3;

public class Task6Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mas[]={0,11,0,10,19,0,12,-1,0,74};
		
		int x=mas.length;
		
		for (int i = x - 1; i >= 2; i--) {
			boolean sorted = true;
			for (int j = 0; j < i; j++) {
				if (mas[j] ==0) {
		            int temp = mas[j];
		            mas[j] = mas[j+1];
		            mas[j+1] = temp;
		            sorted = false;
			}
		
		}
			if(sorted) {
		        break;
			}
			
	}
		for(int i1=0;i1<x;i1++){
			System.out.print(" "+mas[i1]+" "+"|");
			}
  }
}
