/**
 * @(#)Torres_de_Hanoi.java
 *
 * Torres_de_Hanoi application
 *
 *	=========================================
 *	TORRES DE HANOI							=
 *	Integrantes: - David Bassante			=
 *				 - Erick León				=
 *				 - Mario Moreno				=
 *	=========================================
 *
 * @author 
 * @version 1.00 2013/11/30
 */
 
 //LIBRERÍAS A OCUPAR
 //GRÁFICA
 import javax.swing.JOptionPane;
 //SCANNER
 import java.util.Scanner;
 //PILAS
 import java.util.Stack;
 
public class Torres_de_Hanoi {
    
    public static void main(String[] args) {
    	
		//OBJETO PARA LECTURA DE DATOS   	
    	Scanner leer=new Scanner(System.in);
    
    	//VARIABLES A OCUPAR
    	int n, i, o, d;
   		String os,ds,ns;
    	
    	//DESARROLLO DEL JUEGO
    	JOptionPane.showMessageDialog (null,"\t\tBienvenido al juego Torres de Hanoi\n");
    	JOptionPane.showMessageDialog (null,"La torre de Hanoi es un juego de ingenio que desafía a quien lo juega a trasladar la torre de un \n extremo al otro de 3 espacios en la menor cantidad de movimientos posibles; pero tiene 2 reglas:");
    	JOptionPane.showMessageDialog (null,"1.- Sólo se puede mover un elemento a la vez,\n 2.- No se puede colocar una elemento más grande (con mayor valor) encima de uno más pequeño.");

    	
    	JOptionPane.showMessageDialog (null,"\n\n\t\tQUE EMPIECE EL JUEGO!!!\n\n");
    	do{
    		ns=JOptionPane.showInputDialog ("Ingrese el número de elementos de la torre: ");
    		n = Integer.valueOf(ns);
    	}while((n < 3) || (n > 8));
    	//DECLARAR t PARA OCUPAR A LOS MÉTODOS DE LA CLASE
    	Torres_de_Hanoi t = new Torres_de_Hanoi(n);
        t.Visualizar();
        //MOVER DE UNA TORRE A OTRA
        do
        {   
        	do{            
	        os=JOptionPane.showInputDialog ("\nIngrese desde que torre desea mover: ");
	        o=Integer.valueOf(os);
        	}while(o<1 || o>3);
	        do{
	        ds=JOptionPane.showInputDialog ("Ingrese cual será la torre destino: ");
	        d = Integer.valueOf(ds);
	        }while(d<1 || d>3);       	
        	o=o-1;
        	d=d-1;
	        System.out.println ("\n");
	        //ENVIAMOS LOS PARÁMETROS DE LA TORRE DE ORIGEN Y LA DE DESTINO       
	        t.Mover(o,d);
	        //VISUALIZAMOS LO QUE VAMOS HACIENDO
	        t.Visualizar();
	        //FINALIZA EL JUEGO	        
	    }while(t.verificar()==false);
    	
    }
    		//==================================================================================================
		    //DCLARAR LAS 3 TORRES DONDE SE DESARROLLARÁ EL JUEGO  
		    Stack<Integer> Torres[] = new Stack[3];  
		      
		    //CONSTRUCTOR, RECIBE EL NÚMERO DE ELEMENTOS QUE EL USUARIO ESCOGE 
		    public Torres_de_Hanoi(int elem) 
		    { 		         
		        // Inicializamos las columnas vacias  
		        Torres[0] = new Stack<Integer>();  
		        Torres[1] = new Stack<Integer>();  
		        Torres[2] = new Stack<Integer>();  
		        //COLOCAR EN LA PRIMERA TORRE LOS ELEMENTOS EN ORDEN  
		        for (int i=elem;i>0;i--) 
		        {
		        	Torres[0].push(i);  
		        }
		    }  
		  
		   //MUESTRA EL ESTADO ACTUAL DEL JUEGO
		    public void Visualizar() 
		    {  
		        for (int i=0;i<3;i++) 
		        {  
		            System.out.print("TORRE "+(i+1)+": ");
		            //IMPRIMIR A MANERA DE CONJUNTOS CON UN FOR EACH, EL ELEMENTO Y EL CONJUNTO A DONDE PERTENECE  
		            for(int n : Torres[i]) System.out.print("["+n+"]");  
		            System.out.println("");  
		        }  
		    }  
    		  //MUEVE DE LA COLUMNA DE ORIGEN A LA COLUMNA DE DESTINO SIEMPRE UN ELEMENTO A LA VEZ  
		    public void Mover(int origen, int destino) 
		    {  
		    	System.out.println("\nMovemos desde ("+(origen+1)+") hasta ("+(destino+1)+")");  
		        System.out.println("");
		        //VERIFICAR SI ES POSIBLE MOVER SEGÚN LAS REGLAS 
		        //REALIZAMOS EL MOVIMIENTO
		        if(Torres[origen].empty()==true)
			    {
			        JOptionPane.showMessageDialog (null,"AVISO: La torre seleccionada está vacía");
			        JOptionPane.showMessageDialog (null,"Seleccione una torre con elementos: \n");
			    }
			    else
			    {
			        if (Torres[destino].empty()==true)
					{
					    Torres[destino].push(Torres[origen].pop());				        	
					}
			        else
				    {
				        if(Torres[origen].peek()>Torres[destino].peek())
				        {
				        	JOptionPane.showMessageDialog (null,"AVISO: La regla 2 no lo permite\n");
				        }
				       	else
				        {
				        	Torres[destino].push(Torres[origen].pop());
				        }
				    }		        	
			    }
			}
			//VERIFICAR SI LA PERSONA GANA
			public boolean verificar()
			{
				if((Torres[0].empty()==true) && (Torres[1].empty()==true))
				{
					JOptionPane.showMessageDialog (null,"¡¡¡¡FELICITACIONES LO LOGRASTE!!!\n");
					return true;
				}
				else
				{
					return false;
				}
			}
}
