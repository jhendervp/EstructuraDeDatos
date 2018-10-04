package ejercicio1;
import java.util.Scanner;
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          
       Scanner teclado= new Scanner(System.in);
        int opcion = 0,i=0, j=0, ptr, x=0, z=0, aux, pos;
        String s="";
        int DISPO;
        int orden[]= new int [10];
        int dato[] = new int [10]; 
        int dato_ord[] = new int [10]; 
        int n[] = {1,2,3,4,5,6,7,8,9,10}; 
        int insertar[] = new int [10]; 
        int enlace[]={0,0,0,0,0,0,0,0,0,0};
        int numero,valor=0, start=0, cont, fin=-999;
        System.out.println("-------------------------------");
        System.out.println("Alumno: Valerio Pacheco Jhender");
        System.out.println("Codigo : 0201414025");
        while (opcion!=5 ){
            System.out.println("-------------------------------");
            System.out.println("Posición \t "+"Dato \t "+"Enlace");
        for(j=0;j<10;j++){
        System.out.print(n[j]+ " \t- \t " +dato[j]+ "\t - \t"+enlace[j]);
        System.out.print("\n");
        }
        System.out.println("-------------------------------");
        System.out.println("1 : Insertar");
        System.out.println("2 : Ordenamiento");
        System.out.println("3 : Busqueda");
        System.out.println("4 : Eliminar");
        System.out.println("5 : Salir");
        System.out.println("Ingrese opcion a realizar (START ="+start+"): ");
        opcion=teclado.nextInt();
        
        if(opcion==1){
            cont=0;
            if (start==0) {
                System.out.println("Ingrese en que numero de fila se va a insertar (Start):");
                numero=teclado.nextInt();
                start=numero;
            }else
            {
                System.out.println("Ingrese en que numero de fila se va a insertar:");
                numero=teclado.nextInt();            
            }
                System.out.println("Ingrese el dato a insertar:");
                valor=teclado.nextInt();
                
                // VERIFICAR SI HAY DISPONIBLES 
                for(j=0;j<10;j++){if (enlace[j]==0) cont++;}
                if (cont<=1){DISPO=0;}else{DISPO=1;}
                // FIN VERIFICAR
                    if (DISPO==0){
                            System.out.println("\nOVERFLOW: Ya no se puede insertar elementos, debido a que lista se encuentra llena");
                 
                    }else{

                                if (dato[numero-1]!=0)
                                {
                                    System.out.println("\nNodo ingresado, no se encuentra disponible");
                                    
                                }
                                else
                                {
                                             if (fin!=-999) enlace[fin]=numero;
                                                dato[numero-1]=valor;
                                                fin=numero-1;
                                                enlace[numero-1]=0;          
                                }
                }
        }
        if(opcion==2){
                s="";
             for(x=0;x<10;x++){
                    dato_ord[x]=dato[x];
            }
            for(x=1;x<10;x++){
            for(z=0;z<9;z++){
                if (dato_ord[z]>dato_ord[z+1]){
                    aux=dato_ord[z];
                    dato_ord[z]=dato_ord[z+1];
                    dato_ord[z+1]=aux;
                }
            }
             if (dato_ord[x]!=0) s =s +dato_ord[x]+ "\n";
            }
        System.out.println("\n\nLista Ordenada :" + "\n" + s);
        System.out.println("-------------------------------");
        
        }
        if(opcion==3){
            aux=0;
            System.out.println("Ingrese el numero a buscar:");
            valor=teclado.nextInt();
            
                
                
            ptr=start;
            while(ptr!=0 && aux==0){
                if (valor == dato[ptr-1]){
                   aux=ptr;
                }else{
                    ptr=enlace[ptr-1];
                }
            }
                    
            if(ptr==0){
                System.out.println("\n-------------------------------");
                System.out.println("DATO BUSCADO no se encuentra en la lista" );
            }else{
                System.out.println("\n-------------------------------");
                System.out.println("DATO BUSCADO: "+ valor+", se encuentre en la pocisión "+ aux +", y su enlace es el "+enlace[aux-1]);
            }
   
        }
        if(opcion==4){
            aux=0;
            System.out.println("Ingrese el nodo del dato que desea ELIMINAR:");
            numero=teclado.nextInt();
            if (dato[numero -1 ]==0)
            {
                System.out.println("\n-------------------------------");
                System.out.println("NODO INGRESADO, NO SE ENCUENTRA OCUPADO CON DATOS" );
            }else
            {
                if (numero==start){
                         start=enlace[numero-1];
                         dato[numero-1]=0;
                         enlace[numero-1]=0;
                         fin=-999;
                         
                }
                else{
                        for(j=0;j<10;j++){
                            if (enlace[j]==numero) 
                            {

                                System.out.println(enlace[j]+"----"+numero+"----"+j+"----"+fin);
                                if (fin==numero - 1)
                                {fin = j ;
                                
                                }
                                System.out.println(enlace[j]+"----"+numero+"----"+j+"----"+fin);
                                enlace[j]=enlace[numero-1];
                                dato[numero-1]=0;
                                enlace[numero-1]=0;
                                
                                j=20;
                            }
                        }
                }
                
            
            }
            
                
            
   
        }
     }
 }
    
}
