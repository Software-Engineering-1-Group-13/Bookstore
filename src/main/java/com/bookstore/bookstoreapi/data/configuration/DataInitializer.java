package com.bookstore.bookstoreapi.data.configuration;

import com.bookstore.bookstoreapi.BookstoreConstants;
import com.bookstore.bookstoreapi.data.entity.Book;
import com.bookstore.bookstoreapi.data.entity.Cart;
import com.bookstore.bookstoreapi.data.entity.Comment;
import com.bookstore.bookstoreapi.data.entity.Rating;
import com.bookstore.bookstoreapi.data.entity.User;
import com.bookstore.bookstoreapi.data.entity.Wishlist;
import com.bookstore.bookstoreapi.data.repository.BookRepository;
import com.bookstore.bookstoreapi.data.repository.CartRepository;
import com.bookstore.bookstoreapi.data.repository.CommentRepository;
import com.bookstore.bookstoreapi.data.repository.RatingRepository;
import com.bookstore.bookstoreapi.data.repository.UserRepository;
import com.bookstore.bookstoreapi.data.repository.WishlistRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

  @Bean
  public CommandLineRunner initData(
      BookRepository bookRepository,
      UserRepository userRepository,
      WishlistRepository wishlistRepository,
      CommentRepository commentRepository,
      RatingRepository ratingRepository,
      CartRepository cartRepository) {
    return args -> {
      User john = new User();
      john.setUsername("Johnny123");
      john.setPassword("JohnLolly123");
      john.setName("John Doe");
      john.setEmailAddress("john.doe@example.com");
      john.setHomeAddress("12345 Random st");
      userRepository.save(john);

      User jane = new User();
      jane.setUsername("Janey1993");
      jane.setPassword("JaneSerial!1");
      jane.setName("Jane Smith");
      jane.setEmailAddress("jane.smith@example.com");
      jane.setHomeAddress("12345 non-Random st");
      userRepository.save(jane);

      Wishlist johnWishList = new Wishlist();
      johnWishList.setName("John's Favorites");
      johnWishList.setUser(john);
      wishlistRepository.save(johnWishList);

      Book book1 = new Book();
      book1.setTitle("A Journey to the Center of the Earth");
      book1.setIsbn("978-1503215153");
      book1.setPublishingDate(LocalDate.parse(("1864-01-01"), BookstoreConstants.DATE_FORMAT));
      book1.setTitle("A Journey to the Center of the Earth");
      book1.setAuthor("Jules Verne");
      book1.setGenre(BookstoreConstants.SCIENCE_FICTION);
      book1.setDescription(
          "A geology professor and his nephew discover and decode an ancient document that"
              + " shows that a dormant volcano holds a secret entrance to a subterranean world at the earth's center.");
      book1.setPublisher("Simon & Shuster");
      book1.setPublishingDate(LocalDate.parse(("1864-11-25"), BookstoreConstants.DATE_FORMAT));
      book1.setPrice(12.99);
      book1.setStockCount(50);
      book1.setCopiesSold(1000000);

      Book book2 = new Book();
      book2.setTitle("The Time Machine");
      book2.setIsbn("978-0451530707");
      book2.setTitle("The Time Machine");
      book2.setAuthor("H. G. Wells");
      book2.setGenre(BookstoreConstants.SCIENCE_FICTION);
      book2.setDescription(
          "A nameless scientist builds a time machine, travels to the year 802,701 AD and there encounters humanity’s descendants ");
      book2.setPublisher("William Heinemann (UK) Henry Holt (US)");
      book2.setPublishingDate(LocalDate.parse(("1895-05-07"), BookstoreConstants.DATE_FORMAT));
      book2.setPrice(10.50);
      book2.setStockCount(30);
      book2.setCopiesSold(1000000);

      Book book3 = new Book();
      book3.setTitle("Brave New World");
      book3.setIsbn("978-0060850524");
      book3.setTitle("Brave New World");
      book3.setAuthor("Aldous Huxley");
      book3.setGenre(BookstoreConstants.SCIENCE_FICTION);
      book3.setDescription(
          "A futuristic society, called the World State, that revolves around science and efficiency.");
      book3.setPublisher("HarperCollins");
      book3.setPublishingDate(LocalDate.parse(("1932-08-15"), BookstoreConstants.DATE_FORMAT));
      book3.setPrice(15.20);
      book3.setStockCount(20);
      book3.setCopiesSold(1000000);

      Book book4 = new Book();
      book4.setIsbn("978-3423230124");
      book4.setTitle("Verity");
      book4.setAuthor("Colleen Hoover");
      book4.setGenre("Thriller");
      book4.setDescription(
          "Lowen Ashleigh is a struggling writer who accepts the job offer of a lifetime. "
              + "Jeremy Crawford, husband of bestselling author Verity Crawford, has hired "
              + "Lowen to complete the remaining books in a successful series his injured wife is unable to finish.");
      book4.setPublisher("Grand Central Publishing");
      book4.setPublishingDate(LocalDate.parse(("2018-12-07"), BookstoreConstants.DATE_FORMAT));
      book4.setPrice(12.81);
      book4.setStockCount(15);
      book4.setCopiesSold(3000000);

      Book book5 = new Book();
      book5.setIsbn("978-1250245496");
      book5.setTitle("The Wife Upstairs");
      book5.setAuthor("Rachel Hawkins");
      book5.setGenre("Suspense");
      book5.setDescription(
          "A timeless tale of forbidden romance, ill-advised attraction, and a wife who just won't stay buried");
      book5.setPublisher("St. Martin's Press");
      book5.setPublishingDate(LocalDate.parse(("2021-01-05"), BookstoreConstants.DATE_FORMAT));
      book5.setPrice(9.99);
      book5.setStockCount(11);
      book5.setCopiesSold(235169);

      Book book6 = new Book();
      book6.setIsbn("978-3446264199");
      book6.setTitle("Where the Crawdads Sing");
      book6.setAuthor("Delia Owens");
      book6.setGenre("Mystery");
      book6.setDescription(
          "A woman who raised herself in the marshes of the Deep South becomes a suspect in the murder of a man with whom she was once involved.");
      book6.setPublisher("St. Martin's Press");
      book6.setPublishingDate(LocalDate.parse(("2018-08-14"), BookstoreConstants.DATE_FORMAT));
      book6.setPrice(14.67);
      book6.setStockCount(21);
      book6.setCopiesSold(12000000);

      bookRepository.save(book1);
      bookRepository.save(book2);
      bookRepository.save(book3);
      bookRepository.save(book4);
      bookRepository.save(book5);
      bookRepository.save(book6);

      Cart johnCart = new Cart();
      johnCart.setUser(john);
      johnCart.getBooks().add(book1);
      johnCart.getBooks().add(book2);
      johnCart.getBooks().add(book3);

      Cart janeCart = new Cart();
      janeCart.setUser(jane);

      cartRepository.save(johnCart);
      cartRepository.save(janeCart);

      book1.getCarts().add(johnCart);
      book2.getCarts().add(johnCart);
      book3.getCarts().add(johnCart);

      johnWishList.getBooks().add(book1);
      book1.getWishlists().add(johnWishList);

      johnWishList.getBooks().add(book2);
      book2.getWishlists().add(johnWishList);

      wishlistRepository.save(johnWishList);

      Rating rating1 = new Rating();
      rating1.setUser(john);
      rating1.setBook(book1);
      rating1.setRating(3);

      Comment comment1 = new Comment();
      comment1.setUser(john);
      comment1.setBook(book1);
      comment1.setComment("Wow! Super awesome book!");

      ratingRepository.save(rating1);
      commentRepository.save(comment1);

      john.getRatings().add(rating1);
      book1.getRatings().add(rating1);
      john.getComments().add(comment1);
      book1.getComments().add(comment1);

      johnWishList.getBooks().add(book2);
      book2.getWishlists().add(johnWishList);
      wishlistRepository.save(johnWishList);

      ratingRepository.save(rating1);
      john.getRatings().add(rating1);
      book1.getRatings().add(rating1);
      userRepository.save(john);
      bookRepository.save(book1);
      bookRepository.save(book2);
      bookRepository.save(book3);
      updateInitialAverageRatings(bookRepository);
    };
  }

  private void updateInitialAverageRatings(BookRepository bookRepository) {
    List<Book> books = bookRepository.findAll();

    for (Book book : books) {
      Set<Rating> ratings = book.getRatings();
      double averageRating = ratings.stream().mapToInt(Rating::getRating).average().orElse(0.0);

      book.setAverageRating(averageRating);
      bookRepository.save(book);
    }
  }
}
