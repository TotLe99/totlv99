package service;

import model.Blog;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BlogService {
    List<Blog> blogs = new ArrayList<>();

    public BlogService() {
        blogs.add(new Blog("Heading Lorem Ipsum Dolor Sit Amet", "assets/images/blog/blog-post-thumb-7.jpg", LocalDate.now(),
                "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies..."));
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public Blog findByID(int id) {
        for (Blog blog : blogs) {
            if (blog.getId() == id) {
                return blog;
            }
        }
        return null;
    }

    public int findIndexByID(int id) {
        for (int i = 0; i < blogs.size(); i++) {
            if (blogs.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void createBlog(String title, String img, String content) {
        blogs.add(new Blog(title, img, LocalDate.now(), content));
    }

    public void editBlog(int id, Blog blog) {
        int index = findIndexByID(id);
        blogs.set(index, blog);
    }

    public List<Blog> deleteBlog(int id) {
        int index = findIndexByID(id);
        blogs.remove(index);
        return blogs;
    }
}
