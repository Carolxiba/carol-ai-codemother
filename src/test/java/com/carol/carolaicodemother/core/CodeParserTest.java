package com.carol.carolaicodemother.core;

import com.carol.carolaicodemother.ai.model.HtmlCodeResult;
import com.carol.carolaicodemother.ai.model.MultiFileCodeResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeParserTest {

    @Test
    void parseHtmlCode() {
        String codeContent = """
                随便写一段描述：
                ```html
                <!DOCTYPE html>
                <html>
                <head>
                    <title>测试页面</title>
                </head>
                <body>
                    <h1>Hello World!</h1>
                </body>
                </html>
                ```
                随便写一段描述
                """;
        HtmlCodeResult result = CodeParser.parseHtmlCode(codeContent);
        assertNotNull(result);
        assertNotNull(result.getHtmlCode());
    }

    @Test
    void parseMultiFileCode() {
        String codeContent = """
                <!DOCTYPE html>
                <html lang="zh-CN">
                <head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1"><title>登录</title>
                <style>
                *{box-sizing:border-box;margin:0}body{min-height:100vh;display:grid;place-items:center;padding:20px;font-family:system-ui,"Microsoft YaHei",sans-serif;background:linear-gradient(135deg,#6366f1,#0ea5e9)}
                form{width:100%;max-width:360px;padding:32px;border-radius:16px;background:#fff;box-shadow:0 20px 40px rgba(0,0,0,.2);display:flex;flex-direction:column;gap:14px}
                h1{font-size:22px;text-align:center;color:#1e293b}
                input{padding:12px;font-size:15px;border:1px solid #cbd5e1;border-radius:8px;outline:none}input:focus{border-color:#6366f1;box-shadow:0 0 0 3px rgba(99,102,241,.2)}
                button{padding:12px;font-size:16px;color:#fff;background:#6366f1;border:0;border-radius:8px;cursor:pointer}button:hover{background:#4f46e5}
                p{font-size:13px;color:#64748b;text-align:center}p a{color:#6366f1;text-decoration:none}
                </style></head>
                <body>
                <form id="f">
                <h1>欢迎登录</h1>
                <input type="email" placeholder="邮箱" required>
                <input type="password" placeholder="密码" required minlength="6">
                <button>登 录</button>
                <p>还没有账号？<a href="#">立即注册</a></p>
                </form>
                <script>document.getElementById('f').addEventListener('submit',e=>{e.preventDefault();alert('登录成功，欢迎回来！');});</script></body>
                </html>
                """;
        MultiFileCodeResult result = CodeParser.parseMultiFileCode(codeContent);
        assertNotNull(result);
        assertNotNull(result.getHtmlCode());
        assertNotNull(result.getCssCode());
        assertNotNull(result.getJsCode());
    }
}
