package com.project.doit.Web;

import com.project.doit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArticleRepository articleRepository;


    public DBUser saveUser(DBUser user) {
        DBUser o = new DBUser();
        try {
            user.getUserPassword().equals(o.getUserPassword());
        } catch (UserDuplicate duplicate) {
            duplicate.getMessage();
        }
        userRepository.save(user);
        return user;
    }

    public List<DBUser> listAllUsers(){
        return userRepository.findAll();
    }
    public DBUser getUser(int id){
        return userRepository.findById(id);
    }
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

    public List <DBUser> byAgeAfter(int age){
        return (List<DBUser>) userRepository.findAllByAgeAfter(age);
    }

    public DBArticle saveArticle(DBArticle article){
        return articleRepository.save(article);
    }

    public List <DBArticle> listAllArticles(){
        return articleRepository.findAll();
    }

    public List <DBArticle> byArticleColour(Colour colour){
        Iterable<DBArticle> list3 = articleRepository.findAllByColourEquals(colour);
        for (DBArticle article :
                list3) {
            Logger.getLogger("log").info("User " + article.getArticleReader().getUserName());
        }
        return (List<DBArticle>) list3;
    }

    public List<DBUser> getUsersThatOwnMoreThanOccArticles() {
        List<DBUser>frequentlyMetInArticleDatabase = null;
        for (DBUser user :
                userRepository.findAll()) {
            if(articleRepository.countDistinctByArticleReader(user)>3){
                frequentlyMetInArticleDatabase.add(user);
                System.out.println("User " + user.getUserName() + " occures more than 3 times");
            }
        }
        return frequentlyMetInArticleDatabase;
    }


}
