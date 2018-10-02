import java.io.*;
import java.util.*;

public class interpolasi {

	public static void MatriksInterpolasi(MATRIKS M) {
		//menerima input matriks n baris 2 kolom

		//membuat matriks kuadratik
		MATRIKS M1 = new MATRIKS();
		
		M1.NBrsEff = M.NBrsEff;
		M1.NKolEff = 4;

		for (int i=0;i<M1.NBrsEff; i++){
			for (int j=0;j<M1.NKolEff; j++){
				if (j==0){
					M1.Tab[i][j]=1;
				} 
				if (j==1){
					M1.Tab[i][j]=M.Tab[i][0];
				} 
				if (j==2){
					M1.Tab[i][j]=M.Tab[i][0]*M.Tab[i][0];
				} 
				if (j==3){
					M1.Tab[i][j]=M.Tab[i][1];
				}
			}
		}

		//Melakukan Gauss
		Gaussian.Gauss(M1);
		Gaussian.backSub(M1);
		
	}
	
	public static void printPol(double solution [])
	{	
		System.out.printf("p(x) = ");
		for(int i = 0;i<solution.length;i++)
		{
			if (solution[i]<0){
				System.out.printf(" - %.3f", -1*solution[i]);
			}else{
				if (i!=0){
					System.out.printf(" + ");
				}
				System.out.printf("%.3f",solution[i]);
			}

			if (i==1){
				System.out.printf("x");
			}
			if (i==2){
				System.out.printf("x^2");
			}
			
		}
		System.out.printf("\n");
	}

	public static double solusiInterpolasi (double x, double solution []){
		return solution[0] + solution[1] * x + solution[2] * x * x;
	}

}
