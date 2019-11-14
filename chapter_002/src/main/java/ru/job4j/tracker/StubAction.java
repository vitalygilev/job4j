package ru.job4j.tracker;

import java.util.function.Consumer;

public class StubAction extends BaseAction {

    private boolean call = false;

    public StubAction() {
        super(0, "Stub action");
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }
}
