package lesson4;

public class Task4AppNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="stay hungry stay foolish";
        char[] charArray = a.toCharArray();
        
        for(int i=0;i<charArray.length;i++){
        	int n=0;
        	 for(int j=0;j<charArray.length;j++){
        		 if(charArray[i]==charArray[j]){
        			 n++;
        		 }
        	 }
        	 System.out.println("Буква "+charArray[i]+" встречается "+n+" раз.");
        }

	}

}
