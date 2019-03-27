package cn.codeforfun.d2note.note;

import cn.codeforfun.d2note.account.Account;
import cn.codeforfun.d2note.util.JsonUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author wangbin
 * @mail 253498229@qq.com
 * @qq 253498229
 */
@Data
@Entity
@NoArgsConstructor
public class Note implements Serializable {

    private static final long serialVersionUID = 5682218674157894432L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 32)
    private String name;

    @ManyToOne
    @JsonIgnoreProperties({"notes", "note"})
    private Account account;

    private Date updateAt = new Date();

    @Column(nullable = false, length = 64)
    private String username;

    Note(String name) {
        this.name = name;
    }

    Note(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    String toJson() {
        return JsonUtil.toJson(this);
    }
}
