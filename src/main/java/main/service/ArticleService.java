package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.exceptions.ArticleNotFoundException;
import main.repository.ArticleRepository;
import main.repository.entities.Article;
import main.repository.entities.ArticleTag;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository repo;	
	
	@Autowired
	private ArticleTagService tagService;
	
	public Article createArticle(Article newArticle) {
		return repo.save(newArticle);		
	}
	
	public Article updateArticle(Article article, Long id) {
		Article toUpdate = repo.getOne(id);
		toUpdate.setName(article.getName());
		toUpdate.setDescription(article.getDescription());
		toUpdate.setSource(article.getSource());		
		toUpdate.setUrl(article.getUrl());
		toUpdate.setRating(article.getRating());
		toUpdate.setTagList(article.getTagList());
		toUpdate.setFavourite(article.getFavourite());
		return repo.save(toUpdate);		
	}
	
	public String deleteArticle(Long id) {
		repo.deleteById(id);
		return "Article Deleted";
	}
	
	public List<Article> getArticles() {
		return repo.findAll();
	}
	
	public Article findArticleByID(Long id) {
		return this.repo.findById(id).orElseThrow(ArticleNotFoundException::new);
	}

	public Article addTagToArticle(Long id, ArticleTag tag) {
		Article toUpdate = findArticleByID(id);
		ArticleTag newTag = this.tagService.createArticleTag(tag);
		if (!(toUpdate.getTagList().contains(newTag))) {
			toUpdate.getTagList().add(newTag);			 
		}		
		return this.repo.saveAndFlush(toUpdate);
	}

	public Article toggleFavouriteArticle(Long id) {
		Article toUpdate = findArticleByID(id);
		toUpdate.setFavourite(!toUpdate.getFavourite());				
		return this.repo.saveAndFlush(toUpdate);
	}
}
