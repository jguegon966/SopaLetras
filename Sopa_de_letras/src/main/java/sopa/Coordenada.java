package sopa;

import excepciones.TableroException;

public final class Coordenada {

	private final int fila;
	private final int columna;
	private final Sentido sentido;
	
	public Coordenada(int fila, int columna, Sentido sentido) throws TableroException {
		
		this.fila = fila;
		this.columna = columna;
		this.sentido = sentido;
		
		if(fila < 0) {
			
			throw new TableroException("El numero de la fila es menor que 0");
			
		}else if(columna < 0) {
			
			throw new TableroException("el numero de la columna  es menor que 0");
			
		}else if (sentido == null) {
			
			throw new TableroException("El sentido es nulo");
			
		}
		
	}

	protected int getFila() {
		return this.fila;
	}

	protected int getColumna() {
		return this.columna;
	}

	protected Sentido getSentido() {
		return this.sentido;
	}
	
	
	
}
