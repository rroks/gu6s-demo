package fen.fen.model.query;

import lombok.Data;

/**
 * @author chenyufeng
 */
@Data
public class FindPagedUsersQuery {
    String username;
    Integer pageIndex;
    Integer pageSize;
}
