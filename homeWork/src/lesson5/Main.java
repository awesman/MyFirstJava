package lesson5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);

		Bus[] bus = new Bus[5];
		bus[0] = new Bus("Иванов А.В.", 4382, 12, "Мерседес",
				2012, 120);
		bus[1] = new Bus("Кириленко А.С.", 7581, 44, "VOLVO",
				2006, 370);
		bus[2] = new Bus("Сидорчук Н.Г.", 1396, 68, "МАЗ", 1999,
				876);
		bus[3] = new Bus("Богданов И.Д.", 5469, 77, "MAN", 2001,
				750);
		bus[4] = new Bus("Борисевич П.М.", 7311, 25, "TOYOTA",
				2005, 396);

		System.out.print("Введите номер маршрута:");
		int n = read.nextInt();
		System.out.println();

		int k = 5;
		for (int i = 0; i < 5; i++) {

			if (bus[i].getRouteNumber() == n) {
				System.out.println(bus[i].toString());

			} else {
				k--;
			}
		}
		if (k == 0) {
			System.out.println(
					"Автобусы по такому маршруту не ходят");
		}
		System.out.println();

		System.out.print("Введите срок эксплуатации:");
		int y = read.nextInt();
		System.out.println();

		int l = 5;
		for (int i = 0; i < 5; i++) {

			if ((2016 - bus[i].getFirstYear()) > y) {
				System.out.println(bus[i].toString());

			} else {
				l--;
			}
		}
		if (l == 0) {
			System.out.println(
					"Все автобусы эксплуатируются меньше!");
		}
		System.out.println();

		System.out.print("Введите желаемый пробег(х тыс. км.):");
		int S = read.nextInt();
		System.out.println();

		int m = 5;
		for (int i = 0; i < 5; i++) {

			if (bus[i].getRun() > S) {
				System.out.println(bus[i].toString());

			} else {
				m--;
			}
		}
		if (m == 0) {
			System.out.println(
					"Все автобусы эксплуатируются меньше!");
		}

		read.close();
	}

}
