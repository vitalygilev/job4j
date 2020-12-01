package design.isp;

import java.util.ArrayList;
import java.util.List;

public class StubOutput implements MenuOutput {

    private final List<String> logOutput = new ArrayList<>();

    public List<String> getLogOutput() {
        return logOutput;
    }

    @Override
    public void output(String outText) {
        logOutput.add(outText);
    }
}
