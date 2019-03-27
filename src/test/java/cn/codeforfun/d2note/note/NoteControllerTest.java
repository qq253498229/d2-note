package cn.codeforfun.d2note.note;

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
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 笔记测试
 *
 * @author wangbin
 * @mail 253498229@qq.com
 * @qq 253498229
 */
@RunWith(SpringRunner.class)
@WebMvcTest(NoteController.class)
@Import(TestSecurityConfig.class)
public class NoteControllerTest {
    @Resource
    private MockMvc mock;
    @MockBean
    private NoteServiceImpl noteService;

    @Test
    @WithMockUser
    public void getAllNote() throws Exception {
        given(noteService.getAllNote()).willReturn(Arrays.asList(new Note(), new Note()));

        mock.perform(get("/note"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andDo(print())
        ;
    }


    @Test
    @WithMockUser
    public void save() throws Exception {
        given(noteService.save(any())).willReturn(new Note(1L, "tlx-xl"));
        mock.perform(
                post("/note")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new Note().toJson())
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.name").isNotEmpty())
                .andDo(print())
        ;
    }

    @Test
    @WithMockUser
    public void findByIdFetch() throws Exception {
        given(noteService.findById(any())).willReturn(new Note(1L, "tlx-xl"));
        mock.perform(get("/note/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.name").isNotEmpty())
                .andDo(print())
        ;
    }

    @Test
    @WithMockUser
    public void deleteById() throws Exception {
        mock.perform(delete("/note/1"))
                .andExpect(status().isOk())
        ;
    }
}
