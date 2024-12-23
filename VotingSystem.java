import java.util.ArrayList;
import java.util.HashSet;

public class VotingSystem {
    private ArrayList<Voting> votingList;
    public VotingSystem() {
    }

    public Voting getVoting(int index) {
        return votingList.get(index);
    }

    public ArrayList<Voting> getVotingList() {
        return votingList;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    public void createVoting(String question, boolean isAnonymous, int type, ArrayList<String> choices) {

    }

    public void printResults(int index) {
    }

    public void printVoting(int index) {
        Voting voting = getVoting(index);
        System.out.println("Voting Question: " + voting.getQuestion());
        System.out.println("Voting Type: " + voting.getType());
        System.out.println("Choices:");
        for (String choice : voting.getChoices().keySet()) {
            System.out.println("- " + choice);
        }
    }
    public void printVoters(int index) {
        Voting voting = getVoting(index);
        System.out.println("Voters for Voting Question: " + voting.getQuestion());
        for (Person voter : voting.getVoters()) {
            System.out.println("Voter: " + voter);
        }
    }

}
