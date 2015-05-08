package rockprojecter;

/**
 *
 * @author Marshall Ehlinger
 */
public class BoulderProblem extends RockClimb {
    
    public BoulderProblem(String name, String grade, String area, boolean sent) {
        this.name = name;
        this.grade = grade;
        this.area = area;
        this.sent = sent;
        type = "problem";
    } 
}
