package lesson3;

import java.util.Scanner;

public class Task2DopMainLine {

	public static void main(String[] args) {
		
		Scanner read=new Scanner(System.in);
		System.out.print("Введите размер матрицы - ");
		int n=read.nextInt();
		
		int matrix[][] = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0; j<n; j++){
				matrix[i][j]=(int)(Math.random()*100);
			}
					
		}
		/*int matrix[][]={
				{55,22,62},
				{92,65,52},
				{90,15,14}
		};
		
		int n =3;*/
		
		for(int i=0;i<n;i++){
			for(int j=0; j<n; j++){
				System.out.printf("%3d",matrix[i][j]);
			}
			System.out.println();
			}
		System.out.println("---------------");
		
		new DiagonalSort(matrix);
		
		/*int matrix2[] = new int[n];
		
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
			
			
			*/
			
			
		read.close();	
	}
}
