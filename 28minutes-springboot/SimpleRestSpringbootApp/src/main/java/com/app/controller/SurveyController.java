package com.app.controller;

import com.app.model.Question;
import com.app.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SurveyController {

    private SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @RequestMapping(method= RequestMethod.GET, path="/surveys/{surveyId}/questions")
    public List<Question> retrieveQuestionsForSurvey(@PathVariable String surveyId) {
        return surveyService.retrieveQuestions(surveyId);
    }

    @RequestMapping(method= RequestMethod.GET, path="/surveys/{surveyId}/questions/{questionId}")
    public Question retrieveDetailsForQuestion(@PathVariable String surveyId, @PathVariable String questionId) {
        return surveyService.retrieveQuestion(surveyId, questionId);
    }
}
