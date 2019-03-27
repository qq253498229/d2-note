package cn.codeforfun.d2note.account;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author wangbin
 * @mail 253498229@qq.com
 * @qq 253498229
 */
@Entity
@Data
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
}
