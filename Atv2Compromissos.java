import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Atv2Compromissos
 */
public class Atv2Compromissos {
    Scanner in = new Scanner(System.in);
    ArrayList<String> compromisso = new ArrayList<>();
    ArrayList<String> descricao = new ArrayList<>();
    ArrayList<Integer> dia = new ArrayList<>();
    ArrayList<Integer> mes = new ArrayList<>();
    ArrayList<Integer> ano = new ArrayList<>();

    public void methodAdd (){
        System.out.print("::Insira o nome do compromisso:  ");
        compromisso.add(in.nextLine());
        System.out.print("::Insira a DESCRIÇÃO:  ");
        descricao.add(in.nextLine());
        System.out.print("::Insira o DIA:  ");
        dia.add(in.nextInt());
        System.out.print("::Insira o MÊS:  ");
        mes.add(in.nextInt());
        System.out.print("::Insira o ANO:  ");
        ano.add(in.nextInt());
        System.out.println(">>Compromisso registrado!");
    }

    public void methodRemove (){
        int ctrl = 0, indice = 0;
        String compromisso1;
        do{
            ctrl = 0;
            System.out.print("::Insira o nome do compromisso para remover:  ");
            compromisso1 = in.nextLine();
            indice = compromisso.indexOf(compromisso1);
            if (indice == -1) {
                System.out.println(">>Erro! Compromisso inexistente");
                ctrl = 1;
            }else{
                compromisso.remove(indice);
                descricao.remove(indice);
                dia.remove(indice);
                mes.remove(indice);
                ano.remove(indice);
                System.out.println(">>Compromisso excluido!");
                ctrl = 0;
            }
        }while(ctrl == 1);

    }

    public void methodList (){
        int indice = 0;
        Iterator<String> iteratorStr1 = compromisso.iterator();
        Iterator<String> iteratorStr2 = descricao.iterator();
        Iterator<Integer> iteratorInt1 = dia.iterator();
        Iterator<Integer> iteratorInt2 = mes.iterator();
        Iterator<Integer> iteratorInt3 = ano.iterator();

        while (iteratorStr1.hasNext()) {
            String compromisso1 = iteratorStr1.next();
            String descricao1 = iteratorStr2.next();
            Integer dia1 = iteratorInt1.next();
            Integer mes1 = iteratorInt2.next();
            Integer ano1 = iteratorInt3.next();

            System.out.println("\n::Compromisso "+(indice+1)+": "+compromisso1);
            System.out.println("::Descrição: "+descricao1);
            System.out.println("::Data do compromisso: "+dia1+"/"+mes1+"/"+ano1);
            indice++;
            
        }
        System.out.println("\n>>Fim dos compromissos!");

    }

    public void methodFind () {
        Iterator<Integer> iteratorInt1 = dia.iterator();
        Iterator<Integer> iteratorInt2 = mes.iterator();
        Iterator<Integer> iteratorInt3 = ano.iterator();
        Iterator<String> iteratorStr1 = compromisso.iterator();
        Iterator<String> iteratorStr2 = descricao.iterator();

        int dia1 = 0, mes1 = 0, ano1 = 0;
        System.out.println("::Insira a data do compromisso: ");
        System.out.print("::Dia:  ");
        dia1 = in.nextInt();
        System.out.print("::Mes:  ");
        mes1 = in.nextInt();
        System.out.print("::Ano:  ");
        ano1 = in.nextInt();

        while(iteratorInt1.hasNext()){
            String compromisso1 = iteratorStr1.next();
            String descricao1 = iteratorStr2.next();
            Integer dia2 = iteratorInt1.next();
            Integer mes2 = iteratorInt2.next();
            Integer ano2 = iteratorInt3.next();

            if(dia1 == dia2 && mes1 == mes2 && ano1 == ano2){
                System.out.println("\n::Compromisso: "+compromisso1);
                System.out.println("::Descrição: "+descricao1);
                System.out.println("::Data do compromisso: "+dia2+"/"+mes2+"/"+ano2);
            }
        }



    }

    public int methodOpt (){
        System.out.print("\n::Insira a opção desejada:\n::1 - Adicionar Compromisso\n::2 - Remover Compromisso\n::3 - Listar compromissos\n::4 - Buscar compromisso por data\n::0 - Sair\n:: ");
        int opt1 = in.nextInt();
        in.nextLine();
        return opt1;
    }

    public static void main(String[] args) {
        Atv2Compromissos method = new Atv2Compromissos();
        int ctrl = 1;
        int opt1 = 0;

        do{
            opt1 = method.methodOpt();
            switch (opt1) {
                case 1:
                    method.methodAdd();
                    break;
                case 2:
                    method.methodRemove();
                    break;
                case 3:
                    method.methodList();
                    break;
                case 4:
                    method.methodFind();
                    break;
                default:
                    System.out.println(">>Erro! Refaça a operação!");
                    ctrl = 0;
                    break;
            }
        }while(ctrl != 0);
    }
}