package tn.fm.newsmicroservice.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.fm.newsmicroservice.Model.Writer;
import tn.fm.newsmicroservice.Repo.WriterRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class WriterService {
    private final WriterRepo writerRepo;
    public Writer addWriter(Writer writer){
        return writerRepo.save(writer);
    }
    public Writer updateWriter(Writer writer){
        return writerRepo.save(writer);
    }
    public List<Writer> getAllWriter(){
        return writerRepo.findAll();
    }
}
