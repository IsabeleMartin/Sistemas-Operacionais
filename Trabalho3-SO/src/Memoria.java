// Esta classe representa um objeto  mememória

public class Memoria {
	int processo; 
    int pagina; 
    boolean referenceBit; //bit de referência, só será utilizado no algoritmo Second Chance
    int menosUsada; // Atributo para identificar a página que foi menos utilizada, utilizado somente no algoritmo LRU

    // Construtor 
    public Memoria(int processo, int pagina) {
        this.processo = processo;
        this.pagina = pagina;
        this.referenceBit = true; // Bit de referência inicialmente definido como true
    }
}