package com.rubypaper.controller;

import com.rubypaper.domain.BoardVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class BoardController {
    public BoardController() {
        //자동입력 : sout + tab  또는 sout + enter
        System.out.println("===> BoardController 생성");
        System.out.println("===> BoardController 생성. 자동 반영 테스트");
        System.out.println("자동 리로드... 브라우저의 live reload 추가");
    }

    @GetMapping("/hello")
    public String hello(String name){
        return "Hello : " + name;
    }

    // 추가 코드 56)
    @GetMapping("/getBoard")
    public BoardVO getBoard(){
        BoardVO board = new BoardVO();
        board.setSeq(1);
        board.setTitle("테스트 제목");
        board.setWriter("표선영 강사");
        board.setContent("테스트 내용입니다. 자동 리로드 테스트.브라우저의 live reload 추가.....");
        board.setCreateDate(new Date());
        board.setCnt(0);
        return board;
    }

    // 추가 코드 58)
    @GetMapping("/getBoardList")
    public List<BoardVO> getBoardList() {
        List<BoardVO> boardList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            BoardVO board = new BoardVO();
            board.setSeq(i);
            board.setTitle("제목" + i);
            board.setWriter("테스터");
            board.setContent(i + "번 내용입니다.");
            board.setCreateDate(new Date());
            board.setCnt(0);
            boardList.add(board);
        }
        return boardList;
    }


}

/*
@RestController
    : Restful web API 를 좀 더 쉽게 만들기 위해서 spring 4.0 에 도입
@Controller 와 @ResponseBody 를 합쳐놓은 어노테이션
@Controller : 해당 클래스를 쵸엉을 처리하는 커트롤러로 사용
@ResponseBody: 자바 객체를 HTTP 응답 본문의 객체로 변환해 Clinet 에게 전송 
    이를 통해 따로 html 파일을 만들지 않아도 웹 브라우저에 Hello:name(인자값) 라는 문자열을 출력
*/

/*
@GetMapping("/hello") 은 기존의
@RequestMapping(value = "/hello", method = RequestMethod.GET) 과 동일한 설정
*/
