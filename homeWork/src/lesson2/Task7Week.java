package lesson2;

import java.util.Scanner;

public class Task7Week {

	public static void main(String[] args) {
		// Вычисления названия дня недели по номеру, простая задача, как на занятии!
		Scanner scanner = new Scanner(System.in);
        System.out.print("Какой номер дня?");
        int g = scanner.nextInt();
        
        
        switch (g) {
        case 1:
        System.out.println("Понедельник");
        break;
        case 2:
        System.out.println("Вторник");
        break;
        case 3:
        System.out.println("Среда");
        break;
        case 4:
        System.out.println("Четверг");
        break;
        case 5:
        System.out.println("Пятница!");
        break;
        case 6:
        System.out.println("Суббота!");
        break;
        case 7:
        System.out.println("Воскресенье!");
        break;
        default:
        System.out.println("Дня с таким номером не существует");
      }
        
        
        
        scanner.close();

	}

}
