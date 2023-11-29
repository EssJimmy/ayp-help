/*Jaime
 *nov/2021
 *Esta clase contiene varios metodos para el manejo de matrices de todo tipo
 */
public class ManejadorMatricesGenerico {
	
	public static <T extends Comparable<T>> int mayorCol(T [][] mat, int col, int n) {
		int res = 0;
		
		for(int i = 1; i<n; i++)
			if(mat[res][col].compareTo(mat[i][col])<0)
				res = i;
		return res;
	}
	
	public static <T extends Comparable<T>> int menorCol(T [][] mat, int col, int n) {
		int res = 0;
		
		for(int i = 1; i<n; i++)
			if(mat[res][col].compareTo(mat[i][col])>0)
				res = i;
		return res;
	}
	
	public static <T extends Comparable<T>> int mayorFila(T [][] mat, int m, int ren) {
		return ManejadorArreglosGenerico.posMayor(mat[ren], m);
	}
	
	public static <T extends Comparable <T>> int menorFila(T [][] mat, int m, int ren) {
		return ManejadorArreglosGenerico.posMenor(mat[ren], m);
	}
	
	public static <T extends Comparable<T>> int [] posMayor(T [][] mat, int m, int n) {
		int [] res = new int [2];
		res[0] = 0;
		res[1] = 0;
		
		for(int i = 0; i<m; i++)
			for(int j = 0; j<n; j++)
				if(mat[res[0]][res[1]].compareTo(mat[i][j])<0) {
					res[0] = i;
					res[1] = j;
				}
		return res;
	}
	
	public static <T extends Comparable<T>> int [] posMenor(T [][] mat, int m, int n) {
		int [] res = new int [2];
		res[0] = 0;
		res[1] = 0;
		
		for(int i = 0; i<m; i++)
			for(int j = 0; j<n; j++)
				if(mat[res[0]][res[1]].compareTo(mat[i][j])>0) {
					res[0] = i;
					res[1] = j;
				}
		return res;
	}
	
	public static <T> boolean simetrica(T [][] mat, int m, int n) {
		boolean res = true;
		int i = 0, j = 0;
		
		while(i < m && i < n && res) {
			if(mat[i][j].equals(mat[j][i]))
				i++;
			else
				res = false;
		}
		i = m-1;
		j = n-2;
		while(j >= 0 && res)
			if(mat[i][j].equals(mat[j][i]))
				j--;
			else
				res = false;
		return res;
	}
	
	public static <T> int buscaEnRenglon(T [][] mat, int col, int n, double cont) {
		int res = -1, i;
		
		i = ManejadorArreglosGenerico.busSecDesordenada(mat[col],n,cont);
		if(i!=-1)
			res = i;
		return res;
	}
	
	public static <T> int buscaEnCol(T [][] mat, int m, int ren, T cont) {
		int res = -1, i = 0;
		
		while(i<m && !mat[i][ren].equals(cont))
			i++;
		if(i!=m)
			res = i;
		return res;
	}
	
	public static <T> int [] buscaSecDesordenada(T [][] mat, int m, int n, T cont) {
		int [] res = {-1,-1};
		int i = 0, j = 0;
		
		while(i<m && j==-1) {
			j = ManejadorArreglosGenerico.busSecDesordenada(mat[i],n,cont);
			i++;
		}
		if(j!=-1) {
			res[0] = i-1;
			res[1] = j;
		}
		return res;
	}
}
