import java.util.Scanner;
import java.util.Stack;

/**
 * AtvFixacaoStack
 */
public class AtvFixacaoStack {
    Stack<String> stack = new Stack<String>();
    Scanner in = new Scanner(System.in);

    public void methodAdd (){
        System.out.print("\nInsira tarefa: ");
        stack.push(in.nextLine());
    }

    public void methodRemove () {
        if (stack.isEmpty()) {
            System.out.println("\nSem tarefas a remover!");
            
        }else{
            System.out.println("\nTarefa removida!");
            stack.pop();
        }
    }

    public void methodList (){
        System.out.println("\nElementos: \n"+stack);
    }

    public int mainMenu () {
        System.out.println("\n1-Adicionar elemento;\n2-Remover elemento;\n3-Listar elementos da pilha;\n0-Sair;\n");
        System.out.print("Selecione a opção: ");
        int opt = in.nextInt();
        in.nextLine();
        return opt;
    }

    public static void main(String[] args) {
        AtvFixacaoStack method = new AtvFixacaoStack();
        boolean ctrl = true;
        do{
            int opt = method.mainMenu();
            switch (opt) {
                case 1:
                    method.methodAdd();
                    break;
                case 2:
                    method.methodRemove();
                    break;
                case 3:
                    method.methodList();
                    break;
                case 0:
                    System.out.println("Fim do sistema\n\n");
                    ctrl = false;
                    break;
                default:
                    System.out.println("Erro, digite um caracter válido");
                    break;
            }
        }while(ctrl);
    }
}