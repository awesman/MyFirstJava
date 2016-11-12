package lesson3;

public class Task5Op {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mas[]={5,1,8,10,-2,0,12,-1,-62,74};
		
		long op=1l;
		for(int i=0; i<10; i++){
			if(mas[i]==0){
				break;
			}else{
				op=op*mas[i];
			}
		}
   System.out.println("Произведение до 0= "+op);
	}

}
