package ru.kpfu.itis.Gilmanova.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import ru.kpfu.itis.Gilmanova.service.CommentModel;

import java.io.IOException;
import java.util.Collections;

/**
 * Created by Adel on 18.05.2016.
 */

@Configuration
@Import(ScreensConfiguration.class)
@ImportResource("classpath:applicationContext-security.xml")
public class AppConfiguration {
    @Bean(name="model")
    CommentModel commentModel() throws IOException {
        CommentModel commentModel = new CommentModel();
        commentModel.setRestTemplate(restTemplate());
        commentModel.loadData();
        return commentModel;
    }

    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(Collections.<HttpMessageConverter<?>>singletonList(new MappingJacksonHttpMessageConverter()));
        return restTemplate;
    }
}
