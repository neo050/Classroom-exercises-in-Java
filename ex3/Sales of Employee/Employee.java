public class Employee {
    String name;
    private String Employee;
    private float salary;

    public Employee(float salary,String name) {
        this.salary=salary;
        this.name=name;
    }

    public float ComputeSalary()
    {

        return salary;
    }

    public String getName() {
        return name;
    }
}