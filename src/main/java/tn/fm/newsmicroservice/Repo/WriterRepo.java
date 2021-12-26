package tn.fm.newsmicroservice.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.fm.newsmicroservice.Model.Writer;
@Repository
public interface WriterRepo extends JpaRepository<Writer,Long> {
}
