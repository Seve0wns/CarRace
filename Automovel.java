import java.util.Random;

public abstract class Automovel extends Veiculo implements IPVA {
    private final double consumo, priceIPVA;// consumo=a quantidade em litros que o automovel gasta para se mover um
                                            // "espaco",priceIPVA=o preco do IPVA do automovel
    private double combustivel;// a quantidade restante de combustivel do veiculo, em litros
    private final boolean IPVA;// IPVA=true caso o IPVA esteja pago, IPVA=false caso contrario

    public Automovel(int nrod, int mov, int id, double consumo, double cte) {
        super(nrod, mov, id);
        this.consumo = consumo;
        this.priceIPVA = Valor_Base * cte;
        Random rand = new Random();
        IPVA = (rand.nextInt(101) % 2 == 0 ? true : false);// sorte um numero de 0 a 100, caso esse numero seja par,
                                                           // entao o IPVA esta pago, caso o contrario ele nao esta
        combustivel = 3.5;
    }

    public boolean Mover() {
        if (IPVA && combustivel > GetSpeed() * consumo && tudoCalibrado()) {// caso o carro esteja com o IPVA pago e
                                                                              // tenha combustivel suficiente, seu
                                                                              // movimento depende da calibragem
            combustivel -= GetSpeed() * consumo;// caso o automovel se mova, ele gasta combustivel
            SetPos(GetPos()+GetSpeed());
            return true;
        }
        return false;
    }

    public void abastecer(int qtd)// funcao para abastecer o veiculo
    {
        combustivel += qtd;
    }

    public String toString() {
        String data = super.toString();
        data += ", IPVA = "+priceIPVA+" : ";
        data += IPVA ? "Pago" : "Nao Pago";
        data += ", Combustivel: " + combustivel;
        return data;
    }
}
