package ir.maktabsharif.loginandregister.utility;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory emf;

    private JPAUtil() {
    }

    public static EntityManagerFactory getEmf() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("registerandlogin");
        }
        return emf;

    }
}
