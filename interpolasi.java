import java.io.*;
import java.util.*;

public class interpolasi {

	public static void MatriksInterpolasi(MATRIKS M) {
		//menerima input matriks n baris 2 kolom

		//membuat matriks kuadratik
		MATRIKS M1 = new MATRIKS();
		
		M1.NBrsEff = M.NBrsEff;
		M1.NKolEff = M.NBrsEff+1;

		for (int i=0;i<M1.NBrsEff; i++){
			int j;
			for (j=0;j<M1.NKolEff-1; j++){
				M1.Tab[i][j]=Math.pow(M.Tab[i][0],j);
			}
			M1.Tab[i][j] = M.Tab[i][1];
		}

		//Melakukan Gauss
		Gaussian.REF(M1);
		Gaussian.backSub(M1);
		
	}
	
	public static void printPol(double solution [])
	{	
		System.out.printf("p%d(x) = ", solution.length-1);
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

			if (i!=0){
				System.out.printf("x");
			}
			if (i>1){
				System.out.printf("^%d", i);
			}
			
		}
		System.out.printf("\n");
	}

	public static double solusiInterpolasi (double x, double solution []){
		double hsl = 0;

		for(int i = 0;i<solution.length;i++)
		{
			hsl += Math.pow (x, i)*solution[i];
		}
		return hsl;
	}

	public static void TulisInter (String filename, double solution [], double x, double y)  {
		//menulis MATRIKS ke file eksternal
        try {
            FileWriter writer = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
 			
            bufferedWriter.write("p" + (solution.length-1) + "(x) = ");

            for(int i = 0;i<solution.length;i++)
			{
				if (solution[i]<0){
					bufferedWriter.write(" - " + (-1*solution[i]));
				}else{
					if (i!=0){
						bufferedWriter.write(" + ");
					}
					bufferedWriter.write("" + solution[i]);
				}

				if (i!=0){
					bufferedWriter.write("x");
				}
				if (i>1){
					bufferedWriter.write("^" + i);
				}
				
			}

	        bufferedWriter.newLine();

	        bufferedWriter.write("p" + (solution.length-1) +"(" + x + ")= " + y );
	        bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
}
