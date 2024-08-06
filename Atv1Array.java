import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;

//Atv1 - ArrayList: Alunos e Notas

public class Atv1Array {
    Scanner in = new Scanner(System.in);
    ArrayList<String> nome = new ArrayList<>();
    ArrayList<Float> nota = new ArrayList<>();

    public void metodoAdd(){
        System.out.print("\nInsira o Nome do aluno: ");
        nome.add(in.nextLine());
        System.out.print("Insira a Nota do aluno: ");
        nota.add(in.nextFloat());
        in.nextLine();
    }

    public void metodoFind(){
        int indice = -1;
        do {
            if(indice == -1)
                System.out.print("\nDigite o nome do aluno que deseja editar: ");
            else
                System.out.print("\nNome: ");
            String nome1 = in.nextLine();
            indice = nome.indexOf(nome1);
            if(indice == -1){
                System.out.println("\nErro! Insira um nome válido");
            } else {
                System.out.print("\nInsira o novo Nome do aluno: ");
                nome1 = in.nextLine();
                nome.set(indice, nome1);
                System.out.print("Insira a nova Nota do aluno: ");
                Float nota1 = in.nextFloat();
                nota.set(indice, nota1);
                in.nextLine();
            }
        } while(indice == -1);
    }

    public void metodoRemove(){
        int indice = -1;
        do {
            System.out.print("\nDigite o nome do aluno que deseja remover da lista: ");
            String nome1 = in.nextLine();
            indice = nome.indexOf(nome1);
            if(indice == -1){
                System.out.println("\nErro! Insira um nome válido");
            } else {
                nome.remove(indice);
                nota.remove(indice);
                System.out.println("\nNome e nota removidos com sucesso!");
            }
        } while(indice == -1);
    }

    public void metodoAvrg(){
        float media = 0;
        System.out.println("\nNotas dos alunos:");
        for (float nota2 : nota) {
            System.out.println("Nota: " + nota2);
            media += nota2;
        }
        System.out.println("Média = " + (media / nota.size()));
    }

    public void metodoShow(){
        Iterator<String> iteratorStr = nome.iterator();
        Iterator<Float> iteratorFlt = nota.iterator();
        System.out.println("\n");
        while(iteratorStr.hasNext() && iteratorFlt.hasNext()){
            String nome2 = iteratorStr.next();
            float nota2 = iteratorFlt.next();
            System.out.println("Aluno: " + nome2 + "  -> Nota: " + nota2);
        }
    }

    public int opt1(){
        int opt = 0;
        int ext = 1;
        
        do {
            ext = 1;
            System.out.print("\nSelecione a opção:\n   (1)Adicionar Aluno e Nota;\n   (2)Editar Aluno e Nota;\n   (3)Remover Aluno e Nota;\n   (4)Verificar Média;\n   (5)Mostrar Alunos e Notas;\n   (0)Sair;\n   Opção: ");
            try {
                opt = in.nextInt();
                in.nextLine();
            } catch (InputMismatchException e){
                System.out.println("\nErro! refaça a operação");
                in.nextLine();
                ext = 0;
            }
        } while(ext == 0);
        return opt;
    }

    public static void main(String[] args) {
        Atv1Array metodo = new Atv1Array();

        int opt;
        do {
            opt = metodo.opt1();
            switch (opt) {
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
                    metodo.metodoAvrg();
                    break;
                case 5:
                    metodo.metodoShow();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Informação incorreta, refaça a operação!");
                    break;
            }
        } while(opt != 0);

        metodo.in.close();
    }
}
