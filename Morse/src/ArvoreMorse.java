public class ArvoreMorse {
    private Node raiz; // armazena a raiz da árvore

    //metodo para esvaziar arvore
    public void esvaziar(){
        this.raiz = new Node(' ');
    }

    // inicializar raiz da árvore
    public void inicializar() {
        this.raiz = new Node(' ');

        // inserções
        // 1º nível
        inserirLetra('e', ".");
        inserirLetra('t', "-");

        // 2º nível
        inserirLetra('i', "..");
        inserirLetra('a', ".-");
        inserirLetra('n', "-.");
        inserirLetra('m', "--");

        // 3º nível
        inserirLetra('s', "...");
        inserirLetra('u', "..-");
        inserirLetra('r', ".-.");
        inserirLetra('w', ".--");
        inserirLetra('d', "-..");
        inserirLetra('k', "-.-");
        inserirLetra('g', "--.");
        inserirLetra('o', "---");

        // 4º nível
        inserirLetra('h', "....");
        inserirLetra('v', "...-");
        inserirLetra('f', "..-.");
        inserirLetra('l', ".-..");
        inserirLetra('p', ".--.");
        inserirLetra('j', ".---");
        inserirLetra('b', "-...");
        inserirLetra('x', "-..-");
        inserirLetra('c', "-.-.");
        inserirLetra('y', "-.--");
        inserirLetra('z', "--..");
        inserirLetra('q', "--.-");

        // 5º nível
        inserirLetra('5', ".....");
        inserirLetra('4', "....-");
        inserirLetra('3', "...--");
        inserirLetra('2', "..---");
        inserirLetra('+', ".-.-.");
        inserirLetra('1', ".----");
        inserirLetra('6', "-....");
        inserirLetra('=', "-...-");
        inserirLetra('/', "-..-.");
        inserirLetra('7', "--...");
        inserirLetra('8', "---..");
        inserirLetra('9', "----.");
        inserirLetra('0', "-----");
    }

    public Node obterRaiz() {
        return this.raiz;
    }

    // inserirLetra('a", ".-");
    public void inserirLetra(char letra, String codigo) {
        // criar referencia para caminhar na árvore
        Node atual = raiz;

        // caminhar na árvore para inserir caracter
        for (char simbolo : codigo.toCharArray()) {

            // se for um ponto, caminha para a esquerda
            if (simbolo == '.') {
                if (atual.obterEsquerda() == null) {
                    atual.inserirEsquerda(new Node(' ')); // criar um nó para a posição
                }
                atual = atual.obterEsquerda();
            }
            // se for um traço, caminha para a direita
            else if (simbolo == '-') {
                if (atual.obterDireita() == null) {
                    atual.inserirDireita(new Node(' ')); // criar um nó para a posição
                }
                atual = atual.obterDireita();
            }
        }

        // quando terminar de caminhar pelo código, insere a letra caso não tenha caractere ocupando aquele nó
        if (atual.obterValor() == ' '){
            atual.inserirValor(letra);
            System.out.println("Caractere " + letra + " (" + codigo + ") inserido!");
            return;
        }
        System.out.println("Há um caractere ocupando esse nó, remova-o para inserir uma nova letra");

    }

    // buscar caracter na árvore -> arvore.buscar("... --- ...") # saida: SOS
    public String buscar(String codigo) {
        // criar referencia da raíz para caminhar na árvore
        Node atual = raiz;

        // Criar vetor para armazenar a palavra
        String resultado = "";

        for (char simbolo : codigo.toCharArray()) {
            // se for um ponto, caminha para a esquerda
            if (simbolo == '.') {
                atual = atual.obterEsquerda();
            }
            // se for um traço, caminha para a direita
            if (simbolo == '-') {
                atual = atual.obterDireita();
            }
            // se for um espaço, formamos uma letra
            if (simbolo == ' ') {
                // verifica se a letra existe
                if (atual.obterValor() == ' ' && atual != raiz) {
                    return "\nErro: letra/numero faltando no sistema\nfrase formada: " + resultado;
                }

                // concatena o valor do caracter na posição atual, se não for a raiz
                if (atual != raiz) {
                    resultado += atual.obterValor();
                }

                // reseta o atual para a próxima letra
                atual = raiz;
            }

            // se for uma barra, é uma nova palavra
            if (simbolo == '/') {
                // verifica se a letra existe
                if (atual.obterValor() == ' ' && atual != raiz) {
                    return "\nErro: letra/numero faltando no sistema\nfrase formada: " + resultado;
                }

                // concatena o valor do caracter na posição atual, se não for a raiz
                if (atual != raiz) {
                    resultado += atual.obterValor();
                }

                // reseta o atual para a próxima letra
                atual = raiz;
                resultado += ' ';
            }

            // caso não exista o nó, termina a execução
            if (atual == null) {
                return "\nErro: Nó nulo\nfrase formada: " + resultado;
            }
        }
        // concate o último caracter se não for um espaço vazio
        if (atual.obterValor() == ' ') {
            return "\nErro: letra/numero faltando no sistema\nfrase formada: " + resultado;
        }
        resultado += atual.obterValor();

        // retorna a palavra/letra
        return resultado;
    }

    // remover um caracter da árvore
    public void removerLetra(char letra) {
        Node no = removerLetra(raiz, raiz, letra);

        if (no == null) {
            System.out.println("Letra/numero não encontrada");
        }
        else { // significa que o retorno foi algum nó atual que em nossa recursividade correspondeu a letra desejada

            System.out.println("Letra/numero '" + letra + "' removida com sucesso");
        }
    }

    public Node removerLetra(Node atual, Node anterior, char letra) {

        //condição de parada para que não chegue nas linhas de esquerda ou direita e fique chamando o removerLetra
        if (atual == null) {
            return null;
        }

        // busca pré-ordem
        // verificar se encontrou a letra
        if (atual.obterValor() == letra) {
            if (atual.obterDireita() == null && atual.obterEsquerda() == null) {
                System.out.println("Nó " + letra + " não possui filhos, removendo nó...");

                if(anterior.obterEsquerda() == atual) anterior.inserirEsquerda(null);
                if(anterior.obterDireita() == atual) anterior.inserirDireita(null);
            } else {
                System.out.println("Nó "+ letra +" possui filhos.\nRemovendo apenas seu valor...");
                atual.inserirValor(' ');
            }

            return atual;
        }

        //recursão
        //verifica esquerda
        Node esquerda = removerLetra(atual.obterEsquerda(), atual, letra);
        if (esquerda != null) {
            return esquerda;
        }

        // verifica direita
        Node direita = removerLetra(atual.obterDireita(), atual, letra);
        if (direita != null) {
            return direita;
        }

        return null; // caso não tenha encontrado nada
    }


    public void exibirHierarquia() {
        if (raiz != null) {
            System.out.println("[ ]");

            exibirHierarquia(raiz.obterDireita(), "", true);
            exibirHierarquia(raiz.obterEsquerda(), "", false);
        }
    }

    public void exibirHierarquia(Node no, String prefixo, boolean esquerda) {
        if (no != null) {
            // impressão do valor junto ao prefixo
            System.out.print(prefixo); // imprimir prefixo

            if (esquerda) { // imprimir conector caso tenha esquerda ou não
                System.out.print("├─── (-)");
            } else {
                System.out.print("└─── (.)");
            }

            System.out.println("[" + no.obterValor() + "]"); // imprimir valor

            // criar novo prefixo para próxima impressão
            String novoPrefixo;
            if (esquerda) {
                novoPrefixo = prefixo + "│      "; //concatenando o prefixo com base nos prefixos anteriores
            } else {
                novoPrefixo = prefixo + "       ";
            }


            // verificar se existe nós na esquerda e na direita
            esquerda = no.obterEsquerda() != null;
            boolean direita = no.obterDireita() != null;

            // chamada recursiva caso existam os nós
            if(direita) { //se tem nó na direita, o esquerda que vai imprimir o (-)
                exibirHierarquia(no.obterDireita(), novoPrefixo, esquerda);
            }

            if (esquerda) {
                exibirHierarquia(no.obterEsquerda(), novoPrefixo, false);
            }
        }
    }
}
