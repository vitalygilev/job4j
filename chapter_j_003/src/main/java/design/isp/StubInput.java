package design.isp;

import java.util.ArrayList;
import java.util.List;

public class StubInput implements MenuInput {

    private final List<String> logInput = new ArrayList<>();

    public List<String> getLogInput() {
        return logInput;
    }

    @Override
    public int input(String ask) {
        logInput.add(ask);
        return Integer.parseInt(ask);
    }

}
