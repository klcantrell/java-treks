package com.app.controller;

import com.app.model.Question;
import com.app.service.SurveyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SurveyController.class)
public class SurveyControllerTest {

    @MockBean
    private SurveyService surveyService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void retrieveDetailsForQuestion() throws Exception {
        Question mockQuestion = new Question("Question1",
                "Largest Country in the World", "Russia", Arrays.asList(
                "India", "Russia", "United States", "China"));

        when(surveyService.retrieveQuestion(anyString(), anyString())).thenReturn(mockQuestion);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/surveys/Survey1/questions/Question1")
                .accept(MediaType.APPLICATION_JSON);

        String expected = "{\"id\":\"Question1\",\"description\":\"Largest Country in the World\",\"correctAnswer\":\"Russia\",\"options\":[\"India\",\"Russia\",\"United States\",\"China\"]}";
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void retrieveSurveyQuestions() throws Exception {
        Question mockQuestion1 = new Question("Question1",
                "First Alphabet",
                "A",
                Arrays.asList("A", "B", "C", "D"));
        Question mockQuestion2 = new Question("Question2",
                "First Alphabet",
                "Z",
                Arrays.asList("W", "X", "Y", "Z"));

        List<Question> mockQuestionsList = Arrays.asList(mockQuestion1, mockQuestion2);

        when(surveyService.retrieveQuestions(anyString())).thenReturn(mockQuestionsList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/surveys/Survey1/questions/")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult actual = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        String expected = "["
                + "{\"id\":\"Question1\",\"description\":\"First Alphabet\",\"correctAnswer\":\"A\",\"options\":[\"A\",\"B\",\"C\",\"D\"]},"
                + "{\"id\":\"Question2\",\"description\":\"First Alphabet\",\"correctAnswer\":\"Z\",\"options\":[\"W\",\"X\",\"Y\",\"Z\"]}"
                + "]";

        JSONAssert.assertEquals(expected, actual.getResponse().getContentAsString(), false);
    }

    @Test
    public void createSurveyQuestion() throws Exception {
        Question mockQuestion = new Question("1", "Smallest Number", "1",
				Arrays.asList("1", "2", "3", "4"));

		String questionJson = "{\"description\":\"Smallest Number\",\"correctAnswer\":\"1\",\"options\":[\"1\",\"2\",\"3\",\"4\"]}";
		when(surveyService.addQuestion(anyString(), any(Question.class))).thenReturn(mockQuestion);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/surveys/Survey1/questions/")
                .accept(MediaType.APPLICATION_JSON)
                .content(questionJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult actual = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = actual.getResponse();
        assertThat(HttpStatus.CREATED.value(), equalTo(response.getStatus()));
        assertThat(response.getHeader(HttpHeaders.LOCATION), containsString("/surveys/Survey1/questions/"));
    }
}
