package com.JetBrains;

/*
 * This enum needs to use for unification Exceptions' literals
 */
public enum Exception
{
    InterruptedException("Interrupted Exception"),
    ExecutionException("Executing exception during matches()"),
    TimeoutException("Time is over"),
    InvalidArguments("Invalid arguments"),
    PatternSyntaxException("Not correct regular expression");

    private String title;

    Exception(String title) {
        this.title = title;
    }

    public void println()
    {
        System.err.println(title);
    }

    public String getTitle() {
        return title;
    }
}

