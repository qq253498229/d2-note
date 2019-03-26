package cn.codeforfun.d2note.note;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class NoteRepositoryTest {
    @Resource
    private NoteRepository noteRepository;


    @Test
    public void findAll_emptyNote() {
        List<Note> all = noteRepository.findAll();
        assertNotNull(all);
        assertEquals(0, all.size());
    }

    @Test
    public void findAll_hasNote() {
        noteRepository.save(new Note("tlx项链"));
        List<Note> all = noteRepository.findAll();
        assertNotNull(all);
        assertNotEquals(0, all.size());
    }
}