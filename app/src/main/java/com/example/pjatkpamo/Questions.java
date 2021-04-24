package com.example.pjatkpamo;

public class Questions {
    public String[] Questions = {
            "What other viruses belong to the coronavirus family?",
            "How many vaccine candidates for COVID-19 have been proposed?",
            "How does weather seem to affect the novel coronavirus?",
            "How is COVID-19 passed on?",
            "What are the common symptoms of COVID-19? ",
            "When should fabric face masks be worn?",
    };

    private final String[][] Answers = {
            {"SARS and influenza", "SARS and MERS", "SARS and HIV", "SARS and AIDS"},
            {"10", "40", "100", "120+"},
            {"The virus can’t survive in hot, humid climates.", "Cold temperatures can kill the virus.", "It is not yet known.", "It likes all temperatures."},
            {"By drinking unclean water.", "Through droplets" , "By making contact with blood.", "All of this"},
            {"A new and continuous cough", "Fever", "Tiredness", "All of this"},
            {"On public transport", "In confined or crowded spaces", "In small shops", "All of this"},
    };

    private final String[] CorrectAnswers = {
            "SARS and MERS",
            "120+",
            "It is not yet known.",
            "Through droplets",
            "All of this",
            "All of this",
    };

    public String getQuestion(int a) {
        return Questions[a];
    }

    public String getAnswer1(int a) {
        return Answers[a][0];
    }

    public String getAnswer2(int a) {
        return Answers[a][1];
    }

    public String getAnswer3(int a) {
        return Answers[a][2];
    }

    public String getAnswer4(int a) {
        return Answers[a][3];
    }

    public String getCorrectAnswer(int a) {
        return CorrectAnswers[a];
    }
}
