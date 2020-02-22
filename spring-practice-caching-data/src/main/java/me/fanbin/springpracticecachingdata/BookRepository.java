package me.fanbin.springpracticecachingdata;

/**
 * @author fanbin
 * @date 2020/2/22
 */
public interface BookRepository {

    Book getByIsbn(String isbn);

}
