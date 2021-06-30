package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Emplooyer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		/* / Inst�nciando a lista de funcion�rios. / */
		List<Emplooyer> list = new ArrayList<>();

		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		/* / Preenchendo a lista com os dados dos funcion�rios. / */
		for (int i = 0; i < n; i++) {

			System.out.println();
			System.out.println("Emplyoee #" + (i + 1) + ":");
			System.out.print("Id:");
			Integer id = sc.nextInt();
			
			/* / Checando se o id do funcion�rio j� existe na lista. / */
			while(hasId(list, id)) {
				System.out.println("Id already taken! Try again: ");
				id=sc.nextInt();
			}
			
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();

			Emplooyer emp = new Emplooyer(id, name, salary);
			
			list.add(emp);
		}

		/* / Escolhe o funcion�rio que receber� o aumento pelo id registrado. / */
		System.out.print("Enter the employee id that will have salary increase: ");
		Integer idSalary = sc.nextInt();
		
		/* / Int�nciando e chamando a fun��o position. / */
		Integer pos = position(list, idSalary);
		
		/* / verificando se existe o id para aumentar o sal�rio. / */
		if (pos == null) {
			System.out.print("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			Double percent = sc.nextDouble();
			list.get(pos).increaseSalary(percent);
		}
		
		/* / Mostra a lista de funcion�rios com os sal�rios atualizados. / */
		System.out.println();
		System.out.print("List of employees:");

		for (Emplooyer emp : list) {
			
			System.out.println();
			System.out.println(emp);

		}

		sc.close();
	}
	
	/* / Fun��o para checar a lista para ver se existe o id procurado. / */
	public static Integer position(List<Emplooyer> list, int id) {
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	/* / fun��o para ver se j� existe o id cadastrado. / */
	public static boolean hasId(List<Emplooyer> list,int id) {
		Emplooyer emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}
