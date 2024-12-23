import java.util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Voting {
    private int type;
    private String question;
    private HashMap<String, HashSet<Vote>> choices;
    private boolean isAnonymous;
    private ArrayList<Person> voters;

    public Voting(int type, HashMap<String, HashSet<Vote>> choices, String question, boolean isAnonymous, ArrayList<Person> voters) {
        this.type = type;
        this.question = question;
        this.choices = choices;
        this.isAnonymous = isAnonymous;
        this.voters = voters;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public HashMap<String, HashSet<Vote>> getChoices() {
        return choices;
    }

    public ArrayList<Person> getVoters() {
        return voters;
    }

    public int getType() {
        return type;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Voting voting = (Voting) o;
        return type == voting.type && isAnonymous == voting.isAnonymous && Objects.equals(question, voting.question) && Objects.equals(choices, voting.choices) && Objects.equals(voters, voting.voters);
    }
    public void createChoices(String[] choices, Person voter, String date) {
        // Create a new HashMap to store the choices
        this.choices = new HashMap<>();

        // Add the choices to the HashMap
        for (String choice : choices) {
            // Create a new Vote object with the provided voter and date
            Vote vote = new Vote(voter, date);

            // Add the Vote object to the HashSet in the HashMap
            HashSet<Vote> choiceSet = new HashSet<>();
            choiceSet.add(vote);
            this.choices.put(choice, choiceSet);
        }

    }
    public void vote(Person voter, ArrayList<String> voterChoices) {
        // Validate that the voterChoices list is not empty
        if (voterChoices.isEmpty()) {
            System.out.println("Error: Voter must make at least one choice.");
            return;
        }
        if (voterChoices.size() > 1) {
            System.out.println("Error: Single-choice voting only allows one choice.");
            return;
        }
        for (String choice : voterChoices) {
            if (this.choices.containsKey(choice)) {
                this.choices.get(choice).add(new Vote(voter, "date"));
            } else {
                HashSet<Vote> voteSet = new HashSet<>();
                voteSet.add(new Vote(voter, "date"));
                this.choices.put(choice, voteSet);
            }
        }
        if (!this.voters.contains(voter) && !this.isAnonymous) {
            this.voters.add(voter);
        }
    }
    public void vote(Person person) {
        // Randomly select a choice from the choices HashMap
        String randomChoice = new ArrayList<>(this.choices.keySet()).get(new Random().nextInt(this.choices.size()));

        Vote vote = new Vote(person, "date");
        this.choices.get(randomChoice).add(vote);

        // Add the person to the voters list if they haven't already voted
        if (!this.voters.contains(person)) {
            this.voters.add(person);
            // sorry i have writed the 2 vote methods in the same commit
        }
    }

    public void printResults() {
        System.out.println("printResults:");
        // Iterate over the keys (choices) in the choices map
        for (String choice : this.choices.keySet()) {
            HashSet<Vote> votes = this.choices.get(choice);
            System.out.println(choice + ": " + votes.size());
        }
    }

}
