package hashing;

import java.util.HashMap;
import java.util.Map;

public class HashingComPorao implements EstruturaDeDados {
    private final int TAMANHO_TBL = 10;
    private Map<Integer, Integer> tabelaPrincipal;
    private Map<Integer, Integer> porao;

    public HashingComPorao() {
        tabelaPrincipal = new HashMap<>();
        porao = new HashMap<>();
    }

    @Override
    public void insert(int chave) {
        int hash = hash(chave);
        if (!tabelaPrincipal.containsKey(hash)) {
            tabelaPrincipal.put(hash, chave);
        } else {
            porao.put(chave, hash);
        }
    }

    @Override
    public void delete(int chave) {
        int hash = hash(chave);

        if (tabelaPrincipal.containsKey(hash) && tabelaPrincipal.get(hash) == chave) {
            tabelaPrincipal.remove(hash);
        } else {
            porao.remove(chave);
        }
    }

    @Override
    public boolean search(int chave) {
        int hash = hash(chave);

        if (tabelaPrincipal.containsKey(hash) && tabelaPrincipal.get(hash) == chave) {
            return true;
        } else {
            return porao.containsKey(chave);
        }
    }

    private int hash(int chave) {
        return chave % TAMANHO_TBL;
    }
}
