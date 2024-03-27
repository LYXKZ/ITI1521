import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.*;

/**
 * la classe de Unit test qui teste les methodes de la classe Person
 * @author Livaniaina Rakotomalala (lrakotom@uottawa.ca)
 * @version 01/24/2024
 */
public class UnitTestPerson {
    private static String aphabet = "abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int NOMBREITERATIONTEST = 10;

    /**
     * Genere aleatoirement une chaine de caracteres de taile @param @taille
     * utilise java.lang.Math.random()
     * @param taille
     * @return la chaine de caractere 
     */
     private static String getRandomString(int taille) {
        StringBuilder sb = new StringBuilder(taille);
        int taileAlphabet = aphabet.length();
        
        //generer un chiffre random, considerer ce chiffre comme un position dans le tableu d alphabet 
        for (int i = 0; i < taille; i++) {
            int positionDansAlphabet = (int)(taileAlphabet * Math.random());
            sb.append(aphabet.charAt(positionDansAlphabet));
        }
        return sb.toString();
    }

    /**
     * Genere aleatoirement une nombre entier compris entre @param borneInferieur et @param borneSuperieur
     * utilise java.util.Random
     * @param borneInferieur
     * @param borneSuperieur
     * @return un nombre entier
     */
    private static int getRamdomInt(int borneInferieur, int borneSuperieur){
        Random random = new Random();
        int entier = borneInferieur+random.nextInt(borneSuperieur-borneInferieur);
        return entier;
    }

    /**
     * 
     * Verifie que la methode isNasValid fonctionne convenablement avec juste des chiffres. voici un exemple simple
     */
     @Test
    public void testIsNasValidWithFixedNas() {
        String input1 = "123456789";
        String input2 = "987654321";
        String input3 = " 113 456 789";
        assertTrue(Person.isNasValid(input1));
        assertTrue(Person.isNasValid(input2));
        assertTrue(Person.isNasValid(input3));
        } 

   /**
     * 
     * Verifie que la methode isNasValid fonctionne dans le cas general en 
     * generant aleatoirement un nombre  compose de 9 chiffres. 
     */
    @Test
    public void testIsNasValidWithRandomNas() {
        for (int i=1; i<  NOMBREITERATIONTEST; i++) {
            int nasEnChiffre = getRamdomInt(100000000, 999999999);
            String input = String.valueOf(nasEnChiffre);        
            assertTrue(Person.isNasValid(input));
        }
    }

    /**
     * 
     * Verifie que la methode isNasValid fonctionne et arrive a detecter les mauvais formats prealablement fixe
     */
    @Test
    public void testIsNasValidWithFixedIncorrectFormat() {
        String input4 = "0abc12345";
        String input5 = "abcdefghj";
        String input6 = "123456";

        assertFalse(Person.isNasValid(input4));
        assertFalse(Person.isNasValid(input5));
        assertFalse(Person.isNasValid(input6));
    } 

    /**
     * 
     * Verifie que la methode isNasValid fonctionne et arrive a detecter les mauvais formats generes de facon aleatoire
     */
    @Test
    public void testIsNasValidWithRandomIncorrectFormat() {
        for (int i=1; i<  NOMBREITERATIONTEST; i++) {
            String input = getRandomString (9);       
            assertFalse(Person.isNasValid(input));
        }
    } 

    /**
     * 
     * Verifie que la methode getNas fonctionne convenablement. Vous pouvez utiliser par exemple Marie Tremblay de la methode main Person.java
     */
    @Test
    public void testGetNas() {
        Person p = new Person(getRandomString(10), "1990-10-10");
        String nasInput1 = "123456789";
        p.setNas(nasInput1);
        assertEquals(p.getNas(), "123 456 789");
    } 
    
   /**
     * 
     * Verifie que la methode testCalculateAgeAtDate fonctionne convenablement
     */
    @Test
    public void testCalculateAgeAtDate() {
        Person jd = new Person("Jeanne D'arc", "1412-01-06");
        LocalDate dateDecesJd = LocalDate.of(1431, 5,30);
        assertEquals(Person.calculateAgeAtDate(jd,  dateDecesJd), 19);
  
    }

    /**
     * 
     * Verifie que la methode getAge fonctionne convenablement
     * Bien sur, ces tests pourront echouer si  on les execute ulterieurement,  e.g. dans 1 an; donc comme
     * hypothese, on peut assumre qu'on execute les tests avant Mars 2024. 
     */
    @Test
    public void testGetAge() {
        Person am = new Person("Mozart", "1756-01-27");
        assertEquals(am.getCurrentAge(), 268);

        Person jesus = new Person("Jesus Christ", "0-12-25");
        assertEquals(jesus.getCurrentAge(), 2023);

        Person mj = new Person("Michael Jordan");
        mj.setDateOfBirth("1963-02-17");
        assertEquals(mj.getCurrentAge(), 60);    
    } 
}

// Pour compiler ce fichier
// javac -cp "junit-4.13.jar;hamcrest-core-1.3.jar ;." UnitTestPerson.java