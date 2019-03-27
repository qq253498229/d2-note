package cn.codeforfun.d2note.note;

import cn.codeforfun.d2note.account.Account;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author wangbin
 * @mail 253498229@qq.com
 * @qq 253498229
 */
@Data
@Entity
@NoArgsConstructor
@JsonIgnoreProperties({"notes", "note"})
public class Note implements Serializable {

    private static final long serialVersionUID = 5682218674157894432L;

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, length = 32)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "t_account_note",
            joinColumns = @JoinColumn(name = "note_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id")
    )
    private List<Account> accounts;

    public Note(String name) {
        this.name = name;
    }
}
