package pt.up.fe.ldts.example6;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Tree {
    private final Date plantedAt;
    private Location location;
    private List<Date> appraisalDates;

    public Tree(Date plantedAt, String locationLatitude, String locationLongitude, String locationName) {
        this.plantedAt = plantedAt;
        this.setLocation(locationLatitude, locationLongitude, locationName);
        this.appraisalDates = new ArrayList<>();
    }

    public Date getPlantedAt() {
        return plantedAt;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(String locationLatitude, String locationLongitude, String locationName) {
        this.location = new Location(locationLatitude, locationLongitude, locationName);
    }

    public String toString() {
        return "Tree planted at " +
                this.plantedAt.toString() +
                " in location " +
                location.toString();
    }

    void addAppraisal(Date appraisalDate) {
        this.appraisalDates.add(appraisalDate);
    }

    public List<Date> getAppraisals() {
        return this.appraisalDates;
    }

    public boolean isNextAppraisalOverdue() {
        Date today = new Date();
        Date latestAppraisalDate = getLatestAppraisalDate(today);
        return getNextAppraisalDate(latestAppraisalDate).before(today);
    }

    private Date getLatestAppraisalDate(Date today) {
        Date latestAppraisalDate = today;
        if (!this.appraisalDates.isEmpty()) {
            latestAppraisalDate = this.appraisalDates.get(0);
        }
        for (Date appraisalDate : this.appraisalDates) {
            if (latestAppraisalDate.before(appraisalDate)) {
                latestAppraisalDate = appraisalDate;
            }
        }
        return latestAppraisalDate;
    }

    private static Date getNextAppraisalDate(Date latestAppraisalDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(latestAppraisalDate);
        calendar.add(Calendar.MONTH, 3);

        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            calendar.add(Calendar.DAY_OF_MONTH, 2);

        return calendar.getTime();
    }
}
