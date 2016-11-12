package lesson2;

import java.util.Scanner;

public class Task6DopCalc {

	public static void main(String[] args) {
		/* Программа простейшего калькулятора
		 *Не знаю сколько нужно было выйствий учитывать и их сложность,
		 *можно в испольхуемый метод Calc добавлять еще действия
		 */
		
		Scanner read = new Scanner(System.in);
		System.out.println("Введите первое число:");
		double a=read.nextDouble();
		System.out.println("Введите действие(+,-,*,/):");
		String sign=read.next();
		System.out.println("Введите второе число:");		
		double b=read.nextDouble();
		
		read.close();
		
		
		System.out.println("Результат:"+Calc.Metod(a,sign,b));		

	}

}
