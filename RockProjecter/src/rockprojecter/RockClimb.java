package rockprojecter;

/**
 *  Parent class for different types of climb: BoulderProblem, RockRoute, etc

 * @author Marshall Ehlinger
 */
public class RockClimb {
    protected String name, area, type, grade;
    protected boolean sent;
    protected int pitches = 0; //defaults to 0, for sake of boulder problems

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getGrade() {
        return grade;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    public int getPitches() {
        //dummy superclass stub to be overridden by RockRoute.java
        System.out.println("ERROR: Superclass 'RockClimb' method 'getPitches()' called... only should be called from child subclass 'RockRoute'");
        return 0;
    }
    
    public void setPitches(int Pitches) {
        //dummy superclass stub to be overridden by RockRoute.java
        System.out.println("ERROR: Superclass 'RockClimb' method 'setPitches()' called... only should be called from child subclass 'RockRoute'");
    }
    
     @Override
    public String toString() {
        String sentStr = Boolean.toString(sent);
        if (type.equals("problem")) {
            return String.format("BOULDER    |||  NAME: %-20s|| GRADE: %-5s|| AREA: %-20s|| SENT: %-6s||", name, grade, area, sentStr);
        } else {
            return String.format("ROPED ROUTE|||  NAME: %-20s|| GRADE: %-5s|| AREA: %-20s|| SENT: %-6s|| PITCHES: %-5d||", name, grade, area, sentStr, pitches);

        }
    }
}

