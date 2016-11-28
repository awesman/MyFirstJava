package project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Создание дериватива, подсчет его стоимости, сортировка по уменьшению рисков,
 * а так же поиск стаховки по заданному диапазону
 * @author Pavel
 * @version 1.0 beta
 */

public class Main {
	
	public static void main(String[] args)throws IOException, ClassNotFoundException {

		Insurance firstDoc = new HealthInsurance(1800, 5,"Roger Insurance", 5, 45);
		Insurance secondDoc = new AutoInsurance(500, 8,"BMW Insurance", 8, "BMW");
		Insurance thirdDoc = new PropertyInsurance(4500, 4, 10,"McDonalds", 45000000);
		
		ArrayList<Insurance> docList =new ArrayList<Insurance>();
		
		docList.add(firstDoc);
		docList.add(secondDoc);
		docList.add(thirdDoc);
		
		FileOutputStream fos = new FileOutputStream("text.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(firstDoc);
		oos.writeObject(secondDoc);
		oos.writeObject(thirdDoc);
		
		FileInputStream fis = new FileInputStream("text.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("Меню:");
		System.out.println("Нажмите 1 для вывода стоимости дериватива.");
		System.out.println("Нажмите 2 для вывода списка страховок по убыванию рисков.");
		System.out.println("Нажмите 3 для поиска страховки по заданной цене.");
		System.out.println("Нажмите 4 для десериализация.");
		System.out.println("Нажмите 5 для выхода.");
		
		boolean t=true;
		
		int choose = 0;
		do {
			try {
			 choose = read.nextInt();
			
			 switch (choose) {
				case 1:
					summ(docList);
					break;
				case 2:
					Collections.sort(docList,new InsuranceComporator());
					print(docList);
					break;
				case 3:
					System.out.print("Введите минимальную цену:");
					int lowSide = read.nextInt();
					System.out.print("Введите максимальную цену:");
					int upSide = read.nextInt();
					priceCheck(docList, lowSide, upSide);
					break;
				case 4:
					 Insurance newFirstDoc=(Insurance) ois.readObject();
					 Insurance newSecondDoc=(Insurance) ois.readObject();
					 Insurance newThirdDoc=(Insurance) ois.readObject();
					 System.out.println(newFirstDoc);
					 System.out.println(newSecondDoc);
					 System.out.println(newThirdDoc);
					 break;
				case 5:
					t=false;
					break;
				default:
					System.out.println("Введите значение от 1 до 5!");
				}
			} catch (InputMismatchException e) {
				System.out.println("Ошибка " + e);
				choose = 1;
			}
		} while (t==true);
		read.close();
		oos.close();
		ois.close();
	}
	public static void print(ArrayList<Insurance> docList) {
		for (Insurance insurance : docList)
			System.out.println(insurance);
		    System.out.println();
	}
	public static void priceCheck(ArrayList<Insurance> docList,int a, int b) {
		for (Insurance insurance : docList) {
			if (insurance.getInsuranceCost() < b && insurance.getInsuranceCost() > a) {
				System.out.println(insurance);
			}
		}
	}
	public static void summ(ArrayList<Insurance> docList) {
		int resultPrice = 0;
		for (int i = 0; i < docList.size(); i++) {
			Insurance ArrayList = docList.get(i);
			resultPrice =resultPrice + ArrayList.getInsuranceCost();
		}
		System.out.println("Общая цена = " + resultPrice);
		System.out.println();
	}
}
