package lesson2;

import java.util.Scanner;

public class Task4DopSumma {

	public static void main(String[] args) {
		// Суммируем вводимое количество чисел
		Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество суммируемых чисел:");
        long f = scanner.nextLong();
        
        long t=0;
        
        for (long i=1; i<=f; i++){
        	t=t+i;
        }
        
       System.out.println(t); 
       
       scanner.close();

	}

}
