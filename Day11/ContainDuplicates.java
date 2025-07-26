package cspractice;
import java.util.*;
public class ContainDuplicates {
	public static void main(String[] args) {
		
         Set<Integer> result=new HashSet<>();
         int arr[]= {1,2,3,4,5};
         boolean found=false;
         for(int val:arr) {
        	 if(result.contains(val)) {
    
        		  found=true;
        		  break;
        	 }
        	 else {
        		 result.add(val);
        	 }
        	 
         }
         
         if(found){
        	 System.out.println("duplicates");
         }
         else {
        	 System.out.println("no duplicates");
         }
         
	}

}
