    package test.com.shucheng.service.impl;

    import com.shucheng.pojo.Book;
    import com.shucheng.pojo.Page;
    import com.shucheng.service.BookService;
    import com.shucheng.service.impl.BookServiceImpl;
    import org.junit.Test;

    import java.math.BigDecimal;
    import java.util.List;

    /**
    * BookServiceImpl Tester.
    *
    * @author <Authors name>
    * @since <pre>9�� 7, 2020</pre>
    * @version 1.0
    */
    public class BookServiceImplTest {
        private BookService bookService = new BookServiceImpl();

        /**
         * Method: addBook(Book book)
         */
        @Test
        public void testAddBook() throws Exception {
            Book book = new Book(null, "哥哥好帅", new BigDecimal(998), "小龟龟", 342, 898, "img_path from t_book");
            bookService.addBook(book);

        }

        /**
         * Method: updateBook(Book book)
         */
        @Test
        public void testUpdateBook() throws Exception {
            Book book = new Book(39, "你好骚啊", new BigDecimal(233), "洪世贤", 99888, 9999, null);
            bookService.updateBook(book);
        }

        /**
         * Method: deleteBookById(Integer id)
         */
        @Test
        public void testDeleteBookById() throws Exception {
            bookService.deleteBookById(43);
        }

        /**
         * Method: queryBookById(Integer id)
         */
        @Test
        public void testQueryBookById() throws Exception {
            System.out.println(bookService.queryBookById(38));
        }

        /**
         * Method: queryBooks()
         */
        @Test
        public void testQueryBooks() throws Exception {
            List<Book> books = bookService.queryBooks();
            for (Book book:books){
                System.out.println(book);
            }
        }

        @Test
        public void testPageByPrice() throws Exception {
          Page<Book> page = bookService.pageByPrice(0,3,20,90);
            System.out.println(page);
        }
    }