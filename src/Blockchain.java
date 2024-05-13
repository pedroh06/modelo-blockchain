import java.util.ArrayList;

class Blockchain {
    private ArrayList<Block> blockchain;

    public Blockchain() {
        blockchain = new ArrayList<>();
        blockchain.add(new Block(0, "0", "Charles Ygara", -1.5029129751802872, -48.44701669211251));
    }

    public Block getLastBlock() {
        return blockchain.get(blockchain.size() - 1);
    }

    public void addBlock(String data) {
        Block previousBlock = getLastBlock();
        int newIndex = previousBlock.getIndex() + 1;
        blockchain.add(new Block(newIndex, previousBlock.getHash(), data));
    }

    public boolean isChainValid() {
        for (int i = 1; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);

            if (!currentBlock.getHash().equals(currentBlock.generateHash())) {
                System.out.println("Hash inválido para o bloco " + i);
                return false;
            }

            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                System.out.println("Hash anterior inválido para o bloco " + i);
                return false;
            }
        }
        return true;
    }

    public ArrayList<Block> getBlockchain() {
        return blockchain;
    }
}