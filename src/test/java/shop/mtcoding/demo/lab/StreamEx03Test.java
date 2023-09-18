package shop.mtcoding.demo.lab;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import shop.mtcoding.demo.board.Board;
import shop.mtcoding.demo.board.BoardDetailDTO;
import shop.mtcoding.demo.board.BoardListDTO;

public class StreamEx03Test {
    
    @Test
    public void ex02(){
        Board b1 = Board.builder()
            .id(1)
            .title("제목1")
            .content("내용1")
            .author("ssar")
            .build();
        Board b2 = Board.builder()
            .id(1)
            .title("제목2")
            .content("내용2")
            .author("ssar")
            .build();
        Board b3 = Board.builder()
            .id(1)
            .title("제목3")
            .content("내용3")
            .author("cos")
            .build();
        List<Board> boardList = Arrays.asList(b1, b2, b3);
        // 1.stream을 통해서 담는다
        // 2.filter를 이용해서 author가 "cos"인 것을 제거한다. content에 1이 포함되어 있는 게시글도 제거한다.
        // 3.map을 사용해서 데이터를 가공한다
        // 4.stream을 수집한다
        List<BoardListDTO> responseDTOs = boardList.stream()
                                                .filter(board -> !board.getAuthor().equals("cos"))
                                                .filter(board -> !board.getContent().contains("1"))
                                                .map(board -> new BoardListDTO(board))
                                                .collect(Collectors.toList());
        System.out.println(responseDTOs);
    }

    @Test
    public void ex01(){
        Board board = Board.builder()
            .id(1)
            .title("제목1")
            .content("내용1")
            .author("ssar")
            .build();

        BoardDetailDTO reaponseDto = new BoardDetailDTO(board);
    }
}
