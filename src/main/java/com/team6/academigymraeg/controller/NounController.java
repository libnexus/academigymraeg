package com.team6.academigymraeg.controller;

import com.team6.academigymraeg.model.Gender;
import com.team6.academigymraeg.model.Noun;
import com.team6.academigymraeg.repo.NounRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class NounController {

    @Autowired
    private NounRepository nounRepo;

    @GetMapping("/noun")
    public String noun(Model m) {
        if (!m.containsAttribute("nouns")) {
            m.addAttribute("nouns", nounRepo.findAll());
        }
        return "noun";
    }

    @RequestMapping(value = "/noun", method = RequestMethod.GET, params = "edit")
    public String edit(Model m, @RequestParam(value = "edit", required = false) Integer nounID) {
        Optional<Noun> changeNoun = nounRepo.findById(nounID);

        return "noun";
    }


    @RequestMapping(value = "/noun", method = RequestMethod.GET, params = "delete")
    public String delete(Model m, @RequestParam(value = "delete", required = false) Integer nounID) {
        Optional<Noun> changeNoun = nounRepo.findById(nounID);
        if (!changeNoun.isEmpty()){
            nounRepo.deleteById(nounID);
        }
        return noun(m);
    }


    @RequestMapping(value = "/add-noun", method = RequestMethod.GET, params = { "add" } )
    public String add(Model m,
                      @RequestParam(value = "nounID", required = false) Integer nounID,
                      @RequestParam(value = "english", required = false) String english,
                      @RequestParam(value = "welsh", required = false) String welsh,
                      @RequestParam(value = "gender", required = false) String gender) {
        nounRepo.save(new Noun(-2, english, welsh, Gender.FEMALE));

        return "noun";
    }
}
