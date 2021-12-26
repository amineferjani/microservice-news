package tn.fm.newsmicroservice.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.fm.newsmicroservice.Model.News;
import tn.fm.newsmicroservice.Model.Writer;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Repository
public interface NewsRepo extends JpaRepository<News, Long> {
    Optional<List<News>> findByTitleContaining(String title);
    Optional<List<News>> findByContentContaining(String content);
    Optional<List<News>> findAllByAddedTime(LocalDateTime addedtime);
    Optional<List<News>> findTop10ByOrderByAddedTimeDesc();
    Optional<List<News>> findAllByWriter(Writer writer);
    @Transactional
    @Query("SELECT n from News n order by n.addedTime Desc")
    Optional<List<News>> getlatestNews();

}
