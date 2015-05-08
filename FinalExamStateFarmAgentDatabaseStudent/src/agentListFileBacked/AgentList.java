package agentListFileBacked;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * This AgentList class represents a list of insurance agents. The list is read
 * from and saved to a text file.
 *
 * TODO #2 (complete #1 and #2 for a B grade) - complete the createRecord,
 * retrieveRecord, and two deleteRecord methods. Test using the JUnit
 * AgentListTest program. Do not make any changes to the instance variables, the
 * constructors, the toString() method, or to the JUnit tests.
 *
 * @author Marshall Ehlinger
 */
public class AgentList {

    private final String fileName;
    protected final List<Agent> myList;

    public AgentList() {
        this("agentdata.txt");
    }

    public AgentList(String fileName) {
        this.fileName = fileName;
        this.myList = new ArrayList<>();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ioe) {
            System.out.println("Create file error with " + ioe.getMessage());
        }
        readList();
    }

    public void createRecord(Agent agent) {
        myList.add(agent);
        writeList();
    }

    public Agent retrieveRecord(int id) {
        for(Agent agent : myList) {
            if (agent.getAgentId() == id) {
                return agent;
            }
        }
        return null;
    }

    public void updateRecord(Agent updatedAgent) {
        for (Agent agent : myList) {
            if (agent.getAgentId() == updatedAgent.getAgentId()) {
                agent.setLastName(updatedAgent.getLastName());
                agent.setFirstName(updatedAgent.getFirstName());
                agent.setOfficePhone(updatedAgent.getOfficePhone());
                agent.setCity(updatedAgent.getCity());
                agent.setState(updatedAgent.getState());
                agent.setNumberOfClients(updatedAgent.getNumberOfClients());
                agent.setPortfolioValue(updatedAgent.getPortfolioValue());
                break;
            }
        }
        writeList();
    }

    public void deleteRecord(int id) {
        for(Agent agent : myList) {
            if (agent.getAgentId() == id) {
                myList.remove(agent);
                writeList();
                return;
            }
        }
        System.out.println("DELETE FAILURE: Agent with id " + id + " not found.");
    }

    public void deleteRecord(Agent agent) {
        myList.remove(agent);
        writeList();
    }

    protected void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String last = data[1];
                String first = data[2];
                String officePhone = data[3];
                String city = data[4];
                String state = data[5];
                int clients = Integer.parseInt(data[6]);
                double portfolio = Double.parseDouble(data[7]);
                Agent agent = new Agent(id, last, first, officePhone, city, state, clients, portfolio);
                myList.add(agent);
            }
        } catch (IOException ioe) {
            System.out.println("Read file error with " + ioe.getMessage());
        }
    }

    protected void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Agent agent : myList) {
                writer.write(String.format("%d,%s,%s,%s,%s,%s,%d,%.2f\n",
                        agent.getAgentId(),
                        agent.getLastName(),
                        agent.getFirstName(),
                        agent.getOfficePhone(),
                        agent.getCity(),
                        agent.getState(),
                        agent.getNumberOfClients(),
                        agent.getPortfolioValue()));
            }
        } catch (IOException ioe) {
            System.out.println("Write file error with " + ioe.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        myList.stream().forEach((agent) -> {
            sb.append(String.format("%d, %s, %s, %s, %s, %s, %d, %.2f\n",
                    agent.getAgentId(), agent.getLastName(), agent.getFirstName(),
                    agent.getOfficePhone(), agent.getCity(), agent.getState(),
                    agent.getNumberOfClients(), agent.getPortfolioValue()));
        });

        return sb.toString();
    }
    
    public int calcTotalClients() {
        int count = 0;
        for (Agent agent : myList) {
            count += agent.getNumberOfClients();
        }
        return count;
    }
    
    public double calcTotalPortfolio() {
        double value = 0;
        for (Agent agent : myList) {
            value += agent.getPortfolioValue();
        }
        return value;
    }
    
    
}
