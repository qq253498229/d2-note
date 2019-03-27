package cn.codeforfun.d2note.note;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static org.springframework.http.ResponseEntity.ok;

/**
 * @author wangbin
 * @mail 253498229@qq.com
 * @qq 253498229
 */
@RestController
@RequestMapping("/note")
public class NoteController {
    @Resource
    private NoteServiceImpl noteService;

    @GetMapping
    public ResponseEntity getAllNote() {
        return ok(noteService.getAllNote());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Note note) {
        return ok(noteService.save(note));
    }

    @GetMapping("/{id}")
    public ResponseEntity findByIdFetch(@PathVariable Integer id) {
        return ok(noteService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        noteService.deleteById(id);
        return ok().build();
    }
}
