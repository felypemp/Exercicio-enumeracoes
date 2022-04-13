package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Departamento;
import entidades.HoraContrato;
import entidades.Trabalhador;
import entidades.enums.LevelTrabalhador;

public class Programa {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner leitor = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		System.out.println("Entre com o nome do departamento: ");
		String nomeDepartamento = leitor.nextLine();
		
		System.out.println("Entre com os dados do trabalhador:");
		System.out.print("Nome: ");
		String nomeTrabalhador = leitor.nextLine();
		System.out.print("Level: ");
		String level = leitor.nextLine();
		System.out.print("Salario base:");
		double salarioBase = leitor.nextDouble();
		
		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, LevelTrabalhador.valueOf(level), salarioBase, new Departamento(nomeDepartamento));
		
		
		System.out.println("Quantos contratos este trabalhador terá?");
		int n = leitor.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Entre com os dados do contrato #"+i +":");
			System.out.print("Data (DD/MM/AAAA): ");
			Date dataContrato = sdf.parse(leitor.next());
			System.out.print("Valor por hora:");
			double valorPorHora = leitor.nextDouble();
			System.out.print("Duração (horas): ");
			int horas = leitor.nextInt();
			HoraContrato contrato = new HoraContrato(dataContrato, valorPorHora, horas);
			trabalhador.adicionarContrato(contrato);
			
		}
		
		System.out.println();
		System.out.println("Entre com o mês e ano para o calculo da renda (MM/AAAA");
		String mesAno = leitor.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		System.out.println("Nome: "+ trabalhador.getNome());
		System.out.println("Nome: "+ trabalhador.getDepartamento().getName());
		System.out.println("Renda de "+ mesAno +": "+ String.format("%.2f", trabalhador.renda(ano, mes)));
		
		
		leitor.close();
	}
	
}
