public class CarroPopular extends Automovel implements IPVA {
    private String[] CarroPopular = new String[4];

    public CarroPopular(int id) {
        super(4, 5, id, 0.75, cte_CarroPopular);// o carro popular tem 4 rodas, uma velocidade de 5 blocos/turno e um
                                                // consumo de 0.75 litros de combustivel por bloco
        CarroPopular[0] = "  ______";
        CarroPopular[1] = " /|_||_\\`.__";
        CarroPopular[2] = "(   _    _ _\\";
        CarroPopular[3] = "=`-(_)--(_)-'\n\n";
    }

    public void desenhar()  {
		String pos = "\n";
		for (int i = 0; i < this.GetPos(); i++)// string que dara os espacos para simular a posicao do veiculo na pista
			pos += " ";
		for (String x : CarroPopular)
			System.out.print(pos + x);
    }

    public String toString() {
        return "Carro Popular, " + super.toString();
    }
}
