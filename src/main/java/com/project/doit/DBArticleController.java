package com.project.doit;

import com.project.doit.Web.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class DBArticleController {

    @Autowired
    public UserService userService;
    private String text;

    @GetMapping(value = "/dbarticle", produces = "application/json")
    public List<DBArticle> listArticles(){
        return userService.listAllArticles();
    }

    @GetMapping("findByColour/{colour}")
    public Iterable<DBArticle>  findByColour(@PathVariable("colour") Colour colour){
        return userService.byArticleColour(colour);
    };

     @PostMapping( "/add/{text}/{colour}/{reference}")
     public @ResponseBody String addArticle(
             @ModelAttribute DBArticle article,
             @PathVariable ("text")String text,
             @PathVariable("colour")Colour colour,
             @PathVariable ("reference")int reference,
             Model model){
        model.addAttribute(article);
        //testing to  add article.setText(text); article.setColour(Colour.GREEN); article.setReference(15);
        userService.saveArticle(article);
        return "added";
    }



}
