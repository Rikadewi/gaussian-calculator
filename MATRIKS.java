import java.io.*;
import java.util.*;

public class MATRIKS {
	//Atribut
	double[][] Tab = new double[100][100];
	int NBrsEff;
	int NKolEff;

	//Method

	//KONSTRUKTOR
 
	public MATRIKS(){
		//menghasilkan matriks kosong

		this.NBrsEff = 0;
		this.NKolEff = 0;
	}
 
	public void BacaInputUser (int row, int col){
		//membaca matriks dari input user

		Scanner in = new Scanner (System.in);

		this.NBrsEff = row;
		this.NKolEff = col;

		for (int i = 0; i<this.NBrsEff ; i++){
			for (int j = 0; j<this.NKolEff; j++){
				this.Tab[i][j] = in.nextDouble();
			}	
		} 
	}

	public void BacaFileEksternal (String filename) {
		//membaca matriks dari file eksternal

		try {
			File file = new File (filename);
			Scanner sc = new Scanner(file); 

			if (sc.hasNextLine()){
				String s = sc.nextLine();
				s = s.trim();
				int c=0;

				for (int i=0; i<s.length();i++){
					if (s.charAt(i)==' '){
						c++; //menghitung jumlah kolom matriks
					}
				}
				c++; //ditambahkan dengan elemen terakhir kolom

				sc = new Scanner(file); 
				

				int row = 0; //inisialisasi baris awal
				int col = 0; //inisialisasi kolom awal

				while (sc.hasNextDouble()){
				    this.Tab[row][col] = sc.nextDouble();
				    col++;
				    if (col == c){
				    	col = 0;
				    	row++;
				    }
				} 

				this.NKolEff = c;
				this.NBrsEff = row;

			}else{
				System.out.println("File Kosong");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void CetakMATRIKS (){
		//mencetak matriks
		
		for (int i = 0; i<this.NBrsEff; i++){
			for (int j = 0; j<this.NKolEff ; j++){
				System.out.print (this.Tab[i][j] + " ");
			}
			System.out.println();	
		} 
	}

	public void TulisFileEksternal (String filename)  {
		//menulis MATRIKS ke file eksternal
        try {
            FileWriter writer = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
 			
	        for (int i = 0; i<this.NBrsEff; i++){
				for (int j = 0; j<this.NKolEff; j++){
					bufferedWriter.write(this.Tab[i][j] + " ");
				}
				bufferedWriter.newLine();	
			} 
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
	
	/*public void TulisSPL (String filename, double solution [])  {
		//menulis MATRIKS ke file eksternal
        try {
            FileWriter writer = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
 			
 			for(int i = 1;i<=solution.length;i++)
			{
				bufferedWriter.write("x"+ i +" = "+solution[i-1]);
				bufferedWriter.newLine();
			}	
	        
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }*/
	
	public void TulisNoSolution(String filename){
		// menulis no solution ke file eksternal
		try{
			FileWriter writer = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write("No Solution");
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
		}
	}

	public void TulisHasil (String filename, String solution [])  {
		//menulis MATRIKS ke file eksternal
        try {
            FileWriter writer = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
 			
 			for(int i = 0;i<solution.length;i++)
			{
				bufferedWriter.write("x"+ (i+1) +" = "+ solution[i]);
				bufferedWriter.newLine();
			}	
	        
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
	
	
}
