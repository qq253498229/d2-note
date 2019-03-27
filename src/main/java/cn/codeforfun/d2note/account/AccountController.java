package cn.codeforfun.d2note.account;

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
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @GetMapping
    public ResponseEntity getAll(Principal principal) {
        return ok(accountService.findAll(SecurityUtil.getUsername(principal)));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Account account, Principal principal) {
        return ok(accountService.save(account, SecurityUtil.getUsername(principal)));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id, Principal principal) {
        return ok(accountService.findById(id, SecurityUtil.getUsername(principal)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id, Principal principal) {
        accountService.deleteById(id, SecurityUtil.getUsername(principal));
        return ok().build();
    }
}
