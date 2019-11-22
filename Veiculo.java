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
		this.rodas = new Roda[nrod];
		for (int i = 0; i < nrod; i++) {
			rodas[i] = new Roda();
			rodas[i].SetCalibragem();
		}
	}

	public int GetSpeed()// getter para a velocidade do veiculo
	{
		return mov;
	}

	public int Getnrod() {
		return nrod;
	}

	public int GetID() {
		return id;
	}

	public void calibra(int i)// funcao para a calibragem da i-esima roda
	{
		rodas[i].SetCalibragem();
	}

	public void calibrarTodos() {
		for (Roda x : rodas) {
			x.SetCalibragem();
		}
	}

	public void Esvaziar(int i)// esvazia a i-esima roda
	{
		rodas[i].Esvaziar();
	}

	public boolean tudoCalibrado() { // checa se o veiculo esta com todos os pneus calibrados
		boolean fcalibragem = true;
		for (int i = 0; fcalibragem && i < nrod; i++)
			fcalibragem = fcalibragem && rodas[i].GetCalibragem();
		return fcalibragem;
	}

	public int GetPos()// retorna a distancia total percorrida pelo veiculo
	{
		return dx;
	}

	public void SetPos(int dx) // modifica a distanca total percorrida pelo veiculo
	{
		this.dx = dx;
	}

	public abstract boolean Mover();

	public abstract void desenhar();

	public String toString() {
		String data = "";
		data += "ID: " + id;
		for (int i = 0; i < nrod; i++) {
			data += ", roda " + (i + 1) + ": ";
			data += rodas[i].GetCalibragem();// caso a calibragem da roda seja igual a true, entao esfre "F"
												// Full, caso contrario "E" Empty
		}
		data += ", Distancia Percorrida: " + dx;
		return data;
	}
}
