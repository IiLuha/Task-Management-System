package com.itdev.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "email")
@ToString(exclude = {"taskAuthor", "taskExecutor"})
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class User implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private TaskAuthor taskAuthor;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private TaskExecutor taskExecutor;

    public void addAuthor(@NonNull TaskAuthor taskAuthor) {
        this.taskAuthor = taskAuthor;
        taskAuthor.setUser(this);
    }

    public void addExecutor(@NonNull TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
        taskExecutor.setUser(this);
    }
}
