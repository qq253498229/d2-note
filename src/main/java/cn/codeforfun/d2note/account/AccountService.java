package cn.codeforfun.d2note.account;

import cn.codeforfun.d2note.account.exception.AccountNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author wangbin
 * @mail 253498229@qq.com
 * @qq 253498229
 */
@Service
public class AccountService {
    @Resource
    private AccountRepository accountRepository;

    List<Account> findAll() {
        return accountRepository.findAll();
    }

    Account save(Account account) {
        return accountRepository.save(account);
    }

    Account findById(Integer id) {
        Optional<Account> account = accountRepository.findById(id);
        return account.orElseThrow(AccountNotFoundException::new);
    }
}
