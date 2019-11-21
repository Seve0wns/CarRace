import java.util.Scanner;

public class Simulador {
    static Veiculo[] veiculos;
    static Scanner leitor;

    public static void main(String[] args) {
        int menu;
        veiculos = new Veiculo[20];
        printMenu();
        System.out.println("Opção menu: ");
        menu = verify(0, 11);
        while (menu != 0) {
            printMenu();
            System.out.println("Opção menu: ");
            menu = verify(0, 12);
            if(menu == 1)
                incluirVeiculo();
            else if(menu == 2)
                removerVeiculo(verify(0,19));
            else if(menu == 3)

            

        }
    }

    private static int verify(int chao, int teto) {
        leitor = new Scanner(System.in);
        int output;
        do {
            output = leitor.nextInt();
            if (output < chao || output > teto)
                System.out.println("Opcao invalida! Escolha um numero entre " + chao + " e " + teto + ":");
        } while (output < chao || output > teto);
        return output;
    }

    private static void printMenu() {
        System.out.println("00 - Sair");
        System.out.println("01 - Incluir veículo");
        System.out.println("02 - Remover um veículo");
        System.out.println("03 - Abastecer um veículo");
        System.out.println("04 - Movimentar um veículo");
        System.out.println("05 - Movimentar veículos por tipo");
        System.out.println("06 - Imprimir todos os dados de todos os veículos");
        System.out.println("07 - Imprimir dados de veículos por tipo");
        System.out.println("08 - Esvaziar um pneu específico");
        System.out.println("09 - Calibrar um pneu específico");
        System.out.println("10 - Calibrar todos os pneus por tipo do veículo");
        System.out.println("11 - Imprimir pista de corrida");
    }

    private static void incluirVeiculo() {
        int i = 0;
        while (i < 20 && veiculos[i] != null)
            i++;
        if (i < 20) {
            System.out.println("Informe o tipo de veículo\n1 - Bicicleta\n2 - Motocicleta\n3 - Carro\n4 - Ferrari");
            int opt = verify(1, 4);
            if (opt == 1)
                veiculos[i] = new Bicicleta(i);
            else if (opt == 2)
                veiculos[i] = new Motocicleta(i);
            else if (opt == 3)
                veiculos[i] = new CarroPopular(i);
            else if (opt == 4)
                veiculos[i] = new Ferrari(i);
        }
        else
            System.out.println("Você ja atingiu o número máximo de veículos!");
    }
    private static void removerVeiculo(int id) {
        if(veiculos[id]==null)
            System.out.println("Veículo inexistente!");
        else
            veiculos[id]=null;
    }
    private static void abastecerVeiculo(int id) {
        if(veiculos[id]==null)
            System.out.println("Veículo inexistente!");
        else if(veiculos[id])
    }
}