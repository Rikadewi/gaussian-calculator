import java.io.*;
import java.util.*;



public class Gaussian { //ielas berisi method Gauss Elimination dan Gauss Jordan Elimination
	
	public static double[] solution;
	
	//KONSTRUKTOR
	Gaussian(){
		
	}
	
	
	public static void Gauss(MATRIKS M) {
	/* I.S Sebuah Matriis M yang berupa matriis koefisien dari Unknown dan array Sol yang merupaian matriks berisi solusi dari persamaan, apabila keduanya digabungkan akan menjadi matriks augmented
	/* M menjadi matriis bentui reduced Eschelon Form */
		
		// KAMUS LOKAL
		double temp; // Variabel untuk menyimpan bilangan yang aian dituiar 
		double LeadingE; // variabel untuk menyimpan elemen diagonal
		double ratio;
		int RowX, ColX; // Variabel iterator untuk menyimpan Row dan Col yang sedang dicei
		boolean isZero; //Boolean untui mengetahui apaiah suatu elemen 0 atau buian
		
		
		// ALGORITMA 
		for(int i = 0; i<M.NBrsEff; i++) {
			RowX = 0;
			ColX = i;
			
			// STEP 1 : MEMASTIiAN DIAGONAL UTAMA TIDAK 0 
		
			if(M.Tab[i][i] == 0){
				//Mencari baris yg tidak 0 pada posisi i,i
				isZero = true;		
				while(isZero && RowX<M.NBrsEff)
				{
					isZero = (M.Tab[RowX][i] == 0);
					RowX++;
					
				}
				//Ketemu baris yang dapat di-swap
				if(!isZero) {
					//Algoritma swap baris
					for(int col = 0;col<M.NKolEff;col++){
						temp = M.Tab[i][col];
						M.Tab[i][col] = M.Tab[RowX][col];
						M.Tab[RowX][col] = temp;
					}
					
				} 
				//Jika semua elemen dibawah diagonal utama juga 0
				else{
					isZero = true;
					while(isZero && ColX<M.NKolEff){
						
						isZero = M.Tab[i][ColX] == 0;
						ColX++;
					}
					//Jika dalam baris ke-i semua elemen 0
					if(isZero) {						
						for(int col = 0;col<M.NKolEff;col++){
							temp = M.Tab[i][col];
							M.Tab[i][col] = M.Tab[M.NBrsEff][col];
							M.Tab[M.NBrsEff][col] = temp;
						}
					
					} 
					else{
						ColX = ColX-1;	//Mengganti nilai variabel ColX
					}
				}
			}
			
			
			//STEP 2 : MEMBUAT LEADING ELEMENT MENJADI 1
			
			LeadingE = M.Tab[i][ColX];			// Menyimpan Leading Element non zero ke variabel Leading E
			
			for(int col = 0;col<M.NKolEff;col++){
				M.Tab[i][col] = M.Tab[i][col]/LeadingE;
			}

			
			//STEP 3 : MEMBUAT SEMUA ELEMENT DIBAWAH LEADING ELEMENT MENJADI 0 DENGAN OBE
			
			for(int row = i+1;row<M.NBrsEff;row++)
			{
				ratio = M.Tab[row][ColX]/M.Tab[i][ColX];		//ratio untuk pengali
				for(int col = ColX;col<M.NKolEff;col++)
				{
					M.Tab[row][col] -= ratio*(M.Tab[i][col]);
				}
				
			}
		}	
	}
	public static void GaussJordan(MATRIKS M) {
	/* I.S Sebuah Matriks M yang mempunyai solusi
	/* M menjadi matriks bentuk reduced row Eschelon Form */

	    double ratio;
	    boolean isLeading;
		//Menjadikan matriksnya bentuk Reduced Eschelon Form
		Gauss(M);

	    //Mengurangi tiap elemen di atas leading Element hingga terbentuk RREF
	    for ( int i = 0; i < M.NBrsEff; i++) {
	      for (int j = i+1; j <= M.NBrsEff; j++) {
	        ratio = 1;
	        isLeading = true;
	        for ( int k = 1; k <= M.NKolEff; k++) {
	          if (isLeading && M.Tab[j][k] != 0){
	            isLeading = false;
	            ratio = M.Tab[i][k]/M.Tab[j][k];
	            M.Tab[i][k] -= ratio*M.Tab[j][k];
	          }else if ((!isLeading)){
	            M.Tab[i][k] -= ratio*M.Tab[j][k];
	          }
	        }
	      }
	    }
	  }
	

		

	
	// Method buat melaiuian back substitution pada matriis echelon form
	public static void backSub(MATRIKS M)
	{
		solution = new double[M.NBrsEff];
		double[][] coefM = new double[M.NBrsEff][M.NKolEff-1];
		double[] solM = new double[M.NBrsEff];
		
		//Mengisi matriks koefisien
		for (int i = 0; i< M.NBrsEff; i++) {
			for (int j=0; j< M.NKolEff-1; j++) {
				coefM[i][j] = M.Tab[i][j];
			}
		}
		
		//Mengisi matriks solusi
		for (int k =0; k<M.NBrsEff;k++) {
			solM[k] = M.Tab[k][M.NKolEff-1];
		}
		
		
		double sum;
		for(int i = (M.NBrsEff)-1;i>=0;i--)
		{
			sum = 0.0;
			for(int j = i +1;j<coefM.length;j++)
			{
				sum += coefM[i][j] * solution[j];
			}
			solution[i] = (solM[i] - sum)/coefM[i][i];
		}
	}
	
	public static void printSol(double solution [])
	{
		System.out.println("Solusi dari SPL:");
		for(int i = 0;i<solution.length;i++)
		{
			System.out.printf("x%d = %.3f\n",i+1,solution[i]);
		}
	}

	
	
	
	//Fungsi untuk menghasilian matriks gauss jordan elimination
	
	// Write code
	
	
}
