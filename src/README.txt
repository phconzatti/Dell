Instruções para uso:

A aplicação foi desenvolvida em Java, utilizando o IntelliJ. O programa inteiro irá rodar por meio do terminal da IDE.
Para iniciar a execução do programa, deve-se selecionar a Classe "main" e clicar para rodar o código.
No terminal, será exibido um menu com opções numeradas. A aplicação não possui tratamento de exceções, então qualquer informação recebida pelo teclado deve ser um número inteiro ou a execução irá parar.

Selecionando a opção [1], o programa irá solicitar o nome completo e o CPF do apostador. Como essas informações serão recebidas como "Strings" pode ser digitado qualquer caractere. O ideal é que sejam inseridas
informações verdadeiras, pois, na fase de premiação, essas informações serão validadas (mais sobre isso no arquivo Instruções_premios.txt). Após esse passo, serão solicitados cinco números inteiros, um de cada vez, 
que serão os números da aposta. A aplicação foi programada para aceitar apenas números de 1 a 50 e que devem ser diferentes entre si. Se estas condições não forem atendidas, será solicitado que se digite outro número até
que estejam de acordo. Depois de inserir o último número, serão apresentadas as informações pessoais do atual apostador e este poderá verificá-las e confirmar que estão corretas ou corrigi-las. Lembrando que os números 
da aposta devem ser inteiros e a seleção das opções também, qualquer entrada de tipo diferente irá cessar o funcionamento da aplicação. 
Após tudo isso, serão exibidas todas as informações fornecidas, os números apostados e o número de registro da aposta, retornando ao menu principal.

Selecionando a opção [2], o programa irá rodar de maneira similar à opção 1, com a única diferença sendo os números apostados, que, aqui, serão gerados aleatoriamente. Todas as outras etapas permanecem iguais.

Selecionando a opção [3], serão exibidas no terminal as informações de todos as apostar realizadas até o momento, bem como a relação de números apostados e a quantidade de apostas em cada número.

Selecionando a opção [4], por enquanto, realiza apenas o sorteio dos cinco números que formam a combinação vencedora. Não está implementado a comparação das apostas com o resultado e as iterações que aumentam o a quantidade dos números vencedores.

selecionando a opção [0], a aplicação finaliza a sua execução.

==============================================================================================================================================================================================================================================

Funcionamento dos métodos (separados por Classes):

Classe Apostador

O Apostador possui os atributos "nome", "cpf", "aposta", "registro" e "acertos". O atributo acertos não é utilizado pois não foi implementada a solução para computá-los.
Esta classe possui o construtor, que tem como parâmetros o "nome", o "cpf" e a "aposta".
Métodos setter e getters de todos os atributos presentes e o toString.

Classe Aposta

A Aposta tem como atributos um ArrayList de Apostadores e o "cont".
O construtor inicializa o ArrayList.
O método "realizarAposta" recebe um Apostador como parâmetro, determina o seu número de registro, adiciona o Apostador ao ArrayList e incrementa o "cont".
O método "consultarDados" verifica se há Apostadores no ArrayList e, tendo, irá percorrer todas as posições imprimindo as informações de todos os objetos.
O método "compararAposta" serve para retornar um ArrayList de Apostadores com a finalidade de, no futuro, comparar os números apostados com os números sorteados.
Classe Numeros

Esta classe possui os atributos "valor" e "cont".
Os métodos implementados foram apenas os getters e setters e os atributos são públicos, pois esta classe foi criada para ser "auxiliar", isto é, serve somente para ajudar na contagem dos números apostados e quantas vezes eles aparecem.

Classe Resultado

Foi criada para inicializar um array que receberia os números do sorteados.
Possui construtor, getters, setters e toString.

Classe Main

Foi criada apenas para iniciar a execução da aplicação, possuindo apenas o método "main" e executando o que foi determinado na Classe App.

Classe App

Esta Classe instancia uma Aposta, o Scanner, o Random e um ArrayList de números inteiros.
Tem o método "executar" que controla a execução do menu e o momento de execução dos outros métodos.
O "menu" imprime a parte visual do menu principal.
A "apostaNormal" é a que vai receber todas as informações necessárias para realizar uma aposta, instanciar um Apostador e inserir este na Aposta. Além de inserir os números apostados em um ArrayList que será utilizado posteriormente para a contagem dos números apostados.
A "apostaSurpresa" funciona da mesma maneira que a "apostaNormal", mas não requer a escolha dos números de aposta, pois estes são gerados automaticamente. Além de inserir os números apostados em um ArrayList que será utilizado posteriormente para a contagem dos números apostados.
O "sorteio", até o momento, realiza apenas o sorteio de cinco números. A comparação com as "apostas" dos Apostadores não foi implementada.
O "contagemNum" recebe, como parâmetro, um ArrayList de inteiros (que consiste no conjunto de números apostados) e instancia objetos da Classe Numeros e adicona eles a um ArrayList de Numeros. Depois, compara a ocorrência dos números de 1 a 50 e imprime todos os números com a quantidade de ocorrências, começando pelo que mais aparece até os que menos, ou não aparecem.
O “sorteio” vai definir quais serão os números sorteados e realizará as comparações entre as apostas realizadas e os números sorteados. Define os vencedores e quantos venceram. A comparação entre os números é feita por meio de buscas lineares nos vetores necessários.