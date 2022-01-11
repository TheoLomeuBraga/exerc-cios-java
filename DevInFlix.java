//alinhar shift + alt + f
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Random;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;




class generos_filmes{
    public static String 
    pendente = "pendente",
    ação = "ação",
    comedia = "comedia",
    drana = "drana",
    terror = "terror";
}




class filme{
    

    public static enum linguagem{
        portugues_brasil,
        portugues_portugal,
        ingles,
        japones
    }

    String nome,sinops,link;
    ArrayList<String> generos;
    ArrayList<linguagem> legendas;
    ArrayList<linguagem> dublagem;
    int aprovações,reprovações,id;


    filme(String nome){
        this.nome = nome;
        generos = new ArrayList<String>();
    }

    filme(String nome,String sinops,String link){
        this.nome = nome;
        this.sinops = sinops;
        this.link = link;
        generos = new ArrayList<String>();
    }
    

}

class conta_bancaria{
    conta_bancaria(){}

    String banco,numero_cartao; 
    float saldo;
    float pegar_valor_saldo(){
        float ret = 0;
        saldo = ret;
        return ret;
    }
}



class usuario{
    usuario(){}
    public static enum Genero{
        masculino,
        feminino,
        nao_declarado
    }

    String nome;
    String nome_completo;
    String e_mail,senha;
    conta_bancaria conta;
    Genero genero = Genero.nao_declarado;
    String genero_filme_preferido = generos_filmes.pendente;
    Date data_nascimento;
    String pais,estado,cidade;
    ArrayList<Integer> filmes_assistidos = new ArrayList<Integer>(),filmes_aprovados = new ArrayList<Integer>(),recomendações = new ArrayList<Integer>();
    usuario(String nome){
        this.nome = nome;
    }
    usuario(String nome,Date data_nascimento){
        this.nome = nome;
        this.data_nascimento = data_nascimento;
    }
}

class servidor{
    static int mais_curtido;
    static ArrayList<filme> filmes = new ArrayList<filme>();
    static ArrayList<usuario> usuarios = new ArrayList<usuario>();
    static ArrayList<Integer> em_alta = new ArrayList<Integer>();
    static Map<String,Integer> generos_curtidos;
    
    public static void iniciar(){
        servidor.adicionar_filme(new filme("NULL"));
        generos_curtidos.put(generos_filmes.pendente,0);
        generos_curtidos.put(generos_filmes.ação,0);
        generos_curtidos.put(generos_filmes.comedia,0);
        generos_curtidos.put(generos_filmes.drana,0);
        generos_curtidos.put(generos_filmes.terror,0);
    }

    public static int buscar_mais_curtido(){
        filmes.get(0).aprovações = 0;
        int ret = 0;
        for(int i = 0;i < filmes.size();i++){
            if(filmes.get(i).aprovações > filmes.get(ret).aprovações){
                ret = i;
            }
        }
        System.out.println(filmes.get(ret).nome + " é o filme mais curtido");
        return ret;
    }

    public static int adicionar_filme(filme Filme){
        filmes.add(Filme);
        Filme.id = filmes.size();
        return filmes.size() -1;
    }
    public static int adicionar_usuario(usuario Usuario){
        usuarios.add(Usuario);
        return usuarios.size() -1;
    }

    public static filme pegar_filme(int ID){return filmes.get(ID);}
    public static usuario pegar_usuario(int ID){return usuarios.get(ID);}

    public static ArrayList<filme> pegar_filmes(int ID){return filmes;}
    public static ArrayList<usuario> pegar_usuarios(int ID){return usuarios;}

    public static int pegar_id_filme_nome(String nome){
        int ret = 0;
        for(int i = 0; i < filmes.size();i++){
            if(nome.equals(filmes.get(i).nome)){
                ret = i;
                break;
            }
        }
        return ret;
    }
    public static void curtir_filme(int id){
        filmes.get(id).aprovações++;
        for(int i = 0;i < filmes.get(id).generos.size();i++){
            int a = generos_curtidos.get(filmes.get(id).generos.get(i)) ;
            a +=1;
            generos_curtidos.put(filmes.get(id).generos.get(i), a);
        }

        //generos_curtidos
    }
    public static String pegar_genero_mais_curtido(){
        return "";
    }
}

class local{
    static int id_usuario;

    static void curtir_aleatorio (){
        usuario usu = servidor.usuarios.get(id_usuario);
        //pega filme aleatorio 
        Random gerador = new Random();
        int felme_asistido_aleatorio = gerador.nextInt(usu.filmes_assistidos.size());
        int filme_id = usu.filmes_assistidos.get(felme_asistido_aleatorio);
        String nome_filme = servidor.filmes.get(filme_id).nome;
        System.out.println("voce curtiu o filme " + servidor.pegar_filme(felme_asistido_aleatorio).nome + " y\\n" );
        Scanner scanner = new Scanner(System.in);
        String _string = scanner.nextLine();
        if(_string.compareTo("y") == 0){
            System.out.println("voce curtiu o filme");
            System.out.println("obrigado pelo seu tempo " + usu.nome);
            servidor.curtir_filme(filme_id);
            servidor.usuarios.get(id_usuario).filmes_aprovados.add(filme_id);
        }else{
            System.out.println("voce não curtiu o filme");
        }

    }
}


public class DevInFlix {
    
    public static void adicionar_catalogo_teste(){
        servidor.adicionar_filme(new filme("Filme A"));
        servidor.adicionar_filme(new filme("Filme B"));
        servidor.adicionar_filme(new filme("Filme C"));
        servidor.adicionar_filme(new filme("Teste"));
        servidor.adicionar_filme(new filme("Teste 2"));
        servidor.adicionar_filme(new filme("Teste 3"));

        usuario Theo = new usuario("Théo");
        ArrayList<Integer> lista = new ArrayList<Integer>();
        lista.add(0);
        lista.add(1);
        lista.add(2);
        Theo.filmes_assistidos = lista;
        servidor.adicionar_usuario(Theo);
        servidor.adicionar_usuario(new usuario("Leonardo"));
        servidor.adicionar_usuario(new usuario("Danilo"));
        servidor.adicionar_usuario(new usuario("Migel"));
        servidor.adicionar_usuario(new usuario("Bruno"));

        local.id_usuario = 0;

    }
    public static void main(String args[]) {
        
        servidor.iniciar();
        adicionar_catalogo_teste();
        local.curtir_aleatorio();
        servidor.buscar_mais_curtido();
    }
}
