import java.util.*;

public class MainProgram
{
	public static void main(String[] args) 
	{
	/*Atribut*/
	boolean exit, backutama;
	int menu,metode,simpan;
	int n,m; // n = banyak peubah (banyak kolom), m= banyak persamaan (baris)
	String filename; // variable untuk menulis namafile dalam string.
	int nderajat; // derajat polinom
	//double x,y;

	/*ALgoritma*/
	exit = false;
	while(!exit)
		{	
			backutama = false;
			while(!backutama)
			{
				System.out.println("===================================================");
				System.out.println("Tugas Besar Aljabar Geometri SPL dan Aplikasinya");	
				System.out.println("Credit : Kelompok 'Ga Luka'");	
				System.out.println("	Lukas Kurnia Jonathan / 13517006 (K-03)");	
				System.out.println("	Gardahadi / 13517144 (K-03)");	
				System.out.println("	Rika Dewi / 13517147 (K-03)");	
				System.out.println("===================================================");
				System.out.println();

			
				System.out.println("Silakan pilih menu yang diinginkan: ");
				System.out.println("1. Sistem Persamaan Linear ");
				System.out.println("2. Interpolasi Polinom ");
				System.out.println("3. Keluar program");
				System.out.println();
				

				
					do
					{
						Scanner in = new Scanner(System.in); 
						System.out.print("Pilih menu: ");
						menu = in.nextInt(); //Memasukkan input integer 1 sampai 3 berupa menu
						if((menu != 1) && (menu != 2) && (menu != 3))
						{
							System.out.println("Menu salah, silakan coba lagi !");
						}
					}
					while((menu != 1) && (menu != 2) && (menu != 3));

				if(menu == 3) //command untuk keluar dari program
				{
					backutama=true;
					exit = true;

				}

				else if(menu == 1)//user memilih menu Sistem Persamaan Linear
				{
					System.out.println("Anda telah memilih menu Sistem Persamaan Linear, silakan pilih metode yang diinginkan: ");
					System.out.println("1. Metode eliminasi Gauss ");
					System.out.println("2. Metode eliminasi Gauss Jordan ");
					System.out.println("3. Back ke menu utama");
					System.out.println();


					do
					{
						Scanner in = new Scanner(System.in); 
						System.out.print("Pilih metode: ");
						metode = in.nextInt(); //Memasukkan input integer 1 sampai 3 berupa menu
						if((metode != 1) && (metode != 2) && (metode != 3))
						{
							System.out.println("Metode salah, silakan coba lagi !");
						}
					}
					while((metode != 1) && (metode != 2) && (metode != 3));

					if(metode == 3) //command untuk back ke program utama
					{
						backutama=true;
					}
					else if(metode== 1)//input dimasukkan dari keyboard
					{
						System.out.println("Anda telah memilih Eliminasi Gauss, silakan pilih metode yang diinginkan: ");
						System.out.println("1. Masukkan input dari keyboard ");
						System.out.println("2. Masukkan input dari file eksternal ");
						System.out.println("3. Back ke menu utama");
						System.out.println();


						do
						{
							
							Scanner in = new Scanner(System.in); 
							System.out.print("Pilih metode: ");
							metode = in.nextInt(); //Memasukkan input integer 1 sampai 3 berupa menu
							if((metode != 1) && (metode != 2) && (metode != 3))
							{
								System.out.println("Metode salah, silakan coba lagi !");
							}
						}
						while((metode != 1) && (metode != 2) && (metode != 3));

						if(metode == 3) //command untuk back ke program utama
						{
							backutama=true;
						}
							
						else if(metode== 1) //memilih masukkan input dari keyboard
						{
							MATRIKS M = new MATRIKS();
							Scanner in = new Scanner(System.in);
							System.out.print("Masukkan banyak persamaan / baris matriks: ");
							m = in.nextInt();
							System.out.print("Masukkan banyak peubah / kolom matriks: ");
							n = in.nextInt();
							M.BacaInputUser(m,n);

							Gaussian  G = new Gaussian();
							G.REF(M); // melakukan fungsi gauss
							System.out.println("Matriks setelah dilakukan Gauss:");
							M.CetakMATRIKS();
							//G.backSub(M); // melakukan back substitution							
							//G.printSol(G.solution); //print solusi ke layar
							G.printSol(M);

							System.out.println("Ketik '1' untuk menyimpan hasil dalam file eksternal, '0' jika tidak");
							
							do
							{
								
								Scanner filein = new Scanner(System.in); 
								System.out.print("Simpan? ");
								simpan = filein.nextInt(); //Memasukkan input integer 1 sampai 3 berupa menu
								if((simpan != 1) && (simpan != 0))
								{
									System.out.println("Simpan salah, silakan coba lagi !");
								}
							}
							while((simpan != 1) && (simpan != 0));

							if(simpan==1)
							{
								Scanner filein = new Scanner (System.in);
								System.out.print("Masukkan nama file penyimpanan (.txt): ");
								filename = filein.nextLine(); 
								M.TulisSPL(filename,Gaussian.solution);

								backutama = true;
							}
							else //simpan == 0
							{
								backutama=true;
							}
						
						}
						
						else if(metode== 2) //memilih masukkan  dari file eksternal
						{
							MATRIKS M = new MATRIKS();
							Scanner in = new Scanner(System.in);
							System.out.print("Masukkan nama file eksternal (.txt): ");
							filename = in.nextLine();
							M.BacaFileEksternal(filename);
							System.out.println("Matriks Anda sekarang: ");
							M.CetakMATRIKS();
							System.out.println();


							Gaussian  G = new Gaussian();
							G.REF(M); // melakukan fungsi gauss
							System.out.println("Matriks setelah dilakukan Gauss:");
							M.CetakMATRIKS();
							//G.backSub(M); // melakukan back substitution							
							//G.printSol(G.solution); //print solusi ke layar
							G.printSol(M);
							System.out.println();

							System.out.println("Ketik '1' untuk menyimpan hasil dalam file eksternal, '0' jika tidak");
							
							do
							{
								
								Scanner filein = new Scanner(System.in); 
								System.out.print("Simpan? ");
								simpan = filein.nextInt(); //Memasukkan input integer 1 sampai 3 berupa menu
								if((simpan != 1) && (simpan != 0))
								{
									System.out.println("Simpan salah, silakan coba lagi !");
								}
							}
							while((simpan != 1) && (simpan != 0));

							if(simpan==1)
							{
								Scanner filein = new Scanner (System.in);
								System.out.print("Masukkan nama file penyimpanan (.txt): ");
								filename = filein.nextLine(); 
								M.TulisSPL(filename,Gaussian.solution);
								backutama = true;
							}
							else //simpan == 0
							{
								backutama=true;
							}
							
						}
						
					}
					
					else if(metode== 2) // Memilih Eliminasi Gauss Jordan
					{
						System.out.println("Anda telah memilih Eliminasi Gauss Jordan, silakan pilih metode yang diinginkan: ");
						System.out.println("1. Masukkan input dari keyboard ");
						System.out.println("2. Masukkan input dari file eksternal ");
						System.out.println("3. Back ke menu utama");
						System.out.println();


						do
						{
							//Scanner in = new Scanner(System.in); 
							Scanner in = new Scanner(System.in); 
							System.out.print("Pilih metode: ");
							metode = in.nextInt(); //Memasukkan input integer 1 sampai 3 berupa menu
							if((metode != 1) && (metode != 2) && (metode != 3))
							{
								System.out.println("Metode salah, silakan coba lagi !");
							}
						}
						while((metode != 1) && (metode != 2) && (metode != 3));

						if(metode == 3) //command untuk back ke program utama
						{
							backutama=true;
						}
							
						else if(metode== 1)
						{
							MATRIKS M = new MATRIKS();
							Scanner in = new Scanner(System.in);
							System.out.print("Masukkan banyak persamaan / baris matriks: ");
							m = in.nextInt();
							System.out.print("Masukkan banyak peubah / kolom matriks: ");
							n = in.nextInt();
							M.BacaInputUser(m,n);

							Gaussian  G = new Gaussian();
							G.REF(M); // melakukan gauss terlebih dahulu
							G.RREF(M); // melakukan fungsi gauss jordan
							System.out.println("Matriks setelah dilakukan REF:");
							M.CetakMATRIKS();							
							//G.printSol(G.JordanSolution); //print solusi ke layar
							G.printSol(M);

							System.out.println("Ketik '1' untuk menyimpan hasil dalam file eksternal, '0' jika tidak");
							
							do
							{
								
								Scanner filein2 = new Scanner(System.in); 
								System.out.print("Simpan? ");
								simpan = filein2.nextInt(); //Memasukkan input integer 1 sampai 3 berupa menu
								if((simpan != 1) && (simpan != 0))
								{
									System.out.println("Simpan salah, silakan coba lagi !");
								}
							}
							while((simpan != 1) && (simpan != 0));

							if(simpan==1)
							{
								Scanner filein2 = new Scanner (System.in);
								System.out.print("Masukkan nama file penyimpanan (.txt): ");
								filename = filein2.nextLine(); 
								M.TulisSPL(filename,Gaussian.solution);
								backutama = true; // kembali ke menu utama
							}
							else //simpan == 0
							{
								backutama=true;  //kembali ke menu utama
							}
						
						}
						
						else if(metode== 2) //memilih masukkan  dari file eksternal
						{
							MATRIKS M = new MATRIKS();
							Scanner in = new Scanner(System.in);
							System.out.print("Masukkan nama file eksternal (.txt): ");
							filename = in.nextLine();
							M.BacaFileEksternal(filename);
							System.out.println("Matriks Anda sekarang: ");
							M.CetakMATRIKS();
							System.out.println();


							Gaussian  G = new Gaussian();
							G.REF(M); // melakukan Gauss terlebih dahulu
							G.RREF(M); // melakukan fungsi gauss
							System.out.println("Matriks setelah dilakukan Gauss Jordan:");
							M.CetakMATRIKS();
							//G.printSol(G.JordanSolution); //print solusi ke layar
							G.printSol(M);
							System.out.println();

							System.out.println("Ketik '1' untuk menyimpan hasil dalam file eksternal, '0' jika tidak");
							
							do
							{
								
								Scanner filein2 = new Scanner(System.in); 
								System.out.print("Simpan? ");
								simpan = filein2.nextInt(); //Memasukkan input integer 1 sampai 3 berupa menu
								if((simpan != 1) && (simpan != 0))
								{
									System.out.println("Simpan salah, silakan coba lagi !");
								}
							}
							while((simpan != 1) && (simpan != 0));

							if(simpan==1)
							{
								Scanner filein = new Scanner (System.in);
								System.out.print("Masukkan nama file penyimpanan (.txt): ");
								filename = filein.nextLine(); 
								M.TulisSPL(filename,Gaussian.solution);
								backutama = true;
							}
							else //simpan == 0
							{
								backutama=true;
							}
							
						}
					}
					
				}

				else if(menu == 2)//user memilih menu Interpolasi Polinom, menggunakan REF atau REF Jordan
				{
					System.out.println("Anda telah memilih menu Interpolasi Polinom, silakan pilih metode yang diinginkan: ");
					System.out.println("1. Masukkan input dari keyboard ");
					System.out.println("2. Masukkan input dari file eksternal ");
					System.out.println("3. Back ke menu utama");
					System.out.println();


					do
					{
						
						Scanner in = new Scanner(System.in); 
						System.out.print("Pilih metode: ");
						metode = in.nextInt(); //Memasukkan input integer 1 sampai 3 berupa menu
						if((metode != 1) && (metode != 2) && (metode != 3))
						{
							System.out.println("Metode salah, silakan coba lagi !");
						}
					}
					while((metode != 1) && (metode != 2) && (metode != 3));

					if(metode == 3) //command untuk back ke program utama
					{
						backutama=true;
					}
					else if(metode== 1) //Memasukkan input dari keyboard
					{
						MATRIKS M = new MATRIKS();
						interpolasi I = new interpolasi();
						Gaussian G = new Gaussian();

						Scanner in = new Scanner (System.in);
						System.out.print("Masukkan derajat polinom interpolasi (n): ");
						nderajat = in.nextInt();

						M.BacaInputUser(nderajat+1,2);
						I.MatriksInterpolasi (M);
						System.out.println("Hasil interpolasi: ");
						I.printPol(G.solution);

						//System.out.print("Masukkan harga x (Ketik -999 untuk mengakhiri) : ");
						double [] x = new double [100];
						double [] y = new double [100];
						int i=0;
						Scanner doublein = new Scanner(System.in);
						System.out.print("Masukkan harga x (Ketik -999 untuk mengakhiri) : ");
						x[i]  = doublein.nextDouble();
						while (x[i]!=-999) {
							
							//y[i] = I.solusiInterpolasi ( x[i], G.solution);
							System.out.println("Taksiran nilai fungsi: ");
							System.out.printf("p%d(%.3f) = %.3f\n\n",nderajat, x[i], y[i]);
							System.out.print("Masukkan harga x (Ketik -999 untuk mengakhiri) : ");
							i++;
							x[i]  = doublein.nextDouble();

						} 

						/*x= in.nextDouble();
						y= I.solusiInterpolasi(x, G.solution);
						System.out.println("Taksiran nilai fungsi: ");
						System.out.printf("p(%.3f) = %.3f\n\n", x, y);
*/
						System.out.println("Ketik '1' untuk menyimpan hasil dalam file eksternal, '0' jika tidak");
							
							do
							{
								
								Scanner filein2 = new Scanner(System.in); 
								System.out.print("Simpan? ");
								simpan = filein2.nextInt(); //Memasukkan input integer 1 sampai 3 berupa menu
								if((simpan != 1) && (simpan != 0))
								{
									System.out.println("Simpan salah, silakan coba lagi !");
								}
							}
							while((simpan != 1) && (simpan != 0));

							if(simpan==1)
							{
								Scanner filein = new Scanner (System.in);
								System.out.print("Masukkan nama file penyimpanan (.txt): ");
								filename = filein.nextLine(); 

								I.TulisPol (filename, G.solution);
								for (int j = 0; j< i; j++){
									I.TulisPx (filename, G.solution.length-1, x[j], y[j]);
								}


								// filename = filein.nextLine(); 
								// I.TulisInter(filename,Gaussian.solution,x,y);
								backutama = true;
							}
							else //simpan == 0
							{
								backutama=true;
							}



					}
					
					else if(metode== 2) //Memasukkan input dari file eksternal
					{
						MATRIKS M = new MATRIKS();
						interpolasi I = new interpolasi();
						Gaussian G = new Gaussian();

						Scanner in = new Scanner(System.in);
						System.out.print("Masukkan nama file eksternal (.txt): ");
						filename = in.nextLine();
						M.BacaFileEksternal(filename);
						System.out.println("Matriks interpolasi Anda sekarang: ");
						M.CetakMATRIKS();
						System.out.println();

						I.MatriksInterpolasi (M);
						System.out.println("Hasil interpolasi: ");
						I.printPol(G.solution);

						double [] x = new double [100];
						double [] y = new double [100];
						int i=0;
						System.out.print("Masukkan harga x (Ketik -999 untuk mengakhiri) : ");
						Scanner doublein = new Scanner(System.in);
						x[i]  = doublein.nextDouble();
						while (x[i]!=-999) {
							
							//y[i] = I.solusiInterpolasi ( x[i], G.solution);
							
							System.out.println("Taksiran nilai fungsi: ");
							System.out.printf("p%d(%.3f) = %.3f\n\n",(G.solution.length-1), x[i], y[i]);
							System.out.print("Masukkan harga x (Ketik -999 untuk mengakhiri) : ");
							i++;
							x[i]  = doublein.nextDouble();
						} 

						/*System.out.print("Masukkan harga x: ");
						x= in.nextDouble();
						y= I.solusiInterpolasi(x, G.solution);
						System.out.println("Taksiran nilai fungsi: ");
						System.out.printf("p(%.3f) = %.3f\n\n", x, y);*/

						System.out.println("Ketik '1' untuk menyimpan hasil dalam file eksternal, '0' jika tidak");
							
							do
							{
								
								Scanner filein2 = new Scanner(System.in); 
								System.out.print("Simpan? ");
								simpan = filein2.nextInt(); //Memasukkan input integer 1 sampai 3 berupa menu
								if((simpan != 1) && (simpan != 0))
								{
									System.out.println("Simpan salah, silakan coba lagi !");
								}
							}
							while((simpan != 1) && (simpan != 0));

							if(simpan==1)
							{
								Scanner filein = new Scanner (System.in);
								System.out.print("Masukkan nama file penyimpanan (.txt): ");
								filename = filein.nextLine(); 


								I.TulisPol (filename, G.solution);
								for (int j = 0; j< i; j++){
									I.TulisPx (filename, G.solution.length-1, x[j], y[j]);
								}

								//I.TulisInter(filename,Gaussian.solution,x,y);
								backutama = true;
							}
							else //simpan == 0
							{
								backutama=true;
							}



					}
				}
			}	
		}

	}

}