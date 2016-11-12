package lesson4;

public class Task2Deleting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="Получив этот дар, обезъяны "
				+ "бросили все свои новые интеллектуальные возможности "
				+ "на решение двух задач: найти замену своей косматой шкуре,"
				+ " которая была бы сменной, красиво раскрашенной и выгодно "
				+ "подчеркивала бы их сильные места, а также избавить "
				+ "себя от того, чтобы прикладывать какие-либо усилия в "
				+ "отношении чего бы то ни было путем изобретения всевозможных "
				+ "хитроумных приспособлений и машин. Фактически, ситуация "
				+ "остается неизменной и по сию пору.";
		
		char[] charArray = a.toCharArray();
		String signs=".,:!?-";
		char[] signsArray=signs.toCharArray();
		
		int numbers[]=new int[10];
		int n=0;
		for(int i=0;i<charArray.length;i++ ){	
        	for(int j=0;j<signsArray.length; j++){
        		if(charArray[i]==signsArray[j]){
        			numbers[n]=i;
        			n++;
        		}
        		
	}
        	System.out.print(charArray[i]);
		}
		
				
		System.out.println();
		for(int i=0;i<charArray.length-1;i++){
			for(int j=0;j<numbers.length;j++){
				if(i==numbers[j]){
					charArray[i]=charArray[i+1];
					i++;
				}
			}
			System.out.print(charArray[i]);
		}
		}
	}

