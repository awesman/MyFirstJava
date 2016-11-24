package project;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
	static int choose;

	public static void main(String[] args) throws IOException {

		Insurance firstDoc = new HealthInsurance(1800, 5,"Roger Insurance", 5, 45);
		Insurance secondDoc = new AutoInsurance(500, 8,"BMW Insurance", 8, "BMW");
		Insurance thirdDoc = new PropertyInsurance(4500, 4, 10,	"McDonalds", 45000000);

		ArrayList<Insurance> docList =new ArrayList<Insurance>();

		docList.add(firstDoc);
		docList.add(secondDoc);
		docList.add(thirdDoc);

		 
		FileOutputStream fos = new FileOutputStream("text.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		for (Insurance insurance : docList){
			oos.writeObject(insurance.toString()+"\n");
		}
	
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("Меню:");
		System.out.println("Нажмите 1 для вывода стоимости дериватива.");
		System.out.println("Нажмите 2 для вывода списка страховок по убыванию рисков.");
		System.out.println("Нажмите 3 для поиска страховки по заданной цене.");
		System.out.println("Нажмите 4 для выхода.");
       
		do {
			try{
				
		  int choose = read.nextInt();
		  
		  switch (choose) {
			case 1:
				summ(docList);
				break;
			case 2:
				Collections.sort(docList,new InsuranceComporator());
				print(docList);
				
				//oos.writeObject(docList);
				break;
			case 3:
				System.out.print("Введите минимальную цену:");
				int lowSide = read.nextInt();
				System.out.print("Введите максимальную цену:");
				int upSide = read.nextInt();
				priceCheck(docList,lowSide, upSide );
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Введите значение от 1 до 4!");
			}
		  }catch(InputMismatchException e){
				System.out.println("Ошибка "+e);
				break;
			}
		} while (choose != 4);
		
		read.close();
		oos.close();
		//output.close();
	}

	public static void print(ArrayList<Insurance> docList) {
		for (Insurance insurance : docList)
			System.out.println(insurance);
		    System.out.println();
	}

	 public static void priceCheck(ArrayList<Insurance> docList,int a,int b){
		 for (Insurance insurance : docList) {
				if (insurance.getInsuranceCost() < b
						&& insurance.getInsuranceCost() > a) {
					System.out.println(insurance);
				}
			}
	    }
	 
	 public static void summ(ArrayList<Insurance> docList) {
		 int resultPrice = 0;
			for (int i = 0; i < docList.size(); i++) {
				Insurance ArrayList = docList.get(i);
				resultPrice = resultPrice+ ArrayList.getInsuranceCost();
			}
			System.out.println("Общая цена = "+resultPrice);
			System.out.println();
		}

}
    
