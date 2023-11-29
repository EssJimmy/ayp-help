/*Jaime
 *sept/2021
 *Esta clase tiene varios metodos de manejo de arreglos
 */
import java.util.ArrayList;
public class ManejadorArreglos {
	
	public static double suma(double [] a, int n) {
		double res=0;
		
		for(int i = 0; i<n; i++) {
			res += a[i];
		}
		return res;
	}
	
	public static double promedio(double [] a, int n) {
		double res,suma;
		
		suma = suma(a, n);
		res = suma/n;
		return res;
	}
	
	public static int posMayor(double [] a,int n) {
		int res=0;
		
		for(int i = 1; i<n; i++) {
			if(a[i]>a[res]) {
				res = i;
			}
		}
		return res;
	}
	
	public static int posMenor(double [] a, int n) {
		int res = 0;
		
		for(int i = 1; i<n; i++) {
			if(a[i]<a[res]) {
				res = i;
			}
		}
		return res;
	}
	
	public static int cuantosMayX(double [] a, int n, double b) {
		int res=0;;
		
		for(int i = 0; i<n; i++) {
			if(a[i]>b)
				res++;
		}
		return res;
	}
	
	public static int cuantosMenX(double [] a, int n, double b) {
		int res=0;
		
		for(int i = 0; i<n; i++) {
			if(a[i]<b)
				res++;
		}
		return res;
	}
	
	public static ArrayList <Integer> cualesMayX(double [] a, int n, double b) {
		ArrayList <Integer> res = new ArrayList <Integer>();
		
		for(int i = 0; i<n; i++) {
			if(a[i]>b)
				res.add(i);
		}
		return res;
	}
	
	public static ArrayList <Integer> cualesMenX(double [] a, int n, double b) {
		ArrayList <Integer> res = new ArrayList <Integer>();
		
		for(int i = 0; i<n; i++) {
			if(a[i]<b)
				res.add(i);
		}
		return res;
	}
	
	public static void swap(double [] a, int posX, int posY) {
		double temp;
		
		temp = a[posX];
		a[posX] = a[posY];
		a[posY] = temp;
	}
	
	public static void invierte(double [] a,int n) {
		int j;
		double temp;
		
		for(int i = 0; i<n/2; i++) {
			j = n-i-1;
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}
	
	/*Otra forma de hacer invierte de una forma mas elegante
	public static void invierteDos(double [] a, int n) {
		int j = n-1;
		
		for(int i = 0; i<n/2; i++) {
			swap(a,i,j);
			j--;
		}
	}
	*/
	
	public static void kCorrimientosDer(double [] a, int n, int k) {
		for(int i = 1; i<=k;i++) 
			for (int j = n-1; j >= 0; j--) 
				a[j+1]=a[j];
		a[0] = 0;
	}
	
	public static void kCorrimientosIzq(double [] a, int n, int k) {
		for(int i = 1; i<=k;i++)
			for(int j = 1; j<=n; j++) 
				a[j-1] = a[j];
		a[n] = 0;
	}
	
	public static int posMinInd(double [] a, int n, int inicio) {
		int res = inicio;
		
		for(int i = inicio; i<n; i++)
			if(a[res]>a[i])
				res = i;
		return res;
	}
	
	public static void seleccionDirecta(double [] a,int n) {
		int posMin;
		
		for(int i = 0;i < n; i++) {
			posMin = posMinInd(a, n, i);
			swap(a,posMin,i);
		}
	}
	
	public static int busSecDesordenada(double [] a, int n, double num) {
		int res, i = 0;
		
		while(i<n && a[i]!=num) {
			i++;
		}
		if(i != n)
			res = i;
		else
			res = -1;
		return res;
	}
	
	public static int busSecOrdenada (double [] a, int n, double num) {
		int res, i = 0;
		
		while(a[i]<num) {
			i++;
		}
		if(i == n || a[i] != num)
			res = -i-1;
		else
			res = i;
		return res;
	}
	
	public static int busBinaria(double [] a, int n, double num) {
		int res, inicio=0, aux, fin = n-1;
		
		aux = (inicio+fin)/2;
		while(inicio<fin && a[aux] != num) {
			if(a[aux] < num)
				inicio = aux+1;
			else
				fin = aux-1;
			aux = (inicio+fin)/2;
		}
		if(a[aux] == num)
			res = aux;
		else
			res = -inicio-1;
		return res;
	}
	
	public static void corrimientosIzqInd(double [] a, int n, int posIn) {
		for(int i = posIn; i<n-1;i++)
			a[i] = a[i+1];
	}
	
	public static void corrimientosDerInd(double [] a, int n,int posIn) {
		for(int i = n; i>posIn;i--) 
			a[i]=a[i-1];	
	}
	
	public static int eliminaPos(double [] a, int n, int pos) {
		if(pos>=0 && pos<n) {
			corrimientosIzqInd(a,n,pos);
			n--;
			a[n] = 0;
		}
		return n;
	}
	
	public static int eliminaEnDesordenado(double [] a, int n, double x) {
		int pos;
		
		pos = busSecDesordenada(a,n,x);
		return eliminaPos(a,n,pos);
	}
	
	public static int eliminaOrdenado(double [] a, int n, double x) {
		int pos;
		
		pos = busBinaria(a,n,x);
		return eliminaPos(a,n,pos);
	}
	
	public static int insertaEnOrden(double [] a, int n, double x) {
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
	
	public static int insertaEnPos(double [] a, int n, int pos,double x) {
		if(pos < n && pos > 0) {
			corrimientosDerInd(a,n,pos);
			n++;
			a[pos] = x;
		}
		return n;
	}
	
	public static int insertaAlFinal(double [] a, int n, double x) {
		if(a.length > n) {
			a[n] = x;
			n++;
		}
		return n;
	}
}
