public class Manager extends Employee
{
    private float kmult;
    public Manager(float salary, float kmult,String name)
    {
    super(salary,name);
    this.kmult=kmult;
    }
    public float ComputeSalary()
    {
        return super.ComputeSalary()*kmult;
    }
    public String getName() { return "Manager"; }
}