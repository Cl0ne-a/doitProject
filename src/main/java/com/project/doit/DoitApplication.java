package com.project.doit;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Log
@SpringBootApplication
public class DoitApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoitApplication.class, args);
    }

    @Bean
    CommandLineRunner popData(UserRepository usRep, ArticleRepository artRep) {
        return args -> {
            log.info("Started CLRunner: ");

            log.info("---------User that occurs more than three times --------");

            for (DBUser user :
                    usRep.findAll()) {
                if(artRep.countDistinctByArticleReader(user)>3){
                    log.info("User " + user.getUserName() + " occures more than 3 times");
                }
            }


            log.info("---------age after ----------");
            Iterable<DBUser> list2 = usRep.findAllByAgeAfter(30);
            for (DBUser user :
                    list2) {
                log.info(user.toString());
            }


            log.info("---------user from article with colour GREEN ---------");
            List<DBArticle> list3 = artRep.findAllByColourEquals(Colour.GREEN);

            for (DBArticle article :
                    list3) {
                log.info("User " + article.getArticleReader().getUserName());
            }
        };
    }
}
