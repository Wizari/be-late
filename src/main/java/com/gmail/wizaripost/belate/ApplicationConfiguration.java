package com.gmail.wizaripost.belate;

import com.wizaripost.losertime.mail.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public IEmployeeProvider employeeProvider() {
        IEmployeeProvider employeeProvider = new EmployeeProviderFromXml();
        return employeeProvider;
    }

    @Bean
    public IMailApi mailApi(ISenderProvider senderProvider,
                            IAuthenticatorProvider authenticatorProvider,
                            IPropertiesProvider propertiesProvider) {
        return new MailApi(senderProvider, propertiesProvider, authenticatorProvider);
    }

    @Bean
    public ISenderProvider senderProvider() {
        return new SenderProviderFromMemory();
    }

    @Bean
    public IAuthenticatorProvider authenticatorProvider() {
        return new AuthenticatorProviderFromMemory();
    }

    @Bean
    public IPropertiesProvider propertiesProvider() {
        return new PropertiesProviderFromMemory();
    }

    @Bean
    public IContentCreator contentCreator() {
        return new ContentCreator();
    }

}
