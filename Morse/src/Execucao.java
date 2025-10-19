import java.util.Scanner;

public class Execucao {
    public static void main(String[] args) {
        // criar objeto
        ArvoreMorse arvore = new ArvoreMorse();

        // inicializar arvore
        arvore.inicializar();

        // interface usuario
        Scanner teclado = new Scanner(System.in);
        boolean execucao = true;

        System.out.println("SISTEMA DE ÁRVORE BINÁRIA  COM CÓDIGO MORSE");

        do {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("MENU DE OPERAÇÕES:");
            System.out.println("1. Inserção de caractere");
            System.out.println("2. Descriptografar texto em código morse (busca por caractere)");
            System.out.println("3. Remoção de caractere");
            System.out.println("4. Exibir árvore binária morse");
            System.out.println("5. Esvaziar árvore binária morse");
            System.out.println("6. Sair");
            System.out.println("---------------------------------------------------------------------");
            System.out.print("Selecione a operação: ");

            int escolha = teclado.nextInt();
            teclado.nextLine(); // limpar buffer

            switch (escolha) {
                case 1: // inserção de caractere
                    System.out.println("Digite o caractere: ");
                    String caracter = teclado.next(); // coletar letra/numero

                    System.out.println("Digite o código morse relacionado a esse caractere:");
                    String codigo = teclado.next(); // coletar morse

                    System.out.println("\nTentando inserir novo caractere...");
                    arvore.inserirLetra(caracter.charAt(0), codigo); // transformar string da letra em char para o metodo inserirLetra
                    break;

                case 2: // buscar palavra/letra
                    System.out.println("Digite o texto em morse para descriptografar\nUse ' ' para separar letras e use '/' para separar palavras:");
                    String texto = teclado.nextLine();

                    System.out.println("\nDescriptografando texto...");
                    System.out.println("Texto: " + arvore.buscar(texto));
                    break;

                case 3: // remover letra
                    System.out.println("Digite o caractere que deseja remover: ");
                    String caracterRemover = teclado.next(); // coletar caracter

                    System.out.println("\nRemovendo caractere...");
                    arvore.removerLetra(caracterRemover.charAt(0)); // transformar string da letra em char para o metodo removerLetra
                    break;

                case 4: // exibir hierarquia da arvore binaria de morse
                    System.out.println("\nRealizando exibição da árvore binária morse:");
                    arvore.exibirHierarquia();

                    System.out.println();
                    break;

                case 5: // encerrar
                    System.out.println("\nEsvaziando árvore");
                    arvore.esvaziar();

                    System.out.println();
                    break;

                case 6: // encerrar
                    System.out.println("Encerrando programa!");
                    teclado.close();
                    execucao = false;
                    break;
            }
        } while (execucao);
    }
}
