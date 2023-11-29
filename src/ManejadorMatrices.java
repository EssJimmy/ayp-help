/*Jaime
 *nov/2021
 *Esta clase contiene varios metodos para el manejo de matrices
 */
public class ManejadorMatrices {
	
	public static double sumaCol(double [][] mat, int col, int n) {
		double suma = 0;
		
		for(int i = 0; i<n; i++)
			suma += mat[i][col];
		return suma;
	}
	/*
	public static double sumaRen(double [][] mat, int m, int ren) {
		double suma = 0;
		
		for(int i = 0; i<m; i++)
			suma += mat[i][ren];
		return suma;
	}
	*/
	
	public static double sumaFila(double [][] mat, int m, int ren) {
		double suma;
		
		suma = ManejadorArreglos.suma(mat[ren], m);
		return suma;
	}
	
	public static double suma(double [][] mat, int m, int n) {
		double suma = 0;
		
		for(int i = 0; i<m; i++)
			for(int j = 0; j<n; j++)
				suma += mat[i][j];
		return suma;
	}
	
	public static double sumaDiagonalP(double [][] mat, int m, int n) {
		double suma = 0;
		
		for(int i = 0; i<m; i++)
			suma += mat[i][i];
		return suma;
	}
	
	public static double sumaDiagonalS(double [][] mat, int m, int n) {
		double suma = 0;
		int j = 0;
		
		for(int i = m-1; i>=0; i--) {
			suma += mat[i][j];
			j++;
		}
		return suma;
	}
	
	public static int mayorCol(double [][] mat, int col, int n) {
		int res = 0;
		
		for(int i = 1; i<n; i++)
			if(mat[res][col]<mat[i][col])
				res = i;
		return res;
	}
	
	public static int menorCol(double [][] mat, int col, int n) {
		int res = 0;
		
		for(int i = 1; i<n; i++)
			if(mat[res][col]>mat[i][col])
				res = i;
		return res;
	}
	
	public static int mayorFila(double [][] mat, int m, int ren) {
		return ManejadorArreglos.posMayor(mat[ren], m);
	}
	
	public static int menorFila(double [][] mat, int m, int ren) {
		return ManejadorArreglos.posMenor(mat[ren], m);
	}
	
	public static int [] posMayor(double [][] mat, int m, int n) {
		int [] res = new int [2];
		int posM = 0, posN = 0;
		
		for(int i = 0; i<m; i++)
			for(int j = 0; j<n; j++)
				if(mat[posM][posN]<mat[i][j]) {
					posM = i;
					posN = j;
				}
		res[0] = posM;
		res[1] = posN;
		return res;
	}
	
	public static int [] posMenor(double [][] mat, int m, int n) {
		int [] res = new int [2];
		int posM = 0, posN = 0;
		
		for(int i = 0; i<m; i++)
			for(int j = 0; j<n; j++)
				if(mat[posM][posN]>mat[i][j]) {
					posM = i;
					posN = j;
				}
		res[0] = posM;
		res[1] = posN;
		return res;
	}
	
	public static double [][] traspuesta(double [][] mat, int m, int n){
		double [][] res = new double[n][m];
		
		for(int i = 0; i<n; i++)
			for(int j = 0; i<m; j++)
				res[j][i] = mat[i][j];
		return res;
	}
	
	public static boolean simetrica(double [][] mat, int m, int n) {
		boolean res = false;
		int i = 1, j = 0;
		
		while(i < m && i<n && mat[i][j] == mat[j][i])
			i++;
		if(i == m || i == n)
			res = true;
		return res;
	}
	
	public static int [] buscaSecDesordenada(double [][] mat, int m, int n, double cont) {
		int [] res = new int [2];
		int i = 0, j = 0;
		
		while(i<m && mat[i][j] != cont) {
			j = ManejadorArreglos.busSecDesordenada(mat[i], n, cont);
			if(j==-1) {
				j = 0;
				i++;
			}
		}
		if(mat[i][j] == cont) {
			res[0] = i;
			res[1] = j;
		}
		else {
			res[0] = -1;
			res[1] = -1;
		}
		return res;
	}
}
