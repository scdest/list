package com.simple.list.api;

public final class Api {

    public static final String ROOT_PATH = "/api";
    private static final String BASE_PATH = ROOT_PATH + "/v1";
    private static final String BASE_PATH_V2 = ROOT_PATH + "/v2";
    public static final String USERS = BASE_PATH + "/register";
    public static final String LISTS = BASE_PATH + "/lists";
    public static final String LISTS_V2 = BASE_PATH_V2 + "/lists";
    public static final String LIST_ID = LISTS + "/{list_id}";
    public static final String ITEMS = LIST_ID + "/items";

    private Api() {
    }
}
