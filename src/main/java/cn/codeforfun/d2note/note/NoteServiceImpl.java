package cn.codeforfun.d2note.note;

import cn.codeforfun.d2note.note.exception.NoteNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author wangbin
 * @mail 253498229@qq.com
 * @qq 253498229
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class NoteServiceImpl {
    @Resource
    private NoteRepository noteRepository;

    public List<Note> getAllNote(String username) {
        return noteRepository.findAllFetch(username);
    }

    public Note save(Note note, String username) {
        if (!ObjectUtils.isEmpty(note.getAccount()) && note.getAccount().getId() == 0) {
            note.setAccount(null);
        }
        note.setUpdateAt(new Date());
        note.setUsername(username);
        return noteRepository.save(note);
    }

    public Note findById(Long id, String username) {
        return noteRepository.findByIdFetch(username, id).orElseThrow(NoteNotFoundException::new);
    }

    public void deleteById(Long id, String username) {
        noteRepository.deleteByIdAndUsername(id, username);
    }
}
