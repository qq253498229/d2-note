package cn.codeforfun.d2note.note;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

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
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, length = 32)
    private String name;

    public Note(String name) {
        this.name = name;
    }
}
