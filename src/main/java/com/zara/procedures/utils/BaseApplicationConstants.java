package com.zara.procedures.utils;


public class BaseApplicationConstants {

  /** Endpoint paths, default for v1 version, overwrite when must be updated */
  public static String API_VERSION = "/api/v1";
  /** Common api version*/
  public final static String COMMON_API_VERSION = "/common-api/v1";

  /** Environment variable: boot type of application - VAL_ENV_BT_* **/
  public final static String VAR_ENV_BOOT_TYPE = "app.boot-type";
  /** Environment variable: active environment **/
  public final static String VAR_ENV_PROFILE_ACTIVE = "app.profile.active";

  /** Boot Type: standalone means Spring Boot app as executable **/
  public final static String VAL_ENV_BT_STANDALONE = "standalone";
  /** Boot Type: container means application inside servlet container **/
  public final static String VAL_ENV_BT_CONTAINER = "container";

}
