package com.demo.controller;

import com.demo.common.model.Blog;
import com.demo.interceptor.BlogInterceptor;
import com.demo.service.BlogService;
import com.demo.validator.BlogValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * BlogController 所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller
 * 中，养成好习惯，有利于大型项目的开发与维护
 */
@Before(BlogInterceptor.class)
public class BlogController extends Controller {

	public final static String BLOG_PATH = "/WEB-INF/view/blog/";
	private final static BlogService service = new BlogService();

	public void index() {
		// getParaToInt(0, 1) 取出第一个参数并转成整型，如果为空则使用默认值1
		setAttr("blogPage", service.paginate(getParaToInt(0, 1), 10).getList());
		render(BLOG_PATH + "blog.jsp");
	}

	public void add() {
		render(BLOG_PATH + "add.jsp");
	}

	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中， 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(BlogValidator.class)
	public void save() {
		getModel(Blog.class).save();
		redirect("/blog");
	}

	public void edit() {
		setAttr("blog", service.findById(getParaToInt()));
		render(BLOG_PATH + "edit.jsp");
	}

	/**
	 * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中， 并要对数据进正确性进行验证，在此仅为了偷懒
	 */
	@Before(BlogValidator.class)
	public void update() {
		getModel(Blog.class).update();
		redirect("/blog");
	}

	public void delete() {
		service.deleteById(getParaToInt());
		redirect("/blog");
	}
}
