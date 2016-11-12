package lesson2;

import java.util.Scanner;

public class Task4Year {

	public static void main(String[] args) {
		// Проверка заданного года на високосность
		Scanner scanner = new Scanner(System.in);
        System.out.print("Введите год для проверки - ");
        int g = scanner.nextInt();
		
		if(g % 4 == 0)
		{
		   if(g % 100 == 0)
		   {
		      if(g % 400 == 0)
		      {
		         System.out.println("Високосный");
		      }
		      else
		      {
		         System.out.println("Не високосный");
		      }
		   }
		   else
		   {
		      System.out.println("Високосный");
		   }
		}
		else
		{
		   System.out.println("Не високосный");
		}
		 scanner.close();

	}

}
