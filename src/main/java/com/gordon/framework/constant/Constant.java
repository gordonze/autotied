package com.gordon.framework.constant;


import java.util.regex.Pattern;

public class Constant {

    public static final Pattern GLOBAL_VALUE_PATTERN=Pattern.compile("\\$\\{([^${}]*)\\}");
    public static final Pattern FUNCTION_PATTERN = Pattern.compile("#(\\b[^()]+)\\((.*)\\)");
}
