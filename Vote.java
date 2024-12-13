import java.util.Objects;

public class Vote {
    private final Person  voter;
    private final String date;


    public Vote(Person voter, String date) {
        this.voter = voter;
        this.date = date;
    }

<<<<<<< HEAD
    public Person getVoter() {
        return voter;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return Objects.equals(voter, vote.voter) && Objects.equals(date, vote.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voter, date);
    }
=======
>>>>>>> 64d7ca839665031be2235084d75b98ca8616c30d
}
