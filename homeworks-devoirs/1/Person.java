import java.time.LocalDate;
import java.time.Period;
import java.lang.Math;

/**
 * la classe Personne qui garde les informations d une personne
 * 
 * @author Livaniaina Rakotomalala (lrakotom@uottawa.ca)
 * @version 01/24/2024
 */
public class Person {
    // le format du nas, ici en bloc de 3 chiffres e.g. 123 456 789. Si
    // NASGROUPFORMAT=2, alors on aurait 12 34 56 78 9
    public static int NASGROUPFORMAT = 3;

    // la longueur du nas, au canada le nas est compose de 9 chiffres
    public static final int NASLENGTH = 9;

    // variable d'instance
    private String name;
    private int[] dateOfBirth;
    // TODO: Veuillez ajouter votre code ici pour déclarer votre variable d instance
    // nas en tant que tableau d Integer
    private Integer[] nas;

    // Constructor
    /**
     * 
     * <p>
     * Construit un object Person
     * </p>
     * 
     * @param name le nom de la personne
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * 
     * <p>
     * Construit un object Person
     * </p>
     * 
     * @param name              le nom de la personne
     * @param dateOfBirthString la date de naissance en format AAAA-MM-JJ
     */
    public Person(String name, String dateOfBirthString) {
        // TODO: Veuillez ajouter votre code ici
        this.name = name;

        String[] dobString = dateOfBirthString.split("-");
        this.dateOfBirth = new int[] { Integer.parseInt(dobString[0]), Integer.parseInt(dobString[1]),
                Integer.parseInt(dobString[2]) };
    }

    // getters method

    /**
     * retourne le nom
     * 
     * @return le nom de la personne
     */
    public String getName() {
        return this.name;
    }

    /**
     * retourne la date de naissance
     * 
     * @return la date de naissance en tableau de int
     */
    public int[] getDateOfBirth() {
        return this.dateOfBirth;
    }

    /**
     * retourne le numero d assurance en social en fomrat NASGROUPFORMAT e.g. "123
     * 456 789"
     * 
     * @return le nas
     */
    public String getNas() {
        // TODO: Veuillez ajouter votre code ici
        String nas_string = "";

        for (int i = 0; i < NASLENGTH; i++) {
            if (i / NASGROUPFORMAT == (int) (i / NASGROUPFORMAT)) {
                nas_string = nas_string + " ";
            } else {
                nas_string = nas_string + this.nas[i];
            }
        }

        return nas_string;
    }

    // Setter methods

    /**
     * 
     * <p>
     * met en place le nom de la personne
     * </p>
     * 
     * @param name le nom
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * <p>
     * met en place le date de naissance de la personne
     * </p>
     * 
     * @param dateOfBirthString en format AAAA-MM-JJ
     */
    public void setDateOfBirth(String dateOfBirthString) {
        this.dateOfBirth = parseDateOfBirth(dateOfBirthString);
    }

    /**
     * 
     * <p>
     * met en place le numero d assurance sociale de la personne s il est valide
     * </p>
     * 
     * @param nas compose uniquement de 9 chiffres (123456789 ou 123 456 789 etc)
     */
    public void setNas(String nas) {
        // TODO: Veuillez ajouter votre code ici
        // Hint: verifier que le parametre nas est valide et utiliser la methode de
        // classe parseNas
        if (isNasValid(nas)) {
            this.nas = parseNas(nas, NASGROUPFORMAT);
        }
    }

    // Methodes d'instance

    /**
     * retourne l age actuel de la personne
     * 
     * @return l age
     */
    public int getCurrentAge() {
        // TODO: Veuillez ajouter votre code ici
        // Hint: utiliser la methode de classe calculateAgeAtDate
        LocalDate current_date = LocalDate.now();
        LocalDate birth_date = LocalDate.of(dateOfBirth[0], dateOfBirth[1], dateOfBirth[2]);

        return Period.between(birth_date, current_date).getYears();
    }

