package shop.mtcoding.demo.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class Board {
    private Integer id;
    private Integer title;
    private Integer content;
    private Integer author;

    @Builder
    public Board(Integer id, Integer title, Integer content, Integer author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
