package by.it.academy.entities;

public class Constants {


    public static final String ADMIN_PAGE = "/pages/user/adminPage.jsp";
    public static final String ERRORS_LOGIN = "/pages/errors/error.jsp";

    public static final String USERS_PAGE = "/pages/user/userPage.jsp";
    public static final String ERRORS_AUTHORIZATION = "/pages/errors/authorization_error.jsp";
    public static final String PAGES_REGISTRATION_TRUE = "/pages/service/successfulRegistration.jsp";
    public static final String PRODUCTS_PAGE = "/pages/products/productsPages.jsp";

    public static final String NAME_ID_CREDENTIALS = "/pages/products/productsPages.jsp";
    public static final String SQL_NAME = "postgres";
    public static final String SQL_DRIVER_NAME = "org.postgresql.Driver";
    public static final String SQL_PASSWORD = "Qwety5";
    public static final String SQL_URL = "jdbc:postgresql://localhost:5432/webshop";
    public static final String INSERT_CREDENTIALS = "INSERT INTO credentials (login, password) VALUES (?, ?)";
    public static final String SELECT_CREDENTIALS = "SELECT * FROM credentials";
    public static final String SELECT_DETECTORS = "SELECT * FROM DETECTORS";
    public static final String SELECT_PRODUCTS = "SELECT users.id_credentials, users.name, users.surname, users.age, credentials.login, credentials.password FROM users, credentials WHERE credentials.id_credentials = users.id_credentials";
    public static final String INSERT_USERS = "INSERT INTO users (id_credentials, name, surname, age) VALUES (?, ?, ?, ?)";

    public static final String USERS_URL_READ = "/user/read";
    public static final String USERS_URL_CREATE = "/user/create";
    public static final String PRODUCT_READ = "/product_read";
    public static final String USER_READ = "/user_read";
    public static final String USERS_URL_INPUT = "/user/input";

    public static final String PATH_ALL = "/user/*";

    public static final String SEPARATOR = ":";
    public static final String PASSWORD = "password";
    public static final String NAME = "firstName";
    public static final String SURNAME = "secondName";
    public static final String AGE = "age";

    public static final String USERS = "users";
    public static final String ADMIN_LOGIN = "komikov";
    public static final String ADMIN_PASSWORD = "Qwety5";
    public static final String SERVICES = "userService";
    public static final String LOGIN = "login";
}
