package edu.hw2.task4;

public class WhoCalled {
    private WhoCalled() {
    }

    public static CallingInfo act() {
        try {
            throw new GetStackTraceException();
        } catch (GetStackTraceException e) {
            var st = e.getStackTrace();
            var stElement = st[1];
            String className = stElement.getClassName();
            String methodName = stElement.getMethodName();

            return new CallingInfo(className, methodName);
        }
    }
}
