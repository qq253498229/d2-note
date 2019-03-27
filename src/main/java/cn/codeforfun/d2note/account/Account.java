package cn.codeforfun.d2note.account;

import cn.codeforfun.d2note.note.Note;
import cn.codeforfun.d2note.util.JsonUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@JsonIgnoreProperties({"accounts", "account"})
public class Account implements Serializable {
    private static final long serialVersionUID = -5605471569191196855L;
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @OneToMany
    private List<Note> notes;

    private Date updateAt = new Date();

    Account(String name) {
        this.name = name;
    }

    Account(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    String toJson() {
        return JsonUtil.toJson(this);
    }
}
