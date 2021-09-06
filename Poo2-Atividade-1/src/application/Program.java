package application;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;

import entities.Entregador;
import entities.Funcionario;
import entities.Secretaria;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		DecimalFormat df = new DecimalFormat("0.00");
		
		String opcao;
		char repetir = 's';
		
		List<Funcionario> listaFuncionario = new ArrayList<>();
				
		do {
			opcao = JOptionPane.showInputDialog("CADASTRO DE FUNCION�RIO\n"	+ "1 - Secret�ria;\n" + "2 - Entregador.");
			switch (Integer.parseInt(opcao)){
		
			case 1:
				Funcionario secretaria = new Secretaria(
				Integer.parseInt(JOptionPane.showInputDialog("N�mero de identificador de cadastro: ")),
				JOptionPane.showInputDialog("Nome do funcion�rio: "),
				JOptionPane.showInputDialog("Telefone: "));
				listaFuncionario.add(secretaria);
				repetir = desejaRepetir();

			break;
		
			case 2:
				Funcionario entregador = new Entregador(
				Integer.parseInt(JOptionPane.showInputDialog("N�mero de identificador de cadastro: ")),
				JOptionPane.showInputDialog("Nome do funcion�rio: "),
				JOptionPane.showInputDialog("Telefone: "),
				JOptionPane.showInputDialog("N� da CNH tipo AB"));
				listaFuncionario.add(entregador);
				repetir = desejaRepetir();
			break;
		
			default:
				JOptionPane.showMessageDialog(null, "Op��o Inv�lida");
			break;
		
		}}while(repetir == 's');
		
		for(Funcionario x : listaFuncionario) {
			JOptionPane.showMessageDialog(null,"Id: " + x.getId() + "\nNome: " + x.getNome() + "\nTelefone: " + x.getTelefone() + "\nSalario: R$ " + df.format(x.getSalario()) );
		}
	}
	
	public static char desejaRepetir() {
		String opcao;
		opcao = (JOptionPane.showInputDialog("Deseja cadastrar outro funcion�rio? (s/n)"));
		char repetir = opcao.charAt(0);
		System.out.println(opcao);
		if (repetir != 's' && repetir != 'n') {
			System.out.println("Op��o Inv�lida");
			opcao = JOptionPane.showInputDialog("Deseja cadastrar outro funcion�rio? (s/n)");
		}
		return repetir;
	}
}
