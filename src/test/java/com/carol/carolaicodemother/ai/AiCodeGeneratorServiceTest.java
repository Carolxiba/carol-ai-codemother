package com.carol.carolaicodemother.ai;

import com.carol.carolaicodemother.ai.model.HtmlCodeResult;
import com.carol.carolaicodemother.ai.model.MultiFileCodeResult;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AiCodeGeneratorServiceTest {
    @Resource
    private AiCodeGeneratorService aiCodeGeneratorService;

    @Test
    void generateHtmlCode() {
        HtmlCodeResult htmlCodeResult = aiCodeGeneratorService.generateHtmlCode("做一个程序员carol的博客，不超过20行");
//        String s = (String) htmlCodeResult;
        Assertions.assertNotNull(htmlCodeResult);
//        System.out.println(s);
    }

    @Test
    void generateMultiFileCode() {
        MultiFileCodeResult multiFileCodeResult = aiCodeGeneratorService.generateMultiFileCode("做一个程序员carol的留言板,不超过50行");
//        String s = (String) multiFileCodeResult;
        Assertions.assertNotNull(multiFileCodeResult);
    }
}