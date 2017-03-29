package br.com.tiago.gerenciador.modelo;

import java.util.Calendar;

public class Recebimentos {
	private String nome;
	private String categoria;
	private double valor;
	private Calendar data;
	private Calendar data1;


	public Recebimentos(String nome, String categoria, double valor, Calendar data,Calendar data1) {
		this.nome = nome;
		this.categoria = categoria;
		this.valor = valor;
		this.setData(data);
		this.setData1(data1);
	}
	public String getNome() {
		return nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public double getValor() {
		return valor;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public Calendar getData1() {
		return data1;
	}
	public void setData1(Calendar data1) {
		this.data1 = data1;
	}

}
