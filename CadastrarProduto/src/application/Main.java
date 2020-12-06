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
		
		int quantidadeCadastros; //VARI�VEL DE ESCOPO GLOBAL, USO ELA AL�M DO ESCOPO LOCAL DE BAIXO
		do
		{
			System.out.print("DIGITE A QUANTIDADE DE CADASTROS: ");		
			quantidadeCadastros = input.nextInt();
			input.nextLine();//RESOLVENDO UM PROBLEMA DE QUEBRA DE LINHA
				if (quantidadeCadastros <= 0)
				{
					System.out.println();
					System.out.println("FAVOR DIGITE UM N�MERO MAIOR DO QUE ZERO");
					System.out.println();
				}
		} while (quantidadeCadastros <= 0);	
		
		//MODIFICANDO A MENSAGEM PARA ESCREVER NO PLURAL OU NO SINGULAR
		if (quantidadeCadastros == 1)
		{
			System.out.println();
			System.out.printf("VOC� REALIZAR� %d CADASTRO", quantidadeCadastros);
			System.out.println();
		}
		else 
		{
			System.out.println();
			System.out.printf("VOC� REALIZAR� %d CADASTROS", quantidadeCadastros);
			System.out.println();
		}
		
		Produto[] vetor = new Produto[quantidadeCadastros];//CRIA-SE A VARI�VEL VETOR NA STACK E O PR�PRIO VETOR COM A QUANTIDADE DE POSIC�ES NO HEAP (PONTEIROS)
		
		for (int i=0; i < vetor.length; i++)
		{
			System.out.println();
			System.out.printf("DIGITE O NOME DO PRODUTO - [%d]: ", i);
			//RESOLVENDO UM PROBLEMA DE QUEBRA DE LINHA
			String nomeProduto = input.nextLine();
			System.out.printf("DIGITE O PRE�O DO PRODUTO - [%d]: ", i);
			Double precoProduto = input.nextDouble();
			System.out.printf("DIGITE A ORIGEM DO PRODUTO - [%d]: ", i);
			input.nextLine();//CORRIGINDO OUTRA VEZ
			String origemProduto = input.nextLine();
			System.out.println();

			vetor[i] = new Produto(nomeProduto, precoProduto, origemProduto);//O VETOR � DO TIPO PRODUTO PARA FAZER DEPOIS 
		}
		
		System.out.println("DESEJA ALTERAR O NOME E A INFORMA��O DE ALGUM PRODUTO DESTE VETOR ? s/n");
		Character reposta = input.next().charAt(0);
		
		if (reposta == 's')
		{
			char repostaAlterarMaisInformacoes;
			do
			{
				//MOSTRANDO O OS PRODUTOS DIGITADOS NA TELA
				byte posicao = 0;
				//OUTRA MANEIRA DE FAZER ESSE LA�O FOR EACH
				//PARA CADA OBJETO CONTIDO NO apelidoQualquer CONTIDO NO VETOR DE NOME vetor FA�A
				//ESTAMOS TRATANDO DE OBJETOS, ENT�O PARA SABER PRE�OS E VALORES PRECISO UTILIZAR OS M�TODOS DE ACESSO A ESSES VALORES
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
					posicao += 1; //N�O USEI O FOR PARA CONTAGEM, POR ISSO ESSA OPERA��O PARA DETERMINAR A POSI��O
				}
			
				System.out.println();
				System.out.print("QUAL PRODUTO ACIMA VOC� DESEJA ALTERAR?\n"
						          +"FAVOR DIGITE O N�MERO DE SUA POSI��O: ");
				int posicaoDoVetor= input.nextInt();
				input.nextLine();//ARRUMANDO O PROBLEMA DA QUEBRA DE LINHA
				System.out.println();
				
				System.out.printf("DIGITE O NOVO NOME DO PRODUTO NA POSI��O[%d]: ", posicaoDoVetor);
				String nomeProduto = input.nextLine();
				vetor[posicaoDoVetor].setNomeProduto(nomeProduto);
				
				System.out.printf("DIGITE O NOVO PRE�O DO PRODUTO NA POSI��O[%d]: ", posicaoDoVetor);
				Double precoProduto = input.nextDouble();
				vetor[posicaoDoVetor].setPrecoProduto(precoProduto);
				
				System.out.printf("DIGITE O NOVO PRE�O DO PRODUTO NA POSI��O[%d]: ", posicaoDoVetor);
				input.nextLine();//ARRUMANDO OUTRO PROBLEMA DE QUEBRA DE LINHA
				String origemProduto = input.nextLine();
				vetor[posicaoDoVetor].setOrigemProduto(origemProduto);
				System.out.println();
				
				System.out.println("DESEJA ALTERAR MAIS ALGUMA INFORMA��O DO VETOR ? s/n");
				repostaAlterarMaisInformacoes = input.next().charAt(0);
			} while ( repostaAlterarMaisInformacoes == 's');
		}
		
		//ESCREVENDO NOVAMENTE AS RESPECTIVAS INFORMA��ES CADA PRODUTO CADASTRADO
		for (int i=0; i < vetor.length; i++)
		{ 
			System.out.printf("Produto[%d] NOME: %s, PRE�O: R$ %.2f, ORIGEM: %s%n", i, vetor[i].getNomeProduto(), vetor[i].getPrecoProduto(), vetor[i].getOrigemProduto());
		}
		
		input.close();
	}

}
