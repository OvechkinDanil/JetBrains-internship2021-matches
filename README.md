# JetBrains-internship2021-matches
## Задание: 
You have a function, both text and regex parameters are set by a user. Refactor the function to avoid crash or hang during the code execution.

>```
> public boolean matches(String text, String regex) {
>		return Pattern.compile(regex).matcher(text).matches();
>}
>```

Hint: you don't want to wait forever till the regex match finishes.
