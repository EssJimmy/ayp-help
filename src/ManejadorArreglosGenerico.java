import java.util.ArrayList;
public class ManejadorArreglosGenerico {
	
	public static <T extends Comparable<T>> int posMayor(T [] a,int n) {
		int res=0;
		
		for(int i = 1; i<n; i++) {
			if(a[i].compareTo(a[res])>0) {
				res = i;
			}
		}
		return res;
	}
	
	public static <T extends Comparable<T>> int posMenor(T [] a, int n) {
		int res = 0;
		
		for(int i = 1; i<n; i++) {
			if(a[i].compareTo(a[res])<0) {
				res = i;
			}
		}
		return res;
	}
	
	public static <T extends Comparable<T>> int cuantosMayX(T [] a, int n, T b) {
		int res=0;;
		
		for(int i = 0; i<n; i++) {
			if(a[i].compareTo(b)>0)
				res++;
		}
		return res;
	}
	
	public static <T extends Comparable<T>> int cuantosMenX(T [] a, int n, T b) {
		int res=0;
		
		for(int i = 0; i<n; i++) {
			if(a[i].compareTo(b)<0)
				res++;
		}
		return res;
	}
	
	public static <T extends Comparable<T>> ArrayList <Integer> cualesMayX(T [] a, int n, T b) {
		ArrayList <Integer> res = new ArrayList <Integer>();
		
		for(int i = 0; i<n; i++) {
			if(a[i].compareTo(b)>0)
				res.add(i);
		}
		return res;
	}
	
	public static <T extends Comparable<T>> ArrayList <Integer> cualesMenX(T [] a, int n, T b) {
		ArrayList <Integer> res = new ArrayList <Integer>();
		
		for(int i = 0; i<n; i++) {
			if(a[i].compareTo(b)<0)
				res.add(i);
		}
		return res;
	}
	
	public static <T> void swap(T [] a, int posX, int posY) {
		T temp;
		
		temp = a[posX];
		a[posX] = a[posY];
		a[posY] = temp;
	}
	
	public static <T> void invierte(T [] a,int n) {
		int j;
		T temp;
		
		for(int i = 0; i<n/2; i++) {
			j = n-i-1;
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}
	
	//Otra forma de hacer invierte de una forma mas elegante
	public static <T> void invierteDos(T [] a, int n) {
		int j = n-1;
		
		for(int i = 0; i<n/2; i++) {
			swap(a,i,j);
			j--;
		}
	}
	
	public static <T> void kCorrimientosDer(T [] a, int n, int k) {
		for(int i = 1; i<=k;i++) 
			for (int j = n-1; j >= 0; j--) 
				a[j+1]=a[j];
		a[0] = null;
	}
	
	public static <T> void kCorrimientosIzq(T [] a, int n, int k) {
		for(int i = 1; i<=k;i++)
			for(int j = 1; j<=n; j++) 
				a[j-1] = a[j];
		a[n] = null;
	}
	
	public static <T extends Comparable<T>> int posMinInd(T [] a, int n, int inicio) {
		int res = inicio;
		
		for(int i = inicio; i<n; i++)
			if(a[res].compareTo(a[i])>0)
				res = i;
		return res;
	}
	
	public static <T extends Comparable<T>> void seleccionDirecta(T [] a,int n) {
		int posMin;
		
		for(int i = 0;i < n; i++) {
			posMin = posMinInd(a, n, i);
			swap(a,posMin,i);
		}
	}
	
	public static <T> int busSecDesordenada(T [] a, int n, T objeto) {
		int res, i = 0;
		
		while(i<n && !a[i].equals(objeto)) {
			i++;
		}
		if(i != n)
			res = i;
		else
			res = -1;
		return res;
	}
	
	public static <T extends Comparable<T>> int busSecOrdenada (T [] a, int n, T object) {
		int res, i = 0;
		
		while(a[i].compareTo(object)<0) {
			i++;
		}
		if(i == n || !a[i].equals(object))
			res = -i-1;
		else
			res = i;
		return res;
	}
	
	public static <T extends Comparable<T>>int busBinaria(T [] a, int n, T x) {
		int res, inicio=0, aux, fin = n-1;
		
		aux = (inicio+fin)/2;
		while(inicio<fin && !a[aux].equals(x)) {
			if(a[aux].compareTo(x)<0)
				inicio = aux+1;
			else
				fin = aux-1;
			aux = (inicio+fin)/2;
		}
		if(a[aux].equals(x))
			res = aux;
		else
			res = -inicio-1;
		return res;
	}
	
	public static <T> void corrimientosIzqInd(T [] a, int n, int posIn) {
		for(int i = posIn; i<n-1;i++)
			a[i] = a[i+1];
	}
	
	public static <T> void corrimientosDerInd(T [] a, int n,int posIn) {
		for(int i = n; i>posIn;i--) 
			a[i]=a[i-1];	
	}
	
	public static <T> int eliminaPos(T [] a, int n, int pos) {
		if(pos>=0 && pos<n) {
			corrimientosIzqInd(a,n,pos);
			n--;
			a[n] = null;
		}
		return n;
	}
	
	public static <T extends Comparable<T>> int eliminaEnDesordenado(T [] a, int n, T x) {
		int pos;
		
		pos = busSecDesordenada(a,n,x);
		return eliminaPos(a,n,pos);
	}
	
	public static <T extends Comparable<T>> int eliminaOrdenado(T [] a, int n, T x) {
		int pos;
		
		pos = busBinaria(a,n,x);
		return eliminaPos(a,n,pos);
	}
	
	public static <T extends Comparable<T>> int insertaEnOrden(T [] a, int n, T x) {
		int pos;		
		
		if(a.length > n) {
			pos = busBinaria(a,n,x);
			if(pos<0) {
				pos = -pos-1;
				corrimientosDerInd(a,n,pos);
				n++;
				a[pos] = x;
			}
		}	
		return n;
	}
	
	public static <T> int insertaEnPos(T [] a, int n, int pos, T x) {
		if(pos < n && pos > 0) {
			corrimientosDerInd(a,n,pos);
			n++;
			a[pos] = x;
		}
		return n;
	}
	
	public static <T> int insertaAlFinal(T [] a, int n, T x) {
		if(a.length > n) {
			a[n] = x;
			n++;
		}
		return n;
	}
	
}
