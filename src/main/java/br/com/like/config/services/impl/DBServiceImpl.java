package br.com.like.config.services.impl;

import br.com.like.config.services.DBService;
import br.com.like.domains.*;
import br.com.like.repositories.*;
import br.com.like.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class DBServiceImpl implements DBService {

    private final String desc = "is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s";
    private final String reply = "Lorem Ipsum has been the industry's standard";

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void instantiateTestDatabase() throws ParseException {
        replyRepository.deleteAll();
        questionRepository.deleteAll();
        commentRepository.deleteAll();
        productRepository.deleteAll();
        categoryRepository.deleteAll();
        userRepository.deleteAll();
        clientRepository.deleteAll();

        User u1 = new User(1L, "crane", "1234");
        User u1c = userService.create(u1);

        Set<String> phones = new HashSet<String>();
        phones.add("982525252");
        phones.add("34558585");
        Client cl1 = new Client(1L, "Kyle", "Crane", "marcelo.laravel@gmail.com", "12312312312", phones, u1c);
        clientRepository.save(cl1);

        Category c1 = new Category(1L, "Decoracao");
        Category c2 = new Category(2L,"Escritorio");
        Category c3 = new Category(3L,"Cama mesa e banho");
        Category c4 = new Category(4L, "Eletronicos");

        categoryRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

        Product p1 = new Product(1L, "Computador", 2000.00, desc, 20, c4);
        Product p2 = new Product(2L,"Impressora", 800.00, desc, 10, c4);
        Product p3 = new Product(3L,"Mouse", 80.00, desc, 80, c4);
        Product p4 = new Product(4L,"Mesa de escritorio", 300.00, desc, 40, c2);
        Product p5 = new Product(5L,"Toalha", 30.00, desc, 13, c2);
        Product p6 = new Product(6L,"Colcha", 200.00, desc, 4, c2);
        Product p7 = new Product(7L,"TV", 1200.00, desc, 7, c3);
        Product p8 = new Product(8L,"Roçadeira", 800.00, desc, 20, c3);
        Product p9 = new Product(9L,"Abajour", 100.00, desc, 20, c3);
        Product p10 = new Product(10L,"Pendente", 180.00, desc, 10, c1);
        Product p11 = new Product(11L,"Cama", 190.00, desc, 5, c1);
        Product p12 = new Product(12L,"Travesseiro", 280.00, desc, 14, c1);

        Comment cm1 = new Comment(1L, 5, "Good", desc, null, p12);
        Comment cm2 = new Comment(2L, 2, "Bad", desc, null, p12);
        Comment cm3 = new Comment(3L, 5, "Good", desc, null, p12);
        Comment cm4 = new Comment(4L, 2, "Bad", desc, null, p11);
        Comment cm5 = new Comment(5L, 5, "Good", desc, null, p10);
        Comment cm6 = new Comment(6L, 2, "Bad", desc, null, p9);
        Comment cm7 = new Comment(7L, 5, "Good", desc, null, p5);
        Comment cm8 = new Comment(8L, 2, "Bad", desc, null, p1);

        Question q1 = new Question(1L, desc, p12);
        Question q2 = new Question(2L, desc, p12);
        Question q3 = new Question(3L, desc, p12);


        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12));

        commentRepository.saveAll(Arrays.asList(cm1, cm2, cm3, cm4, cm5, cm6, cm7, cm8));

        questionRepository.saveAll(Arrays.asList(q1, q2, q3));

        Reply r1 = new Reply(1L, reply, q1);
        Reply r2 = new Reply(2L, reply, q2);
        Reply r3 = new Reply(3L, reply, q3);

        replyRepository.saveAll(Arrays.asList(r1, r2, r3));

    }
}
