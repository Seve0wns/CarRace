import java.util.Random;
public class Ferrari extends Automovel implements IPVA
{
    String[] Ferrari=new String[6];
    public Ferrari(int id)
    {
	super(4,10,id,2.3,cte_Ferrari);//a ferrari tem 4 rodas, se move a uma velocidade de 10 blocos/turno e tem um consumo de 2.3 litros de combustivel por bloco
	Ferrari[0]="       __";
	Ferrari[1]="     ~( @\\ \\";
	Ferrari[2]="   ____]_[_/_>__";
	Ferrari[3]="  / __ \\<> |  __ \\";
	Ferrari[4]="=\\_/__\\_\\__|_/__\\_D";
	Ferrari[5]="   (__)      (__)\n\n";
    }
    public void desenhar()
    {
	super.desenhar(Ferrari);
    }
    public String toString()
    {
	return "Ferrari, "+super.toString();
    }
}
