package lesson2;

public class Task1StringDivision {

	public static void main(String[] args) {
		// Программа разбивающая строку на 2 равных строки
		String var1 = "Всегда пишите код так, будто сопровождать его будет склонный к насилию психопат, который знает, где вы живете.";
        System.out.println(var1);
        int lenght = var1.length();
        System.out.println("Количество символов в строке="+lenght);
        String var2 = var1.substring(0,lenght/2);
        String var3 = var1.substring(lenght/2,lenght);

        System.out.println(var2);
        System.out.println(var3);

	}

}
