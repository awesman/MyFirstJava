package lesson2;

import java.util.Scanner;

public class Task5Weight {

	public static void main(String[] args) {
		// Проверка идеальности вашего веса
		Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваш рост в СМ - ");
        double var1 = scanner.nextDouble();
        System.out.print("Введите ваш вес в КГ - ");
        double var2 = scanner.nextDouble();
             
         /* Есть странный баг, например при вводе значений 181 см
          *  и 67.7 кг, выдает немного неточное значение.
          *  Появляется он не всега, с некоторыми данными работает корректно,
          *  немогу понять откуда вылазят эти   3*10-16 
          */
        if( (var1-100)==var2){
        	System.out.println("Поздравляем! У вас идеальный вес!");
        }else{
        	if( (var1-100)>var2){
        		 System.out.println("Вам нужно попровиться на "+((var1-100)-var2));
        	}else{
        		System.out.println("Вам нужно похудеть на "+(var2-(var1-100)));	
        	}
        	
        }
        scanner.close();

	}

}
