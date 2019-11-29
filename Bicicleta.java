public class Bicicleta extends Veiculo {
    private String[] Bicicleta = new String[3];

    public Bicicleta(int id) {
        super(2, 2, id);// a bicicleta tem duas rodas e se move a uma velocidade de dois blocos por
                        // turno
        Bicicleta[0] = "   __o";
        Bicicleta[1] = " _`\\<,_";
        Bicicleta[2] = "(*)/ (*)\n\n";
    }

    public boolean Mover()// funcao para mover o veiculo
    {
        if (tudoCalibrado()) {
            SetPos(GetPos() + GetSpeed());
            return true;
        }
        return false;
    }

    public void desenhar() {
        String pos = "\n";
        for (int i = 0; i < this.GetPos(); i++)// string que dara os espacos para simular a posicao do veiculo na pista
            pos += " ";
        for (String x : Bicicleta)
            System.out.print(pos + x);
    }

    public String toString() {
        return "Bicicleta, " + super.toString();
    }
}
