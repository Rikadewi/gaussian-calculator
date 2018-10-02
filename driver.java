import java.io.*;
import java.util.*;

public class driver {

	public static void main(String[] args) {
		//buat objek
		MATRIKS M = new MATRIKS();
		//input data dari user

		Scanner in = new Scanner (System.in);

		int row = in.nextInt();
		int col = in.nextInt();

		M.BacaInputUser(row, col);
		
		
		//Melakukan Gauss
		Gaussian.Gauss(M);
		Gaussian.backSub(M);
		Gaussian.printSol(Gaussian.solution);
		//cetak matriks
		
		M.CetakMATRIKS ();

		//input data dari file eksternal
		Scanner inn = new Scanner (System.in);

		String filename = inn.nextLine(); 
		M.BacaFileEksternal(filename);
		M.CetakMATRIKS ();
		
		
		
		//tulis data ke file eksternal
		Scanner innn = new Scanner (System.in);

		filename = innn.nextLine(); 
		M.TulisFileEksternal(filename);
		
		
		
	}
	

}
