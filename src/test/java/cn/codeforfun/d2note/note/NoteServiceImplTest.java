package cn.codeforfun.d2note.note;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class NoteServiceImplTest {

    @InjectMocks
    private NoteServiceImpl noteService;
    @Mock
    private NoteRepository noteRepository;

    @Test
    public void getAllNote_ok() {
        given(noteRepository.findAll()).willReturn(Arrays.asList(new Note(), new Note()));

        List<Note> allNote = noteService.getAllNote();
        assertNotNull(allNote);
    }
}