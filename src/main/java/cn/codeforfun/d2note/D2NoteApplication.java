package cn.codeforfun.d2note;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author wangbin
 * @mail 253498229@qq.com
 * @qq 253498229
 */
@SpringBootApplication
@EnableResourceServer
@EnableWebSecurity
public class D2NoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(D2NoteApplication.class, args);
    }

}
