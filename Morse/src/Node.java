public class Node {
    private char caractere;
    private Node esquerda;
    private Node direita;


    public Node getDireita() {
        return direita;
    }

    public void setDireita(Node direita) {
        this.direita = direita;
    }

    public Node getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public char getInformacao() {
        return caractere;
    }

    public void setInformacao(char informacao) {
        this.caractere = caractere;
    }
}
