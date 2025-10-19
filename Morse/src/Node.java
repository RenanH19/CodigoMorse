public class Node {
    private char valor;
    private Node direita;
    private Node esquerda;

    public Node (char valor) {
        this.valor = valor;
        this.direita = null;
        this.esquerda = null;
    }

    public void inserirValor(char valor) {
        this.valor = valor;
    }

    public void inserirEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public void inserirDireita(Node direita) {
        this.direita = direita;
    }

    public char obterValor() {
        return this.valor;
    }

    public Node obterEsquerda() {
        return this.esquerda;
    }

    public Node obterDireita() {
        return this.direita;
    }
}
