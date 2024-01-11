import java.util.*;

class Candidate {
    String name;
    int age;
    String id;
    String address;
    String party;
    String symbol;

    public Candidate(String name, int age, String id, String address, String party, String symbol) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.address = address;
        this.party = party;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", party='" + party + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}

class Voter {
    String id;
    String name;
    int age;
    String area;
    String aadharNo;
    boolean hasVoted;

    public Voter(String id, String name, int age, String area, String aadharNo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.area = area;
        this.aadharNo = aadharNo;
        this.hasVoted = false;
    }

    @Override
    public String toString() {
        return "Voter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", area='" + area + '\'' +
                ", aadharNo='" + aadharNo + '\'' +
                ", hasVoted=" + hasVoted +
                '}';
    }
}

public class ElectionSystem {
    public static void main(String[] args) {
        List<Candidate> candidateList = new ArrayList<>();
        Vector<Voter> voterVector = new Vector<>();
        Map<String, Integer> votes = new HashMap<>();
        Map<String, String> electionStatus = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n|--- Online Election System ---|");
            System.out.println("1. Candidate Registration");
            System.out.println("2. Voter Registration Management");
            System.out.println("3. Election Status Tracking");
            System.out.println("4. Voting Period Management");
            System.out.println("5. Election Result Updates");
            System.out.println("6. Feedback and Complaints Handling");
            System.out.println("7. Cast Vote");
            System.out.println("8. Display Registered Candidates");
            System.out.println("9. Display Registered Voters");
            System.out.println("10. Exit");
            System.out.println("Enter your choice: ");


            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    
                    System.out.print("Enter candidate name: ");
                    String candidateName = sc.next();
                    System.out.print("Enter candidate age: ");
                    int candidateAge = sc.nextInt();
                    System.out.print("Enter candidate ID: ");
                    String candidateId = sc.next();
                    System.out.print("Enter candidate address: ");
                    String candidateAddress = sc.next();
                    System.out.print("Enter party name: ");
                    String partyName = sc.next();
                    System.out.print("Enter party symbol: ");
                    String partySymbol = sc.next();

                    candidateList.add(new Candidate(candidateName, candidateAge, candidateId, candidateAddress, partyName, partySymbol));
                    System.out.println("Candidate registered successfully!");
                    break;

                case 2:
                 
                    System.out.print("Enter voter ID: ");
                    String voterId = sc.next();
                    System.out.print("Enter voter name: ");
                    String voterName = sc.next();
                    System.out.print("Enter voter age: ");
                    int voterAge = sc.nextInt();
                    System.out.print("Enter voter area: ");
                    String voterArea = sc.next();
                    System.out.print("Enter voter Aadhar number: ");
                    String aadharNo = sc.next();

                    voterVector.add(new Voter(voterId, voterName, voterAge, voterArea, aadharNo));
                    System.out.println("Voter registered successfully!");
                    break;

                case 3:
                    
                    System.out.println("Election Status:");
                    electionStatus.entrySet().forEach(entry ->
                            System.out.println(entry.getKey() + ": " + entry.getValue())
                    );
                    break;

                case 4:
                    
                    System.out.print("Enter start date of voting period: ");
                    String startDate = sc.next();
                    System.out.print("Enter end date of voting period: ");
                    String endDate = sc.next();
                    electionStatus.put("Voting Period", "From " + startDate + " to " + endDate);
                    System.out.println("Voting period set successfully!");
                    break;

                case 5:
                    
                    System.out.println("Election Results:");
                    votes.entrySet().forEach(entry ->
                            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes")
                    );
                    break;

                case 6:
                   
                    System.out.print("Enter feedback or complaint: ");
                    String feedback = sc.next();
                    System.out.println("Feedback/Complaint submitted: " + feedback);
                    break;

                case 7:
                    
                    System.out.print("Enter voter ID: ");
                    String voterIDForVote = sc.next();

                    Voter voterForVote = null;
                    for (Voter voter : voterVector) {
                        if (voter.id.equals(voterIDForVote)) {
                            voterForVote = voter;
                            break;
                        }
                    }

                    if (voterForVote != null && !voterForVote.hasVoted) {
                        System.out.println("Candidates available for voting:");
                        candidateList.forEach(System.out::println);

                        System.out.print("Enter candidate name for your vote: ");
                        String candidateNameForVote = sc.next();

                        for (Candidate candidate : candidateList) {
                            if (candidate.name.equals(candidateNameForVote)) {
                                votes.put(candidate.name, votes.getOrDefault(candidate.name, 0) + 1);
                                voterForVote.hasVoted = true;
                                System.out.println("Vote cast successfully!");
                                break;
                            }
                        }
                    } else if (voterForVote != null && voterForVote.hasVoted) {
                        System.out.println("You have already cast your vote.");
                    } else {
                        System.out.println("Voter not found or has already voted.");
                    }
                    break;

                case 8:
                    
                    System.out.println("Registered Candidates:");
                    candidateList.forEach(System.out::println);
                    break;

                case 9:
                    
                    System.out.println("Registered Voters:");
                    voterVector.forEach(System.out::println);
                    break;

                case 10:
                    
                    System.out.println("Exiting the Online Election System. Thank you!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}