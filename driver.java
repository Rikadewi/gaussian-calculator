import java.io.*;
import java.util.*;

public class driver {

	public static void main(String[] args) {
		

		MATRIKS M = new MATRIKS(); 

		Scanner in = new Scanner (System.in);

		//baca inputan interpolasi

		int n = in.nextInt();
		M.BacaInputUser(n, 2); 
		
		//melakukan interpolasi
		interpolasi.SolusiInterpolasi (M);
		
		//mencetak solusi interpolasi
		Gaussian.printSol(Gaussian.solution);	
		
	}
	

}
