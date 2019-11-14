package com.github.gs618.eventbus.remote.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author s.c.gao
 */
public class GsonUtils {

    public static final Gson GSON = new GsonBuilder()
            .serializeNulls()
            .create();

}
