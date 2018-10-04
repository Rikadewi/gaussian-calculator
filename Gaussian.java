import java.io.*;
import java.util.*;



public class Gaussian { //ielas berisi method Gauss Elimination dan Gauss Jordan Elimination

	public static double[] solution;
	public static double[] JordanSolution;
	//KONSTRUKTOR
	Gaussian(){}


	public static void REF(MATRIKS M) {
	/* I.S Sebuah Matriis M yang berupa matriis koefisien dari Unknown dan array Sol yang merupaian matriks berisi solusi dari persamaan, apabila keduanya digabungkan akan menjadi matriks augmented
	/* M menjadi matriis bentui reduced Eschelon Form */

		// KAMUS LOKAL
		double ratio;
		double temp;
		 // Variabel iterator untuk menyimpan Row dan Col yang sedang dicei
		//Boolean untui mengetahui apaiah suatu elemen 0 atau buian
		int i,j,k,l;

		// ALGORITMA
		for(i = 0; i<M.NBrsEff; i++) {


						//STEP 1 : MEMBUAT LEADING ELEMENT MENJADI 1

					    boolean LeadingE;

					    for ( k = 0; k < M.NBrsEff; k++) {
					      ratio = 1;
					      LeadingE = true;
					      for ( j = 0; j < M.NKolEff; j++) {
					        if (LeadingE && M.Tab[k][j] != 0){
					          LeadingE = false;
					          ratio = 1/M.Tab[k][j];
					          M.Tab[k][j] *= ratio;
					        }else if (!LeadingE && M.Tab[k][j] != 0){
					          M.Tab[k][j] *= ratio;
					        }
					      }
					    }



			//STEP 2 : MEMBUAT SEMUA ELEMENT DIBAWAH LEADING ELEMENT MENJADI 0
			for(int row = i+1;row<M.NBrsEff;row++){
				if(M.Tab[i][IndexLeading(i,M)]!=0) {
					ratio = M.Tab[row][IndexLeading(i,M)]/M.Tab[i][IndexLeading(i,M)];		//ratio untuk pengali
					for(int col = 0;col<M.NKolEff;col++){
						M.Tab[row][col] -= ratio*(M.Tab[i][col]);
					}
				}
			}



		    //STEP 3 : MENGURUTKAN 0 SEHINGGA MEMBENTUK MATRIKS SEGITIGA BAWAH/ESCHELON
		    for ( k = 0; k < M.NBrsEff-1; k++) {
		      //Mencari jumlah nol di baris ke-i
		      int Nzero;
		      Nzero = 0; j = 0;
		      while (j < M.NKolEff-1 && M.Tab[k][j] == 0) {
		        Nzero++;
		        j++;
		      }
		      //Mencari jumlah nol di baris setelah baris ke-i
		      int RowToSwitch,zeroRowSw;
		      RowToSwitch = -1; zeroRowSw = Nzero;
		      for ( int k1 = k+1; k1 < M.NBrsEff; k1++) {
		        int NzeroX;
		        NzeroX = 0; l = 0;
		        while (l < M.NKolEff-1 && M.Tab[k1][l] == 0) {
		          NzeroX++;
		          l++;
		        }
		        if (NzeroX<zeroRowSw){
		          RowToSwitch = k1;
		          zeroRowSw = NzeroX;
		        }
		      }
		      //Menukar 2 baris
		      if (RowToSwitch != -1) {

		        for ( int m = 0; m < M.NKolEff; m++) {
		          temp =M.Tab[k][m];
		          M.Tab[k][m] = M.Tab[RowToSwitch][m];
		          M.Tab[RowToSwitch][m] = temp;
		        }
		      }
		    }




		}
	}
	public static void RREF(MATRIKS M) {
	/* I.S Sebuah Matriks M yang berbentuk REF
	/* M menjadi matriks bentuk reduced row Eschelon Form */
	    double ratio;
	    boolean isLeading;
		//Menjadikan matriksnya bentuk Reduced Eschelon Form

	    //Mengurangi tiap elemen di atas leading Element hingga terbentuk RREF
	    for ( int i = 0; i < M.NBrsEff; i++) {
	      for (int j = i+1; j < M.NBrsEff; j++) {
	        ratio = 1;
	        isLeading = true;
	        for ( int k = 0; k < M.NKolEff; k++) {
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

	// Fungsi untuk mememeriksa apakah suatu baris pada matriks Koefisien mengandung 0 semua
	public static boolean isCoefZero(int i, MATRIKS M){
	//I.S Sebuah Matriks M yang berbentuk REF/RREF dan index i yang menunjukan baris yang ingin dicek
	//F.S Boolean yang bernilai TRUE jika seluruh koefisien baris ke-i 0
	    int j = 0;
	    boolean found = false;
	    while (j<M.NKolEff-1 && !(found)) {
	      if (M.Tab[i][j] != 0) {
	        found = true;
	      }else{
	        j++;
	      }
	    }
	    return (!found);
	  }

	  //Memeriksa apakah elemen hasil baris ke-i adalah nol
	  public static boolean IsResultZero(int i, MATRIKS M){
		//I.S : Matriks M berbentuk REF/RREF
		//F.S Bernilai True jika pada kolom terakhir terdapat nilai 0
	    return (M.Tab[i][M.NKolEff-1] == 0);
	  }



	  public static boolean SingleLeading(int i, MATRIKS M){
		//I.S : Matriks M berbentuk REF/RREF
		//F.S : Bernilai TRUE jika pada baris ke-i matriks M hanya terdapat satu leading Element
	    boolean retLeadingOne, leadingOneFound;
	    retLeadingOne = true;
	    leadingOneFound = false;
	    for ( int j = 0; j < M.NKolEff-1; j++) {
	      //Mencari leading one
	      if (!leadingOneFound && M.Tab[i][j] != 0){
	        leadingOneFound = true;
	      } else if (leadingOneFound && M.Tab[i][j] != 0) {
	        //Memeriksa elemen setelah leading one hingga sebelum kolom hasil
	        retLeadingOne = false;
	      }
	    }
	    return retLeadingOne;
	  }

	  public static int IndexLeading(int i, MATRIKS M){
	  //I.S Baris ke-i Matriks M dicek, Matriks M berbentuk REF/RREF
		//F.S Integer yang menunjukan posisi dari Leading Element baris ke-i
	    boolean leadingFound;
	    int j;
	    j = 0;
	    leadingFound = false;
	    while (!leadingFound && j<M.NKolEff-1) {
	      //Mencari leading Element
	      if (!leadingFound && M.Tab[i][j] !=     0){
	        leadingFound = true;
	      }else{
	        j++;
	      }
	    }
			//Mengembalikan posisi leading Element
	    return j;
	  }








	public static boolean isSolvable(MATRIKS M){
	//I.S Matriks M yang berbentuk REF/RREF
	//F.S Bernilai TRUE jika matriks M mempunyai solusi
	    int i = 0;
	    boolean retSol = true;
	    while (retSol && i<M.NBrsEff) {
	      if ((isCoefZero(i,M)) && (!IsResultZero(i,M))) {
	        retSol = false;
	      }else{
	        i++;
	      }
	    }
	    return retSol;
	  }

	  public static String[] Solver(MATRIKS M){
	  // I.S MATRIKS M berbentuk REF/RREF dan mempunyai solusi
		// F.S Sebuah Array of String yang berisi solusi dari persamaan yang direpresentasikan Matriks M
	    String[] resultArray = new String[M.NKolEff-1]; //Check
	    for (int i=0; i<M.NKolEff-1; i++) {
	      resultArray[i] = Character.toString((char) (i + 96));
	    }
	    for (int i=M.NBrsEff-1; i>=0; i--) {
	      if (!isCoefZero(i,M)) {
	        if (SingleLeading(i,M)) {
	          //Hanya ada leading one saja pada baris ke-i, sisanya 0
	          resultArray[IndexLeading(i,M)] = Double.toString(M.Tab[i][M.NKolEff-1]);
	        }
	        else{
	          //Ada elemen non-0 setelah leading one pada baris ke-i
	          double resDouble = M.Tab[i][M.NKolEff-1];
	          String resString = "";
	          for (int j=IndexLeading(i,M)+1; j<M.NKolEff-1; j++) {
	            if (M.Tab[i][j] != 0) {
	              //Kondisi elemen M ke i,j bukan 0
	              try {
	                //Jika hasil ke-x merupakan bilangan, maka jumlahkan dengan elemen hasil
	                resDouble += (-1)*M.Tab[i][j]*Double.valueOf(resultArray[j]);
	              } catch(NumberFormatException e) {
	                //Jika hasil ke-x bukan bilangan, sambungkan koefisien dengan parameter yang sesuai
	                resString += ConCoefParam((-1)*M.Tab[i][j],resultArray[j]);
	              }
	            }
	          }
	          //Gabungkan bilangan hasil dengan parameter
	          resultArray[IndexLeading(i,M)] = Double.toString(resDouble) + resString;
	        }
	      }
	    }
	    return resultArray;
	  }

	  private static String ConCoefParam(double coef, String param){
		//I.S Coef dan param terdefinisi
		// F.S Sebuah string yang berisi gabungan dari parmeter dan soluso
	    if (param.length()>1){
	      param = "("+param+")";
	    }
	    if (coef>1) {
	      return "+" + Double.toString(coef) + param;
	    }else if (coef == 1){
	      return "+" + param;
	    }else if (coef == -1){
	      return "-" + param;
	    }else{
	      return Double.toString(coef) + param;
	    }
	  }

	public static double[] ArrStringtoDouble (String[] S) {
		//I.S Tidak boleh solusi Parametrik!
		//F.S Sebuah array solusi yang berisi integer
			double[] newArray = new double[S.length];
			for (int i=0; i<S.length; i++) {
		      newArray[i]= Double.valueOf(S[i]);
			}
			return newArray;
	}

	// Method buat ngeprint solusi

	public static void printSol(MATRIKS M){
	//I.S Matriks M terdefinisi (belum tentu Solvable)
	//F.S Menuliskan ke layar solusi dari SPL
		String[] result = new String[0];
		if (Gaussian.isSolvable(M)) {
			result = Gaussian.Solver(M);
			for(int i=0;i<result.length;i++) {
				 System.out.println("x"+(i+1)+":"+result[i]);
			}
		}

		else {
			System.out.println("No Solution");
		}

	}




	//Fungsi untuk menghasilian matriks gauss jordan elimination

	// Write code


}
