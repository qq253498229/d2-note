package cn.codeforfun.d2note.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.test.context.support.WithMockUser;

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
    @WithMockUser
    public void findAll() {
        given(accountRepository.findAllFetch(any())).willReturn(Arrays.asList(new Account(), new Account()));

        List<Account> all = accountService.findAll("test");
        assertEquals(2, all.size());
    }

    @Test
    public void save() {

        given(accountRepository.save(any())).willReturn(new Account(1L, "mf-sor"));

        Account save = accountService.save(new Account(), "test");
        assertNotNull(save);
        assertSame(save.getId(), 1L);
        assertEquals(save.getName(), "mf-sor");
    }

    @Test
    public void findById() {
        given(accountRepository.findByIdFetch(any(), any())).willReturn(Optional.of(new Account(1L, "mf-sor")));

        Account account = accountService.findById(1L, "test");
        assertNotNull(account);
        assertSame(account.getId(), 1L);
        assertEquals(account.getName(), "mf-sor");
    }

    @Test
    public void deleteById() {
        accountService.deleteById(1L, "test");
    }
}