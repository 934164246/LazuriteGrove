package com.rurigokou.common.constant;

/**
 * @author gokoururi
 */
public class JwtConstant {

    /**
     * redis里面用户基本信息前缀
     */
    public static String USER_PREFIX="user:";

    /**
     * redis里面用户权限基本信息前缀
     */
    public static String AUTHORITY_PREFIX="authority:";

    /**
     * salt
     */
    public static final String TOKEN_SECRET = "【「{(GokouRuriForever)}」】";

    public static final String ID = "id";

    public static final String USERNAME = "name";

    public static final String TTL="ttl";

    public static final String NEW_TOKEN="New-Token";
}
