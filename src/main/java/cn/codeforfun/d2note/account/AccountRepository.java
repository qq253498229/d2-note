package cn.codeforfun.d2note.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author wangbin
 * @mail 253498229@qq.com
 * @qq 253498229
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    /**
     * 查询账号列表关联记录
     *
     * @param username 用户名
     * @return 账号列表
     */
    @Query("select distinct a from Account a left join fetch a.notes where a.username=:username order by a.updateAt desc ")
    List<Account> findAllFetch(@Param("username") String username);

    /**
     * 查询账号关联记录
     *
     * @param id       id
     * @param username 用户名
     * @return 账号
     */
    @Query("select a from Account a left join fetch a.notes where a.username=:username and a.id=:id")
    Optional<Account> findByIdFetch(@Param("username") String username, @Param("id") Long id);

    /**
     * 根据id和用户名删除账号
     *
     * @param username 用户名
     * @param id       id
     */
    void deleteByIdAndUsername(@Param("id") Long id, @Param("username") String username);
}
