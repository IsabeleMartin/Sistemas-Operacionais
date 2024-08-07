import java.util.*;
import java.io.*; // Biblioteca para entrada e saída de arquivos

public class TrocaPagina {
    public static void main(String[] args) {
        System.out.println("O tamanho do vetor é igual a 900 e pode ser mudado na linha 9 \n"
                + "Os dados de entrada podem ser inseridos no arquivo txt, lembrando que o modelo dado foi o seguinte 1-0 1-1 2-0 1-1 2-1 3-0 1-3 0-0.\n");

        int tamVetMen = 5; // tamanho do vetor da memória

        // Leitura do arquivo entradas.txt
        String stringDeEntradas = lerArquivo("entradas.txt");

        int paginaFaultsFifo = executaFIFO(stringDeEntradas, tamVetMen); // Método para chamar o algoritmo FIFO
        System.out.println("FIFO Pagina Faults: " + paginaFaultsFifo);

        int paginaFaultsLRU = executaLRU(stringDeEntradas, tamVetMen); // Método para chamar o algoritmo LRU
        System.out.println("LRU Pagina Faults: " + paginaFaultsLRU);

        int paginaFaultsSecondChance = executaSecondChance(stringDeEntradas, tamVetMen); // Método para chamar o algoritmo Second Chance
        System.out.println("Second Chance Pagina Faults: " + paginaFaultsSecondChance);
    }

    // Método para ler o conteúdo de um arquivo e retornar como string
    public static String lerArquivo(String nomeArquivo) {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conteudo.toString();
    }

    // Método do algoritmo LRU
    public static int executaLRU(String referenceString, int memSize) {
        int paginaFaults = 0; // seta o número de faltas de página para 0
        List<Memoria> memory = new ArrayList<>(); // cria uma Lista para a memória

        String[] references = referenceString.split(";");
        for (String ref : references) {
            String[] parts = ref.split(",");
            int processo = Integer.parseInt(parts[0]);
            int pagina = Integer.parseInt(parts[1]);

            if (processo == 0 && pagina == 0) {
                continue;
            }

            Memoria entry = new Memoria(processo, pagina);
            boolean paginaFound = false;

            // Verificar se a página já está na memória
            for (Memoria Memoria : memory) {
                if (Memoria.processo == processo && Memoria.pagina == pagina) {
                    Memoria.menosUsada = 0;
                    paginaFound = true;
                } else {
                    Memoria.menosUsada++;
                }
            }

            // Se a página não foi encontrada, adicione-a à memória
            if (!paginaFound) {
                paginaFaults++;
                if (memory.size() >= memSize) {
                    // Encontrar a página menos recentemente usada (LRU)
                    Memoria lruPagina = Collections.max(memory, Comparator.comparingInt(e -> e.menosUsada));
                    memory.remove(lruPagina);
                }
                memory.add(entry);
            }
        }

        return paginaFaults;
    }

    // Método do algoritmo FIFO
    public static int executaFIFO(String referenceString, int memSize) {
        int paginaFaults = 0; // seta o número de faltas de página para 0
        Memoria[] memory = new Memoria[memSize]; // cria um vetor de Memoria
        int currentIndex = 0; // contadores para fazer as substituições
        int older = 0; // contadores para fazer as substituições

        String[] references = referenceString.split(";"); // cria um vetor de Strings para separar as entradas da string de referência
        List<Memoria> referenceQueue = new ArrayList<>();

        for (String ref : references) {
            String[] parts = ref.split(",");
            int processo = Integer.parseInt(parts[0]);
            int pagina = Integer.parseInt(parts[1]);

            if (processo == 0 && pagina == 0) {
                continue; // Fim da string de referência
            }

            Memoria newEntry = new Memoria(processo, pagina); // cria um novo objeto Memoria
            boolean paginaFound = false; // seta uma variável booleana para verificar se a página está na memória

            // Verifica se a página já está na memória
            for (Memoria entry : memory) {
                if (entry != null && entry.processo == processo && entry.pagina == pagina) {
                    paginaFound = true;
                    break;
                }
            }

            // Se a página não estiver na memória
            if (!paginaFound) {
                while (true) {
                    if (currentIndex < memSize) { // verifica se o índice é menor que o tamanho da memória
                        if (memory[currentIndex] == null) { // verifica se encontrou algum objeto nulo da lista de Memoria
                            memory[currentIndex] = newEntry;
                            referenceQueue.add(newEntry);
                            paginaFaults++;
                            break;
                        }
                        currentIndex++; // Move o ponteiro para a próxima página
                    } else { // Se o índice é maior ou igual ao tamanho da memória, vai utilizar o contador older para fazer a substituição do mais antigo
                        paginaFaults++;
                        if (older == memSize) {
                            older = 0;
                            removePaginaFromMemory(memory, older);
                            addPaginaToMemory(memory, processo, pagina);
                            referenceQueue.remove(memory[older]);
                            referenceQueue.add(newEntry);
                            older++;
                        } else {
                            removePaginaFromMemory(memory, older);
                            addPaginaToMemory(memory, processo, pagina);
                            referenceQueue.remove(memory[older]);
                            referenceQueue.add(newEntry);
                            older++;
                        }
                        break;
                    }
                }
            }
        }

        return paginaFaults;
    }

    // Método do algoritmo Second Chance
    public static int executaSecondChance(String referenceString, int memSize) {
        int paginaFaults = 0;
        Memoria[] memory = new Memoria[memSize];
        int currentIndex = 0;

        String[] references = referenceString.split(";");
        List<Memoria> referenceQueue = new ArrayList<>();

        for (String ref : references) {
            String[] parts = ref.split(",");
            int processo = Integer.parseInt(parts[0]);
            int pagina = Integer.parseInt(parts[1]);

            if (processo == 0 && pagina == 0) {
                continue; // Fim da string de referência
            }

            Memoria newEntry = new Memoria(processo, pagina);
            boolean paginaFound = false;

            // Verifica se a página já está na memória
            for (Memoria entry : memory) {
                if (entry != null && entry.processo == processo && entry.pagina == pagina) {
                    entry.referenceBit = true; // Define o bit de referência como true
                    paginaFound = true;
                    break;
                }
            }

            // Se a página não estiver na memória
            if (!paginaFound) {
                while (true) {
                    if (memory[currentIndex] == null || !memory[currentIndex].referenceBit) {
                        // Se o bit de referência for falso ou a entrada for nula, substitui a página
                        memory[currentIndex] = newEntry;
                        referenceQueue.add(newEntry);
                        paginaFaults++;
                        break;
                    } else {
                        memory[currentIndex].referenceBit = false; // Define o bit de referência como falso
                        referenceQueue.remove(memory[currentIndex]);
                        referenceQueue.add(memory[currentIndex]);
                    }
                    currentIndex = (currentIndex + 1) % memSize; // Move o ponteiro para a próxima página
                }
            }
        }

        return paginaFaults;
    }

    // Métodos auxiliares para os métodos dos algoritmos
    public static int findMemoryIndex(Memoria[] memory, int processo, int pagina) {
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] != null && memory[i].processo == processo && memory[i].pagina == pagina) {
                return i;
            }
        }
        return -1;
    }

    public static void addPaginaToMemory(Memoria[] memory, int processo, int pagina) {
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == null) {
                memory[i] = new Memoria(processo, pagina);
                return;
            }
        }
    }

    public static void removePaginaFromMemory(Memoria[] memory, int index) {
        memory[index] = null;
    }
}

