package AnalizadorDOsCero;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Sintak {
	
	ArrayList<String> lex = new ArrayList<String>();          	// Lo que arroja el analisis lexico
	ArrayList<String> elexe = new ArrayList<String>();			// Fila de entrantes
	ArrayList<String> terminales = new ArrayList<String>();		// Columna de terminales
	Stack<String> pila = new Stack<String>();
	String MensajeDeError = "";
	String MensajeDePila = "";
	boolean errP = false; 
	
	String [][] tabla1 = 
		{
				{" " ,"identificador","id_ent","abP"  ,"ciP","op_sum"  ,"op_res","op_mult","op_div","id_cad","id_cart","finale"	},
				{"E" ,"T E�"		 ,"T E�"  ,"T E�" ," "  ," "	   ," "	    ," "	  ," "	   ,"T E�"	,"T E�"	  ," "		},
				{"E�"," "			 ," "	  ," "	  ,"�"  ,"op_sum T E�","op_res T E�","�"	  ,"�"	   ," "	 	," "	  ,"�"		},	
				{"T" ,"F T�"		 ,"F T�"  ,"F T�" ," "  ," "	   ," "	    ," "	  ," "	   ,"F T�"	,"F T�"	  ," "		},
				{"T�"," "			 ," "	  ," "	  ,"�"  ,"�"	   ,"�"		,"op_mult F T�" ,"op_div F T�"," "	 	," "	  ,"�"		},
				{"F" ,"identificador","id_ent","abP E ciP"," "," "     ," "		," "	  ," "	   ,"id_cad","id_cart"," "		}
		};
	
	//Este metodo llena la fila y columna en los arrays creados para ahorrarnos bucles de b�squeda
	public void llenarFyC() {
		for (int i = 0; i < tabla1.length; i++) {
			terminales.add(tabla1[i][0]);
		}
		for (int i = 0; i < tabla1[0].length; i++) {
			elexe.add(tabla1[0][i]);
		}
	}
	
	//Este es el constructor que recibe todo el pedo y inicia lo esensial
	public Sintak() {
		llenarFyC();
		pila.push("finale");
		pila.push("E");
	}
	
	
	//Revisa si es aceptado
	public boolean aceptado() {
		if (pila.isEmpty() && MensajeDeError.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	//Este es el �nico metodo que se llama
	public boolean AS(String lexema) {
		MensajeDePila = "";
		lex.add(lexema);
		procesoApilAndDesapil(lex.size()-1);
		return errP;
	}
	
	//Este nos va a servir para llamarlo y mediante recursivida poder llenar hasta que se desapile y concuerde y retorne a AS
	public void procesoApilAndDesapil (int pivote) {
		if(pila.isEmpty()) {
			MensajeDeError += "Error de Sintaxis: "+lex.get(pivote)+" despu�s de "+ lex.get(pivote-1)+"\n";errP = false;
			pila.push(" ");
		}
		if (terminales.contains(pila.peek()) && elexe.contains(lex.get(pivote))) {
			apila(terminales.indexOf(pila.peek()), elexe.indexOf(lex.get(pivote)),pivote);
		}
	}
	
	//Aqui apila hasta lo indicado en procesoApilAndDesapil()
	public void apila(int i, int j, int pivote) {
		String interseccion = tabla1[i][j];
		if (interseccion == " ") {
			if (pivote > 0) {
				MensajeDeError += "Error de Sintaxis: "+lex.get(pivote)+" despu�s de "+ lex.get(pivote-1)+"\n" ; errP = false;
			}else {
				MensajeDeError += "Error de Sintaxis: "+lex.get(pivote)+" al inicio de la l�nea 1\n" ; errP = false;
			}
		}else {
			String[] interseccionArray = interseccion.split(" ");
			pila.pop();
			for (int k = interseccionArray.length; k > 0; k--) {
				pila.push(interseccionArray[k - 1]);
			}
			if (pila.peek().equalsIgnoreCase("�")) {
				pila.pop();
			}
			if (pila.peek().equalsIgnoreCase(lex.get(pivote))) {
				MensajeDePila += pila+"\n";
				pila.pop();
				MensajeDePila += pila+"\n";errP = true;
			} else {
				MensajeDePila += pila+"\n";
				procesoApilAndDesapil(pivote);
			}
		}
	}
}
/*

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Sintak {
	
	ArrayList<String> lex = new ArrayList<String>();          	// Lo que arroja el analisis lexico
	ArrayList<String> elexe = new ArrayList<String>();			// Fila de entrantes
	ArrayList<String> terminales = new ArrayList<String>();		// Columna de terminales
	Stack<String> pila = new Stack<String>();
	String MensajeDeError = "";
	String MensajeDePila = "";
	String []perror;
	int linea=0;
	String erro="";
	
	String [][] tabla1 = 
		{
				{" " ,"identificador","id_ent","abP"  ,"ciP","op_sum"  ,"op_res","op_mult","op_div","id_cad","id_cart","finale"	},
				{"E" ,"T E�"		 ,"T E�"  ,"T E�" ," "  ," "	   ," "	    ," "	  ," "	   ,"T E�"	,"T E�"	  ," "		},
				{"E�"," "			 ," "	  ," "	  ,"�"  ,"op_sum T E�","op_res T E�","�"	  ,"�"	   ," "	 	," "	  ,"�"		},	
				{"T" ,"F T�"		 ,"F T�"  ,"F T�" ," "  ," "	   ," "	    ," "	  ," "	   ,"F T�"	,"F T�"	  ," "		},
				{"T�"," "			 ," "	  ," "	  ,"�"  ,"�"	   ,"�"		,"op_mult F T�" ,"op_div F T�"," "	 	," "	  ,"�"		},
				{"F" ,"identificador","id_ent","abP E ciP"," "," "     ," "		," "	  ," "	   ,"id_cad","id_cart"," "		}
		};
	
	//Este metodo llena la fila y columna en los arrays creados para ahorrarnos bucles de b�squeda
	public void llenarFyC() {
		for (int i = 0; i < tabla1.length; i++) {
			terminales.add(tabla1[i][0]);
		}
		for (int i = 0; i < tabla1[0].length; i++) {
			elexe.add(tabla1[0][i]);
		}
	}
	
	//Este es el constructor que recibe todo el pedo y inicia lo esensial
	public Sintak() {
		llenarFyC();
		pila.push("finale");
		pila.push("E");
	}
	
	public boolean aceptado() {
		if (pila.isEmpty() && MensajeDeError.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	//Este es el �nico metodo que se llama
	public void AS(String lexema, int nlinea) {
		MensajeDePila = "";
		lex.add(lexema);
		procesoApilAndDesapil(lex.size()-1, nlinea);
	}
	
	//Este nos va a servir para llamarlo y mediante recursivida poder llenar hasta que se desapile y concuerde y retorne a AS
	public void procesoApilAndDesapil (int pivote, int nlinea) {
		if (terminales.contains(pila.peek()) && elexe.contains(lex.get(pivote))) {
			apila(terminales.indexOf(pila.peek()), elexe.indexOf(lex.get(pivote)),pivote, nlinea);
		}
	}
	
	//Aqui apila hasta lo indicado en procesoApilAndDesapil()
	public void apila(int i, int j, int pivote, int nlinea) {
		String interseccion = tabla1[i][j];
		if (interseccion == " ") {
			MensajeDeError += "\nError de Sintaxis: "+lex.get(pivote)+" despu�s de "+ lex.get(pivote-1)+ " en la l�nea "+nlinea;
			linea=nlinea-2;
		}else {
			String[] interseccionArray = interseccion.split(" ");
			pila.pop();
			for (int k = interseccionArray.length; k > 0; k--) {
				pila.push(interseccionArray[k - 1]);
			}
			if (pila.peek().equalsIgnoreCase("�")) {
				pila.pop();
			}
			if (pila.peek().equalsIgnoreCase(lex.get(pivote))) {
				MensajeDePila += pila+"\n";
				pila.pop();
				MensajeDePila += pila+"\n";
			} else {
				MensajeDePila += pila+"\n";
				procesoApilAndDesapil(pivote, nlinea);
			}
		}
	}
	public void setError(String e){
		erro+=e+" ";
	}
	public String getE() {
		perror=erro.split(" ");
		return perror[linea];
	}
}*/