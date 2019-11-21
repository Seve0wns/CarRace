public class Motocicleta extends Automovel implements IPVA {
    String[] Motocicleta = new String[3];

    public Motocicleta(int id) {
        super(2, 3, id, 0.25, cte_Motocicleta);// a motocicleta tem 2 rodas, se move a uma velocidade de 3 blocos/turno
                                               // e gasta 0.25 litros de gasolino por blocoxs
        Motocicleta[0] = "   ,_oo";
        Motocicleta[1] = ".-/c-//::";
        Motocicleta[2] = "(_)'==(_)\n\n";
    }

    public void desenhar() {
        super.desenhar(Motocicleta);
    }

    public String toString() {
        return "Motocicleta, " + super.toString();
    }
}
