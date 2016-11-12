package lesson3;

import java.util.List;
import java.util.*;

public class DiagonalSort {
	
	private List<List<Integer>> columnValues;
	public DiagonalSort(int matrix[][]){
		int l=matrix.length;
		int columnIndex[]=new int[l];
		for(int i=0; i<l;i++){
			columnIndex[i]=i;
		}
		List<List<Integer>> permutation = permute(columnIndex);
		
		columnValues=new ArrayList<List<Integer>>();
		for(int i=0; i<l; i++){
			List<Integer> curCol=new ArrayList<Integer>();
			for(int j=0; j<l; j++){
				curCol.add(matrix[j][i]);
			}
			columnValues.add(curCol);
		}
		int counter=0;
		for(int i=0;i<permutation.size(); i++){
			List<Integer> curPerm=permutation.get(i);
			int[][] sortedArray=creatArray(curPerm);
			
			boolean isDiagonal=isDiagonal(sortedArray);
		    if(isDiagonal){
		    	counter++;
		    	for(int k=0;k<sortedArray.length;k++){
					for(int j=0; j<sortedArray.length; j++){
						System.out.printf("%3d",sortedArray[k][j]);
					}
					System.out.println();
					}
		    	System.out.println("---------------");
		    }
		    
			
		}
		if(counter==0){
			System.out.println("Нет возможных решений!");
		}
					
	
	}
	
	public boolean isDiagonal(int[][] matrix){
		boolean res=true;
		int prevVal=matrix[0][0];
		for(int i=1; i<matrix.length;i++){
			int curVal=matrix[i][i];
			if(curVal<prevVal){
				res=false;
				break;
			}
			prevVal=curVal;
		}
		return res;
		
	}
	
	
	public int[][] creatArray(List<Integer> colIndex){
		int [][] tempMatrix=new int[colIndex.size()][colIndex.size()];
		for(int i=0; i<colIndex.size(); i++){
			Integer[] temp = new Integer[columnValues.size()];
			(columnValues.get(colIndex.get(i))).toArray(temp);
			for(int j=0; j<colIndex.size(); j++){
				tempMatrix[i][j]=temp[j].intValue();
			}			
		}
		return tempMatrix;
	}
	
	public List<List<Integer>> permute(int[] nums) {
	    List<List<Integer>> results = new ArrayList<List<Integer>>();
	    if(nums == null || nums.length == 0) return results;
	    List<Integer> result = new ArrayList<>();
	    dfs(nums, results, result);
	    return results;
	}

	public void dfs(int[] nums, List<List<Integer>> results, List<Integer> result){
	    if(nums.length == result.size()){
	        List<Integer> temp = new ArrayList<>(result);
	        results.add(temp);
	    }        
	    for(int i=0; i<nums.length; i++){
	        if(result.contains(nums[i])) continue; 
	        result.add(nums[i]);
	        dfs(nums, results, result);
	        result.remove(result.size()-1);
	    }
	}
	   
}
