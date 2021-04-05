package lesson5;

public class Employee {
    private String fullName;
    private String position;
    private String eMail;
    private String phoneNumber;
    private String salary;
    private int age;

    public Employee(String fullName, String position, String eMail, String phoneNumber, String salary, int age){
        this.fullName = fullName;
        this.position = position;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Full name: ");
        builder.append(fullName);
        builder.append("\nPosition: ");
        builder.append(position);
        builder.append("\nEmail: ");
        builder.append(eMail);
        builder.append("\nPhone number: ");
        builder.append(phoneNumber);
        builder.append("\nSalary: ");
        builder.append(salary);
        builder.append("\nAge: ");
        builder.append(age);
        return builder.toString();

    }
    public void printInfo(){
        System.out.println(this.toString());
    }
}
