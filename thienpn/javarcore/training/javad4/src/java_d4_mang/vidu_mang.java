package java_d4_mang;

public class vidu_mang {
	
	public static int[] giam_dan(int[] ar) {
		 for(int i=0;i<ar.length-1;i++) {
			   for(int j=i+1;j<ar.length;j++) {
				   if(ar[i]<ar[j]){
					   int max=ar[0];
					   max=ar[i];
					   ar[i]=ar[j];
					   ar[j]=max;
				   }
				 
			   }
			   
		   }
		 return ar;
	}
	public static void inmang(int[] bb) {
		 bb=giam_dan(bb);
		 for(int i=0;i<bb.length;i++) {
			   System.out.println(bb[i]);
		   }
	}
	
   public static void main(String args[]) {
	   
	   int[] ar_songuyen = {1,5,6,3,9,};
	  
	  inmang(ar_songuyen);
	   
	  
	   System.out.printf("%n");
	   
	   
	   
	   int[] xapxep= {3,7,9,4,5};
	  inmang(xapxep);
   }
   
}
