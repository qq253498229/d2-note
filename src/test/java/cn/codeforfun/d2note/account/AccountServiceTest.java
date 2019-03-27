package cn.codeforfun.d2note.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
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
}