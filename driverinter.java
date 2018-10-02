import java.io.*;
import java.util.*;

public class driverinter {

	public static void main(String[] args) {
		

		MATRIKS M = new MATRIKS(); 

		Scanner in = new Scanner (System.in);

		//baca inputan interpolasi

		int n = in.nextInt();
		M.BacaInputUser(n, 2); 
		
		//melakukan interpolasi
		interpolasi.MatriksInterpolasi (M);
		
		//mencetak solusi interpolasi
		interpolasi.printPol(Gaussian.solution);	
		
		double x  = in.nextDouble();
		System.out.printf("p(%.3f) = %.3f\n", x, interpolasi.solusiInterpolasi ( x, Gaussian.solution));
	}
	

}
