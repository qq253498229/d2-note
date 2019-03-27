package cn.codeforfun.d2note.account;

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
public class AccountServiceTest {
    @InjectMocks
    private AccountService accountService;
    @Mock
    private AccountRepository accountRepository;

    @Test
    public void findAll() {
        given(accountRepository.findAll()).willReturn(Arrays.asList(new Account(), new Account()));

        List<Account> all = accountService.findAll();
        assertEquals(2, all.size());
    }

    @Test
    public void save() {

        given(accountRepository.save(any())).willReturn(new Account(1, "mf-sor"));

        Account save = accountService.save(new Account());
        assertNotNull(save);
        assertSame(save.getId(), 1);
        assertEquals(save.getName(), "mf-sor");
    }

    @Test
    public void findById() {
        given(accountRepository.findById(any())).willReturn(Optional.of(new Account(1, "mf-sor")));

        Account account = accountService.findById(1);
        assertNotNull(account);
        assertSame(account.getId(), 1);
        assertEquals(account.getName(), "mf-sor");
    }
}