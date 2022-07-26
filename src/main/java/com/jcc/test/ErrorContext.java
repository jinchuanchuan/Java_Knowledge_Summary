package com.jcc.test;

public class ErrorContext {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator", "\n");
    private static final ThreadLocal<ErrorContext> LOCAL = new ThreadLocal<ErrorContext>();

    private String message;

    private ErrorContext()
    {
    }

    public static ErrorContext instance()
    {
        ErrorContext context = LOCAL.get();
        if (context == null)
        {
            context = new ErrorContext();
            LOCAL.set(context);
        }
        return context;
    }

    public ErrorContext message(String message)
    {
        this.message = message;
        return this;
    }

    public ErrorContext reset()
    {

        message = null;
        LOCAL.remove();
        return this;
    }

    @Override
    public String toString()
    {
        StringBuilder description = new StringBuilder();

        if (this.message != null)
        {
            description.append("### ");
            description.append(this.message);
            description.append(LINE_SEPARATOR);
        }

        return description.toString();
    }

    public static void main(String[] args)
    {

        Runnable task1 = () -> {

            ErrorContext cxt = ErrorContext.instance();
            cxt.message("info");

            System.out.println(cxt);
            cxt.reset();
        };

        Runnable task2 = () -> {
            ErrorContext cxt = ErrorContext.instance();
            cxt.message("error");
            System.out.println(cxt);
            cxt.reset();
        };

        new Thread(task1).start();

        new Thread(task2).start();

    }
}
