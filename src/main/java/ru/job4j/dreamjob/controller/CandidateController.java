package ru.job4j.dreamjob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.dreamjob.store.CandidateStore;

/**
 * Класс связывает данные и вид
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 * @date 18.07.2022
 */

@Controller
public class CandidateController {
    private final CandidateStore store = CandidateStore.instOf();

    @GetMapping("/candidates")
    public String posts(Model model) {
        model.addAttribute("candidates", store.findAll());
        return "candidates";
    }
}
