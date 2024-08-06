import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;

//    Atv1 - Gerenciar Alunos e Notas de uma escola.

public class Atv1Array {
    Scanner in;
    ArrayList<String> nome;
    ArrayList<Float> nota;


    public void metodoAdd(){
        System.out.print("\nInsira o Nome do aluno: ");
        nome.add(in.nextLine());
        System.out.print("Insira a Nota do aluno: ");
        nota.add(in.nextFloat());
    }

    public void metodoFind(){
        Iterator<String> iteratorStr = nome.iterator();
        Iterator<Float> iteratorFlt = nota.iterator();
        int indice = 0;

        do{
            if(indice == 0)
                System.out.print("\nDigite o nome do aluno que deseja editar:   ");
            else
                System.out.print("\nNome:  ");
            String nome1 = in.nextLine();
            indice = nome.indexOf(nome1);
            if(indice == -1){
                System.out.println("\nErro! Insira um nome válido");
                metodo.opt1();
            }else{
                System.out.print("\nInsira o Nome do aluno: ");
                nome1 = in.nextLine();
                nome.set(indice, nome1);
                System.out.print("Insira a Nota do aluno: ");
                Float nota1 = in.nextFloat();
                nota.set(indice, nota1);
            }
        }while(indice ==-1);
        
    }

    public void metodoRemove(ArrayList<String> nome, ArrayList<Float> nota, Iterator<String> iteratorStr, Iterator<Float> iteratorFlt){
        int indice = 0;
        Iterator<String> iteratorStr = nome.iterator();
        Iterator<Float> iteratorFlt = nota.iterator();

        do{
            if(indice == 0)
                System.out.print("\nDigite o nome do aluno que deseja remover da lista:   ");
            else
                System.out.print("\nNome:  ");
            String nome1 = in.nextLine();
            indice = nome.indexOf(nome1);
            if(indice == -1){
                System.out.println("\nErro! Insira um nome válido");
            }else{
                nome.remove(indice);
                nota.remove(indice);
                System.out.println("\nNome e nota removido com sucesso!");               
            }
        }while(indice ==-1);

    }
    public void metodoMedia(){
        Iterator<String> iteratorStr = nome.iterator();
        Iterator<Float> iteratorFlt = nota.iterator();
        float media = 0;
        iteratorFlt = nota.iterator();
        System.out.println("\n");
        while(iteratorFlt.hasNext()){
            float nota2 = iteratorFlt.next();
            System.out.println("Nota:  "+nota2);
            media = media+nota2;

        }
        System.out.println("Média = "+(media/nota.size()));

    }


    public int opt1(){
        int opt = 0;
        int ext = 1;
        
        do{
        ext = 1;
        System.out.print("\nSelecione a opção:\n   (1)Adicionar Aluno e Nota;\n   (2)Editar Aluno e Nota;\n   (3)Remover Aluno e Nota\n   (4)Verificar Média\n   (0)Sair;\n   Opção:   ");
            try{
                opt = in.nextInt();
                in.nextLine();
            }catch (Exception e){
                System.out.println("\nErro! refaça a operação");
                in.nextLine();
                ext = 0;
            }
        }while(ext == 0);
        return opt;
    }

    public static void main(String[] args) {
        in = new Scanner(System.in);
        Atv1Array metodo = new Atv1Array();
        nome = new ArrayList<>();
        nota = new ArrayList<>();

        int opt = 0;
        opt = metodo.opt1(in);

        while(opt != 0){
            switch (opt){
                case 1:
                    metodo.metodoAdd();
                    break;
                case 2:
                    metodo.metodoFind();
                    break;
                case 3:
                    metodo.metodoRemove();
                    break;
                case 4:
                    metodo.metodoMedia();
                    break;
                default:
                    System.out.println("Informação incorreta, refaça a operação!");
                    break;
            }
            opt = metodo.opt1(in);
        }

        in.close();
    }
}

