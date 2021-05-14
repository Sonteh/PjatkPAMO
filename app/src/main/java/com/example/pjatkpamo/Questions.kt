package com.example.pjatkpamo

class Questions {
    var Questions = arrayOf(
        "What other viruses belong to the coronavirus family?",
        "How many vaccine candidates for COVID-19 have been proposed?",
        "How does weather seem to affect the novel coronavirus?",
        "How is COVID-19 passed on?",
        "What are the common symptoms of COVID-19? ",
        "When should fabric face masks be worn?"
    )

    private val Answers = arrayOf(
        arrayOf("SARS and influenza", "SARS and MERS", "SARS and HIV", "SARS and AIDS"),
        arrayOf("10", "40", "100", "120+"),
        arrayOf(
            "The virus can’t survive in hot, humid climates.",
            "Cold temperatures can kill the virus.",
            "It is not yet known.",
            "It likes all temperatures."
        ),
        arrayOf(
            "By drinking unclean water.",
            "Through droplets",
            "By making contact with blood.",
            "All of this"
        ),
        arrayOf("A new and continuous cough", "Fever", "Tiredness", "All of this"),
        arrayOf(
            "On public transport",
            "In confined or crowded spaces",
            "In small shops",
            "All of this"
        )
    )

    private val CorrectAnswers = arrayOf(
        "SARS and MERS",
        "120+",
        "It is not yet known.",
        "Through droplets",
        "All of this",
        "All of this"
    )

    fun getQuestion(a: Int): String {
        return Questions[a]
    }

    fun getAnswer1(a: Int): String {
        return Answers[a][0]
    }

    fun getAnswer2(a: Int): String {
        return Answers[a][1]
    }

    fun getAnswer3(a: Int): String {
        return Answers[a][2]
    }

    fun getAnswer4(a: Int): String {
        return Answers[a][3]
    }

    fun getCorrectAnswer(a: Int): String {
        return CorrectAnswers[a]
    }
}