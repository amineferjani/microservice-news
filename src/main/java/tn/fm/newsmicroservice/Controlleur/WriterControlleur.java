package tn.fm.newsmicroservice.Controlleur;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.fm.newsmicroservice.Model.Writer;
import tn.fm.newsmicroservice.Service.WriterService;

import java.util.List;

@RestController
@RequestMapping("api/writer")
@AllArgsConstructor
public class WriterControlleur {
    private final WriterService writerService;

    @PostMapping
    public Writer addWriter(@RequestBody Writer writer){
        return writerService.addWriter(writer);
    }
    @PutMapping
    public Writer updateWriter(@RequestBody Writer writer){
        return writerService.updateWriter(writer);
    }
    @GetMapping
    public List<Writer> getAllWriter(){
        return writerService.getAllWriter();
    }
}
