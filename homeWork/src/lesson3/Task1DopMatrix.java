package lesson3;

import java.util.Scanner;

public class Task1DopMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner read=new Scanner(System.in);
		System.out.print("Введите размер матрицы - ");
		int n=read.nextInt();
		
		int matrix[][] = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0; j<n; j++){
				matrix[i][j]=(int)(Math.random()*100);
			}
			
		}
		
		for(int i=0;i<n;i++){
			for(int j=0; j<n; j++){
		System.out.printf("%3d",matrix[i][j]);
			}
			System.out.println();
		}
		
		int matrix2[] = new int[n];
		int matrix3[]=new int[n];
		
		for(int i=0; i<n ;i++){
			for(int j=0;j<n;j++){
				if(i==j){
				matrix2[i]=matrix[i][j];
				}
			}
		}
		System.out.print("Главная ось: ");
		for(int i=0; i<n ;i++){
		System.out.print(" "+matrix2[i]);
		}
		System.out.println();
		
		for(int i=0; i<n ;i++){
			for(int j=0;j<n;j++){
				if(j==(n-1-i)){
				matrix3[i]=matrix[i][j];
				}
			}
				
		}
		System.out.print("Побочная ось: ");
		for(int i=0; i<n ;i++){
		System.out.print(" "+matrix3[i]);
		}
		
       read.close();
	}

}
