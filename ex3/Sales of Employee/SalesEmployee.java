import java.util.List;

public class SalesEmployee extends Employee implements Sale {
    private float commis;
    List<String> SaleNames;

    public SalesEmployee(float salary, float commis, String name) {
        super(salary, name);
        this.commis = commis;
    }

    public float ComputeSalary() {
        return super.ComputeSalary() * (1 + commis / 100);
    }

    public float getCom() {
        return commis;
    }

    public String getSaleName() {
        return "jpj";
    }
}
