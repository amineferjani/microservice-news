package tn.fm.newsmicroservice.Service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.fm.newsmicroservice.Model.News;
import tn.fm.newsmicroservice.Model.Writer;
import tn.fm.newsmicroservice.Repo.NewsRepo;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NewsServices {
    private final NewsRepo newsRepo;

    public List<News> getAllNews(){
        return newsRepo.findAll();
    }
    public Optional<List<News>> findNewsByTitle(String title){
        return newsRepo.findByTitleContaining(title);
    }
    public Optional<List<News>> findNewsByContent(String content){
        return newsRepo.findByContentContaining(content);
    }
    public Optional<List<News>> getLastestNews(){
        return newsRepo.findTop10ByOrderByAddedTimeDesc();
    }
    public Optional<List<News>> getByWriter(Writer writer){
        return newsRepo.findAllByWriter(writer);
    }
    public News addNews(News news){
        return newsRepo.save(news);
    }
    public News updateNews(News news){
        return newsRepo.save(news);
    }
    public void deleteNews(News news){
        newsRepo.delete(news);
    }

}
