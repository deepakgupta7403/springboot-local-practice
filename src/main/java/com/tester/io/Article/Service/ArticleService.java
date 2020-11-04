package com.tester.io.Article.Service;


import com.tester.io.Article.Model.ArticleDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ArticleService {

    List<ArticleDTO> articleDTOList = new ArrayList<>(Arrays.asList(new ArticleDTO(1,"Article 01","Description 1"),
            new ArticleDTO(2,"Article 02","Description 2"),
            new ArticleDTO(3,"Article 03","Description 3"),
            new ArticleDTO(4,"Article 04","Description 4")
    ));


    public List<ArticleDTO> getAllArticleDTOList() {
        return articleDTOList;
    }

    public ArticleDTO getArticle(long id) {
        return articleDTOList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }


    public void addArticle(ArticleDTO articleDTO) {
        articleDTOList.add(articleDTO);
    }


    public void updateArticle(ArticleDTO article, Long id) {
        for (int i = 0;i < articleDTOList.size() ; i++) {
            ArticleDTO articleDTO = articleDTOList.get(i);
            if (articleDTO.getId().equals(id)) {
                articleDTOList.set(i,article);
            }
        }
    }

    public void deleteArticle(Long id) {

        articleDTOList.removeIf(t -> t.getId().equals(id));

//        List<ArticleDTO> removeList = new ArrayList<>();
//        for (int i = 0;i < articleDTOList.size() ; i++) {
//            ArticleDTO articleDTO = articleDTOList.get(i);
//            if (articleDTO.getId().equals(id)) {
//                removeList.add(articleDTO);
//            }
//        }
//        articleDTOList.removeAll(removeList);
    }
}
