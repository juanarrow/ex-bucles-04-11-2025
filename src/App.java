public class App {
    public static final String RESET = "\033[0m" ;
    public static final String RED_BACKGROUND = "\033[41m"; 
    public static final String GREEN_BACKGROUND = "\033[42m";
    public static final String BLUE_BACKGROUND = "\033[44m";
    public static final String PURPLE_BACKGROUND = "\033[45m";   
    public static void main(String[] args) throws Exception {
        System.out.println("Introduzca el valor del intervalo mínimo: ");
        long min = Long.parseLong(System.console().readLine());
        System.out.println("Introduzca el valor del intervalo máximo: ");
        long max = Long.parseLong(System.console().readLine());
        System.out.println("¿Blanco y negro o color (b|c)?: ");
        boolean bn = System.console().readLine().toLowerCase().charAt(0)=='b';
        if (min <0 || max < 0){
            System.out.println("Debe introducir un intervalo correcto positivo donde min <=max");
            return;
        }
        if(min > max ){
            long aux = min;
            min = max;
            max = aux;
        }
        long numero = (long)(Math.floor(Math.random()*(max - min +1)) + min);
        
        numero = numero*10 +1; //añade un 1 al final del numero para que no sea 0
        int digitos = 0;
        int digitoMayor = 0;
        long volteado = 0;
        long aux = numero;
        while(aux>0){
            int digito = (int)(aux%10);
            volteado = volteado*10+digito;
            digitos++;
            if(digitoMayor<digito)
                digitoMayor = digito;
            aux/=10;
        }
        digitos--;
        //volteado -> 10012345678987654321
        aux = volteado;
        int fila = 1;
        while((fila<=digitos)){
            int digito = (int)(aux%10);
            aux/=10;
            if(bn){
                for(int i = 1; i<=digitoMayor+1;i++)
                    System.out.print(" ---");
                System.out.println("");
                for(int i = 1; i<=digitoMayor+1;i++){                
                    System.out.printf("| %s ",
                    (i==1)?digito:(i<=digito+1)?"*":" ");

                }
                System.out.println("|");
            }
            else{
                for(int i = 1; i<=digitoMayor+2;i++)
                    System.out.printf(
                        "%s", 
                        (fila==1)?
                          ((i!=digitoMayor+2)?(i==1)?"╔":"═╦":"═╗"):
                        (fila!=digitos+1)?
                          ((i!=digitoMayor+2)?(i==1)?"╠":"═╬":"═╣"):
                          ((i!=digitoMayor+2)?(i==1)?"╚":"═╩":"═╝"));
                    
                System.out.println("");
                for(int i = 1; i<=digitoMayor+1;i++){  
                                  
                    System.out.printf("║%s",
                    (i==1)?digito:(i<=digito+1)?
                    switch(digito){
                        case 1,2,3,4->RED_BACKGROUND;
                        case 5,6->GREEN_BACKGROUND;
                        case 7,8->BLUE_BACKGROUND;
                        case 9->PURPLE_BACKGROUND;
                        default->"";
                    }+" "+RESET:" ");

                }
                System.out.println("║");

            }
            fila++;
            
        }
        if(bn){
            for(int i = 1; i<=digitoMayor+1;i++)
                System.out.print(" ---");
        }
        else{
            System.out.print("╚");
            for(int i = 1; i<=digitoMayor;i++)
                System.out.print("═╩");
            System.out.print("═╝");
            
        }
        
    }
}
