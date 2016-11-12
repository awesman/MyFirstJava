package lesson4;

public class Task1EngStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            String a="stay hungry stay foolish";
            char[] charArray = a.toCharArray();
            System.out.println(charArray);
            String alphabet="abcdefghijklmnopqrstuvwxyz";
            char[] alphabetArr=alphabet.toCharArray();
            
            for(int i=0;i<charArray.length;i++ ){
            System.out.printf("%3s",String.valueOf(charArray[i]));
            }
            
            System.out.println();
            
            
            
            for(int i=0;i<charArray.length;i++ ){	
            	for(int j=0;j<alphabetArr.length; j++){
            		if(charArray[i]==' '){
            			System.out.printf("%3s"," ");
            			break;
            		}else if(charArray[i]==alphabetArr[j]){
            			System.out.printf("%3d",(int)(j+1));
            		}	
            	}
          }  	  
	}
}
