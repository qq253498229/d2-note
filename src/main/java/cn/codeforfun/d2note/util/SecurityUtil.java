package cn.codeforfun.d2note.util;

import java.security.Principal;

/**
 * @author wangbin
 * @mail 253498229@qq.com
 * @qq 253498229
 */
public class SecurityUtil {
    public static String getUsername(Principal principal) {
        return principal.getName();
    }
}
