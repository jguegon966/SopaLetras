package sopa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import excepciones.TableroException;

public class SopaLetras {
	Scanner sc = new Scanner(System.in);
	
	public List<List<Character>> lista = new ArrayList<List<Character>>();
	public int num = 0;
	
	public SopaLetras() {
		
	}
	
	public int numeroMatrix() {
		
		System.out.println("Introduzca el numero de la matrix: ");
		String str = sc.next();
		int n = 0;
		
	    	try{
	        	n=Integer.parseInt(str);
	        	if(n <= 0 ) {
	        		System.err.println("El numero introducido es menor o igual a cero");
	        	}
	    	}catch(NumberFormatException ex){
	        	System.err.println("No es un número entero");
	    	}
	    	
	    	num = n;
		
	    	return n;
	    	
	}
	
	//metodo que sirve para rellenar la matriz de asteriscos y posteriormente rellenarla con letras en otro metodo 
	public List rellenarMatrix(List lista, int n) {
		
		
		for(int i=0; i< n; i++) {
			
			List<Character> asteriscos = new ArrayList<Character>();
			this.lista.add(asteriscos);
			
			for(int j=0; j<n; j++) {
				
				this.lista.get(i).add('*');
				
			}
		}
		
		return lista;
		
	}
	
	public void mostrarMatrix(List lista, int n) {
		
		System.out.print(lista);
		
	}
	
	//Comprobaciones previas que hará antes de introducir la palabra en la matrzi si da error saltará una excepcion
	public void colocarPalabraHorizontal(String palabra, Coordenada coordenada)throws TableroException{
		
		System.out.println("Introduzca la palabra");
		
		palabra = sc.nextLine();
		int fila = 0;
		int columna = 0;
		
		System.out.println("introduzca la fila: ");
		fila = sc.nextInt();
		System.out.println("introduzca la columna: ");
		columna = sc.nextInt();
		
		Coordenada coor = new Coordenada(fila, columna, Sentido.Normal);
		
		if (palabra == null || palabra.isEmpty()) {
			
			throw new TableroException("Palabra nula o vacia");
			
		}else if(palabra.length() > this.num) {
			
			throw new TableroException("El tamano de la palabra es superior a la dimension");
			
		}else if(coordenada.getFila() > num) {
			
			throw new TableroException("El numero de la fila es mas grande que la dimsension");
			
		}else if(coordenada.getColumna() > num) {
			
			throw new TableroException("El numero de la fila es mas grande que la dimsension");
			
		}else if (coordenada.getSentido()== Sentido.Normal) {
			
			if((this.num -(coordenada.getColumna() + palabra.length()) <0)){
			
				throw new TableroException("El tamaño de la palabra supera el limite");
				
			}
			
			this.colocarPalabraHorizontalNormal(palabra, coordenada);
			
		}
		
	}
	
	
	//funcionalidad que llama elñ metodo al lanzarse y convierte la palabra a caracteres y los va introduciendo poco a poco en la matriz	
	private void colocarPalabraHorizontalNormal(String palabra, Coordenada coordenada) {
		
		
		
			for(int i=0; i< palabra.length(); i++) {
			
			char ch = palabra.charAt(i);
				
			ArrayList<Character> letras = new ArrayList<Character>();
			this.lista.get(i).add(ch);
			
		}
			
		
		
	}
	
	//genera letra random para posteriormente ir introduciendola en la matriz sustituyendo los caracteres aleatorios por las posiciones donde hay asteriscos
	//(estamos trabajando en ello)
	public void generarRandom() {
		
		int num_random = (int) (Math.random()*27+1);
		
		String abecedario = "abcdefghijklmnopqrstuvwxyz";
		
		char randomChar = abecedario.charAt(num_random);
		
		System.out.println(randomChar);
		
		
	}

	//metodo lanzador que va a ser llamado por el metodo main para ejecutar la matriz e ir llamando metodos de la propia clase sopa de letras
	public void lanzador() throws TableroException {
		
		rellenarMatrix(lista, numeroMatrix());
		//mostrarMatrix(lista, num);
		
		Coordenada coor = new Coordenada(2, 0, Sentido.Normal);
		
		String palabra = sc.nextLine();
		
		colocarPalabraHorizontal(palabra, coor);
		
		mostrarMatrix(lista, num);
	}

	
}
