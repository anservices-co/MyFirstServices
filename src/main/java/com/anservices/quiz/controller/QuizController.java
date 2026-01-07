package com.anservices.quiz.controller;

import com.anservices.quiz.dto.QuestionResponse;
import com.anservices.quiz.dto.AnswerRequest;
import com.anservices.quiz.service.QuizService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping(value = "/questions", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<QuestionResponse> getQuestions() {
        return quizService.getQuestions();
    }

    @PostMapping(value = "/submit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> submitAnswers(@RequestBody List<AnswerRequest> answers) {
        int correct = quizService.grade(answers);
        Map<String, Object> resp = new HashMap<>();
        resp.put("total", quizService.totalQuestions());
        resp.put("correct", correct);
        return resp;
    }
}
