
//alinhar shift + alt + f
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class exercicios_aula {
    public static void teste_input_int() {
        Scanner scanner = new Scanner(System.in);
        int inteiro = scanner.nextInt();
        System.out.print("o valor inteiro é = " + inteiro);
    }

    public static void teste_input_string() {
        Scanner scanner = new Scanner(System.in);
        String texto = scanner.nextLine();
        System.out.print("o valor de texto é = " + texto);
    }

    public static void numero_secreto(int menor,int maior) {
        boolean repetir = true;
        Random random = new Random();
        int numero_aleatorio = random.nextInt(maior - menor) + menor;
        while(repetir){
            Scanner scanner = new Scanner(System.in);
            if(scanner.nextInt() == numero_aleatorio){
                System.out.println("acertou ^_^");
                repetir = false;
            }else{
                System.out.println("errou :-<\nfavor tentar de novo");
            }
        }
    }

    public static void problema_Valeria(){

        System.out.println("digite um numero maior que zero");

        int numero_entrada = 0;
        int numero_maior = 0;
        int numero_menor = (int)Double.POSITIVE_INFINITY;

        while(true){
            Scanner scanner = new Scanner(System.in);
            numero_entrada = scanner.nextInt();

            if(numero_entrada > numero_maior){
                numero_maior = numero_entrada;
            }
            if(numero_entrada < 0){
                break;
            }
            if(numero_entrada < numero_menor){
                numero_menor = numero_entrada;
            }
        }
        System.out.println("maior numero = " + numero_maior + "\nmenor numero = " + numero_menor);
    }



}

class desafios {
    public static void numero_mes() {

        ArrayList<String> lista_meses = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        lista_meses.add("");
        lista_meses.add("Janeiro");
        lista_meses.add("Fevereiro");
        lista_meses.add("Março");
        lista_meses.add("Abril");
        lista_meses.add("Maio");
        lista_meses.add("Junho");
        lista_meses.add("Julho");
        lista_meses.add("Agosto");
        lista_meses.add("Setembro");
        lista_meses.add("Outubro");
        lista_meses.add("Novembro");
        lista_meses.add("Dezembro");
        System.out.println(lista_meses.get(i));
    }

}

class START {
    public static String mensagem = "ola java";

    public static void main(String args[]) {
        System.out.println(mensagem);
        int numero_inteiro = new Scanner(System.in).nextInt();
    }
}