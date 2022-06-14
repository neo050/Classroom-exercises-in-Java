import java.util.List;

public class SalesManager extends Manager implements Sale
{
    private float kmult;
    private float commis;
    List<String> SaleNames;

    public SalesManager(float salary, float kmult, String name,float commis) {
        super(salary,kmult, name);
        this.kmult = kmult;
        this.commis=commis;
    }

    public float ComputeSalary() {
        return super.ComputeSalary() *kmult* (1 + commis / 100);
    }

    public float getCom() {
        return commis;
    }

    public String getSaleName() {
        return "jpj";
    }
}