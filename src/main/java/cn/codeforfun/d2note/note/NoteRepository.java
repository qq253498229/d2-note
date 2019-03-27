package cn.codeforfun.d2note.note;

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
public interface NoteRepository extends JpaRepository<Note, Long> {
    /**
     * 获取笔记列表关联账号
     *
     * @param username 用户名
     * @return 笔记列表
     */
    @Query("select distinct n from Note n left join fetch n.account where n.username=:username order by n.updateAt desc ")
    List<Note> findAllFetch(@Param("username") String username);

    /**
     * 获取笔记关联账号
     *
     * @param username 用户名
     * @param id       id
     * @return 笔记
     */
    @Query("select n from Note n left join fetch n.account where n.username=:username and n.id=:id")
    Optional<Note> findByIdFetch(@Param("username") String username, @Param("id") Long id);

    /**
     * 根据id和用户名删除笔记
     *
     * @param username 用户名
     * @param id       id
     */
    void deleteByIdAndUsername(@Param("id") Long id, @Param("username") String username);
}
