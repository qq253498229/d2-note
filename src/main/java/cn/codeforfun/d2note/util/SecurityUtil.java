package cn.codeforfun.d2note.util;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author wangbin
 * @mail 253498229@qq.com
 * @qq 253498229
 */
public class SecurityUtil {
    public static String getUsername() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
