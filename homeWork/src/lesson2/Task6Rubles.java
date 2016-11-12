package lesson2;

import java.util.Scanner;

public class Task6Rubles {

	public static void main(String[] args) {
		// Вывод правильного падежа
		Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество рублей от 1 до 999 -");
        int var1 = scanner.nextInt();
        
        int n = 0;
        
         //Вычисление 2ух последних цифр
        
        int var2 = (int)(var1%100);
        
        /* Вычисление 2ой цифры в введеном числе  
         * Необходимо для проверки числед со значениями *11-*19    
         */
        
        int var3=(int)(var2/10);
        
        //Вычисление последней цифры
                
        int var4=(int)(var2%10);
        
        
        
      // Можно было сразу писать что выводить, я решил попрактиковаться :)
        
        if(var3==1){
        	n=1;
        }else{	
        	if(var4 == 0){
        		n=2;
        	}else{
        		if(var4 == 1){
        			n=3;
        		}else{
        			if(2<=var4 && var4<=4){
        				n=4;        			
        			}else{
        				if(5<=var4 && var4<=9)
        					n=5;
        			}
        		}
        	}
        }
        
        // Условия вводимого диапазона по условию задачи
        if(var1>999 || var1<1){
        	n=6;
         }
        
        switch (n) {
        case 1:
        System.out.println(var1+" рублей");
        break;
        case 2:
        System.out.println(var1+" рублей");
        break;
        case 3:
        System.out.println(var1+" рубль");
        break;
        case 4:
        System.out.println(var1+" рубля");
        break;
        case 5:
        System.out.println(var1+" рублей");
        break;
        default:
        System.out.println("Неверно введена денежная сумма");
        
        }
       
      
        scanner.close();

	}

}
