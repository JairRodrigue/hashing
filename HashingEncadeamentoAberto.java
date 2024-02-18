package hashing;

import java.util.LinkedList;

public class HashingEncadeamentoAberto implements EstruturaDeDados {
    private final int TAMANHO_TABELA = 10;
    private LinkedList<Integer>[] tabela;

    public HashingEncadeamentoAberto() {
        tabela = new LinkedList[TAMANHO_TABELA];
        for (int i = 0; i < TAMANHO_TABELA; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    @Override
    public void insert(int chave) {
        int indice = hash(chave);
        tabela[indice].add(chave);
    }

    @Override
    public void delete(int chave) {
        int indice = hash(chave);
        tabela[indice].remove(Integer.valueOf(chave));
    }

    @Override
    public boolean search(int chave) {
        int indice = hash(chave);
        return tabela[indice].contains(chave);
    }

    private int hash(int chave) {
        return chave % TAMANHO_TABELA;
    }
}
