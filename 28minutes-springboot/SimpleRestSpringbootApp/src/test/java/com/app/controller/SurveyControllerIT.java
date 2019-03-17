package com.app.controller;

import com.app.Application;
import com.app.model.Question;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate;
    HttpHeaders httpHeaders;

    @Before
    public void setup() {
        restTemplate = new TestRestTemplate();
        httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    }

    @Test
    public void addQuestion() {
        Question question = new Question("Question1",
                "Largest Country in the World", "Russia", Arrays.asList(
                "India", "Russia", "United States", "China"));
        ResponseEntity<List<Question>> response = restTemplate.exchange(
                createUrl("/surveys/Survey1/questions/"),
                HttpMethod.POST,
                new HttpEntity<>(question, httpHeaders),
                new ParameterizedTypeReference<List<Question>>() {
                });

        String expectedUriComponent = "/surveys/Survey1/questions";
        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

        assertThat(actual, containsString(expectedUriComponent));
    }

    @Test
    public void retrieveSurveyQuestions() {
        ResponseEntity<List<Question>> response = restTemplate.exchange(
                createUrl("/surveys/Survey1/questions/"), HttpMethod.GET,
                new HttpEntity<>(null, httpHeaders),
                new ParameterizedTypeReference<List<Question>>() {
                });

        Question sampleQuestion = new Question("Question1",
                "Largest Country in the World", "Russia", Arrays.asList(
                "India", "Russia", "United States", "China"));

        assertThat(response.getBody(), hasItem(sampleQuestion));
    }

    @Test
    public void surveyQuestionController() throws JSONException {
        HttpEntity httpEntity = new HttpEntity<String>(null, httpHeaders);

        ResponseEntity<String> response = restTemplate.exchange(
                createUrl("/surveys/Survey1/questions/Question1"),
                HttpMethod.GET, httpEntity, String.class);

        String expected = "{\"id\":\"Question1\",\"description\":\"Largest Country in the World\",\"correctAnswer\":\"Russia\",\"options\":[\"India\",\"Russia\",\"United States\",\"China\"]}";
        assertThat(response.getBody(), containsString(expected));
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    private String createUrl(String url) {
        String base = "http://localhost:";
        return base + port + url;
    }

}
