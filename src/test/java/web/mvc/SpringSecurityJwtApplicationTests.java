package web.mvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import web.mvc.domain.Board;
import web.mvc.domain.Member;
import web.mvc.repository.BoardRepository;
import web.mvc.repository.MemberRepository;

@SpringBootTest
@Transactional
@Commit
class SpringSecurityJwtApplicationTests {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 관리자 등록
     */
//    // @Test
//    void memberInsert() {
//        String encPwd = passwordEncoder.encode("1234");
//
//        memberRepository.save(Member.builder().id("admin").pwd(encPwd)
//                .role(
//                        "ROLE_ADMIN").address("오리역").name("장희정").build());
//    }

    /**
     * 게시물 등록
     */
    //@Test
    void boardInsert() {
        String encPwd = passwordEncoder.encode("1234");

        Member member = memberRepository.save(Member.builder().id("kk").pwd(encPwd)
                .role(
                        "ROLE_USER").address("오리역").name("오리").build());


        for (int i = 1; i < 500; i++) {
            boardRepository.save(Board.builder().title("test" + i).content("test" + i + " 입니다.").member(member).build());
        }
    }
}