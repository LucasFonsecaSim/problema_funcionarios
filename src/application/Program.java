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
		
		/* / Instânciando a lista de funcionários. / */
		List<Emplooyer> list = new ArrayList<>();

		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		/* / Preenchendo a lista com os dados dos funcionários. / */
		for (int i = 0; i < n; i++) {

			System.out.println();
			System.out.println("Emplyoee #" + (i + 1) + ":");
			System.out.print("Id:");
			Integer id = sc.nextInt();
			
			/* / Checando se o id do funcionário já existe na lista. / */
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

		/* / Escolhe o funcionário que receberá o aumento pelo id registrado. / */
		System.out.print("Enter the employee id that will have salary increase: ");
		Integer idSalary = sc.nextInt();
		
		/* / Intânciando e chamando a função position. / */
		Integer pos = position(list, idSalary);
		
		/* / verificando se existe o id para aumentar o salário. / */
		if (pos == null) {
			System.out.print("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			Double percent = sc.nextDouble();
			list.get(pos).increaseSalary(percent);
		}
		
		/* / Mostra a lista de funcionários com os salários atualizados. / */
		System.out.println();
		System.out.print("List of employees:");

		for (Emplooyer emp : list) {
			
			System.out.println();
			System.out.println(emp);

		}

		sc.close();
	}
	
	/* / Função para checar a lista para ver se existe o id procurado. / */
	public static Integer position(List<Emplooyer> list, int id) {
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	/* / função para ver se já existe o id cadastrado. / */
	public static boolean hasId(List<Emplooyer> list,int id) {
		Emplooyer emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}
