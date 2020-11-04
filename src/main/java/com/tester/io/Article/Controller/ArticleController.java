package com.tester.io.Article.Controller;


import com.tester.io.Article.Model.ArticleDTO;
import com.tester.io.Article.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/articles")
    public List<ArticleDTO> getAllArticleDTOList() {
       return articleService.getAllArticleDTOList();
    }

    @RequestMapping("/articles/{id}")
    public ArticleDTO getArticleDTO(@PathVariable Long id) {
        return articleService.getArticle(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/articles")
    public void addArticle(@RequestBody ArticleDTO articleDTO) {
        articleService.addArticle(articleDTO);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/articles/{id}")
    public void updateArticle(@RequestBody ArticleDTO articleDTO, @PathVariable Long id) {
        articleService.updateArticle(articleDTO, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/articles/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }
}
