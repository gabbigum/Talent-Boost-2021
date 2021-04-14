package com.vmware.talentboost.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vmware.talentboost.spring.AuthenticateTestRepositoryStub;
import com.vmware.talentboost.spring.IRepository;
import com.vmware.talentboost.spring.impl.AccountManager;

@Configuration
public class TestConfig {

    @Bean
    AccountManager accountManager() {
        return new AccountManager(repository());
    }

    @Bean
    IRepository repository() {
        return new AuthenticateTestRepositoryStub();
    }

}
