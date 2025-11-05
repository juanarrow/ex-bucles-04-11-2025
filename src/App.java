public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Introduzca el valor del intervalo mínimo: ");
        long min = 0;//Long.parseLong(System.console().readLine());
        System.out.println("Introduzca el valor del intervalo máximo: ");
        long max = 0;//Long.parseLong(System.console().readLine());
        if (min <0 || max < 0){
            System.out.println("Deve introducir un intervalo correcto positivo donde min <=max");
            return;
        }
        if(min > max ){
            long aux = min;
            min = max;
            max = aux;
        }
        long numero = (long)(Math.floor(Math.random()*(max - min +1)) + min);
        numero = 123456765432100L;//12345678987654321001//
        numero = numero*10 +1;
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
        int digitosAux = digitos;
        while((digitosAux-- > 0)){
            int digito = (int)(aux%10);
            aux/=10;
            System.out.println(digito);
        }
    }
}
