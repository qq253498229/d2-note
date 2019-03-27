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
public interface NoteRepository extends JpaRepository<Note, Integer> {
    /**
     * 获取笔记列表关联账号
     *
     * @return 笔记列表
     */
    @Query("select n from Note n left join fetch n.account order by n.updateAt desc ")
    List<Note> findAllFetch();

    /**
     * 获取笔记关联账号
     *
     * @param id id
     * @return 笔记
     */
    @Query("select n from Note n left join fetch n.account where n.id=:id")
    Optional<Note> findByIdFetch(@Param("id") Integer id);
}
