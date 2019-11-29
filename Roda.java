import java.util.Random;

public class Roda {
    private boolean calibragem;// calibragem=true caso a roda esteja calibrada, calibragem=false caso contrario

    public Roda() {
        Random rand = new Random();
        calibragem = (rand.nextInt(101) % 2 == 0 ? true : false);// sorteia um numero de 0 a 100, caso seja um numero
                                                                 // par, o pneu esta calibrado, caso contrario, naocalibragem = false;
    }

    public void SetCalibragem() {
        calibragem = true;
    }

    public void Esvaziar()// esvazia o pneu
    {
        calibragem = false;
    }

    public boolean GetCalibragem()// retorna true, caso o pneu esteja calibrado, e false caso contrario
    {
        return calibragem;
    }
}
