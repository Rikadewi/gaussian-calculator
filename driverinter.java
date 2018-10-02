import java.io.*;
import java.util.*;

public class driverinter {

	public static void main(String[] args) {
		

		MATRIKS M = new MATRIKS(); 

		Scanner in = new Scanner (System.in);

		//baca inputan interpolasi dari user

		int n = in.nextInt();
		M.BacaInputUser(n+1, 2); 


		
		//melakukan interpolasi
		interpolasi.MatriksInterpolasi (M);
		
		//mencetak solusi interpolasi
		interpolasi.printPol(Gaussian.solution);	
		
		double x  = in.nextDouble();
		double y = interpolasi.solusiInterpolasi ( x, Gaussian.solution);
		System.out.printf("p(%.3f) = %.3f\n", x, y);

		//baca inputan dari file eksternal

		Scanner inn = new Scanner (System.in);

		String filename = inn.nextLine();
		M.BacaFileEksternal(filename);

		//melakukan interpolasi
		interpolasi.MatriksInterpolasi (M);
		
		x  = in.nextDouble();
		y = interpolasi.solusiInterpolasi ( x, Gaussian.solution);

		//mencetak ke file eksternal

		filename = inn.nextLine();
		interpolasi.TulisInter (filename, Gaussian.solution, x, y);
	}
	

}
