package com.mjr.app.alleasy.utils;

import com.gabrielMJr.twaire.tools.Tools;

public class Util {
    public static boolean isEmpty(String value) {
        return new Tools().isNull(value);
    }
}
