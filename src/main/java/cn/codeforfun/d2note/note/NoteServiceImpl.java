package cn.codeforfun.d2note.note;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangbin
 * @mail 253498229@qq.com
 * @qq 253498229
 */
@Service
public class NoteServiceImpl {
    @Resource
    private NoteRepository noteRepository;

    public List<Note> getAllNote() {
        return noteRepository.findAll();
    }
}
