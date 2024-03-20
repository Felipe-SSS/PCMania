public class Computador {

    String marca;
    float preco;
    private final HardwareBasico processador;
    private HardwareBasico memoriaRAM;
    private HardwareBasico armazenamento;
    private SistemaOperacional sistemaOperacional;
    private MemoriaUSB memoriaUSB_pc;

    public Computador(String marca, float preco, HardwareBasico processador, HardwareBasico memoriaRAM, HardwareBasico armazenamento, SistemaOperacional sistemaOperacional) {
        this.marca = marca;
        this.preco = preco;
        this.processador = processador;
        this.memoriaRAM = memoriaRAM;
        this.armazenamento = armazenamento;
        this.sistemaOperacional = sistemaOperacional;
    }

    void mostraPCConfigs(){

        System.out.println("Marca --> "+this.marca);
        System.out.println("Processador --> "+this.processador.nome+" ("+this.processador.capacidade+" Mhz)");
        System.out.println("Memória RAM --> "+this.memoriaRAM.capacidade+" GB");

        if (this.armazenamento.capacidade < 10){
            System.out.println("Armazenamento --> "+this.armazenamento.capacidade+" Tb de HDD");
        }
        else{
            System.out.println("Armazenamento --> "+this.armazenamento.capacidade+" Gb de HDD");
        }

        System.out.println("Sistema operacional --> "+this.sistemaOperacional.nome+" ("+this.sistemaOperacional.tipo+" bits)");

        System.out.println("Preço --> R$ "+this.preco);

        if (memoriaUSB_pc.capacidade > 2){
            System.out.println("EXTRA!!! Acompanha "+memoriaUSB_pc.nome+" de "+memoriaUSB_pc.capacidade+"Gb!");
        }
        else{
            System.out.println("EXTRA!!! Acompanha "+memoriaUSB_pc.nome+" de "+memoriaUSB_pc.capacidade+"Tb!");
        }

        System.out.println();
    }

    void addMemoriaUSB(MemoriaUSB memoriaUSB){
        memoriaUSB_pc = memoriaUSB;
    }

}
