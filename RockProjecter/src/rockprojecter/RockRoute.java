package rockprojecter;

/**
 *
 * @author Marshall Ehlinger
 */
public class RockRoute extends RockClimb {
        
    public RockRoute(String name, String grade, String area, boolean sent, int pitches) {
        this.name = name;
        this.grade = grade;
        this.area = area;
        this.sent = sent;
        this.pitches = pitches;
        type = "rockRoute";
    }

    @Override
    public int getPitches() {
        return pitches;
    }

    @Override
    public void setPitches(int pitches) {
        this.pitches = pitches;
    }

    
}
