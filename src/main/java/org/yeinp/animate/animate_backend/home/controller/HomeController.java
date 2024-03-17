package org.yeinp.animate.animate_backend.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yeinp.animate.animate_backend.adoption.repository.AdoptionRepository;
import org.yeinp.animate.animate_backend.home.dto.HomeARDto;

import java.util.List;
@Controller
@CrossOrigin("http://localhost:3000")
public class HomeController {

    @Autowired
    AdoptionRepository adoptionRepository;
    @GetMapping("/home/review/best")
    @ResponseBody
    public List<HomeARDto> getHomeARbest(){
        return adoptionRepository.findTop3HomeARDtoList();
    }
}
