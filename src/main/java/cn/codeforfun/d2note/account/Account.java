package cn.codeforfun.d2note.account;

import cn.codeforfun.d2note.util.JsonUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

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
    @GeneratedValue
    private Integer id;
    private String name;

    public Account(String name) {
        this.name = name;
    }

    public Account(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toJson() {
        return JsonUtil.toJson(this);
    }
}
