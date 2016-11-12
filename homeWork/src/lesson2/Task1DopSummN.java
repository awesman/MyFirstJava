package lesson2;

import java.util.Scanner;

public class Task1DopSummN {

	public static void main(String[] args) {
		// Программа вычисляющая сумму n первых членов ряда
		// Ограничение на 0 не ставим, так как в этом случае цикл не будет выполняться
		// и при вводе 0 первых членов, значение будет равно начальному t=0
		Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество членов ряда:");
        double f = scanner.nextDouble();
        
        double t=0;
        
        for (double i=1; i<=f; i++){
        	t=t+1/i;
        }
        
       System.out.println(t); 
       
       scanner.close();

	}

}
