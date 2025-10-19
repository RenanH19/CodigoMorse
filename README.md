<h1> Trabalho código Morse </h1>
<h2>Implementação</h2>
<p>Esse projeto tem como objetivo aprimorar o conhecimento e manipulação de árvores binárias utilizando um padrão diferente na inserção e busca de elementos, que será orientado para direita, se for caractere (-), ou para esquerda, se for caractere (.).</p>
<p>Essa implementação tem como base o código morse, desenvolvido inicialmente por Samuel Morse, o qual serviu como base para o funcionamento do telégrafo elétrico, o qual pulsos elétricos curtos transmitem sinais de pontos e pulsos elétricos longos transmitem sinais de traços. </p>
<p>Nessa circunstância, houve uma facilidade na comunicação, utilizando a eletricidade para transmitir sinais e, assim, mitigando o tempo de transmissão.


<h3>Classes</h3>
<p>Para desenvolver essa árvore, foram feitas 3 classes em java: ArvoreMorse, Execucao e Node.</p>
<ul>
<li>Node: é uma classe criada para servir como base para cada nó de nossa árvore. Ela possui 3 atributos e os métodos para manipular esses atributos. O atributo <strong>valor</strong> armazena o caractere correspondente a determinado nó. Os atributos <strong>direita e esquerda</strong> armazenam as respectivas posições para possibilitar o encadeamento</li>
<li>ArvoreMorse: possibilita a criação da estrutura básica da árvore, inicializando-a com a raiz vazia e acoplando os métodos para sua manipulação.</li>
<li>Execucao: instancia a árvore morse e cria uma interface para o usuário manipular a árvore.</li>
</ul>

<h3>Métodos</h3>
<p>Foram criados 6 métodos para manipular a árvore: esvaziar, inicializar, inserirLetra, buscar, removerLetra e exibirHierarquia</p>
<ul>
<li><strong>esvaziar</strong>: apenas reinicializa o nó raiz, removendo todos os outros nós</li>
<li><strong>inicializar</strong>: é o método chamado logo após a instanciação da árvore, ele faz uma inserção prévia dos caracteres com base no seu respectivo código morse.</li>
<li><strong>inserirLetra</strong>: é método que recebe como parâmetro o caractere, o qual será armazenado como atributo <strong>valor</strong> no nó, e o código morse daquela letra. Após isso, o código, que possui tipo String, será convertido para um vetor de caractere, esse vetor será percorrido e cada caractere <strong>ponto(.)</strong> determina o sentido para esquerda, enquanto o caractere traço(-) determina o sentido para a direita. Caso não houver nó, o método cria o nó e, no final, após ter percorrido todo os caracteres, se nada estiver ocupando o atributo <strong>valor</strong>, o método armazena o caractere que recebeu de parâmetro no nó.</li>
<li><strong>buscar</strong>: possui um funcionamento parecido com a inserção, recebendo como parâmetro o código morse. Esse código morse será usado para percorrer a árvore, restringindo o percurso para esquerda, se o caractere for ponto, direita se for traço. O uso de espaço(' ') como parâmetro serve para separar letras, enquanto a barra ('/') serve para separar palavras, acrescentando espaço na string que será exibida como resultado no retorno da função.</li>
<li><strong>removerLetra</strong>: recebe o caractere que quero remover para chamar, por recursividade, o removerLetra que possui diferente assinatura(sobrecarga), levando em consideração o nó atual e anterior. Esse método possui um funcionamento muito simples, ele percorre toda a árvore do tipo pré ordem, ou seja, nós na esquerda, depois direita e depois raiz. Quando encontra o nó correspondente ao caractere, verifica se o nó tem filho, se houver, ele remove o caractere que está no atributo valor do nó e retorna o nó para indicar que houve a remoção. Se não houver filhos, como a função removerLetra recebe o nó anterior e o atual, ela verifica se o nó atual é filho da direita ou esquerda do nó anterior para excluir a referência do nó atual do anterior. </li>
<li><Strong>ExibirHierarquia</Strong>: é um método recursivo que possui 3 parâmetros, o nó, o prefixo e o esquerda, que indica se deve exibir ponto ou traço. O método percorre inicialmente todos os nós da direita por recursividade, após isso, percorre os nós da esquerda. Por isso, a exibição, na hora de escrever as linhas, possui os traços acima e pontos abaixo. Conforme as chamadas aumentam, o prefixo é concatenado com base no prefixo anterior, criando uma ramificação maior em chamadas que estão mais empilhadas. </li>
</ul>

<p> Integrantes: </p>
<p>Renan Americo Herculano</p>
<p>Lucas de Paula</p>
<p>Guilherme Arcanjo</p>
<p>Leandro Pavan</p>