package cn.codeforfun.d2note.note;

import cn.codeforfun.d2note.note.exception.NoteNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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

    List<Note> getAllNote() {
        return noteRepository.findAllFetch();
    }

    Note save(Note note) {
        if (note.getAccount().getId() == 0) {
            note.setAccount(null);
        }
        note.setUpdateAt(new Date());
        return noteRepository.save(note);
    }

    Note findById(Integer id) {
        return noteRepository.findByIdFetch(id).orElseThrow(NoteNotFoundException::new);
    }

    void deleteById(Integer id) {
        noteRepository.deleteById(id);
    }
}
