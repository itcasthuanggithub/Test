    package test.com.shucheng.dao.impl;

    import com.shucheng.dao.BookDao;
    import com.shucheng.dao.impl.BookDaoImpl;
    import com.shucheng.pojo.Book;
    import org.junit.Test;

    import java.math.BigDecimal;
    import java.util.List;

    /**
    * BookDaoImpl Tester.
    *
    * @author <Authors name>
    * @since <pre>9月 6, 2020</pre>
    * @version 1.0
    */
    public class BookDaoImplTest {
        private BookDao bookDao = new BookDaoImpl();

    @Test
    public void testAddBook() throws Exception {
        Book book = new Book(null,"肉蒲团",new BigDecimal(6666),"小黄",66666,1,"static/img/defualt.jpg");
        bookDao.addBook(book);
    }

    /**
    *
    * Method: updateBook(Book book)
    *
    */
    @Test
    public void testUpdateBook() throws Exception {
         Book book = new Book(38,"全国富婆通讯录",new BigDecimal(9999),"小黄黄",10000,10,"static/img/defualt.jpg");
         bookDao.updateBook(book);
    }

    /**
    *
    * Method: deleteBookById(Integer id)
    *
    */
    @Test
    public void testDeleteBookById() throws Exception {
    }

    /**
    *
    * Method: queryBookById(Integer id)
    *
    */
    @Test
    public void testQueryBookById() throws Exception {
        System.out.println(bookDao.queryBookById(39));
    }

    /**
    *
    * Method: queryBooks()
    *
    */
    @Test
    public void testQueryBooks() throws Exception {
        List<Book> books = bookDao.queryBooks();
        for (Book book:books){
            System.out.println(book);
        }
    }
        @Test
        public void testQueryForPageTotalCountByPrice() throws Exception {
            System.out.println(bookDao.queryForPageTotalCountByPrice(30,90));
        }

        @Test
        public void testQueryItemsByPrice() throws Exception {
            List<Book> books = bookDao.queryItemsByPrice(0, 3, 20, 50);
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
