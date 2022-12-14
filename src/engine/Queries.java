package engine;

public class Queries {

    public static final String SQL_ONE = "select idPracownika, nazwisko, imię, stanowisko from pracownicy where `status studenta` = 'tak'";
    public static final String SQL_TWO = "select idLokalu, miejscowość, województwo from lokale having województwo in ('wielkopolskie')";
    public static final String SQL_THREE = "select `nazwa potrawy`, `długość przygotowania` from menu where `długość przygotowania` >= 10 order by `długość przygotowania` desc;";
    public static final String SQL_FOUR = "select imię, nazwisko from pracownicy where imię like '%a'";
    public static final String SQL_FIVE = "select idStolika, priorytet from zamówienia z" +
            "where exists(select * from zamówienia where z.potrawy = 'Piwo')";
    public static final String SQL_SIX = "select Lokale_idLokale,nazwa, ilość, `data ostatniego zamówienia`, `termin przydatności`, `ilość w magazynie` " +
            "from magazyn " +
            "inner join zapotrzebowanie z on magazyn.Zapotrzebowanie_idPrzedmiotu = z.idPrzedmiotu " +
            "order by Lokale_idLokale asc";
    public static final String SQL_SEVEN = "";
    public static final String SQL_EIGHT = "";
    public static final String SQL_NINE = "";
    public static final String SQL_TEN = "";
    public static final String SQL_ELEVEN = "";
    public static final String SQL_TWELVE = "";
    public static final String SQL_THIRDTEEN = "";
    public static final String SQL_FOURTEEN = "";
    public static final String SQL_FIFTEEN = "";

    public static final String REPORT_ONE_QUERY = "select idPracownika, nazwisko, imię, stanowisko, `rodzaj umowy` " +
            "from pracownicy " +
            "order by `rodzaj umowy`";

    public static final String REPORT_TWO_QUERY = "select * " +
            "from lokale " +
            "where województwo = ";

    public static final String REPORT_THREE_QUERY = "select  idRachunku ,cena, napiwek, Potrawy, imię, nazwisko, (cena + napiwek) as cena\n" +
            "from rachunki\n" +
            "left join pracownicy p on p.idPracownika = rachunki.Pracownicy_idPracownika";

}