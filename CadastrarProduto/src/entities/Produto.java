package entities;

public class Produto
{
	private String nomeProduto;
	private Double precoProduto;
	private String origemProduto;
	
	public Produto(String nomeProduto, Double precoProduto, String origemProduto)
	{
		this.nomeProduto = nomeProduto;
		this.precoProduto = precoProduto;
		this.origemProduto = origemProduto;
	}
	
	public Produto(String nomeProduto, Double precoProduto)
	{
		this.nomeProduto = nomeProduto;
		this.precoProduto = precoProduto;
	}
		
	public void setNomeProduto(String nomeProduto)
	{
		this.nomeProduto = nomeProduto;
	}
	
	public String getNomeProduto()
	{
		return this.nomeProduto;
	}
	
	public void setPrecoProduto(Double precoProduto)
	{
		this.precoProduto = precoProduto;
	}
	
	public double getPrecoProduto()
	{
		return this.precoProduto;
	}
	
	public void setOrigemProduto(String origemProduto)
	{
		this.origemProduto = origemProduto;
	}
	
	public String getOrigemProduto()
	{
		return this.origemProduto;
	}
}
