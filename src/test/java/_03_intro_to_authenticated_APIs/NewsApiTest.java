package _03_intro_to_authenticated_APIs;

import _03_intro_to_authenticated_APIs.data_transfer_objects.ApiExampleWrapper;
import _03_intro_to_authenticated_APIs.data_transfer_objects.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class NewsApiTest {
    NewsApi newsApi;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        newsApi = new NewsApi();
    }

    @Test
    void itShouldGetNewsStoryByTopic() {
        //given
        String topic = "among us";

        //when
        ApiExampleWrapper apiExampleWrapper = newsApi.getNewsStoryByTopic(topic);

        //then
        assertNotNull(apiExampleWrapper);

        try {
            newsApi.getNewsStoryByTopic("");
            fail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void itShouldFindStory(){
        //given
        String topic = "weather";

        //when
        String output = newsApi.findStory(topic);

        //then
//        assertTrue(output.toLowerCase().contains(topic.toLowerCase()));
    }
}