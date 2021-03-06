package cn.codeforfun.d2note.note.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author wangbin
 * @mail 253498229@qq.com
 * @qq 253498229
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoteNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 5820843273846674883L;
}
