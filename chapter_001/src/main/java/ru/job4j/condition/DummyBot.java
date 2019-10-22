package ru.job4j.condition;

    public class DummyBot {

        /**
         * Подбор правильного ответа в зависимости от введенной строки.
         * @param question
         * @return
         */
        public static String answer(String question) {
            String rsl = "Это ставит меня в тупик. Задайте другой вопрос.";
            if ("Привет, Бот.".equals(question)) {
                rsl = "Привет, умник.";
            } else if ("Пока.".equals(question)) {
                rsl = "До скорой встречи.";
            }
            return rsl;
        }

    }
