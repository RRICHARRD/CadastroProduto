package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Produto;

public class Main 
{

	public static void main(String[] args) 
	{
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		int quantidadeCadastros; //VARIÁVEL DE ESCOPO GLOBAL, USO ELA ALÉM DO ESCOPO LOCAL DE BAIXO
		do
		{
			System.out.print("DIGITE A QUANTIDADE DE CADASTROS: ");		
			quantidadeCadastros = input.nextInt();
			input.nextLine();//RESOLVENDO UM PROBLEMA DE QUEBRA DE LINHA
				if (quantidadeCadastros <= 0)
				{
					System.out.println();
					System.out.println("FAVOR DIGITE UM NÚMERO MAIOR DO QUE ZERO");
					System.out.println();
				}
		} while (quantidadeCadastros <= 0);	
		
		//MODIFICANDO A MENSAGEM PARA ESCREVER NO PLURAL OU NO SINGULAR
		if (quantidadeCadastros == 1)
		{
			System.out.println();
			System.out.printf("VOCÊ REALIZARÁ %d CADASTRO", quantidadeCadastros);
			System.out.println();
		}
		else 
		{
			System.out.println();
			System.out.printf("VOCÊ REALIZARÁ %d CADASTROS", quantidadeCadastros);
			System.out.println();
		}
		
		Produto[] vetor = new Produto[quantidadeCadastros];//CRIA-SE A VARIÁVEL VETOR NA STACK E O PRÓPRIO VETOR COM A QUANTIDADE DE POSICÕES NO HEAP (PONTEIROS)
		
		for (int i=0; i < vetor.length; i++)
		{
			System.out.println();
			System.out.printf("DIGITE O NOME DO PRODUTO - [%d]: ", i);
			//RESOLVENDO UM PROBLEMA DE QUEBRA DE LINHA
			String nomeProduto = input.nextLine();
			System.out.printf("DIGITE O PREÇO DO PRODUTO - [%d]: ", i);
			Double precoProduto = input.nextDouble();
			System.out.printf("DIGITE A ORIGEM DO PRODUTO - [%d]: ", i);
			input.nextLine();//CORRIGINDO OUTRA VEZ
			String origemProduto = input.nextLine();
			System.out.println();

			vetor[i] = new Produto(nomeProduto, precoProduto, origemProduto);//O VETOR É DO TIPO PRODUTO PARA FAZER DEPOIS 
		}
		
		System.out.println("DESEJA ALTERAR O NOME E A INFORMAÇÃO DE ALGUM PRODUTO DESTE VETOR ? s/n");
		Character reposta = input.next().charAt(0);
		
		if (reposta == 's')
		{
			char repostaAlterarMaisInformacoes;
			do
			{
				//MOSTRANDO O OS PRODUTOS DIGITADOS NA TELA
				byte posicao = 0;
				//OUTRA MANEIRA DE FAZER ESSE LAÇO FOR EACH
				//PARA CADA OBJETO CONTIDO NO apelidoQualquer CONTIDO NO VETOR DE NOME vetor FAÇA
				//ESTAMOS TRATANDO DE OBJETOS, ENTÃO PARA SABER PREÇOS E VALORES PRECISO UTILIZAR OS MÉTODOS DE ACESSO A ESSES VALORES
				for (Produto apelidoQualquer : vetor)
				{
					System.out.println();
					System.out.printf("PRODUTO POSICAO[%d]%n"
							        + "NOME - %s%n"
							        + "VALOR - R$ %.2f%n"
							        + "ORIGEM - %s%n", 
							        posicao,
							        apelidoQualquer.getNomeProduto(), 
							        apelidoQualquer.getPrecoProduto(),
							        apelidoQualquer.getOrigemProduto());
					posicao += 1; //NÃO USEI O FOR PARA CONTAGEM, POR ISSO ESSA OPERAÇÃO PARA DETERMINAR A POSIÇÃO
				}
			
				System.out.println();
				System.out.print("QUAL PRODUTO ACIMA VOCÊ DESEJA ALTERAR?\n"
						          +"FAVOR DIGITE O NÚMERO DE SUA POSIÇÃO: ");
				int posicaoDoVetor= input.nextInt();
				input.nextLine();//ARRUMANDO O PROBLEMA DA QUEBRA DE LINHA
				System.out.println();
				
				System.out.printf("DIGITE O NOVO NOME DO PRODUTO NA POSIÇÃO[%d]: ", posicaoDoVetor);
				String nomeProduto = input.nextLine();
				vetor[posicaoDoVetor].setNomeProduto(nomeProduto);
				
				System.out.printf("DIGITE O NOVO PREÇO DO PRODUTO NA POSIÇÃO[%d]: ", posicaoDoVetor);
				Double precoProduto = input.nextDouble();
				vetor[posicaoDoVetor].setPrecoProduto(precoProduto);
				
				System.out.printf("DIGITE O NOVO PREÇO DO PRODUTO NA POSIÇÃO[%d]: ", posicaoDoVetor);
				input.nextLine();//ARRUMANDO OUTRO PROBLEMA DE QUEBRA DE LINHA
				String origemProduto = input.nextLine();
				vetor[posicaoDoVetor].setOrigemProduto(origemProduto);
				System.out.println();
				
				System.out.println("DESEJA ALTERAR MAIS ALGUMA INFORMAÇÃO DO VETOR ? s/n");
				repostaAlterarMaisInformacoes = input.next().charAt(0);
			} while ( repostaAlterarMaisInformacoes == 's');
		}
		
		//ESCREVENDO NOVAMENTE AS RESPECTIVAS INFORMAÇÕES CADA PRODUTO CADASTRADO
		for (int i=0; i < vetor.length; i++)
		{ 
			System.out.printf("Produto[%d] NOME: %s, PREÇO: R$ %.2f, ORIGEM: %s%n", i, vetor[i].getNomeProduto(), vetor[i].getPrecoProduto(), vetor[i].getOrigemProduto());
		}
		
		input.close();
	}

}
