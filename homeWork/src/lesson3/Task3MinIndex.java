package lesson3;

public class Task3MinIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mas[]={-52,11,29,33,19,7,9,-14,12,7,13,16,22,18,19};

          int min=mas[0];
          int ind=0;
		
		for(int i = 0; i<10; i++){
			if(mas[i]<min){
				min=mas[i];
				ind=i;
			}
		}
		System.out.println("min value ="+min);
		System.out.print("Индекс миннимального значения в массиве "+ind);
	}

}
