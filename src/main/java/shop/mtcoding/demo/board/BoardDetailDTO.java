package shop.mtcoding.demo.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 객체를 sysout하면 toString이 자동 호출됨.
@ToString
@Getter @Setter
public class BoardDetailDTO {
    private Integer id;
    private String title;
    private String content;
    private String author;

    // 깊은 복사
    public BoardDetailDTO(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.author = board.getAuthor();
    }  
}
