public abstract class Veiculo {
	private int dx;// dx=a distancia total percorrida pelo veiculo
	private final int nrod, mov, id;// nrod=numero de rodas,mov=velocidade do veiculo em quantidade de "espacos" que
									// ele percorre num turno,id=a identificacao do veiculo
	private Roda[] rodas;// rodas=vetor de rodas do veiculo

	public Veiculo(int nrod, int mov, int id)// recebe os atributos da subclasse e os aplica nas variaveis
	{
		this.nrod = nrod;
		dx = 0;
		this.mov = mov;
		this.id = id;
		rodas = new Roda[nrod];
		for (Roda x : rodas) {
			x = new Roda();
			x.SetCalibragem();
		}
	}

	public int GetSpeed()// getter para a velocidade do veiculo
	{
		return mov;
	}

	public boolean Mover()// funcao para mover o veiculo
	{
		int i = 0;
		boolean fcalibragem = true;
		while (fcalibragem && i < nrod)// checa se o veiculo esta com todos os pneus calibrados
			fcalibragem = fcalibragem && rodas[i].GetCalibragem();
		if (fcalibragem)// caso estiver, o veiculo pode se mover
		{
			dx += mov;
			return true;// retorna true caso e veiculo se mova
		}
		return false;// retorna false caso contrario
	}

	public int GetID() {
		return id;
	}

	public void desenhar(String[] design) {
		String pos = "\n";
		for (int i = 0; i < dx; i++)// string que dara os espacos para simular a posicao do veiculo na pista
			pos += " ";
		for (String x : design)
			System.out.print(pos + x);
	}

	public void calibra(int i)// funcao para a calibragem da i-esima roda
	{
		rodas[i].SetCalibragem();
	}

	public void Esvaziar(int i)// esvazia a i-esima roda
	{
		rodas[i].Esvaziar();
	}

	public int GetPos()// retorna a distancia total percorrida pelo veiculo
	{
		return dx;
	}

	public String toString() {
		String data = "";
		data += "ID: " + id;
		for (int i = 0; i < rodas.length; i++) {
			data += ", roda " + (i + 1) + ": ";
			data += rodas[i].GetCalibragem() ? "F" : "E";// caso a calibragem da roda seja igual a true, entao esfre "F"
															// Full, caso contrario "E" Empty
		}
		data += ", Distancia Percorrida: " + dx;
		return data;
	}
}
