package com.JetBrains;

import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class MyMatcher {
    private static int timout_time_in_seconds = 7;

    /**
     * Set timout
     * @param timeout time in seconds during which matches() will try to execute
     */
    public static void setTimout(int timeout)
    {
        if (timeout < 0)
            return;

        timout_time_in_seconds = timeout;
    }

    /**
     * Modified method Pattern.matches() that works for a specific time and
     * return false if the time is over
     * return true if find a matches
     * @param text a string to search for a regular expression in it
     * @param regex the regular expression that the given string must match.
     */
    public static boolean matches(String text, String regex)
    {
        if (text == null || regex == null || text.length() == 0 || regex.length() == 0)
        {
            Exception.InvalidArguments.println();
            return false;
        }

        boolean result = false;
        final Pattern pattern;
        try {
            pattern = Pattern.compile(regex);
        }
        catch (PatternSyntaxException e)
        {
            Exception.PatternSyntaxException.println();
            return false;
        }

        final Matcher matcher = pattern.matcher(text);
        final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        final Future<Boolean> future = singleThreadExecutor.submit(matcher::matches);

        try{
            result = future.get(timout_time_in_seconds, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Exception.InterruptedException.println();
        } catch (ExecutionException e)
        {
            Exception.ExecutionException.println();
        }
        catch (TimeoutException e) {
            future.cancel(true);
            Exception.TimeoutException.println();
        }
        finally {
            singleThreadExecutor.shutdown();
        }
        return result;
    }

}
