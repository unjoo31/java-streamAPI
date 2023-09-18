package shop.mtcoding.demo.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardListDTO {
    private Integer id;
    private String title;
    private String author;

    // 깊은 복사
    public BoardListDTO(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.author = board.getAuthor();
    }
}
