package lesson2;

public class Calc {
	//Дополнительный метод для калькулятора  Task6DopCalc
	public static double Metod(double a,String sign,double b){
	  double result = 0;
	  switch(sign){
	  case "+": result=a+b;
	  break;
	  case "-": result=a-b;
	  break;
	  case "*": result=a*b;
	  break;
	  case "/": if(b==0){
		  System.out.println("Деление на 0 запрещено");
		 	  } else{
			  result=a/b;
		  }
		  
	  break;
	  }
		/* Так и не придумал как при делении на 0 сделать так чтобы результат не выводился,
		 * при делении на 0 выдает сообщение, но все равно выводит результат 0
		 */
		return result;
		
	}

}
