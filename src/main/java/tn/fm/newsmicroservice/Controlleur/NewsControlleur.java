package tn.fm.newsmicroservice.Controlleur;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.fm.newsmicroservice.Model.News;
import tn.fm.newsmicroservice.Model.Writer;
import tn.fm.newsmicroservice.Service.NewsServices;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;


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
    @PostMapping("upload")
    public ResponseEntity<String> uploadFile(@RequestBody MultipartFile file) throws IOException {
        String filename= StringUtils.cleanPath(file.getOriginalFilename());
        Path filestorage =get(System.getProperty("user.home")+"/imgs/",filename)
                .toAbsolutePath().normalize();
        copy(file.getInputStream(),filestorage);
        return ResponseEntity.ok().body(filename);
    }

}
