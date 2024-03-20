public class Cliente {

    String nome;
    long cpf;

    float calculaTotalCompra(float[] valores){

        float total = 0;

        for(float valor : valores){
            total += valor;
        }

        return total;
    }

}
