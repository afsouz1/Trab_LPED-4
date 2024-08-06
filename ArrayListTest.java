import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * Criar um programa em Java para gerenciar uma lista de compras usando ArrayList, 
 * permitindo adicionar itens, remover itens e listar todos os itens da lista.
 */


public class ArrayListTest {

    public int menuLista(Scanner in) {
        System.out.print("\n\nSelecione a função desejada:\n   (1)Listar Item\n   (2)Adicionar Item;\n   (3)Remover Item;\n   (4)Alterar Item;\n   (0)Sair;\n Opção:  ");
        return in.nextInt();
    }

    public void metodoAdd(ArrayList<String> item, Scanner in){
        System.out.println("\nInsira o item "+(item.size()+1));
        System.out.print("Item: ");
        item.add(in.next());
    }

    public void metodoLista(ArrayList<String> item){
        Iterator <String> iter = item.iterator();
        System.out.println("\nLista de itens:  ");
        while(iter.hasNext()){
            String itens = iter.next();
            System.out.println(itens);
        }

    }

    public void metodoRemove(ArrayList<String> item, Scanner in){
        Iterator <String> iter = item.iterator();
        in.nextLine();
        System.out.print("\nInforme o item a ser removido:  ");
        String nome = in.nextLine();
        while(iter.hasNext()){
            String itens = iter.next();
            if(itens.equalsIgnoreCase(nome)){
                iter.remove();
            }
        }
    }

    public void metodoAlterar(ArrayList<String> item, Scanner in){
        in.nextLine();
        System.out.print("\nInforme o item a ser alterado:  ");
        String nome = in.nextLine();
        System.out.print("\nInforme o novo item:  ");
        String nome1 = in.nextLine();
        item.set(item.indexOf(nome),nome1);
    }

    public int opt1(Scanner in){
        System.out.print("\nDeseja realizar outra operação?\n   (1)Sim;\n   (0)Não;\n Opção:  ");
        return in.nextInt();
    }

    public static void main(String[] args) {
        ArrayListTest metodo = new ArrayListTest();
        ArrayList<String> item = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int opt1, opt;

        do{
            opt = metodo.menuLista(in);
            switch (opt) {
                case 1:
                    metodo.metodoLista(item);
                    break;
                case 2:
                    metodo.metodoAdd(item, in);
                    break;
                case 3:
                    metodo.metodoRemove(item, in);
                    break;
                case 4:
                    metodo.metodoAlterar(item, in);
                    break;
                default:
                    System.out.println("\nErro, item inválido.\n\n");
                    break;
            }
            opt1 = metodo.opt1(in);
        }while(opt1 !=0);
        in.close();
    }
    
}
