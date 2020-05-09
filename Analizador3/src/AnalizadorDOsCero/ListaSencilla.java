package AnalizadorDOsCero;

public class ListaSencilla {
  Nodo inicio, fin;
  int cantidad;
    
    public ListaSencilla () {
        inicio = fin = null;
    }

    /*void captura() {
        String name;
        do {           
        name = JOptionPane.showInputDialog("Teclee un nombre");        
        Nodo nuevo = new Nodo (name);
        if ( name.equals("") == true) 
            break;
        //Comprobar que la lista este vacia
        if (inicio == null) {
            inicio = fin = nuevo;
        } else {
            //Ampliamos la lista, y posicionamos 'nuevo' en el final
            fin.der = nuevo;
            fin = fin.der;
        }
        } while (name.compareTo("")!= 0);
        
    }*/
    public boolean isEmpty() {
		if(inicio == null && fin ==null) return true;
		return false;
	}
    
    void addValue(String valor){
        Nodo nuevo = new Nodo (valor); //Se crea un tipo nodo
        if (inicio == null) { //Si está vacia crea uno nuevo
            inicio = fin = nuevo;
        }else{
          fin.der= nuevo; //se amplia
          fin=fin.der;  
        } 
    }

    void imprime() {
        //Recorremos la lista e impriminos todos su contenido
        //Cont recorre la lista elemento x elemento
        Nodo cont = inicio ;
        while (cont != null) {
            System.out.println(cont.nombre);
            //Se recorre la lista una posicion 
            cont = cont.der;
        }
        
    }
    String imprimeR() {
        //Recorremos la lista e impriminos todos su contenido
        //Cont recorre la lista elemento x elemento
        Nodo cont = inicio ;
        String conte="";
        while (cont != null) {
        	conte=cont.nombre;
        	conte+="\n";
            //Se recorre la lista una posicion 
            cont = cont.der;
        }
        return conte;
    }
    
    //Contar los elementos de la lista
    public int listLenght() {
       int elem = 0;
       Nodo cont = inicio ;
        while (cont != null) {
            elem ++;
            //Se recorre la lista una posicion 
            cont = cont.der;
        }
       
       return elem; 
    }

    void borrar_primero() {
        /* Asignar inicio a una variable
            mover el inicio
        desconectar la variable de la lista        
        */
    	if(!isEmpty()) {
			if(inicio==fin) { //Hay un solo elemento
				inicio=fin=null;
			}else {
				inicio=inicio.der;
			}
		}
       /* Nodo v = inicio;
        inicio = inicio.der;
        v.der = null;*/
    }



    void borrar_ultimo () {
        if (inicio == fin) {
            inicio = fin = null;
        } else {
        Nodo v = inicio;
       //
        /*for (int i = 0; i < elem-2; i++) {
            v = v.der; 
        } */ 
        while (v.der != fin) {
            v = v.der;
        }
        v.der = null;
        fin = v;
        }
    }

    
    public String getValor(int i) {
        String valor="";
        int c=0;
        //Recorremos la lista e impriminos todos su contenido
        //Cont recorre la lista elemento x elemento
        Nodo cont = inicio ;
        while (cont != null) {
            if(c==i){
                valor=cont.nombre; //Saca el valor
            }
            //Se recorre la lista una posicion
            c++;
            cont = cont.der;
        }
        return valor;
    }
    
    public class Nodo {
        String nombre;
        Nodo der;
        
        public Nodo (){
            nombre = "Sin nombre";
            der = null;
        }
        public Nodo (String nombre){
            this.nombre = nombre;
            der = null;
        }
    }
    
    
 
    
}

