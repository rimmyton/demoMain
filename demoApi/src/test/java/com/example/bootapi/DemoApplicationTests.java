package com.example.bootapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bootapi.domain.Account;
import com.example.bootapi.repository.AccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	AccountRepository accountRepository;

	@Test
	public void saveAccount() {
		Account account = new Account();
		account.setName("test");
		account.setEmail("test@127.com");
		account.setHashPassword("123456");
		Account save = accountRepository.save(account);
		System.out.println(save.getId());
	}

}
