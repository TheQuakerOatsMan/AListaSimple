package AnalizadorDOsCero;
import java.io.*;


public class Buscador {

	FileInputStream entrada;
	FileOutputStream salida;
	File archivo;
	
	public Buscador() {
		try {
			salida = new FileOutputStream(archivo);
		}catch(Exception e) {}
	}
	
	//Esta madre guarda
	public String AbrirTexto(File archivo) {
		String contenido = "";
		try {
			entrada = new FileInputStream(archivo);
			int ascci;
			while((ascci = entrada.read()) != -1) {
				char caracter = (char) ascci;
				contenido += caracter;
			}
		}catch(Exception e) {	
			e.printStackTrace();
		}	
		return contenido;
	}
	
	public String guardar(File arc,String doc){
		String mgs=null;
		try {
			salida=new FileOutputStream(arc);
			byte[] byt=doc.getBytes();
			salida.write(byt);
			mgs="Archivo guardado";
			
		}catch(Exception e) {}
		return mgs;
	}
}
/*public class Buscador {

	FileInputStream entrada;
	FileOutputStream salida;
	File archivo;
	Vector <Object>vector=new Vector();
	String []v2;
	int lineasfalsas;
    private Set<Character> espaciosBlanco = new HashSet<Character>();
    public ArrayList<Character> myDict = new ArrayList<Character>();

	public Buscador() {
		try {
			salida = new FileOutputStream(archivo);
		}catch(Exception e) {}
	}
	ListaSencilla arch = new ListaSencilla();
    public void leer(String ar) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
        	archivo = new File(ar);
            
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
            		if(linea.equals(""))
            			lineasfalsas++;
            		else
            			arch.addValue(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    public ListaSencilla obtenerArchivo(){
        return arch;
    }
	//Esta madre guarda
	int n=0;
	public String AbrirTexto(File archivo) {
		String contenido = "", contenido2="";
		try {
			entrada = new FileInputStream(archivo);
			int ascci;
			while((ascci = entrada.read()) != -1) {
				char caracter = (char) ascci;
				//puse esta tabla
				myDict.add(caracter);
				if (espaciosBlanco.contains(caracter)) {
					n++;
				}
				contenido += caracter;
			}
			
		}catch(Exception e) {	
			e.printStackTrace();
		}	
		return contenido;
	}
	public int returnn () {
		return n;
	}
	public void m () {
		System.out.println(myDict);
	}
	public String guardar(File arc,String doc){
		String mgs=null;
		try {
			salida=new FileOutputStream(arc);
			byte[] byt=doc.getBytes();
			salida.write(byt);
			mgs="Archivo guardado";
			
		}catch(Exception e) {}
		return mgs;
	}
}*/