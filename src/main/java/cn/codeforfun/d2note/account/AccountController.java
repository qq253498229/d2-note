package cn.codeforfun.d2note.account;

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
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @GetMapping
    public ResponseEntity getAll() {
        return ok(accountService.findAll());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Account account) {
        return ok(accountService.save(account));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        return ok(accountService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        accountService.deleteById(id);
        return ok().build();
    }
}