    /**
     * retourne la version String de la personne en format "Nom ... , Date de
     * naissance: [...], Nas: ... (si le nas existe) "
     * e.g Nom: Michael Jordan, Date de naissance: [17 février 1963]
     * e.g Nom: Marie Tremblay, Date de naissance: [1 juillet 1980], Nas: (123 456
     * 789)
     * 
     * @return la version string de l objet Person
     */
    public String toString() {
        // TODO: Veuillez ajouter votre code ici
        String s = "Nom:" + this.name;
        s += ", Date de naissance: " + dateOfBirth[0] + "-" + dateOfBirth[1] + "-" + dateOfBirth[2];

        if (nas != null) {
            s += ", Nas: (";
            for (int i = 0; i < this.nas.length; i++) {
                s += this.nas[i] + " ";
            }
            s = s.substring(0, s.length() - 1) + ")";
        }

        return s;
    }

    // Methodes de classe

    /**
     * Méthode Helper pour calculer l'âge par rapport a la date envoye en parametre
     * 
     * @param person la personne dont l age est a calculer
     * @param date   la date de reference (e.g. date d aujourhui ou une date
     *               quelconque)
     * @return l age
     */
    public static int calculateAgeAtDate(Person person, LocalDate date) {
        // TODO: Veuillez ajouter votre code ici
        // Hint: inspirez vous des methodes utilitaires de la classe java.Time.LocalDate
        // et java.Time.Period
        int[] dob = person.getDateOfBirth();

        LocalDate birth_date = LocalDate.of(dob[0], dob[1], dob[2]);

        return Period.between(birth_date, date).getYears();
    }

    /**
     * Méthode Helper pour verifier si un nas est valide
     * 
     * @param input le nas
     * @return vrai si le nas est valide
     */
    public static boolean isNasValid(String input) {
        // TODO: Veuillez ajouter votre code ici
        int digits = 0;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                digits++;
            } else if (input.charAt(i) != ' ') {
                return false;
            }
        }

        if (input.charAt(0) != '0' && digits == 9) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Méthode Helper pour mettre la chaîne de caractere date de naissance dans un
     * tableau d'entiers
     * 
     * @param dateOfBirthString le date de naissance en format AAAA-MM-JJ 
     * @return un tableau de int
     */
    private static int[] parseDateOfBirth(String dateOfBirthString) {
        // En supposant que la chaîne de date de naissance soit au format « AAAA-MM-JJ »
        String[] parts = dateOfBirthString.split("-");

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        // Créer un tableau pour représenter la date de naissance
        int[] dateOfBirthArray = { year, month, day };

        return dateOfBirthArray;
    }

    /**
     * Méthode Helper pour mettre la chaîne de caractere nas dans un tableau
     * d'entiers
     * 
     * @param nas    le numero d assurance social
     * @param format la longueur de chaque bloc
     * @return un tableau de Integer
     */
    private static Integer[] parseNas(String nas, int format) {
        // TODO: Veuillez ajouter votre code ici
        // Hint: la methode java.lang.Math.ceil et la methode d instance substring de
        // String pourraient vous aider
        Integer[] tableau = new Integer[format];

        for (int i = 0; i < Math.ceil(9 / format); i++) {
            tableau[i] = Integer.valueOf(nas.substring(i, i + format));
        }

        return tableau;
    }

    /**
     * Méthode principale
     * 
     * @param args parametres de la ligne de commande
     */
    public static void main(String[] args) {
        // Creating a Person object
        Person am = new Person("Mozart", "1756-01-27");
        Person jd = new Person("Jeanne D'arc", "1412-01-06");
        Person jesus = new Person("Jesus Christ", "0-12-25");
        Person mj = new Person("Michael Jordan");
        mj.setDateOfBirth("1963-02-17");
        Person mt = new Person("Marie Tremblay", "1980-7-1");
        mt.setNas("123456789");

        StudentInfo.display();

        System.out.println(am.toString() + ", Age: " + am.getCurrentAge());
        LocalDate dateDecesJd = LocalDate.of(1431, 5, 30);
        System.out.println(jd.toString() + ", Age au decès: " + Person.calculateAgeAtDate(jd, dateDecesJd));
        System.out.println(jesus.toString() + ", Age: " + jesus.getCurrentAge());
        System.out.println(mj.toString() + ", Age: " + Person.calculateAgeAtDate(mj, LocalDate.now())); // une autre
                                                                                                        // alternative
                                                                                                        // de chercher l
                                                                                                        // age
        System.out.println(mt.toString());
        System.out.println();
    }
}
