package cn.codeforfun.d2note.account;

import cn.codeforfun.d2note.account.exception.AccountNotFoundException;
import cn.codeforfun.d2note.config.TestSecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
    @MockBean
    private AccountService accountService;

    @Test
    @WithMockUser
    public void getAll() throws Exception {
        given(accountService.findAll()).willReturn(Arrays.asList(new Account(), new Account()));

        mockMvc.perform(get("/account"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andDo(print())
        ;
    }

    @Test
    @WithMockUser
    public void save() throws Exception {
        given(accountService.save(any())).willReturn(new Account(1, "mf-sor"));

        mockMvc.perform(
                post("/account")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new Account("mf-sor").toJson())
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("mf-sor"))
                .andDo(print())
        ;
    }

    @Test
    @WithMockUser
    public void findById() throws Exception {
        given(accountService.findById(anyInt())).willReturn(new Account(1, "mf-sor"));

        mockMvc.perform(get("/account/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("mf-sor"))
                .andDo(print())
        ;
    }

    @Test
    @WithMockUser
    public void findById_notFound() throws Exception {
        given(accountService.findById(anyInt())).willThrow(AccountNotFoundException.class);

        mockMvc.perform(get("/account/1"))
                .andExpect(status().isNotFound())
                .andDo(print())
        ;
    }


    @Test
    @WithMockUser
    public void deleteById() throws Exception {
        mockMvc.perform(delete("/account/1"))
                .andExpect(status().isOk())
                .andDo(print())
        ;
    }
}
