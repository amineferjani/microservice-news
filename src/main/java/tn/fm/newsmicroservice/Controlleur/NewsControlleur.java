package tn.fm.newsmicroservice.Controlleur;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.fm.newsmicroservice.Model.News;
import tn.fm.newsmicroservice.Model.Writer;
import tn.fm.newsmicroservice.Service.NewsServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/news")
@AllArgsConstructor
public class NewsControlleur {
    private final NewsServices newsServices;
    @GetMapping
    public List<News> getAllNews(){
        return newsServices.getAllNews();
    }
    @GetMapping(path="findt/{title}")
    public Optional<List<News>> getNewsByTitle(@PathVariable String title){
        return newsServices.findNewsByTitle(title);
    }
    @GetMapping(path="findc/{content}")
    public Optional<List<News>> getNewsByContent(@PathVariable String content){
        return newsServices.findNewsByContent(content);
    }
    @GetMapping(path="latest")
    public Optional<List<News>> getLatestNews(){
        return newsServices.getLastestNews();
    }
    @PostMapping(path="add")
    public News addNews(@RequestBody News news){
        return newsServices.addNews(news);
    }
    @PutMapping
    public News updateNews(@RequestBody News news){
        return newsServices.updateNews(news);
    }
    @PostMapping("writers")
    public Optional<List<News>> getByWriter(Writer writer){
        return newsServices.getByWriter(writer);
    }
    @DeleteMapping
    public void deleteNews(News news){
        newsServices.deleteNews(news);
    }

}
