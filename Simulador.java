import java.util.Scanner;

public class Simulador {
    private static Veiculo[] veiculos;
    private static Scanner leitor;
    /*
    Calibrar com chance?
    */
        public static void main(String[] args) {
        int menu = 1;
        veiculos = new Veiculo[20];
        while (menu != 0) {
            printMenu();
            System.out.println("Opcao menu: ");
            menu = verify(0, 11);
            if (menu == 1) {
                System.out.println("Informe o tipo de veiculo\n1 - Bicicleta\n2 - Motocicleta\n3 - Carro\n4 - Ferrari");
                incluirVeiculo(verify(1, 4));
            } else if (menu == 2) {
                System.out.println("Informe o id do veiculo: ");
                removerVeiculo(verify(0, 19));
            } else if (menu == 3) {
                System.out.println("Informe o id do veiculo: ");
                int id = verify(0, 19);
                leitor = new Scanner(System.in);
                System.out.println("Informe a quantidade de combustivel: ");
                int litros = leitor.nextInt();
                abastecerVeiculo(id, litros);
            } else if (menu == 4) {
                System.out.println("Informe o id do veiculo: ");
                moverVeiculo(verify(0, 19));
            } else if (menu == 5) {
                System.out.println("Informe o tipo de veiculo\n1 - Bicicleta\n2 - Motocicleta\n3 - Carro\n4 - Ferrari");
                moverTipo(verify(1, 4));
            } else if (menu == 6) {
                printDadosTodos();
            } else if (menu == 7) {
                System.out.println("Informe o tipo de veiculo\n1 - Bicicleta\n2 - Motocicleta\n3 - Carro\n4 - Ferrari");
                printDadosTipo(verify(1, 4));
            } else if (menu == 8) {
                System.out.println("Informe o id do veiculo: ");
                int id = verify(0, 19);
                if (verificaExistencia(id)) {
                    int n = veiculos[id].Getnrod();
                    System.out.println("Informe o numero do penu (1 - " + n + "): ");
                    esvaziarPneu(id, verify(1, n));
                }
            } else if (menu == 9) {
                System.out.println("Informe o id do veiculo: ");
                int id = verify(0, 19);
                if (verificaExistencia(id)) {
                    int n = veiculos[id].Getnrod();
                    System.out.println("Informe o numero do penu (1 - " + n + "): ");
                    calibrarPneu(id, verify(1, n));
                }
            } else if (menu == 10) {
                System.out.println("Informe o tipo de veiculo\n1 - Bicicleta\n2 - Motocicleta\n3 - Carro\n4 - Ferrari");
                calibrarTipo(verify(1, 4));
            } else if (menu == 11) {
                printCorrida();
            }
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

    private static boolean verificaExistencia(int id) {
        if (veiculos[id] == null) {
            System.out.println("Veiculo inexistente!");
            return false;
        } else
            return true;
    }

    private static void printMenu() {
        System.out.println("00 - Sair");
        System.out.println("01 - Incluir veiculo");
        System.out.println("02 - Remover um veiculo");
        System.out.println("03 - Abastecer um veiculo");
        System.out.println("04 - Movimentar um veiculo");
        System.out.println("05 - Movimentar veiculos por tipo");
        System.out.println("06 - Imprimir todos os dados de todos os veiculos");
        System.out.println("07 - Imprimir dados de veiculos por tipo");
        System.out.println("08 - Esvaziar um pneu especifico");
        System.out.println("09 - Calibrar um pneu especifico");
        System.out.println("10 - Calibrar todos os pneus por tipo do veiculo");
        System.out.println("11 - Imprimir pista de corrida");
    }

    private static void incluirVeiculo(int tipo) {
        int i = 0;
        while (i < 20 && veiculos[i] != null)
            i++;
        if (i < 20) {
            if (tipo == 1)
                veiculos[i] = new Bicicleta(i);
            else if (tipo == 2)
                veiculos[i] = new Motocicleta(i);
            else if (tipo == 3)
                veiculos[i] = new CarroPopular(i);
            else if (tipo == 4)
                veiculos[i] = new Ferrari(i);
        } else
            System.out.println("Voce ja atingiu o numero maximo de veiculos!");
    }

    private static void removerVeiculo(int id) {
        if (verificaExistencia(id))
            veiculos[id] = null;
    }

    private static void abastecerVeiculo(int id, int l) {
        if (verificaExistencia(id)) {
            if (veiculos[id] instanceof Bicicleta)
                System.out.println("Voce nao pode abastecer uma bicicleta!");
            else {
                Automovel aux = (Automovel) veiculos[id];
                aux.abastecer(l);
            }
        }
    }

    private static void moverVeiculo(int id) {
        if (verificaExistencia(id)) {
            if (veiculos[id].Mover())
                System.out.println("Moveu!");
            else
                System.out.println("Nao moveu!");
        }
    }

    private static void moverTipo(int tipo) {
        if (tipo == 1)
            for (Veiculo x : veiculos) {
                if (x != null && x instanceof Bicicleta)
                    x.Mover();
            }
        else if (tipo == 2)
            for (Veiculo x : veiculos) {
                if (x != null && x instanceof Motocicleta) {
                    x.Mover();
                }
            }
        else if (tipo == 3)
            for (Veiculo x : veiculos) {
                if (x != null && x instanceof CarroPopular) {
                    x.Mover();
                }
            }
        else if (tipo == 4)
            for (Veiculo x : veiculos) {
                if (x != null && x instanceof Ferrari) {
                    x.Mover();
                }
            }
    }

    private static void printDadosTodos() {
        for (Veiculo x : veiculos) {
            if (x != null)
                System.out.println(x);
        }
    }

    private static void printDadosTipo(int tipo) {
        if (tipo == 1)
            for (Veiculo x : veiculos) {
                if (x != null && x instanceof Bicicleta)
                    System.out.println(x);
            }
        else if (tipo == 2)
            for (Veiculo x : veiculos) {
                if (x != null && x instanceof Motocicleta)
                    System.out.println(x);
            }
        else if (tipo == 3)
            for (Veiculo x : veiculos) {
                if (x != null && x instanceof CarroPopular)
                    System.out.println(x);
            }
        else if (tipo == 4)
            for (Veiculo x : veiculos) {
                if (x != null && x instanceof Ferrari)
                    System.out.println(x);
            }
    }

    private static void esvaziarPneu(int id, int pneu) {
        if (verificaExistencia(id))
            veiculos[id].Esvaziar(pneu - 1);
    }

    private static void calibrarPneu(int id, int pneu) {
        if (verificaExistencia(id))
            veiculos[id].calibra(pneu - 1);
    }

    private static void calibrarTipo(int tipo) {
        if (tipo == 1)
            for (Veiculo x : veiculos) {
                if (x != null && x instanceof Bicicleta)
                    x.calibrarTodos();
            }
        else if (tipo == 2)
            for (Veiculo x : veiculos) {
                if (x != null && x instanceof Motocicleta)
                    x.calibrarTodos();
            }
        else if (tipo == 3)
            for (Veiculo x : veiculos) {
                if (x != null && x instanceof CarroPopular)
                    x.calibrarTodos();
            }
        else if (tipo == 4)
            for (Veiculo x : veiculos)
                if (x != null && x instanceof Ferrari)
                    x.calibrarTodos();
    }

    private static void printCorrida() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        for (Veiculo x : veiculos) {
            if (x != null) {
                System.out.println("ID = "+x.GetID());
                x.desenhar();
                System.out.println("----------------------------------------------------------------------------------------------------------------------");
            }
        }
    }
}