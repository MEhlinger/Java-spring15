package rockprojecter;

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
 *
 * @author Marshall Ehlinger
 */
public class ClimbPortfolio {
    protected List<RockClimb> climbs;
    private String filePath;
    
    public ClimbPortfolio() {
        this("climbs.txt");
    }
    
    public ClimbPortfolio(String filePath) {
        this.climbs = new ArrayList<>();
        this.filePath = filePath;
        try {
            Files.createFile(Paths.get(filePath));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ioe) {
            System.out.println("Create file error with " + ioe.getMessage());
        }
        readList();
    }
    
    public void createRecord(RockClimb climb) {
        climbs.add(climb);
        writeList();
    }
    
    public RockClimb retrieveRecord(String name) {
        for (RockClimb climb : climbs) {
            if (climb.getName().equalsIgnoreCase(name)) {
                return climb;
            }
        }
        return null;
    }
    
    public void updateRecord(RockClimb newClimb) {
        for (RockClimb climb : climbs) {
            if (climb.getName().equalsIgnoreCase(newClimb.getName())) {
                climbs.remove(climb);
                climbs.add(newClimb);
                writeList();
                return;
            }
        }
    }
    
    public void deleteRecord(String name) {
        for (RockClimb climb : climbs) {
            if (climb.getName().equalsIgnoreCase(name)) {
                climbs.remove(climb);
                writeList();
                return;
            }
        }
    }
    
    protected void readList() {
        // Reads in as name,type,grade,area,sent,pitches
        RockClimb climb;
        Path path = Paths.get(filePath);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                String name = data[0];
                String type = data[1];
                String area = data[3];
                boolean sent = Boolean.parseBoolean(data[4]);
                
                if (type.equals("problem")) {
                    String vGrade = data[2];
                    climb = new BoulderProblem(name, vGrade, area, sent);

                } else { //Change to else if (type.equals("rockRoute") if adding other types of climb... ice, etc
                    String ydsGrade = data[2];
                    int pitches = Integer.parseInt(data[5]);
                    climb = new RockRoute(name, ydsGrade, area, sent, pitches);
                }
                climbs.add(climb);
            }
        } catch (IOException ioe) {
            System.out.println("Read file error with " + ioe.getMessage());
        }
    }

    protected void writeList() {
        // Writes in as name;type;grade;area;sent;pitches
        Path path = Paths.get(filePath);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (RockClimb climb : climbs) {
                if (climb.getType().equals("problem")) {
                    writer.write(String.format("%s;%s;%s;%s;%s\n",
                        climb.getName(),
                        climb.getType(),
                        climb.getGrade(),
                        climb.getArea(),
                        climb.isSent()));
                } else {
                    writer.write(String.format("%s;%s;%s;%s;%s;%d\n",
                        climb.getName(),
                        climb.getType(),
                        climb.getGrade(),
                        climb.getArea(),
                        climb.isSent(),
                        climb.getPitches()));
                }
            }
        } catch (IOException ioe) {
            System.out.println("Write file error with " + ioe.getMessage());
        }
    }
    
    public void print() {
        for (RockClimb climb : climbs) {
            System.out.println(climb);
        }
    }
}
