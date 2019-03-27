package cn.codeforfun.d2note.note;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class NoteServiceImplTest {

    @InjectMocks
    private NoteServiceImpl noteService;
    @Mock
    private NoteRepository noteRepository;

    @Test
    public void getAllNote() {
        given(noteRepository.findAllFetch(any())).willReturn(Arrays.asList(new Note(), new Note()));

        List<Note> allNote = noteService.getAllNote();
        assertNotNull(allNote);
    }


    @Test
    public void save() {
        given(noteRepository.save(any())).willReturn(new Note(1L, "tlx-xl"));
        Note save = noteService.save(new Note("tlx-xl"));
        assertNotNull(save);
        assertSame(save.getId(), 1L);
        assertEquals(save.getName(), "tlx-xl");
    }

    @Test
    public void findById() {
        given(noteRepository.findByIdFetch(any(), any())).willReturn(Optional.of(new Note(1L, "tlx-xl")));
        Note note = noteService.findById(1L);
        assertNotNull(note);
    }

    @Test
    public void deleteById() {
        noteService.deleteById(1L);
    }
}