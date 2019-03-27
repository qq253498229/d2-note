package cn.codeforfun.d2note.account;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangbin
 * @mail 253498229@qq.com
 * @qq 253498229
 */
@Service
public class AccountService {
    @Resource
    private AccountRepository accountRepository;

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
