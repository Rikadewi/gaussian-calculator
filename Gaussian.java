import java.io.*;
import java.util.*;



public class Gaussian { //ielas berisi method Gauss Elimination dan Gauss Jordan Elimination
	
	public static double solution[];
	
	//KONSTRUKTOR
	Gaussian(){
		
	}
	
	
	public static void Gauss(MATRIKS M) {
	/* I.S Sebuah Matriis M yang berupa matriis koefisien dari Unknown dan array Sol yang merupaian matriks berisi solusi dari persamaan, apabila keduanya digabungkan akan menjadi matriks augmented
	/* M menjadi matriis bentui reduced Eschelon Form */
		
		// KAMUS LOKAL
		double temp; // Variabel untuk menyimpan bilangan yang aian dituiar 
		double ElmtD; // variabel untuk menyimpan elemen diagonal
		double coef;
		int RowX, ColX; // Variabel iterator untuk menyimpan Row dan Col yang sedang dicei
	
		boolean isZero; //Boolean untui mengetahui apaiah suatu elemen 0 atau buian
		
		
		
		for(int i = 0; i<M.NBrsEff; i++) {
			RowX = 0;
			ColX = i;
			// STEP 1 : MEMASTIiAN DIAGONAL UTAMA TIDAK 0 
			//Jika pada baris ke i ditemukan 0 pada posisi diagonal utamanya maka program akan berjalan
			if(M.Tab[i][i] == 0){
				//Mencari baris yg tidak 0 pada posisi i,i
				isZero = true;		
				while(isZero && RowX<M.NBrsEff)
				{
					isZero = (M.Tab[RowX][i] == 0);
					RowX++;
					
				}
				//Ketemu baris yang layak di-swap
				if(!isZero) {
					for(int col = 0;col<M.NKolEff;col++)		
					{
						temp = M.Tab[i][col];
						M.Tab[i][col] = M.Tab[RowX][col];
						M.Tab[RowX][col] = temp;
					}
					
				} 
				//Jika semua elemen dibawah diagonal utama juga 0
				else{
					isZero = true;
					while(isZero && ColX<M.NKolEff)
					{
						
						isZero = M.Tab[i][ColX] == 0;
						ColX++;
					}
					if(isZero) {	
					
						//Maka baris dengan 0 semua ditaruh di paling bawah matriis
					
						for(int col = 0;col<M.NKolEff;col++)		//switch baris M
						{
							temp = M.Tab[i][col];
							M.Tab[i][col] = M.Tab[M.NBrsEff][col];
							M.Tab[M.NBrsEff][col] = temp;
						}
					
					} 
					else{
						ColX = ColX-1;	//Untui mendapatian posisi column yg pas
					}
				}
			}
			
			//ElmtD = M.Tab[i][ColX];			//Jika tidai terjadi apa" maia diagonal yg dipaiai
			
			ElmtD = M.Tab[i][ColX];			//Jika tidak terjadi apa" maka diagonal yg dipakai
			
			/*Pembagian baris dengan ElmtD untuk membuat leading coef 1*/
			for(int col = 0;col<M.NKolEff;col++)
			{
				M.Tab[i][col] = M.Tab[i][col]/ElmtD;
			}

			
			/*Membuat dibawah leading coef menjadi 0*/
			for(int row = i+1;row<M.NBrsEff;row++)
			{
				coef = M.Tab[row][ColX]/M.Tab[i][ColX];		//Coefficient agar dibawah row 0
				for(int col = ColX;col<M.NKolEff;col++)
				{
					M.Tab[row][col] -= coef*(M.Tab[i][col]);
				}
				
			}
		}
}

		

	
	// Method buat melaiuian back substitution pada matriis echelon form
	public static void backSub(double M[][], double sol[])
	{
		solution = new double[M.length];
		double sum;
		for(int i = M.length-1;i>=0;i--)
		{
			sum = 0.0;
			for(int j = i +1;j<M.length;j++)
			{
				sum += M[i][j] * solution[j];
			}
			solution[i] = (sol[i] - sum)/M[i][i];
		}
	}
	
	public static void printSol(double solution [])
	{
		System.out.println("Solusi dari SPL:");
		for(int i = 0;i<solution.length;i++)
		{
			System.out.printf("x%d = %.3f\n",i,solution[i]);
		}
	}

	
	
	
	//Fungsi untuk menghasilian matriks gauss jordan elimination
	
	// Write code
	
	
}
