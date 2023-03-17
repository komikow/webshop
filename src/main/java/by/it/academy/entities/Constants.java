package by.it.academy.entities;

public class Constants {

<<<<<<< HEAD

=======
>>>>>>> 3c6d791 (add fixed error code)
    public static final String ADMIN_PAGE = "/pages/user/adminPage.jsp";
    public static final String ERRORS_LOGIN = "/pages/errors/error.jsp";

    public static final String USERS_PAGE = "/pages/user/userPage.jsp";
    public static final String ERRORS_AUTHORIZATION = "/pages/errors/authorization_error.jsp";
    public static final String PAGES_REGISTRATION_TRUE = "/pages/service/successfulRegistration.jsp";
<<<<<<< HEAD
    public static final String PRODUCTS_PAGE = "/pages/products/productsPages.jsp";
=======
    public static final String PAGES_ADD_PRODUCT = "/pages/products/addProducts.jsp";
    public static final String PRODUCTS_PAGE = "/pages/products/productsPages.jsp";
    public static final String ALL_USERS_PAGE = "/pages/user/allUsersPage.jsp";
    public static final String PRODUCT_ADD_TRUE_PAGE = "/pages/service/successfullyAddProduct.jsp";
    public static final String DELETE_USER_PAGE = "/pages/service/successfullyDeleteUser.jsp";
    public static final String BRACKET = "')";
    public static final String QUOTATION_MARK = "'";
    public static final String DELETE_USER_FROM_CREDENTIALS = "delete from credentials where login='";
    public static final String DELETE_PRODUCT = "delete from detectors where model='";

    public static final String DELETE_USER_FROM_USERS = "delete from users where id_credentials in " +
            "(select id_credentials from credentials " +
            "where login='";
>>>>>>> 3c6d791 (add fixed error code)

    public static final String NAME_ID_CREDENTIALS = "/pages/products/productsPages.jsp";
    public static final String SQL_NAME = "postgres";
    public static final String SQL_DRIVER_NAME = "org.postgresql.Driver";
    public static final String SQL_PASSWORD = "Qwety5";
    public static final String SQL_URL = "jdbc:postgresql://localhost:5432/webshop";
    public static final String INSERT_CREDENTIALS = "INSERT INTO credentials (login, password) VALUES (?, ?)";
    public static final String INSERT_BRAND = "INSERT INTO brand (brand) VALUES (?)";
    public static final String INSERT_DETECTORS = "INSERT INTO detectors (model, specifications, guarantee, price, quantity) VALUES (?,?,?,?,?)";
    public static final String SELECT_CREDENTIALS = "SELECT * FROM credentials";
    public static final String SELECT_DETECTORS = "SELECT * FROM DETECTORS";
<<<<<<< HEAD
    public static final String SELECT_PRODUCTS = "SELECT users.id_credentials, users.name, users.surname, users.age, credentials.login, credentials.password FROM users, credentials WHERE credentials.id_credentials = users.id_credentials";
=======
    public static final String SELECT_USERS = "SELECT users.id_credentials, users.name, users.surname, users.age, credentials.login, credentials.password FROM users, credentials WHERE credentials.id_credentials = users.id_credentials";
>>>>>>> 3c6d791 (add fixed error code)
    public static final String INSERT_USERS = "INSERT INTO users (id_credentials, name, surname, age) VALUES (?, ?, ?, ?)";

    public static final String USERS_URL_READ = "/user/read";
    public static final String USERS_URL_CREATE = "/user/create";
<<<<<<< HEAD
    public static final String PRODUCT_READ = "/product_read";
    public static final String USER_READ = "/user_read";
=======
    public static final String PRODUCT_URL_CREATE = "/product_create";
    public static final String PRODUCT_URL_READ = "/product_read";
    public static final String USER_URL_READ = "/user_read";
    public static final String USER_URL_DELETE = "/user_delete";
>>>>>>> 3c6d791 (add fixed error code)
    public static final String USERS_URL_INPUT = "/user/input";

    public static final String PATH_ALL = "/user/*";

    public static final String SEPARATOR = ":";
    public static final String PRODUCTS = "products";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String NAME = "firstName";
    public static final String SURNAME = "secondName";
    public static final String AGE = "age";

    public static final String USERS = "users";
<<<<<<< HEAD
    public static final String ADMIN_LOGIN = "komikov";
    public static final String ADMIN_PASSWORD = "Qwety5";
    public static final String SERVICES = "userService";
    public static final String LOGIN = "login";
=======
    public static final String PRODUCT_ID = "id";
    public static final String PRODUCT_MODEL = "model";
    public static final String PRODUCT_SPECIFICATIONS = "specifications";
    public static final String PRODUCT_GUARANTEE = "guarantee";
    public static final String PRODUCT_PRICE = "price";
    public static final String PRODUCT_QUANTITY = "quantity";
    public static final String ADMIN_LOGIN = "komikov";
    public static final String ADMIN_PASSWORD = "Qwety5";
//    public static final String LOGIN_FOR_DELETE = "loginForDelete";
    public static final String USER_SERVICE = "userService";
    public static final String USER_REPOSITORY = "userRepository";
    public static final String PRODUCT_SERVICE = "productService";
    public static final String CREDENTIALS_ID = "id_credentials";
    public static final String LOGIN_TO_DELETE = "loginToDelete";
    public static final int PARAMETER_ONE = 1;
    public static final int PARAMETER_TWO = 2;
    public static final int PARAMETER_THREE = 3;
    public static final int PARAMETER_FOUR = 4;
    public static final int PARAMETER_FIVE = 5;
    public static final int PARAMETER_SIX = 6;
>>>>>>> 3c6d791 (add fixed error code)
}
