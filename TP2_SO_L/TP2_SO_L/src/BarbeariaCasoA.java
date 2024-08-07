//Trabalho Prático 2 - Sistemas Operacionais
//Alunos: Luiz Gabriel Favacho de Almeida - 22153921
// Mateus de Jesus Santos - 22152028

// Importação da classe Random para geração de números aleatórios.
import java.util.Random;
import java.util.Scanner;
// Importação da classe Semaphore para o uso de semáforos em controle de concorrência.
import java.util.concurrent.Semaphore;
import java.util.Queue;
import java.util.LinkedList;

public class BarbeariaCasoA {
	    public static void main(String[] args) {

	        int CochiloSargento = Entrada(); // Chama a função que define o tempo do cochilo do Sargento Tainha.
	        
	        int[] cadeirasOcupadasPorCategoria = new int[4];
	        int numCadeiras = 20; // total de cadeiras na barbearia
	        int tamMaxFilas = 500; // quantidade máxima de elementos que cada fila poderá ter.

	        // Semáforo para tratar exclusão mútua
	        Semaphore mutex = new Semaphore(1);

	        // Arrays de semáforos para filas de oficiais, sargentos, cabos e pausas
	        Semaphore[] filaOficiais = new Semaphore[tamMaxFilas];
	        Semaphore[] filaSargentos = new Semaphore[tamMaxFilas];
	        Semaphore[] filaCabos = new Semaphore[tamMaxFilas];
	        Semaphore[] filaPausas = new Semaphore[tamMaxFilas];

	        // Filas de espera para clientes de diferentes categorias
	        Queue<Integer> filaEsperaOficiais = new LinkedList<>();
	        Queue<Integer> filaEsperaSargentos = new LinkedList<>();
	        Queue<Integer> filaEsperaCabos = new LinkedList<>();
	        Queue<Integer> filaEsperaPausas = new LinkedList<>();
	        
	        // Variáveis para rastrear as estatísticas
	        int[] numAtendimentosPorCategoria = new int[4]; // Uma posição para cada categoria
	        long[] tempoTotalAtendimentoPorCategoria = new long[4];
	        long[] tempoTotalEsperaPorCategoria = new long[4];
	        long[] tempoEsperaPorCategoria = new long[4];
	        int[] numClientesPorCategoria = new int[4]; // Número total de clientes por categoria

	        // Inicialização das filas
	        for (int i = 0; i < tamMaxFilas; i++) {
	            filaOficiais[i] = new Semaphore(0);
	            filaSargentos[i] = new Semaphore(0);
	            filaCabos[i] = new Semaphore(0);
	            filaPausas[i] = new Semaphore(0);
	        }

	        // Thread do Sargento Tainha
	        Thread sargentoThread = new Thread(() -> {
	            Random rand = new Random();
	            int cont = 0; // controla o laço
	            int ninguemNaFila = 0; // quando ocorrer 3 vezes seguidas o sargento vai embora.
	            while (cont < 1000) { // Laço dá 1000 voltas, para gerar os mil registros pedidos no relatório.
	                cont++;
	                if (ninguemNaFila < 3) {
	                    try {
	                        // Geração de categoria aleatória (0 para pausa, 1 para oficial, 2 para sargento, 3 para cabo)
	                        int categoria = rand.nextInt(4);
	                        //System.out.println(categoria);
	                        if (categoria == 1 && somaVetor(cadeirasOcupadasPorCategoria) < numCadeiras) {
	                            // Adiciona um oficial à fila de oficiais
	                            adicionarCliente(mutex, filaOficiais, filaEsperaOficiais);
	                            ninguemNaFila = 0;
	                           // System.out.println("Sargento Tainha trouxe um oficial.");
	                            cadeirasOcupadasPorCategoria[1]++;
		                        numClientesPorCategoria[1]++;		                        
	                            tempoEsperaPorCategoria[1] = System.currentTimeMillis();
	                        } else if (categoria == 2 && somaVetor(cadeirasOcupadasPorCategoria) < numCadeiras) {
	                            // Adiciona um sargento à fila de sargentos
	                            adicionarCliente(mutex, filaSargentos, filaEsperaSargentos);
	                            ninguemNaFila = 0;
	                            //System.out.println("Sargento Tainha trouxe um sargento.");
	                            tempoEsperaPorCategoria[2] = System.currentTimeMillis();
	                            cadeirasOcupadasPorCategoria[2]++;
		                        numClientesPorCategoria[2]++;
	                        } else if (categoria == 3 && somaVetor(cadeirasOcupadasPorCategoria) < numCadeiras) {
	                            // Adiciona um cabo à fila de cabos
	                            adicionarCliente(mutex, filaCabos, filaEsperaCabos);
	                            ninguemNaFila = 0;
	                            //System.out.println("Sargento Tainha trouxe um cabo.");
	                            tempoEsperaPorCategoria[3] = System.currentTimeMillis();
	                            cadeirasOcupadasPorCategoria[3]++;
		                        numClientesPorCategoria[3]++;
	                        } else {
	                            // Adiciona uma pausa à fila de pausas
	                            adicionarCliente(mutex, filaPausas, filaEsperaPausas);
	                            //System.out.println("Sargento Tainha: pausa.");
	                            tempoEsperaPorCategoria[0] = System.currentTimeMillis();
	                            cadeirasOcupadasPorCategoria[0]++;
	                            ninguemNaFila++;
		                        numClientesPorCategoria[0]++;
	                        }
	                        Thread.sleep(CochiloSargento * 1000);
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                } else {
	                    //System.out.println("Sargento Tainha foi embora por não ter ninguém!");
	                    cont = 1000; // para quebrar o laço, e o Sargento ir embora.
	                }
	            }
	        });

	        // Threads dos Barbeiros
	        Thread barbeiroZero = new Thread(() -> {
	        	int cont = 0;
	            while (cont < 3) {
	                Random rand = new Random();
	                int TempoDeCorte = 0;
	                try {
	                    // Chamada para atender um cliente
	                    int categoria = atenderCliente(mutex, filaEsperaOficiais, filaEsperaSargentos, filaEsperaCabos, filaEsperaPausas);
	                  //  System.out.println(categoria);
	                    if (categoria == 1) {
	                        // Atendimento a um Oficial
	                        //System.out.println("Atendimento a um Oficial");
	                    	tempoTotalEsperaPorCategoria[1] += System.currentTimeMillis() - tempoEsperaPorCategoria[1];
	                        TempoDeCorte = rand.nextInt((6000) + 4000); // define o tempo de corte que pode ser gasto com um Oficial
	                        cadeirasOcupadasPorCategoria[1]--;
	                        cont = 0;
	                    } else if (categoria == 2) {
	                        // Atendimento a um Sargento
	                    	//System.out.println("Atendimento a um Sargento");
	                    	tempoTotalEsperaPorCategoria[2] += System.currentTimeMillis() - tempoEsperaPorCategoria[2];
	                        TempoDeCorte = rand.nextInt((4000) + 2000);
	                        cadeirasOcupadasPorCategoria[2]--;
	                        cont = 0;
	                    } else if (categoria == 3) {
	                        // Atendimento a um Cabo
	                    	//System.out.println("Atendimento a um Cabo");
	                    	tempoTotalEsperaPorCategoria[3] += System.currentTimeMillis() - tempoEsperaPorCategoria[3];
	                        TempoDeCorte = rand.nextInt((3000) + 1000);
	                        cadeirasOcupadasPorCategoria[3]--;
	                        cont = 0;
	                    } else if (categoria == 0) {
	                        // Hove uma pausa! com tempo já definido entre 3 e 4 segundos.
	                    	//System.out.println("Houve uma pausa");
	                    	tempoTotalEsperaPorCategoria[0] += System.currentTimeMillis() - tempoEsperaPorCategoria[0];
	                        TempoDeCorte = rand.nextInt((4000) + 3000);
	                        cadeirasOcupadasPorCategoria[0]--;
	                        cont = 0;
	                    } else {
	                        // Em caso de filas vazias o tempo de corte também fica entre 3 e 4 segundos
	                    	//System.out.println("Filas vazias");
	                        TempoDeCorte = rand.nextInt((4000) + 3000);
	                        cont++;
	                    }
	                    if (categoria!=-1) {
		                    numAtendimentosPorCategoria[categoria]++;
		                    tempoTotalAtendimentoPorCategoria[categoria] += TempoDeCorte;
	                    }
	                    // Impressão da categoria do cliente atendido pelo Recruta Zero
	                    //System.out.println("Recruta Zero atendeu um cliente: " + getCategoriaString(categoria));
	                    // Tempo de atendimento simulado
	                    Thread.sleep(rand.nextInt(TempoDeCorte));
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        });

	        // Thread do Tenente Escovinha RELATÓRIO
	        Thread tenenteThread = new Thread(() -> {
	            int dia = 0;
	         // Variáveis para rastrear o comprimento médio das filas
	            int comprimentoFilaOficiais = 0;
	            int comprimentoFilaSargentos = 0;
	            int comprimentoFilaCabos = 0;
	            int comprimentoFilaPausas = 0;
	            int numVerificacoes = 0;
	            
	            while (dia < 1000) { // Executa a cada 1000 interações do Sargento Tainha
	                dia++;
	                try {
	                    Thread.sleep(3000); // Espera 3 segundos
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }

	                // Cálculos das estatísticas
	                // Atualizar os comprimentos das filas a cada verificação
	                comprimentoFilaOficiais += filaEsperaOficiais.size();
	                comprimentoFilaSargentos += filaEsperaSargentos.size();
	                comprimentoFilaCabos += filaEsperaCabos.size();
	                comprimentoFilaPausas += filaEsperaPausas.size();
	                numVerificacoes++;
	                
	                // Calcular o comprimento médio das filas
	                double mediaComprimentoFilaOficiais = (double) comprimentoFilaOficiais / numVerificacoes;
	                double mediaComprimentoFilaSargentos = (double) comprimentoFilaSargentos / numVerificacoes;
	                double mediaComprimentoFilaCabos = (double) comprimentoFilaCabos / numVerificacoes;
	                double mediaComprimentoFilaPausas = (double) comprimentoFilaPausas / numVerificacoes;
	                
	                //Calcular o percentual de ocupação das cadeiras
	                double percentualOcupacaoOficiais = (double) (cadeirasOcupadasPorCategoria[1] * 100) / numCadeiras;
	                double percentualOcupacaoSargentos = (double) (cadeirasOcupadasPorCategoria[2] * 100) / numCadeiras;
	                double percentualOcupacaoCabos = (double) (cadeirasOcupadasPorCategoria[3] * 100) / numCadeiras;
	                double percentualOcupacaoPausas = (double) (cadeirasOcupadasPorCategoria[0] * 100) / numCadeiras;
	                double percentualCadeirasLivres = (double) ((numCadeiras - (cadeirasOcupadasPorCategoria[1] + cadeirasOcupadasPorCategoria[2] + cadeirasOcupadasPorCategoria[3] + cadeirasOcupadasPorCategoria[0])) * 100) / numCadeiras;


	                // Impressão do relatório (exemplo)
	                System.out.println("\n\nRelatório do Tenente Escovinha - Dia " + dia);
	                // Imprimir percentual de ocupação por categoria e cadeiras livres
	                System.out.println("Estado de ocupação das cadeiras:");
	                System.out.println("Categoria 0 - pausas:" + percentualOcupacaoPausas + "%");
	                System.out.println("Categoria 1 - Oficiais:" + percentualOcupacaoOficiais+ "%");
	                System.out.println("Categoria 2 - Sargentos:" + percentualOcupacaoSargentos+ "%");
	                System.out.println("Categoria 3 - Cabos:" + percentualOcupacaoCabos+ "%");
	                System.out.println("Cadeiras livres:" + percentualCadeirasLivres+ "%");
	                // Imprimir comprimento médio das filas
	                System.out.println("\nComprimento médio das filas:");
	                System.out.println("Categoria 0 - pausas:" + mediaComprimentoFilaPausas);
	                System.out.println("Categoria 1 - Oficiais:" + mediaComprimentoFilaOficiais);
	                System.out.println("Categoria 2 - Sargentos:" + mediaComprimentoFilaSargentos);
	                System.out.println("Categoria 3 - Cabos:" + mediaComprimentoFilaCabos);
	                // Imprimir tempo médio de atendimento por categoria
	                if (numAtendimentosPorCategoria[0]!=0 && numAtendimentosPorCategoria[1]!=0 && numAtendimentosPorCategoria[2]!=0 && numAtendimentosPorCategoria[3]!=0) {
		                System.out.println("\nTempo médio de atendimento por categoria: (em segundos)");
		                System.out.println("Categoria 0 - pausas:" + (tempoTotalAtendimentoPorCategoria[0]/1000)/numAtendimentosPorCategoria[0]);
		                System.out.println("Categoria 1 - Oficiais:" + (tempoTotalAtendimentoPorCategoria[1]/1000)/numAtendimentosPorCategoria[1]);
		                System.out.println("Categoria 2 - Sargentos:" + (tempoTotalAtendimentoPorCategoria[2]/1000)/numAtendimentosPorCategoria[2]);
		                System.out.println("Categoria 3 - Cabos:" + (tempoTotalAtendimentoPorCategoria[3]/1000)/numAtendimentosPorCategoria[3]);
		                
		                // Imprimir tempo médio de espera por categoria
		                System.out.println("\nTempo médio de espera por categoria: (em segundos)");
		                System.out.println("Categoria 0 - pausas:" + (tempoTotalEsperaPorCategoria[0]/1000)/numAtendimentosPorCategoria[0]);
		                System.out.println("Categoria 1 - Oficiais:" + (tempoTotalEsperaPorCategoria[1]/1000)/numAtendimentosPorCategoria[1]);
		                System.out.println("Categoria 2 - Sargentos:" + (tempoTotalEsperaPorCategoria[2]/1000)/numAtendimentosPorCategoria[2]);
		                System.out.println("Categoria 3 - Cabos:" + (tempoTotalEsperaPorCategoria[3]/1000)/numAtendimentosPorCategoria[3]);
	                }
	                // Imprimir número de atendimentos por categoria
	                System.out.println("\nNúmero de atendimentos por categoria:");
	                System.out.println("Categoria 0 - pausas:" + numAtendimentosPorCategoria[0]);
	                System.out.println("Categoria 1 - Oficiais:" + numAtendimentosPorCategoria[1]);
	                System.out.println("Categoria 2 - Sargentos:" + numAtendimentosPorCategoria[2]);
	                System.out.println("Categoria 3 - Cabos:" + numAtendimentosPorCategoria[3]);
	                // Imprimir número total de clientes por categoria
	                System.out.println("\nNúmero total de clientes por categoria:");
	                System.out.println("Categoria 0 - pausas:" + numClientesPorCategoria[0]);
	                System.out.println("Categoria 1 - Oficiais:" + numClientesPorCategoria[1]);
	                System.out.println("Categoria 2 - Sargentos:" + numClientesPorCategoria[2]);
	                System.out.println("Categoria 3 - Cabos:" + numClientesPorCategoria[3]);
	                // ...

	                // Reinicializar as estatísticas para o próximo dia
	                // ...
	            }
	        });
	        
	        // Iniciar as threads
	        sargentoThread.start();
	        barbeiroZero.start();
	        tenenteThread.start();
	    }

	    // Método para atender um cliente
	    public static int atenderCliente(Semaphore mutex, Queue<Integer> filaEsperaOficiais,
	    		Queue<Integer> filaEsperaSargentos, Queue<Integer> filaEsperaCabos, Queue<Integer> filaEsperaPausas) throws InterruptedException {
	        mutex.acquire();
	        int categoria = -1; // Inicializa a categoria como -1 (nenhum cliente)

	        // Verifica se há oficiais esperando
	        if (!filaEsperaOficiais.isEmpty()) {	
	        	categoria = 1; // Oficial
	            filaEsperaOficiais.poll();
	            
	        }

	        // Verifica se há sargentos esperando
	        else if (!filaEsperaSargentos.isEmpty()) {
	        	filaEsperaSargentos.poll();
	        	categoria = 2; // Sargento
	        }

	        // Verifica se há cabos esperando
	        else if (!filaEsperaCabos.isEmpty()) {
	        	filaEsperaCabos.poll();
	            categoria = 3; // Cabo
	        }

	        // Verifica se há pausas esperando
	        else if (!filaEsperaPausas.isEmpty()) {
	        	filaEsperaPausas.poll();
	        	categoria = 0; // Pausa
	        }
	        mutex.release();
	
	        return categoria;
	    }

	    // Método para adicionar um cliente à fila de espera para atendimento
	    public static void adicionarCliente(Semaphore mutex, Semaphore[] filaClientes, Queue<Integer> filaEspera) throws InterruptedException {
	        // Bloquear o acesso à fila de espera
	    	mutex.acquire();
	        try {
	            // Adiciona o cliente à fila de espera
	            filaEspera.add(1);

	            // Libera o semáforo correspondente para indicar que há um cliente na fila
	            filaClientes[0].release();
	        } finally {
	        	// Libera o acesso mútuo 
	            mutex.release();
	        }
	    }

	    // Método onde o usuário define o tempo de cochilo do Sargento Tainha.
	    public static int Entrada() {
	        System.out.println("Defina o tempo de cochilo do Sargento Tainha entre (1) a (5) segundos: ");
	        Scanner scan = new Scanner(System.in);
	        int cochilo1 = scan.nextInt();
	        scan.close();
	        return cochilo1;
	    }

	    // Método para obter a categoria em forma de string
	    	// Obtem o número que representa a categria e retorna a string com o nome da categoria
	    public static String getCategoriaString(int categoria) {
	    	//System.out.println("getCategoria "+categoria);
	        switch (categoria) {
	            case 0:
	                return "Pausa";
	            case 1:
	                return "Oficial";
	            case 2:
	                return "Sargento";
	            case 3:
	                return "Cabo";
	            case -1:
	                return "Filas vazias!";
	            default:
	                return "Desconhecida";
	        }
	    }
	    
	    // Método para somar os valores presentes em um vetor
	    public static int somaVetor(int[] vetor) {
	    	int soma=0;
			for(int i=0;i<vetor.length;i++) {
				soma += vetor[i];
			}
			return soma;
	    }
}

