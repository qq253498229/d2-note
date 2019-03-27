package cn.codeforfun.d2note.account;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
