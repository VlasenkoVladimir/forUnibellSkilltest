package ru.unibell.vladimirvlasenkoskilltest.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.ExposureConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import ru.unibell.vladimirvlasenkoskilltest.model.Client;
import ru.unibell.vladimirvlasenkoskilltest.model.ContactInformation;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration restConfig, CorsRegistry cors) {
        ExposureConfiguration config = restConfig.getExposureConfiguration();

        config.forDomainType(Client.class)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(HttpMethod.PATCH))
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(HttpMethod.PUT))
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(HttpMethod.DELETE));

        config.forDomainType(ContactInformation.class)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(HttpMethod.PATCH))
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(HttpMethod.PUT))
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(HttpMethod.DELETE));
    }
}
