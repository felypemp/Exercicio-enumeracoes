package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.LevelTrabalhador;

public class Trabalhador {
	private String nome;
	private LevelTrabalhador level;
	private Double SalarioBase;
	
	private Departamento departamento;
	
	private List<HoraContrato> contratos = new ArrayList<>();
	
	public Trabalhador() {
	}

	public Trabalhador(String nome, LevelTrabalhador level, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.level = level;
		SalarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LevelTrabalhador getLevel() {
		return level;
	}

	public void setLevel(LevelTrabalhador level) {
		this.level = level;
	}

	public Double getSalarioBase() {
		return SalarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		SalarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HoraContrato> getContratos() {
		return contratos;
	}
	
	public void adicionarContrato(HoraContrato contrato ) {
		contratos.add(contrato);
	}
	
	public void removerContrato(HoraContrato contrato ) {
		contratos.remove(contrato);
	}
	
	public double renda(int ano, int mes) {
		double soma = SalarioBase;
		Calendar cal = Calendar.getInstance();
		for(HoraContrato c: contratos) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			if (ano == c_ano && mes == c_mes) {
				soma +=c.valorTotal();
			}
			
		}
		return soma;
	}
 }
