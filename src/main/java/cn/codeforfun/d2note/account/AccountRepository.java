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
public interface AccountRepository extends JpaRepository<Account, Integer> {
    /**
     * 查询账号列表关联记录
     *
     * @return 账号列表
     */
    @Query("select a from Account a left join fetch a.notes")
    List<Account> findAllFetch();

    /**
     * 查询账号关联记录
     *
     * @param id id
     * @return 账号
     */
    @Query("select a from Account a left join fetch a.notes where a.id=:id")
    Optional<Account> findByIdFetch(@Param("id") Integer id);
}
