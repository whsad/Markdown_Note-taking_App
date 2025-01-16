package com.kirito.note_app.controller;

import com.kirito.note_app.ResponseResult;
import com.vladsch.flexmark.ext.anchorlink.AnchorLinkExtension;
import com.vladsch.flexmark.ext.autolink.AutolinkExtension;
import com.vladsch.flexmark.ext.emoji.EmojiExtension;
import com.vladsch.flexmark.ext.footnotes.FootnoteExtension;
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.ext.gfm.tasklist.TaskListExtension;
import com.vladsch.flexmark.ext.jekyll.tag.JekyllTagExtension;
import com.vladsch.flexmark.ext.superscript.SuperscriptExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.ext.toc.TocExtension;
import com.vladsch.flexmark.ext.yaml.front.matter.YamlFrontMatterExtension;
import com.vladsch.flexmark.ext.youtube.embedded.YouTubeLinkExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import com.vladsch.flexmark.util.misc.Extension;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

    @GetMapping("/test")
    public String test(){
        MutableDataSet options = new MutableDataSet();

        // 启用所有扩展
        List<Extension> allExtensions = Arrays.asList(
                TablesExtension.create(),
                StrikethroughExtension.create(),
                AutolinkExtension.create(),
                FootnoteExtension.create(),
                EmojiExtension.create(),
                AnchorLinkExtension.create(),
                TocExtension.create(),
                SuperscriptExtension.create(),
                JekyllTagExtension.create(),
                YamlFrontMatterExtension.create(),
                YouTubeLinkExtension.create(),
                TaskListExtension.create()
        );

        options.set(Parser.EXTENSIONS, allExtensions);

        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        String source3 = "以下是一个完整的包含了 Markdown 所有主要语法的示例：\n" +
                "\n" +
                "---\n" +
                "\n" +
                "# Markdown 语法示例\n" +
                "\n" +
                "## 1. 标题\n" +
                "使用 `#` 表示不同级别的标题：\n" +
                "```markdown\n" +
                "# 一级标题\n" +
                "## 二级标题\n" +
                "### 三级标题\n" +
                "#### 四级标题\n" +
                "##### 五级标题\n" +
                "###### 六级标题\n" +
                "```\n" +
                "\n" +
                "## 2. 强调\n" +
                "- **加粗**: `**加粗**` 或 `__加粗__`\n" +
                "- *斜体*: `*斜体*` 或 `_斜体_`\n" +
                "- ~~删除线~~: `~~删除线~~`\n" +
                "\n" +
                "示例：\n" +
                "**加粗**  \n" +
                "*斜体*  \n" +
                "~~删除线~~\n" +
                "\n" +
                "## 3. 列表\n" +
                "### 无序列表\n" +
                "使用 `-`、`+` 或 `*` 开始一行：\n" +
                "```markdown\n" +
                "- 项目 1\n" +
                "- 项目 2\n" +
                "  - 子项目 1\n" +
                "  - 子项目 2\n" +
                "```\n" +
                "结果：\n" +
                "- 项目 1\n" +
                "- 项目 2\n" +
                "  - 子项目 1\n" +
                "  - 子项目 2\n" +
                "\n" +
                "### 有序列表\n" +
                "使用数字加点：\n" +
                "```markdown\n" +
                "1. 项目 1\n" +
                "2. 项目 2\n" +
                "   1. 子项目 1\n" +
                "   2. 子项目 2\n" +
                "```\n" +
                "结果：\n" +
                "1. 项目 1\n" +
                "2. 项目 2\n" +
                "   1. 子项目 1\n" +
                "   2. 子项目 2\n" +
                "\n" +
                "## 4. 链接与图片\n" +
                "### 链接\n" +
                "```markdown\n" +
                "[这是一个链接](https://www.example.com)\n" +
                "```\n" +
                "结果：[这是一个链接](https://www.example.com)\n" +
                "\n" +
                "### 图片\n" +
                "```markdown\n" +
                "![替代文本](https://www.example.com/image.png)\n" +
                "```\n" +
                "结果：  \n" +
                "![替代文本](https://www.example.com/image.png)\n" +
                "\n" +
                "## 5. 引用\n" +
                "使用 `>` 表示引用：\n" +
                "```markdown\n" +
                "> 这是一个引用\n" +
                ">> 嵌套引用\n" +
                "```\n" +
                "结果：\n" +
                "> 这是一个引用  \n" +
                ">> 嵌套引用  \n" +
                "\n" +
                "## 6. 代码\n" +
                "### 行内代码\n" +
                "使用反引号：  \n" +
                "```markdown\n" +
                "`行内代码`\n" +
                "```\n" +
                "结果：`行内代码`\n" +
                "\n" +
                "### 块代码\n" +
                "使用三个反引号：\n" +
                "```markdown\n" +
                "```\n" +
                "这是块代码\n" +
                "```\n" +
                "```\n" +
                "结果：\n" +
                "```\n" +
                "这是块代码\n" +
                "```\n" +
                "\n" +
                "还可以指定语言高亮：\n" +
                "```markdown\n" +
                "```javascript\n" +
                "console.log(\"Hello, Markdown!\");\n" +
                "```\n" +
                "```\n" +
                "结果：\n" +
                "```javascript\n" +
                "console.log(\"Hello, Markdown!\");\n" +
                "```\n" +
                "\n" +
                "## 7. 分隔线\n" +
                "使用 `---`、`***` 或 `___`：\n" +
                "```markdown\n" +
                "---\n" +
                "```\n" +
                "结果：\n" +
                "---\n" +
                "\n" +
                "## 8. 表格\n" +
                "使用管道 `|` 和连字符 `-`：\n" +
                "```markdown\n" +
                "| 标题1 | 标题2 | 标题3 |\n" +
                "|-------|-------|-------|\n" +
                "| 内容1 | 内容2 | 内容3 |\n" +
                "| 内容A | 内容B | 内容C |\n" +
                "```\n" +
                "结果：\n" +
                "\n" +
                "| 标题1 | 标题2 | 标题3 |\n" +
                "|-------|-------|-------|\n" +
                "| 内容1 | 内容2 | 内容3 |\n" +
                "| 内容A | 内容B | 内容C |\n" +
                "\n" +
                "## 9. 任务列表\n" +
                "使用 `- [ ]` 和 `- [x]`：\n" +
                "```markdown\n" +
                "- [x] 已完成任务\n" +
                "- [ ] 未完成任务\n" +
                "```\n" +
                "结果：\n" +
                "- [x] 已完成任务\n" +
                "- [ ] 未完成任务\n" +
                "\n" +
                "## 10. HTML 支持\n" +
                "Markdown 中可以嵌入 HTML：\n" +
                "```markdown\n" +
                "<p style=\"color: red;\">这是一个红色的段落。</p>\n" +
                "```\n" +
                "结果：  \n" +
                "<p style=\"color: red;\">这是一个红色的段落。</p>\n" +
                "\n" +
                "---\n" +
                "\n" +
                "希望这个示例对你有帮助！ \uD83D\uDE0A";
        String htmlContent = renderer.render(parser.parse(source3));

        String styledHtml =
                "<html>\n" +
                        "  <head>\n" +
                        "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/github-markdown-css/5.1.0/github-markdown.min.css\">\n" +
                        "  </head>\n" +
                        "  <body class=\"markdown-body\">\n" +
                        "    " + htmlContent + "\n" +
                        "  </body>\n" +
                        "</html>";
        // 输出 HTML
        return styledHtml;
    }

    @GetMapping("/test1")
    public String test1(){
        // Markdown 文本示例
        String markdownText =
                "# Hello, Markdown!\n" +
                        "This is a **flexmark-all** example.\n\n" +
                        "## Features\n" +
                        "- Converts Markdown to HTML\n" +
                        "- Supports **tables**, **lists**, and more\n\n" +
                        "| Header 1 | Header 2 |\n" +
                        "|----------|----------|\n" +
                        "| Row 1    | Value 1  |\n" +
                        "| Row 2    | Value 2  |\n";

        // 配置解析器和渲染器
        MutableDataSet options = new MutableDataSet();
        options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create())); // 支持表格扩展
        //
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        // 解析 Markdown 并生成 HTML
        String htmlContent = renderer.render(parser.parse(markdownText));

        // 添加 GitHub 样式
        String styledHtml =
                "<html>\n" +
                        "  <head>\n" +
                        "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/github-markdown-css/5.1.0/github-markdown.min.css\">\n" +
                        "  </head>\n" +
                        "  <body class=\"markdown-body\">\n" +
                        "    " + htmlContent + "\n" +
                        "  </body>\n" +
                        "</html>";

        // 输出 HTML
        return styledHtml;
    }

    @GetMapping("/test2")
    public String test2(){
        String markdown = "- [ ] Task 1\n- [x] Task 2\n- [ ] Task 3";

        // 初始化解析器和渲染器，启用 TaskListExtension
        Parser parser = Parser.builder()
                .extensions(Collections.singleton(TaskListExtension.create()))
                .build();
        HtmlRenderer renderer = HtmlRenderer.builder()
                .extensions(Collections.singleton(TaskListExtension.create()))
                .build();

        // 解析 Markdown 文本
        Node document = parser.parse(markdown);
        String html = renderer.render(document);

        // 输出渲染后的 HTML
        return html;
    }

    @PostMapping("/renderer")
    public ResponseResult MarkdownRenderer(String markdown){
        if (!StringUtils.hasText(markdown)){
            return new ResponseResult("");
        }
        MutableDataSet options = new MutableDataSet();

        List<Extension> allExtensions = Arrays.asList(
                TablesExtension.create(),
                StrikethroughExtension.create(),
                AutolinkExtension.create(),
                FootnoteExtension.create(),
                EmojiExtension.create(),
                AnchorLinkExtension.create(),
                TocExtension.create(),
                SuperscriptExtension.create(),
                JekyllTagExtension.create(),
                YamlFrontMatterExtension.create(),
                YouTubeLinkExtension.create(),
                TaskListExtension.create()
        );

        options.set(Parser.EXTENSIONS, allExtensions);

        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();
        String render = renderer.render(parser.parse(markdown));

        return new ResponseResult(render);

    }
}
