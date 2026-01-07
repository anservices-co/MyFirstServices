package com.anservices.quiz.service;

import com.anservices.quiz.model.Question;
import com.anservices.quiz.dto.QuestionResponse;
import com.anservices.quiz.dto.AnswerRequest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {
    private final List<Question> questions = new ArrayList<>();

    @PostConstruct
    public void init() {
        questions.add(new Question(1L, "What is the capital of France?", List.of("Berlin", "Madrid", "Paris", "Rome"), 2));
        questions.add(new Question(2L, "Which language runs on the JVM?", List.of("Python", "Java", "C#", "JavaScript"), 1));
        questions.add(new Question(3L, "What does HTTP stand for?", List.of("HyperText Transfer Protocol", "HighText Transfer Protocol", "HyperTransfer Text Protocol", "HyperText Transmission Protocol"), 0));
    }

    public List<QuestionResponse> getQuestions() {
        return questions.stream()
                .map(q -> new QuestionResponse(q.getId(), q.getText(), q.getOptions()))
                .collect(Collectors.toList());
    }

    public int grade(List<AnswerRequest> answers) {
        int correct = 0;
        Map<Long, Question> map = questions.stream().collect(Collectors.toMap(Question::getId, q -> q));
        for (AnswerRequest ar : answers) {
            Question q = map.get(ar.getQuestionId());
            if (q != null && q.getCorrectIndex() == ar.getSelectedIndex()) correct++;
        }
        return correct;
    }

    public int totalQuestions() { return questions.size(); }

    public Optional<Question> findById(Long id) {
        return questions.stream().filter(q -> q.getId().equals(id)).findFirst();
    }
}
