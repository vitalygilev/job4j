package design.isp;

public class ConsoleOutput implements MenuOutput {

    @Override
    public void output(String outText) {
        System.out.print(outText+ "\n");
    }
}
