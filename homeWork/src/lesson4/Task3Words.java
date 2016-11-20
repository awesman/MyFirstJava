package lesson4;

import java.util.Scanner;

public class Task3Words {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner read = new Scanner(System.in);
		System.out.print("Введите длинну слов которые хотите удалить:");
		int n=read.nextInt();
		String s="низкоуровневый язык — это когда требуется внимание к вещам, которые никак не связаны с программами на этом языке.";
		String[] words=s.split(" ");
		String s1="бвгджзклмнпрстфхцчшщ";
		char[] consonant=s1.toCharArray();
		
		
		
          for(int i=0; i<words.length;i++){
        	  for(int j=0; j<consonant.length;j++){
        		  if(words[i].length()==n){
        			  words[i]=words[i+1];
    				  i++;
        			  if(words[i].charAt(0)==consonant[j]){
        				  words[i]=words[i+1];
        				  i++;
        			  }
        		  }
        		  
        	  }
        	  System.out.print(words[i]+" ");
		  }
         
        
		read.close();
	}

}
