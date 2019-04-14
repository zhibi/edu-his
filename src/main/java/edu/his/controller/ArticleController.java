package edu.his.controller;

import com.github.pagehelper.PageInfo;
import edu.his.extra.base.BaseController;
import edu.his.service.ArticleService;
import edu.his.vo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zhibi.commons.exception.MessageException;
import zhibi.frame.domain.Page;
import zhibi.frame.mybatis.example.Example;
import zhibi.frame.mybatis.example.ExampleType;

import java.util.Date;

@RequestMapping("article")
@Controller
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    /**
     * 列表
     *
     * @param article
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("list/{type}")
    public String list(Article article, Page page, Model model,@PathVariable String type) {
        Example example = Example.getInstance()
                .addParam("title", article.getTitle(), ExampleType.Operation.LIKE)
                .addParam("type", type, ExampleType.Operation.LIKE)
                .addOrder("addtime", ExampleType.OrderType.DESC);
        PageInfo<Article> pageInfo = articleService.selectByExample(example, page);
        setModelAttribute(model, pageInfo);
        return "article/list";
    }

    @GetMapping("add/{type}")
    public String add( Model model,@PathVariable String type) {
        model.addAttribute("type",type);
        return "article/add";
    }

    @PostMapping("add")
    public String add(Article article) {
        article.setAddtime(new Date());
        articleService.insertSelective(article);
        return redirect("list/"+article.getType());
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Article article = articleService.selectByPrimaryKey(id);
        if (null == article) throw new MessageException("该信息不存在");
        model.addAttribute(article);
        return "article/detail";
    }

    @PostMapping("update")
    public String update(Article article) {
        articleService.updateByPrimaryKeySelective(article);
        return redirect("list/"+article.getType());
    }

    @RequestMapping("del/{id}")
    public String del(@PathVariable Integer id) {
        articleService.deleteByPrimaryKey(id);
        return refresh();
    }

    @GetMapping("info/{id}")
    public String info(@PathVariable Integer id, Model model) {
        Article article = articleService.selectByPrimaryKey(id);
        if (null == article) throw new MessageException("该项目不存在");
        model.addAttribute(article);
        return "article/info";
    }
}
