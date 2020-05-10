package AnalizadorDOsCero;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import javax.swing.JTextArea;


public class Lexer2 {
	JTextArea text;
    private Tokens token;
    private String lexema;
    private boolean detener = false;
    private String mensajeError = "";
    private Set<Character> espaciosBlanco = new HashSet<Character>();
    int nlinea = 0;
    int i=0, i2=0;
    ListaSencilla vectorin;
    ListaSencilla vectorclean;
    Buscador b;
    String []vec, veclean;
    boolean ban;
 
    /*public  void LexerL(String filePath) {
    	b=new Buscador();
    	b.leer(filePath);
    	vectorin=b.obtenerArchivo();
    	vectorclean = new ListaSencilla();
        /*try (Stream<String> st = Files.lines(Paths.get(filePath))) {
            st.forEach(entrada::append);
        } catch (IOException ex) {
        	detener = true;
        	mensajeError = "Error en lectura de archivo: " + filePath;
            return;
        }
        espaciosBlanco.add('\r');
        espaciosBlanco.add('\n');
        espaciosBlanco.add((char) 8);
        espaciosBlanco.add((char) 9);
        espaciosBlanco.add((char) 11);
        espaciosBlanco.add((char) 12);
        espaciosBlanco.add((char) 32);
        nlinea=0;
        ban=false;
        vec=vectorin.getValor(nlinea).split(" ");//al principio sera 0
        for (int i = 0; i < vec.length; i++) {
			System.out.print("contenido vec"+i +""+vec[i]+",");
			vectorclean.addValue(vec[i]);
		}llenado();
        siguiente();
    }
    public void llenado() {
    	for (int i = 0; i < vec.length; i++) {
    		if (vec[i].isEmpty()) {//para el espacio en blanco
    			int j= vectorclean.BuscarElemento(vec[i].toString());
    			vectorclean.EliminarEspec(j);
    			System.out.println("position:"+j);
    			System.out.println("se obvio algo");
    		}
		}
    	vec=null;
    	vec= new String [vectorclean.listLenght()];
    	for (int i = 0; i < vectorclean.listLenght(); i++) {
			vec[i]=vectorclean.getValor(i);
		}
    }
   
    public boolean chechar() {
    	if(i>=vec.length) {//cambio de linea
    		cambialinea();
    		if (ban == true) {//si dice que ya no hay en la lista
    			return false;
    		}
    	}
    			for (Tokens t : Tokens.values()) {
                    int end = t.endOfMatch(vec[i].toString());
                    if (end != -1) {
                        token = t;
                        lexema = vec[i];
                        System.out.println("lexema: "+lexema);
                        i++;
                        if(token.name().equalsIgnoreCase("error"))
                        	return false;
                        return true;
                    }
                }return false;	
    }
    public void cambialinea() {
    	vectorin.borrar_primero();
    	if(!vectorin.isEmpty()) {
    		vec=null;
    		nlinea++;//salto de linea
    		i=0;//recorre desde el principio
    		i2=0;
        	vec=vectorin.getValor(0).split(" ");
        	vectorclean.clear();
        	for (int i = 0; i < vec.length; i++) {
    			System.out.print("contenido vec"+i +""+vec[i]+",");
    			vectorclean.addValue(vec[i]);
    		}
        	llenado();
        	System.out.println("tamaño de la lista"+vectorin.listLenght());//aqui ya esta el contenido
    	}else {
    		System.out.println("ya no hay joven");
    		ban=true;
    	}
    }

    public void siguiente() {
        if (detener) {
            return;
        }
        if (vectorin.listLenght() == 0) {
        	detener = true;
            return;
        }
        /*ignoraEspacios();
        if (chechar()) {
        	System.out.println("linea "+nlinea);
            return;
        }
        detener = true;
        if (ban!=true) {//aqui tambien debio de haber ido otra condicion pero no se cual
        	/*if(vec[i].equals("")|| vec[i].isEmpty()) {
        		detener=false;
        		siguiente();
        	}else {
        		mensajeError += "Error Léxico: '" + vec[i-1] + "' en la línea "+((nlinea+1)+b.lineasfalsas)+"\n";//nlinea mas 1 por que inicia en 0
            	detener = true;
            	return;
        //}
        }
    }

    /*private void ignoraEspacios() {
        int charsAeliminar = 0;
        while (espaciosBlanco.contains())) {
        	charsAeliminar++;
        }
        if (charsAeliminar > 0) {
        	entrada.delete(0, charsAeliminar);
        }
    }*/

 
    public Tokens currentToken() {
        return token;
    }
    
    private String lex;
    
    public String LexemaToken(String token) {
    	Tokens t1=Tokens.valueOf(token);
    	return token;
    }

    public String currentLexema() {
        return lexema;
    }

    public boolean isSuccessful() {
        return mensajeError.isEmpty();
    }

    public String mensajeError() {
        return mensajeError;
    }

    public boolean isExausthed() {
        return detener;
    }
}
/*for (int i = 0; i < vec.length; i++) { //asgina el vector
        		if (vec[i].equals("")|| vec[i].isEmpty() || vec[i].contains("\\r") ||vec[i].contains("\\n")){
        			System.out.println("me lo ignore :,v");
        		}else {
        			veclean[i2]=vec[i];
        			System.out.print("contenido vec"+i2 +""+veclean[i2]+",");
        			i2++;
        		}
    		}if(veclean==null) {
    			if(vectorin.listLenght()!=0) {
    				
    			}else {
    				cambialinea();
    			}
    			
    		}
    		
    	if(veclean==null) {
    			if(vectorin.listLenght()!=0) {
    				
    			}else {
    				cambialinea();
    			}
    			
    		}	*/
