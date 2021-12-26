package tn.fm.newsmicroservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Writer {
    @Id
    private Long id;
    private String name;
    private String email;
    private String tel;
    private String login;
    private String password;
    private String url_logo;
}
