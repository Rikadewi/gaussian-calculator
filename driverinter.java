import java.io.*;
import java.util.*;

public class driverinter {

	public static void main(String[] args) {
		

		MATRIKS M = new MATRIKS(); 

		Scanner in = new Scanner (System.in);

		// //baca inputan interpolasi dari user

		// int n = in.nextInt();
		// M.BacaInputUser(n+1, 2); 


		
		// //melakukan interpolasi
		// interpolasi.MatriksInterpolasi (M);
		
		// //mencetak solusi interpolasi
		// interpolasi.printPol(Gaussian.solution);	
		
		// double x  = in.nextDouble();
		// double y = interpolasi.solusiInterpolasi ( x, Gaussian.solution);
		// System.out.printf("p(%.3f) = %.3f\n", x, y);

		//baca inputan dari file eksternal

		Scanner inn = new Scanner (System.in);

		String filename = inn.nextLine();
		M.BacaFileEksternal(filename);

		//melakukan interpolasi
		interpolasi.MatriksInterpolasi (M);
		double [] x = new double [100];
		double [] y = new double [100];
		int i=0;
		x[i]  = in.nextDouble();
		while (x[i]!=-999) {
			
			y[i] = interpolasi.solusiInterpolasi ( x[i], Gaussian.solution);
			i++;
			x[i]  = in.nextDouble();
		} 

		//mencetak ke file eksternal

		filename = inn.nextLine();
		interpolasi.TulisPol (filename, Gaussian.solution);
		for (int j = 0; j< i; j++){
			interpolasi.TulisPx (filename, Gaussian.solution.length-1, x[j], y[j]);
		}
		
	}
	

}
