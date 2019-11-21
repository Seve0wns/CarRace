public class Bicicleta extends Veiculo {
    String[] Bicicleta = new String[3];

    public Bicicleta(int id) {
        super(2, 2, id);// a bicicleta tem duas rodas e se move a uma velocidade de dois blocos por
                        // turno
        Bicicleta[0] = "   __o";
        Bicicleta[1] = " _`\\<,_";
        Bicicleta[2] = "(*)/ (*)\n\n";
    }

    public void desenhar() {
        super.desenhar(Bicicleta);
    }

    public String toString() {
        return "Bicicleta, " + super.toString();
    }
}
