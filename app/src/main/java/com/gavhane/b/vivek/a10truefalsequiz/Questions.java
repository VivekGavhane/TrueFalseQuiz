package com.gavhane.b.vivek.a10truefalsequiz;

public class Questions {

    public String mQuestions[] = {
            "I am very strong",
            "You are very strong",
            "They are very strong",
            "We are very strong",
            "I am very weak",
            "You are very weak",
            "They are very weak",
            "We are very weak",
    };

    public String mAnswers[] = {
            "true",
            "true",
            "true",
            "true",
            "false",
            "false",
            "false",
            "false",
    };

    public String getQuestion(int number){
        return mQuestions[number];
    }

    public String getAnswer(int number){
        return mAnswers[number];
    }
}
