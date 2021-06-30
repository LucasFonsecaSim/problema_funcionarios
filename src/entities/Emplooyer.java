/* / Classe entidade. / */
package entities;

public class Emplooyer {
	private Integer id;
	private String name;
	private Double salary;

	/* / Construtor padrão / */
	public Emplooyer() {
	}
	
	/* / Construtor com id, nome e salário. / */
	public Emplooyer(Integer id, String name, Double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	/* / F. gets e sets. / */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	/* / F. para aumentar o salário por porcentagem do salário já existente. / */
	public void increaseSalary(double percentage) {
		salary += salary * percentage / 100.0;
	}
	
	/* / F. toString. / */
	@Override
	public String toString() {
		return id + ", " + name + ", " + String.format("%.2f", salary);
	}
}
