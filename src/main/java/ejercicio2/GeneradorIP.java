package ejercicio2;

import java.util.Random;

public class GeneradorIP {
	
	private Random random;

    public GeneradorIP() {
        this.random = new Random();
    }

    public int generarNumero(int minimo, int maximo) {
        return random.nextInt((maximo - minimo) + 1) + minimo;
    }

    public String generarIPV4() {
        StringBuilder ip = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int numero;
            do {
                numero = generarNumero(0, 254);
            } while ((i == 0 || i == 3) && numero == 0);

            ip.append(numero);
            if (i < 3) {
                ip.append(".");
            }
        }
        return ip.toString();
    }
    
}
