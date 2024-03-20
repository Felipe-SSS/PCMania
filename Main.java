import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        // Cria um novo cliente
        Cliente cliente = new Cliente();

        System.out.println();
        System.out.println("Bem vindo!");
        System.out.println();
        System.out.println("Para iniciarmos, insira seu nome e CPF para te cadastrarmos no sistema.");
        System.out.println();

        Scanner input = new Scanner(System.in);

        System.out.print("Nome: ");
        cliente.nome = input.nextLine();

        System.out.print("CPF: ");
        cliente.cpf = input.nextLong();

        System.out.println();
        System.out.println("---------------------------------------------");

        // Declara valor total de PCs disponíveis
        int totalPCs = 3;
        int limiteCompra = 11;


        // Cria objetos que contém as informações de Hardware dos PCs

        // Ubuntosvaldo --> Promoção 1
        // Windolson --> Promoção 2
        // Windonelson --> Promoção 3

        HardwareBasico processador_ubuntosvaldo = new HardwareBasico();
        HardwareBasico processador_windolson = new HardwareBasico();
        HardwareBasico processador_windonelson = new HardwareBasico();

        processador_ubuntosvaldo.nome = "Pentium Core i3";
        processador_windolson.nome = "Pentium Core i5";
        processador_windonelson.nome = "Pentium Core i7";

        processador_ubuntosvaldo.capacidade = 2200;
        processador_windolson.capacidade = 3370;
        processador_windonelson.capacidade = 4500;

        HardwareBasico memoriaRAM_ubuntosvaldo = new HardwareBasico();
        HardwareBasico memoriaRAM_windolson = new HardwareBasico();
        HardwareBasico memoriaRAM_windonelson = new HardwareBasico();

        memoriaRAM_ubuntosvaldo.nome = "Memória RAM";
        memoriaRAM_windolson.nome = "Memória RAM";
        memoriaRAM_windonelson.nome = "Memória RAM";

        memoriaRAM_ubuntosvaldo.capacidade = 8;
        memoriaRAM_windolson.capacidade = 16;
        memoriaRAM_windonelson.capacidade = 32;

        HardwareBasico armazenamento_ubuntosvaldo = new HardwareBasico();
        HardwareBasico armazenamento_windolson = new HardwareBasico();
        HardwareBasico armazenamento_windonelson = new HardwareBasico();

        armazenamento_ubuntosvaldo.nome = "HDD";
        armazenamento_windolson.nome = "HDD";
        armazenamento_windonelson.nome = "HDD";

        armazenamento_ubuntosvaldo.capacidade = 500;
        armazenamento_windolson.capacidade = 1;
        armazenamento_windonelson.capacidade = 2;

        SistemaOperacional os_ubuntosvaldo = new SistemaOperacional();
        SistemaOperacional os_windolson = new SistemaOperacional();
        SistemaOperacional os_windonelson = new SistemaOperacional();

        os_ubuntosvaldo.nome = "Linux Ubuntu";
        os_windolson.nome = "Windows 8";
        os_windonelson.nome = "Windows 10";

        os_ubuntosvaldo.tipo = 32;
        os_windolson.tipo = 64;
        os_windonelson.tipo = 64;

        // Cria um array de computadores de acordo com o total de PCs disponíveis
        Computador[] computadores = new Computador[totalPCs];

        // Atribui às posições do vetor as especificações declaradas anteriormente

        /* Ubuntosvaldo */ computadores[0] = new Computador("Positivo", 3300, processador_ubuntosvaldo, memoriaRAM_ubuntosvaldo, armazenamento_ubuntosvaldo, os_ubuntosvaldo);
        /* Windolson */ computadores[1] = new Computador("Acer", 8800, processador_windolson, memoriaRAM_windolson, armazenamento_windolson, os_windolson);
        /* Windonelson */ computadores[2] = new Computador("Vaio", 4800, processador_windonelson, memoriaRAM_windolson, memoriaRAM_windonelson, os_windonelson);

        System.out.println();
        System.out.println("Bem vindo "+cliente.nome+"!");
        System.out.println();
        System.out.println("Confira abaixo o catálogo de PCs para compra!");
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();
        System.out.println("* PC's na promoção *");
        System.out.println();

        MemoriaUSB memoriaUSB_ubuntosvaldo = new MemoriaUSB();
        MemoriaUSB memoriaUSB_windolson = new MemoriaUSB();
        MemoriaUSB memoriaUSB_windonelson = new MemoriaUSB();

        memoriaUSB_ubuntosvaldo.nome = "Pen-drive";
        memoriaUSB_windolson.nome = "Pen-drive";
        memoriaUSB_windonelson.nome = "HD Externo";

        memoriaUSB_ubuntosvaldo.capacidade = 16;
        memoriaUSB_windolson.capacidade = 32;
        memoriaUSB_windonelson.capacidade = 1;

        computadores[0].addMemoriaUSB(memoriaUSB_ubuntosvaldo);
        computadores[1].addMemoriaUSB(memoriaUSB_windolson);
        computadores[2].addMemoriaUSB(memoriaUSB_windonelson);

        // Exibe especificações dos PCs e seu número de promoção
        for (int i = 0; i < totalPCs; i++) {

            System.out.println("-- Promoção "+(i+1)+ " --");
            computadores[i].mostraPCConfigs();
        }

        System.out.println("---------------------------------------------");
        System.out.println();
        System.out.println("Se deseja comprar algum dos computadores, digite o número da promoção abaixo. Caso não queira comprar nada ou finalizar a compra, digite 0.");

        System.out.print("Digite aqui: ");

        // Usuário pode fazer até no máximo 10 compras de uma vez

        // Preço dos computadores a serem comprados
        float[] valoresCompra = new float[limiteCompra];

        // Index das promoções a serem compradas
        int[] compras = new int[limiteCompra];

        // Inicia inserção de comras do usuário
        int promoInt = input.nextInt();
        int aux = 0;

        while (promoInt != 0 && aux < limiteCompra){
            compras[aux] = promoInt-1;
            valoresCompra[aux] = computadores[promoInt-1].preco;
            aux++;
            System.out.println("Computador da marca "+computadores[promoInt-1].marca+" adicionado ao carrinho!");
            System.out.println();
            System.out.println();

            if (aux == limiteCompra-1){
                System.out.println("Total de compras alcançado!");
                System.out.println();
                break;
            }

            System.out.print("Digite aqui: ");
            promoInt = input.nextInt();
        }

        System.out.println();

        // Caso o usuário não compre nada
        if (valoresCompra[0] == 0.0) {
            System.out.println("Que pena que você não comprou nada. :(");
            System.out.println();
            System.out.println("Volte sempre!");
        }

        // Caso ele compre
        else{

            System.out.println("---------------------------------------------");
            System.out.println();

            System.out.println("Cliente: "+cliente.nome);
            System.out.println("CPF do Cliente: "+cliente.cpf);
            System.out.println();

            System.out.println("Produtos adquiridos: ");
            System.out.println();

            int aux1 = 0;

            // Mostra produtos adicionados ao carrinho
            for (int i = 0; i < aux; i++) {
                System.out.println("PC adicionado ao carrinho:");
                aux1 = compras[i];
                computadores[aux1].mostraPCConfigs();
            }

            // Calcula valor total e exibe
            System.out.println("Total a ser pago: R$ "+cliente.calculaTotalCompra(valoresCompra));
        }

    }
}
