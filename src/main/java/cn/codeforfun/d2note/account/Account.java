package cn.codeforfun.d2note.account;

import cn.codeforfun.d2note.note.Note;
import cn.codeforfun.d2note.util.JsonUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author wangbin
 * @mail 253498229@qq.com
 * @qq 253498229
 */
@Entity
@Data
@NoArgsConstructor
public class Account implements Serializable {
    private static final long serialVersionUID = -5605471569191196855L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "account")
    @JsonIgnoreProperties({"accounts", "account"})
    private List<Note> notes;

    private Date updateAt = new Date();

    Account(String name) {
        this.name = name;
    }

    Account(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    String toJson() {
        return JsonUtil.toJson(this);
    }
}
