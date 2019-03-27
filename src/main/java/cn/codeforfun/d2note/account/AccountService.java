package cn.codeforfun.d2note.account;

import cn.codeforfun.d2note.account.exception.AccountNotFoundException;
import cn.codeforfun.d2note.util.SecurityUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author wangbin
 * @mail 253498229@qq.com
 * @qq 253498229
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AccountService {
    @Resource
    private AccountRepository accountRepository;

    public List<Account> findAll() {
        return accountRepository.findAllFetch(SecurityUtil.getUsername());
    }

    public Account save(Account account) {
        account.setUpdateAt(new Date());
        if (ObjectUtils.isEmpty(account.getUsername())) {
            account.setUsername(SecurityUtil.getUsername());
        }
        return accountRepository.save(account);
    }

    public Account findById(Long id) {
        Optional<Account> account = accountRepository.findByIdFetch(SecurityUtil.getUsername(), id);
        return account.orElseThrow(AccountNotFoundException::new);
    }

    public void deleteById(Long id) {
        accountRepository.deleteByIdAndUsername(id, SecurityUtil.getUsername());
    }
}
