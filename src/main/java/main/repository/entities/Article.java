package main.repository.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Article {
	
	@Id
	@JoinColumn
	@GeneratedValue
	private long id;
	private String name;	
	private String description;	
	private String area;	
	private String source;	
	private int rating;
	private String url;
	private Date saveDate;	
	private Date publishDate;	
	private boolean favourite;
	
	@ManyToMany
	@JoinTable(
			name = "article_tags", 
			joinColumns = @JoinColumn(name = "article_id"), 
			inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<ArticleTag> articleTags;
	
	public Article() {
	}
	
	public Article(String name,String url) {
		this.name = name;
		this.url = url;
	}
	
	public Article(String name,String url,List<ArticleTag> articleTags) {
		this.name = name;
		this.url = url;
		this.articleTags = articleTags;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<ArticleTag> getTagList() {
		return articleTags;
	}

	public void setTagList(List<ArticleTag> articleTags) {
		this.articleTags = articleTags;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getSaveDate() {
		return saveDate;
	}

	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public boolean getFavourite() {
		return favourite;
	}

	public void setFavourite(boolean favourite) {
		this.favourite = favourite;
	}	
}
