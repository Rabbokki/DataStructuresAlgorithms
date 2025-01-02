package javaTest;

public class Temporary extends Employee{
    private int time;
    private int pay;

    public Temporary(String name, int time, int pay) {
        super(name);
        this.time = time;
        this.pay = pay;
    }

    @Override
    int getPay(int time, int pay) {
        return time * pay;
    }
}
