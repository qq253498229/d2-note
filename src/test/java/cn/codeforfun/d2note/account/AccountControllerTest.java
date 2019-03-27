package cn.codeforfun.d2note.account;

import cn.codeforfun.d2note.config.TestSecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author wangbin
 * @mail 253498229@qq.com
 * @qq 253498229
 */
@WebMvcTest(AccountController.class)
@RunWith(SpringRunner.class)
@Import(TestSecurityConfig.class)
public class AccountControllerTest {
    @Resource
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void findALl_ok() throws Exception {
        mockMvc.perform(get("/account"))
                .andExpect(status().isOk())
                .andDo(print())
        ;
    }
}
