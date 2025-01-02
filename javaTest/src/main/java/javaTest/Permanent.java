package javaTest;

public class Permanent extends Employee{

    private int salary;
    private int bonus;

    public Permanent(String name, int salary, int bonus) {
        super(name);
        this.salary = salary;
        this.bonus = bonus;
    }

    @Override
    int getPay(int salary, int bonus) {

        return salary + bonus;
    }
}
