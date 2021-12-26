package tn.fm.newsmicroservice.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data @NoArgsConstructor
@Entity
public class News {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    private LocalDateTime addedTime;
    private Boolean enabled=true;
    private int priority=1;
    @ManyToOne
    private Writer writer;

    public News(String title, String content, LocalDateTime addedTime) {
        this.title = title;
        this.content = content;
        this.addedTime = addedTime;
    }

}
