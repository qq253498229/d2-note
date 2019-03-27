package cn.codeforfun.d2note.note;

import cn.codeforfun.d2note.util.SecurityUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;

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
    public ResponseEntity getAllNote(Principal principal) {
        return ok(noteService.getAllNote(SecurityUtil.getUsername(principal)));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Note note, Principal principal) {
        return ok(noteService.save(note, SecurityUtil.getUsername(principal)));
    }

    @GetMapping("/{id}")
    public ResponseEntity findByIdFetch(@PathVariable Long id, Principal principal) {
        return ok(noteService.findById(id, SecurityUtil.getUsername(principal)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id, Principal principal) {
        noteService.deleteById(id, SecurityUtil.getUsername(principal));
        return ok().build();
    }
}
